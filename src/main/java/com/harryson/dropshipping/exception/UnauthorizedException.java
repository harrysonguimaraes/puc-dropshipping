package com.harryson.dropshipping.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED, reason = "Unauthorized")
public class UnauthorizedException extends RuntimeException {

}
