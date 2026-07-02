package io.github.marcos.livrariaapi.livros;

import jakarta.persistence.*;
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
}
