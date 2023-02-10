package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.entities.IPM_Entity;
import com.poste.ProjetIPM.entities.IPM_Service;

import java.util.Collection;
import java.util.List;

public interface IPM_ServiceService {

    Collection<IPM_Service> getAll();

    IPM_Service getById(long id);

    void save(IPM_Service ipm_service);

    void update(IPM_Service ipm_service);




    Collection<IPM_Service> getList(IPM_Entity ipmEntity);

    List<IPM_Service> save(List<IPM_Service> ipm_service);

    void delete(Long id);
}
