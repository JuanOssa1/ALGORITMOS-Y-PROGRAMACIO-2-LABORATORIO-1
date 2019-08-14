package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.Arrays;
import org.junit.Test;

import modelo.Buscaminas;
import modelo.Casilla;
import modelo.UnAvaiableCluesException;

public class TestBuscaminas {

	private Buscaminas busca;
	
	
	private void setUpSceneInicializarMinasPRINCIPIANTE(){
		busca = new Buscaminas(Buscaminas.PRINCIPIANTE);
		busca.generarMinas();
	}
	private void setUpSceneInicializarMinasINTERMEDIO(){
		busca = new Buscaminas(Buscaminas.INTERMEDIO);
		busca.generarMinas();
	}
	private void setUpSceneInicializarMinasEXPERTO(){
		busca = new Buscaminas(Buscaminas.EXPERTO);
		busca.generarMinas();
	}
	@Test
	public void testInicializarMinas(){
		setUpSceneInicializarMinasPRINCIPIANTE();
		Casilla[][] casillas1 = busca.darCasillas();
		setUpSceneInicializarMinasPRINCIPIANTE();
		Casilla[][] casillas2 = busca.darCasillas();
		assertNotEquals(casillas1, casillas2);
		setUpSceneInicializarMinasINTERMEDIO();
		Casilla[][] casillas3 = busca.darCasillas();
		setUpSceneInicializarMinasINTERMEDIO();
		Casilla[][] casillas4 = busca.darCasillas();
		assertNotEquals(casillas3, casillas4);
		setUpSceneInicializarMinasEXPERTO();
		Casilla[][] casillas5 = busca.darCasillas();
		setUpSceneInicializarMinasEXPERTO();
		Casilla[][] casillas6 = busca.darCasillas();
		assertNotEquals(casillas5, casillas6);
	}
	private void setUpSceneInicializarCasillasLibresAntesDeDarlesValorP(){
		busca = new Buscaminas(Buscaminas.PRINCIPIANTE);
		busca.inicializarCasillasLibresAntesdeDarlesValor();
	}
	private void setUpSceneInicializarCasillasLibresAntesDeDarlesValorI(){
		busca = new Buscaminas(Buscaminas.INTERMEDIO);
		busca.inicializarCasillasLibresAntesdeDarlesValor();
	}
	private void setUpSceneInicializarCasillasLibresAntesDeDarlesValorE(){
		busca = new Buscaminas(Buscaminas.EXPERTO);
		busca.inicializarCasillasLibresAntesdeDarlesValor();
	}
	@Test
	public void testInicializarCasillasLibresAntesDeDarlesValor() {
		setUpSceneInicializarCasillasLibresAntesDeDarlesValorP();
		Casilla[][] casillaTestP = busca.darCasillas();
		assertNotNull(casillaTestP);
		setUpSceneInicializarCasillasLibresAntesDeDarlesValorI();
		Casilla[][] casillaTestI = busca.darCasillas();
		assertNotNull(casillaTestI);
		setUpSceneInicializarCasillasLibresAntesDeDarlesValorE();
		Casilla[][] casillaTestE = busca.darCasillas();
		assertNotNull(casillaTestE);
	
	}
	private void setUpScenecantidadMinasAlrededorP(){
		busca = new Buscaminas(Buscaminas.PRINCIPIANTE);
		Casilla[][] casillaTestP = new Casilla[Buscaminas.FILAS_PRINCIPIANTE][Buscaminas.COLUMNAS_PRINCIPIANTE];
		casillaTestP[2][2] =  new Casilla(Casilla.MINA);
		for(int i = 0; i<casillaTestP.length; i++){
			for(int j = 0; j<casillaTestP[0].length; j++){
				if(casillaTestP[i][j] == null){
					casillaTestP[i][j] = new Casilla(50);
				}
				busca.setCasillas(casillaTestP);
			}
		}
		
	}
	private void setUpScenecantidadMinasAlrededorI(){
		busca = new Buscaminas(Buscaminas.INTERMEDIO);
		Casilla[][] casillaTestP = new Casilla[Buscaminas.FILAS_INTERMEDIO][Buscaminas.COLUMNAS_INTERMEDIO];
		casillaTestP[0][0] =  new Casilla(Casilla.MINA);
		casillaTestP[0][1] =  new Casilla(Casilla.MINA);
		casillaTestP[0][2] =  new Casilla(Casilla.MINA);
		for(int i = 0; i<casillaTestP.length; i++){
			for(int j = 0; j<casillaTestP[0].length; j++){
				if(casillaTestP[i][j] == null){
					casillaTestP[i][j] = new Casilla(50);
				}
				busca.setCasillas(casillaTestP);
			}
		}
		
	}
	private void setUpScenecantidadMinasAlrededorE(){
		busca = new Buscaminas(Buscaminas.EXPERTO);
		Casilla[][] casillaTestP = new Casilla[Buscaminas.FILAS_EXPERTO][Buscaminas.FILAS_EXPERTO];
		casillaTestP[2][2] =  new Casilla(Casilla.MINA);
		casillaTestP[0][1] =  new Casilla(Casilla.MINA);
		casillaTestP[0][2] =  new Casilla(Casilla.MINA);
		for(int i = 0; i<casillaTestP.length; i++){
			for(int j = 0; j<casillaTestP[0].length; j++){
				if(casillaTestP[i][j] == null){
					casillaTestP[i][j] = new Casilla(50);
				}
				busca.setCasillas(casillaTestP);
			}
		}
		
	}
	@Test
	public void testCantidadMinasAlrededor(){
		setUpScenecantidadMinasAlrededorP();
		assertEquals(busca.cantidadMinasAlrededor(1, 1), 1);
	}
	@Test
	public void testCantidadMinasAlrededorI(){
		setUpScenecantidadMinasAlrededorI();
		assertEquals(busca.cantidadMinasAlrededor(1, 1), 3);
	}
	@Test
	public void testCantidadMinasAlrededorE(){
		setUpScenecantidadMinasAlrededorE();
		assertEquals(busca.cantidadMinasAlrededor(1, 1), 3);
	}

