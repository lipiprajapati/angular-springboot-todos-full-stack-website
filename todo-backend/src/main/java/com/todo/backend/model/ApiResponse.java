package com.todo.backend.model;

public record ApiResponse<T> (T data, ApiError error) {
    // Static helper for successful responses
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(data, null);
    }

    // Static helper for error responses
    public static <T> ApiResponse<T> error(String message, String code) {
        return new ApiResponse<>(null, new ApiError(message, code));
    }
}

