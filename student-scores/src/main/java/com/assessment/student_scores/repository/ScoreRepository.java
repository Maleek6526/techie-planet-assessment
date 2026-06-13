package com.assessment.student_scores.repository;

import com.assessment.student_scores.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {

    List<Score> findByStudentId(Long studentId);
}