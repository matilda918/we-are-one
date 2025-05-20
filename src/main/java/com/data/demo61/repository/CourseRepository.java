package com.data.demo61.repository;

import com.data.demo61.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    List<Course> findById(int id);
    Page<Course> findByCourseNameContainingIgnoreCase(String courseName, Pageable pageable);
    boolean existsByCourseName(String courseName);
}


