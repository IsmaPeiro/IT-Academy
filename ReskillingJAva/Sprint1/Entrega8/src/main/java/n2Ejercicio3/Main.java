package n2Ejercicio3;

public class Main {
    public static void main(String[] args) {
        
        Operation addition=(par1, par2)->par1+par2;
        Operation subtraction=(par1, par2)->par1-par2;
        Operation multiplication=(par1, par2)->par1*par2;
        Operation division=(par1, par2)->par1/par2;
        
        System.out.println(addition.operation(5, 3));
        System.out.println(subtraction.operation(5, 3));
        System.out.println(multiplication.operation(5, 3));
        System.out.println(division.operation(5, 3));
    }
    
    @FunctionalInterface
    public interface Operation {
        float operation(float num1, float num2);
    }
}