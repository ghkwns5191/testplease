package com.example.demo.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import android.util.Base64;

@CrossOrigin(origins = "*", maxAge = 3600)
//@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/api/chatbot")
@Controller
public class chatbotController {
   
   @GetMapping("/chatbotform")
   public String chatbotForm() {
      return "chatbot";
   } 
   
   @ResponseBody
   @PostMapping("/chatbot")
   public String chatbot(@RequestParam("query") String query) {
      String chatbotMessage = ""; 
 
      try { 
         
         String apiURL = "https://5ltxnd3vrm.apigw.ntruss.com/custom/v1/7705/4d36b297f911602e6c53044ef19c7e42a5a39484ddc8262450648828fcf56bdb";
         String secretKey = "TWRzaWV0VlNRdW1ERXRHTFJwQ1dJZ0N0R1Bwa2dGVFE=";
         URL url = new URL(apiURL);

         String message = getReqMessage(query);  
         System.out.println("##" + message);
    
         String encodeBase64String = makeSignature(message, secretKey);

         HttpURLConnection con = (HttpURLConnection) url.openConnection();
         con.setRequestMethod("POST");
         con.setRequestProperty("Content-Type", "application/json;UTF-8");
         con.setRequestProperty("X-NCP-CHATBOT_SIGNATURE", encodeBase64String);

         // post request
         con.setDoOutput(true);
         DataOutputStream wr = new DataOutputStream(con.getOutputStream());
         wr.write(message.getBytes("UTF-8"));
         wr.flush();
         wr.close();
         int responseCode = con.getResponseCode();

         BufferedReader br;
         System.out.println(responseCode);
         if (responseCode == 200) { 
            System.out.println("getResponseMessage:"+con.getResponseMessage());

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String decodedString;
            while ((decodedString = in.readLine()) != null) {
               chatbotMessage = decodedString;
            }
            // chatbotMessage = decodedString;
            in.close();

         } else { 

            chatbotMessage = con.getResponseMessage();
         }
      } catch (Exception e) {
         System.out.println(e);
      }
      System.out.println("chatbotMessage:"+chatbotMessage);
      JSONObject jobj = new JSONObject(chatbotMessage);
      JSONArray bubbles_array = jobj.getJSONArray("bubbles");
      JSONObject bubble = (JSONObject)bubbles_array.get(0);
      if(bubble.get("type").equals("text")) {
    	  JSONObject data = (JSONObject)bubble.get("data");
    	  return data.getString("description");
      }else if(bubble.get("type").equals("template")) {
      JSONObject data = (JSONObject)bubble.get("data");
      JSONObject cover = (JSONObject)data.get("cover");
      //return cover.getString("title");
      JSONObject data1 = (JSONObject)cover.get("data");
      //return data1.getString("description") + "\n" + data1.getString("imageUrl");
      return cover.getString("title")+"\n"+data1.getString("description")+data1.getString("imageUrl");
      }
      
      else return "";
      
     }
   

   public static String makeSignature(String message, String secretKey) {

      String encodeBase64String = "";

      try {
         byte[] secrete_key_bytes = secretKey.getBytes("UTF-8");

         SecretKeySpec signingKey = new SecretKeySpec(secrete_key_bytes, "HmacSHA256");
         Mac mac = Mac.getInstance("HmacSHA256");
         mac.init(signingKey);

         byte[] rawHmac = mac.doFinal(message.getBytes("UTF-8"));
         encodeBase64String = Base64.encodeToString(rawHmac, Base64.NO_WRAP);

         return encodeBase64String;

      } catch (Exception e) {
         System.out.println(e);
      }

      return encodeBase64String;

   }

   
   
   
   public static String getReqMessage(String voiceMessage) {

      String requestBody = "";

      try {

         JSONObject obj = new JSONObject();

         long timestamp = new Date().getTime();

         System.out.println("##" + timestamp);

         obj.put("version", "v2");
         obj.put("userId", "U47b00b58c90f8e47428af8b7bddc1231heo2");

         obj.put("timestamp", timestamp);

         JSONObject bubbles_obj = new JSONObject();

         bubbles_obj.put("type", "text");
         
         
         JSONObject data_obj = new JSONObject();
         data_obj.put("description", voiceMessage);

         bubbles_obj.put("type", "text");
         bubbles_obj.put("data", data_obj);
         
         
         JSONArray bubbles_array = new JSONArray();
         bubbles_array.put(bubbles_obj);

         obj.put("bubbles", bubbles_array);
         obj.put("event", "send");

         requestBody = obj.toString();

      } catch (Exception e) {
         System.out.println("## Exception : " + e);
      }

      return requestBody;

   }
}