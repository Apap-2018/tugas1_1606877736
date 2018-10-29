package com.apap.tugas1.controller;

import com.apap.tugas1.model.InstansiModel;
import com.apap.tugas1.model.JabatanModel;
import com.apap.tugas1.model.JabatanPegawaiModel;
import com.apap.tugas1.model.PegawaiModel;
import com.apap.tugas1.service.InstansiService;
import com.apap.tugas1.service.PegawaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PegawaiController {
    @Autowired
    private PegawaiService pegawaiService;

    @Autowired
    private InstansiService instansiService;

    @RequestMapping(value = "/pegawai", method = RequestMethod.GET)
    private String viewPegawai(@RequestParam(value = "nip", required = true) String nip, Model model){
        PegawaiModel archive = pegawaiService.getPegawaiByNip(nip);
        List<JabatanModel> lstJab = pegawaiService.getListJabatan(archive);
        Double gaji = 0.0;
        for(JabatanModel jabatan : lstJab){
            if(jabatan.getGaji_pokok() > gaji){
                gaji = jabatan.getGaji_pokok();
            }
        }
        InstansiModel instansi = archive.getInstansi();
        int gajiBersih = (int) (gaji + ((instansi.getProvinsi().getPresentaseTunjangan()/100) * gaji));

        model.addAttribute("judul", "View Pegawai");
        model.addAttribute("pegawai", archive);
        model.addAttribute("listJabatan", lstJab);
        model.addAttribute("gajiBersih", gajiBersih);
        return "view-pegawai";
    }

    /*@RequestMapping(value = "/car/add", params={"addRow"})
    private String addRow(@ModelAttribute DealerModel dealer, Model model){
        CarModel car = new CarModel();
        car.setDealer(dealer);
        List<CarModel> newList = dealer.getListCar();
        if(newList == null) {
            newList = new ArrayList<CarModel>();
            newList.add(car);
        }else{
            newList.add(car);
        }
        dealer.setListCar(newList);

        model.addAttribute("dealer", dealer);
        model.addAttribute("judul", "Add Car");
        return "addCar";
    }

    @RequestMapping(value= "/car/add", params={"removeRow"})
    private String removeRow(@ModelAttribute DealerModel dealer, final HttpServletRequest req, Model model){
        final Integer rowId = Integer.valueOf(req.getParameter("removeRow"));
        dealer.getListCar().remove(rowId.intValue());
        model.addAttribute("dealer", dealer);
        model.addAttribute("judul", "Add Car");
        return "addCar";
    }

    @RequestMapping(value = "/car/add", method = RequestMethod.POST)
    private String addCarSubmit(@ModelAttribute DealerModel dealer, Model model){
        for(CarModel car : dealer.getListCar()){
            car.setDealer(dealerService.getDealerDetailById(dealer.getId()).get());
            carService.addCar(car);
        }
        model.addAttribute("judul", "Add Success");
        return "add";
    }

    @RequestMapping(value = "/car/delete", method = RequestMethod.POST)
    private String delete(@ModelAttribute DealerModel dealer, Model model){
        for (CarModel car : dealer.getListCar()){
            carService.deleteCar(car);
        }
        model.addAttribute("judul", "Delete Success");
        return "delete";
    }

    @RequestMapping(value = "/car/update/{carId}", method = RequestMethod.GET)
    private String update(@PathVariable(value = "carId") Long carId, Model model){
        CarModel archive = carService.getCarById(carId).get();
        model.addAttribute("newCar", new CarModel());
        model.addAttribute("car", archive);
        model.addAttribute("judul", "Update Car");
        return "updateCar";
    }

    @RequestMapping(value = "/car/update/{carId}", method = RequestMethod.POST)
    private String updateSubmit(@PathVariable(value = "carId") Long carId, @ModelAttribute CarModel newCar, Model model){
        carService.updateCar(carId,newCar);
        model.addAttribute("judul", "Update Success");
        return "update";
    }*/

}
