package com.apap.tugas1.controller;

import com.apap.tugas1.model.JabatanModel;
import com.apap.tugas1.service.InstansiService;
import com.apap.tugas1.service.JabatanService;
import com.apap.tugas1.service.PegawaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class JabatanController {
    @Autowired
    private InstansiService instansiService;

    @Autowired
    private PegawaiService pegawaiService;

    @Autowired
    private JabatanService jabatanService;


    @RequestMapping(value = "/jabatan/tambah", method = RequestMethod.GET)
    private String tambah(Model model){
        model.addAttribute("judul", "Tambah Jabatan");
        model.addAttribute("jabatan", new JabatanModel());
        return "tambahJabatan";
    }

    @RequestMapping(value = "/jabatan/tambah", method = RequestMethod.POST)
    private String tambahSubmit(@ModelAttribute JabatanModel jabatan, Model model){
        jabatanService.addJabatan(jabatan);
        model.addAttribute("judul", "Tambah Jabatan Sukses");
        return "tambahJabatanSukses";
    }

    @RequestMapping(value = "/jabatan/view", method = RequestMethod.GET)
    private String viewJabatan(@RequestParam(value = "idJabatan", required = true) Long idJabatan, Model model){
        JabatanModel archive = jabatanService.getJabatanById(idJabatan).get();
        model.addAttribute("judul", "Lihat Jabatan");
        model.addAttribute("jabatan", archive);
        return "view-jabatan";
    }

    @RequestMapping(value = "/jabatan/ubah", method = RequestMethod.GET)
    private String updateJabatan(@RequestParam(value = "idJabatan", required = true) long idJabatan, Model model){
        JabatanModel archive = jabatanService.getJabatanById(idJabatan).get();
        model.addAttribute("jabatan", archive);
        model.addAttribute("judul", "Ubah Jabatan");
        return "update-jabatan";
    }

    @RequestMapping(value = "/jabatan/ubah", method = RequestMethod.POST)
    private String updateJabatanSubmit(@ModelAttribute JabatanModel jabatan, Model model){
        JabatanModel archive = jabatanService.getJabatanById(jabatan.getId()).get();
        jabatan.setListPegawaiJabatan(archive.getListPegawaiJabatan());
        jabatanService.deleteJabatan(archive);
        jabatanService.addJabatan(jabatan);
        model.addAttribute("judul", "Jabatan berhasil diupdate");
        return "update";
    }

    @RequestMapping(value = "/jabatan/hapus", method = RequestMethod.GET)
    private String delete(@RequestParam(value = "idJabatan", required = true) long idJabatan, Model model){
        JabatanModel archive = jabatanService.getJabatanById(idJabatan).get();
        jabatanService.deleteJabatan(archive);
        model.addAttribute("judul", "Jabatan berhasil dihapus");
        return "hapus-jabatan";
    }

    /*@RequestMapping(value = "/dealer/add", method = RequestMethod.GET)
    private String add(Model model){
        model.addAttribute("judul", "Add Dealer");
        model.addAttribute("dealer", new DealerModel());
        return "addDealer";
    }

    @RequestMapping(value = "/dealer/add", method = RequestMethod.POST)
    private String addDealerSubmit(@ModelAttribute DealerModel dealer, Model model){
        dealerService.addDealer(dealer);
        model.addAttribute("judul", "Add Success");
        return "add";
    }

    @RequestMapping(value = "/dealer/view", method = RequestMethod.GET)
    private String view(@RequestParam(value = "dealerId", required = true) Long dealerId, Model model){
        DealerModel archiveDealer = dealerService.getDealerDetailById(dealerId).get();
        List<CarModel> archive = archiveDealer.getListCar();
        Collections.sort(archive);
        archiveDealer.setListCar(archive);
        model.addAttribute("dealer", archiveDealer);
        model.addAttribute("judul", "View Dealer");
        return "view-dealer";
    }

    @RequestMapping(value = "/dealer/viewall", method = RequestMethod.GET)
    private String viewAll(Model model){
        List<DealerModel> listDealer = dealerService.getAllDealer();
        model.addAttribute("listdealer", listDealer);
        model.addAttribute("judul", "View All Dealer");
        return "view-all-dealer";
    }*/

}
