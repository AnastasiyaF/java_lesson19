/*
 *  Created by Anastasiya Findziukevich
 *  24/04/2017
 *  
 *  Task 19.
 *  
 *  Для предметной области Магазин проката спортивных товаров разработайте xml-файл, 
 *  позволяющий хранить ассортимент магазина, и соответствующую ему xsd-схему.
 */

package com.epam.java_training.main;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;


public class Main {
	
	public static void main(String[] args) {
		
		try{
			
			SchemaFactory schema_factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			
			Source stream_source = new StreamSource(new File("src/com/epam/java_training/main/ProductsSchema.xsd"));
			Schema schema = schema_factory.newSchema(stream_source);
			
			Validator validator = schema.newValidator();
			
			validator.validate(new StreamSource(new File("src/com/epam/java_training/main/Products.xml")));
			
			System.out.println("XML document is validated.");
		}
		catch (SAXException e) {
			e.printStackTrace();
		}
		catch (IOException e){
			System.out.println(e);
		}

	}
}
