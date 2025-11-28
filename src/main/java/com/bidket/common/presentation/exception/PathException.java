package com.bidket.common.presentation.exception;

import com.bidket.common.presentation.error.BaseErrorCode;
import lombok.Getter;

@Getter
public class PathException extends RuntimeException {

    private final BaseErrorCode errorCode;

    public PathException(BaseErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}