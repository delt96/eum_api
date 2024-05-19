package com.example.eum_api.service;

import com.example.eum_api.request.*;
import com.example.eum_api.response.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class EumApiService {

    @Value("${api.key}")
    String key ;
    @Value("${api.id}")
    String id ;


    //시군구 코드 조회
    public SearchAreaResponse searchArea() throws Exception{
        SearchAreaRequest areaRequest = new SearchAreaRequest();
        areaRequest.setId(id);
        areaRequest.setKey(key);
        String url = "?id="+ areaRequest.getId()+"&key="+areaRequest.getKey();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.eum.go.kr/web/Rest/OP/searchArea"+url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(response.body());
        document.getDocumentElement().normalize();

        NodeList nodeList = document.getElementsByTagName("response");

        SearchAreaResponse searchAreaResponse = new SearchAreaResponse();
        List<Area>  areas = new ArrayList<>();
        for(int i =0 ; i< nodeList.getLength() ; i++){
            Area area = new Area();
            // area.setAreaNm();
            // area.setAreaCd();
            areas.add(area);
        }

        System.out.println(response.body());

        return null;
    }
    //지역지구 코드 조회
    public SearchZoneResponse searchZone (String uname, String areaCd) throws Exception{
        SearchZoneRequest searchZoneRequest =new SearchZoneRequest();
        searchZoneRequest.setId(id);
        searchZoneRequest.setKey(key);
        searchZoneRequest.setUname(uname);
        searchZoneRequest.setAreaCd(areaCd);
        searchZoneRequest.setType("S");
        String url = "?id="+ searchZoneRequest.getId() + "&key="+searchZoneRequest.getKey()+ "&areaCd=" + searchZoneRequest.getAreaCd() + "&type="+ searchZoneRequest.getType() + "&uname="+ searchZoneRequest.getUname() ;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.eum.go.kr/web/Rest/OP/searchZone"+url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());

        return null;
    }
    //토지이용규제 법령정보
    public LuLawInfoResponse luLawInfo(String areaCd , String ucodeList) throws Exception{
        LuLawInfoRequest luLawInfoRequest = new LuLawInfoRequest();
        luLawInfoRequest.setId(id);
        luLawInfoRequest.setKey(key);
        luLawInfoRequest.setAreaCd(areaCd);
        luLawInfoRequest.setUcodeList(ucodeList);

        String url = "?id="+luLawInfoRequest.getId()+ "&key="+ luLawInfoRequest.getKey() + "&areaCd="+luLawInfoRequest.getAreaCd()+"&ucodeList=" + luLawInfoRequest.getUcodeList();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.eum.go.kr/web/Rest/OP/luLawInfo"+url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());

        return null;
    }
    //토지이용 행위 명
    public SearchLunCdResponse searchLunCd (String pageNo , String landUseNm)  throws  Exception{
        SearchLunCdRequest searchLunCdRequest =new SearchLunCdRequest();
        searchLunCdRequest.setId(id);
        searchLunCdRequest.setKey(key);
        searchLunCdRequest.setLandUseNm(landUseNm);
        searchLunCdRequest.setPageNo(pageNo);

        String url = "?id="+searchLunCdRequest.getId() + "&key="+ searchLunCdRequest.getKey() + "&landUseNm="+searchLunCdRequest.getLandUseNm() + "&pageNo="+searchLunCdRequest.getPageNo();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.eum.go.kr/web/Rest/OP/searchLunCd"+url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());


        return null;
    }

    //토지이용 규제 행위제한 정보
    public ArLandUseInfoResponse arLandUseInfo (String ucodeList, String landUseNm) throws  Exception{
        ArLandUseInfoRequest arLandUseInfoRequest = new ArLandUseInfoRequest();
        arLandUseInfoRequest.setId(id);
        arLandUseInfoRequest.setKey(key);
        arLandUseInfoRequest.setUcodeList(ucodeList);
        arLandUseInfoRequest.setLandUseNm(landUseNm);

        String url = "?id="+arLandUseInfoRequest.getId() + "&key="+arLandUseInfoRequest.getKey() + "&ucodeList="+arLandUseInfoRequest.getUcodeList()+ "&landUseNm="+ arLandUseInfoRequest.getLandUseNm();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.eum.go.kr/web/Rest/OP/arLandUseInfo"+url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());


        return null;
    }
}


