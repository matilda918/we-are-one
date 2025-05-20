package com.data.demo61.service;

import com.data.demo61.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ICourseService {
    List<Course> findByCourseId(int courseId);
    Page<Course> findByCourseName(String courseName, Pageable pageable);
    boolean existsByCourseName(String courseName);

}
