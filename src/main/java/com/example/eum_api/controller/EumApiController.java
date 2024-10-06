package com.example.eum_api.controller;

import com.example.eum_api.response.*;
import com.example.eum_api.service.EumApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
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
        log.info("uname {} areaCd {}", uname, areaCd);
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
        log.info("areaCd  {} ucodeList {}", areaCd, ucodeList);
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
        log.info("pageNo  {} landUseNm {}", pageNo, landUseNm);
        try {
            return eumApiService.searchLunCd(pageNo, landUseNm);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
    @GetMapping("/arLandUseInfo")
    public String arLandUseInfo(String ucodeList, String landUseNm, String areaCd){
        System.out.println("arLandUseInfo");
        log.info("areaCd  {} landUseNm {}", areaCd, landUseNm);
        try {
            return eumApiService.arLandUseInfo(ucodeList, landUseNm, areaCd);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
    @GetMapping("/test")
    public String luLawInfoTest(String areaCd , String ucodeList){
        System.out.println("luLawInfo Start");
        log.info("areaCd  {} ucodeList {}", areaCd, ucodeList);
        try {
            return eumApiService.luLawInfoTest(areaCd, ucodeList);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

}
