package com.example.demo.service.impl;

import com.example.demo.controller.OpenApiController;
import com.example.demo.dto.atmospherepollution.msrstnacctorltmmesurednsty.MsrstnAcctoRltmMesureDnsty;
import com.example.demo.dto.atmospherepollution.msrstnacctorltmmesurednsty.MsrstnAcctoRltmMesureDnstyItem;
import com.example.demo.dto.hospital.hsptlmdcnclistinfoinqire.HsptlMdcncListInfoInqire;
import com.example.demo.service.AtmosphereService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.apache.bcel.classfile.Module;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class AtmosphereServiceImpl implements AtmosphereService {
    private ObjectMapper objectMapper = new ObjectMapper();
    private String serviceKey = "lfsF1YUzjtqebNpyyoxGlj8MARFHn2khJCKvQ%2BkNy5fHubwsv5qRusS6Jr5zwjQBnf%2BdiknzBWkNxGIrqXXtLQ%3D%3D";

    public MsrstnAcctoRltmMesureDnsty atmosphere1;

    @Override
    public MsrstnAcctoRltmMesureDnstyItem getMsrstnAcctoRltmMesureDnstyItem() throws Exception {

        //if (atmosphere1 != null) return atmosphere1.getResponse().getBody().getItems().get(0);

        String url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMsrstnAcctoRltmMesureDnsty";

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("serviceKey", serviceKey);
        paramMap.put("returnType", "json");
        paramMap.put("stationName", URLEncoder.encode("강남구", "UTF-8"));
        paramMap.put("dataTerm", "DAILY");
        paramMap.put("ver", "1.4");

        String jsonString = OpenApiController.callOpenApiAndReturnString(url, paramMap, "GET", "JSON");

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        atmosphere1 = objectMapper.readValue(jsonString, MsrstnAcctoRltmMesureDnsty.class);

        return atmosphere1.getResponse().getBody().getItems().get(0);
    }
}
