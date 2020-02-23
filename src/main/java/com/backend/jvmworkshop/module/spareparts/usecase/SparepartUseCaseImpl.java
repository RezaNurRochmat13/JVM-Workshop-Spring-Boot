package com.backend.jvmworkshop.module.spareparts.usecase;

import com.backend.jvmworkshop.module.spareparts.domain.Spareparts;
import com.backend.jvmworkshop.module.spareparts.repository.SparepartRepository;
import com.backend.jvmworkshop.module.util.exception.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SparepartUseCaseImpl implements SparepartUseCase {

    @Autowired
    private SparepartRepository sparepartRepository;

    @Override
    public List<Spareparts> findAllSpareparts() {
        return sparepartRepository.findAll();
    }

    @Override
    public Long countAllSparepart() {
        return sparepartRepository.count();
    }

    @Override
    public Optional<Spareparts> findBySparepartId(Long id) {
        Optional<Spareparts> sparepartsById = Optional.ofNullable(sparepartRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFound("Spareparts not found with id " + id)));
        return sparepartsById;
    }

    @Override
    public Spareparts createNewSparepart(Spareparts sparepartsPayload) {
        return sparepartRepository.save(sparepartsPayload);
    }

    @Override
    public Spareparts updateSparepart(Long id, Spareparts sparepartsPayload) {
        Spareparts sparepartsUpdateById = sparepartRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFound("Spareparts not found with id " + id));
        sparepartsUpdateById.setSparepartName(sparepartsPayload.getSparepartName());
        sparepartsUpdateById.setSparepartStock(sparepartsPayload.getSparepartStock());
        sparepartRepository.save(sparepartsUpdateById);
        return sparepartsUpdateById;
    }

    @Override
    public Spareparts deleteSparepart(Long id) {
        Spareparts sparepartsDeleteById = sparepartRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFound("Spareparts not found with id " + id));
        sparepartRepository.delete(sparepartsDeleteById);
        return sparepartsDeleteById;
    }
}
