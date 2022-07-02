package de.telran.telran_project_students_courses.controller;

import de.telran.telran_project_students_courses.dto.StudentCourseRequestDTO;
import de.telran.telran_project_students_courses.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentCourseController {

    @Autowired
    private StudentCourseService studentCourseService;

    @PutMapping("/api/students_courses/")
    public void create(@RequestBody StudentCourseRequestDTO request) {
        studentCourseService.registerStudentOnCourse(request);
    }


}
