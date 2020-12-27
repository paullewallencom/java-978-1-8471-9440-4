
import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class HttpInOutClient{

    private static String url = "http://localhost:8080/EsbServlet/hello/";
    private static String fileUrl = "HttpSoapRequest.xml";

    protected void executeClient()throws Exception{

		log(" ********** HttpInOutClient.executeClient...");

		InputStream inputStream = ClassLoader.getSystemResourceAsStream(fileUrl);
		byte[] bytes = new byte[inputStream.available()];
		inputStream.read(bytes);
		inputStream.close();

        URLConnection connection = new URL(url).openConnection();
        connection.setDoOutput(true);
        OutputStream os = connection.getOutputStream();
        os.write(new String(bytes).getBytes());
        os.close();

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
        }
        in.close();

        log("-------------------------------------------------");
	}

    public static void log(Object msg){
       System.out.println(msg.toString());
    }

    public static void main(String[] args)throws Exception{

		log(" ********** HttpInOutClient.main-Start...");

		if(args.length == 2){
			url = args[0];
			log("url : " + url);
			fileUrl = args[1];
			log("fileUrl : " + fileUrl);
		}

		HttpInOutClient httpInOutClient = new HttpInOutClient();
		httpInOutClient.executeClient();

		log(" ********** HttpInOutClient.main-Done.");
	}

}