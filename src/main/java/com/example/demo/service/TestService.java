package com.example.demo.service;

import com.example.demo.entity.TestEntity;
import com.example.demo.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;

    public void create(TestEntity testEntity) {
        testRepository.save(testEntity);
    }

    public void update(TestEntity testEntity) {
        testRepository.save(testEntity);
    }

    public void delete(long id) {
        testRepository.deleteById(id);
    }

    public List<TestEntity> find() {
        return testRepository.findAll();
    }

    public TestEntity find(long id) {
        return testRepository.getOne(id);
    }

}
