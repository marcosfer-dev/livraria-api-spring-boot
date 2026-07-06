package io.github.marcos.livrariaapi.controller;

import io.github.marcos.livrariaapi.livros.*;
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
        return livroRepository.findAllByStatus(StatusLivro.DISPONIVEL)
                .stream()
                .map(DadosListagemLivro::new)
                .toList();
    }

    @PutMapping
    @Transactional
    public void atualizarLivro(@RequestBody @Valid DadosAtualizarLivro dadosAtualizarLivro) {
        var livro = livroRepository.getReferenceById(dadosAtualizarLivro.id());
        livro.atualizarInformacoes(dadosAtualizarLivro);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluirLivro(@PathVariable Long id) {
        livroRepository.deleteById(id);
    }

    @DeleteMapping("/inativar/{id}")
    @Transactional
    public void inativarLivro(@PathVariable Long id) {
        var livro = livroRepository.getReferenceById(id);
        livro.inativar();
    }

    @PutMapping("/reativar/{id}")
    @Transactional
    public void reativarLivro(@PathVariable Long id) {
        var livro = livroRepository.getReferenceById(id);
        livro.reativar();
    }
}
