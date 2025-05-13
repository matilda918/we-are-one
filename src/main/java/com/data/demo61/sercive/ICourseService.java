package com.data.demo61.sercive;

import com.data.demo61.entity.Course;
import com.data.demo61.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ICourseService {
    List<Course> findByCourseId(int courseId);
    Page<Course> findByCourseName(String courseName, Pageable pageable);

}
