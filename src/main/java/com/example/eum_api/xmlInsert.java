package com.example.eum_api;

import com.example.eum_api.response.EumLaw;
import com.example.eum_api.response.LuLawInfoResponse;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Slf4j
public class xmlInsert {
    public static void main(String[] args) {

        String url =  ResourceUtils.CLASSPATH_URL_PREFIX + "20240620.xml";
        try{
            File file = ResourceUtils.getFile(url);
            StringBuilder xmlResponse = new StringBuilder();
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    xmlResponse.append(line);
                }
            }

            XmlMapper xmlMapper = new XmlMapper();
            LuLawInfoResponse luLawInfoResponse = xmlMapper.readValue(xmlResponse.toString(), LuLawInfoResponse.class);
            insertRecordIntoTable(luLawInfoResponse, "20240620");


        }catch(Exception e){
            log.info(e.getMessage());
        }

    }
    private static void insertRecordIntoTable(LuLawInfoResponse luLawInfoResponse, String date) throws SQLException {
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String insertTableSQL = "insert into eum_law (ucode, uname, law_content, law_level, law_full_cd , reg_dt) values (?,?,?,?,?,?)" ;

        try {
            dbConnection = getDBConnection();
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);
            int totalSize = Integer.parseInt(luLawInfoResponse.getTotalSize());

            for(int i =0 ; i< totalSize  ; i++){
                 EumLaw eum = luLawInfoResponse.getEumLaw().get(i);
                preparedStatement.setString(1, eum.getUCODE());
                preparedStatement.setString(2, eum.getUNAME());
                preparedStatement.setString(3, eum.getLAW_CONTENTS());
                preparedStatement.setString(4, eum.getLAW_LEVEL());
                preparedStatement.setString(5, eum.getLAW_FULL_CD());
                preparedStatement.setString(6, date);
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }

    private static Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/law_alarm_service_db", "beom", "beom1234");
            return dbConnection;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }
}
