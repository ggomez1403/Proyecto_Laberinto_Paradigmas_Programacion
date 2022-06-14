//Clase para definir colores
import java.awt.Color;
//clase para dibujar el laberinto
import java.awt.Graphics;
//Clase para trabajar con archivos
import java.io.File;
//Clase excepciones
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
//Clases para trabajar con im�genes
import javax.imageio.ImageIO;
import java.awt.Image;


public class Laberinto {

	int[][]lab=new int[13][23];
	//Contador de filas
	private int fila = 0;
	//Contador columnas
	private int columna = 0;
	//N�mero de filas establecidas
	private final int numerofilas = 13;
	//N�mero de columnas establecidas
	private final int numeroColumnas = 23;
	//Ancho 
	private final int anchoBloque = 40;
	//Alto
	private final int altoBloque = 40;
	
	//Método paint para dibujar laberinto
	public void paint(Graphics grafico) {	
		//variable que invoca metodo Obtener laberinto 
		int[][]laberinto= obtieneLaberinto();
		//For anidados para recorrer filas y columnas
		//For para filas
		for(fila = 0;fila<numerofilas;fila++){
			//For para columnas		
			for(columna = 0;columna<numeroColumnas;columna++) {
					
				//Verifica si la fila y columna del laberinto es 1
				if(laberinto[fila][columna]==1) {
					if(Juego.obtieneNivel()==1) {grafico.setColor(Color.cyan);}
					if(Juego.obtieneNivel()==2) {grafico.setColor(Color.green);}
					if(Juego.obtieneNivel()>=3) {grafico.setColor(Color.orange);}
					grafico.fillRect(columna*40,fila*40,anchoBloque,altoBloque);
					grafico.setColor(Color.black);
					grafico.drawRect(columna*40,fila*40,anchoBloque,altoBloque);
				}
			}
		}
		grafico.drawString("Inicio", 5, 62);
		grafico.drawString("Fin", 850, 462);
	}
	//Obtener el laberinto
	  public int[][] obtieneLaberinto(){
		  if(Juego.obtieneNivel()==1) {
			  int laberinto[][]=
	                {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
	                { 1,0,0,1,0,0,0,0,1,0,0,0,1,0,1,0,0,0,0,0,0,1,1},
	                { 1,1,0,1,1,0,1,0,1,0,1,0,1,0,1,0,1,1,1,1,0,1,1},
	                { 1,1,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,0,1,0,1,1},
	                { 1,1,1,0,1,0,1,0,0,0,1,0,1,0,0,0,1,1,0,1,0,1,1},
	                { 1,1,0,0,1,0,1,0,1,1,1,0,1,0,1,0,0,0,0,1,0,1,1},
	                { 1,1,0,1,1,1,1,0,1,0,1,0,1,0,1,1,1,1,0,1,1,1,1},
	                { 1,1,0,1,0,0,0,0,1,0,0,0,1,0,0,1,0,1,0,0,0,1,1},
	                { 1,1,0,1,0,1,1,1,1,0,1,1,1,1,0,1,0,1,1,1,0,1,1},
	                { 1,1,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,1,0,1,0,1,1},
	                { 1,1,0,1,0,1,1,1,1,1,1,1,1,1,0,1,0,1,0,1,0,1,1},
	                { 1,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0},
	                { 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
			  lab=laberinto;
		  }
		  if(Juego.obtieneNivel()==2) {
			  int laberinto[][]=
	                {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
	                { 1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
	                { 1,1,1,0,1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,1,0,1,1},
	                { 1,1,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,1,1},
	                { 1,1,0,1,1,1,1,0,1,1,1,1,1,1,0,1,1,1,1,1,0,1,1},
	                { 1,1,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,1,1},
	                { 1,1,1,0,1,0,1,1,0,1,1,1,1,1,1,1,1,1,0,1,0,1,1},
	                { 1,1,0,0,1,0,1,0,0,0,1,0,0,0,0,0,0,0,0,1,0,1,1},
	                { 1,1,0,1,1,0,1,0,1,0,1,0,1,1,1,1,1,1,1,1,0,1,1},
	                { 1,1,0,1,0,0,0,0,1,0,1,0,0,1,0,0,0,0,0,1,0,1,1},
	                { 1,1,0,1,0,1,1,1,1,1,1,1,0,1,1,1,0,1,0,1,1,1,1},
	                { 1,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,1},
	                { 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
			  lab=laberinto;
		  }
		  if(Juego.obtieneNivel()==3) {
			  int laberinto[][]=
	                {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
	                { 1,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,1},
	                { 1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1},
	                { 1,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,1},
	                { 1,1,0,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1},
	                { 1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,1},
	                { 1,1,1,1,1,0,1,1,1,0,1,1,0,1,1,1,1,1,1,1,0,1,1},
	                { 1,1,0,0,0,0,0,1,1,0,0,0,1,0,0,0,0,0,0,0,0,1,1},
	                { 1,1,0,1,1,0,1,0,1,1,1,1,0,1,1,1,1,0,1,0,1,1,1},
	                { 1,1,0,1,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,1,1},
	                { 1,1,0,1,0,1,0,1,0,1,0,1,0,1,0,0,0,1,1,1,0,1,1},
	                { 1,1,0,0,0,1,0,1,0,1,0,0,0,1,0,0,0,1,0,0,0,0,1},
	                { 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
			  lab=laberinto;
		  }
	        return lab;
		}
}