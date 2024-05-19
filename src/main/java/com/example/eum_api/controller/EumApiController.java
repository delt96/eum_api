package com.example.eum_api.controller;

import com.example.eum_api.response.*;
import com.example.eum_api.service.EumApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EumApiController {

    @Autowired
    EumApiService eumApiService;

    @GetMapping("/searchArea")
    public SearchAreaResponse searchArea(){
        try {
            return eumApiService.searchArea();
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
    @GetMapping("/searchZone")
    public SearchZoneResponse searchZone(String uname, String areaCd){
        try {
            return eumApiService.searchZone(uname, areaCd);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
    @GetMapping("/luLawInfo")
    public LuLawInfoResponse luLawInfo(String areaCd , String ucodeList){
        try {
            return eumApiService.luLawInfo(areaCd, ucodeList);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
    @GetMapping("/searchLunCd")
    public SearchLunCdResponse searchLunCd(@RequestParam(defaultValue = "1") String pageNo , String landUseNm){
        try {
            return eumApiService.searchLunCd(pageNo, landUseNm);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
    @GetMapping("/arLandUseInfo")
    public ArLandUseInfoResponse arLandUseInfo(String ucodeList, String landUseNm){
        try {
            return eumApiService.arLandUseInfo(ucodeList, landUseNm);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

}
