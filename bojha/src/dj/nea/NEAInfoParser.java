/**
 * 
 */
package dj.nea;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author debmalyajash
 *
 */
public class NEAInfoParser {

	/**
	 * KEY_REF to call nea api
	 */
	 private static final String KEY_REF = "<<Your API KEY>>";


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] datasets = new String[] { "nowcast", "12hrs_forecast",
				"3days_outlook", "heavy_rain_warning","uvi","earthquake","psi_update","pm2.5_update" };

		for (int i = 0; i < datasets.length; i++) {
			try {
				callNEAWebAPI(datasets[i], KEY_REF);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private static void callNEAWebAPI(String datasetName, String keyRef)
			throws Exception {
		// Step 1: Construct URL
		String url = "http://www.nea.gov.sg/api/WebAPI?dataset=" + datasetName
				+ "&keyref=" + KEY_REF;
		// Step 2: Call API Url
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
		// Step 3: Check the response status
		if (responseCode == 200) {
			// Step 3a: If response status == 200
			// print the received xml
			System.out.println(readStream(con.getInputStream()));
		} else {
			// Step 3b: If response status != 200
			// print the error received from server
			// System.out.println("Error in accessing API - " +
			readStream(con.getErrorStream());
		}
	}

	// Read the responded result
	private static String readStream(InputStream inputStream) throws Exception {
		BufferedReader reader = null;
		StringBuffer response = new StringBuffer();
		try {
			reader = new BufferedReader(new InputStreamReader(inputStream));
			String inputLine;

			while ((inputLine = reader.readLine()) != null) {
				response.append(inputLine);
			}
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
		return response.toString();
	}
}
