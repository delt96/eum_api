import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Test;
import org.springframework.util.ResourceUtils;

import java.io.*;


@Slf4j
public class Testt {

    public static void main(String[] args) {
        String url =  ResourceUtils.CLASSPATH_URL_PREFIX + "20240601.xml";
        log.info("url : {}", url);
        try{
         File file = ResourceUtils.getFile(url);
         InputStream is = new FileInputStream(url);
         InputStreamReader isr = new InputStreamReader(is, "UTF-8");
         BufferedReader br = new BufferedReader(isr);
         String strJson = "";
         strJson += br.readLine();
         br.lines().forEach(System.out::println);

         log.info("strJson : {}", strJson);
         JSONParser par = new JSONParser();
         JSONObject jsonObj = (JSONObject) par.parse(strJson);
         log.info("jsonObj : {}", jsonObj);



        }catch(Exception e){
            log.info(e.getMessage());
        }
    }
}
