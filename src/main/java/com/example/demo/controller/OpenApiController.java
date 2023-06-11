package com.example.demo.controller;

import com.example.demo.dto.atmospherepollution.ctprvnrltmmesurednsty.CtprvnRltmMesureDnsty;
import com.example.demo.dto.atmospherepollution.minudustfrcstdspth.MinuDustFrcstDspth;
import com.example.demo.dto.atmospherepollution.minudustweekfrcstdspth.MinuDustWeekFrcstDspth;
import com.example.demo.dto.atmospherepollution.msrstnacctorltmmesurednsty.MsrstnAcctoRltmMesureDnsty;
import com.example.demo.dto.atmospherepollution.ulfptcaalarminfo.UlfptcaAlarmInfo;
import com.example.demo.dto.atmospherepollution.unityairenvrnidexsnstiveabovemsrstnlist.UnityAirEnvrnIdexSnstiveAboveMsrstnList;
import com.example.demo.dto.hospital.hsptlbassinfoinqire.HsptlBassInfoInqire;
import com.example.demo.dto.hospital.hsptlmdcnclcinfoinqire.HsptlMdcncLcinfoInqire;
import com.example.demo.dto.hospital.hsptlmdcnclistinfoinqire.HsptlMdcncListInfoInqire;
import com.example.demo.dto.pharmacy.parmacybassinfoinqire.ParmacyBassInfoInqire;
import com.example.demo.dto.pharmacy.parmacylcinfoinqire.ParmacyLcinfoInqire;
import com.example.demo.dto.pharmacy.parmacylistinfoinqire.ParmacyListInfoInqire;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import java.io.IOException;
import java.util.*;

@Slf4j
@Controller
public class OpenApiController {

    private ObjectMapper objectMapper = new ObjectMapper();
    private String serviceKey = "lfsF1YUzjtqebNpyyoxGlj8MARFHn2khJCKvQ%2BkNy5fHubwsv5qRusS6Jr5zwjQBnf%2BdiknzBWkNxGIrqXXtLQ%3D%3D";

    @GetMapping("/openapi")
    public String openApiHome() {
        return "openapi";
    }

    @GetMapping("/openapi/samplemap")
    public String sampleMap() {
        return "sampleMap";
    }

    @GetMapping("/openapi/atmosphere/getulfptcaalarminfo")
    public String ulfptcaAlarmInfo(Model model) throws IOException {

        String url = "http://apis.data.go.kr/B552584/UlfptcaAlarmInqireSvc/getUlfptcaAlarmInfo";

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("serviceKey", serviceKey);
        paramMap.put("returnType", "json");
        paramMap.put("year", "2023");

        String jsonString = callOpenApiAndReturnString(url, paramMap, "GET", "JSON");

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        UlfptcaAlarmInfo jsonObject = objectMapper.readValue(jsonString, UlfptcaAlarmInfo.class);
        String jsonPrettyString = objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(jsonObject);

        model.addAttribute("rawData", jsonPrettyString);

        return "rawData";
    }

    @GetMapping("/openapi/atmosphere/getmsrstnacctorltmmesurednsty")
    public String msrstnAcctoRltmMesureDnsty(Model model) throws IOException {

        String url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMsrstnAcctoRltmMesureDnsty";

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("serviceKey", serviceKey);
        paramMap.put("returnType", "json");
        paramMap.put("stationName", URLEncoder.encode("종로구", "UTF-8"));
        paramMap.put("dataTerm", "DAILY");

        String jsonString = callOpenApiAndReturnString(url, paramMap, "GET", "JSON");

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        MsrstnAcctoRltmMesureDnsty jsonObject = objectMapper.readValue(jsonString, MsrstnAcctoRltmMesureDnsty.class);
        String jsonPrettyString = objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(jsonObject);

        model.addAttribute("rawData", jsonPrettyString);

        return "rawData";
    }

    @GetMapping("/openapi/atmosphere/getunityairenvrnidexsnstiveabovemsrstnlist")
    public String unityAirEnvrnIdexSnstiveAboveMsrstnList(Model model) throws IOException {

        String url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getUnityAirEnvrnIdexSnstiveAboveMsrstnList";

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("serviceKey", serviceKey);
        paramMap.put("returnType", "json");

        String jsonString = callOpenApiAndReturnString(url, paramMap, "GET", "JSON");

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        UnityAirEnvrnIdexSnstiveAboveMsrstnList jsonObject = objectMapper.readValue(jsonString, UnityAirEnvrnIdexSnstiveAboveMsrstnList.class);
        String jsonPrettyString = objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(jsonObject);

        model.addAttribute("rawData", jsonPrettyString);

        return "rawData";
    }

