package com.data.demo61.sercive;

import com.data.demo61.entity.Course;
import com.data.demo61.entity.Lession;

import java.util.List;

public interface ILessionService {
    List<Lession> findById(int id);
}