	private void setUpScenemostrarTableroP(){
		busca = new Buscaminas(Buscaminas.PRINCIPIANTE);
		Casilla[][] casillaTestP = new Casilla[Buscaminas.FILAS_PRINCIPIANTE][Buscaminas.COLUMNAS_PRINCIPIANTE];
		//casillaTestP[2][2] =  new Casilla(Casilla.MINA);
		for(int i = 0; i<casillaTestP.length; i++){
			for(int j = 0; j<casillaTestP[0].length; j++){
				if(casillaTestP[i][j] == null){
					casillaTestP[i][j] = new Casilla(50);
				}
				busca.setCasillas(casillaTestP);
			}
		}
	}
	private void setUpScenemostrarTableroI(){
		busca = new Buscaminas(Buscaminas.INTERMEDIO);
		Casilla[][] casillaTestP = new Casilla[Buscaminas.FILAS_INTERMEDIO][Buscaminas.COLUMNAS_INTERMEDIO];
		//casillaTestP[2][2] =  new Casilla(Casilla.MINA);
		for(int i = 0; i<casillaTestP.length; i++){
			for(int j = 0; j<casillaTestP[0].length; j++){
				if(casillaTestP[i][j] == null){
					casillaTestP[i][j] = new Casilla(50);
				}
				busca.setCasillas(casillaTestP);
			}
		}
	}
	private void setUpScenemostrarTableroE(){
		busca = new Buscaminas(Buscaminas.EXPERTO);
		Casilla[][] casillaTestP = new Casilla[Buscaminas.FILAS_EXPERTO][Buscaminas.COLUMNAS_EXPERTO];
		//casillaTestP[2][2] =  new Casilla(Casilla.MINA);
		for(int i = 0; i<casillaTestP.length; i++){
			for(int j = 0; j<casillaTestP[0].length; j++){
				if(casillaTestP[i][j] == null){
					casillaTestP[i][j] = new Casilla(50);
				}
				busca.setCasillas(casillaTestP);
			}
		}
	}
	
	
	
	
	@Test
	
	public void testScenemostrarTableroP(){
		setUpScenemostrarTableroP();
			String tablero=(  "   1  2  3  4  5  6  7  8  " +"\n"+
							  "1   -  -  -  -  -  -  -  -  " + "\n"+
							  "2   -  -  -  -  -  -  -  -  " + "\n"+
							  "3   -  -  -  -  -  -  -  -  " + "\n"+
						 	  "4   -  -  -  -  -  -  -  -  " + "\n"+
						 	  "5   -  -  -  -  -  -  -  -  " + "\n"+
							  "6   -  -  -  -  -  -  -  -  " + "\n"+
							  "7   -  -  -  -  -  -  -  -  " + "\n"+
							  "8   -  -  -  -  -  -  -  -  "  + "\n");
							  	assertEquals(tablero, busca.mostrarTablero());
	}
	
