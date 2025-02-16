package com.esubmit.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "submissions")
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studentUsername;
    private String assignmentTitle;
    private String submissionText;
    private LocalDateTime submissionDate;
    private String status; // e.g., "Pending", "Reviewed", "Approved"
    
    private Long assignmentId; // ✅ Added assignmentId

    public Submission() {
    }

    public Submission(String studentUsername, String assignmentTitle, String submissionText, LocalDateTime submissionDate, String status, Long assignmentId) {
        this.studentUsername = studentUsername;
        this.assignmentTitle = assignmentTitle;
        this.submissionText = submissionText;
        this.submissionDate = submissionDate;
        this.status = status;
        this.assignmentId = assignmentId; // ✅ Initialize in constructor
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentUsername() {
        return studentUsername;
    }

    public void setStudentUsername(String studentUsername) {
        this.studentUsername = studentUsername;
    }

    public String getAssignmentTitle() {
        return assignmentTitle;
    }

    public void setAssignmentTitle(String assignmentTitle) {
        this.assignmentTitle = assignmentTitle;
    }

    public String getSubmissionText() {
        return submissionText;
    }

    public void setSubmissionText(String submissionText) {
        this.submissionText = submissionText;
    }

    public LocalDateTime getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(LocalDateTime submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getAssignmentId() { // ✅ Getter
        return assignmentId;
    }

    public void setAssignmentId(Long assignmentId) { // ✅ Setter
        this.assignmentId = assignmentId;
    }
}
