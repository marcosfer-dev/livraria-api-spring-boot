package io.github.marcos.livrariaapi.livros;

public record DadosListagemLivro(String titulo, String autor, Integer anoPublicacao, String editora, Integer quantidadeExemplares) {

    public DadosListagemLivro(Livro livro){
        this(livro.getTitulo(), livro.getAutor(), livro.getAnoPublicacao(), livro.getEditora(), livro.getQuantidadeExemplares());
    }

}
