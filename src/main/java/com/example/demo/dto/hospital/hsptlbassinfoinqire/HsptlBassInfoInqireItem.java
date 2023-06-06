package com.example.demo.dto.hospital.hsptlbassinfoinqire;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true) //MKioskTy11가 매핑이 안되서 선언함
public class HsptlBassInfoInqireItem {
    private String hpid;
    private String dutyName;
    private String postCdn1;
    private String postCdn2;
    private String dutyAddr;
    private String dutyTel1;
    private String dutyTel3;
    private String hvec;
    private String hvoc;
    private String hvcc;
    private String hvncc;
    private String hvccc;
    private String hvicc;
    private String hvgc;
    private String dutyHayn;
    private String dutyHano;
    private String dutyInf;
    private String dutyMapimg;
    private String dutyEryn;
    private String dutyTime1c;
    private String dutyTime2c;
    private String dutyTime3c;
    private String dutyTime4c;
    private String dutyTime5c;
    private String dutyTime6c;
    private String dutyTime7c;
    private String dutyTime8c;
    private String dutyTime1s;
    private String dutyTime2s;
    private String dutyTime3s;
    private String dutyTime4s;
    private String dutyTime5s;
    private String dutyTime6s;
    private String dutyTime7s;
    private String dutyTime8s;
    private String MKioskTy25;
    private String MKioskTy1;
    private String MKioskTy2;
    private String MKioskTy3;
    private String MKioskTy4;
    private String MKioskTy5;
    private String MKioskTy6;
    private String MKioskTy7;
    private String MKioskTy8;
    private String MKioskTy9;
    private String MKioskTy10;
    @JsonProperty(value = "MKioskTy11")
    private String MKioskTy11;
    private String o001;
    private String o002;
    private String o003;
    private String o004;
    private String o005;
    private String o006;
    private String o007;
    private String o008;
    private String o009;
    private String o010;
    private String o011;
    private String o012;
    private String o013;
    private String o014;
    private String o015;
    private String o016;
    private String o017;
    private String o018;
    private String o019;
    private String o020;
    private String o021;
    private String o022;
    private String o023;
    private String o024;
    private String o025;
    private String o026;
    private String o027;
    private String o028;
    private String o029;
    private String o030;
    private String o031;
    private String o032;
    private String o033;
    private String o034;
    private String o035;
    private String o036;
    private String o037;
    private String o038;
    private String wgs84Lon;
    private String wgs84Lat;
    private String dgidIdName;
    private String hpbdn;
    private String hpccuyn;
    private String hpcuyn;
    private String hperyn;
    private String hpgryn;
    private String hpicuyn;
    private String hpnicuyn;
    private String hpopyn;
}
