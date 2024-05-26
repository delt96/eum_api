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
    public String searchArea(){
        System.out.println("searchArea Start");
        try {
            return eumApiService.searchArea();
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
    @GetMapping("/searchZone")
    public String searchZone(String uname, String areaCd){
        System.out.println("searchZone Start");
        try {
            return eumApiService.searchZone(uname, areaCd);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
    @GetMapping("/luLawInfo")
    public String luLawInfo(String areaCd , String ucodeList){
        System.out.println("luLawInfo Start");
        try {
            return eumApiService.luLawInfo(areaCd, ucodeList);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
    @GetMapping("/searchLunCd")
    public String searchLunCd(@RequestParam(defaultValue = "1") String pageNo , String landUseNm){
        System.out.println("searchLunCd Start");
        try {
            return eumApiService.searchLunCd(pageNo, landUseNm);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
    @GetMapping("/arLandUseInfo")
    public String arLandUseInfo(String ucodeList, String landUseNm){
        System.out.println("arLandUseInfo");
        try {
            return eumApiService.arLandUseInfo(ucodeList, landUseNm);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

}
