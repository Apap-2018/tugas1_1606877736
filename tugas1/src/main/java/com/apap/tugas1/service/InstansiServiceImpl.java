package com.apap.tugas1.service;

import com.apap.tugas1.model.InstansiModel;
import com.apap.tugas1.repository.InstansiDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class InstansiServiceImpl implements InstansiService {
    @Autowired
    private InstansiDb instansiDb;

    @Override
    public Optional<InstansiModel> getInstansiDetailById(Long id){
        return instansiDb.findById(id);
    }

    @Override
    public List<InstansiModel> getAllInstansi(){ return instansiDb.findAll(); }

    @Override
    public void addInstansi(InstansiModel instansi) {
        instansiDb.save(instansi);
    }

    @Override
    public void deleteInstansi(InstansiModel instansi){ instansiDb.delete(instansi);}

}
