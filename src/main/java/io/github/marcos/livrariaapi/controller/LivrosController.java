package io.github.marcos.livrariaapi.controller;

import io.github.marcos.livrariaapi.livros.DadosCadastroLivro;
import io.github.marcos.livrariaapi.livros.DadosListagemLivro;
import io.github.marcos.livrariaapi.livros.Livro;
import io.github.marcos.livrariaapi.livros.LivroRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivrosController {

    @Autowired
    private LivroRepository livroRepository;

    @PostMapping
    @Transactional
    public void cadastrarLivro(@RequestBody @Valid DadosCadastroLivro dadosCadastroLivro) {
        livroRepository.save(new Livro(dadosCadastroLivro));
    }

    @GetMapping
    public List<DadosListagemLivro> listarLivros() {
        return livroRepository.findAll()
                .stream()
                .map(DadosListagemLivro::new)
                .toList();
    }

}
