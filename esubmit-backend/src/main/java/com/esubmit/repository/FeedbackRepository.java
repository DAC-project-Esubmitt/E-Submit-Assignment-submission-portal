package com.esubmit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esubmit.entity.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    List<Feedback> findBySubmissionId(Long submissionId);
}

