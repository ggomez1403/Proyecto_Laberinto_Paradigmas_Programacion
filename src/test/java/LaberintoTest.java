import static org.junit.Assert.*;
import org.junit.Test;

public class LaberintoTest {
	
	//Objeto de la clase Juego
	Juego juego = new Juego();

	// Test satisfactorio mientras el método de la clase juego >> juego.obtieneNivel() esté entre 1 y 3
	@Test
	public void testObtieneLaberinto() {
	juego.obtieneNivel();
	assertTrue("PRUEBA EXITOSA",juego.obtieneNivel()>=1|juego.obtieneNivel()<=3);
	}
	
	//Test no satisfactorio, variable obtiene nivel es mayor a 3 o menor a 1
	@Test
	public void testNoObtieneLaberinto() {
	juego.obtieneNivel();
	assertTrue("PRUEBA NO EXITOSA: el nivel escogido no tiene asignado un laberinto", juego.obtieneNivel() > 3 |juego.obtieneNivel() <= 0);
	}
}
