package br.com.aftermidnight.kartwiki.util.xml;



import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


public class JAXBHelper {
	
	public <T>  T xml2JavaObject(String xmlUrl, Class<T> clazz) {
		T retorno = null;
		try {
			InputStream is = new URL(xmlUrl).openStream();
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller un = context.createUnmarshaller();
            retorno = (T)un.unmarshal(is);
            is.close();
            return retorno;
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        } 
        return null;
	}

	public <T>  T xml2JavaObject(InputStream is , Class<T> clazz) {
		
		try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller un = context.createUnmarshaller();
            return (T)un.unmarshal(is);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
	}
	
	public <T>  T xml2JavaObject(File fileIn, Class<T> clazz) {
		
		try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller un = context.createUnmarshaller();
            return (T)un.unmarshal(fileIn);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
	}
	
	public <T> void javaObject2Xml(String fileNameOut, Class<T> clazz, T object) {

		try {
			JAXBContext context = JAXBContext.newInstance(clazz);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.marshal(object, new File(fileNameOut));
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

}

