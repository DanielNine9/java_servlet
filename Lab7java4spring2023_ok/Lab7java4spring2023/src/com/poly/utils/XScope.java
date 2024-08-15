package com.poly.utils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
//Cung cáº¥p cÃ¡c phÆ°Æ¡ng thá»©c Ä‘á»�c ghi attribute trong cÃ¡c scope
public class XScope {
	public static HttpServletRequest request() {
		return RRSharer.request();
	}
	
	public static HttpSession session() {
		return request().getSession();
	}
	
	public static ServletContext application() {
		return request().getServletContext();
	}
	
	//Táº¡o attribute trong request scope
	//@param name tÃªn attribute
	//@param value giÃ¡ trá»‹ cá»§a attribute
	
	public static void setRequest(String name, Object value) {
		request().setAttribute(name, value);
	}
	
	//Ä�á»�c attribute trong request scope
	//@param name tÃªn attribute
	//@return giÃ¡ trá»‹ cá»§a attribute hoáº·c null náº¿u khÃ´ng tá»“n táº¡i
	
	@SuppressWarnings("unchecked")
	public static <T> T geRequest(String name) {
		return (T) request().getAttribute(name);
	}
	
	//XoÃ¡ attribute trong request scope
	//@param name tÃªn attribute cáº§n xoÃ¡
	
	public static void removeRequest(String name) {
		request().removeAttribute(name);
	}
	
	//Táº¡o attribute trong session scope
	//@param name tÃªn attribute
	//@param value giÃ¡ trá»‹ cá»§a attributte
	
	public static void setSession(String name, Object value) {
		session().setAttribute(name, value);
	}
	
	//Ä�á»�c attribute trong session scope
	//@param name tÃªn attribute
	//@return giÃ¡ trá»‹ cá»§a attribute hoáº·c null náº¿u khÃ´ng tá»“n táº¡i
	
	@SuppressWarnings("unchecked")
	public static<T>T getSession(String name){
		return (T)session().getAttribute(name);
	}
	
	//XoÃ¡ attribute trong session Scope
	//@param name tÃªn attribute cáº§n xoÃ¡
	
	public static void removeSession(String name) {
		session().removeAttribute(name);
	}
	
	//Táº¡o attribute trong application scope
	//@param name tÃªn attribute
	//@param value giÃ¡ trá»‹ cá»§a attribute
	
	public static void setApplication(String name, Object value) {
		application().setAttribute(name, value);
	}
	
	//Ä�á»�c attribute trong application scope
	//@param name tÃªn attribute
	//@return giÃ¡ trá»‹ cá»§a attribute hoáº·c null náº¿u khÃ´ng tá»“n táº¡i
	
	@SuppressWarnings("unchecked")
	public static <T> T getApplication(String name) {
		return (T)application().getAttribute(name);
	}
	
	//XoÃ¡ attribute trong application scope
	//@param name tÃªn attribute cáº§n xoÃ¡
	
	public static void removeApplication(String name) {
		application().removeAttribute(name);
	}
}
