package m8Ejercicio6.main;

import java.util.ArrayList;
import java.util.Scanner;

import m8Ejercicio6.herencia.*;

public class M8Ejercicio6 {

	public static void main(String[] args) {
		ArrayList<Tienda> tiendas=new ArrayList<Tienda>();
		
		Tienda tienda1=new Tienda();
		Tienda tienda2=new Tienda();
		Tienda tienda3=new Tienda();
		
		tiendas.add(tienda1);
		tiendas.add(tienda2);
		tiendas.add(tienda3);
		
		Cliente juan=new Cliente ("Juan", "11111111A");
		Cliente meri=new Cliente ("Meri", "22222222B");
		Cliente pablo=new Cliente ("Pablo", "33333333C");
		Cliente antonio=new Cliente ("Antonio", "44444444D");
		Cliente marta=new Cliente ("Marta", "55555555E");
		Cliente luis=new Cliente ("Luís", "66666666F");
		
		tienda1.registrarCliente(juan);
		tienda1.registrarCliente(meri);
		tienda2.registrarCliente(juan);
		tienda2.registrarCliente(pablo);
		tienda2.registrarCliente(antonio);
		tienda3.registrarCliente(marta);
		tienda3.registrarCliente(luis);
		
		ProductoElectronico pc=new ProductoElectronico ("PC", 2, 500, 450);
		ProductoElectronico portatil=new ProductoElectronico ("Pórtatil", 50, 1000, 350);
		ProductoElectronico lavadora=new ProductoElectronico ("Lavadora", 15, 300, 100);
		
		ProductoRopa camiseta=new ProductoRopa ("Camiseta", 50, 10, 20);
		ProductoRopa tejano=new ProductoRopa ("Tejano", 30, 25, 42);
		ProductoRopa chaqueta=new ProductoRopa ("Chaqueta", 25, 35, 35);
		
		ProductoAlimentario pastel=new ProductoAlimentario ("Pastel", 10, 15, 1000);
		ProductoAlimentario naranja=new ProductoAlimentario ("Naranja", 10, 1, 20);
		ProductoAlimentario agua=new ProductoAlimentario ("Agua", 10, 2, 0);
		
		tienda1.registrarProducto(pc);
		tienda1.registrarProducto(portatil);
		tienda2.registrarProducto(lavadora);
		tienda2.registrarProducto(camiseta);
		tienda3.registrarProducto(tejano);
		tienda3.registrarProducto(chaqueta);
		tienda1.registrarProducto(pastel);
		tienda1.registrarProducto(naranja);
		tienda2.registrarProducto(agua);
		
		juan.comprar(pc, tienda1);
		juan.comprar(pc, tienda1);
		juan.comprar(chaqueta, tienda1);
		meri.comprar(portatil, tienda1);
		pablo.comprar(lavadora, tienda2);
		antonio.comprar(camiseta, tienda2);
		marta.comprar(tejano, tienda3);
		luis.comprar(chaqueta, tienda3);
		juan.comprar(pastel, tienda1);
		meri.comprar(naranja, tienda1);
		pablo.comprar(agua, tienda2);
		juan.devolver(pc, tienda1);
		
		boolean sortir = false;

		do {
			switch (menu()) {
			case 1:
				registrarTienda(tiendas);
				break;
			case 2:
				eliminarTienda(tiendas);
				break;
			case 3:
				registrarProducto(tiendas);
				break;
			case 4:
				eliminarProducto(tiendas);
				break;
			case 5:
				verStocProducto(tiendas);
				break;
			case 6:
				verTienda(tiendas);
				break;
			case 7:
				verTodasTiendas(tiendas);
				break;
			case 8:
				registrarCliente(tiendas);
				break;
			case 9:
				eliminarCliente(tiendas);
				break;
			case 10:
				comprarPorCliente(tiendas);
				break;
			case 11:
				devolverPorCliente(tiendas);
				break;
			case 12:
				verCliente(tiendas);
				break;
			case 0:
				System.out.println("Gràcies per utilitzar l'aplicació");
				sortir = true;
				break;
			}
		} while (!sortir);
	}

