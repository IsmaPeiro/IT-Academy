package abstractfactorymitocode.inter.impl;

import abstractfactorymitocode.inter.IConexionREST;

public class ConexionRESTCompras implements IConexionREST {
    @Override
    public void leerURL(String url) {
        System.out.println("Conectándose a "+url);
    }
}
