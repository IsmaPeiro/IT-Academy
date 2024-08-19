package abstractfactorymitocode.inter.impl;

import abstractfactorymitocode.inter.IConexionBD;

public class ConexionBDOracle implements IConexionBD {
    private String host;
    private String puerto;
    private String usuario;
    private String constrasena;
    
    public ConexionBDOracle() {
        this.host="localhost";
        this.puerto="1521";
        this.usuario="admin";
        this.constrasena="123";
    }
    
    @Override
    public void conectar() {
        // Aquí puede ir código JDBC
        System.out.println("Se conectó a Oracle");
    }
    
    @Override
    public void desconectar() {
        // Aquí puede ir código JDBC
        System.out.println("Se desconectó a Oracle");
    }
}