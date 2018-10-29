package com.apap.tugas1.service;

import com.apap.tugas1.model.ProvinsiModel;

import java.util.Optional;

public interface ProvinsiService {
    Optional<ProvinsiModel> getProvinsiById(Long id);
    void addProvinsi(ProvinsiModel provinsi);
    void deleteProvinsi(ProvinsiModel provinsi);
}
