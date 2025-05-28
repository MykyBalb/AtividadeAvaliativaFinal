package com.example.demo.Controller;

import com.example.demo.DTO.EstoqueDTO;
import com.example.demo.Entity.Estoque;
import com.example.demo.Repository.EstoqueRepository;
import com.example.demo.Service.EstoqueService;
import org.hibernate.boot.model.source.spi.EmbeddableSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


}
