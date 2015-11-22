package br.com.aftermidnight.kartwiki.model.jaxb.livetime.adapter;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class HoraMinutoSegundoMilisegundoAdapter extends XmlAdapter<String, Date> {

	static final private  SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss.SSS");

	 @Override
	    public String marshal(Date v) throws Exception {
	        return dateToString(v);
	    }

	    @Override
	    public Date unmarshal(String v) throws Exception {
	        return stringToDate(v);
	    }
	    
	    
	    static public String dateToString(Date v) throws Exception{
	    	return dateFormat.format(v);
	    }
	    
	    static public Date stringToDate(String v) throws Exception{
	    	return dateFormat.parse(v);
	    }
}