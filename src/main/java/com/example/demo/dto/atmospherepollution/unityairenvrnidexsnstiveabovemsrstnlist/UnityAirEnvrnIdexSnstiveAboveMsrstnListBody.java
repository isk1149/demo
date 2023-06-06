package com.example.demo.dto.atmospherepollution.unityairenvrnidexsnstiveabovemsrstnlist;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UnityAirEnvrnIdexSnstiveAboveMsrstnListBody {
    //private List<UnityAirEnvrnIdexSnstiveAboveMsrstnListItem> items = new ArrayList<>();
    private List<UnityAirEnvrnIdexSnstiveAboveMsrstnListItem> items;
    private int numOfRows;
    private int pageNo;
    private int totalCount;
}
