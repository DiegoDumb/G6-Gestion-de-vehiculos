package consultasBD;

import java.sql.Statement;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.Writer;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.w3c.dom.NodeList;

import vehiculos.Camion;
import vehiculos.Turismo;


/**
 * 
 * @author diego
 * 
 * Se encarga de las operaciones que involucran archivos .xml
 * 
 * Para la creacion del archivo XML hemos usado las librerias del repositorio de dom4j 
 * y la carga de informacion de un .xml a la base de datos com DOM.
 * Estos permiten crear y leer documentos, creando un ArrayList con los elementos 
 * que equivaldrian a los atributos de la base de datos.
 * Definiendo el elemento raiz, el padre y los elementos hijos.
 *  
 */
public class XML {
	
	private Conexion conexion;
	private Connection con;
	
	public XML(){
		conexion = new Conexion();
		con = conexion.conectar();
	}
	
	/**
	 * 
	 * Se crea un archivo .xml basandose en las consultas a ejecutar en la sabe de datos.
	 * En este caso, toda la informacion pertinente con cada Turismo y cada Camion.
	 * 
	 */
	public void crearXML() {
		String strPath = "D:\\proyecto\\XML\\vehiculos.xml";
	    try {	
	    	Statement stmTurismo = con.createStatement();
	    	Statement stmCamion= con.createStatement();
	    	ResultSet resultTurismo = stmTurismo.executeQuery("select vehiculos.*, coches.num_puertas, coches.capacidad_maletero_dm3, series.marca, series.modelo, series.anio_fabricacion\r" + 
	    			"from vehiculos, coches, series\r" + 
	    			"where vehiculos.matricula = coches.matricula and vehiculos.serie = series.Nombre_Serie;");
	    	ResultSet resultCamion = stmCamion.executeQuery("select vehiculos.*, Camiones.carga_kg, Camiones.tipo_Mercancia, series.marca, series.modelo, series.anio_fabricacion\r" + 
	    			"from vehiculos, Camiones, series\r" + 
	    			"where vehiculos.matricula = Camiones.matricula and vehiculos.serie = series.Nombre_Serie;");
	    	Document document = DocumentHelper.createDocument();
	    	Element root = document.addElement("Vehiculos");
	    	
	    	for(int i =0; resultTurismo!=null && resultTurismo.next();i++) {
	    		Element coche = root.addElement("Turismo");
	    		coche.addElement("Matricula").addText(resultTurismo.getString(1));
	    		coche.addElement("NumeroBastidor").addText(resultTurismo.getString(2)); 
	    		coche.addElement("Color").addText(resultTurismo.getString(3));
	    		coche.addElement("NumeroDeAsientos").addText(resultTurismo.getString(4));
	    		coche.addElement("Precio").addText(resultTurismo.getString(5));
	    		coche.addElement("Serie").addText(resultTurismo.getString(6));
	    		coche.addElement("NumeroDePuertas").addText(resultTurismo.getString(7));
		    	coche.addElement("CapacidadDeMaleteroDm3").addText(resultTurismo.getString(8));
		    	coche.addElement("Marca").addText(resultTurismo.getString(9));
		    	coche.addElement("Modelo").addText(resultTurismo.getString(10));
		    	coche.addElement("AnioFabricacion").addText(resultTurismo.getString(11));
	    	}
	    	
	    	int j = 0;
	    	while(resultCamion != null && resultCamion.next()) {
	    		Element Camion = root.addElement("Camion");
	    		Camion.addElement("Matricula").addText(resultCamion.getString(1));
	    		Camion.addElement("NumeroBastidor").addText(resultCamion.getString(2));
	    		Camion.addElement("Color").addText(resultCamion.getString(3));
	    		Camion.addElement("NumeroDeAsientos").addText(resultCamion.getString(4));
	    		Camion.addElement("Precio").addText(resultCamion.getString(5));
	    		Camion.addElement("Serie").addText(resultCamion.getString(6));
	    		Camion.addElement("CargaEnKg").addText(resultCamion.getString(7));
	    		Camion.addElement("TipoMercancia").addText(resultCamion.getString(8));
	    		Camion.addElement("Marca").addText(resultCamion.getString(9));
	    		Camion.addElement("Modelo").addText(resultCamion.getString(10));
	    		Camion.addElement("AnioFabricacion").addText(resultCamion.getString(11));
	    		j++;
	    	}
	    	Writer writer = new OutputStreamWriter(new FileOutputStream(strPath), "UTF-8");
	        document.write(writer);
	        writer.close();
	        
	    } catch (Exception e){
	    	e.printStackTrace();
	    }finally {
			
		}
	}
	/**
	 * 
	 * Obtener toda la informacion del .xml creando un ArrayList por cada tipo de vehiculo
	 * para posteriormente enviarla a la base de datos.
	 * 
	 */
	public void cargarXML(){
		File archivo = new File("D:\\proyecto\\XML\\vehiculos.xml");
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            org.w3c.dom.Document document =  documentBuilder.parse(archivo);
            
            ((org.w3c.dom.Document) document).getDocumentElement().normalize();
            ((org.w3c.dom.Document) document).getDocumentElement().getNodeName();
            
            NodeList listaCamion = ((org.w3c.dom.Document) document).getElementsByTagName("Camion");
            NodeList listaTurismo = ((org.w3c.dom.Document) document).getElementsByTagName("Turismo");
            
	        Turismo turismo = new Turismo();
	        Camion camion = new Camion();
	        Stock s = new Stock();
	        
	        for(int i=0; i<listaCamion.getLength();i++) {
	        	org.w3c.dom.Node nodo = listaCamion.item(i);
	        	nodo.getNodeName();
	        	
	        	org.w3c.dom.Element element = (org.w3c.dom.Element) nodo;
	        	
	        	String numasientos = element.getElementsByTagName("NumeroDeAsientos").item(0).getTextContent();
                String precio = element.getElementsByTagName("Precio").item(0).getTextContent();
                String carga = element.getElementsByTagName("CargaEnKg").item(0).getTextContent();
                
	        	camion.setMatricula(element.getElementsByTagName("Matricula").item(0).getTextContent());
	        	camion.setNumBastidor(element.getElementsByTagName("NumeroBastidor").item(0).getTextContent());
	        	camion.setColor(element.getElementsByTagName("Color").item(0).getTextContent());
	        	camion.setNumAsientos(Integer.parseInt(numasientos));
	        	camion.setPrecio(Integer.parseInt(precio));
	        	camion.setNomSerie(element.getElementsByTagName("Serie").item(0).getTextContent());
	        	camion.setCarga(Integer.parseInt(carga));
	        	camion.setMercancia(element.getElementsByTagName("TipoMercancia").item(0).getTextContent());
	        	camion.setMarca(element.getElementsByTagName("Marca").item(0).getTextContent());
	        	camion.setModelo(element.getElementsByTagName("Modelo").item(0).getTextContent());
	        	camion.setAño(element.getElementsByTagName("AnioFabricacion").item(0).getTextContent());
	        	
	        	s.sumarStockCamion(camion);
	        	
	        }
	        
	        for(int i=0; i<listaTurismo.getLength();i++) {
	        	org.w3c.dom.Node nodo = listaTurismo.item(i);
	        	nodo.getNodeName();
	        	
	        	org.w3c.dom.Element element = (org.w3c.dom.Element) nodo;
	        	
	        	
	        	String numasientos = element.getElementsByTagName("NumeroDeAsientos").item(0).getTextContent();
                String precio = element.getElementsByTagName("Precio").item(0).getTextContent();
	        	String numpuertas = element.getElementsByTagName("NumeroDePuertas").item(0).getTextContent();
                String capMaletero= element.getElementsByTagName("CapacidadDeMaleteroDm3").item(0).getTextContent();
	        	
                turismo.setMatricula(element.getElementsByTagName("Matricula").item(0).getTextContent());
                turismo.setNumBastidor(element.getElementsByTagName("NumeroBastidor").item(0).getTextContent());
                turismo.setColor(element.getElementsByTagName("Color").item(0).getTextContent());
                turismo.setNumAsientos(Integer.parseInt(numasientos));
                turismo.setPrecio(Integer.parseInt(precio));
                turismo.setNomSerie(element.getElementsByTagName("Serie").item(0).getTextContent());
                turismo.setNumPuertas(Integer.parseInt(numpuertas));
                turismo.setCapacidadMaletero(Integer.parseInt(capMaletero));
                turismo.setMarca(element.getElementsByTagName("Marca").item(0).getTextContent());
                turismo.setModelo(element.getElementsByTagName("Modelo").item(0).getTextContent());
                turismo.setAño(element.getElementsByTagName("AnioFabricacion").item(0).getTextContent());
                
                s.sumarStockTurismo(turismo);
	        }
	        
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
		}
		
	}
	
}