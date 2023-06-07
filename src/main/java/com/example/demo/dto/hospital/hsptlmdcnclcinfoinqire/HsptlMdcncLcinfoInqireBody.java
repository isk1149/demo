package com.example.demo.dto.hospital.hsptlmdcnclcinfoinqire;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class HsptlMdcncLcinfoInqireBody {
    private HsptlMdcncLcinfoInqireItems items;
    //private List<InnerHsptlMdcncListInfoInqireItem> items = new ArrayList<>();
    private int numOfRows;
    private int pageNo;
    private int totalCount;
}
