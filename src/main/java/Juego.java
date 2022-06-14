//Clase para mostrar graficos
import javax.swing.JFrame;
import javax.swing.JOptionPane;
//Clase panel para setear propiedades de la ventana
import javax.swing.JPanel;
//clase para dibujar el laberinto
import java.awt.Graphics;
//Clase para lectura de teclas
import java.awt.event.KeyListener;
//Importar libreria de eventos para teclas
import java.awt.event.KeyEvent;
//Clases excepciones
import java.util.logging.Level;
import java.util.logging.Logger;


public class Juego extends JPanel{
	//Instanciar objeto de la clase laberinto
	Laberinto laberinto = new Laberinto();
	//Instanciar objeto de la clase Personaje
	static Personaje personaje = new Personaje();
	public static int nivel=1;
	
	
	//Constructor  
	public Juego(){
        addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                personaje.teclaPresionada(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        setFocusable(true);
    }
	
	//sobreescritura del metodo paint
	@Override
	public void paint(Graphics grafico){
		//Crear laberinto
		laberinto.paint(grafico);
		//Crear ovalo
		personaje.paint(grafico);
		
	}
	// avance de nivel
	public static int cambiaNivel(){
		return nivel++;
	}
	
	public static int obtieneNivel(){
		return nivel;
	}
	
	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "Grupo 28 - Paradigmas de programación\n\nGeraldine Gómez\nLeidy Delgado\nDavid Ramirez\nMiguel Perez\nJulian Preciado");
		JOptionPane.showMessageDialog(null, "Busca un salida del laberinto, responde correctamente las preguntas para completar el juego");
		// Se crea la ventana con el nombre del juego
		JFrame miVentana = new JFrame("Visual Lab");
		//Objeto de la clase Juego
		Juego game = new Juego();
		//Agregar al Jframe el objeto de la clase juego
		miVentana.add(game);
		//Tamano de la ventana en pixeles
		miVentana.setSize(935,560);
		//ubicacion de la ventana
		miVentana.setLocation(300,200);
		//Mostrar la ventana
		miVentana.setVisible(true);
		
		//
		miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Bucle para observar movimiento del ovalo
		while(true) {
			//delay
			try {
				Thread.sleep(10);
			} catch (InterruptedException ex) {
				// TODO Auto-generated catch block
				 Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
			}
			//Vuelve a pintar el juego
			miVentana.repaint();
			
			
			
			if(obtieneNivel()==1 && personaje.x == 40) {
				String respuesta = JOptionPane.showInputDialog(null, "Por favor, digite la letra de su respuesta\n\n ¿Cual es la raiz cuadrada de 16 ?\n A. 2\n B. 4\n C. 6\n D. 8");
				if(respuesta.equalsIgnoreCase("B")) {
					JOptionPane.showMessageDialog(null, "Respuesta Correcta");
					personaje.x = 80;
				} else {
					JOptionPane.showMessageDialog(null, "Respuesta Incorrecta\n\nIntentalo de nuevo");
				}
			}
			
			if(obtieneNivel()==2 && personaje.x == 40) {
				String respuesta = JOptionPane.showInputDialog(null, "Por favor, digite la letra de su respuesta\n\n ¿Cual es la Capital del departamento de Sucre?\n A. Sincelejo\n B. Mitu\n C. Valledupar\n D. Riohacha");
				if(respuesta.equalsIgnoreCase("A")) {
					JOptionPane.showMessageDialog(null, "Respuesta Correcta");
					personaje.x = 80;
				} else {
					JOptionPane.showMessageDialog(null, "Respuesta Incorrecta\n\nIntentalo de nuevo");
				}
			}
			
			if(obtieneNivel()==3 && personaje.x == 40) {
				String respuesta = JOptionPane.showInputDialog(null, "Por favor, digite la letra de su respuesta\n\n ¿Como se escribe en ingles el numero 15 ?\n A. fyfteen\n B. fifteen\n C. fyften\n D. fiften");
				if(respuesta.equalsIgnoreCase("B")) {
					personaje.x = 80;
					JOptionPane.showMessageDialog(null, "Respuesta Correcta");
				} else {
					JOptionPane.showMessageDialog(null, "Respuesta Incorrecta\n\nIntentalo de nuevo");
				}
			}
			
			if(obtieneNivel()>3) {
				JOptionPane.showMessageDialog(null, "¡Juego Completado!");
				System.exit(0);
			}
		}
	}

}