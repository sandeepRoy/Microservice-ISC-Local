package com.school.services;

import com.netflix.discovery.converters.Auto;
import com.school.client.StudentClient;
import com.school.dtos.SchoolDto;
import com.school.entities.School;
import com.school.reponses.SchoolStudentResponse;
import com.school.reponses.Student;
import com.school.repositories.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;

    private final StudentClient studentClient;

    public List<School> getAllSchools() {
        List<School> all = schoolRepository.findAll();
        return all;
    }

    public School createSchool(SchoolDto schoolDto) {
        School school = new School();
        school.setName(schoolDto.getName());
        school.setCity(schoolDto.getCity());

        School created = schoolRepository.save(school);
        return created;
    }

    public SchoolStudentResponse getAllStudentsBySchoolId(Integer schoolId) {
        System.out.println("getAllStudentsBySchoolId() called!");
        School school = schoolRepository.findById(schoolId).orElseThrow(() -> new RuntimeException("School Not Found!"));
        List<Student> allStudentsBySchoolId = studentClient.getAllStudentsBySchoolId(schoolId);

        System.out.println("42: " + allStudentsBySchoolId.toString());
        SchoolStudentResponse schoolStudentResponse = new SchoolStudentResponse();
        schoolStudentResponse.setName(school.getName());
        schoolStudentResponse.setCity(school.getCity());
        schoolStudentResponse.setStudentList(allStudentsBySchoolId);

        return schoolStudentResponse;
    }
}
