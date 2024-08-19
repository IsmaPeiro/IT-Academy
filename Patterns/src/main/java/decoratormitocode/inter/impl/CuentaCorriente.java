package decoratormitocode.inter.impl;

import decoratormitocode.inter.ICuentaBancaria;
import decoratormitocode.model.Cuenta;

public class CuentaCorriente implements ICuentaBancaria {
    
    @Override
    public void abrirCuenta(Cuenta c) {
        System.out.println("-----------------------");
        System.out.println("Se abrió una Cuenta Corriente");
        System.out.println("Cliente: " + c.getCliente());
    }
}