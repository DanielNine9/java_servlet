package com.poly.utils;

import javax.servlet.http.Cookie;

public class XCookie {
	
	//Táº¡o vÃ  gá»­i cookie vá»� client
	//@param name tÃªn cookie
	//@param value giÃ¡ trá»‹ cookie
	//@param hours thá»�i háº¡n cookie (giá»�)
	//@return Cookie Ä‘Ã£ gá»­i vá»� client
	
	public static void add(String name,String value,int hours) {
		Cookie cookie = new Cookie(name,value);
		cookie.setMaxAge(hours*60*60);
		cookie.setPath("/");
		RRSharer.response().addCookie(cookie);
	}
	
	////Ä�á»�c giÃ¡ trá»‹ cookie
	//@param name tÃªn cookie cáº§n Ä‘á»�c
	//@param defval giÃ¡ trá»‹ máº·c Ä‘á»‹nh
	//@return giÃ¡ trá»‹ cookie hoáº·c defval náº¿u cookie khÃ´ng tá»“n táº¡i
	
	public static String get(String name, String defval) {
		Cookie[] cookies = RRSharer.request().getCookies();
		if(cookies != null) {
			for (Cookie cookie : cookies) {
				if(cookie.getName().equalsIgnoreCase(name)) {
					return cookie.getValue();
				}
			}
		}
		return defval;
	}
	
	
}
