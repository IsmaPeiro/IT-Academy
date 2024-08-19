package singletonmitocode;

public class Main {
    public static void main(String[] args) {
        //Instanciació  por constructor prohibido por ser private
        //Conexión c=new Conexión();
        Conexion c=Conexion.getInstancia(1);
        c.conectar();
        c.desconectar();
        
        boolean rpta=c instanceof Conexion;
        System.out.println(rpta);
        
        //Aunque creemos otra instancia con el metodo getInstancia
        //apuntará a la instancia previamente creada
        Conexion c2=Conexion.getInstancia(2);
        c.conectar();
        c2.desconectar();
    }
}
