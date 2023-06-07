package com.example.demo.dto.hospital.hsptlmdcnclcinfoinqire;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class HsptlMdcncLcinfoInqireResponse {
    private HsptlMdcncLcinfoInqireHeader header;
    private HsptlMdcncLcinfoInqireBody body;
}
