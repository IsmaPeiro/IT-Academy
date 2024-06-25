package algoritmia;

import java.util.ArrayList;
import java.util.*;

public class ListIteratorEjemplo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> palabras=new ArrayList<String>();
		
		palabras.add("Ahora");
		palabras.add("Bajo");
		palabras.add("Cobra");
		palabras.add("Delta");
		palabras.add("Ele");
		palabras.add("Fonema");
		palabras.add("Geologo");
		palabras.add("Helice");
		palabras.add("Idiota");
		
		ListIterator<String> li=palabras.listIterator();
		
		while (li.hasNext()) {
			if (li.next().toLowerCase().contains("e")) {
				li.remove();
			}
		}
		System.out.println(palabras);
	}

}
