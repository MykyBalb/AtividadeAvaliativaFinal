package com.example.demo.Service;

import com.example.demo.DTO.EstoqueDTO;
import com.example.demo.Entity.Estoque;
import com.example.demo.Repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstoqueService {
    @Autowired
    private EstoqueRepository rpEstoque;

    public List<Estoque> getAll() {
        return rpEstoque.findAll();
    }

    public EstoqueDTO create(EstoqueDTO e) {
        Estoque estoque = e.toEstoque();
        estoque = rpEstoque.save(estoque);
        return e.fromEstoque(estoque);
    }

    public Optional<EstoqueDTO> update(Long id, EstoqueDTO estoqueDTO) {
        Optional<Estoque> estoqueOp = rpEstoque.findById(id);
        if (estoqueOp.isPresent()) {
            Estoque estoque = estoqueOp.get();
            estoque.setMateriaPrima(estoqueDTO.getMateriaPrima());
            estoque.setProdutoAcabado(estoqueDTO.getProdutoAcabado());
            Estoque updated = rpEstoque.save(estoque);
            return Optional.of(estoqueDTO);
        }
        return Optional.empty();
    }

    public boolean delete(Long id) {
        if (rpEstoque.existsById(id)) {
            rpEstoque.deleteById(id);
            return true;
        }
        return false;
    }

}