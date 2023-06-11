package com.example.demo.service;

import com.example.demo.dto.hospital.hsptlbassinfoinqire.HsptlBassInfoInqire;
import com.example.demo.dto.hospital.hsptlmdcnclcinfoinqire.HsptlMdcncLcinfoInqire;
import com.example.demo.dto.hospital.hsptlmdcnclistinfoinqire.HsptlMdcncListInfoInqire;
import com.example.demo.dto.hospital.hsptlmdcnclistinfoinqire.HsptlMdcncListInfoInqireItem;

import java.util.Map;

public interface HospitalService {
    HsptlMdcncListInfoInqire getHsptlMdcncListInfoInqire() throws Exception;
    Map<String, HsptlMdcncListInfoInqireItem> getHsptlMdcncListInfoInqireMap() throws Exception;
    HsptlMdcncLcinfoInqire getHsptlMdcncLcinfoInqire() throws Exception;
    HsptlBassInfoInqire getHsptlBassInfoInqire(String hpid) throws Exception;
}
/*
D001	내과
D002	외과
D003	산부인과
D004	소아과
D005	신경과
D006	정신과
D007	피부과
D008	안과
D009	이비인후과
D010	치과
D011	정형외과
D012	신경외과
D013	흉부외과
D014	혈액종양내과
D015	암센터
D016	류마티스내과
D017	감염내과
D018	내분비내과
D019	신장내과
D020	호흡기내과
D021	소화기내과
D022	순환기내과
D023	알레르기내과
D024	재활의학과
D025	가정의학과
D026	마취통증의학과
D027	진단검사의학과
D028	방사선종양학과
D029	예방의학과

D001	내과
D002	이비인후과
D003	안과
D004	치과
D005	피부과
D006	비뇨기과
D007	산부인과
D008	소아과
D009	정신건강의학과
D010	신경외과
D011	신경과
D012	정형외과
D013	흉부외과
D014	혈액종양내과
D015	류마티스내과
D016	내분비내과
D017	신장내과
D018	알레르기내과
D019	감염내과
D020	호흡기내과
D021	종양내과
D022	핵의학과
D023	재활의학과
D024	가정의학과
D025	예방의학과
D026	마취통증의학과
D027	영상의학과
D028	진단검사의학과
D029	방사선종양학과
D030	응급의학과
D031	재활의학과
D032	가정의학과
D033	예방의학과
D034	마취통증의학과
D035	영상의학과
D036	진단검사의학과
D037	방사선종양학과
D038	응급의학과
D039	한방내과
D040	한방신경정신과
D041	한방재활의학과
D042	한방소아과
D043	한방부인과
D044	한방피부과
D045	한방안과
D046	한방치과
D047	한방비뇨기과
D048	한방정형외과
D049	한방흉부외과
D050	한방혈액종양내과
D051	한방류마티스내과
D052	한방내분비내과
D053	한방신장내과
D054	한방알레르기내과
D055	한방감염내과
D056	한방호흡기내과
D057	한방종양내과
D058	한방핵의학과
D059	한방재활의학과
D060	한방가정의학과
D061	한방예방의학과
D062	한방마취통증의학과
D063	한방영상의학과
D064	한방진단검사의학과
D065	한방방사선종양학과
D066	한방응급의학과
D067	한방안과
D068	한방이비인후과
D069	한방치과
 */