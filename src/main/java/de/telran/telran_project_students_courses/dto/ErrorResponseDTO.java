package de.telran.telran_project_students_courses.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Data
@Builder
public class ErrorResponseDTO {

    private HttpStatus status;
    private String message;
}