	@Test
	public void testScenemostrarTableroI(){
		setUpScenemostrarTableroI();
			String tablero=(  "   1  2  3  4  5  6  7  8  9  10  11 12 13 14 15 16 " +"\n"+
							  "1   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  "  + "\n"+
							  "2   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  "  + "\n"+
							  "3   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  "  + "\n"+
						 	  "4   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  "  + "\n"+
						 	  "5   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  "  + "\n"+
							  "6   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  "  + "\n"+
							  "7   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  "  + "\n"+
							  "8   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  "  + "\n"+
							  "9   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  "  + "\n"+
							  "10  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  "  + "\n"+
							  "11  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  "  + "\n"+
						   	  "12  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  "  + "\n"+
						 	  "13  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  "  + "\n"+
							  "14  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  "  + "\n"+
							  "15  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  "  + "\n"+
							  "16  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  " + "\n" ); 
		assertEquals(tablero, busca.mostrarTablero());
		//assertTrue(Arrays.equals(tablero, busca.mostrarTablero()));
	}
	@Test
	public void testScenemostrarTableroE(){
		setUpScenemostrarTableroE();
		String tablero=(  "   1  2  3  4  5  6  7  8  9  10  11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 "  +"\n"+
						  "1   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  "  +"\n"+
						  "2   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  "  +"\n"+
						  "3   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  "  +"\n"+
						  "4   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  "  +"\n"+
						  "5   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  "  +"\n"+
						  "6   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  "  +"\n"+
						  "7   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  " 	+"\n"+
						  "8   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  "  +"\n"+
						  "9   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  "  +"\n"+
						  "10  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  "  +"\n"+
						  "11  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  "  +"\n"+
						  "12  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  "  +"\n"+
						  "13  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  "  +"\n"+
						  "14  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  "  +"\n"+
						  "15  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  "  +"\n"+
						  "16  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  "  +"\n");
		assertEquals(tablero, busca.mostrarTablero());
	}
	private void setUpSceneResolver(){
		busca = new Buscaminas(Buscaminas.PRINCIPIANTE);
		
	}
	private void setUpSceneResolverI(){
		busca = new Buscaminas(Buscaminas.INTERMEDIO);
		
	}
	private void setUpSceneResolverE(){
		busca = new Buscaminas(Buscaminas.EXPERTO);
		
	}
	@Test
	public void testResolver(){
		setUpSceneResolver();
		busca.resolver();
		boolean close = true;
		Casilla[][] casillaTestP = new Casilla[Buscaminas.FILAS_PRINCIPIANTE][Buscaminas.COLUMNAS_PRINCIPIANTE];
		for(int i = 0; i< casillaTestP.length && close; i++ ){
			for(int j = 0; j < casillaTestP[0].length; j++){
				if(busca.darCasillas()[i][j].darSeleccionada() == false){
					close = false;
				}
			}
		}
		assertTrue(close);
	}
	
	@Test
	
	public void testResolverIn(){
		setUpSceneResolverI();
		busca.resolver();
		boolean close = true;
		Casilla[][] casillaTestP = new Casilla[Buscaminas.FILAS_INTERMEDIO][Buscaminas.COLUMNAS_INTERMEDIO];
		for(int i = 0; i< casillaTestP.length && close; i++ ){
			for(int j = 0; j < casillaTestP[0].length; j++){
				if(busca.darCasillas()[i][j].darSeleccionada() == false){
					close = false;
				}
			}
		}
		assertTrue(close);
	}
	
	@Test
	public void testResolverE(){
		setUpSceneResolverE();
		busca.resolver();
		boolean close = true;
		Casilla[][] casillaTestP = new Casilla[Buscaminas.FILAS_EXPERTO][Buscaminas.COLUMNAS_EXPERTO];
		for(int i = 0; i< casillaTestP.length && close; i++ ){
			for(int j = 0; j < casillaTestP[0].length; j++){
				if(busca.darCasillas()[i][j].darSeleccionada() == false){
					close = false;
				}
			}
		}
		assertTrue(close);
	}
	