    @GetMapping("/openapi/atmosphere/getctprvnrltmmesurednsty")
    public String ctprvnRltmMesureDnsty(Model model) throws IOException {

        String url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty";

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("serviceKey", serviceKey);
        paramMap.put("returnType", "json");
        paramMap.put("sidoName", URLEncoder.encode("전국", "UTF-8"));

        String jsonString = callOpenApiAndReturnString(url, paramMap, "GET", "JSON");

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        CtprvnRltmMesureDnsty jsonObject = objectMapper.readValue(jsonString, CtprvnRltmMesureDnsty.class);
        String jsonPrettyString = objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(jsonObject);

        model.addAttribute("rawData", jsonPrettyString);

        return "rawData";
    }

    @GetMapping("/openapi/atmosphere/getminudustfrcstdspth")
    public String minuDustFrcstDspth(Model model) throws IOException {

        String url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMinuDustFrcstDspth";

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("serviceKey", serviceKey);
        paramMap.put("returnType", "json");

        String jsonString = callOpenApiAndReturnString(url, paramMap, "GET", "JSON");

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        MinuDustFrcstDspth jsonObject = objectMapper.readValue(jsonString, MinuDustFrcstDspth.class);
        String jsonPrettyString = objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(jsonObject);

        model.addAttribute("rawData", jsonPrettyString);

        return "rawData";
    }

    @GetMapping("/openapi/atmosphere/getminudustweekfrcstdspth")
    public String minuDustWeekFrcstDspth(Model model) throws IOException{

        String url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMinuDustWeekFrcstDspth";

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("serviceKey", serviceKey);
        paramMap.put("returnType", "json");

        String jsonString = callOpenApiAndReturnString(url, paramMap, "GET", "JSON");

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        MinuDustWeekFrcstDspth jsonObject = objectMapper.readValue(jsonString, MinuDustWeekFrcstDspth.class);
        String jsonPrettyString = objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(jsonObject);

        model.addAttribute("rawData", jsonPrettyString);

        return "rawData";
    }

    /**
     * 주소, 기관구분, 진료과목 등을 기준으로 진료시간 등의 병/의원 정보를 조회하는 병 의원 목록정보 조회기능 제공
     * @return String
     * @throws IOException
     */
    @GetMapping("/openapi/hospital/gethsptlmdcnclistinfoinqire")
    public String hsptlMdcncListInfoInqire(Model model) throws IOException {

        String url = "http://apis.data.go.kr/B552657/HsptlAsembySearchService/getHsptlMdcncListInfoInqire";

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("serviceKey", serviceKey);
        paramMap.put("Q0", URLEncoder.encode("서울특별시", "UTF-8"));
        paramMap.put("Q1", URLEncoder.encode("강남구", "UTF-8"));
        paramMap.put("QN", URLEncoder.encode("이비인", "UTF-8"));
        //paramMap.put("QZ", "B");
        //paramMap.put("QD", "D003");
        paramMap.put("numOfRows", "100");

        String jsonString = callOpenApiAndReturnString(url, paramMap, "GET", "XML");

        JSONObject json = XML.toJSONObject(jsonString);
        HsptlMdcncListInfoInqire jsonObject = objectMapper.readValue(json.toString(), HsptlMdcncListInfoInqire.class);
        String jsonPrettyString = objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(jsonObject);

        model.addAttribute("rawData", jsonPrettyString);

        return "rawData";
    }

    /**
     * 병/의원 위치정보 조회
     * @return
     * @throws IOException
     */
    @GetMapping("/openapi/hospital/gethsptlmdcnclcinfoinqire")
    public String hsptlMdcncLcinfoInqire(Model model) throws IOException{

        String url = "http://apis.data.go.kr/B552657/HsptlAsembySearchService/getHsptlMdcncLcinfoInqire";

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("serviceKey", serviceKey);
        //metlife tower latitude, longitude
        paramMap.put("WGS84_LAT", "37.503041");
        paramMap.put("WGS84_LON", "127.045502");

        String jsonString = callOpenApiAndReturnString(url, paramMap, "GET", "XML");

        JSONObject json = XML.toJSONObject(jsonString);
        HsptlMdcncLcinfoInqire jsonObject = objectMapper.readValue(json.toString(), HsptlMdcncLcinfoInqire.class);
        String jsonPrettyString = objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(jsonObject);

        model.addAttribute("rawData", jsonPrettyString);

        return "rawData";
    }

