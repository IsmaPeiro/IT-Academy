package factorymitocode.inter.impl;

import factorymitocode.inter.IConexion;

public class ConexionMySQL implements IConexion {
    
    private String host;
    private String puerto;
    private String usuario;
    private String constrasena;
    
    public ConexionMySQL() {
        this.host="localhost";
        this.puerto="3306";
        this.usuario="root";
        this.constrasena="123";
    }
    
    @Override
    public void conectar() {
        // Aquí puede ir código JDBC
        System.out.println("Se conectó a MySQL");
    }
    
    @Override
    public void desconectar() {
        // Aquí puede ir código JDBC
        System.out.println("Se desconectó a MySQL");
    }
}
