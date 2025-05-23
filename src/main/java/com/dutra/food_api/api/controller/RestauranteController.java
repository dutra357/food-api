package com.dutra.food_api.api.controller;

import com.dutra.food_api.domain.models.Restaurante;
import com.dutra.food_api.domain.repositories.impl.RestauranteImpl;
import com.dutra.food_api.domain.services.interfaces.CadastroRestauranteInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    private final CadastroRestauranteInterface cadastroRestauranteService;
    private final RestauranteImpl restauranteImpl;

    public RestauranteController(CadastroRestauranteInterface cadastroRestauranteService,
                                 RestauranteImpl restauranteImpl) {
        this.cadastroRestauranteService = cadastroRestauranteService;
        this.restauranteImpl = restauranteImpl;
    }

    @GetMapping("/com-frete-gratis")
    public ResponseEntity<List<Restaurante>> buscar(@RequestParam String comNome) {
        return ResponseEntity.ok(restauranteImpl.findComFreteGratis(comNome));
    }

    @GetMapping("/buscar-primeiro")
    public ResponseEntity<Restaurante> buscarPrimeiro() {
        return ResponseEntity.ok(cadastroRestauranteService.buscarPrimeiro());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Restaurante> salvar(@RequestBody Restaurante restaurante) {
        return ResponseEntity.ok(cadastroRestauranteService.salvar(restaurante));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurante> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(cadastroRestauranteService.buscar(id));
    }

    @GetMapping()
    public ResponseEntity<List<Restaurante>> buscarTodos() {
        return ResponseEntity.ok(cadastroRestauranteService.buscarTodos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurante> atualizar(@PathVariable Long id,
                                                 @RequestBody Restaurante restaurante) {
        return ResponseEntity.ok(cadastroRestauranteService.atualizarTudo(restaurante));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Restaurante> atualizarParcial(@PathVariable Long id,
                                               @RequestBody Map<String, Object> campos) {
        return  ResponseEntity.ok(cadastroRestauranteService.atualizarParcial(id, campos));
    }
}
