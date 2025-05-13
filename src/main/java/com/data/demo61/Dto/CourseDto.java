package com.data.demo61.Dto;

import com.data.demo61.entity.Lession;
import lombok.Data;

import java.util.List;

@Data

public class CourseDto {
    private int id;
    private String courseName;
    private int soBuoi;
    private int soGio;

    List<LessionDto> lessions;


}
