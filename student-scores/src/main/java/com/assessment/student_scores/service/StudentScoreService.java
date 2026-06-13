package com.assessment.student_scores.service;

import com.assessment.student_scores.dto.response.StudentReportResponse;
import com.assessment.student_scores.dto.request.StudentScoreRequest;
import com.assessment.student_scores.model.Score;
import com.assessment.student_scores.model.Student;
import com.assessment.student_scores.model.Subject;
import com.assessment.student_scores.repository.ScoreRepository;
import com.assessment.student_scores.repository.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class StudentScoreService {

    private final StudentRepository studentRepository;
    private final ScoreRepository scoreRepository;

    public StudentScoreService(StudentRepository studentRepository, ScoreRepository scoreRepository) {
        this.studentRepository = studentRepository;
        this.scoreRepository = scoreRepository;
    }


    public Long saveStudentScores(StudentScoreRequest request) {
        Student student = new Student();
        student.setName(request.getStudentName());
        Student savedStudent = studentRepository.save(student);

        for (Map.Entry<Subject, Integer> entry : request.getScores().entrySet()) {
            Score score = new Score();
            score.setStudent(savedStudent);
            score.setSubject(entry.getKey());
            score.setScoreValue(entry.getValue());
            scoreRepository.save(score);
        }

        return savedStudent.getId();
    }


    public Page<StudentReportResponse> buildReport(Pageable pageable, String nameFilter) {
        List<Student> allStudents = studentRepository.findAll();

        List<Student> filteredStudents = new ArrayList<>();
        for (Student student : allStudents) {
            boolean matchesFilter = nameFilter == null
                || nameFilter.isBlank()
                || student.getName().toLowerCase().contains(nameFilter.toLowerCase());

            if (matchesFilter) {
                filteredStudents.add(student);
            }
        }

        List<StudentReportResponse> allReportRows = new ArrayList<>();
        for (Student student : filteredStudents) {
            allReportRows.add(buildReportForStudent(student));
        }

        int start = (int) pageable.getOffset();
        int end = Math.min(start + pageable.getPageSize(), allReportRows.size());

        List<StudentReportResponse> pageContent;
        if (start > allReportRows.size()) {
            pageContent = new ArrayList<>();
        } else {
            pageContent = allReportRows.subList(start, end);
        }

        return new PageImpl<>(pageContent, pageable, allReportRows.size());
    }

    private StudentReportResponse buildReportForStudent(Student student) {
        List<Score> scores = scoreRepository.findByStudentId(student.getId());

        Map<Subject, Integer> scoreMap = new HashMap<>();
        List<Integer> scoreValues = new ArrayList<>();
        for (Score score : scores) {
            scoreMap.put(score.getSubject(), score.getScoreValue());
            scoreValues.add(score.getScoreValue());
        }

        double mean = calculateMean(scoreValues);
        double median = calculateMedian(scoreValues);
        List<Integer> mode = calculateMode(scoreValues);

        return new StudentReportResponse(
            student.getId(),
            student.getName(),
            scoreMap,
            mean,
            median,
            mode
        );
    }


    public double calculateMean(List<Integer> values) {
        if (values.isEmpty()) {
            return 0.0;
        }

        int sum = 0;
        for (int value : values) {
            sum += value;
        }

        return (double) sum / values.size();
    }


    public double calculateMedian(List<Integer> values) {
        if (values.isEmpty()) {
            return 0.0;
        }

        List<Integer> sortedValues = new ArrayList<>(values);
        sortedValues.sort(Integer::compareTo);

        int size = sortedValues.size();
        int middleIndex = size / 2;

        if (size % 2 == 1) {
            return sortedValues.get(middleIndex);
        } else {
            int lowerMiddle = sortedValues.get(middleIndex - 1);
            int upperMiddle = sortedValues.get(middleIndex);
            return (lowerMiddle + upperMiddle) / 2.0;
        }
    }


    public List<Integer> calculateMode(List<Integer> values) {
        if (values.isEmpty()) {
            return new ArrayList<>();
        }

        Map<Integer, Integer> frequencyByValue = new HashMap<>();
        for (int value : values) {
            frequencyByValue.merge(value, 1, Integer::sum);
        }

        int highestFrequency = 0;
        for (int frequency : frequencyByValue.values()) {
            if (frequency > highestFrequency) {
                highestFrequency = frequency;
            }
        }

        List<Integer> modeValues = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequencyByValue.entrySet()) {
            if (entry.getValue() == highestFrequency) {
                modeValues.add(entry.getKey());
            }
        }

        modeValues.sort(Integer::compareTo);
        return modeValues;
    }
}