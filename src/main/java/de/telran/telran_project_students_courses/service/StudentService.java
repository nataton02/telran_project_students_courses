package de.telran.telran_project_students_courses.service;

import de.telran.telran_project_students_courses.dto.StudentRequestDTO;
import de.telran.telran_project_students_courses.dto.StudentResponseDTO;

import java.util.List;

public interface StudentService {

    void createStudent(StudentRequestDTO request);

    List<StudentResponseDTO> getAllStudents();

    StudentResponseDTO getStudentById(Long id);

}
