package com.example.demo.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UlfptcaAlarmInqireSvc {
    private InnerUlfptcaAlarmInqireSvc1 response;
    //private InnerUlfptcaAlarmInqireSvc items;

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    static class InnerUlfptcaAlarmInqireSvc1 {
        private InnerUlfptcaAlarmInqireSvc2 body;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    static class InnerUlfptcaAlarmInqireSvc2 {
        private int totalCount;
        private List<InnerUlfptcaAlarmInqireSvc3> items = new ArrayList<>();
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    static class InnerUlfptcaAlarmInqireSvc3 {
        private String clearVal;
        private String sn;
        private String districtName;
        private String dataDate;
        private String issueVal;
        private String issueTime;
        private String clearDate;
        private String issueDate;
        private String moveName;
        private String clearTime;
        private String issueGbn;
        private String itemCode;
    }

}
