package com.upse.rutas.gpx;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class PuntoCoordenadas {

	/*public void coordenadas(){
		List<Punto> punto=new  ArrayList<>();


		Punto p = new Punto();
		String ruta = "D:/Aplicaciones/Archivos/2017/8/4/Transcisa7.gpx";
		//Y generamos el objeto respecto a la ruta del archivo
		File archivo = new File(ruta);

		String info = "";
		List<String> gpxList = decodeGPX(archivo);
		for(int i = 0; i < gpxList.size(); i++){
			info = gpxList.get(i).toString();
			// System.out.println("info: "+info);
			String[] latlong = info.split(":");

			double latitude = Double.parseDouble(latlong[0]);
			double longitude = Double.parseDouble(latlong[1]);

			Punto q = new Punto(latitude,longitude);
			punto.add(q);


		}
		//String []puntoss=new String [punto.size()];
		//int[] numeros = new int[punto.size()];
		String puntosPaJS = "[";

		for(int i=0;i<punto.size();i++){
			//System.out.println("puntosOriginales: "+punto.get(i).toString());
			//puntoss[i]=punto.get(i).toString();
			if(i<punto.size()-1)
			{	
				puntosPaJS = puntosPaJS + punto.get(i).toString() + ",";
			}
			else{
				puntosPaJS = puntosPaJS + punto.get(i).toString() + "}";
			}
		}

	}*/
	
	/*private static List<String> decodeGPX(File is){
        List<String> list = new ArrayList<>();

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
          //  FileInputStream fileInputStream = new FileInputStream(is);
          Document document = documentBuilder.parse(is);
           Element elementRoot = document.getDocumentElement();

            NodeList nodelist_trkpt = document.getElementsByTagName("trkpt");

            for(int i = 0; i < nodelist_trkpt.getLength(); i++){

                Node node = nodelist_trkpt.item(i);
                NamedNodeMap attributes = node.getAttributes();

                String newLatitude = attributes.getNamedItem("lat").getTextContent();
                Double newLatitude_double = Double.parseDouble(newLatitude);

                String newLongitude = attributes.getNamedItem("lon").getTextContent();
                Double newLongitude_double = Double.parseDouble(newLongitude);

                String newLocationName = newLatitude + ":" + newLongitude;

                list.add(newLocationName);

            }

  //          is.close();

        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }
*/
}
