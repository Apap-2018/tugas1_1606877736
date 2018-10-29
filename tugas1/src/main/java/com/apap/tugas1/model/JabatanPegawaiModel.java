package com.apap.tugas1.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "jabatan_pegawai")
public class JabatanPegawaiModel implements Serializable {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public JabatanModel getJabatan() {
        return jabatan;
    }

    public void setJabatan(JabatanModel jabatan) {
        this.jabatan = jabatan;
    }

    public PegawaiModel getPegawai() {
        return pegawai;
    }

    public void setPegawai(PegawaiModel pegawai) {
        this.pegawai = pegawai;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_jabatan", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private JabatanModel jabatan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pegawai", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private PegawaiModel pegawai;

}
