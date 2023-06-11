package com.example.demo.controller;

import com.example.demo.dto.DayName;
import com.example.demo.dto.distance.LatLng;
import com.example.demo.dto.hospital.hsptlmdcnclistinfoinqire.HsptlMdcncListInfoInqireItem;
import com.example.demo.dto.pharmacy.parmacylistinfoinqire.ParmacyListInfoInqireItem;
import com.example.demo.service.DistanceService;
import com.example.demo.service.HospitalService;
import com.example.demo.service.PharmacyService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Slf4j
@Controller
public class HackathonController {
    //metlife tower latitude, longitude
    private double metLatitude = 37.503041;
    private double metLongitude = 127.045502;

    @Autowired
    private HospitalService hospitalService;
    @Autowired
    private DistanceService distanceService;
    @Autowired
    private PharmacyService pharmacyService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/hackathon/hospitals")
    public String hospitalList(@RequestParam(required = false) Double latitude,
                       @RequestParam(required = false) Double longitude,
                       @RequestParam(required = false, defaultValue = "Metlife Korea") String dutyName,
                       Model model) throws Exception {

        Map<String, HsptlMdcncListInfoInqireItem> hospitalMap = hospitalService.getHsptlMdcncListInfoInqireMap();
        List<LatLng> latLngs = distanceService.hospitalDistanceList(hospitalService.getHsptlMdcncListInfoInqire());
        List<HsptlMdcncListInfoInqireItem> hospitals = new ArrayList<>();

        for (int i = 0; i < hospitalMap.size(); i++) {
            hospitals.add(hospitalMap.get(latLngs.get(i).getHpid()));
        }
        log.info("hospitals.size={}", hospitals.size());

        model.addAttribute("hospitals", hospitals);
        model.addAttribute("dayName", DayName.getDayName().toUpperCase());

        if (latitude == null) {
            log.info("metLatitude={}", metLatitude);
            model.addAttribute("latitude", metLatitude);
        }
        else {
            log.info("latitude={}", latitude);
            model.addAttribute("latitude", latitude);
        }

        if (longitude == null) {
            log.info("metlongitude={}", metLongitude);
            model.addAttribute("longitude", metLongitude);
        }
        else {
            log.info("longitude={}", longitude);
            model.addAttribute("longitude", longitude);
        }

        if (dutyName == null) {
            log.info("dutyName={}", dutyName);
            model.addAttribute("dutyName", dutyName);
        }
        else {
            log.info("dutyName={}", dutyName);
            model.addAttribute("dutyName", dutyName);
        }

        return "hospitalList";
    }

    @GetMapping("/hackathon/pharmacies")
    public String pharmacyList(@RequestParam(required = false) Double latitude,
                       @RequestParam(required = false) Double longitude,
                       @RequestParam(required = false, defaultValue = "Metlife Korea") String dutyName,
                       Model model) throws Exception {

        Map<String, ParmacyListInfoInqireItem> pharmacyMap = pharmacyService.getParmacyListInfoInqireMap();
        List<LatLng> latLngs = distanceService.pharmacyDistanceList(pharmacyService.getParmacyListInfoInqire());
        List<ParmacyListInfoInqireItem> pharmacies = new ArrayList<>();

        for (int i = 0; i < pharmacyMap.size(); i++) {
            pharmacies.add(pharmacyMap.get(latLngs.get(i).getHpid()));
        }
        log.info("pharmacies.size={}", pharmacies.size());

        model.addAttribute("pharmacies", pharmacies);
        model.addAttribute("dayName", DayName.getDayName().toUpperCase());

        if (latitude == null) {
            log.info("metLatitude={}", metLatitude);
            model.addAttribute("latitude", metLatitude);
        }
        else {
            log.info("latitude={}", latitude);
            model.addAttribute("latitude", latitude);
        }

        if (longitude == null) {
            log.info("metlongitude={}", metLongitude);
            model.addAttribute("longitude", metLongitude);
        }
        else {
            log.info("longitude={}", longitude);
            model.addAttribute("longitude", longitude);
        }

        if (dutyName == null) {
            log.info("dutyName={}", dutyName);
            model.addAttribute("dutyName", dutyName);
        }
        else {
            log.info("dutyName={}", dutyName);
            model.addAttribute("dutyName", dutyName);
        }

        return "pharmacyList";
    }
}