	public static byte menu() {
		Scanner entrada = new Scanner(System.in);
		byte opcio;
		final byte MINIMO = 0;
		final byte MAXIMO = 14;

		do {
			System.out.println("\nMENú PRINCIPAL");
			System.out.println("***********GESTIÓN DE TIENDAS***********");
			System.out.println("1. Registrar Tienda.");
			System.out.println("2. Eliminar Tienda.");
			System.out.println("3. Registrar Producto en Tienda.");
			System.out.println("4. Eliminar Producto de Tienda.");
			System.out.println("5. Ver Stoc de producto en Tienda.");
			System.out.println("6. Ver Tienda.");
			System.out.println("7. Ver Todas las Tiendas.");
			System.out.println("***********GESTIÓN DE CLIENTES**********");
			System.out.println("8. Registrar Cliente en Tienda.");
			System.out.println("9. Eliminar Cliente de Tienda.");
			System.out.println("10. Comprar Producto por Cliente.");
			System.out.println("11. Devolver Producto por Cliente.");
			System.out.println("12. Ver Cliente.");			
			System.out.println("****************************************");
			System.out.println("0. Salir de la aplicación.\n");
			opcio = entrada.nextByte();
			if (opcio < MINIMO || opcio > MAXIMO) {
				System.out.println("Escoge una opción válida");
			}
		} while (opcio < MINIMO || opcio > MAXIMO);
		return opcio;
	}

	public static void registrarTienda(ArrayList<Tienda> tiendas) {
		Tienda tienda = new Tienda();
		tiendas.add(tienda);
		System.out.println("Tienda creada correctamente.");
		System.out.println("La nueva tienda se llama: "+tienda.getNombreTienda());
	}

	public static void eliminarTienda(ArrayList<Tienda> tiendas) {
		String nombreTienda;
		Tienda tienda = null;
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el nombre de la tienda:");
		nombreTienda = sc.nextLine();
		tienda = buscarTienda(tiendas, nombreTienda);
		if (tienda != null) {
			tiendas.remove(tienda);
			System.out.println("tienda eliminada correctamente.");
		} else {
			System.out.println("La tienda no existe en la Base de Datos.");
		}

	}

	public static void registrarProducto(ArrayList<Tienda> tiendas) {
		int opcion = 0;
		String nombreTienda = "";
		Tienda tienda = null;
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el nombre de la tienda:");
		nombreTienda = sc.nextLine();
		tienda = buscarTienda(tiendas, nombreTienda);
		if (tienda != null) {
			System.out.println("¿Qué tipo de producto deseas registrar?");
			System.out.println("1. Electrónico | 2. Ropa | 3. Alimentario | 0. Ninguno");
			opcion = sc.nextInt();
			sc.nextLine();
			switch (opcion) {
			case 1:
				registrarElectronico(tienda);
				break;
			case 2:
				registrarRopa (tienda);
				break;
			case 3:
				registrarAlimentario (tienda);
				break;
			case 0:
				System.out.println("Gracias, saliendo al menú");
				break;
			default:
				System.out.println("Opción incorrecta.");

			}
		} else {
			System.out.println("La tienda no existe en la Base de Datos.");
		}
	}

	public static void registrarElectronico(Tienda tienda) {
		String nombre = "";
		int stoc = 0, consumoKW = 0;
		double precio = 0;
		Producto producto = null;

		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el nombre del Producto:");
		nombre = sc.nextLine();
		producto = tienda.buscarProductoPorNombre(nombre);
		if (producto == null) {
			System.out.println("Introduce el stoc:");
			stoc = sc.nextInt();
			System.out.println("Introduce el precio:");
			precio = sc.nextDouble();
			System.out.println("Introduce el consumo en KW:");
			consumoKW = sc.nextInt();
			tienda.registrarProducto(new ProductoElectronico(nombre, stoc, precio, consumoKW));
			System.out.println("Producto registrado correctamente.");
		} else {
			System.out.println("El producto ya está registrado en la Tienda.");
		}
	}

	public static void registrarRopa(Tienda tienda) {
		String nombre = "";
		int stoc = 0, talla = 0;
		double precio = 0;
		Producto producto = null;

		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el nombre del Producto:");
		nombre = sc.nextLine();
		producto = tienda.buscarProductoPorNombre(nombre);
		if (producto == null) {
			System.out.println("Introduce el stoc:");
			stoc = sc.nextInt();
			System.out.println("Introduce el precio:");
			precio = sc.nextDouble();
			System.out.println("Introduce la talla:");
			talla = sc.nextInt();
			tienda.registrarProducto(new ProductoRopa(nombre, stoc, precio, talla));
			System.out.println("Producto registrado correctamente.");
		} else {
			System.out.println("El producto ya está registrado en la Tienda.");
		}
	}

