package com.data.demo61.sercive;

import com.data.demo61.entity.Course;
import com.data.demo61.repository.CourseRepository;
import com.data.demo61.repository.LessionRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService {
    @Autowired
    private CourseRepository courseRepository;



    @Override
    public List<Course> findByCourseId(int id) {
        return courseRepository.findById(id);

    }

    @Override
    public Page<Course> findByCourseName(String courseName, Pageable pageable) {
        return courseRepository.findByCourseNameContainingIgnoreCase(courseName, pageable);
    }
}
