package com.assessment.student_scores.dto.request;

import com.assessment.student_scores.model.Subject;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;


@Getter
@Setter
public class StudentScoreRequest {

    @NotBlank(message = "Student name must not be blank")
    private String studentName;

    @NotNull(message = "Scores must not be null")
    private Map<Subject, @Min(value = 0, message = "Score must be at least 0")
                          @Max(value = 100, message = "Score must be at most 100") Integer> scores;
}