package com.backend.jvmworkshop.module.spareparts.presenter;

import com.backend.jvmworkshop.module.spareparts.domain.Spareparts;
import com.backend.jvmworkshop.module.spareparts.usecase.SparepartUseCaseImpl;
import com.backend.jvmworkshop.module.util.response.BaseCreateOrUpdateResponse;
import com.backend.jvmworkshop.module.util.response.BaseListCollectionResponse;
import com.backend.jvmworkshop.module.util.response.BaseSingleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/")
public class SparepartPresenter {

    @Autowired
    private SparepartUseCaseImpl sparepartUseCase;

    @GetMapping("spareparts")
    @ResponseStatus(HttpStatus.OK)
    public BaseListCollectionResponse getAllSpareparts() {
        BaseListCollectionResponse baseListCollectionResponse = new BaseListCollectionResponse();
        List<Spareparts> sparepartsList = sparepartUseCase.findAllSpareparts();
        Long countAllSpareparts = sparepartUseCase.countAllSparepart();
        baseListCollectionResponse.setCount(sparepartsList.size());
        baseListCollectionResponse.setTotal(countAllSpareparts);
        baseListCollectionResponse.setResult(sparepartsList);
        return baseListCollectionResponse;
    }

    @GetMapping("sparepart/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BaseSingleResponse getSingleSpareparts(@PathVariable Long id) {
        BaseSingleResponse baseSingleResponse = new BaseSingleResponse();
        Optional<Spareparts> sparepartsById = sparepartUseCase.findBySparepartId(id);
        baseSingleResponse.setResult(sparepartsById);
        return baseSingleResponse;
    }

    @PostMapping("sparepart")
    @ResponseStatus(HttpStatus.CREATED)
    public BaseCreateOrUpdateResponse createNewSparepart(@RequestBody Spareparts sparepartsPayload) {
        BaseCreateOrUpdateResponse baseCreateOrUpdateResponse = new BaseCreateOrUpdateResponse();
        Spareparts sparepartsCreate = sparepartUseCase.createNewSparepart(sparepartsPayload);
        baseCreateOrUpdateResponse.setMessages("Spareparts created successfully");
        baseCreateOrUpdateResponse.setResourceCreateOrUpdated(sparepartsCreate);
        return baseCreateOrUpdateResponse;
    }

    @PutMapping("sparepart/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BaseCreateOrUpdateResponse updateSpareparts(
            @PathVariable Long id,
            @RequestBody Spareparts sparepartsPayload) {
        BaseCreateOrUpdateResponse baseCreateOrUpdateResponse = new BaseCreateOrUpdateResponse();
        Spareparts sparepartsUpdate = sparepartUseCase.updateSparepart(id, sparepartsPayload);
        baseCreateOrUpdateResponse.setMessages("Spareparts updated successfully");
        baseCreateOrUpdateResponse.setResourceCreateOrUpdated(sparepartsUpdate);
        return baseCreateOrUpdateResponse;
    }

    @DeleteMapping("sparepart/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BaseCreateOrUpdateResponse deleteSpareparts(@PathVariable Long id) {
        BaseCreateOrUpdateResponse baseCreateOrUpdateResponse = new BaseCreateOrUpdateResponse();
        Spareparts sparepartsDelete = sparepartUseCase.deleteSparepart(id);
        baseCreateOrUpdateResponse.setMessages("Spareparts deleted successfully");
        baseCreateOrUpdateResponse.setResourceCreateOrUpdated(sparepartsDelete);
        return baseCreateOrUpdateResponse;
    }
}
