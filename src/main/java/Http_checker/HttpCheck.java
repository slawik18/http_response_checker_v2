package Http_checker;

/**
 * Created by adminus on 2015-12-05.
 */

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpCheck {

    public int getHTTPResponseStatusCode(String u) throws IOException {

        URL url = new URL(u);
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        http.setConnectTimeout(5000);
        http.setReadTimeout(5000);
        return http.getResponseCode();
    }

    public boolean checkingHTTPAvailable(String u) {
        boolean status;
        try {
            if (getHTTPResponseStatusCode(u) == 200) {
                status = true;
            } else {
                status = false;
            }
        } catch (IOException e) {
            System.out.println("Service unavailable");
            status = false;
        }
        return status;
    }
}
