package com.data.demo61.service;

import com.data.demo61.entity.Lession;

import java.util.List;

public interface ILessionService {
    List<Lession> findById(int id);
    boolean existsByLessionName(String lessionName);
}
