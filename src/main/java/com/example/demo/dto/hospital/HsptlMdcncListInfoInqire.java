package com.example.demo.dto.hospital;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

/*@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class HsptlMdcncListInfoInqire {

    private Response response;

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    static class Response {
        private Header header;
        private Body body;
    }

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    static class Header {
        private String resultCode;
        private String resultMsg;
    }

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    static class Body {
        private Items items;
        //private List<InnerHsptlMdcncListInfoInqireItem> items = new ArrayList<>();
        private int numOfRows;
        private int pageNo;
        private int totalCount;
    }

    static class Items {
        private List<Item> item = new ArrayList<>();
    }

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    static class Item {
        private String rnum;
        private String dutyAddr;
        private String dutyDiv;
        private String dutyDivNam;
        private String dutyEmcls;
        private String dutyEmclsName;
        private String dutyEryn;
        private String dutyEtc;
        private String dutyInf;
        private String dutyMapimg;
        private String dutyName;
        private String dutyTel1;
        private String dutyTel3;
        private String dutyTime1c;
        private String dutyTime2c;
        private String dutyTime3c;
        private String dutyTime4c;
        private String dutyTime5c;
        private String dutyTime6c;
        private String dutyTime7c;
        private String dutyTime8c;
        private String dutyTime1s;
        private String dutyTime2s;
        private String dutyTime3s;
        private String dutyTime4s;
        private String dutyTime5s;
        private String dutyTime6s;
        private String dutyTime7s;
        private String dutyTime8s;
        private String hpid;
        private String postCdn1;
        private String postCdn2;
        private String wgs84Lon;
        private String wgs84Lat;
    }
}*/

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class HsptlMdcncListInfoInqire {

    private InnerHsptlMdcncListInfoInqireResponse response;

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    static class InnerHsptlMdcncListInfoInqireResponse {
        private InnerHsptlMdcncListInfoInqireHeader header;
        private InnerHsptlMdcncListInfoInqireBody body;
    }

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    static class InnerHsptlMdcncListInfoInqireHeader {
        private String resultCode;
        private String resultMsg;
    }

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    static class InnerHsptlMdcncListInfoInqireBody {
        private InnerHsptlMdcncListInfoInqireItems items;
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
    static class InnerHsptlMdcncListInfoInqireItems {
        private List<InnerHsptlMdcncListInfoInqireItem> item = new ArrayList<>();
    }

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    static class InnerHsptlMdcncListInfoInqireItem {
        private String rnum;
        private String dutyAddr;
        private String dutyDiv;
        private String dutyDivNam;
        private String dutyEmcls;
        private String dutyEmclsName;
        private String dutyEryn;
        private String dutyEtc;
        private String dutyInf;
        private String dutyMapimg;
        private String dutyName;
        private String dutyTel1;
        private String dutyTel3;
        private String dutyTime1c;
        private String dutyTime2c;
        private String dutyTime3c;
        private String dutyTime4c;
        private String dutyTime5c;
        private String dutyTime6c;
        private String dutyTime7c;
        private String dutyTime8c;
        private String dutyTime1s;
        private String dutyTime2s;
        private String dutyTime3s;
        private String dutyTime4s;
        private String dutyTime5s;
        private String dutyTime6s;
        private String dutyTime7s;
        private String dutyTime8s;
        private String hpid;
        private String postCdn1;
        private String postCdn2;
        private String wgs84Lon;
        private String wgs84Lat;
    }
}
