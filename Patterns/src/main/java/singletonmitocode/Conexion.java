package singletonmitocode;

public class Conexion {
    
    //Declaración
    private static Conexion instancia;
    private int id;
    //Para evitar instancia mediante operador "new"
    private Conexion(int id) {
        this.id=id;
    }
    
    //Para obtener la instancia unicamente por este método
    //Notese la palabra reservada "static" hace posible el acceso mediante Clase.metodo
    public static Conexion getInstancia(int id) {
        if (instancia==null) {
            instancia= new Conexion(id);
        }
        return instancia;
    }
    
    //Método de prueba
    public void conectar() {
        System.out.println("Me conecté a la BD"+this.id);
    }
    
    //Método de prueba
    public void desconectar() {
        System.out.println("Me desconecté de la BD"+this.id);
    }
}
