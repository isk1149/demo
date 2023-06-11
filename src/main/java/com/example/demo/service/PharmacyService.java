package com.example.demo.service;

import com.example.demo.dto.pharmacy.parmacylistinfoinqire.ParmacyListInfoInqire;
import com.example.demo.dto.pharmacy.parmacylistinfoinqire.ParmacyListInfoInqireItem;

import java.util.Map;

public interface PharmacyService {
    ParmacyListInfoInqire getParmacyListInfoInqire() throws Exception;
    Map<String, ParmacyListInfoInqireItem> getParmacyListInfoInqireMap() throws Exception;
}
