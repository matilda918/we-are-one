package com.data.demo61.request;

import lombok.Data;

@Data

public class CoursesCreateRequest {
    private String courseName;
    private int soBuoi;
    private int soGio;
    private String moTaKhoaHoc;

    public CoursesCreateRequest() {
    }
    public CoursesCreateRequest(String courseName, int soBuoi, int soGio,String moTaKhoaHoc) {
        this.courseName = courseName;
        this.soBuoi = soBuoi;
        this.soGio = soGio;
        this.moTaKhoaHoc=moTaKhoaHoc;
    }
}
