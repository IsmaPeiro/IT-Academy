package m8ejercicio5;

public class M8Ejercicio5 {

	public static void main(String[] args) {
		Punto centro1=new Punto(-5,5);
		Punto centro2=new Punto(8,4);
		
		Circulo circulo1=new Circulo (centro1, 3);
		Circulo circulo2=new Circulo (centro2, 15);
		
		System.out.println("La distancia entre los centros de los círculos es:");
		System.out.println(circulo1.distanciaCentros(circulo2));		
		
		
		System.out.println (circulo1.equals(circulo2) ? "Los dos círculos son iguales." : "Los círculos son diferentes.");
		
		System.out.println (circulo1.sonConcentricos(circulo2) ? "Los dos círculos son concentricos." : "Los círculos no son concentricos.");
		
		System.out.println (circulo1.tienenIgualRadio(circulo2) ? "Los dos círculos tienen igual radio." : "Los círculos no tienen igual radio.");
		
		System.out.println (circulo1.sonTangentes(circulo2) ? "Los dos círculos son tangentes." : "Los círculos no son tangentes.");
		
		System.out.println (circulo1.sonSecantes(circulo2) ? "Los dos círculos son secantes." : "Los círculos no son secantes.");
		
		System.out.println (circulo1.noSeTocan(circulo2) ? "Los dos círculos no se tocan." : "Los círculos se tocan.");
	}

}
