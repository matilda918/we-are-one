package com.data.demo61.entity;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "lessions")


public class Lession {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;
    private String lessionName;
    private int soGio;
    private String moTaLession;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    public Lession() {
    }



}
