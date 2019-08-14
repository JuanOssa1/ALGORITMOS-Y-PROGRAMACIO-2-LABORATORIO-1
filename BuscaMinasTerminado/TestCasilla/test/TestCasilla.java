package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import modelo.Casilla;

public class TestCasilla {

	private Casilla casillas;
	
	private void setUpEscenaryYesMine(){
		casillas = new Casilla(Casilla.MINA);
	}
	private void setUpEscenaryNoMine(){
		casillas = new Casilla(Casilla.LIBRE);
	}
	@Test
	public void testYesMine(){
		setUpEscenaryYesMine();
		assertTrue(casillas.esMina());
	}
	@Test
	public void testNoMine(){
		setUpEscenaryNoMine();
		assertFalse(casillas.esMina());
	}
	
	
	private void setUpEscenarySpeceBoxValueMINA(){
		casillas = new Casilla(Casilla.MINA);
		casillas.destapar();
		casillas.darSeleccionada();
	}
	private void setUpEscenarySpeceBoxValueLIBRE(){
		casillas = new Casilla(Casilla.LIBRE);
		casillas.darSeleccionada();
	}
	@Test
	public void testDarValorMina(){
		setUpEscenarySpeceBoxValueMINA();
		String actu = casillas.mostrarValorCasilla();
		assertEquals("*", actu);
	}
	@Test
	public void testDarValorLibre(){
		setUpEscenarySpeceBoxValueLIBRE();
		String actu = casillas.mostrarValorCasilla();
		assertEquals("-", actu);
	}
	private void setUpSceneDestaparLIBRE(){
		casillas = new Casilla(Casilla.LIBRE);
	}
	private void setUpSceneDestaparMINA(){
		casillas = new Casilla(Casilla.MINA);
	}
	@Test
	public void testDestaparLIBRE(){
		setUpSceneDestaparLIBRE();
		casillas.destapar();
		assertTrue(casillas.darSeleccionada());
	}
	@Test
	public void testDestaparMINA(){
		setUpSceneDestaparMINA();
		casillas.destapar();
		assertTrue(casillas.darSeleccionada());
	}
	private void setUpScenedarSeleccionada(){
		casillas = new Casilla(Casilla.LIBRE);
	}
	@Test
	public void testDarSeleccionadaNoOpenened(){
		setUpScenedarSeleccionada();
		assertFalse(casillas.darSeleccionada());
	}
	@Test
	public void testDarSeleccionadaOpenened(){
		setUpScenedarSeleccionada();
		casillas.destapar();
		assertTrue(casillas.darSeleccionada());
	}
	private void testScenedarValor(){
		casillas = new Casilla(Casilla.LIBRE);
	}
	@Test
	public void testDarValor(){
		testScenedarValor();
		assertEquals(casillas.darValor(), -1);
	}

}
