
package monitoreo.modelos.impl;

import java.util.Map;
import monitoreo.modelos.interfaces.IVisitor;

public class XMLImpresoVisitor implements IVisitor {

    @Override
    public Map<String, String> visitRecojo(Recojo recojo) {
        return recojo.imprimirXML();
    }

    @Override
    public Map<String, String> visitDespacho(Despacho despacho) {
        return despacho.imprimirXML();
    }

}
