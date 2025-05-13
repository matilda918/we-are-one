package com.data.demo61.controller;

import com.data.demo61.Dto.CourseDto;
import com.data.demo61.Dto.LessionDto;
import com.data.demo61.entity.Course;
import com.data.demo61.entity.Lession;
import com.data.demo61.repository.CourseRepository;
import com.data.demo61.request.CoursesCreateRequest;
import com.data.demo61.request.LessionReques;
import com.data.demo61.sercive.CourseServiceImpl;
import com.data.demo61.sercive.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;
    private ICourseService courseService;

    public CourseController(CourseRepository courseRepository, ICourseService courseService) {
        this.courseRepository = courseRepository;
        this.courseService = courseService;
    }

    @GetMapping("courses")
    public ResponseEntity<?> getAllCourse(Pageable pageable) {
        Page<Course> courses = courseRepository.findAll(pageable);
        List<CourseDto> courseDtos = new ArrayList<>();
        courses.forEach(course -> {
            CourseDto courseDto = new CourseDto();
            courseDto.setId(course.getId());
            courseDto.setCourseName(course.getCourseName());
            courseDto.setSoBuoi(course.getSoBuoi());
            courseDto.setSoGio(course.getSoGio());

            courseDtos.add(courseDto);

        });

        Page<CourseDto> dtoPage = new PageImpl<>(courseDtos, pageable, courses.getTotalElements());
        return ResponseEntity.ok(dtoPage);

    }

    @GetMapping("courses/{id}")

    public ResponseEntity<?> getCourseById(@PathVariable Integer id) {
        List<Course> courses = courseService.findByCourseId(id);
        List<CourseDto> courseDtos = new ArrayList<>();
        courses.forEach(course -> {
            CourseDto courseDto = new CourseDto();
            courseDto.setId(course.getId());
            courseDto.setCourseName(course.getCourseName());
            courseDto.setSoBuoi(course.getSoBuoi());
            courseDto.setSoGio(course.getSoGio());

            List<LessionDto> lessionDtos = new ArrayList<>();
            List<Lession> lessionList = course.getLessions();
            lessionList.forEach(lession -> {
                LessionDto lessionDto = new LessionDto();
                lessionDto.setId(lession.getId());
                lessionDto.setLessionName(lession.getLessionName());
                lessionDtos.add(lessionDto);
            });
            courseDto.setLessions(lessionDtos);

            courseDtos.add(courseDto);

        });
        return ResponseEntity.ok(courseDtos);

    }

    @PostMapping("courses")
    public ResponseEntity<?> createCourse(@RequestBody CoursesCreateRequest coursesCreateRequest) {
        if (coursesCreateRequest.getCourseName() == null || coursesCreateRequest.getCourseName().isEmpty()) {
            return ResponseEntity.badRequest().body("Tên khoá học không được để trống");
        } else if (coursesCreateRequest.getSoBuoi() <= 0) {
            return ResponseEntity.badRequest().body("Số buổi không được để trống");
        } else if (coursesCreateRequest.getSoGio() <= 0) {
            return ResponseEntity.badRequest().body("Số giờ không được để trống");
        }

        Course course = new Course();
        course.setCourseName(coursesCreateRequest.getCourseName());
        course.setSoBuoi(coursesCreateRequest.getSoBuoi());
        course.setSoGio(coursesCreateRequest.getSoGio());
        courseRepository.save(course);
        return ResponseEntity.ok("Thêm khoá học thành công");
    }

    @PutMapping("courses/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable Integer id, @RequestBody CoursesCreateRequest coursesCreateRequest) {
        if (coursesCreateRequest.getCourseName() == null || coursesCreateRequest.getCourseName().isEmpty()) {
            return ResponseEntity.badRequest().body("Tên khoá học không được để trống");
        } else if (coursesCreateRequest.getSoBuoi() <= 0) {
            return ResponseEntity.badRequest().body("Số buổi không được để trống");
        } else if (coursesCreateRequest.getSoGio() <= 0) {
            return ResponseEntity.badRequest().body("Số giờ không được để trống");
        }
        Optional<Course> courseOptional = courseRepository.findById(id);
        if (courseOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("Khoá học không tồn tại");
        }
        Course course = courseOptional.get();
        course.setCourseName(coursesCreateRequest.getCourseName());
        course.setSoBuoi(coursesCreateRequest.getSoBuoi());
        course.setSoGio(coursesCreateRequest.getSoGio());
        courseRepository.save(course);
        return ResponseEntity.ok("Cập nhật khoá học thành công");

    }

    @DeleteMapping("courses/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Integer id) {
        Optional<Course> courseOptional = courseRepository.findById(id);
        if (courseOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("Khoá học không tồn tại");
        }
        Course course = courseOptional.get();
        courseRepository.delete(course);
        return ResponseEntity.ok("Xoá khoá học thành công");
    }

    @GetMapping("courses/search")
    public ResponseEntity<?> searchCourse(@RequestParam String courseName, Pageable pageable) {
        Page<Course> courses = courseService.findByCourseName(courseName, pageable);
        List<CourseDto> courseDtos = new ArrayList<>();
        courses.forEach(course -> {
            CourseDto courseDto = new CourseDto();
            courseDto.setId(course.getId());
            courseDto.setCourseName(course.getCourseName());
            courseDto.setSoBuoi(course.getSoBuoi());
            courseDto.setSoGio(course.getSoGio());

            courseDtos.add(courseDto);

        });

        Page<CourseDto> dtoPage = new PageImpl<>(courseDtos, pageable, courses.getTotalElements());
        return ResponseEntity.ok(dtoPage);
    }



}



