package com.data.demo61.request;

import lombok.Data;

@Data

public class CoursesCreateRequest {
    private String courseName;
    private int soBuoi;
    private int soGio;

    public CoursesCreateRequest() {
    }
    public CoursesCreateRequest(String courseName, int soBuoi, int soGio) {
        this.courseName = courseName;
        this.soBuoi = soBuoi;
        this.soGio = soGio;
    }
}
