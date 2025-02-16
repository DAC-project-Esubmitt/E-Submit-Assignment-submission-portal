package com.esubmit.service;

import java.util.List;

import com.esubmit.entity.Assignment;

public interface AssignmentService {
    Assignment saveAssignment(Assignment assignment);
    List<Assignment> getAllAssignments();
    Assignment getAssignmentById(Long id);
    Assignment updateAssignment(Long id, Assignment assignment);
    void deleteAssignment(Long id);
}
