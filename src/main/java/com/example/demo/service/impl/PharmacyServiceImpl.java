package com.example.demo.service.impl;

import com.example.demo.controller.OpenApiController;
import com.example.demo.dto.pharmacy.parmacylistinfoinqire.ParmacyListInfoInqire;
import com.example.demo.dto.pharmacy.parmacylistinfoinqire.ParmacyListInfoInqireItem;
import com.example.demo.service.PharmacyService;
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
public class PharmacyServiceImpl implements PharmacyService {
    private ObjectMapper objectMapper = new ObjectMapper();
    private String serviceKey = "lfsF1YUzjtqebNpyyoxGlj8MARFHn2khJCKvQ%2BkNy5fHubwsv5qRusS6Jr5zwjQBnf%2BdiknzBWkNxGIrqXXtLQ%3D%3D";

    public ParmacyListInfoInqire pharmacy1;
    public Map<String, ParmacyListInfoInqireItem> pharmacyMap;

    @Override
    public ParmacyListInfoInqire getParmacyListInfoInqire() throws Exception {
        if (pharmacy1 != null) return pharmacy1;

        String url = "http://apis.data.go.kr/B552657/ErmctInsttInfoInqireService/getParmacyListInfoInqire";

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("serviceKey", serviceKey);
        paramMap.put("Q0", URLEncoder.encode("서울특별시", "UTF-8"));
        paramMap.put("Q1", URLEncoder.encode("강남구", "UTF-8"));
        paramMap.put("numOfRows", "500");

        String jsonString = OpenApiController.callOpenApiAndReturnString(url, paramMap, "GET", "XML");

        JSONObject json = XML.toJSONObject(jsonString);
        pharmacy1 = objectMapper.readValue(json.toString(), ParmacyListInfoInqire.class);

        return pharmacy1;
    }

    @Override
    public Map<String, ParmacyListInfoInqireItem> getParmacyListInfoInqireMap() throws Exception {
        if (pharmacyMap != null) return pharmacyMap;

        pharmacyMap = new HashMap<>();

        List<ParmacyListInfoInqireItem> items = pharmacy1.getResponse().getBody().getItems().getItem();
        for (int i = 0; i < items.size(); i++) {
            pharmacyMap.put(items.get(i).getHpid(), items.get(i));
        }

        log.info("pharmacyMap={}", pharmacyMap.size());

        return pharmacyMap;
    }
}
