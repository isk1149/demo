package com.example.demo.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CtprvnRltmMesureDnsty {
    private InnerCtprvnRltmMesureDnstyResponse response;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    static class InnerCtprvnRltmMesureDnstyResponse {
        private InnerCtprvnRltmMesureDnstyHeader header;
        private InnerCtprvnRltmMesureDnstyBody body;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    static class InnerCtprvnRltmMesureDnstyHeader {
        private String resultCode;
        private String resultMsg;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    static class InnerCtprvnRltmMesureDnstyBody {
        private List<InnerCtprvnRltmMesureDnstyItem> items = new ArrayList<>();
        private int numOfRows;
        private int pageNo;
        private int totalCount;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    static class InnerCtprvnRltmMesureDnstyItem {
        private String stationName;
        private String stationCode;
        private String mangName;
        private String sidoName;
        private String dataTime;
        private String so2Value;
        private String coValue;
        private String o3Value;
        private String no2Value;
        private String pm10Value;
        private String pm10Value24;
        private String pm25Value;
        private String pm25Value24;
        private String khaiValue;
        private String khaiGrade;
        private String so2Grade;
        private String coGrade;
        private String o3Grade;
        private String no2Grade;
        private String pm10Grade;
        private String pm25Grade;
        private String pm10Grade1h;
        private String pm25Grade1h;
        private String so2Flag;
        private String coFlag;
        private String o3Flag;
        private String no2Flag;
        private String pm10Flag;
        private String pm25Flag;
    }
}
