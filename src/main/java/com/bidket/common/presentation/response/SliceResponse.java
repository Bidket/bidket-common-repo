package com.bidket.common.presentation.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.util.List;

@Getter
@Schema(description = "슬라이스 응답 형식")
public class SliceResponse<T> {

    @Schema(description = "현재 페이지 번호", example = "0")
    private final int page;

    @Schema(description = "페이지 크기", example = "20")
    private final int size;

    @Schema(description = "다음 페이지 존재 여부", example = "true")
    private final boolean hasNext;

    @Schema(description = "현재 페이지의 데이터 리스트")
    private final List<T> content;

    private SliceResponse(List<T> content, int page, int size, boolean hasNext) {
        this.content = content;
        this.page = page;
        this.size = size;
        this.hasNext = hasNext;
    }

    public static <T> SliceResponse<T> of(List<T> content, int page, int size, boolean hasNext) {
        return new SliceResponse<>(content, page, size, hasNext);
    }
}