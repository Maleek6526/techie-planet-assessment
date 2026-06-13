package com.assessment.student_scores.controller;

import com.assessment.student_scores.dto.response.StudentReportResponse;
import com.assessment.student_scores.dto.request.StudentScoreRequest;
import com.assessment.student_scores.service.StudentScoreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/scores")
@Tag(name = "Student Scores", description = "Submit scores and view reports")
public class StudentScoreController {

    private final StudentScoreService studentScoreService;

    public StudentScoreController(StudentScoreService studentScoreService) {
        this.studentScoreService = studentScoreService;
    }

    @PostMapping
    @Operation(summary = "Submit a student's scores for all subjects")
    public ResponseEntity<Long> submitScores(@Valid @RequestBody StudentScoreRequest request) {
        Long studentId = studentScoreService.saveStudentScores(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(studentId);
    }


    @GetMapping("/report")
    @Operation(summary = "Get a paginated report of all students with mean, median, and mode")
    public ResponseEntity<Page<StudentReportResponse>> getReport(
            @Parameter(description = "Page number, starting from 0")
            @RequestParam(defaultValue = "0") int page,

            @Parameter(description = "Number of students per page")
            @RequestParam(defaultValue = "10") int size,

            @Parameter(description = "Only include students whose name contains this text")
            @RequestParam(required = false) String nameFilter
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<StudentReportResponse> report = studentScoreService.buildReport(pageable, nameFilter);
        return ResponseEntity.ok(report);
    }
}