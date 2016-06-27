package com.gdms.tools;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.util.EntityUtils;

public class MyHttpMethod {
	public MyHttpMethod(){
		
	}
	
	/**
	 * Post 鏂瑰紡璇锋眰
	 * @param nameValuePairList 璇锋眰鎵�甫鍙傛暟
	 * @param sessionId
	 * @param url 璇锋眰鍦板潃
	 * @return 璇锋眰缁撴灉
	 */
	public static String MyPost(List<NameValuePair> nameValuePairList,String url,String sessionId){

		String resultString = null;
		HttpEntity httpEntity = null;
		HttpClient httpClient = null;
		HttpResponse httpResponse = null;
		try{
			httpEntity = new  UrlEncodedFormEntity(nameValuePairList,"UTF-8");
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Cookie", "ASP.NET_SessionId="+sessionId);	
		httpPost.setEntity(httpEntity);
		httpClient = new DefaultHttpClient();
		InputStream inputStream = null;
		try{
			httpResponse = httpClient.execute(httpPost);
			httpEntity = httpResponse.getEntity();
			resultString = EntityUtils.toString(httpEntity);
		}catch(IOException e){
			e.printStackTrace();
		}
		finally{
			if(inputStream!=null){
				try {
					inputStream.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		return resultString;
	}
	/**
	 * get鏂瑰紡璇锋眰
	 * @param url 璇锋眰鍦板潃
	 * @param 
	 * @return resultString 璇锋眰缁撴灉
	 */
	public static Map<String, String> MyGetSession(String url){
		String sessionId = "";
		String resultString = null;
		HttpGet httpGet = null;
		HttpEntity httpEntity = null;
		HttpResponse httpResponse = null;
		HttpClient httpClient = null;
		
		InputStream inputStream = null;
		httpGet = new HttpGet(url);	
		httpClient = new DefaultHttpClient();
		try {
			httpResponse = httpClient.execute(httpGet);
			List<Cookie> cookies = ((AbstractHttpClient) httpClient).getCookieStore().getCookies();
	        for (int i=0;i<cookies.size();++i){
	            sessionId = cookies.get(i).getValue();
			}
			httpEntity = httpResponse.getEntity();
			resultString = EntityUtils.toString(httpEntity);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			if(inputStream != null){
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("sessionId", sessionId);
		map.put("result", resultString);
		return map;
	}
	/**
	 * get鏂瑰紡璇锋眰
	 * @param url 璇锋眰鍦板潃
	 * @param 
	 * @return resultString 璇锋眰缁撴灉
	 */
	public static String MyGet(String url,String userId,String sessionId){
		String resultString = null;
		HttpGet httpGet = null;
		HttpEntity httpEntity = null;
		HttpResponse httpResponse = null;
		HttpClient httpClient = null;
		
		InputStream inputStream = null;
		
		httpGet = new HttpGet(url);
		httpGet.setHeader("Referer","http://61.139.105.138/xs_main.aspx?xh="+userId);
		httpGet.setHeader("Cookie", "ASP.NET_SessionId="+sessionId);

		httpClient = new DefaultHttpClient();
		try {
			httpResponse = httpClient.execute(httpGet);
			httpEntity = httpResponse.getEntity();
			resultString = EntityUtils.toString(httpEntity);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			if(inputStream != null){
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return resultString;
	}
	/**
	 * 
	 * @param url
	 * @param model
	 * @return
	 */
	public static byte[] MyGetYZM(String url,String sessionId){
		HttpGet httpGet = null;
		HttpEntity httpEntity = null;
		HttpResponse httpResponse = null;
		HttpClient httpClient = null;
		
		InputStream inputStream = null;
		
		httpGet = new HttpGet(url);
		httpGet.setHeader("Cookie", "ASP.NET_SessionId="+sessionId);

		httpClient = new DefaultHttpClient();
		try {
			httpResponse = httpClient.execute(httpGet);
			httpEntity = httpResponse.getEntity();
			byte[] resultStringb = EntityUtils.toByteArray(httpEntity);
			return resultStringb;
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			if(inputStream != null){
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
