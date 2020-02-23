package com.backend.jvmworkshop.module.spareparts.repository;

import com.backend.jvmworkshop.module.spareparts.domain.Spareparts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SparepartRepository extends JpaRepository<Spareparts, Long> {
}
