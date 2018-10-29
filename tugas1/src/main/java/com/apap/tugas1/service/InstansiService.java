package com.apap.tugas1.service;



import com.apap.tugas1.model.InstansiModel;

import java.util.List;
import java.util.Optional;

public interface InstansiService {
    Optional<InstansiModel> getInstansiDetailById(Long id);
    List<InstansiModel> getAllInstansi();
    void addInstansi(InstansiModel instansi);
    void deleteInstansi(InstansiModel instansi);
}
