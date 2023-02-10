package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.Repository.IPM_CatgorieRepository;
import com.poste.ProjetIPM.entities.IPM_Categorie;
import com.poste.ProjetIPM.entities.IPM_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class IPM_CategorieServiceImpl implements IPM_CategorieService {

    @Autowired
    IPM_CatgorieRepository ipm_catgorieRepository;

    @Override
    public Collection<IPM_Categorie> getAll() {
        return ipm_catgorieRepository.findAll();
    }

    @Override
    public IPM_Categorie getById(long id) {
        return ipm_catgorieRepository.findById(id).get();
    }

    @Override
    public void save(IPM_Categorie ipm_categorie) {
        ipm_catgorieRepository.save(ipm_categorie);
    }

    @Override
    public void update(IPM_Categorie ipm_categorie) {
        ipm_catgorieRepository.save(ipm_categorie);
    }

    @Override
    public void delete(Long id) {
        ipm_catgorieRepository.deleteById(id);
    }
    @Override
    public List<IPM_Categorie> save(List<IPM_Categorie> ipm_categories) {
        for (int i = 0; i < ipm_categories.size(); i++) {
            ipm_catgorieRepository.save(ipm_categories.get(i));

        }
        return ipm_categories;
    }
}
