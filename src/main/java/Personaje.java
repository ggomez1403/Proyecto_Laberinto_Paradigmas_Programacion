//Clase para definir colores
import java.awt.Color;
//Clase para dibujar el laberinto
import java.awt.Graphics;
//Importar librer�a de eventos para teclas
import java.awt.event.KeyEvent;

//clase para creacion del ovalo
public class Personaje {

	//Instanciar objeto de clase laberinto
	Laberinto lab = new Laberinto();
	//Coordenada eje x
	public int x = 40;
	//Coordenada en eje y
	public int y = 40;
	//Ancho del ovalo
	public final int ancho = 40;
	//Alto del ovalo
	public final int alto = 40;
	//Movimiento del ovalo
	public final int movimiento = 40;
	
	//Dibujar ovalo y definir color
	public void paint(Graphics grafico) {
		//Definir en rojo color del ovalo
		grafico.setColor(Color.red);
		//Aplicar coordenadas al ovalo
		grafico.fillOval(x, y, ancho, alto);
		//Establecer color del contorno
		grafico.setColor(Color.black);
		//Dibujar el ovalo con las propiedades
		grafico.drawOval(x, y, ancho, alto);
		//ojos
		grafico.setColor(Color.white);
		grafico.fillOval(x+7,y+8,13,13);
		grafico.fillOval(x+21,y+8,13,13);
		grafico.setColor(Color.black);
		grafico.fillOval(x+11,y+12,5,5);
		grafico.fillOval(x+25,y+12,5,5);
		//boca
		grafico.setColor(Color.black);
		grafico.fillOval(x+7,y+24,27,7);
		
	}
	
	//Metodo lectura de teclas presionadas por el usuario
	public void teclaPresionada(KeyEvent evento) {
		//Crear matriz invocando metodo obtiene laberinto
		int [][] laberinto = lab.obtieneLaberinto();	
		//Si lee la flecha Izquierda del teclado 
		if(evento.getExtendedKeyCode()==37) {
			//Verificar si hay muro para evitar movimiento 
			if(laberinto[y/40][(x/40)-1]!=1) {
			//ovalo se desplaza a la izquierda en eje x
			x = x - movimiento;
			}					
		}
		//Si lee la flecha Derecha del teclado 
		if(evento.getExtendedKeyCode()==39) {
			//Verificar si hay muro para evitar movimiento 
			if(laberinto[y/40][(x/40)+1]!=1) {
			// ovalo se desplaza a la derecha en eje x
			x = x + movimiento;	
			}
		}
		//Si lee la flecha Abajo del teclado 
		if(evento.getExtendedKeyCode()==40) {
			//Verificar si hay muro para evitar movimiento 
			if(laberinto[(y/40)+1][x/40]!=1) {
			//ovalo se desplaza hacia abajo en el eje y
			y = y + movimiento;
			}
		}
		//Si lee la flecha Arriba del teclado 
		if(evento.getExtendedKeyCode()==38) {
			//Verificar si hay muro para evitar movimiento 
			if(laberinto[(y/40)-1][x/40]!=1) {
			//�valo se desplaza hacia arriba en el eje y	
			y = y - movimiento;
			}
		}
		// si llega al final
		if(x==840 && y==440) {
			Juego.cambiaNivel();
			x=40;
			y=40;	
		}
	}
}
