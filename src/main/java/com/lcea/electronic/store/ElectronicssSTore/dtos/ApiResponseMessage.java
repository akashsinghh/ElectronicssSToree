package com.lcea.electronic.store.ElectronicssSTore.dtos;

import lombok.*;
import org.springframework.http.HttpStatus;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponseMessage {
    private  String message;
    private boolean success;
    private HttpStatus status;
}
