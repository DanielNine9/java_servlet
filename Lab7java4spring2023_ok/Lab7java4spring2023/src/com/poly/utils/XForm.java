package com.poly.utils;


import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

import static com.poly.utils.RRSharer.request;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class XForm {
	//Kiá»ƒm tra sá»± tá»“n táº¡i cá»§a tham sá»‘
	//@param name tÃªn tham sá»‘
	//@return true náº¿u tá»“n táº¡i, ngÆ°á»£c láº¡i lÃ  false
	
	public static boolean exist(String name) {
		return request().getParameter(name)!=null;
	}
	
	//Ä�á»�c chuá»—i tá»« tham sá»‘
	//@param name tÃªn tham sá»‘ form
	//@param defval giÃ¡ trá»‹ máº·c Ä‘á»‹nh
	//@return GiÃ¡ trá»‹ tham sá»‘ hoáº·c defval náº¿u tham sá»‘ khÃ´ng tá»“n táº¡i
	
	public static String getString(String name, String defval) {
		String value = request().getParameter(name);
		return value == null?defval:value;
	}
	
	//Ä�á»�c sá»‘ nguyÃªn tá»« tham sá»‘ form
	//@param name tÃªn tham sá»‘ form
	//@param defval giÃ¡ trá»‹ máº·c Ä‘á»‹nh
	//@return giÃ¡ trá»‹ tham sá»‘ hoáº·c defval náº¿u tham sá»‘ khÃ´ng tá»“n táº¡i
	
	public static int getInt(String name, int defval) {
		String value = getString(name, String.valueOf(defval));
		return Integer.parseInt(value);
	}
	
	//Ä�á»�c sá»‘ thá»±c tá»« tham sá»‘ form
	//@param name tÃªn tham sá»‘ form
	//@param defval giÃ¡ trá»‹ máº·c Ä‘á»‹nh
	//@return giÃ¡ trá»‹ tham sá»‘ hoáº·c defval náº¿u tham sá»‘ khÃ´ng tá»“n táº¡i
	
	public static double getDouble(String name,double defval) {
		String value = getString(name,String.valueOf(defval));
		return Double.parseDouble(value);
	}
	
	//Ä�á»�c giÃ¡ trá»‹ boolean tá»« tham sá»‘ form
	//@param name tÃªn tham sá»‘ form
	//@param defval giÃ¡ trá»‹ máº·c Ä‘á»‹nh
	//@return giÃ¡ trá»‹ tham sá»‘ hoáº·c defval náº¿u tham sá»‘ khÃ´ng tá»“n táº¡i
	
	public static boolean getBoolean(String name,boolean defval) {
		String value = getString(name,String.valueOf(defval));
		return Boolean.parseBoolean(value);
	}
	
	//Ä�á»�c thá»�i gian tá»« tham sá»‘ form
	//@param name tÃªn tham sá»‘ form
	//@param defval giÃ¡ trá»‹ máº·c Ä‘á»‹nh
	//@return giÃ¡ trá»‹ tham sá»‘ hoáº·c defval náº¿u tham sá»‘ khÃ´ng tá»“n táº¡i
	
	public static Date getDate(String name, Date defval) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		String date = getString(name, sdf.format(defval));
		try {
			return sdf.parse(date);
		} catch (Exception e) {
			return defval;
		}
	}
	
	//LÆ°u file upload vÃ o thÆ° má»¥c vá»›i tÃªn duy nháº¥t
	//@param name tÃªn tham sá»‘ form
	//@param folder thÆ° má»¥c chá»©a file
	//@return File káº¿t quáº£ hoáº·c null náº¿u khÃ´ng upload
	
	public static File save(String name, String folder) {
		HttpSession session = request().getSession();
		ServletContext XHttp = session.getServletContext();
		File dir = new File(XHttp.getRealPath(folder));
		if(!dir.exists()) {
			dir.mkdirs();
		}
		try {
			Part part = request().getPart(name);
			if(part!=null && part.getSize()>0) {
				String fn = System.currentTimeMillis()+part.getSubmittedFileName();
				String filename = Integer.toHexString(fn.hashCode()) + fn.substring(fn.lastIndexOf("."));
				File file = new File(dir,filename);
				part.write(file.getAbsolutePath());
				return file;
			}
			return null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	//Ä�á»�c cÃ¡c giÃ¡ trá»‹ tham sá»‘ form vÃ o cÃ¡c thuá»™c tÃ­nh cÃ¹ng tÃªn cá»§a bean
	//@return Bean chá»©a dá»¯ liá»‡u form
	
	@SuppressWarnings("deprecation")
	public static <T> T getBean(Class<T> clazz) {
		DateTimeConverter dtc = new DateConverter(new Date());
		dtc.setPattern("MM/dd/yyyy");
		ConvertUtils.register(dtc, Date.class);
		try {
			T bean = clazz.newInstance();
			BeanUtils.populate(bean, request().getParameterMap());
			return bean;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
}
