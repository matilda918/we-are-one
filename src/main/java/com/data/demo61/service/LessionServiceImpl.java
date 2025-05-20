package com.data.demo61.service;

import com.data.demo61.entity.Lession;
import com.data.demo61.repository.CourseRepository;
import com.data.demo61.repository.LessionRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class LessionServiceImpl implements ILessionService{
    @Autowired
    private LessionRepositoy lessionRepositoy;
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Lession> findById(int id) {
        return lessionRepositoy.findById(id);
    }

    @Override
    public boolean existsByLessionName(String lessionName) {
        return lessionRepositoy.existsByLessionName(lessionName);
    }
}
