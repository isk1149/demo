package com.example.demo.dto.pharmacy.parmacylistinfoinqire;

import com.example.demo.dto.hospital.hsptlbassinfoinqire.HsptlBassInfoInqireItems;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ParmacyListInfoInqireBody {
    private ParmacyListInfoInqireItems items;
    private int numOfRows;
    private int pageNo;
    private int totalCount;
}
