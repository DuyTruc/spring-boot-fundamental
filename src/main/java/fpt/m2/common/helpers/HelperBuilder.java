package fpt.m2.common.helpers;

import java.util.HashMap;
import java.util.Map;

public class HelperBuilder {
	public static Map<?,?> buildMessage(String string) {
		Map<String,String> message = new HashMap<>();
		message.put("message",string);
		return message;
		
	}
	
}
