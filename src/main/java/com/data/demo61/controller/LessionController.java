package com.data.demo61.controller;

import com.data.demo61.Dto.LessionDto;
import com.data.demo61.entity.Course;
import com.data.demo61.entity.Lession;
import com.data.demo61.repository.LessionRepositoy;
import com.data.demo61.request.LessionReques;
import com.data.demo61.sercive.ILessionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.data.demo61.repository.CourseRepository;

@RestController

public class LessionController {
    private LessionRepositoy lessionRepositoy;
    private ILessionService iLessionService;
   private CourseRepository courseRepository;


    public LessionController(LessionRepositoy lessionRepositoy, ILessionService iLessionService,
                             CourseRepository courseRepository) {
        this.lessionRepositoy = lessionRepositoy;
        this.iLessionService = iLessionService;
        this.courseRepository = courseRepository;
    }


    @GetMapping("lession/{id}")
    public ResponseEntity<?> showLession(@PathVariable Integer id) {
        List<Lession> lession = iLessionService.findById(id);
        List<LessionDto> lessionDtos = new ArrayList<>();
        lession.forEach(lession1 -> {
            LessionDto lessionDto = new LessionDto();
            lessionDto.setId(lession1.getId());
            lessionDto.setLessionName(lession1.getLessionName());
            lessionDto.setSoGio(lession1.getSoGio());
            lessionDto.setMoTaLession(lession1.getMoTaLession());
            lessionDtos.add(lessionDto);
        });
        return ResponseEntity.ok(lessionDtos);

    }

    @DeleteMapping("lession/{id}")
    public ResponseEntity<?> deleteLession(@PathVariable Integer id) {
        Optional<Lession> lessionOptional = lessionRepositoy.findById(id);
        if (lessionOptional.isEmpty()) {
            return ResponseEntity.ok("Không tìm thấy bài học có id:"+id);
        }
        Lession lession = lessionOptional.get();
        lessionRepositoy.delete(lession);

        return ResponseEntity.ok("Xóa bài học thành công");
    }
    @PutMapping("lession/{id}")
    public ResponseEntity<?> updateLession(@PathVariable Integer id, @RequestBody LessionReques lessionReques) {
        if(lessionReques.getLessionName() == null || lessionReques.getSoGio() == null || lessionReques.getMoTaLession() == null) {
            return ResponseEntity.ok("Không được để trống");
        }
        Optional<Lession> lessionOptional = lessionRepositoy.findById(id);
        if (lessionOptional.isEmpty()) {
            return ResponseEntity.ok("Không tìm thấy bài học có id:"+id);
        }
        Lession lession = lessionOptional.get();
        lession.setLessionName(lessionReques.getLessionName());
        lession.setSoGio(lessionReques.getSoGio());
        lession.setMoTaLession(lessionReques.getMoTaLession());
        lessionRepositoy.save(lession);
        return ResponseEntity.ok("Cập nhật bài học thành công");
    }
    @PostMapping("course/{id}/lessons")
    public ResponseEntity<?> addLessonToCourse(@PathVariable Integer id, @RequestBody LessionReques request) {
        Optional<Course> optionalCourse = courseRepository.findById(id);
        if (optionalCourse.isEmpty()) {
            return ResponseEntity.badRequest().body("Không tìm thấy khóa học có ID = " + id);
        }
        Course course = optionalCourse.get();
        Lession lesson = new Lession();
        lesson.setLessionName(request.getLessionName());
        lesson.setSoGio(request.getSoGio());
        lesson.setMoTaLession(request.getMoTaLession());
        lesson.setCourse(course);

         lessionRepositoy.save(lesson);

        return ResponseEntity.ok("Thêm bài học thành công vào khóa học: " + course.getCourseName());


}}
