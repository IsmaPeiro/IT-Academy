package abstractfactorymitocode;

import abstractfactorymitocode.inter.FabricaAbstracta;
import abstractfactorymitocode.inter.IConexionBD;
import abstractfactorymitocode.inter.IConexionREST;
import abstractfactorymitocode.inter.impl.ConexionRESTCompras;
import abstractfactorymitocode.inter.impl.ConexionRESTNoArea;
import abstractfactorymitocode.inter.impl.ConexionRESTVentas;

public class ConexionRESTFabrica implements FabricaAbstracta {
    @Override
    public IConexionREST getREST(String area) {
        if (area==null) {
            return new ConexionRESTNoArea();
        }
        if (area.equalsIgnoreCase("COMPRAS")) {
            return new ConexionRESTCompras();
        } else if (area.equalsIgnoreCase("VENTAS")) {
            return new ConexionRESTVentas();
        }
        return new ConexionRESTNoArea();
    }
    
    @Override
    public IConexionBD getBD(String motor) {
        return null;
    }
}
