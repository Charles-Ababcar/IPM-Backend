package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.entities.IPM_Service;

import java.util.Collection;

public interface IPM_ServiceService {

    Collection<IPM_Service> getAll();

    IPM_Service getById(long id);

    void save(IPM_Service ipm_service);

    void update(IPM_Service ipm_service);

    void delete(Long id);
}
