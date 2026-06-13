package com.assessment.student_scores.dto.response;

import com.assessment.student_scores.model.Subject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;


@Getter
@Setter
@AllArgsConstructor
public class StudentReportResponse {

    private Long studentId;
    private String studentName;
    private Map<Subject, Integer> scores;
    private double mean;
    private double median;
    private List<Integer> mode;
}