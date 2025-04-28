package com.personalblog.personalblog.controller;

import com.personalblog.personalblog.model.Theme;
import com.personalblog.personalblog.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/theme")
@CrossOrigin(origins = "*", allowedHeaders = "")
public class ThemeController {

    @Autowired
    private ThemeRepository themeRepository;

    @GetMapping
    public ResponseEntity<List<Theme>> getAll(){
        return ResponseEntity.ok(themeRepository.findAll());
    }

}
