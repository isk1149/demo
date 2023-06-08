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

    @ResponseBody
    @GetMapping("/getUlfptcaAlarmInfo")
    public String ulfptcaAlarmInfo() throws IOException {

        String url = "http://apis.data.go.kr/B552584/UlfptcaAlarmInqireSvc/getUlfptcaAlarmInfo";

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("serviceKey", serviceKey);
        paramMap.put("returnType", URLEncoder.encode("json", "UTF-8"));
        paramMap.put("year", URLEncoder.encode("2023", "UTF-8"));

        //UlfptcaAlarmInfo jsonObject = new UlfptcaAlarmInfo();
        //String jsonString = openApiCallJsonStringReturn(url, paramMap, jsonObject, UlfptcaAlarmInfo.class);
        String jsonString = callOpenApiAndReturnString(url, paramMap, "GET", "JSON");

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        UlfptcaAlarmInfo jsonObject = objectMapper.readValue(jsonString, UlfptcaAlarmInfo.class);
        String jsonPrettyString = objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(jsonObject);

        return jsonPrettyString;
    }

    @ResponseBody
    @GetMapping("/getMsrstnAcctoRltmMesureDnsty")
    public String msrstnAcctoRltmMesureDnsty() throws IOException {

        String url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMsrstnAcctoRltmMesureDnsty";

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("serviceKey", serviceKey);
        paramMap.put("returnType", URLEncoder.encode("json", "UTF-8"));
        paramMap.put("stationName", URLEncoder.encode("종로구", "UTF-8"));
        paramMap.put("dataTerm", URLEncoder.encode("DAILY", "UTF-8"));

        //MsrstnAcctoRltmMesureDnsty jsonObject = new MsrstnAcctoRltmMesureDnsty();
        //String jsonString = openApiCallJsonStringReturn(url, paramMap, jsonObject, MsrstnAcctoRltmMesureDnsty.class);
        String jsonString = callOpenApiAndReturnString(url, paramMap, "GET", "JSON");

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        MsrstnAcctoRltmMesureDnsty jsonObject = objectMapper.readValue(jsonString, MsrstnAcctoRltmMesureDnsty.class);
        String jsonPrettyString = objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(jsonObject);

        return jsonPrettyString;
    }

    @ResponseBody
    @GetMapping("/getUnityAirEnvrnIdexSnstiveAboveMsrstnList")
    public String unityAirEnvrnIdexSnstiveAboveMsrstnList() throws IOException {

        String url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getUnityAirEnvrnIdexSnstiveAboveMsrstnList";

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("serviceKey", serviceKey);
        paramMap.put("returnType", URLEncoder.encode("json", "UTF-8"));

        //UnityAirEnvrnIdexSnstiveAboveMsrstnList jsonObject = new UnityAirEnvrnIdexSnstiveAboveMsrstnList();
        //String jsonString = openApiCallJsonStringReturn(url, paramMap, jsonObject, UnityAirEnvrnIdexSnstiveAboveMsrstnList.class);
        String jsonString = callOpenApiAndReturnString(url, paramMap, "GET", "JSON");

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        UnityAirEnvrnIdexSnstiveAboveMsrstnList jsonObject = objectMapper.readValue(jsonString, UnityAirEnvrnIdexSnstiveAboveMsrstnList.class);
        String jsonPrettyString = objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(jsonObject);

        return jsonPrettyString;
    }

    @ResponseBody
    @GetMapping("/getCtprvnRltmMesureDnsty")
    public String ctprvnRltmMesureDnsty() throws IOException {

        String url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty";

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("serviceKey", serviceKey);
        paramMap.put("returnType", URLEncoder.encode("json", "UTF-8"));
        paramMap.put("sidoName", URLEncoder.encode("전국", "UTF-8"));

        String jsonString = callOpenApiAndReturnString(url, paramMap, "GET", "JSON");

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        CtprvnRltmMesureDnsty jsonObject = objectMapper.readValue(jsonString, CtprvnRltmMesureDnsty.class);
        String jsonPrettyString = objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(jsonObject);

        return jsonPrettyString;
    }

    @ResponseBody
    @GetMapping("/getMinuDustFrcstDspth")
    public String minuDustFrcstDspth() throws IOException {

        String url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMinuDustFrcstDspth";

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("serviceKey", serviceKey);
        paramMap.put("returnType", URLEncoder.encode("json", "UTF-8"));

        //MinuDustFrcstDspth jsonObject = new MinuDustFrcstDspth();
        //String jsonString = openApiCallJsonStringReturn(url, paramMap, jsonObject, MinuDustFrcstDspth.class);
        String jsonString = callOpenApiAndReturnString(url, paramMap, "GET", "JSON");

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        MinuDustFrcstDspth jsonObject = objectMapper.readValue(jsonString, MinuDustFrcstDspth.class);
        String jsonPrettyString = objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(jsonObject);

        return jsonPrettyString;
    }

    @ResponseBody
    @GetMapping("/getMinuDustWeekFrcstDspth")
    public String minuDustWeekFrcstDspth() throws IOException{

        String url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMinuDustWeekFrcstDspth";

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("serviceKey", serviceKey);
        paramMap.put("returnType", URLEncoder.encode("json", "UTF-8"));

        //MinuDustWeekFrcstDspth jsonObject = new MinuDustWeekFrcstDspth();
        //String jsonString = openApiCallJsonStringReturn(url, paramMap, jsonObject, MinuDustWeekFrcstDspth.class);
        String jsonString = callOpenApiAndReturnString(url, paramMap, "GET", "JSON");

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        MinuDustWeekFrcstDspth jsonObject = objectMapper.readValue(jsonString, MinuDustWeekFrcstDspth.class);
        String jsonPrettyString = objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(jsonObject);

        return jsonPrettyString;
    }

    /**
     * 주소, 기관구분, 진료과목 등을 기준으로 진료시간 등의 병/의원 정보를 조회하는 병 의원 목록정보 조회기능 제공
     * @return String
     * @throws IOException
     */
    @ResponseBody
    @GetMapping("/getHsptlMdcncListInfoInqire")
    public String hsptlMdcncListInfoInqire() throws IOException {

        String url = "http://apis.data.go.kr/B552657/HsptlAsembySearchService/getHsptlMdcncListInfoInqire";

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("serviceKey", serviceKey);
        paramMap.put("Q0", URLEncoder.encode("서울특별시", "UTF-8"));
        paramMap.put("Q1", URLEncoder.encode("강남구", "UTF-8"));
        paramMap.put("Q2", URLEncoder.encode("B", "UTF-8"));

        //StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552657/HsptlAsembySearchService/getHsptlMdcncListInfoInqire"); /*URL*/
        //urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + serviceKey); /*Service Key*/
        //urlBuilder.append("&" + URLEncoder.encode("Q0","UTF-8") + "=" + URLEncoder.encode("서울특별시", "UTF-8")); /*주소(시도)*/
        //urlBuilder.append("&" + URLEncoder.encode("Q1","UTF-8") + "=" + URLEncoder.encode("강남구", "UTF-8")); /*주소(시군구)*/
        //urlBuilder.append("&" + URLEncoder.encode("QZ","UTF-8") + "=" + URLEncoder.encode("B", "UTF-8")); /*CODE_MST의'H000' 참조(B:병원, C:의원)*/
        //log.info("url={}", urlBuilder.toString());

        String jsonString = callOpenApiAndReturnString(url, paramMap, "GET", "XML");

        /*URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
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
        conn.disconnect();*/

        JSONObject json = XML.toJSONObject(jsonString);
        HsptlMdcncListInfoInqire jsonObject = objectMapper.readValue(json.toString(), HsptlMdcncListInfoInqire.class);
        String jsonPrettyString = objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(jsonObject);

        return jsonPrettyString;
    }

    /**
     * 병/의원 위치정보 조회
     * @return
     * @throws IOException
     */
    @ResponseBody
    @GetMapping("/getHsptlMdcncLcinfoInqire")
    public String hsptlMdcncLcinfoInqire() throws IOException{

        String url = "http://apis.data.go.kr/B552657/HsptlAsembySearchService/getHsptlMdcncLcinfoInqire";

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("serviceKey", serviceKey);
        paramMap.put("WGS84_LAT", URLEncoder.encode("37.538034", "UTF-8"));
        paramMap.put("WGS84_LON", URLEncoder.encode("127.048523", "UTF-8"));
        //paramMap.put("Q2", URLEncoder.encode("B", "UTF-8"));

        /*StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552657/HsptlAsembySearchService/getHsptlMdcncLcinfoInqire"); *//*URL*//*
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + serviceKey); *//*Service Key*//*
        urlBuilder.append("&" + URLEncoder.encode("WGS84_LAT","UTF-8") + "=" + URLEncoder.encode("37.538034", "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("WGS84_LON","UTF-8") + "=" + URLEncoder.encode("127.048523", "UTF-8"));
        log.info("url={}", urlBuilder.toString());*/

        String jsonString = callOpenApiAndReturnString(url, paramMap, "GET", "XML");

        /*URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
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
        conn.disconnect();*/

        JSONObject json = XML.toJSONObject(jsonString);
        HsptlMdcncLcinfoInqire jsonObject = objectMapper.readValue(json.toString(), HsptlMdcncLcinfoInqire.class);
        String jsonPrettyString = objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(jsonObject);

        return jsonPrettyString;
    }

    /**
     * 병/의원별 기본정보 조회
     * @return
     * @throws IOException
     */
    @ResponseBody
    @GetMapping("/getHsptlBassInfoInqire")
    public String hsptlBassInfoInqire() throws IOException{

        String url = "http://apis.data.go.kr/B552657/HsptlAsembySearchService/getHsptlBassInfoInqire";

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("serviceKey", serviceKey);

        /*StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552657/HsptlAsembySearchService/getHsptlBassInfoInqire"); *//*URL*//*
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + serviceKey); *//*Service Key*//*
        log.info("url={}", urlBuilder.toString());*/

        String jsonString = callOpenApiAndReturnString(url, paramMap, "GET", "XML");

        /*URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
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
        conn.disconnect();*/

        JSONObject json = XML.toJSONObject(jsonString);
        HsptlBassInfoInqire jsonObject = objectMapper.readValue(json.toString(), HsptlBassInfoInqire.class);
        String jsonPrettyString = objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(jsonObject);

        return jsonPrettyString;
    }


    @ResponseBody
    @GetMapping("/getParmacyListInfoInqire")
    public String pharmacy() throws IOException {

        String url = "http://apis.data.go.kr/B552657/ErmctInsttInfoInqireService/getParmacyListInfoInqire";

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("serviceKey", serviceKey);
        paramMap.put("Q0", URLEncoder.encode("서울특별시", "UTF-8"));
        paramMap.put("Q1", URLEncoder.encode("강남구", "UTF-8"));

        /*StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552657/ErmctInsttInfoInqireService/getParmacyListInfoInqire"); *//*URL*//*
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + serviceKey); *//*Service Key*//*
        urlBuilder.append("&" + URLEncoder.encode("Q0","UTF-8") + "=" + URLEncoder.encode("서울특별시", "UTF-8")); *//*주소(시도)*//*
        urlBuilder.append("&" + URLEncoder.encode("Q1","UTF-8") + "=" + URLEncoder.encode("강남구", "UTF-8")); *//*주소(시군구)*//*
        urlBuilder.append("&" + URLEncoder.encode("QT","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); *//*월~일요일, 공휴일: 1~8*//*
        urlBuilder.append("&" + URLEncoder.encode("QN","UTF-8") + "=" + URLEncoder.encode("삼성약국", "UTF-8")); *//*기관명*//*
        urlBuilder.append("&" + URLEncoder.encode("ORD","UTF-8") + "=" + URLEncoder.encode("NAME", "UTF-8")); *//*순서*//*
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); *//*페이지 번호*//*
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); *//*목록 건수*//*
        */

        String jsonString = callOpenApiAndReturnString(url, paramMap, "GET", "XML");

        /*URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
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
        conn.disconnect();*/
        //System.out.println(sb.toString());

        JSONObject json = XML.toJSONObject(jsonString);
        ParmacyListInfoInqire jsonObject = objectMapper.readValue(json.toString(), ParmacyListInfoInqire.class);
        String jsonPrettyString = objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(jsonObject);

        return jsonPrettyString;
    }

    @ResponseBody
    @GetMapping("/getParmacyLcinfoInqire")
    public String parmacyLcinfoInqire() throws IOException {

        String url = "http://apis.data.go.kr/B552657/ErmctInsttInfoInqireService/getParmacyLcinfoInqire";

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("serviceKey", serviceKey);
        paramMap.put("WGS84_LAT", URLEncoder.encode("37.503041", "UTF-8"));
        paramMap.put("WGS84_LON", URLEncoder.encode("127.045502", "UTF-8"));

        /*StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552657/ErmctInsttInfoInqireService/getParmacyListInfoInqire"); *//*URL*//*
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + serviceKey); *//*Service Key*//*
        urlBuilder.append("&" + URLEncoder.encode("Q0","UTF-8") + "=" + URLEncoder.encode("서울특별시", "UTF-8")); *//*주소(시도)*//*
        urlBuilder.append("&" + URLEncoder.encode("Q1","UTF-8") + "=" + URLEncoder.encode("강남구", "UTF-8")); *//*주소(시군구)*//*
        urlBuilder.append("&" + URLEncoder.encode("QT","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); *//*월~일요일, 공휴일: 1~8*//*
        urlBuilder.append("&" + URLEncoder.encode("QN","UTF-8") + "=" + URLEncoder.encode("삼성약국", "UTF-8")); *//*기관명*//*
        urlBuilder.append("&" + URLEncoder.encode("ORD","UTF-8") + "=" + URLEncoder.encode("NAME", "UTF-8")); *//*순서*//*
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); *//*페이지 번호*//*
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); *//*목록 건수*//*
         */

        String jsonString = callOpenApiAndReturnString(url, paramMap, "GET", "XML");

        /*URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
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
        conn.disconnect();*/
        //System.out.println(sb.toString());

        JSONObject json = XML.toJSONObject(jsonString);
        ParmacyLcinfoInqire jsonObject = objectMapper.readValue(json.toString(), ParmacyLcinfoInqire.class);
        String jsonPrettyString = objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(jsonObject);

        return jsonPrettyString;
    }

    @ResponseBody
    @GetMapping("/getParmacyBassInfoInqire")
    public String parmacyBassInfoInqire() throws IOException {

        String url = "http://apis.data.go.kr/B552657/ErmctInsttInfoInqireService/getParmacyBassInfoInqire";

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("serviceKey", serviceKey);
        //paramMap.put("HPID", "C1108484");

        /*StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552657/ErmctInsttInfoInqireService/getParmacyListInfoInqire"); *//*URL*//*
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + serviceKey); *//*Service Key*//*
        urlBuilder.append("&" + URLEncoder.encode("Q0","UTF-8") + "=" + URLEncoder.encode("서울특별시", "UTF-8")); *//*주소(시도)*//*
        urlBuilder.append("&" + URLEncoder.encode("Q1","UTF-8") + "=" + URLEncoder.encode("강남구", "UTF-8")); *//*주소(시군구)*//*
        urlBuilder.append("&" + URLEncoder.encode("QT","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); *//*월~일요일, 공휴일: 1~8*//*
        urlBuilder.append("&" + URLEncoder.encode("QN","UTF-8") + "=" + URLEncoder.encode("삼성약국", "UTF-8")); *//*기관명*//*
        urlBuilder.append("&" + URLEncoder.encode("ORD","UTF-8") + "=" + URLEncoder.encode("NAME", "UTF-8")); *//*순서*//*
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); *//*페이지 번호*//*
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); *//*목록 건수*//*
         */

        String jsonString = callOpenApiAndReturnString(url, paramMap, "GET", "XML");

        /*URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
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
        conn.disconnect();*/
        //System.out.println(sb.toString());

        JSONObject json = XML.toJSONObject(jsonString);
        ParmacyBassInfoInqire jsonObject = objectMapper.readValue(json.toString(), ParmacyBassInfoInqire.class);
        String jsonPrettyString = objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(jsonObject);

        return jsonPrettyString;
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
    //private String openApiCallJsonStringReturn(String paramUrl, Map<String, String> paramMap, Object jsonObject, Class<?> jsonObjectClass) throws IOException{
    private String callOpenApiAndReturnString(String paramUrl, Map<String, String> paramMap, String httpMethodType, String messageType) throws IOException{
        StringBuilder urlBuilder = new StringBuilder(paramUrl);
        if (!paramMap.isEmpty()) {
            urlBuilder.append("?");

            Set<String> keySet = paramMap.keySet();
            Iterator<String> keyIterator = keySet.iterator();

            while (keyIterator.hasNext()) {
                String key = keyIterator.next();
                String value = paramMap.get(key);
                //if (key.equals("serviceKey"))
                    urlBuilder.append(URLEncoder.encode(key,"UTF-8") + "=" + value);
                //else
                //    urlBuilder.append(URLEncoder.encode(key,"UTF-8") + "=" + URLEncoder.encode(value,"UTF-8"));
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
        //log.info("sb.toString()={}", sb.toString());

        /*objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        jsonObject = objectMapper.readValue(sb.toString(), jsonObjectClass);
        String jsonString = objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(jsonObject);*/

        return sb.toString();
    }

}