    /**
     * 병/의원별 기본정보 조회
     * @return
     * @throws IOException
     */
    @GetMapping("/openapi/hospital/gethsptlbassinfoinqire")
    public String hsptlBassInfoInqire(Model model) throws IOException{

        String url = "http://apis.data.go.kr/B552657/HsptlAsembySearchService/getHsptlBassInfoInqire";

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("serviceKey", serviceKey);
        paramMap.put("HPID", "A1124177"); //굿본재활의학과의원 A1124177

        String jsonString = callOpenApiAndReturnString(url, paramMap, "GET", "XML");

        JSONObject json = XML.toJSONObject(jsonString);
        HsptlBassInfoInqire jsonObject = objectMapper.readValue(json.toString(), HsptlBassInfoInqire.class);
        String jsonPrettyString = objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(jsonObject);

        model.addAttribute("rawData", jsonPrettyString);

        return "rawData";
    }



    @GetMapping("/openapi/pharmacy/getparmacylistinfoinqire")
    public String parmacyListInfoInqire(Model model) throws IOException {

        String url = "http://apis.data.go.kr/B552657/ErmctInsttInfoInqireService/getParmacyListInfoInqire";

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("serviceKey", serviceKey);
        paramMap.put("Q0", URLEncoder.encode("서울특별시", "UTF-8"));
        paramMap.put("Q1", URLEncoder.encode("강남구", "UTF-8"));

        String jsonString = callOpenApiAndReturnString(url, paramMap, "GET", "XML");

        JSONObject json = XML.toJSONObject(jsonString);
        ParmacyListInfoInqire jsonObject = objectMapper.readValue(json.toString(), ParmacyListInfoInqire.class);
        String jsonPrettyString = objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(jsonObject);

        model.addAttribute("rawData", jsonPrettyString);

        return "rawData";
    }

    @GetMapping("/openapi/pharmacy/getparmacylcinfoinqire")
    public String parmacyLcinfoInqire(Model model) throws IOException {

        String url = "http://apis.data.go.kr/B552657/ErmctInsttInfoInqireService/getParmacyLcinfoInqire";

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("serviceKey", serviceKey);
        //metlife tower latitude, longitude
        paramMap.put("WGS84_LAT", "37.503041");
        paramMap.put("WGS84_LON", "127.045502");

        String jsonString = callOpenApiAndReturnString(url, paramMap, "GET", "XML");

        JSONObject json = XML.toJSONObject(jsonString);
        ParmacyLcinfoInqire jsonObject = objectMapper.readValue(json.toString(), ParmacyLcinfoInqire.class);
        String jsonPrettyString = objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(jsonObject);

        model.addAttribute("rawData", jsonPrettyString);

        return "rawData";
    }

    @GetMapping("/openapi/pharmacy/getparmacybassinfoinqire")
    public String parmacyBassInfoInqire(Model model) throws IOException {

        String url = "http://apis.data.go.kr/B552657/ErmctInsttInfoInqireService/getParmacyBassInfoInqire";

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("serviceKey", serviceKey);
        paramMap.put("HPID", "C1108328"); //누리약국 C1108328

        String jsonString = callOpenApiAndReturnString(url, paramMap, "GET", "XML");

        JSONObject json = XML.toJSONObject(jsonString);
        ParmacyBassInfoInqire jsonObject = objectMapper.readValue(json.toString(), ParmacyBassInfoInqire.class);
        String jsonPrettyString = objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(jsonObject);

        model.addAttribute("rawData", jsonPrettyString);

        return "rawData";
    }

    /**
     *
     * @param paramUrl url
     * @param paramMap queryParameter
     * @param httpMethodType GET, POST, PUT ...
     * @param messageType JSON, XML
     * @return String
     * @throws IOException
     */
    public static String callOpenApiAndReturnString(String paramUrl, Map<String, String> paramMap, String httpMethodType, String messageType) throws IOException{
        StringBuilder urlBuilder = new StringBuilder(paramUrl);
        if (!paramMap.isEmpty()) {
            urlBuilder.append("?");

            Set<String> keySet = paramMap.keySet();
            Iterator<String> keyIterator = keySet.iterator();

            while (keyIterator.hasNext()) {
                String key = keyIterator.next();
                String value = paramMap.get(key);
                urlBuilder.append(URLEncoder.encode(key,"UTF-8") + "=" + value);
                urlBuilder.append("&");
            }
            urlBuilder.deleteCharAt(urlBuilder.toString().length()-1); //마지막에 붙은 & 제거
        }
        log.info("url={}", urlBuilder.toString());

        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        if (httpMethodType.equalsIgnoreCase("GET"))
            conn.setRequestMethod("GET");

        if (messageType.equalsIgnoreCase("JSON"))
            conn.setRequestProperty("Content-type", "application/json");

        log.info("Response code={}", conn.getResponseCode());

        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "UTF-8"));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();

        return sb.toString();
    }

}
