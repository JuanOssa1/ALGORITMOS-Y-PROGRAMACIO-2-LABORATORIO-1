/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad Icesi (Cali - Colombia)
 * Propuesta de solución laboratorio Unidad 5
 * @author Camilo Barrios - camilo.barrios@correo.icesi.edu.co
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */


package interfaz;

import java.util.InputMismatchException;
import java.util.Scanner;
import modelo.Buscaminas;
import modelo.UnAvaiableCluesException;

public class Menu {
	
	// -----------------------------------------------------------------
	// Atributos y relaciones
	// -----------------------------------------------------------------
	
	/**
	 * Relacion con el modelo
	 */
	private Buscaminas juego;
	
	/**
	 * Atributo utilizado para la lectura de datos de consola
	 */
	private Scanner lector;


	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------
	
	/**
	 * Constructor de la clase Menu
	 * Se encarga de inicializar los atributos
	 */
	public Menu(){
		lector = new Scanner(System.in);
		mostrarBienvenida();
		int dificultad = seleccionarDificultad();
		juego = new Buscaminas(dificultad);
		manejoJuego();
	}


	// -----------------------------------------------------------------
	// Metodos
	// -----------------------------------------------------------------

	/**
	 * Metodo que tiene todo el manejo de un juego.
	 * Se encarga de la interaccion con el usuario y de delegar responsabilidades
	 */
	public void manejoJuego() {
		
		boolean salir = false;

		while (!salir) {

			mostrarTablero();
			int valorUsuario = menuJuego();

			switch (valorUsuario) {
			case 1:
				//Abrir una casilla
				
				if(!abrirCasilla()){
					System.out.println("La casilla ya estaba abierta o es incorrecta!");
					
				}
				//abrirCasilla();
				if (juego.darPerdio()) {
					System.out.println("X_X Perdiste al abrir una Mina :( ");
					mostrarTablero();
					salir = true;
				}

				if(juego.gano()){
					System.out.println("Felicitaciones Ganaste!!!!!!!");
				}
				break;

			case 2:
				try {
					System.out.println(juego.darPista());
				} catch (UnAvaiableCluesException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(juego.gano()){
					System.out.println("Felicitaciones Ganaste!!!!!!!");
				}
				break;

			case 3:
				//Ver Solucion
				mostrarTableroResuelto();
				salir = true;
				break;

			case 4:
				//Salir
				salir = true;
				break;

			default:
				System.out.println("Por favor digite una opción valida");
				break;
			}


		}

		System.out.println("******************************************************************"); 
		System.out.println("***************** Gracias por usar el programa *******************"); 
		System.out.println("******************************************************************"); 

	}



	/**
	 * Metodo encargado de abrir las casillas
	 * @return boolean, true si fue posible abrir la casilla, false en caso contrario
	 */
	public boolean abrirCasilla() {
		boolean abrir = false;//es false
		boolean continuarCiclo = true;
		do {
			
			int i = 0;
			int j = 0;
			System.out.println("Por favor digite el número de la fila que desea abrir");
			try {
				i = lector.nextInt();
				i--;
				
			}
			catch(InputMismatchException inputMismatchException){
				System.out.println("Ole ingrese numeros");
			}
				

			System.out.println("Por favor digite el número de la columna que desea abrir");
			try{
				j = lector.nextInt();lector.nextLine();
				j--;
					
			}
			catch(InputMismatchException inputMismatchException){
				System.out.println("Ole ingrese numeros");
			}
			//lector.nextLine();
			
			abrir = juego.abrirCasilla(i,j);
			continuarCiclo = false;
			
		/*
		if(i>=0 && i<juego.darCasillas().length && j>=0 && j<juego.darCasillas()[0].length){
			abrir = juego.abrirCasilla(i,j);			
		}else {
			System.out.println("Digitaste valores incorrectos");
		}
		 */
		}while(continuarCiclo);
		return abrir;
	}


	/**
	 * Método que se encarga mostrar el menu de un juego al usuario
	 * @return int - la seleccion del usuario
	 */
	public int menuJuego(){
		int valor = 0;
		System.out.println("Que deseas hacer ?");
		System.out.println("1. Abrir una casilla ");
		System.out.println("2. Dar pista ");
		System.out.println("3. Ver la solución del Buscaminas ");
		System.out.println("4. Salir ");
		try{
			valor = lector.nextInt();
		}
		catch(InputMismatchException inputMismatchException){
			System.out.println("No ingrese valores diferentes a numeros");
		}
		lector.nextLine();			
		return valor;
	}

	/**
	 * Metodo que se encarga de Mostrar el tablero en consola
	 */
	public void mostrarTablero() {
		System.out.println(juego.mostrarTablero());		
	}

	/**
	 *  Metodo que se encarga de Mostrar el tablero resuelto en consola
	 */
	public void mostrarTableroResuelto() {
		juego.resolver();
		System.out.println("******************************************************************"); 
		System.out.println("********************** Tablero Resuelto **************************"); 
		System.out.println("******************************************************************"); 
		mostrarTablero();
	}


	/**
	 * Metodo que muestra el Menu donde el usuario elige la dificultad del buscaminas
	 * @return int - el valor de dificultad seleccionado por el usuario
	 */
	public int seleccionarDificultad() {

		int seleccion = -1;

		while (seleccion<1 || seleccion>3) {

			System.out.println("Por favor elija el nivel de dificultad: ");
			System.out.println("1. Principiante ");
			System.out.println("2. Intermedio ");
			System.out.println("3. Experto ");
			try {
				seleccion = lector.nextInt();
				//lector.nextLine();
			}
			catch(InputMismatchException inputMismatchException){
				System.out.println("No ingrese valores diferentes a numeros");
			}
			lector.nextLine();

			if(seleccion<1 || seleccion>3){
				System.out.println("Por favor ingrese un valor correcto");
			}

		}

		return seleccion;
	}


	/**
	 * Metodo que muestra un banner de bienvenida
	 */
	public void mostrarBienvenida() {

		String mensaje = "";

		mensaje += "******************************************************************\n";
		mensaje += "****************** BIENVENIDO AL BUSCAMINAS **********************\n";
		mensaje += "*************** Desarrollado por: Camilo Barrios *****************\n";
		mensaje += "****************** <groovy.kmilo@gmail.com> **********************\n";
		mensaje += "********************** Universidad Icesi  ************************\n";
		mensaje += "******************************************************************\n";

		mensaje += mostrarBannerSeparacion();

		System.out.println(mensaje);
	}



	/**
	 * Este método permite mostrar un banner de separacion en el Menu. <br>
	 */
	public String mostrarBannerSeparacion() {
		StringBuilder all = new StringBuilder();
		all.append("\n");
		int ancho = 17;
		for (int a = 1; a <= 4; a++) {
			int cantidadAsteriscos = ancho - a;
			int cantidadEspacios = ancho - cantidadAsteriscos;
			int cantidadSlashes = (ancho - a) * 2;
			int cantidadDeBackSlashes = (a - 1) * 2;
			appendChars(all, '*', cantidadAsteriscos);
			appendChars(all, ' ', cantidadEspacios);
			appendChars(all, '/', cantidadSlashes);
			appendChars(all, '\\', cantidadDeBackSlashes);
			appendChars(all, ' ', cantidadEspacios);
			appendChars(all, '*', cantidadAsteriscos);
			all.append("\n");
		}

		for (int a = 4; a >= 1; a--) {
			int cantidadAsteriscos = ancho - a;
			int cantidadEspacios = ancho - cantidadAsteriscos;
			int cantidadDeBackSlashes = (ancho - a) * 2;
			int cantidadSlashes = (a - 1) * 2;
			appendChars(all, '*', cantidadAsteriscos);
			appendChars(all, ' ', cantidadEspacios);
			appendChars(all, '/', cantidadSlashes);
			appendChars(all, '\\', cantidadDeBackSlashes);
			appendChars(all, ' ', cantidadEspacios);
			appendChars(all, '*', cantidadAsteriscos);
			all.append("\n");
		}
		all.append("\n");
		return all.toString();
	}

	/**
	 * Este método permite concatenar los caracteres para el banner. <br>
	 */
	public void appendChars(StringBuilder sb, char c, int count) {
		for (int i = 0; i < count; i++) {
			sb.append(c);
		}
	}


	/**
	 * Meotdo main
	 * @param args
	 */
	public static void main(String[] args) {
		Menu m = new Menu();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
