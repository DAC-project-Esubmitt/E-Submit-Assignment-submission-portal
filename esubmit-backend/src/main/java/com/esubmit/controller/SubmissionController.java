package com.esubmit.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esubmit.entity.Submission;
import com.esubmit.service.SubmissionService;

@RestController
@RequestMapping("/submissions")
public class SubmissionController {

    private final SubmissionService submissionService;

    public SubmissionController(SubmissionService submissionService) {
        this.submissionService = submissionService;
    }

    // ✅ Submit an assignment
    @PostMapping("/submit")
    public ResponseEntity<Submission> submitAssignment(@RequestBody Submission submission) {
        Submission savedSubmission = submissionService.submitAssignment(submission);
        return ResponseEntity.ok(savedSubmission);
    }

    // ✅ Get all submissions
    @GetMapping("/all")
    public ResponseEntity<List<Submission>> getAllSubmissions() {
        List<Submission> submissions = submissionService.getAllSubmissions();
        return ResponseEntity.ok(submissions);
    }

    // ✅ Get submissions by student username
    @GetMapping("/student/{studentUsername}")
    public ResponseEntity<List<Submission>> getSubmissionsByStudent(@PathVariable String studentUsername) {
        List<Submission> submissions = submissionService.getSubmissionsByStudent(studentUsername);
        return ResponseEntity.ok(submissions);
    }

    // ✅ Get submissions by assignment ID
    @GetMapping("/assignment/{assignmentId}")
    public ResponseEntity<List<Submission>> getSubmissionsByAssignment(@PathVariable Long assignmentId) {
        List<Submission> submissions = submissionService.getSubmissionsByAssignment(assignmentId);
        return ResponseEntity.ok(submissions);
    }

    // ✅ Update a submission
    @PutMapping("/update/{id}")
    public ResponseEntity<Submission> updateSubmission(@PathVariable Long id, @RequestBody Submission submissionDetails) {
        Submission updatedSubmission = submissionService.updateSubmission(id, submissionDetails);
        return ResponseEntity.ok(updatedSubmission);
    }

    // ✅ Delete a submission
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSubmission(@PathVariable Long id) {
        submissionService.deleteSubmission(id);
        return ResponseEntity.ok("Submission deleted successfully");
    }
}
