package de.telran.telran_project_students_courses.service.impl;

import de.telran.telran_project_students_courses.dto.StudentCourseRequestDTO;
import de.telran.telran_project_students_courses.entity.StudentCourse;
import de.telran.telran_project_students_courses.repository.StudentCourseRepository;
import de.telran.telran_project_students_courses.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class StudentCourseServiceImpl implements StudentCourseService {

    @Autowired
    private StudentCourseRepository studentCourseRepository;


    @Override
    public void registerStudentOnCourse(StudentCourseRequestDTO request) {
        if(studentCourseRepository.findByStudentIdAndCourseId(request.getStudentId(), request.getCourseId()) != null) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    String.format("The student with id %s already attending the course with id %s",
                            request.getStudentId(), request.getCourseId()));
        }

        StudentCourse studentCourse = StudentCourse.builder()
                .studentId(request.getStudentId())
                .courseId(request.getCourseId())
                .build();

        studentCourseRepository.save(studentCourse);
    }





}
