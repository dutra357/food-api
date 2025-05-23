package com.dutra.food_api.domain.services;

import com.dutra.food_api.domain.services.exceptions.EntidadeNaoEncontradaException;
import com.dutra.food_api.domain.models.Estado;
import com.dutra.food_api.domain.repositories.EstadoRepository;
import com.dutra.food_api.domain.services.interfaces.CadastroEstadoInterface;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CadastroEstadoService implements CadastroEstadoInterface {

    private final EstadoRepository estadoRepository;
    public CadastroEstadoService(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Estado> buscarTodos() {
        return estadoRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Estado buscarPorId(Long id) {
        return estadoRepository.findById(id)
                .orElseThrow(() -> new EmptyResultDataAccessException(1));
    }

    @Transactional(readOnly = false)
    @Override
    public Estado salvar(Estado estado) {
        return estadoRepository.save(estado);
    }

    @Transactional(readOnly = false)
    @Override
    public void delete(Long estadoId) {

        Estado estado = estadoRepository.findById(estadoId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        String.format("Não existe um cadastro de estado com código %d", estadoId)));

        try {
            estadoRepository.delete(estado);

        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException(
                    String.format("Estado de código %d não pode ser removido, pois está em uso", estadoId));
        }
    }

    @Transactional(readOnly = false)
    @Override
    public Estado atualizar(Estado estado) {
        return estadoRepository.save(estado);
    }

}
