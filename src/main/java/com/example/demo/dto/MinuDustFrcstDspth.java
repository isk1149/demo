package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MinuDustFrcstDspth {
    private InnerMinuDustFrcstDspthResponse response;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    static class InnerMinuDustFrcstDspthResponse {
        private InnerMinuDustFrcstDspthHeader header;
        private InnerMinuDustFrcstDspthBody body;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    static class InnerMinuDustFrcstDspthHeader {
        private String resultCode;
        private String resultMsg;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    static class InnerMinuDustFrcstDspthBody {
        private List<InnerMinuDustFrcstDspthItem> items = new ArrayList<>();
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    static class InnerMinuDustFrcstDspthItem {
        private String dataTime;
        private String informCode;
        /*private String informOverall;
        private String informCause;
        private String informGrade;
        private String actionKnack;
        private String imageUrl1;
        private String imageUrl2;
        private String imageUrl3;
        private String imageUrl4;
        private String imageUrl5;
        private String imageUrl6;
        private String imageUrl7;
        private String imageUrl8;
        private String imageUrl9;
        private String informData;*/
    }
}
