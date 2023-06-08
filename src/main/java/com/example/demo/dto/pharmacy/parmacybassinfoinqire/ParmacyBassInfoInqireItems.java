package com.example.demo.dto.pharmacy.parmacybassinfoinqire;

import com.example.demo.dto.pharmacy.parmacylcinfoinqire.ParmacyLcinfoInqireItem;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ParmacyBassInfoInqireItems {
    private List<ParmacyBassInfoInqireItem> item;
}
