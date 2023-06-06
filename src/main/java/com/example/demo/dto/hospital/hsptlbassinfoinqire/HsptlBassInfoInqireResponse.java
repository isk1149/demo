package com.example.demo.dto.hospital.hsptlbassinfoinqire;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class HsptlBassInfoInqireResponse {
    private HsptlBassInfoInqireHeader header;
    private HsptlBassInfoInqireBody body;
}
