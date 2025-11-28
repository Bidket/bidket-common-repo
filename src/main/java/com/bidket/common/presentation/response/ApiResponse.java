package com.bidket.common.presentation.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
@Schema(description = "공통 API 응답 형식")
public class ApiResponse<T> {

    @Schema(description = "요청 처리 성공 여부", example = "true")
    private final boolean success;

    @Schema(description = "결과 메시지", example = "OK")
    private final String message;

    @Schema(description = "응답 데이터")
    private final T data;

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(true, "OK", data);
    }

    public static <T> ApiResponse<T> success(String message, T data) {
        return new ApiResponse<>(true, message, data);
    }

    public static ApiResponse<?> error(String message) {
        return new ApiResponse<>(false, message, null);
    }
}