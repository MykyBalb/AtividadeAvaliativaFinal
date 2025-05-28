package com.example.demo.Controller;

import com.example.demo.DTO.EstoqueDTO;
import com.example.demo.Entity.Estoque;
import com.example.demo.Service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {
    @Autowired
    private EstoqueService estoqueService;

    @GetMapping
    public ResponseEntity<List<Estoque>> getAll() {
        List<Estoque> estoque = estoqueService.getAll();
        return ResponseEntity.ok(estoque);
    }

    @PostMapping
    public ResponseEntity<EstoqueDTO> create(@RequestBody EstoqueDTO estoque) {
        EstoqueDTO estoqueSaved = estoqueService.create(estoque);
        return ResponseEntity.status(HttpStatus.CREATED).body(estoqueSaved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstoqueDTO> update(@PathVariable Long id, @RequestBody EstoqueDTO estoqueDTO) {
        Optional<EstoqueDTO> updated = estoqueService.update(id, estoqueDTO);
        return updated.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return estoqueService.delete(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
