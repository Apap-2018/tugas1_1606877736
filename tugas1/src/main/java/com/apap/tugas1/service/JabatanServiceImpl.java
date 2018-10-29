package com.apap.tugas1.service;

import com.apap.tugas1.model.JabatanModel;
import com.apap.tugas1.repository.JabatanDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class JabatanServiceImpl implements JabatanService {
    @Autowired
    private JabatanDb jabatanDb;

    @Override
    public Optional<JabatanModel> getJabatanById(Long id){
        return jabatanDb.findById(id);
    }

    @Override
    public List<JabatanModel> getAllJabatan(){ return jabatanDb.findAll(); }

    @Override
    public void addJabatan (JabatanModel jabatan){
        jabatanDb.save(jabatan);
    }

    @Override
    public void deleteJabatan (JabatanModel jabatan) { jabatanDb.delete(jabatan);}


}
