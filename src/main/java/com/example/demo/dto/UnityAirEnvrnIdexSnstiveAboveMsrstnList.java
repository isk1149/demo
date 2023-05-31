package com.example.demo.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UnityAirEnvrnIdexSnstiveAboveMsrstnList {
    private InnerUnityAirEnvrnIdexSnstiveAboveMsrstnListResponse response;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    static class InnerUnityAirEnvrnIdexSnstiveAboveMsrstnListResponse {
        private InnerUnityAirEnvrnIdexSnstiveAboveMsrstnListHeader header;
        private InnerUnityAirEnvrnIdexSnstiveAboveMsrstnListBody body;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    static class InnerUnityAirEnvrnIdexSnstiveAboveMsrstnListHeader {
        private String resultCode;
        private String resultMsg;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    static class InnerUnityAirEnvrnIdexSnstiveAboveMsrstnListBody {
        private List<InnerUnityAirEnvrnIdexSnstiveAboveMsrstnListItem> items = new ArrayList<>();
        private int numOfRows;
        private int pageNo;
        private int totalCount;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    static class InnerUnityAirEnvrnIdexSnstiveAboveMsrstnListItem {
        private String stationName;
        private String stationCode;
        private String addr;
    }
}
