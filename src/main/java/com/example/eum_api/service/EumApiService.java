package com.example.eum_api.service;

import com.example.eum_api.request.*;
import com.example.eum_api.response.LuLawInfoResponse;
import com.example.eum_api.response.SearchAreaResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Slf4j
@Service
public class EumApiService {

    @Value("${api.key}")
    String key;
    @Value("${api.id}")
    String id;


    //시군구 코드 조회
    public String searchArea() throws Exception{
        SearchAreaRequest areaRequest = SearchAreaRequest.builder().id(id).key(key).build();

        String url = "?id="+ areaRequest.getId()+"&key="+areaRequest.getKey();

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.eum.go.kr/web/Rest/OP/searchArea"+url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
    //지역지구 코드 조회
    public String searchZone (String uname, String areaCd) throws Exception{
        SearchZoneRequest searchZoneRequest =SearchZoneRequest.builder().id(id).key(key).uname(uname).areaCd(areaCd).build();

        String url = "?id="+ searchZoneRequest.getId() + "&key="+searchZoneRequest.getKey()+ "&areaCd=" + searchZoneRequest.getAreaCd() + "&type=S" + "&uname="+ searchZoneRequest.getUname() ;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.eum.go.kr/web/Rest/OP/searchZone"+url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
    //토지이용규제 법령정보
    public String luLawInfo(String areaCd , String ucodeList) throws Exception{
        LuLawInfoRequest luLawInfoRequest = LuLawInfoRequest.builder().id(id).key(key).areaCd(areaCd).ucodeList(ucodeList).build();

        String url = "?id="+luLawInfoRequest.getId()+ "&key="+ luLawInfoRequest.getKey() + "&areaCd="+luLawInfoRequest.getAreaCd()+"&ucodeList=" + luLawInfoRequest.getUcodeList();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.eum.go.kr/web/Rest/OP/luLawInfo"+url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
    //토지이용 행위 명
    public String searchLunCd (String pageNo , String landUseNm)  throws  Exception{
        SearchLunCdRequest searchLunCdRequest =SearchLunCdRequest.builder().id(id).key(key).build();
        searchLunCdRequest.setLandUseNm(landUseNm);
        searchLunCdRequest.setPageNo(pageNo);

        String url = "?id="+searchLunCdRequest.getId() + "&key="+ searchLunCdRequest.getKey() + "&landUseNm="+searchLunCdRequest.getLandUseNm() + "&pageNo="+searchLunCdRequest.getPageNo();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.eum.go.kr/web/Rest/OP/searchLunCd"+url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    //토지이용 규제 행위제한 정보
    public String arLandUseInfo (String ucodeList, String landUseNm, String areaCd) throws  Exception{
        ArLandUseInfoRequest arLandUseInfoRequest = ArLandUseInfoRequest.builder().id(id).key(key).build();
        arLandUseInfoRequest.setUcodeList(ucodeList);
        arLandUseInfoRequest.setLandUseNm(landUseNm);
        arLandUseInfoRequest.setAreaCd(areaCd);
        String url = "?id="+arLandUseInfoRequest.getId() + "&key="+arLandUseInfoRequest.getKey() +"&areaCd="+ arLandUseInfoRequest.getAreaCd() +"&ucodeList="+arLandUseInfoRequest.getUcodeList()+ "&landUseNm="+ arLandUseInfoRequest.getLandUseNm();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.eum.go.kr/web/Rest/OP/arLandUseInfo"+url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
    public String searchAreaTest() throws Exception{
        SearchAreaRequest areaRequest = SearchAreaRequest.builder().id(id).key(key).build();

        String url = "?id="+ areaRequest.getId()+"&key="+areaRequest.getKey();

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.eum.go.kr/web/Rest/OP/searchArea"+url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        response.body();

        String xmlResponse = response.body();

        XmlMapper xmlMapper = new XmlMapper();
        SearchAreaResponse searchAreaResponse = xmlMapper.readValue(xmlResponse, SearchAreaResponse.class);
        log.info(searchAreaResponse.toString());
        return null;
    }
    public String luLawInfoTest(String areaCd , String ucodeList) throws Exception{
        LuLawInfoRequest luLawInfoRequest = LuLawInfoRequest.builder().id(id).key(key).areaCd(areaCd).ucodeList(ucodeList).build();

        String url = "?id="+luLawInfoRequest.getId()+ "&key="+ luLawInfoRequest.getKey() + "&areaCd="+luLawInfoRequest.getAreaCd()+"&ucodeList=" + luLawInfoRequest.getUcodeList();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.eum.go.kr/web/Rest/OP/luLawInfo"+url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String xmlResponse = response.body();

        XmlMapper xmlMapper = new XmlMapper();
        LuLawInfoResponse luLawInfoResponse = xmlMapper.readValue(xmlResponse, LuLawInfoResponse.class);
        log.info(luLawInfoResponse.toString());
        return null;
    }
}


