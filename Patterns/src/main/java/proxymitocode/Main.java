package proxymitocode;

import proxymitocode.inter.ICuenta;
import proxymitocode.inter.impl.*;
import proxymitocode.model.Cuenta;
import proxymitocode.proxy.CuentaProxy;

public class Main {
    public static void main(String[] args) {
        Cuenta c=new Cuenta(1, "Mitocode", 100);
        
        ICuenta cuenta=new CuentaProxy(new CuentaBancoBImpl());
        cuenta.mostrarSaldo(c);
        c=cuenta.depositarDinero(c, 50);
        c=cuenta.retirarDinero(c, 20);
        cuenta.mostrarSaldo(c);
    }
}
