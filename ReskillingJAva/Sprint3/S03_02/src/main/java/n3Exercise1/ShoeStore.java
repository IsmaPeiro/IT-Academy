package n3Exercise1;

import n3Exercise1.callback.PaymentGateway;
import n3Exercise1.payment_methods.BankAccount;
import n3Exercise1.payment_methods.CreditCard;
import n3Exercise1.payment_methods.Paypal;

public class ShoeStore {
    PaymentGateway gateway=new PaymentGateway();
    
    CreditCard creditCard=new CreditCard();
    BankAccount bankAccount=new BankAccount();
    Paypal paypal=new Paypal();
    
    public void payments () {
        creditCard.pay(100, gateway);
        bankAccount.pay(54, gateway);
        paypal.pay(89, gateway);
    }
}
