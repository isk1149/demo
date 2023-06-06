package com.example.demo.dto.atmospherepollution.ctprvnrltmmesurednsty;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CtprvnRltmMesureDnstyBody {
    //private List<CtprvnRltmMesureDnstyItem> items = new ArrayList<>();
    private List<CtprvnRltmMesureDnstyItem> items;
    private int numOfRows;
    private int pageNo;
    private int totalCount;
}
