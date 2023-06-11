package com.example.demo.service;

import com.example.demo.dto.distance.LatLng;
import com.example.demo.dto.hospital.hsptlmdcnclistinfoinqire.HsptlMdcncListInfoInqire;
import com.example.demo.dto.pharmacy.parmacylistinfoinqire.ParmacyListInfoInqire;

import java.util.List;

public interface DistanceService {
    List<LatLng> hospitalDistanceList(HsptlMdcncListInfoInqire hospitals);
    List<LatLng> pharmacyDistanceList(ParmacyListInfoInqire pharmacies);
}
