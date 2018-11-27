package application.rest.v2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.List;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@RestController
public class Example {


    @RequestMapping("v2")
    public @ResponseBody ResponseEntity<String> example() {
        List<String> list = new ArrayList<>();
        
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
        list.add("Resposta do endpoint (http://testejava.default.svc.cluster.local:8080/health) :");
		list.add(response.toString());

        return new ResponseEntity<String>(list.toString(), HttpStatus.OK);
    }

}
