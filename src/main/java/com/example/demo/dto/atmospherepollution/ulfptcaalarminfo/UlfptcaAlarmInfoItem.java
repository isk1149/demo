package com.example.demo.dto.atmospherepollution.ulfptcaalarminfo;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UlfptcaAlarmInfoItem {
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
