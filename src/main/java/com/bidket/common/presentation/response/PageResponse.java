package com.bidket.common.presentation.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.util.List;

@Getter
@Schema(description = "페이징 처리된 응답 형식")
public class PageResponse<T> {

    @Schema(description = "현재 페이지 번호", example = "0")
    private final int page;

    @Schema(description = "페이지 크기", example = "20")
    private final int size;

    @Schema(description = "전체 데이터 개수", example = "125")
    private final long totalElements;

    @Schema(description = "전체 페이지 수", example = "7")
    private final int totalPages;

    @Schema(description = "다음 페이지 존재 여부", example = "true")
    private final boolean hasNext;

    @Schema(description = "이전 페이지 존재 여부", example = "false")
    private final boolean hasPrevious;

    @Schema(description = "현재 페이지의 데이터 리스트")
    private final List<T> content;

    private PageResponse(
            List<T> content,
            int page,
            int size,
            long totalElements,
            int totalPages,
            boolean hasNext,
            boolean hasPrevious
    ) {
        this.content = content;
        this.page = page;
        this.size = size;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.hasNext = hasNext;
        this.hasPrevious = hasPrevious;
    }

    public static <T> PageResponse<T> of(
            List<T> content,
            int page,
            int size,
            long totalElements
    ) {
        int totalPages = calculateTotalPages(totalElements, size);
        boolean hasNext = page + 1 < totalPages;
        boolean hasPrevious = page > 0;

        return new PageResponse<>(
                content,
                page,
                size,
                totalElements,
                totalPages,
                hasNext,
                hasPrevious
        );
    }

    private static int calculateTotalPages(long totalElements, int size) {
        if (size <= 0) {
            return 1;
        }
        if (totalElements == 0) {
            return 0;
        }
        return (int) ((totalElements - 1) / size + 1);
    }
}