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

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(Exception exception, WebRequest webRequest) {

        ErrorResponse errorDto = new ErrorResponse(
                exception.getMessage(),
                new Date(),
                webRequest.getDescription(false));

        return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(PackingListNotFoundException.class)
    public ResponseEntity<ErrorResponse> packingListNotFoundException(Exception exception, WebRequest webRequest) {

        ErrorResponse errorDto = new ErrorResponse(
                exception.getMessage(),
                new Date(),
                webRequest.getDescription(false));

        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(PackingListAlreadyExistException.class)
    public ResponseEntity<ErrorResponse> PackingListAlreadyExistException(Exception exception, WebRequest webRequest) {

        ErrorResponse errorDto = new ErrorResponse(
                exception.getMessage(),
                new Date(),
                webRequest.getDescription(false));

        return new ResponseEntity<>(errorDto, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(PackingListDoesntExistException.class)
    public ResponseEntity<ErrorResponse> PackingListDoesntExistException(Exception exception, WebRequest webRequest) {

        ErrorResponse errorDto = new ErrorResponse(
                exception.getMessage(),
                new Date(),
                webRequest.getDescription(false));

        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(WeatherNotFoundException.class)
    public ResponseEntity<ErrorResponse> WeatherNotFoundException(Exception exception, WebRequest webRequest) {

        ErrorResponse errorDto = new ErrorResponse(
                exception.getMessage(),
                new Date(),
                webRequest.getDescription(false));

        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmptyPackingListIdException.class)
    public ResponseEntity<ErrorResponse> EmptyPackingListIdException(Exception exception, WebRequest webRequest) {

        ErrorResponse errorDto = new ErrorResponse(
                exception.getMessage(),
                new Date(),
                webRequest.getDescription(false));

        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmptyPackingListItemException.class)
    public ResponseEntity<ErrorResponse> EmptyPackingListItemException(Exception exception, WebRequest webRequest) {

        ErrorResponse errorDto = new ErrorResponse(
                exception.getMessage(),
                new Date(),
                webRequest.getDescription(false));

        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmptyPackingListNameException.class)
    public ResponseEntity<ErrorResponse> EmptyPackingListNameException(Exception exception, WebRequest webRequest) {

        ErrorResponse errorDto = new ErrorResponse(
                exception.getMessage(),
                new Date(),
                webRequest.getDescription(false));

        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidTemperatureException.class)
    public ResponseEntity<ErrorResponse> InvalidTemperatureException(Exception exception, WebRequest webRequest) {

        ErrorResponse errorDto = new ErrorResponse(
                exception.getMessage(),
                new Date(),
                webRequest.getDescription(false));

        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidTravelDaysException.class)
    public ResponseEntity<ErrorResponse> InvalidTravelDaysException(Exception exception, WebRequest webRequest) {

        ErrorResponse errorDto = new ErrorResponse(
                exception.getMessage(),
                new Date(),
                webRequest.getDescription(false));

        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PackingItemAlreadyExistException.class)
    public ResponseEntity<ErrorResponse> PackingItemAlreadyExistException(Exception exception, WebRequest webRequest) {

        ErrorResponse errorDto = new ErrorResponse(
                exception.getMessage(),
                new Date(),
                webRequest.getDescription(false));

        return new ResponseEntity<>(errorDto, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(PackingItemNotFoundException.class)
    public ResponseEntity<ErrorResponse> PackingItemNotFoundException(Exception exception, WebRequest webRequest) {

        ErrorResponse errorDto = new ErrorResponse(
                exception.getMessage(),
                new Date(),
                webRequest.getDescription(false));

        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(InvalidUUIDException.class)
    public ResponseEntity<ErrorResponse> InvalidUUIDException(Exception exception, WebRequest webRequest) {

        ErrorResponse errorDto = new ErrorResponse(
                exception.getMessage(),
                new Date(),
                webRequest.getDescription(false));

        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }
    

}
