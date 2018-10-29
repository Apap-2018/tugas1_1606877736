package com.apap.tugas1.service;

import com.apap.tugas1.model.ProvinsiModel;
import com.apap.tugas1.repository.ProvinsiDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class ProvinsiServiceImpl implements ProvinsiService {
    @Autowired
    private ProvinsiDb provinsiDb;

    @Override
    public Optional<ProvinsiModel> getProvinsiById(Long id){
        return provinsiDb.findById(id);
    }

    @Override
    public void addProvinsi (ProvinsiModel provinsi){
        provinsiDb.save(provinsi);
    }

    @Override
    public void deleteProvinsi (ProvinsiModel provinsi) { provinsiDb.delete(provinsi);}

}
