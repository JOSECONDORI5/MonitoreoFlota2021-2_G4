package monitoreo.modelos.impl;

import java.util.HashMap;
import java.util.Map;

import monitoreo.modelos.interfaces.ITipoServicio;
import monitoreo.modelos.interfaces.IVisitor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Despacho extends Punto {

    private String direccion;
    private String comentarios;
    private String documento;

    public Despacho(double lon, double lat) {
        super(lon, lat);
    }

    public Despacho(double lon, double lat, String direccion, String comentarios, String documento) {
        super(lon, lat);
        this.direccion = direccion;
        this.comentarios = comentarios;
        this.documento = documento;
    }

    public Despacho(ITipoServicio servicio, Double latitud, Double longitud)  {
        super(servicio, latitud, longitud);
    }

    public String getDireccion() {
        return direccion;
    }

    public String getComentarios() {
        return comentarios;
    }

    public String getDocumento() {
        return documento;
    }

    public void acceptImprimir(IVisitor visitor) {
        visitor.visitDespacho(this);
    }

    public Map<String, String> imprimirFormato() {

        System.out.println("\n[Visitor]-[Despacho] *********** FORNATO DESPACHO XXXX ***************");
        Map<String, String> salida = new HashMap<>();
        salida.put("comentarios", getComentarios());
        salida.put("direccion", getDireccion());
        salida.put("documento", getDocumento());
        Gson gson = new GsonBuilder().create();
        String jsonParse = gson.toJson(salida);
        System.out.println("[Visitor]-[Despacho] " + jsonParse);
        System.out.println("[Visitor]-[Despacho] *********** FORNATO DESPACHO XXXX ***************");
        return salida;
    }
    
    public Map<String, String> imprimirXML() {
        
        System.out.println("\n[Visitor]-[Despacho] *********** FORNATO DESPACHO XML ***************");
        Map<String, String> cadena = new HashMap<>();
        
        StringBuffer xml = new StringBuffer();
        xml.append("<impresion>");
        xml.append("<title>Formato XML</title>");
        xml.append("<despacho>");
        xml.append("<comentario>" + this.getComentarios() + "</comentario>");
        xml.append("<direccion>" + this.getDireccion() + "</direccion>");
        xml.append("<documento>" + this.getDocumento() + "</documento>");
        xml.append("</despacho>");
        xml.append("</impresion>");
        cadena.put("xml", xml.toString());
        System.out.println("[Visitor]-[Despacho] "+cadena.get("xml"));
        System.out.println("[Visitor]-[Despacho] *********** FORNATO DESPACHO XML ***************");

        return cadena;
    }

}
