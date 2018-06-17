package utils;

import java.io.OutputStream;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;


/**
* This class contains methods for validating in the form beans
*@author     PKTAN
*/

public final class PushNotificationHelper implements Serializable{
	
	/**
     * Replace SERVER_KEY with your SERVER_KEY generated from FCM
     * Replace DEVICE_TOKEN with your DEVICE_TOKEN
     */
 //   private static String SERVER_KEY = "AAAABlVkzV8:APA91bEdvA1fDrg_11pOmB5yjvaVAkAL6q4aPsjaBhy6oIwy4FgKhBS2hEV6ncKPQlPHYg85q-mLewngsTEdwMUjrONBPZsPDvPQLP79VE9_o5Tiz2cPyzsOQAzssUt_swxlVnhObOf5";
	private static String SERVER_KEY ="AAAAHejCOLE:APA91bHDyXTNWgA7LqFtM7-hSvJj0gyVqoYB-4hujrGUWnPwEwfJjRrxpnb9r83mCHAQSIUVNAsY5nnOkf2tgQaOuBBfMM-Beq42KBaBwZaFeXoNZtv3zhxW_rBwX7ZU6v02w44rCJhl";
	//   private static String DEVICE_TOKEN = "ct4p17PzBlY:APA91bHfi-uqnB6x3Zwrz6eihKnMF-58nGSl1fdx1hjky_DbSu0Spn_jYMJTml7Q1S0KBxzeFTnx4o89TSGd_lmqH-DJJffdWSaSrRWGilP0oASAhc-XvgxFYMbJ3O1Enh-hWboR6Eo6";
	 /**
     * Sends notification to mobile, YOU DON'T NEED TO UNDERSTAND THIS METHOD
     */
    public static void sendPushNotification(String title, String message, String deviceId) throws Exception {
       
    	//push notification
    	String pushMessage = "{\"data\":{\"title\":\"" +
                title +
                "\",\"message\":\"" +
                message +
                "\"},\"to\":\"" +
                deviceId +
                "\"}";
        // Create connection to send FCM Message request.
        URL url = new URL("https://fcm.googleapis.com/fcm/send");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestProperty("Authorization", "key=" + SERVER_KEY);
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);

        // Send FCM message content.
        OutputStream outputStream = conn.getOutputStream();
        outputStream.write(pushMessage.getBytes());

        System.out.println(conn.getResponseCode());
        System.out.println(conn.getResponseMessage());
    }
} 
