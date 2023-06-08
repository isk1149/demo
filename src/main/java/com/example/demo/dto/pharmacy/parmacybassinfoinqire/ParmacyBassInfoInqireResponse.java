package com.example.demo.dto.pharmacy.parmacybassinfoinqire;

import com.example.demo.dto.pharmacy.parmacylcinfoinqire.ParmacyLcinfoInqireBody;
import com.example.demo.dto.pharmacy.parmacylcinfoinqire.ParmacyLcinfoInqireHeader;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ParmacyBassInfoInqireResponse {
    private ParmacyBassInfoInqireHeader header;
    private ParmacyBassInfoInqireBody body;
}
