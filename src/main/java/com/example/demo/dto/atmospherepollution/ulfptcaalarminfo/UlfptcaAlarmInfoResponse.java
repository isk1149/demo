package com.example.demo.dto.atmospherepollution.ulfptcaalarminfo;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UlfptcaAlarmInfoResponse {
    private UlfptcaAlarmInfoHeader header;
    private UlfptcaAlarmInfoBody body;
}
