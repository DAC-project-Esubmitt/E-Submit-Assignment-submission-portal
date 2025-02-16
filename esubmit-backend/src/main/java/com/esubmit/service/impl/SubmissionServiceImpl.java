package com.esubmit.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.esubmit.entity.Submission;
import com.esubmit.repository.SubmissionRepository;
import com.esubmit.service.SubmissionService;

@Service
public class SubmissionServiceImpl implements SubmissionService {

    private final SubmissionRepository submissionRepository;

    public SubmissionServiceImpl(SubmissionRepository submissionRepository) {
        this.submissionRepository = submissionRepository;
    }

    @Override
    public Submission submitAssignment(Submission submission) {
        return submissionRepository.save(submission);
    }

    @Override
    public List<Submission> getAllSubmissions() {
        return submissionRepository.findAll();
    }

    @Override
    public List<Submission> getSubmissionsByStudent(String studentUsername) {
        return submissionRepository.findByStudentUsername(studentUsername);
    }

    @Override
    public List<Submission> getSubmissionsByAssignment(Long assignmentId) {
        return submissionRepository.findByAssignmentId(assignmentId);
    }

    @Override
    public void deleteSubmission(Long id) {
        submissionRepository.deleteById(id);
    }

    @Override
    public Submission updateSubmission(Long id, Submission submissionDetails) {
        Submission submission = submissionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Submission not found with ID: " + id));

        // Update fields
        submission.setAssignmentId(submissionDetails.getAssignmentId());
        submission.setStudentUsername(submissionDetails.getStudentUsername());
        submission.setSubmissionDate(submissionDetails.getSubmissionDate());

        return submissionRepository.save(submission);
    }
}
