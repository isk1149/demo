package com.example.demo.dto.pharmacy.parmacybassinfoinqire;

import com.example.demo.dto.pharmacy.parmacylcinfoinqire.ParmacyLcinfoInqireItems;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ParmacyBassInfoInqireBody {
    private ParmacyBassInfoInqireItems items;
    private int numOfRows;
    private int pageNo;
    private int totalCount;
}
