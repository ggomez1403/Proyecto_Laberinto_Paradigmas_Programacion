import static org.junit.Assert.*;
import org.junit.Test;

public class JuegoTest {
	
	//Objeto de la clase Juego
	Juego juego = new Juego();
	
	// Test satisfactorio el cual debe obtener un número 1 al invocar método "obtieneNivel"
	@Test
	public void testObtieneNivel() {
	System.out.print(juego.obtieneNivel());
	assertTrue("PRUEBA EXITOSA: El nivel por defecto es 1", juego.obtieneNivel()==1);
	}
			
	// Test NO satisfactorio cuando el número sea distinto a 1
	@Test
	public void testNoObtieneNivel() {
	assertTrue("PRUEBA NO EXITOSA: El nivel por defecto al invocar el método debe ser 1", juego.obtieneNivel()!=1);
	}

	//Test satisfactorio el cual debe funcionar mientras que al invocar el método obtieneNivel, el resultado sea mayor a cero
	@Test
	public void testCambiaNivel() {
		assertTrue("PRUEBA EXITOSA",juego.cambiaNivel()>0);
	}

	//Test NO satisfactorio del método cambiaNivel, mientras que el valor sea igual a cero
	@Test
	public void testNivelCero() {
		assertEquals(0,juego.cambiaNivel());
	}	
	
}
