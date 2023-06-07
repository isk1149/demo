package com.example.demo.dto.hospital.hsptlmdcnclistinfoinqire;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class HsptlMdcncListInfoInqireResponse {
    private HsptlMdcncListInfoInqireHeader header;
    private HsptlMdcncListInfoInqireBody body;
}
