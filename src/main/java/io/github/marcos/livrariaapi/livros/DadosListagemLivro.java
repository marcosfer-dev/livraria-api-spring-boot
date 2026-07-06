package io.github.marcos.livrariaapi.livros;

public record DadosListagemLivro(Long id, String titulo, String autor, Integer anoPublicacao, String editora, Integer quantidadeExemplares, StatusLivro status) {

    public DadosListagemLivro(Livro livro){
        this(livro.getId(), livro.getTitulo(), livro.getAutor(), livro.getAnoPublicacao(), livro.getEditora(), livro.getQuantidadeExemplares(), livro.getStatus());
    }

}
