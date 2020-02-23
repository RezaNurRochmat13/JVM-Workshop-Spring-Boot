package com.backend.jvmworkshop.module.spareparts.usecase;

import com.backend.jvmworkshop.module.spareparts.domain.Spareparts;

import java.util.List;
import java.util.Optional;

public interface SparepartUseCase {
    List<Spareparts> findAllSpareparts();
    Long countAllSparepart();
    Optional<Spareparts> findBySparepartId(Long id);
    Spareparts createNewSparepart(Spareparts sparepartsPayload);
    Spareparts updateSparepart(Long id, Spareparts sparepartsPayload);
    Spareparts deleteSparepart(Long id);
}
