package abstractfactorymitocode;

import abstractfactorymitocode.inter.FabricaAbstracta;
import abstractfactorymitocode.inter.IConexionBD;
import abstractfactorymitocode.inter.IConexionREST;
import abstractfactorymitocode.inter.impl.*;

public class ConexionBDFabrica implements FabricaAbstracta {
    //comentario de prueba
    @Override
    public IConexionBD getBD (String motor) {
        if (motor==null) {
            return new ConexionBDVacia();
        }
        if (motor.equalsIgnoreCase("MYSQL")) {
            return new ConexionBDMySQL();
        } else if (motor.equalsIgnoreCase("ORACLE")) {
            return new ConexionBDOracle();
        } else if (motor.equalsIgnoreCase("POSTGRE")) {
            return new ConexionBDPostgreSQL();
        } else if (motor.equalsIgnoreCase("SQL")) {
            return new ConexionBDSQLServer();
        }
        return new ConexionBDVacia();
    }
    
    @Override
    public IConexionREST getREST(String area) {
        return null;
    }
}
