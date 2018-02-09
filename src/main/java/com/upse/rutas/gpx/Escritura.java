package com.upse.rutas.gpx;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class Escritura {
	public static void CrearArchivo(List<Punto> puntos) throws IOException, ParserConfigurationException{
		
		String lat=null,lon=null,ruta="D:/Aplicaciones/Archivos/2017/8/4/archivo.gpx";
		
		Document document = null;
		
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        
           DOMImplementation implementation = builder.getDOMImplementation();
           document = implementation.createDocument(null, "xml", null);
           
		for(int i=1;i<puntos.size();i++){
							
			lat=String.valueOf(puntos.get(i).getLatitud());
			lon=String.valueOf(puntos.get(i).getLongitud());
			           
	        try{
	        	//Creación de elementos
	          
	           Element tkrpt = document.createElement("trkpt"); 
	           //Element ele= document.createElement("ele");
	           //Text valorele = document.createTextNode("55.74");
	          
	           

	           //Asignamos la versión de nuestro XML
	           document.setXmlVersion("1.0"); 
	           //Añadimos el tkrpt al documento
	           document.getDocumentElement().appendChild(tkrpt); 
	           //añadimos los atributos al tkrpt
	           tkrpt.setAttribute("lat",lat);
	           tkrpt.setAttribute("lon",lon);
	         
	           //tkrpt.appendChild(ele);
	           
	           //ele.appendChild(valorele);
	           
	        }catch(Exception e){
	            System.err.println("Error");
	        }
	        
	        
		}
		
		
		//una vez creado todos los elementos necesario se guarda el archivo con el formato
		guardaConFormato(document, ruta);
		
		
        
   }
	
	


//guardar
public static void guardaConFormato(Document document, String url) throws IOException{
	
//String nombre = "archivo.txt";
	
	

    try {
        TransformerFactory transFact = TransformerFactory.newInstance();

        //Formateamos el fichero. Añadimos sangrado y la cabecera de XML
        transFact.setAttribute("indent-number", new Integer(3));
        Transformer trans = transFact.newTransformer();
        trans.setOutputProperty(OutputKeys.INDENT, "yes");
        trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");

        //Hacemos la transformación
        StringWriter sw = new StringWriter();
        StreamResult sr = new StreamResult(sw);
        DOMSource domSource = new DOMSource(document);
        trans.transform(domSource, sr);

        
        try {
            //Creamos fichero para escribir en modo texto
        	
            PrintWriter writer = new PrintWriter(new FileWriter(url));

            //Escribimos todo el árbol en el fichero
            writer.println(sw.toString());

            //Cerramos el fichero
            writer.close();
            System.out.println("EL ARCHIVO FUE CREADO CORRECTAMENTE :"+url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    } catch(Exception ex) {
        ex.printStackTrace();
    }
      
   
}
}
