package com.apap.tugas1.service;

import com.apap.tugas1.model.JabatanModel;

import java.util.List;
import java.util.Optional;

public interface JabatanService {
    Optional<JabatanModel> getJabatanById(Long id);
    List<JabatanModel> getAllJabatan();
    void addJabatan(JabatanModel jabatan);
    void deleteJabatan(JabatanModel jabatan);
}
