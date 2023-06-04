package com.example.demo.controller;

import com.example.demo.dto.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Slf4j
@Controller
public class OpenApiController {

    private ObjectMapper objectMapper = new ObjectMapper();
    private String serviceKey = "lfsF1YUzjtqebNpyyoxGlj8MARFHn2khJCKvQ%2BkNy5fHubwsv5qRusS6Jr5zwjQBnf%2BdiknzBWkNxGIrqXXtLQ%3D%3D";

    @GetMapping("/openapi")
    public String openApiHome() {
        return "openapi";
    }

    /*@ResponseBody
    @GetMapping("/getUlfptcaAlarmInfo")
    public String ulfptcaAlarmInfo() throws IOException {

        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552584/UlfptcaAlarmInqireSvc/getUlfptcaAlarmInfo"); *//*URL*//*
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + serviceKey); *//*Service Key*//*
        urlBuilder.append("&" + URLEncoder.encode("returnType","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); *//*xml 또는 json*//*
        urlBuilder.append("&" + URLEncoder.encode("year","UTF-8") + "=" + URLEncoder.encode("2023", "UTF-8")); *//*측정 연도*//*
        log.info("serviceKey={}", serviceKey);
        log.info("urlBuilder.toString()={}", urlBuilder.toString());

        URL url = new URL(urlBuilder.toString());
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
        conn.disconnect();

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        UlfptcaAlarmInfo json = objectMapper.readValue(sb.toString(), UlfptcaAlarmInfo.class);
        String jsonString = objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(json);

        return jsonString;
    }*/

    @ResponseBody
    @GetMapping("/getUlfptcaAlarmInfo")
    public String ulfptcaAlarmInfo() throws IOException {

        String url = "http://apis.data.go.kr/B552584/UlfptcaAlarmInqireSvc/getUlfptcaAlarmInfo";

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("serviceKey", serviceKey);
        paramMap.put("returnType", URLEncoder.encode("json", "UTF-8"));
        paramMap.put("year", URLEncoder.encode("2023", "UTF-8"));

        UlfptcaAlarmInfo jsonObject = new UlfptcaAlarmInfo();
        String jsonString = openApiCall(url, paramMap, jsonObject, UlfptcaAlarmInfo.class);

        return jsonString;
    }

/*    @ResponseBody
    @GetMapping("/getMsrstnAcctoRltmMesureDnsty")
    public String msrstnAcctoRltmMesureDnsty() throws IOException {

        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMsrstnAcctoRltmMesureDnsty"); //URL
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + serviceKey); //Service Key
        urlBuilder.append("&" + URLEncoder.encode("returnType","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); //xml 또는 json
        urlBuilder.append("&" + URLEncoder.encode("stationName","UTF-8") + "=" + URLEncoder.encode("종로구", "UTF-8")); //한 페이지 결과 수(조회 날짜로 검색 시 사용 안함)
        urlBuilder.append("&" + URLEncoder.encode("dataTerm","UTF-8") + "=" + URLEncoder.encode("DAILY", "UTF-8")); //페이지번호(조회 날짜로 검색 시 사용 안함)
        log.info("url={}", urlBuilder.toString());

        URL url = new URL(urlBuilder.toString());
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
        conn.disconnect();
        //System.out.println(sb.toString());

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        MsrstnAcctoRltmMesureDnsty json = objectMapper.readValue(sb.toString(), MsrstnAcctoRltmMesureDnsty.class);
        String jsonString = objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(json);

        log.info("jsonString={}", jsonString);

        return jsonString;
    }*/

    @ResponseBody
    @GetMapping("/getMsrstnAcctoRltmMesureDnsty")
    public String msrstnAcctoRltmMesureDnsty() throws IOException {

        String url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMsrstnAcctoRltmMesureDnsty";

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("serviceKey", serviceKey);
        paramMap.put("returnType", URLEncoder.encode("json", "UTF-8"));
        paramMap.put("stationName", URLEncoder.encode("종로구", "UTF-8"));
        paramMap.put("dataTerm", URLEncoder.encode("DAILY", "UTF-8"));

        MsrstnAcctoRltmMesureDnsty jsonObject = new MsrstnAcctoRltmMesureDnsty();
        String jsonString = openApiCall(url, paramMap, jsonObject, MsrstnAcctoRltmMesureDnsty.class);

        return jsonString;
    }

