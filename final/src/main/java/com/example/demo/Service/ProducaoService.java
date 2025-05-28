package com.example.demo.Service;

import com.example.demo.DTO.ProducaoDTO;
import com.example.demo.Entity.Producao;
import com.example.demo.Repository.ProducaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProducaoService {
    @Autowired
    private ProducaoRepository rpProducao;

    public List<Producao> getAll() {return rpProducao.findAll();}

    public ProducaoDTO create(ProducaoDTO p) {
        Producao producao = p.toProducao();
        producao = rpProducao.save(producao);
        return p.fromProducao(producao);
    }

    public Optional<ProducaoDTO> update(Long id, ProducaoDTO producaoDTO) {
        Optional<Producao> estoqueOp = rpProducao.findById(id);
        if (estoqueOp.isPresent()) {
            Producao producao = estoqueOp.get();
            producao.setEspecificacao(producaoDTO.getEspecificacao());
            producao.setQuantidade(producaoDTO.getQuantidade());
            producao.setTipoAco(producaoDTO.getTipoAco());
            Producao updated = rpProducao.save(producao);
            return Optional.of(producaoDTO);
        }
        return Optional.empty();
    }

    public boolean delete(Long id) {
        if (rpProducao.existsById(id)) {
            rpProducao.deleteById(id);
            return true;
        }
        return false;
    }
}
