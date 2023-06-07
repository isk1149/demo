package com.example.demo.dto.hospital.hsptlmdcnclistinfoinqire;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class HsptlMdcncListInfoInqireBody {
    private HsptlMdcncListInfoInqireItems items;
    //private List<InnerHsptlMdcncListInfoInqireItem> items = new ArrayList<>();
    private int numOfRows;
    private int pageNo;
    private int totalCount;
}
