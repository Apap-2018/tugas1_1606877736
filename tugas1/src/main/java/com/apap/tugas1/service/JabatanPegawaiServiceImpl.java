package com.apap.tugas1.service;

import com.apap.tugas1.model.JabatanPegawaiModel;
import com.apap.tugas1.repository.JabatanPegawaiDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class JabatanPegawaiServiceImpl implements JabatanPegawaiService {
    @Autowired
    private JabatanPegawaiDb jabatanPegawaiDb;

    @Override
    public Optional<JabatanPegawaiModel> getJabatanPegawaiById(Long id){
        return jabatanPegawaiDb.findById(id);
    }

    @Override
    public void addJabatanPegawai (JabatanPegawaiModel jabatanPegawai){
        jabatanPegawaiDb.save(jabatanPegawai);
    }

    @Override
    public void deleteJabatanPegawai (JabatanPegawaiModel jabatanPegawai) { jabatanPegawaiDb.delete(jabatanPegawai);}

}
