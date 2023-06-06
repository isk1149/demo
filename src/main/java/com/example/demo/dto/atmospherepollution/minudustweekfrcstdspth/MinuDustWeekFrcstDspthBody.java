package com.example.demo.dto.atmospherepollution.minudustweekfrcstdspth;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MinuDustWeekFrcstDspthBody {
    //private List<MinuDustWeekFrcstDspth.InnerMinuDustWeekFrcstDspthItem> items = new ArrayList<>();
    private List<MinuDustWeekFrcstDspthItem> items;
    private int numOfRows;
    private int pageNo;
    private int totalCount;
}
