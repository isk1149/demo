package com.example.demo.dto.pharmacy.parmacylcinfoinqire;

import com.example.demo.dto.pharmacy.parmacylistinfoinqire.ParmacyListInfoInqireItems;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ParmacyLcinfoInqireBody {
    private ParmacyLcinfoInqireItems items;
    private int numOfRows;
    private int pageNo;
    private int totalCount;
}
