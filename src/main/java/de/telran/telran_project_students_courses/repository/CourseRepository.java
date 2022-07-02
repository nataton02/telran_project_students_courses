package de.telran.telran_project_students_courses.repository;

import de.telran.telran_project_students_courses.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
