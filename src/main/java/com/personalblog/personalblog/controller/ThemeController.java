package com.personalblog.personalblog.controller;

import com.personalblog.personalblog.model.Theme;
import com.personalblog.personalblog.repository.ThemeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<Theme> getById(@PathVariable Long id){
        return themeRepository.findById(id)
                .map(response -> ResponseEntity.ok(response))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/description/{description}")
    public ResponseEntity<List<Theme>> getByDescription(@PathVariable String description){
        return ResponseEntity.ok(themeRepository
                .findAllByDescriptionContainingIgnoreCase(description));
    }

    @PostMapping
    public ResponseEntity<Theme> createTheme(@Valid @RequestBody Theme theme){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(themeRepository.save(theme));
    }

    @PutMapping
    public ResponseEntity<Theme> updateTheme(@Valid @RequestBody Theme theme){
        return themeRepository.findById(theme.getId())
                .map(response -> ResponseEntity.status(HttpStatus.CREATED)
                        .body(themeRepository.save(theme)))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }


}
