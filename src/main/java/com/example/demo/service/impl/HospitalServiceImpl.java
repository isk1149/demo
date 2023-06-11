package com.example.demo.service.impl;

import com.example.demo.controller.OpenApiController;
import com.example.demo.dto.hospital.hsptlbassinfoinqire.HsptlBassInfoInqire;
import com.example.demo.dto.hospital.hsptlmdcnclcinfoinqire.HsptlMdcncLcinfoInqire;
import com.example.demo.dto.hospital.hsptlmdcnclistinfoinqire.HsptlMdcncListInfoInqire;
import com.example.demo.dto.hospital.hsptlmdcnclistinfoinqire.HsptlMdcncListInfoInqireItem;
import com.example.demo.service.HospitalService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class HospitalServiceImpl implements HospitalService {
    private ObjectMapper objectMapper = new ObjectMapper();
    private String serviceKey = "lfsF1YUzjtqebNpyyoxGlj8MARFHn2khJCKvQ%2BkNy5fHubwsv5qRusS6Jr5zwjQBnf%2BdiknzBWkNxGIrqXXtLQ%3D%3D";

    public HsptlMdcncListInfoInqire hospital1;
    public Map<String, HsptlMdcncListInfoInqireItem> hospitalMap;
    public HsptlMdcncLcinfoInqire hospital2;
    public HsptlBassInfoInqire hospital3;

    @Override
    public HsptlMdcncListInfoInqire getHsptlMdcncListInfoInqire() throws Exception {

        if (hospital1 != null) return hospital1;

        String url = "http://apis.data.go.kr/B552657/HsptlAsembySearchService/getHsptlMdcncListInfoInqire";

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("serviceKey", serviceKey);
        paramMap.put("Q0", URLEncoder.encode("서울특별시", "UTF-8"));
        paramMap.put("Q1", URLEncoder.encode("강남구", "UTF-8"));
        paramMap.put("QN", URLEncoder.encode("이비인", "UTF-8"));
        //paramMap.put("QZ", "C"); //의원
        //paramMap.put("QD", "D003");
        paramMap.put("numOfRows", "100");

        String jsonString = OpenApiController.callOpenApiAndReturnString(url, paramMap, "GET", "XML");

        JSONObject json = XML.toJSONObject(jsonString);
        hospital1 = objectMapper.readValue(json.toString(), HsptlMdcncListInfoInqire.class);

        return hospital1;
    }

    @Override
    public Map<String, HsptlMdcncListInfoInqireItem> getHsptlMdcncListInfoInqireMap() throws Exception {

        if (hospitalMap != null) return hospitalMap;

        hospitalMap = new HashMap<>();

        List<HsptlMdcncListInfoInqireItem> items = hospital1.getResponse().getBody().getItems().getItem();
        for (int i = 0; i < items.size(); i++) {
            hospitalMap.put(items.get(i).getHpid(), items.get(i));
        }

        log.info("hospitalMap={}", hospitalMap.size());

        return hospitalMap;
    }

    @Override
    public HsptlMdcncLcinfoInqire getHsptlMdcncLcinfoInqire() throws Exception {

        if (hospital2 != null) return hospital2;

        String url = "http://apis.data.go.kr/B552657/HsptlAsembySearchService/getHsptlMdcncLcinfoInqire";

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("serviceKey", serviceKey);
        //metlife tower latitude, longitude
        paramMap.put("WGS84_LAT", "37.503041");
        paramMap.put("WGS84_LON", "127.045502");

        String jsonString = OpenApiController.callOpenApiAndReturnString(url, paramMap, "GET", "XML");

        JSONObject json = XML.toJSONObject(jsonString);
        hospital2 = objectMapper.readValue(json.toString(), HsptlMdcncLcinfoInqire.class);

        return hospital2;
    }

    @Override
    public HsptlBassInfoInqire getHsptlBassInfoInqire(String hpid) throws Exception {

        if (hospital3 != null) return hospital3;

        String url = "http://apis.data.go.kr/B552657/HsptlAsembySearchService/getHsptlBassInfoInqire";

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("serviceKey", serviceKey);
        paramMap.put("HPID", hpid); //굿본재활의학과의원 A1124177

        String jsonString = OpenApiController.callOpenApiAndReturnString(url, paramMap, "GET", "XML");

        JSONObject json = XML.toJSONObject(jsonString);
        hospital3 = objectMapper.readValue(json.toString(), HsptlBassInfoInqire.class);

        return hospital3;
    }
}
