package de.telran.telran_project_students_courses.service;

import de.telran.telran_project_students_courses.dto.StudentCourseRequestDTO;

public interface StudentCourseService {

    void registerStudentOnCourse(StudentCourseRequestDTO request);
}
