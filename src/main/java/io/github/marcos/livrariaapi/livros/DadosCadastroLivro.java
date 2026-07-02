package io.github.marcos.livrariaapi.livros;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record DadosCadastroLivro(

        @NotBlank
        String titulo,

        @NotBlank
        String autor,

        @NotNull
        @Min(1000)
        Integer anoPublicacao,

        @NotBlank
        String editora,

        @NotNull
        @Positive
        Integer quantidadeExemplares
    ) {
}
