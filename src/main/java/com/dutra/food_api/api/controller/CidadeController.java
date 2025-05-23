package com.dutra.food_api.api.controller;

import com.dutra.food_api.domain.models.Cidade;
import com.dutra.food_api.domain.services.CadastroCidadeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    private final CadastroCidadeService cadastroCidadeService;

    public CidadeController(CadastroCidadeService cadastroCidadeService) {
        this.cadastroCidadeService = cadastroCidadeService;
    }


    @GetMapping("/{cidadeId}")
    public ResponseEntity<Cidade> buscar(@PathVariable Long cidadeId) {
        return ResponseEntity.ok(cadastroCidadeService.buscarPorId(cidadeId));
    }

    @GetMapping
    public ResponseEntity<List<Cidade>> buscarTodas() {
        return ResponseEntity.ok(cadastroCidadeService.buscarTodas());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Cidade> salvar(Cidade cidade) {
        return ResponseEntity.ok(cadastroCidadeService.salvar(cidade));
    }

    @PutMapping("/{cidadeId}")
    public ResponseEntity<Cidade> atualizar(@PathVariable Long cidadeId, Cidade cidade) {
        return ResponseEntity.ok(cadastroCidadeService.atualizar(cidadeId, cidade));
    }

    @DeleteMapping("/{cidadeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long cidadeId) {
        cadastroCidadeService.excluir(cidadeId);
    }
}
