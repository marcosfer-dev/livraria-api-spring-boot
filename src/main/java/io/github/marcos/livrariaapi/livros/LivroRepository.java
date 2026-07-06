package io.github.marcos.livrariaapi.livros;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {

    List<Livro>findAllByStatus(StatusLivro status);

}