	private void setUpSceneAbrirCasilla(){
		busca = new Buscaminas(Buscaminas.PRINCIPIANTE);
	}
	@Test
	public void testAbrirCasilla(){
		setUpSceneAbrirCasilla();
		boolean open = true;
		Casilla[][] casillaTestP = new Casilla[Buscaminas.FILAS_PRINCIPIANTE][Buscaminas.COLUMNAS_PRINCIPIANTE];
		busca.abrirCasilla(2, 2);
		for(int i = 0; i<casillaTestP.length; i++){
			for(int j = 0; j<casillaTestP[0].length; j++){
				casillaTestP[i][j] = new Casilla(Casilla.LIBRE);
			}
		}
		if(casillaTestP[2][2].darSeleccionada() == true){
			open = false;
		}
		//busca.setCasillas(casillaTestP);
		assertTrue(open);	
	}
	private void setUpSceneGanoP(){
		busca = new Buscaminas(Buscaminas.PRINCIPIANTE);
		Casilla[][] casillaTestP = busca.darCasillas();
		for(int i = 0; i<casillaTestP.length; i++){
			for(int j = 0; j<casillaTestP[0].length; j++){
				
				if(!casillaTestP[i][j].esMina()){
					casillaTestP[i][j].destapar();
					
				}
				
			}
		}
		
		
	}
	
	@Test
	public void testGanoP(){
		setUpSceneGanoP();
		assertTrue(busca.gano());
	}
	private void setUpSceneNoGanoP(){
		busca = new Buscaminas(Buscaminas.PRINCIPIANTE);
		Casilla[][] casillaTestP = busca.darCasillas();
		for(int i = 0; i<casillaTestP.length; i++){
			for(int j = 0; j<casillaTestP[0].length; j++){
				
				if(casillaTestP[i][j].esMina()){
					casillaTestP[i][j].destapar();
					
				}
				
			}
		}
		
		
	}
	@Test
	public void testNoGanoP(){
		setUpSceneNoGanoP();
		assertFalse(busca.gano());
	}
	private void setUpSceneDarPista(){
		busca = new Buscaminas(Buscaminas.PRINCIPIANTE);
		Casilla[][] casillaTestP = new Casilla[2][2];
		casillaTestP[0][1]= new Casilla(Casilla.MINA);
		busca.setCasillas(casillaTestP);
		busca.inicializarCasillasLibresAntesdeDarlesValor();
		busca.inicializarCasillasLibres();
			
	}
	@Test
	public void testDarPista(){
		setUpSceneDarPista();
		try {
			assertEquals(busca.darPista(), "La casilla abierta es  1 1");
		} catch (UnAvaiableCluesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void setUpSceneNoPista(){
		busca = new Buscaminas(Buscaminas.PRINCIPIANTE);
		Casilla[][] casillaTestP = new Casilla[2][2];
		casillaTestP[1][1]= new Casilla(Casilla.MINA);
		busca.setCasillas(casillaTestP);
		busca.inicializarCasillasLibresAntesdeDarlesValor();
		busca.inicializarCasillasLibres();
		busca.abrirCasilla(0, 1);
		busca.abrirCasilla(1, 0);
		busca.abrirCasilla(0, 0);	
	}
	@Test
	public void testNoPista(){
		setUpSceneNoPista();
		try {
			assertEquals(busca.darPista(), "No hay pistas para dar");
		} catch (UnAvaiableCluesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void setUpScenedarPerdio(){
		busca = new Buscaminas(Buscaminas.PRINCIPIANTE);
	
	}
	@Test
	public void testDarPerdio(){
		setUpScenedarPerdio();
		assertEquals(busca.darPerdio(), false);
	}
	private void setUpScenesetCasillas(){
		busca = new Buscaminas(Buscaminas.PRINCIPIANTE);
		Casilla[][] casillaTestP = new Casilla[2][2];
		casillaTestP[1][1]= new Casilla(Casilla.MINA);
		busca.setCasillas(casillaTestP);
		busca.inicializarCasillasLibresAntesdeDarlesValor();
		busca.inicializarCasillasLibres();
	}
	@Test
	public void testsetCasillas(){
		setUpScenesetCasillas();
		
		assertEquals(busca.cantidadMinasAlrededor(1, 1), 1);
	}
	
}
