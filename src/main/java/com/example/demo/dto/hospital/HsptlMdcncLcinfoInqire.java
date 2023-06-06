package com.example.demo.dto.hospital;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class HsptlMdcncLcinfoInqire {
    private InnerHsptlMdcncLcinfoInqireResponse response;

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    static class InnerHsptlMdcncLcinfoInqireResponse {
        private InnerHsptlMdcncLcinfoInqireHeader header;
        private InnerHsptlMdcncLcinfoInqireBody body;
    }

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    static class InnerHsptlMdcncLcinfoInqireHeader {
        private String resultCode;
        private String resultMsg;
    }

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    static class InnerHsptlMdcncLcinfoInqireBody {
        private InnerHsptlMdcncLcinfoInqireItems items;
        //private List<InnerHsptlMdcncListInfoInqireItem> items = new ArrayList<>();
        private int numOfRows;
        private int pageNo;
        private int totalCount;
    }

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    static class InnerHsptlMdcncLcinfoInqireItems {
        private List<InnerHsptlMdcncLcinfoInqireItem> item = new ArrayList<>();
    }

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    static class InnerHsptlMdcncLcinfoInqireItem {
        private String rnum;
        private String distance;
        private String dutyAddr;
        private String dutyDiv;
        private String dutyDivName;
        private String dutyEmcls;
        private String dutyFax;
        private String dutyLvkl;
        private String dutyName;
        private String dutyTel1;
        private String endTime;
        private String hpid;
        private String latitude;
        private String longitude;
        private String startTime;
        private String cnt;
    }
}
