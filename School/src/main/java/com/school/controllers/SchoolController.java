package com.school.controllers;

import com.school.dtos.SchoolDto;
import com.school.entities.School;
import com.school.reponses.SchoolStudentResponse;
import com.school.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/school")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    @GetMapping("/get")
    public ResponseEntity<List<School>> getAllSchools() {
        List<School> allSchools = schoolService.getAllSchools();
        return new ResponseEntity<>(allSchools, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<School> createSchool(@RequestBody SchoolDto schoolDto) {
        School school = schoolService.createSchool(schoolDto);
        return new ResponseEntity<>(school, HttpStatus.CREATED);
    }

    @GetMapping("/students/{school_id}")
    public ResponseEntity<SchoolStudentResponse> getAllStudentsBySchoolId(@PathVariable Integer school_id) {
        SchoolStudentResponse allStudentsBySchoolId = schoolService.getAllStudentsBySchoolId(school_id);
        return new ResponseEntity<>(allStudentsBySchoolId, HttpStatus.OK);
    }
}
