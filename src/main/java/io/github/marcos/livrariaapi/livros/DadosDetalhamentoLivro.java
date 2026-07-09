package io.github.marcos.livrariaapi.livros;

public record DadosDetalhamentoLivro(
        Long id,
        String titulo,
        String autor,
        Integer anoPublicacao,
        String editora,
        Integer quantidadeExemplares
    )
{
    public DadosDetalhamentoLivro(Livro livro) {
        this(
                livro.getId(),
                livro.getTitulo(),
                livro.getAutor(),
                livro.getAnoPublicacao(),
                livro.getEditora(),
                livro.getQuantidadeExemplares()
        );
    }
}
