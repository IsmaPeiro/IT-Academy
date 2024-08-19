package factorymitocode.inter.impl;

import factorymitocode.inter.IConexion;

public class ConexionPostgreSQL implements IConexion {
    private String host;
    private String puerto;
    private String usuario;
    private String constrasena;
    
    public ConexionPostgreSQL() {
        this.host="localhost";
        this.puerto="5433";
        this.usuario="postgres";
        this.constrasena="123";
    }
    
    @Override
    public void conectar() {
        // Aquí puede ir código JDBC
        System.out.println("Se conectó a PostgreSQL");
    }
    
    @Override
    public void desconectar() {
        // Aquí puede ir código JDBC
        System.out.println("Se desconectó a PostgreSQL");
    }
}