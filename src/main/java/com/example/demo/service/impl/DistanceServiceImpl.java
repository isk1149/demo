package com.example.demo.service.impl;

import com.example.demo.dto.distance.LatLng;
import com.example.demo.dto.hospital.hsptlmdcnclistinfoinqire.HsptlMdcncListInfoInqire;
import com.example.demo.dto.hospital.hsptlmdcnclistinfoinqire.HsptlMdcncListInfoInqireItem;
import com.example.demo.dto.pharmacy.parmacylistinfoinqire.ParmacyListInfoInqire;
import com.example.demo.dto.pharmacy.parmacylistinfoinqire.ParmacyListInfoInqireItem;
import com.example.demo.service.DistanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@Service
public class DistanceServiceImpl implements DistanceService {
    //metlife tower lattitude, longitude
    private double currentLatitude = 37.503041;
    private double currentLongitude = 127.045502;

    public List<LatLng> hospitalLatLngs;
    public List<LatLng> pharmacyLatLngs;

    @Override
    public List<LatLng> hospitalDistanceList(HsptlMdcncListInfoInqire hospitals) {

        if (hospitalLatLngs != null) return hospitalLatLngs;

        // Define the list of latitudes and longitudes to sort.
//        List<LatLng> latLngs = Arrays.asList(
//                new LatLng(1, 37.7, -122.4), // 미국
//                new LatLng(2, 37.504514, 127.048979), // 선릉역
//                new LatLng(3, 37.491211, 127.101767), //수서초등학교
//                new LatLng(4, 37.506311, 127.024757) //신논현역
//        );
        hospitalLatLngs = new ArrayList<>();
        List<HsptlMdcncListInfoInqireItem> item = hospitals.getResponse().getBody().getItems().getItem();
        LatLng metLatLng = new LatLng("metlife", 37.503041, 127.045502);
        for (int i = 0; i < item.size(); i++) {
            hospitalLatLngs.add(new LatLng(item.get(i).getHpid(), item.get(i).getWgs84Lat(), item.get(i).getWgs84Lon()));
            item.get(i).setDistance(Math.round(hospitalLatLngs.get(i).distanceTo(metLatLng)*100)/100.0);
        }

        // Sort the list by the shortest distance to the current latitude and longitude.
        Collections.sort(hospitalLatLngs, (latLng1, latLng2) -> {
            double distance1 = haversine(latLng1.getLatitude(), latLng1.getLongitude(), currentLatitude, currentLongitude);
            double distance2 = haversine(latLng2.getLatitude(), latLng2.getLongitude(), currentLatitude, currentLongitude);
            return Double.compare(distance1, distance2);
        });

        log.info("latLngs.size={}", hospitalLatLngs.size());
        log.info("item.distance={}", item.get(0).getDutyTel1() + "/ " + item.get(0).getDistance());
        //log.info("latLngs.get(0)={}", latLngs.get(0).getHpid() + "/" + latLngs.get(0).getLatitude() + "/" + latLngs.get(0).getLongitude());

        return hospitalLatLngs;
    }

    @Override
    public List<LatLng> pharmacyDistanceList(ParmacyListInfoInqire pharmacies) {

        if (pharmacyLatLngs != null) return pharmacyLatLngs;

        pharmacyLatLngs = new ArrayList<>();
        List<ParmacyListInfoInqireItem> item = pharmacies.getResponse().getBody().getItems().getItem();
        LatLng metLatLng = new LatLng("metlife", 37.503041, 127.045502);
        for (int i = 0; i < item.size(); i++) {
            pharmacyLatLngs.add(new LatLng(item.get(i).getHpid(), item.get(i).getWgs84Lat(), item.get(i).getWgs84Lon()));
            item.get(i).setDistance(Math.round(pharmacyLatLngs.get(i).distanceTo(metLatLng)*100)/100.0);
        }

        // Sort the list by the shortest distance to the current latitude and longitude.
        Collections.sort(pharmacyLatLngs, (latLng1, latLng2) -> {
            double distance1 = haversine(latLng1.getLatitude(), latLng1.getLongitude(), currentLatitude, currentLongitude);
            double distance2 = haversine(latLng2.getLatitude(), latLng2.getLongitude(), currentLatitude, currentLongitude);
            return Double.compare(distance1, distance2);
        });

        log.info("latLngs.size={}", pharmacyLatLngs.size());
        log.info("item.distance={}", item.get(0).getDutyTel1() + "/ " + item.get(0).getDistance());
        //log.info("latLngs.get(0)={}", latLngs.get(0).getHpid() + "/" + latLngs.get(0).getLatitude() + "/" + latLngs.get(0).getLongitude());

        return pharmacyLatLngs;
    }

    private static double haversine(double lat1, double lon1, double lat2, double lon2) {
        double R = 6371; // Earth's radius in kilometers.
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }

}
