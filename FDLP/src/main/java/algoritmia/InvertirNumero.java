package algoritmia;

public class InvertirNumero {

	public static void main(String[] args) {
		//programa muestra invertido un número mayor a 9999
		
		long num=12345678;
		String invertir="";
		long numInvertido;
		
		while (num!=0) {			
			invertir+=num%10;
			num/=10;
		}
		
		numInvertido=Long.parseLong(invertir);
		System.out.println(numInvertido);
	}

}
