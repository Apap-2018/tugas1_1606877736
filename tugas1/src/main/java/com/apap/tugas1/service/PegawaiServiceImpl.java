package com.apap.tugas1.service;

import com.apap.tugas1.model.JabatanModel;
import com.apap.tugas1.model.JabatanPegawaiModel;
import com.apap.tugas1.model.PegawaiModel;
import com.apap.tugas1.repository.PegawaiDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PegawaiServiceImpl implements PegawaiService {
    @Autowired
    private PegawaiDb pegawaiDb;

    @Override
    public PegawaiModel getPegawaiByNip(String nip){
        return pegawaiDb.findByNip(nip);
    }

    @Override
    public List<JabatanModel> getListJabatan(PegawaiModel pegawai){
        List<JabatanModel> lstJab = new ArrayList<JabatanModel>();
        List<JabatanPegawaiModel> lstJabwai = pegawai.getListPegawaiJabatan();
        for (JabatanPegawaiModel jabwai : lstJabwai){
            lstJab.add(jabwai.getJabatan());
        }
        return lstJab;
    }

    @Override
    public void addPegawai (PegawaiModel pegawai){
        pegawaiDb.save(pegawai);
    }

    @Override
    public void deletePegawai (PegawaiModel pegawai) { pegawaiDb.delete(pegawai);}

}
