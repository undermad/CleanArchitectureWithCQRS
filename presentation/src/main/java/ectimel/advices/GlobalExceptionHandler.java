package ectimel.advices;

import ectimel.exception.PackingListNotFoundException;
import ectimel.exceptions.InvalidUUIDException;
import example.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PackingListNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlePackingListNotFoundException(PackingListNotFoundException ex, WebRequest request) {
        return buildErrorResponse(ex, request, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PackingListAlreadyExistException.class)
    public ResponseEntity<ErrorResponse> handlePackingListAlreadyExistException(PackingListAlreadyExistException ex, WebRequest request) {
        return buildErrorResponse(ex, request, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(PackingListDoesntExistException.class)
    public ResponseEntity<ErrorResponse> handlePackingListDoesntExistException(PackingListDoesntExistException ex, WebRequest request) {
        return buildErrorResponse(ex, request, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(WeatherNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleWeatherNotFoundException(WeatherNotFoundException ex, WebRequest request) {
        return buildErrorResponse(ex, request, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmptyPackingListIdException.class)
    public ResponseEntity<ErrorResponse> handleEmptyPackingListIdException(EmptyPackingListIdException ex, WebRequest request) {
        return buildErrorResponse(ex, request, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmptyPackingListItemException.class)
    public ResponseEntity<ErrorResponse> handleEmptyPackingListItemException(EmptyPackingListItemException ex, WebRequest request) {
        return buildErrorResponse(ex, request, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmptyPackingListNameException.class)
    public ResponseEntity<ErrorResponse> handleEmptyPackingListNameException(EmptyPackingListNameException ex, WebRequest request) {
        return buildErrorResponse(ex, request, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidTemperatureException.class)
    public ResponseEntity<ErrorResponse> handleInvalidTemperatureException(InvalidTemperatureException ex, WebRequest request) {
        return buildErrorResponse(ex, request, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidTravelDaysException.class)
    public ResponseEntity<ErrorResponse> handleInvalidTravelDaysException(InvalidTravelDaysException ex, WebRequest request) {
        return buildErrorResponse(ex, request, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PackingItemAlreadyExistException.class)
    public ResponseEntity<ErrorResponse> handlePackingItemAlreadyExistException(PackingItemAlreadyExistException ex, WebRequest request) {
        return buildErrorResponse(ex, request, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(PackingItemNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlePackingItemNotFoundException(PackingItemNotFoundException ex, WebRequest request) {
        return buildErrorResponse(ex, request, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidUUIDException.class)
    public ResponseEntity<ErrorResponse> handleInvalidUUIDException(InvalidUUIDException ex, WebRequest request) {
        return buildErrorResponse(ex, request, HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<ErrorResponse> buildErrorResponse(Exception ex, WebRequest request, HttpStatus status) {
        ErrorResponse errorResponse = new ErrorResponse(
                ex.getMessage(),
                new Date(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(errorResponse, status);
    }

}
