package io.github.marcos.livrariaapi.livros;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarLivro(
            @NotNull
            Long id,
            String titulo,
            String autor,
            Integer anoPublicacao,
            String editora,
            Integer quantidadeExemplares
        ) {
}
