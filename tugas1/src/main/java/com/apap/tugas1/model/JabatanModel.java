package com.apap.tugas1.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "jabatan")
public class JabatanModel implements Serializable {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public Double getGaji_pokok() {
        return gaji_pokok;
    }

    public void setGaji_pokok(Double gaji_pokok) {
        this.gaji_pokok = gaji_pokok;
    }

    public List<JabatanPegawaiModel> getListPegawaiJabatan() {
        return listPegawaiJabatan;
    }

    public void setListPegawaiJabatan(List<JabatanPegawaiModel> listPegawaiJabatan) {
        this.listPegawaiJabatan = listPegawaiJabatan;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 255)
    @Column(name = "nama", nullable = false)
    private String nama;

    @NotNull
    @Size(max = 255)
    @Column(name = "deskripsi", nullable = false)
    private String deskripsi;

    @NotNull
    @Column(name = "gaji_pokok", nullable = false)
    private Double gaji_pokok;

    @OneToMany(mappedBy = "jabatan", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<JabatanPegawaiModel> listPegawaiJabatan;

}
