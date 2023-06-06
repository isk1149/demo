package com.example.demo.dto.hospital.hsptlbassinfoinqire;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class HsptlBassInfoInqireBody {
    private HsptlBassInfoInqireItems items;
    //private List<InnerHsptlMdcncListInfoInqireItem> items = new ArrayList<>();
    private int numOfRows;
    private int pageNo;
    private int totalCount;
}
