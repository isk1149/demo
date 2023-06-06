package com.example.demo.dto.atmospherepollution.msrstnacctorltmmesurednsty;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MsrstnAcctoRltmMesureDnstyBody {
    //private List<MsrstnAcctoRltmMesureDnstyItem> items = new ArrayList<>();
    private List<MsrstnAcctoRltmMesureDnstyItem> items;
    private int numOfRows;
    private int pageNo;
    private int totalCount;
}
