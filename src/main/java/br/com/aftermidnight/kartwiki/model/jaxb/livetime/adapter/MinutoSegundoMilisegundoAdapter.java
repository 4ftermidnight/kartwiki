package br.com.aftermidnight.kartwiki.model.jaxb.livetime.adapter;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;


//http://stackoverflow.com/questions/13568543/how-do-you-specify-the-date-format-used-when-jaxb-marshals-xsddatetime
public class MinutoSegundoMilisegundoAdapter extends XmlAdapter<String, Date> {

    static final private SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss.SSS");

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