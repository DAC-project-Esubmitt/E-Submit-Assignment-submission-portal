package com.esubmit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esubmit.entity.Submission;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission, Long> {

    List<Submission> findByStudentUsername(String studentUsername); // ✅ Ensure this method exists

    List<Submission> findByAssignmentId(Long assignmentId); // ✅ Fix: Add this method
}
