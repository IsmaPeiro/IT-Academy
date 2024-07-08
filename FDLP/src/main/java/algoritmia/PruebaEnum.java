package algoritmia;

import java.sql.SQLOutput;

public class PruebaEnum {
    public static void main(String[] args) {
        enum Prueba {
            UNO(1),
            DOS(2);
            
            public int valor;
            
            Prueba(int valor) {
                this.valor = valor;
            }
            
            public int getValor() {
                return valor;
            }
        }
        System.out.println(Prueba.DOS.valor);
    }
}
