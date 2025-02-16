package com.esubmit.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.esubmit.entity.Course;
import com.esubmit.repository.CourseRepository;

@Service
public class CourseService {
    
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    // ✅ Save Course
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    // ✅ Get All Courses
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // ✅ Get Course by ID
    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found"));
    }

    // ✅ Update Course
    public Course updateCourse(Long id, Course course) {
        if (!courseRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found");
        }
        course.setId(id);
        return courseRepository.save(course);
    }

    // ✅ Delete Course
    public void deleteCourse(Long id) {
        if (!courseRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found");
        }
        courseRepository.deleteById(id);
    }
}
