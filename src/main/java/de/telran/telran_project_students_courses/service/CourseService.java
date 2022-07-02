package de.telran.telran_project_students_courses.service;

import de.telran.telran_project_students_courses.dto.CourseRequestDTO;
import de.telran.telran_project_students_courses.dto.CourseResponseDTO;


public interface CourseService {

    void createCourse(CourseRequestDTO request);

    CourseResponseDTO getCourseById(Long id);


}
