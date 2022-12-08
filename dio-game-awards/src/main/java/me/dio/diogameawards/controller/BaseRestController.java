package me.dio.diogameawards.controller;

import me.dio.diogameawards.service.exepetion.BusinessException;
import me.dio.diogameawards.service.exepetion.NoContentException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api")
public abstract class BaseRestController {

    @ExceptionHandler(NoContentException.class)
    public ResponseEntity<Void> handlerNoContentException(NoContentException exception){
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiErrorDTO> handlerNoBusinessException(BusinessException exception){
        ApiErrorDTO error = new ApiErrorDTO(exception.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ApiErrorDTO> handlerUnexpectedException(Throwable exception){
        exception.printStackTrace();
        ApiErrorDTO error = new ApiErrorDTO("Ops, Ocorreu Algo Inesperado");
        return ResponseEntity.internalServerError().body(error);
    }

}
