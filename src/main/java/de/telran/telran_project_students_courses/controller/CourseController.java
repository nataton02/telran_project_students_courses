package de.telran.telran_project_students_courses.controller;

import de.telran.telran_project_students_courses.dto.CourseRequestDTO;
import de.telran.telran_project_students_courses.dto.CourseResponseDTO;
import de.telran.telran_project_students_courses.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/api/courses")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCourse(@RequestBody CourseRequestDTO request) {
        courseService.createCourse(request);
    }

    @GetMapping("/api/courses/{id}")
    public CourseResponseDTO readCourseById(@PathVariable("id") Long id) {
        return courseService.getCourseById(id);
    }
}
