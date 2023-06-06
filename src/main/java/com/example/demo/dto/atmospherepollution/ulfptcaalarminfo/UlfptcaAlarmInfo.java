package com.example.demo.dto.atmospherepollution.ulfptcaalarminfo;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UlfptcaAlarmInfo {
    //private InnerUlfptcaAlarmInfoResponse response;
    private UlfptcaAlarmInfoResponse response;

    /*@Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    static class InnerUlfptcaAlarmInfoResponse {
        private InnerUlfptcaAlarmInfoHeader header;
        private InnerUlfptcaAlarmInfoBody body;

        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        static class InnerUlfptcaAlarmInfoHeader {
            private String resultCode;
            private String resultMsg;
        }

        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        static class InnerUlfptcaAlarmInfoBody {
            private List<InnerUlfptcaAlarmInfoItem> items = new ArrayList<>();
            private int numOfRows;
            private int pageNo;
            private int totalCount;

            @Getter
            @Setter
            @NoArgsConstructor
            @AllArgsConstructor
            static class InnerUlfptcaAlarmInfoItem {
                private String sn;
                private String dataDate;
                private String districtName;
                private String moveName;
                private String itemCode;
                private String issueGbn;
                private String issueDate;
                private String issueTime;
                private String issueVal;
                private String clearDate;
                private String clearTime;
                private String clearVal;
            }
        }
    }*/
}

/*
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UlfptcaAlarmInfo {
    private InnerUlfptcaAlarmInfoResponse response;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    static class InnerUlfptcaAlarmInfoResponse {
        private InnerUlfptcaAlarmInfoHeader header;
        private InnerUlfptcaAlarmInfoBody body;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    static class InnerUlfptcaAlarmInfoHeader {
        private String resultCode;
        private String resultMsg;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    static class InnerUlfptcaAlarmInfoBody {
        private List<InnerUlfptcaAlarmInfoItem> items = new ArrayList<>();
        private int numOfRows;
        private int pageNo;
        private int totalCount;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    static class InnerUlfptcaAlarmInfoItem {
        private String sn;
        private String dataDate;
        private String districtName;
        private String moveName;
        private String itemCode;
        private String issueGbn;
        private String issueDate;
        private String issueTime;
        private String issueVal;
        private String clearDate;
        private String clearTime;
        private String clearVal;
    }

}
*/