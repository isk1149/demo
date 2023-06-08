package com.example.demo.dto.pharmacy.parmacylcinfoinqire;

import com.example.demo.dto.pharmacy.parmacylistinfoinqire.ParmacyListInfoInqireItem;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ParmacyLcinfoInqireItems {
    private List<ParmacyLcinfoInqireItem> item;
}
