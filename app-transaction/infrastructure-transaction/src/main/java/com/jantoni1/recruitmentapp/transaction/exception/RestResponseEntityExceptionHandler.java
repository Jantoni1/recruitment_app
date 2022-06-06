package com.jantoni1.recruitmentapp.transaction.exception;

import com.jantoni1.recruitmentapp.transaction.customer.exception.CustomerNotFoundException;
import com.jantoni1.recruitmentapp.transaction.exception.error.ApiError;
import com.jantoni1.recruitmentapp.transaction.exception.error.ApiSubError;
import com.jantoni1.recruitmentapp.transaction.exception.error.ApiValidationError;
import com.jantoni1.recruitmentapp.transaction.purchase.exception.PurchaseNotFoundException;
import com.jantoni1.recruitmentapp.transaction.shared.RuntimeAppException;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {RuntimeAppException.class})
    protected ResponseEntity<ApiError> handlePurchaseNotFound(RuntimeAppException ex) {
        var notFoundStatus = HttpStatus.NOT_FOUND;
        return ResponseEntity
                .status(notFoundStatus)
                .body(ApiError.builder()
                        .message(ex.getLocalizedMessage())
                        .httpStatus(notFoundStatus)
                        .build());
    }

    @ExceptionHandler(value = {ConstraintViolationException.class})
    protected ResponseEntity<ApiError> handlePurchaseNotFound(ConstraintViolationException ex) {
        var notFoundStatus = HttpStatus.UNPROCESSABLE_ENTITY;
        return ResponseEntity
                .status(notFoundStatus)
                .body(ApiError.builder()
                        .message("Invalid request data")
                        .debugMessage(ex.getLocalizedMessage())
                        .httpStatus(notFoundStatus)
                        .subErrors(mapToSubErrors(ex.getConstraintViolations()))
                        .build());
    }

    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<ApiError> handleAnyException(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiError.builder()
                        .message("Unknown error")
                        .debugMessage(ex.getLocalizedMessage())
                        .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                        .build());
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body,
                                                             HttpHeaders headers, HttpStatus status, WebRequest request) {
        var response = ResponseEntity.status(status)
                .body(ApiError.builder()
                        .httpStatus(status)
                        .debugMessage(ex.getMessage())
                        .build());
        return super.handleExceptionInternal(ex, response, headers, status, request);
    }
    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(
            MissingServletRequestParameterException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {
        String error = ex.getParameterName() + " parameter is missing";
        return new ResponseEntity<>(
                ApiError.builder()
                        .httpStatus(HttpStatus.BAD_REQUEST)
                        .message(error)
                        .debugMessage(ex.getLocalizedMessage())
                        .build(),
                HttpStatus.BAD_REQUEST
        );
    }

    private static List<ApiSubError> mapToSubErrors(Collection<ConstraintViolation<?>> constraintViolations) {
        return constraintViolations.stream()
                .map(RestResponseEntityExceptionHandler::mapToSubError)
                .collect(Collectors.toList());
    }

    private static ApiSubError mapToSubError(ConstraintViolation<?> violation) {
        return new ApiValidationError(
                violation.getRootBeanClass().getSimpleName(),
                ((PathImpl) violation.getPropertyPath()).getLeafNode().asString(),
                violation.getInvalidValue(),
                violation.getMessage()
        );
    }

}
