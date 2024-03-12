package com.parameta.prueba.controllers.exceptions;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CustomExceptionHandler {
    // Excepción personalizada para cuando no se envían todos los datos requeridos en el body
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException exception) {
        Map<String, String> errorMap = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error ->
        {
            errorMap.put(error.getField(), error.getDefaultMessage());

        });
        return errorMap;

    }

    // Excepción personalizada para tipo de dato inválido o fecha inválida
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidFormatException.class)
    public Map<String, String> handleInvalidFormatException(InvalidFormatException formatException) {
        Map<String, String> errorMap = new HashMap<>();

        String targetType = formatException.getTargetType().getSimpleName();
        String fieldName = formatException.getPath().get(0).getFieldName();
        String errorMessage = targetType.equals("LocalDate")
                ? "Formato de fecha inválido. Por favor siga el formato yyyy-MM-dd"
                : "Tipo de dato inválido. Tipo de dato esperado: " + targetType;
        errorMap.put(fieldName, errorMessage);
        return errorMap;

    }

}
