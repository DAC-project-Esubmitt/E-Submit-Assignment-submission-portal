package com.esubmit.service;

import java.util.List;

import com.esubmit.entity.Submission;

public interface SubmissionService {
    Submission submitAssignment(Submission submission);
    List<Submission> getAllSubmissions();
    List<Submission> getSubmissionsByStudent(String studentUsername);
    List<Submission> getSubmissionsByAssignment(Long assignmentId);
    void deleteSubmission(Long id);
    
    // New method to update a submission
    Submission updateSubmission(Long id, Submission submission);
}
