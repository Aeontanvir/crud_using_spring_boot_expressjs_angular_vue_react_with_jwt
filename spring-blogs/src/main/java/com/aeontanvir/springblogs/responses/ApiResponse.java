package com.aeontanvir.springblogs.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T>{
    private boolean status;
    private String message;
    private T data;
    public static <T> ApiResponse<T> success(String message, T data){
        return new ApiResponse<>(true, message, data);
    }
    public static <T> ApiResponse<T> error(String message){
        return new ApiResponse<>(false, message, null);
    }
    public static <T> ApiResponse<T> error(String message, T data){
        return new ApiResponse<>(false, message, data);
    }
}
