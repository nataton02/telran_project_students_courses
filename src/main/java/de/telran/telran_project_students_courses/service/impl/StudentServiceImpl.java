package de.telran.telran_project_students_courses.service.impl;

import de.telran.telran_project_students_courses.dto.CourseRequestDTO;
import de.telran.telran_project_students_courses.dto.StudentRequestDTO;
import de.telran.telran_project_students_courses.dto.StudentResponseDTO;
import de.telran.telran_project_students_courses.entity.Course;
import de.telran.telran_project_students_courses.entity.Student;
import de.telran.telran_project_students_courses.entity.StudentCourse;
import de.telran.telran_project_students_courses.repository.CourseRepository;
import de.telran.telran_project_students_courses.repository.StudentCourseRepository;
import de.telran.telran_project_students_courses.repository.StudentRepository;
import de.telran.telran_project_students_courses.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentCourseRepository studentCourseRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void createStudent(StudentRequestDTO request) {
        Student student = Student.builder()
                .name(request.getName())
                .build();

        studentRepository.save(student);
    }

    @Override
    public List<StudentResponseDTO> getAllStudents() {

        return studentRepository.findAll().stream()
                .map(student -> StudentResponseDTO.builder()
                       .name(student.getName())
                       .build())
                .collect(Collectors.toList());
    }

    @Override
    public StudentResponseDTO getStudentById(Long id) {

        Student  student = studentRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                String.format("Student with id %s does not exist", id)));

        List<Long> coursesIdByStudentId = getCoursesByStudentId(id);

        List<Course> courses = coursesIdByStudentId.stream()
                .map(courseId -> courseRepository.findById(courseId)
                        .orElseThrow(() ->
                                new ResponseStatusException(
                                        HttpStatus.NOT_FOUND,
                                        String.format("Course with id %s does not exist", id))))
                .collect(Collectors.toList());


        return convertStudentToDto(student, courses);

    }

    private List<Long> getCoursesByStudentId(Long id) {
        return studentCourseRepository.findAllByStudentId(id).stream()
                .map(StudentCourse::getCourseId)
                .collect(Collectors.toList());
    }


    private StudentResponseDTO convertStudentToDto(Student student, List<Course> courses) {
        return StudentResponseDTO.builder()
                .name(student.getName())
                .courses(courses.stream()
                        .map(course -> CourseRequestDTO.builder()
                                .courseName(course.getCourseName())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }

}
