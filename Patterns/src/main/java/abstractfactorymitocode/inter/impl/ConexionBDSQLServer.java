package abstractfactorymitocode.inter.impl;

import abstractfactorymitocode.inter.IConexionBD;

public class ConexionBDSQLServer implements IConexionBD {
    
    private String host;
    private String puerto;
    private String usuario;
    private String constrasena;
    
    public ConexionBDSQLServer() {
        this.host="localhost";
        this.puerto="1433";
        this.usuario="postgres";
        this.constrasena="123";
    }
    
    @Override
    public void conectar() {
        // Aquí puede ir código JDBC
        System.out.println("Se conectó a SQLServer");
    }
    
    @Override
    public void desconectar() {
        // Aquí puede ir código JDBC
        System.out.println("Se desconectó a SQLServer");
    }
}