    /*@ResponseBody
    @GetMapping("/getUnityAirEnvrnIdexSnstiveAboveMsrstnList")
    public String unityAirEnvrnIdexSnstiveAboveMsrstnList() throws IOException {

        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getUnityAirEnvrnIdexSnstiveAboveMsrstnList"); *//*URL*//*
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + serviceKey); *//*Service Key*//*
        urlBuilder.append("&" + URLEncoder.encode("returnType","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); *//*xml 또는 json*//*

        URL url = new URL(urlBuilder.toString());
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
        conn.disconnect();
        //System.out.println(sb.toString());

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        UnityAirEnvrnIdexSnstiveAboveMsrstnList json = objectMapper.readValue(sb.toString(), UnityAirEnvrnIdexSnstiveAboveMsrstnList.class);
        String jsonString = objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(json);

        log.info("jsonString={}", jsonString);

        return jsonString;
    }*/

    @ResponseBody
    @GetMapping("/getUnityAirEnvrnIdexSnstiveAboveMsrstnList")
    public String unityAirEnvrnIdexSnstiveAboveMsrstnList() throws IOException {

        String url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getUnityAirEnvrnIdexSnstiveAboveMsrstnList";

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("serviceKey", serviceKey);
        paramMap.put("returnType", URLEncoder.encode("json", "UTF-8"));

        UnityAirEnvrnIdexSnstiveAboveMsrstnList jsonObject = new UnityAirEnvrnIdexSnstiveAboveMsrstnList();
        String jsonString = openApiCall(url, paramMap, jsonObject, UnityAirEnvrnIdexSnstiveAboveMsrstnList.class);

        return jsonString;
    }

    /*@ResponseBody
    @GetMapping("/getCtprvnRltmMesureDnsty")
    public String ctprvnRltmMesureDnsty() throws IOException {

        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty"); *//*URL*//*
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + serviceKey); *//*Service Key*//*
        urlBuilder.append("&" + URLEncoder.encode("returnType","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); *//*xml 또는 json*//*
        urlBuilder.append("&" + URLEncoder.encode("sidoName","UTF-8") + "=" + URLEncoder.encode("전국", "UTF-8")); *//*xml 또는 json*//*

        URL url = new URL(urlBuilder.toString());
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
        conn.disconnect();
        //System.out.println(sb.toString());

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        CtprvnRltmMesureDnsty json = objectMapper.readValue(sb.toString(), CtprvnRltmMesureDnsty.class);
        String jsonString = objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(json);

        log.info("jsonString={}", jsonString);

        return jsonString;
    }*/

    @ResponseBody
    @GetMapping("/getCtprvnRltmMesureDnsty")
    public String ctprvnRltmMesureDnsty() throws IOException {

        String url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty";

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("serviceKey", serviceKey);
        paramMap.put("returnType", URLEncoder.encode("json", "UTF-8"));
        paramMap.put("sidoName", URLEncoder.encode("전국", "UTF-8"));

        CtprvnRltmMesureDnsty jsonObject = new CtprvnRltmMesureDnsty();
        String jsonString = openApiCall(url, paramMap, jsonObject, CtprvnRltmMesureDnsty.class);

        return jsonString;
    }

    /*@ResponseBody
    @GetMapping("/getMinuDustFrcstDspth")
    public String minuDustFrcstDspth() throws IOException {

        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMinuDustFrcstDspth"); *//*URL*//*
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + serviceKey); *//*Service Key*//*
        urlBuilder.append("&" + URLEncoder.encode("returnType","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); *//*xml 또는 json*//*
        URL url = new URL(urlBuilder.toString());
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
        conn.disconnect();
        //System.out.println(sb.toString());

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        MinuDustFrcstDspth json = objectMapper.readValue(sb.toString(), MinuDustFrcstDspth.class);
        String jsonString = objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(json);

        log.info("jsonString={}", jsonString);

        return jsonString;
    }*/

