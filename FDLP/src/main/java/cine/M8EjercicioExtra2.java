package cine;

import java.util.ArrayList;

public class M8EjercicioExtra2 {

	public static void main(String[] args) {
		ArrayList<Espectador> espectadores=new ArrayList<Espectador>();
		
		int i=0;
		boolean salaLlena=false;
		
		Espectador espectador1=new Espectador ("Juan", (int) Math.floor(Math.random() * 99), (int) Math.floor(Math.random() * 20));
		Espectador espectador2=new Espectador ("Pedro", (int) Math.floor(Math.random() * 99), (int) Math.floor(Math.random() * 20));
		Espectador espectador3=new Espectador ("Carla", (int) Math.floor(Math.random() * 99), (int) Math.floor(Math.random() * 20));
		Espectador espectador4=new Espectador ("Susana", (int) Math.floor(Math.random() * 99), (int) Math.floor(Math.random() * 20));
		Espectador espectador5=new Espectador ("Luís", (int) Math.floor(Math.random() * 99), (int) Math.floor(Math.random() * 20));
		Espectador espectador6=new Espectador ("Rosa", (int) Math.floor(Math.random() * 99), (int) Math.floor(Math.random() * 20));
		Espectador espectador7=new Espectador ("Quilian", (int) Math.floor(Math.random() * 99), (int) Math.floor(Math.random() * 20));
		Espectador espectador8=new Espectador ("Wallace", (int) Math.floor(Math.random() * 99), (int) Math.floor(Math.random() * 20));
		Espectador espectador9=new Espectador ("Ramón", (int) Math.floor(Math.random() * 99), (int) Math.floor(Math.random() * 20));
		Espectador espectador10=new Espectador ("Teresa", (int) Math.floor(Math.random() * 99), (int) Math.floor(Math.random() * 20));
		Espectador espectador11=new Espectador ("Yolanda", (int) Math.floor(Math.random() * 99), (int) Math.floor(Math.random() * 20));
		Espectador espectador12=new Espectador ("Isma", (int) Math.floor(Math.random() * 99), (int) Math.floor(Math.random() * 20));
		Espectador espectador13=new Espectador ("Olivia", (int) Math.floor(Math.random() * 99), (int) Math.floor(Math.random() * 20));
		Espectador espectador14=new Espectador ("Pablo", (int) Math.floor(Math.random() * 99), (int) Math.floor(Math.random() * 20));
		Espectador espectador15=new Espectador ("Ana", (int) Math.floor(Math.random() * 99), (int) Math.floor(Math.random() * 20));
		Espectador espectador16=new Espectador ("Samantha", (int) Math.floor(Math.random() * 99), (int) Math.floor(Math.random() * 20));
		Espectador espectador17=new Espectador ("Daniel", (int) Math.floor(Math.random() * 99), (int) Math.floor(Math.random() * 20));
		Espectador espectador18=new Espectador ("Federico", (int) Math.floor(Math.random() * 99), (int) Math.floor(Math.random() * 20));
		Espectador espectador19=new Espectador ("Jorge", (int) Math.floor(Math.random() * 99), (int) Math.floor(Math.random() * 20));
		Espectador espectador20=new Espectador ("Natalia", (int) Math.floor(Math.random() * 99), (int) Math.floor(Math.random() * 20));
		
		espectadores.add(espectador1);
		espectadores.add(espectador2);
		espectadores.add(espectador3);
		espectadores.add(espectador4);
		espectadores.add(espectador5);
		espectadores.add(espectador6);
		espectadores.add(espectador7);
		espectadores.add(espectador8);
		espectadores.add(espectador9);
		espectadores.add(espectador11);
		espectadores.add(espectador12);
		espectadores.add(espectador13);
		espectadores.add(espectador14);
		espectadores.add(espectador15);
		espectadores.add(espectador16);
		espectadores.add(espectador17);
		espectadores.add(espectador18);
		espectadores.add(espectador19);
		espectadores.add(espectador20);
		
		Pelicula pelicula=new Pelicula ("The Room", 122, 16, "Tommy Wiseau");
		
		Cine cine=new Cine(pelicula, 5);
		
		System.out.println("Llenando la sala para la película " + pelicula.getTitulo() + " con precio " + cine.getPrecio()
				+ "€ para mayores de " + pelicula.getEdadMinima() + " años.");
		
		while (i<espectadores.size()&&!salaLlena) {
			if (cine.ocuparButaca(espectadores.get(i))) {
				salaLlena=true;
			} 
			i++;
		}
				
		System.out.println("Se han gestionado todos los espectadores");		
	}
}
