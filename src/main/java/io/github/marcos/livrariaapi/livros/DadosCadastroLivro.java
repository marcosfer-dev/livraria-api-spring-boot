package io.github.marcos.livrariaapi.livros;

import jakarta.validation.constraints.*;

public record DadosCadastroLivro(

        @NotBlank(message = "Nome não pode estar em branco")
        String titulo,

        @NotBlank(message = "Autor não pode estar em branco")
        String autor,

        @NotNull(message = "O ano é obrigatório")
        @Min(1000)
        Integer anoPublicacao,

        @NotBlank(message = "A editora é obrigatória e não pode estar em branco")
        String editora,

        @NotNull(message = "A quantidade de exemplares é obrigatória")
        @PositiveOrZero(message = "A quantidade não pode ser negativa.")
        Integer quantidadeExemplares
    ) {
}
