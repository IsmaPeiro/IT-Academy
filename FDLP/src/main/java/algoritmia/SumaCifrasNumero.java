package algoritmia;

public class SumaCifrasNumero {

	public static void main(String[] args) {
		int num=5546;
		int suma=0;
		
		while (num!=0) {
			suma+=num%10;
			num=num/10;
		}
		System.out.println(suma);
	}

}
