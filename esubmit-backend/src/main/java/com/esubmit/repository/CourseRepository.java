package com.esubmit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esubmit.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
