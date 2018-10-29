package com.apap.tugas1.service;


import com.apap.tugas1.model.JabatanPegawaiModel;

import java.util.Optional;

public interface JabatanPegawaiService {
    Optional<JabatanPegawaiModel> getJabatanPegawaiById(Long id);
    void addJabatanPegawai(JabatanPegawaiModel jabatanPegawai);
    void deleteJabatanPegawai(JabatanPegawaiModel jabatanPegawai);
}
