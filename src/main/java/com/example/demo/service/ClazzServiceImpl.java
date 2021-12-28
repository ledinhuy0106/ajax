package com.example.demo.service;

import com.example.demo.model.Clazz;
import com.example.demo.repository.ClassRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClazzServiceImpl implements ClazzService {
    @Autowired
    private ClassRepository classRepository;

    @Override
    public Iterable<Clazz> findAll() {
        return classRepository.findAll();
    }

    @Override
    public Optional<Clazz> findById(Long id) {
        return classRepository.findById(id);
    }

    @Override
    public void save(Clazz clazz) {
        classRepository.save(clazz);
    }

    @Override
    public void remove(Long id) {
        classRepository.deleteById(id);
    }
}
