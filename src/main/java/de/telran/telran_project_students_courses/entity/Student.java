package de.telran.telran_project_students_courses.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "student")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", unique = true)
    private String name;
}
