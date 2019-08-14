/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad Icesi (Cali - Colombia)
 * Propuesta de solución laboratorio Unidad 5
 * @author Camilo Barrios - camilo.barrios@correo.icesi.edu.co
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */


package modelo;


public class Buscaminas {
	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------
	public static final int FILAS_PRINCIPIANTE = 8;
	public static final int FILAS_INTERMEDIO = 16;
	public static final int FILAS_EXPERTO = 16;
	public static final int COLUMNAS_PRINCIPIANTE = 8;
	public static final int COLUMNAS_INTERMEDIO = 16;
	public static final int COLUMNAS_EXPERTO = 30;
	public static final int PRINCIPIANTE = 1;
	public static final int INTERMEDIO = 2;
	public static final int EXPERTO = 3;
	public static final int CANTIDAD_MINAS_PRINCIPANTE = 10;
	public static final int CANTIDAD_MINAS_INTERMEDIO = 40;
	public static final int CANTIDAD_MINAS_EXPERTO = 99;
	// -----------------------------------------------------------------
	// Atributos y relaciones
	// -----------------------------------------------------------------
	private Casilla[][] casillas;
	private int nivel;
	private int cantidadMinas;
	private boolean perdio;
	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------
	/**
	 * Constructo de la clase Buscaminas
	 * @param nivel - el nivel seleccionado por el usuario
	 */
	public Buscaminas(int nivel) {
		this.nivel = nivel;
		perdio = false;
		try {
			inicializarPartida();
		} catch (UnAvaiableCluesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// -----------------------------------------------------------------
	// Metodos
	// -----------------------------------------------------------------
	/**
	 * Se encarga de inicializar los atributos y relaciones de la clase buscaminas a partir del nivel elegido por el usuario
	 * @throws UnAvaiableCluesException 
	 */
	private void inicializarPartida() throws UnAvaiableCluesException {
		
		if(nivel == 1){
			casillas = new Casilla[FILAS_PRINCIPIANTE][COLUMNAS_PRINCIPIANTE];
			cantidadMinas = CANTIDAD_MINAS_PRINCIPANTE;
		}
		else if(nivel == 2){
			casillas = new Casilla[FILAS_INTERMEDIO][COLUMNAS_INTERMEDIO];
			cantidadMinas = CANTIDAD_MINAS_INTERMEDIO;
		}
		else if(nivel == 3){
			casillas = new Casilla[FILAS_EXPERTO][COLUMNAS_EXPERTO];
			cantidadMinas = CANTIDAD_MINAS_EXPERTO;
		}
		else if(nivel > 3){
			throw new UnAvaiableCluesException("no se puede");
		}
		generarMinas();
		inicializarCasillasLibresAntesdeDarlesValor();
		inicializarCasillasLibres();
		
		
		
	}
	public void inicializarCasillasLibresAntesdeDarlesValor(){
		for(int i = 0; i<casillas.length; i++){
			for(int j=0; j<casillas[0].length; j++){
					if(casillas [i][j] == null){
						casillas [i][j] = new Casilla(Casilla.LIBRE);
					}
				} 
			}
	}


	/**
	 * Metodo que se encarga de inicializar todas las casillas que no son minas
	 */
	public void inicializarCasillasLibres() {
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[0].length; j++) {
				if(casillas[i][j].darValor() == -1) {
					casillas[i][j].modificarValor(cantidadMinasAlrededor(i, j));
				}
				
			}
			
		}
		
		

	}


	/**
	 * Metodo que permite contar la cantidad de minas que tiene alrededor una casillas
	 * @param i - La fila de la matriz
	 * @param j - la columna de la matriz
	 * @return int - La cantidad de minas que tiene alrededor la casilla [i][j]
	 */
	public int cantidadMinasAlrededor(int row, int column) { 
		int mineQuantity = 0;
		int delta = 1;
		for(int i = row - delta; i <= row + 1; i++  ){
			for(int j = column - delta; j <= column + 1; j++){
				if(i>=0 && i < casillas.length && j >= 0 && j < casillas[0].length){
					if(casillas[i][j].esMina()){
						mineQuantity++;
					}
				}
			}
		}
		return mineQuantity;
	}

