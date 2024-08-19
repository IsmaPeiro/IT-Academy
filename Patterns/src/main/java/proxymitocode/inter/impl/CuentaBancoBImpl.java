package proxymitocode.inter.impl;

import proxymitocode.inter.ICuenta;
import proxymitocode.model.Cuenta;

public class CuentaBancoBImpl implements ICuenta {
    
    @Override
    public Cuenta retirarDinero(Cuenta cuenta, double monto) {
        double saldoActual= cuenta.getSaldoInicial() - monto;
        cuenta.setSaldoInicial(saldoActual);
        System.out.println("Se han retirado: " + monto);
        mostrarSaldo(cuenta);
        return cuenta;
    }
    
    @Override
    public Cuenta depositarDinero(Cuenta cuenta, double monto) {
        double saldoActual=cuenta.getSaldoInicial() + monto +0.20;
        cuenta.setSaldoInicial(saldoActual);
        System.out.println("Se han ingresado: " + monto);
        mostrarSaldo(cuenta);
        return cuenta;
    }
    
    @Override
    public void mostrarSaldo(Cuenta cuenta) {
        System.out.println("Saldo actual: " + cuenta.getSaldoInicial());
    }
}
