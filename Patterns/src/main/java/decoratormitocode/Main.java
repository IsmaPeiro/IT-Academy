package decoratormitocode;

import decoratormitocode.decorador.BlindajeDecorador;
import decoratormitocode.inter.ICuentaBancaria;
import decoratormitocode.inter.impl.CuentaAhorro;
import decoratormitocode.model.Cuenta;

public class Main {
    public static void main(String[] args) {
        Cuenta c=new Cuenta(1, "Mitocode");
        
        ICuentaBancaria cuenta=new CuentaAhorro();
        ICuentaBancaria cuentaBlindada=new BlindajeDecorador(cuenta);
        
        cuentaBlindada.abrirCuenta(c);
    }
}
