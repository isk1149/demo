package com.example.demo.dto.atmospherepollution.minudustfrcstdspth;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MinuDustFrcstDspthBody {
    //private List<MinuDustFrcstDspthItem> items = new ArrayList<>();
    private List<MinuDustFrcstDspthItem> items;
    private int totalCount;
}
