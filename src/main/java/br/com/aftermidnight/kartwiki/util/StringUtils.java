package br.com.aftermidnight.kartwiki.util;

import java.text.Normalizer;

public class StringUtils extends org.apache.commons.lang3.StringUtils {

	static public String normalize(String str) {
		String temp = Normalizer.normalize(str, java.text.Normalizer.Form.NFD);
		return temp.replaceAll("[^\\p{ASCII}]", "");
	}

	static public String apenasNumeros(String str) {
		return str.replaceAll("[^0-9]", ""); 
	}
}
