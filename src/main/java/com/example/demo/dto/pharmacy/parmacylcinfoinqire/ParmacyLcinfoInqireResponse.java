package com.example.demo.dto.pharmacy.parmacylcinfoinqire;

import com.example.demo.dto.pharmacy.parmacylistinfoinqire.ParmacyListInfoInqireBody;
import com.example.demo.dto.pharmacy.parmacylistinfoinqire.ParmacyListInfoInqireHeader;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ParmacyLcinfoInqireResponse {
    private ParmacyLcinfoInqireHeader header;
    private ParmacyLcinfoInqireBody body;
}