	/**
	 * Método que se encarga de generar aleatoriomente las minas
	 * @throws LevelOutOfBoundsException 
	 */
	public void generarMinas()  {
		int rowBeginnerComplete = 0;
		int columnBeginnerComplete = 0;
		int rowIntermediateComplete = 0;
		int columnIntermediateComplete = 0;
		int rowExpertComplete = 0;
		int columnExpertComplete = 0;
		
			
			if(nivel == 1){
				for(int i = 0; i < CANTIDAD_MINAS_PRINCIPANTE; i++){
					double rowBeginner = Math.random() * FILAS_PRINCIPIANTE;
					rowBeginnerComplete = (int)rowBeginner;
					double columnBeginner = Math.random() * COLUMNAS_PRINCIPIANTE;
					columnBeginnerComplete = (int)columnBeginner;
					if( casillas [rowBeginnerComplete][columnBeginnerComplete] == null){
						casillas[rowBeginnerComplete][columnBeginnerComplete] = new Casilla(Casilla.MINA);
						//i++;
					}
				}
			}
			else if(nivel == 2){
				for(int i = 0; i < CANTIDAD_MINAS_INTERMEDIO; i++){
					double rowIntermediate = Math.random() * FILAS_INTERMEDIO;
					rowIntermediateComplete = (int)rowIntermediate;
					double columnIntermediate = Math.random() * COLUMNAS_INTERMEDIO;
					columnIntermediateComplete = (int)columnIntermediate;
					if( casillas [rowIntermediateComplete][columnIntermediateComplete] == null){
						casillas[rowIntermediateComplete][columnIntermediateComplete] = new Casilla(Casilla.MINA);
						//i++;
					}
				}
			}
			else if(nivel == 3){
				for(int i = 0; i < CANTIDAD_MINAS_EXPERTO; i++){
					double rowExpert = Math.random() * FILAS_EXPERTO;
					rowExpertComplete = (int)rowExpert;
					double columnExpert = Math.random() * COLUMNAS_EXPERTO;
					columnExpertComplete = (int)columnExpert;
					if( casillas [rowExpertComplete][columnExpertComplete] == null){
						casillas[rowExpertComplete][columnExpertComplete] = new Casilla(Casilla.MINA);
						//i++;
					}
				}
			}
			else{
				try {
					throw new LevelOutOfBoundsException("Error"); 
				}
				catch(LevelOutOfBoundsException e) {
					e.printStackTrace();
				}
				
			}
		
	}


	/**
	 * Metodo que se encarga de convertir el tablero a un String para poder verlo en pantalla
	 * @return String - El tablero en formato String
	 */
	public String mostrarTablero() {
		String tablero = "   ";
		for(int j = 0; j<casillas[0].length; j++){
			if(j<10){
				tablero += (j+1) + "  " ;
			}
			else {
				tablero += (j+1) + " ";
			}
		}
		tablero += "\n";
		for(int i = 0; i<casillas.length; i++){
			if(i<9){
				tablero +=(i+1) + "   " ;
			}
			else {
				tablero +=(i+1) + "  " ;
			}
			
			for(int j=0; j<casillas[0].length; j++){
						tablero +=  casillas [i][j].mostrarValorCasilla() + "  ";
						
				} 
			 tablero += "\n";
			}
		return tablero;
	}


	/**
	 * Metodo que se encarga de marcar todas las casillas como destapadas
	 */
	public void resolver() {

		for(int i = 0; i<casillas.length; i++){
			for(int j = 0; j<casillas[0].length;j++){
				casillas[i][j].destapar();
			}
		}
		
	}

	/**
	 * Metodo dar del atributo casillas
	 * @return la relacion casillas
	 */
	public Casilla[][] darCasillas(){
		return casillas;
	}


	/**
	 * Este metodo se encargaa de abrir una casilla
	 * Si se abre una casilla de tipo Mina, se marca que el jugador perdio el juego.
	 * @param i - la fila donde esta la casilla 
	 * @param j - la columna donde esta la casilla
	 * @return boolean - true si fue posible destaparla, false en caso contrario
	 */
	public boolean abrirCasilla(int i, int j) {
		
		boolean open = false;
		try {
			if(casillas[i][j].darSeleccionada() == false){
				casillas[i][j].destapar();
				open = true;
			}
			if(casillas[i][j].esMina() == true) {
				perdio = true;
			}
		}
		catch(ArrayIndexOutOfBoundsException e){
			
		}
		
		/*
		if(casillas[i][j].esMina()){
			perdio = true;
		}
		*/
		return open;
	}


	/**
	 * Metodo que se encarga de revisar si el jugador gano el juego
	 * @return boolean - true si gano el juego, false en caso contrario
	 */
	public boolean gano() {
		
		 boolean win = true;
		 
	        for(int i = 0; i <casillas.length && win; i++){
	            for(int j = 0; j<casillas[0].length && win; j++){
	                if(!casillas[i][j].darSeleccionada() && !casillas[i][j].esMina()){
	                    win = false;
	                }
	                else{
	                	darPerdio();
	                }

	            }
	        }

	        return win;
	    }
	/**
	 * Metodo que se encarga de abrir la primera casilla que no sea una Mina y cuyo valor sea Mayor que 0
	 * @return String, Mensaje de la Casilla que marco abierta, En caso de no haber casillas posibles para dar una pista, retorna el mensaje no hay pistas para dar
	 * @throws UnAvaiableCluesException 
	 * @throws Exception 
	 */
	public String darPista() throws UnAvaiableCluesException {
		//throw UnAvaiableCluesException;
		boolean centinel = false;
		String clue = "No hay pistas para dar";
		for(int i = 0; i< casillas.length && centinel == false ; i++) {
			for(int j = 0; j<casillas[0].length && centinel == false; j++){
				
				if(casillas[i][j].darValor() > 0 && casillas[i][j].darSeleccionada() == false && casillas[i][j].esMina() == false){
					casillas[i][j].destapar();
					centinel = true;
					clue = "La casilla abierta es " + " " + (i+1)+ " " + (j+1);
				}
			}
			
		}
		if(clue == "No hay pistas para dar"){
			try{
				throw new UnAvaiableCluesException(clue);
			}
			catch(UnAvaiableCluesException e){
				//e.printStackTrace();
			}
		}
		
		return clue;
	}
	
	/***
	 * Metodo dar del atributo perdio
	 * @return boolean el atributo
	 */
	public boolean darPerdio(){
		return perdio;
	}
	public void setCasillas(Casilla[][] matrix){
		casillas = matrix;
	}

}