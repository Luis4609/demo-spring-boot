package com.example.demo.service;

import com.example.demo.repository.DemoRepository;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    private final DemoRepository demoRepository;

    public DemoService(DemoRepository demoRepository) {
        this.demoRepository = demoRepository;
    }
}
