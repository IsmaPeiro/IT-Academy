package abstractfactorymitocode.inter.impl;

import abstractfactorymitocode.inter.IConexionBD;

public class ConexionBDVacia implements IConexionBD {
    @Override
    public void conectar() {
        System.out.println("NO SE ESPECIFICÓ PROVEEDOR");
    }
    
    @Override
    public void desconectar() {
        System.out.println("NO SE ESPECIFICÓ PROVEEDOR");
    }
}
