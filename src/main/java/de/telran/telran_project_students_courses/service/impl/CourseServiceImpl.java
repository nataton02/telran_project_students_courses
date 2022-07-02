package de.telran.telran_project_students_courses.service.impl;

import de.telran.telran_project_students_courses.dto.CourseRequestDTO;
import de.telran.telran_project_students_courses.dto.CourseResponseDTO;
import de.telran.telran_project_students_courses.entity.Course;
import de.telran.telran_project_students_courses.repository.CourseRepository;
import de.telran.telran_project_students_courses.repository.StudentCourseRepository;
import de.telran.telran_project_students_courses.repository.StudentRepository;
import de.telran.telran_project_students_courses.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentCourseRepository studentCourseRepository;

    @Override
    public void createCourse(CourseRequestDTO request) {
        Course course = Course.builder()
                .courseName(request.getCourseName())
                .build();
        courseRepository.save(course);
    }

    @Override
    public CourseResponseDTO getCourseById(Long id) {
        Long countOfStudents = studentCourseRepository.countAllByCourseId(id);

        Course course = courseRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                String.format("Course with id %s does not exist", id)));

        return CourseResponseDTO.builder()
                .courseName(course.getCourseName())
                .studentsCount(countOfStudents)
                .build();
    }


}
