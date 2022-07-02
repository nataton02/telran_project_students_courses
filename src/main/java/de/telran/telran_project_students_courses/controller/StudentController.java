package de.telran.telran_project_students_courses.controller;

import de.telran.telran_project_students_courses.dto.StudentRequestDTO;
import de.telran.telran_project_students_courses.dto.StudentResponseDTO;
import de.telran.telran_project_students_courses.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/api/students")
    @ResponseStatus(HttpStatus.CREATED)
    public void createStudent(@RequestBody StudentRequestDTO request) {
        studentService.createStudent(request);
    }

    @GetMapping("/api/students")
    public List<StudentResponseDTO> readAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/api/students/{id}")
    public StudentResponseDTO readStudentById(@PathVariable("id") Long id) {
        return studentService.getStudentById(id);
    }

}
