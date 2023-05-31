package com.example.demo.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MsrstnAcctoRltmMesureDnsty {

    private InnerMsrstnAcctoRltmMesureDnstyResponse response;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    static class InnerMsrstnAcctoRltmMesureDnstyResponse {
        private InnerMsrstnAcctoRltmMesureDnstyHeader header;
        private InnerMsrstnAcctoRltmMesureDnstyBody body;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    static class InnerMsrstnAcctoRltmMesureDnstyHeader {
        private String resultCode;
        private String resultMsg;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    static class InnerMsrstnAcctoRltmMesureDnstyBody {
        private List<InnerMsrstnAcctoRltmMesureDnstyItem> items = new ArrayList<>();
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
    static class InnerMsrstnAcctoRltmMesureDnstyItem {
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
