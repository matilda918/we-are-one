package com.data.demo61.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "courses")
@Data

public class Course {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;
    private String courseName;
    private int soBuoi;
    private int soGio;
    private String moTaKhoaHoc;

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Lession> lessions;



    public Course() {
    }

    public Course(int id, String courseName, int soBuoi, int soGio,String moTaKhoaHoc) {
        this.id = id;
        this.courseName = courseName;
        this.soBuoi = soBuoi;
        this.soGio = soGio;
        this.moTaKhoaHoc=moTaKhoaHoc;

    }
}
