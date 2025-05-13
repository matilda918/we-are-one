package com.data.demo61.repository;

import com.data.demo61.entity.Course;
import com.data.demo61.entity.Lession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface LessionRepositoy extends JpaRepository<Lession, Integer> {
    List<Lession> findById(int id);
}

