package de.telran.telran_project_students_courses.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "student_course")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class StudentCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "course_id")
    private Long courseId;
}
