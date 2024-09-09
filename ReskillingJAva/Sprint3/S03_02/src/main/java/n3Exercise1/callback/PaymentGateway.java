package n3Exercise1.callback;

public class PaymentGateway implements Callback {
    @Override
    public void call(String result) {
        System.out.println("Conectando con la pasarela de pago\n" + result);
    }
}