	public static void registrarAlimentario(Tienda tienda) {
		String nombre = "";
		int stoc = 0, calorias = 0;
		double precio = 0;
		Producto producto = null;

		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el nombre del Producto:");
		nombre = sc.nextLine();
		producto = tienda.buscarProductoPorNombre(nombre);
		if (producto == null) {
			System.out.println("Introduce el stoc:");
			stoc = sc.nextInt();
			System.out.println("Introduce el precio:");
			precio = sc.nextDouble();
			System.out.println("Introduce las calorias:");
			calorias = sc.nextInt();
			tienda.registrarProducto(new ProductoAlimentario(nombre, stoc, precio, calorias));
			System.out.println("Producto registrado correctamente.");
		} else {
			System.out.println("El producto ya está registrado en la Tienda.");
		}
	}

	public static void eliminarProducto(ArrayList<Tienda> tiendas) {
		Scanner sc = new Scanner(System.in);
		String nombre = "", nombreTienda ="";
		Producto producto = null;
		int opcion = 0;
		Tienda tienda = null;

		System.out.println("Introduce el nombre de la tienda:");
		nombreTienda = sc.nextLine();
		tienda = buscarTienda(tiendas, nombreTienda);
		if (tienda != null) {
			System.out.println("Introduce el nombre del Producto:");
			nombre = sc.nextLine();
			producto = tienda.buscarProductoPorNombre(nombre);
			if (producto != null) {
				tienda.eliminarProducto(producto);
				System.out.println("Producto eliminado correctamente.");
			} else {
				System.out.println("El producto no existe en la tienda.");
			}
		} else {
			System.out.println("La tienda no existe.");
		}
	}
	
	public static void verStocProducto(ArrayList<Tienda> tiendas) {
		Scanner sc = new Scanner(System.in);
		String nombre = "", nombreTienda ="";
		Producto producto = null;
		int opcion = 0;
		Tienda tienda = null;

		System.out.println("Introduce el nombre de la tienda:");
		nombreTienda = sc.nextLine();
		tienda = buscarTienda(tiendas, nombreTienda);
		if (tienda != null) {
			System.out.println("Introduce el nombre del Producto:");
			nombre = sc.nextLine();
			producto = tienda.buscarProductoPorNombre(nombre);
			if (producto != null) {
				System.out.println("El stock de "+producto.getNombre()+" en la tienda "+
									tienda.getNombreTienda()+" es de: "+producto.getStoc()+" unidades.");				
			} else {
				System.out.println("El producto no existe en la tienda.");
			}
		} else {
			System.out.println("La tienda no existe.");
		}
	}
	
	public static void verTienda(ArrayList<Tienda> tiendas) {
		Scanner sc = new Scanner(System.in);		
		String nombreTienda ="";
		Tienda tienda = null;

		System.out.println("Introduce el nombre de la tienda:");
		nombreTienda = sc.nextLine();
		tienda = buscarTienda(tiendas, nombreTienda);
		if (tienda != null) {
			System.out.println(tienda);
		} else {
			System.out.println("la tienda no existe.");
		}
			
	}
	
	public static void verTodasTiendas(ArrayList<Tienda> tiendas) {
		for (Tienda tienda : tiendas) {
			System.out.println(tienda);
		}
	}
	
	public static void registrarCliente(ArrayList<Tienda> tiendas) {
		Scanner sc = new Scanner(System.in);		
		String nombre="", dni="";
		String nombreTienda = "";
		Tienda tienda = null;
		Cliente cliente=null;

		System.out.println("Introduce el nombre de la tienda:");
		nombreTienda = sc.nextLine();
		tienda = buscarTienda(tiendas, nombreTienda);
		if (tienda != null) {
			System.out.println("Introduce el dni del cliente:");
			dni=sc.nextLine();
			cliente=tienda.buscarCliente(dni);
			if (cliente==null) {
				System.out.println("Introduce el nombre del cliente:");
				nombre=sc.nextLine();
				tienda.registrarCliente(new Cliente(nombre, dni));
			} else {
				System.out.println("El cliente ya está registrado en la tienda.");
			}
		} else {
			System.out.println("la tienda no existe.");
		}
			
	}
	
