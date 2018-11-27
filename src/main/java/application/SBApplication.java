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

        URL url = new URL("http://testejava.default.svc.cluster.local:8080/health");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
        System.out.println("------------------");
		System.out.println(response.toString());
        System.out.println("******************");
    }
}
