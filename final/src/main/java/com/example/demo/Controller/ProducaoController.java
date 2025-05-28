package com.example.demo.Controller;

import com.example.demo.DTO.ProducaoDTO;
import com.example.demo.Entity.Producao;
import com.example.demo.Service.ProducaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/producao")
public class ProducaoController {
    @Autowired
    private ProducaoService producaoService;

    @GetMapping
    public ResponseEntity<List<Producao>> getAll() {
        List<Producao> producao = producaoService.getAll();
        return ResponseEntity.ok(producao);
    }

    @PostMapping
    public ResponseEntity<ProducaoDTO> create(@RequestBody ProducaoDTO producaoDTO) {
        ProducaoDTO producaoSaved = producaoService.create(producaoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(producaoSaved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProducaoDTO> update(@PathVariable Long id, @RequestBody ProducaoDTO producaoDTO) {
        Optional<ProducaoDTO> updated = producaoService.update(id, producaoDTO);
        return updated.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return producaoService.delete(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
