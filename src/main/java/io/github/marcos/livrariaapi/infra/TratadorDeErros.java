package io.github.marcos.livrariaapi.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> tratador400(MethodArgumentNotValidException ex) {
        var erros = ex.getFieldErrors();

        return ResponseEntity.badRequest().body(erros.stream().map(DadosErros::new).toList());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> tratador404() {
        return ResponseEntity.notFound().build();
    }

    public record DadosErros(String campo, String mensagem) {

        public DadosErros(FieldError erro) {
            this(erro.getField(), erro.getDefaultMessage());
        }
    }

}