	public static void eliminarCliente(ArrayList<Tienda> tiendas) {
		Scanner sc = new Scanner(System.in);		
		String nombre="", dni="";
		String nombreTienda = "";
		Tienda tienda = null;
		Cliente cliente=null;

		System.out.println("Introduce el nombre de la tienda:");
		nombreTienda = sc.nextLine();
		tienda = buscarTienda(tiendas, nombreTienda);
		if (tienda != null) {
			System.out.println("Introduce el dni del cliente:");
			dni=sc.nextLine();
			cliente=tienda.buscarCliente(dni);
			if (cliente!=null) {
				tienda.eliminarCliente(cliente);
			} else {
				System.out.println("El cliente no está registrado en la tienda.");
			}
		} else {
			System.out.println("la tienda no existe.");
		}
			
	}
	
	public static void comprarPorCliente(ArrayList<Tienda> tiendas) {
		Scanner sc = new Scanner(System.in);		
		String nombreProducto="", dni="";
		String nombreTienda = "";
		Tienda tienda = null;
		Cliente cliente=null;
		Producto producto=null;
		
		System.out.println("Introduce el nombre de la tienda:");
		nombreTienda = sc.nextLine();
		tienda = buscarTienda(tiendas, nombreTienda);
		if (tienda != null) {
			System.out.println("Introduce el dni del cliente:");
			dni=sc.nextLine();
			cliente=tienda.buscarCliente(dni);
			if (cliente!=null) {
				System.out.println("Introduce el nombre del producto:");
				nombreProducto=sc.nextLine();
				producto=tienda.buscarProductoPorNombre(nombreProducto);
				if (producto!=null) {
					cliente.comprar(producto, tienda);
				} else {
					System.out.println("El producto no existe en la tienda.");
				}
			} else {
				System.out.println("El cliente no está registrado en la tienda.");
			}
		} else {
			System.out.println("la tienda no existe.");
		}			
	}
	
	public static void devolverPorCliente(ArrayList<Tienda> tiendas) {
		Scanner sc = new Scanner(System.in);		
		String nombreProducto="", dni="";
		String nombreTienda = "";
		Tienda tienda = null;
		Cliente cliente=null;
		Producto producto=null;
		
		System.out.println("Introduce el nombre de la tienda:");
		nombreTienda = sc.nextLine();
		tienda = buscarTienda(tiendas, nombreTienda);
		if (tienda != null) {
			System.out.println("Introduce el dni del cliente:");
			dni=sc.nextLine();
			cliente=tienda.buscarCliente(dni);
			if (cliente!=null) {
				System.out.println("Introduce el nombre del producto:");
				nombreProducto=sc.nextLine();
				producto=tienda.buscarProductoPorNombre(nombreProducto);
				if (producto!=null) {
					cliente.devolver(producto, tienda);
				} else {
					System.out.println("El producto no existe en la tienda.");
				}
			} else {
				System.out.println("El cliente no está registrado en la tienda.");
			}
		} else {
			System.out.println("la tienda no existe.");
		}			
	}
	
	public static void verCliente (ArrayList<Tienda> tiendas ) {
		Scanner sc=new Scanner(System.in);
		String dni="";
		Cliente cliente=null;
		Tienda tiendaControl=null;
		System.out.println("introduce el dni del cliente:");
		dni=sc.nextLine();
		
		for (Tienda tienda : tiendas) {
			cliente=tienda.buscarCliente(dni);
			if (cliente!=null) {
				System.out.println("El cliente con dni: "+dni+" está registrado en la tienda: "+tienda.getNombreTienda());
				tiendaControl=tienda;
			}			
		}
		if (tiendaControl!=null) {
			System.out.println("\n"+tiendaControl.buscarCliente(dni));
		} else {
			System.out.println("El cliente no esta registrado en ninguna tienda.");
		}
	}

	public static Tienda buscarTienda(ArrayList<Tienda> tiendas, String nombre) {
		Tienda tienda = null;
		int i = 0;
		while (tienda == null && i < tiendas.size()) {
			if (tiendas.get(i).getNombreTienda().equalsIgnoreCase(nombre)) {
				tienda = tiendas.get(i);
			}
			i++;
		}
		return tienda;
	}
}
