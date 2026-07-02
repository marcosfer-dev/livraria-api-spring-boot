package io.github.marcos.livrariaapi.controller;

import io.github.marcos.livrariaapi.livros.DadosCadastroLivro;
import io.github.marcos.livrariaapi.livros.Livro;
import io.github.marcos.livrariaapi.livros.LivroRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livros")
public class LivrosController {

    @Autowired
    private LivroRepository livroRepository;

    @PostMapping
    public void cadastrarLivro(@RequestBody @Valid DadosCadastroLivro dadosCadastroLivro) {
        livroRepository.save(new Livro(dadosCadastroLivro));
    }

}
