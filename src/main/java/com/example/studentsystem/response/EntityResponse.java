package com.example.studentsystem.response;



import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EntityResponse<T> {

    private int status;
    private String message;
    private T data;
    private LocalDateTime timestamp;

}
