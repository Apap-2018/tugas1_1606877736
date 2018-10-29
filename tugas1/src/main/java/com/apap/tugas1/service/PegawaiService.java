package com.apap.tugas1.service;


import com.apap.tugas1.model.JabatanModel;
import com.apap.tugas1.model.PegawaiModel;

import java.util.List;
import java.util.Optional;

public interface PegawaiService {
    PegawaiModel getPegawaiByNip(String nip);
    List<JabatanModel> getListJabatan(PegawaiModel pegawai);
    void addPegawai(PegawaiModel pegawai);
    void deletePegawai(PegawaiModel pegawai);
}
