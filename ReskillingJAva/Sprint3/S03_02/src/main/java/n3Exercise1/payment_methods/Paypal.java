package n3Exercise1.payment_methods;

import n3Exercise1.callback.Callback;

public class Paypal {
    public void pay (int amount, Callback callback) {
        System.out.println("Realizando pago con Paypal...");
        
        String result="Pago de " + amount + " realizado con éxito";
        callback.call(result);
    }
}
