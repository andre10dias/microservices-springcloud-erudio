package com.github.andre10dias.microservices_springcloud_erudio.exception;

import java.util.Date;

public record ExceptionResponse(
        Date timestamp, String message, String details
) {
}
