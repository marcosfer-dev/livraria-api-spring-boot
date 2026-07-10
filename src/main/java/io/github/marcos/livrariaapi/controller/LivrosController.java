package io.github.marcos.livrariaapi.controller;

import io.github.marcos.livrariaapi.livros.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivrosController {

    @Autowired
    private LivroRepository livroRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoLivro> cadastrarLivro(@RequestBody @Valid DadosCadastroLivro dadosCadastroLivro, UriComponentsBuilder uriBuilder) {
        var livro = new Livro(dadosCadastroLivro);
        livroRepository.save(livro);

        var uri = uriBuilder.path("/livros/{id}").buildAndExpand(livro.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoLivro(livro));
    }

    @GetMapping
    public ResponseEntity<List<DadosListagemLivro>> listarLivros() {
        var lista = livroRepository.findAllByStatus(StatusLivro.DISPONIVEL)
                .stream()
                .map(DadosListagemLivro::new)
                .toList();

        return ResponseEntity.ok(lista);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoLivro> atualizarLivro(@RequestBody @Valid DadosAtualizarLivro dadosAtualizarLivro) {
        var livro = livroRepository.getReferenceById(dadosAtualizarLivro.id());
        livro.atualizarInformacoes(dadosAtualizarLivro);

        return ResponseEntity.ok(new DadosDetalhamentoLivro(livro));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluirLivro(@PathVariable Long id) {
        livroRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/inativar/{id}")
    @Transactional
    public ResponseEntity<Void> inativarLivro(@PathVariable Long id) {
        var livro = livroRepository.getReferenceById(id);
        livro.inativar();

        return ResponseEntity.noContent().build();
    }
    @PutMapping("/reativar/{id}")
    @Transactional
    public ResponseEntity<Void> reativarLivro(@PathVariable Long id) {
        var livro = livroRepository.getReferenceById(id);
        livro.reativar();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoLivro> detalharLivro(@PathVariable Long id) {
        var livro = livroRepository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoLivro(livro));
    }
}