    @ResponseBody
    @GetMapping("/getMinuDustFrcstDspth")
    public String minuDustFrcstDspth() throws IOException {

        String url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMinuDustFrcstDspth";

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("serviceKey", serviceKey);
        paramMap.put("returnType", URLEncoder.encode("json", "UTF-8"));

        MinuDustFrcstDspth jsonObject = new MinuDustFrcstDspth();
        String jsonString = openApiCall(url, paramMap, jsonObject, MinuDustFrcstDspth.class);

        return jsonString;
    }

    /*@ResponseBody
    @GetMapping("/getMinuDustWeekFrcstDspth")
    public String minuDustWeekFrcstDspth() throws IOException{

        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMinuDustWeekFrcstDspth"); *//*URL*//*
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + serviceKey); *//*Service Key*//*
        urlBuilder.append("&" + URLEncoder.encode("returnType","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); *//*xml 또는 json*//*
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        log.info("getMinuDustWeekFrcstDspth Response code={}", conn.getResponseCode());

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

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        MinuDustWeekFrcstDspth json = objectMapper.readValue(sb.toString(), MinuDustWeekFrcstDspth.class);
        String jsonString = objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(json);

        log.info("jsonString={}", jsonString);

        return jsonString;
    }*/

    @ResponseBody
    @GetMapping("/getMinuDustWeekFrcstDspth")
    public String minuDustWeekFrcstDspth() throws IOException{

        String url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMinuDustWeekFrcstDspth";

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("serviceKey", serviceKey);
        paramMap.put("returnType", URLEncoder.encode("json", "UTF-8"));

        MinuDustWeekFrcstDspth jsonObject = new MinuDustWeekFrcstDspth();
        String jsonString = openApiCall(url, paramMap, jsonObject, MinuDustWeekFrcstDspth.class);

        return jsonString;
    }

    @ResponseBody
    @GetMapping("/hospital1")
    public String hospital() throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552657/HsptlAsembySearchService/getHsptlMdcncListInfoInqire"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + serviceKey); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("Q0","UTF-8") + "=" + URLEncoder.encode("서울특별시", "UTF-8")); /*주소(시도)*/
        urlBuilder.append("&" + URLEncoder.encode("Q1","UTF-8") + "=" + URLEncoder.encode("강남구", "UTF-8")); /*주소(시군구)*/
        urlBuilder.append("&" + URLEncoder.encode("QZ","UTF-8") + "=" + URLEncoder.encode("B", "UTF-8")); /*CODE_MST의'H000' 참조(B:병원, C:의원)*/

        URL url = new URL(urlBuilder.toString());
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
        conn.disconnect();
        //System.out.println(sb.toString());
        log.info("sb.toString()={}", sb.toString());
        return sb.toString();
    }

    @ResponseBody
    @GetMapping("/pharmacy")
    public String pharmacy() throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552657/ErmctInsttInfoInqireService/getParmacyListInfoInqire"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + serviceKey); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("Q0","UTF-8") + "=" + URLEncoder.encode("서울특별시", "UTF-8")); /*주소(시도)*/
        urlBuilder.append("&" + URLEncoder.encode("Q1","UTF-8") + "=" + URLEncoder.encode("강남구", "UTF-8")); /*주소(시군구)*/
        urlBuilder.append("&" + URLEncoder.encode("QT","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*월~일요일, 공휴일: 1~8*/
        urlBuilder.append("&" + URLEncoder.encode("QN","UTF-8") + "=" + URLEncoder.encode("삼성약국", "UTF-8")); /*기관명*/
        urlBuilder.append("&" + URLEncoder.encode("ORD","UTF-8") + "=" + URLEncoder.encode("NAME", "UTF-8")); /*순서*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*목록 건수*/
        URL url = new URL(urlBuilder.toString());
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
        conn.disconnect();
        //System.out.println(sb.toString());
        return sb.toString();
    }

    private String openApiCall(String paramUrl, Map<String, String> paramMap, Object jsonObject, Class<?> jsonObjectClass) throws IOException{

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
        conn.disconnect();
        //log.info("sb.toString()={}", sb.toString());

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        jsonObject = objectMapper.readValue(sb.toString(), jsonObjectClass);
        String jsonString = objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(jsonObject);

        return jsonString;
    }

}
