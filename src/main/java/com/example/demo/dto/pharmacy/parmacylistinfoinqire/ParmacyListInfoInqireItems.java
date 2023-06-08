package com.example.demo.dto.pharmacy.parmacylistinfoinqire;

import com.example.demo.dto.hospital.hsptlbassinfoinqire.HsptlBassInfoInqireItem;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ParmacyListInfoInqireItems {
    private List<ParmacyListInfoInqireItem> item;
}
