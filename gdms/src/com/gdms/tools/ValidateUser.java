package com.gdms.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpSession;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.gdms.pojo.User;

public class ValidateUser {
	public static boolean  Validate(User user, String validateCode){
//		HttpServletRequest request = ServletActionContext.getRequest();
		ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes(); 
		HttpSession session = attrs.getRequest().getSession();
//		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) session.getAttribute("map");
		String sessionId = map.get("sessionId"); 
//		System.out.println(map.get("result"));
		String str = getViewstate(map.get("result"));
//		System.out.println("结果state"+str);
		List<NameValuePair> nameValuePairList = new ArrayList<NameValuePair>();
//		System.out.println(sessionId);
		nameValuePairList.add(new BasicNameValuePair("__VIEWSTATE", str));
		nameValuePairList.add(new BasicNameValuePair("txtUserName", user.getWorkId()));
//		System.out.println(user.getWorkId());
		nameValuePairList.add(new BasicNameValuePair("TextBox2", user.getPassword()));
//		System.out.println("验证"+validateCode);
		nameValuePairList.add(new BasicNameValuePair("txtSecretCode", validateCode));
//		System.out.println("用户名"+user.getWorkId());
		nameValuePairList.add(new BasicNameValuePair("RadioButtonList1", "学生"));
		nameValuePairList.add(new BasicNameValuePair("Button1", ""));
		nameValuePairList.add(new BasicNameValuePair("lbLanguage", ""));
		nameValuePairList.add(new BasicNameValuePair("hidPdrs", ""));
		nameValuePairList.add(new BasicNameValuePair("hidsc", ""));
		String g = MyHttpMethod.MyPost(nameValuePairList, "http://61.139.105.138/default2.aspx", sessionId);
		//System.out.println("------------------------------");
		//System.out.println(g);
		String ggString = g.replace("xs_main.aspx?xh="+user.getWorkId(), "");
		if (ggString.length()==g.length()) {
			return false;
		}else {
			return true;
		}
	}
	public static String  getViewstate(String getString){
		String string = "__VIEWSTATE\" value=\".*\"";
		Pattern p = Pattern.compile(string);
		Matcher matcher = p.matcher(getString);
		if(matcher.find()) {   
			string = matcher.group();
		}
		String[] str2 = string.split("\"");
		for (int i = 0; i < str2.length; i++) {
			string = str2[i];
		}
		return string;
	}
}
