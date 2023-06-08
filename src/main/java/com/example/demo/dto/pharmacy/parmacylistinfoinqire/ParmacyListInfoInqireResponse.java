package com.example.demo.dto.pharmacy.parmacylistinfoinqire;

import com.example.demo.dto.hospital.hsptlbassinfoinqire.HsptlBassInfoInqireBody;
import com.example.demo.dto.hospital.hsptlbassinfoinqire.HsptlBassInfoInqireHeader;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ParmacyListInfoInqireResponse {
    private ParmacyListInfoInqireHeader header;
    private ParmacyListInfoInqireBody body;
}
