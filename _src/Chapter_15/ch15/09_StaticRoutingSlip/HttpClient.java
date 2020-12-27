
import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class HttpClient {

    public static void main(String[] args) throws Exception {

        URLConnection connection = new URL("http://localhost:8912").openConnection();
        connection.setDoOutput(true);
        OutputStream os = connection.getOutputStream();
        os.write(new String("<Test/>").getBytes());
        os.close();

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
        }
        in.close();

    }
}
