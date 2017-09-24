package com.rkovtiuk.blog_ms.core.utils;

import com.rkovtiuk.blog_ms.core.domain.responses.BaseResponse;
import com.rkovtiuk.blog_ms.core.exception.*;
import org.springframework.http.ResponseEntity;

import static org.springframework.http.HttpStatus.*;

public class ExceptUtils {

    public static ResponseEntity<BaseResponse> responseData(Exception e) {
        if (e instanceof NotFoundException)
            return new ResponseEntity<>(new BaseResponse(e.getMessage()), NOT_FOUND);
        if (e instanceof WrongPassOrEmailException)
            return new ResponseEntity<>(new BaseResponse(e.getMessage()), BAD_GATEWAY);
        if (e instanceof EmptyRequestException)
            return new ResponseEntity<>(new BaseResponse(e.getMessage()), BAD_GATEWAY);
        if (e instanceof EmailNotValidException)
            return new ResponseEntity<>(new BaseResponse(e.getMessage()), BAD_GATEWAY);
        if (e instanceof PasswordDontMatchException)
            return new ResponseEntity<>(new BaseResponse(e.getMessage()), BAD_GATEWAY);
        return new ResponseEntity<>(new BaseResponse("Unexpected exception"), INTERNAL_SERVER_ERROR);
    }

}
