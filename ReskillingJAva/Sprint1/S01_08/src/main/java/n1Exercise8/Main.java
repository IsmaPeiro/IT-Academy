package n1Exercise8;

public class Main {
    public static void main(String[] args) {
        /*Reverse r = parameter -> {
            String s = "";
            for (int i = parameter.length() - 1; i >= 0; i--) {
                s += parameter.charAt(i);
            }
            return s;
        };*/
        
        Reverse r= p->(new StringBuilder(p).reverse().toString());
        
        System.out.println(r.reverse("Palabra"));
    }
}
