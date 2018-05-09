package College;

import java.io.InputStream;
import java.net.URL;

/**
 * 
 * @author lilili
 *
 */
public class College {

	public static void getJson(String URL) {
		URL url = new URL(URL);
		try (InputStream is = url.openStream();
				JsonReader rdr = Json.createReader(is)) {

			JsonObject obj = rdr.readObject();
			JsonArray results = obj.getJsonArray("data");
			for (JsonObject result : results.getValuesAs(JsonObject.class)) {
				System.out.print(result.getJsonObject("from").getString("name"));
				System.out.print(": ");
				System.out.println(result.getString("message", ""));
				System.out.println("-----------");
			}
		}
	}

}
