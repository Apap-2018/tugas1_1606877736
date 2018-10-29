package com.apap.tugas1.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "provinsi")
public class ProvinsiModel implements Serializable {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 255)
    @Column(name = "nama", nullable = false)
    private String nama;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Double getPresentaseTunjangan() {
        return presentaseTunjangan;
    }

    public void setPresentaseTunjangan(Double presentaseTunjangan) {
        this.presentaseTunjangan = presentaseTunjangan;
    }

    public List<InstansiModel> getListInstansi() {
        return listInstansi;
    }

    public void setListInstansi(List<InstansiModel> listInstansi) {
        this.listInstansi = listInstansi;
    }

    @NotNull
    @Column(name = "presentase_tunjangan", nullable = false)
    private Double presentaseTunjangan;

    @OneToMany(mappedBy = "provinsi", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<InstansiModel> listInstansi;

}
