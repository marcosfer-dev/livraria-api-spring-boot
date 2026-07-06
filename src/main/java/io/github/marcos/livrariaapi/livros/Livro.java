package io.github.marcos.livrariaapi.livros;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "livros")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String autor;
    private Integer anoPublicacao;
    private String editora;
    private Integer quantidadeExemplares;

    @Enumerated(EnumType.STRING)
    private StatusLivro status;

    public Livro(DadosCadastroLivro dadosCadastroLivro) {
        this.titulo = dadosCadastroLivro.titulo();
        this.autor = dadosCadastroLivro.autor();
        this.anoPublicacao = dadosCadastroLivro.anoPublicacao();
        this.editora = dadosCadastroLivro.editora();
        this.quantidadeExemplares = dadosCadastroLivro.quantidadeExemplares();
        this.status = StatusLivro.DISPONIVEL;
    }

    public void atualizarInformacoes(@Valid DadosAtualizarLivro dadosLivro) {
        if (dadosLivro.titulo() != null) {
            this.titulo = dadosLivro.titulo();
        }

        if (dadosLivro.autor() != null) {
            this.autor = dadosLivro.autor();
        }

        if (dadosLivro.anoPublicacao() != null) {
            this.anoPublicacao = dadosLivro.anoPublicacao();
        }

        if (dadosLivro.editora() != null) {
            this.editora = dadosLivro.editora();
        }

        if (dadosLivro.quantidadeExemplares() != null) {
            this.quantidadeExemplares = dadosLivro.quantidadeExemplares();
        }
    }

    public void inativar() {
        this.status = StatusLivro.INATIVO;
    }

    public void reativar() {
        this.status = StatusLivro.DISPONIVEL;
    }
}
