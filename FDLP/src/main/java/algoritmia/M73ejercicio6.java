package algoritmia;

public class M73ejercicio6 {

	public static void main(String[] args) {
		/* 
		 * Donat un array de números, el programa ha de mostrar
		 * la suma de tots els nombres parells i la suma de tots els números imparells.
		 */
		
		int[] nums=new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		sumNums (nums);
	}
	
	public static void sumNums (int[] nums) {
		int sumPairs=0;
		int sumOdds=0;
		for (int num : nums) {
			if (num%2==0) {
				sumPairs+=num;
			}	else {
				sumOdds+=num;
			}			
		}
		System.out.println("La suma de los números pares es: "+sumPairs);
		System.out.println("La suma de los números impares es: "+sumOdds);
	}
}