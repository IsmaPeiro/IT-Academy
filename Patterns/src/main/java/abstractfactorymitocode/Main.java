package abstractfactorymitocode;

import abstractfactorymitocode.inter.FabricaAbstracta;
import abstractfactorymitocode.inter.IConexionBD;
import abstractfactorymitocode.inter.IConexionREST;

public class Main {
    public static void main(String[] args) {
        FabricaAbstracta fabricaBD=FabricaProductor.getFactory("BD");
        IConexionBD cxBD1=fabricaBD.getBD("MYSQL");
        
        cxBD1.conectar();
        
        FabricaAbstracta fabricaREST=FabricaProductor.getFactory("REST");
        IConexionREST cxRS1=fabricaREST.getREST("COMPRAS");
        
        cxRS1.leerURL("https://www.youtube.com/subscription_center?add_user=mitocode");
        
    }
}
