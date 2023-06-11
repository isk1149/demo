package com.example.demo.controller;

import com.example.demo.dto.atmospherepollution.msrstnacctorltmmesurednsty.MsrstnAcctoRltmMesureDnstyItem;
import com.example.demo.dto.hospital.hsptlmdcnclistinfoinqire.HsptlMdcncListInfoInqire;
import com.example.demo.dto.pharmacy.parmacylistinfoinqire.ParmacyListInfoInqire;
import com.example.demo.service.AtmosphereService;
import com.example.demo.service.DistanceService;
import com.example.demo.service.HospitalService;
import com.example.demo.service.PharmacyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class HomeController {
    @Autowired
    private AtmosphereService atmosphereService;
    @Autowired
    private HospitalService hospitalService;
    @Autowired
    private DistanceService distanceService;
    @Autowired
    private PharmacyService pharmacyService;

    @GetMapping("/")
    public String home(Model model) throws Exception {
        log.debug("home controller");
        log.info("home controller");

        MsrstnAcctoRltmMesureDnstyItem atmosphere = atmosphereService.getMsrstnAcctoRltmMesureDnstyItem();
        log.info("atmosphere={}", atmosphere.getStationName() + "/" + atmosphere.getPm10Value() + "/" + atmosphere.getPm25Grade());

        HsptlMdcncListInfoInqire hospital1 = hospitalService.getHsptlMdcncListInfoInqire();
        log.info("hospital1={}", hospital1.getResponse().getBody().getItems().getItem().get(0).toString());
        hospitalService.getHsptlMdcncListInfoInqireMap();
        distanceService.hospitalDistanceList(hospital1);

        ParmacyListInfoInqire pharmacy1 = pharmacyService.getParmacyListInfoInqire();
        log.info("pharmacy1={}", pharmacy1.getResponse().getBody().getItems().getItem().get(0).toString());
        pharmacyService.getParmacyListInfoInqireMap();
        distanceService.pharmacyDistanceList(pharmacy1);

        model.addAttribute("atmosphereObject", atmosphere);
        /*
        PM10 등급은 ~50은 좋음, 51~100은 보통, 101~은 나쁨
        PM2.5등급은 ~15는 좋음, 16~35는 보통, 36~는 나쁨
         */


/*        HsptlMdcncLcinfoInqire hospital2 = hospitalService.getHsptlMdcncLcinfoInqire();
        log.info("hospital2={}", hospital2.getResponse().getBody().getItems().getItem().get(0).toString());

        HsptlBassInfoInqire hospital3 = hospitalService.getHsptlBassInfoInqire(hospital2.getResponse().getBody().getItems().getItem().get(0).getHpid());
        log.info("hospital3={}", hospital3.getResponse().getBody().getItems().getItem().toString());*/

        return "home";
    }
}
