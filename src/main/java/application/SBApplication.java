package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@SpringBootApplication
@ComponentScan(basePackages = {"application", "com.ibm.javametrics.spring"})
public class SBApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SBApplication.class, args);

       
    }
}
