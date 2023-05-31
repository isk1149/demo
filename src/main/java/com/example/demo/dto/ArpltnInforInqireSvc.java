package com.example.demo.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ArpltnInforInqireSvc {

    private InnerArpltnInforInqireSvcResponse response;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    static class InnerArpltnInforInqireSvcResponse {
        private InnerArpltnInforInqireSvcHeader header;
        private InnerArpltnInforInqireSvcBody body;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    static class InnerArpltnInforInqireSvcHeader {
        private String resultCode;
        private String resultMsg;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    static class InnerArpltnInforInqireSvcBody {
        private List<InnerArpltnInforInqireSvcItem> items = new ArrayList<>();
        private int numOfRows;
        private int pageNo;
        private int totalCount;
    }

    /*@Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    static class InnerArpltnInforInqireSvcItems {
        private InnerArpltnInforInqireSvcItem item;
    }*/

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    static class InnerArpltnInforInqireSvcItem {
        private String so2Grade;
        private String coFlag;
        private String khaiValue;
        private String so2Value;
        private String coValue;
        private String pm10Flag;
        private String pm10Value;
        private String o3Grade;
        private String khaiGrade;
        private String no2Flag;
        private String no2Grade;
        private String o3Flag;
        private String so2Flag;
        private String dataTime;
        private String coGrade;
        private String no2Value;
        private String pm10Grade;
        private String o3Value;
    }
}
