package com.lcea.electronic.store.ElectronicssSTore.dtos;

import lombok.*;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ImageResponse {
    private String imageName;
    private  String message;
    private boolean success;
    private HttpStatus status;
}

