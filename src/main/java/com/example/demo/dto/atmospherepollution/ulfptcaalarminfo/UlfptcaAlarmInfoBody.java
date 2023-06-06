package com.example.demo.dto.atmospherepollution.ulfptcaalarminfo;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UlfptcaAlarmInfoBody {
    //private List<UlfptcaAlarmInfoItem> items = new ArrayList<>();
    private List<UlfptcaAlarmInfoItem> items;
    private int numOfRows;
    private int pageNo;
    private int totalCount;
}
