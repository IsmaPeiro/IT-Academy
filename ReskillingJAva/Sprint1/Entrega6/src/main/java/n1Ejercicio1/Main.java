package n1Ejercicio1;

public class Main {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        n1Ejercicio2.Person p=new n1Ejercicio2.Person("","",2);
        NoGenericMethods ngm1=new NoGenericMethods("primero", "segundo", "tercero");
        NoGenericMethods ngm2=new NoGenericMethods("tercero", "primero","segundo");
        NoGenericMethods ngm3=new NoGenericMethods("segundo", "tercero","primero");
        
        System.out.println(ngm1);
        System.out.println(ngm2);
        System.out.println(ngm3);
    }
}
