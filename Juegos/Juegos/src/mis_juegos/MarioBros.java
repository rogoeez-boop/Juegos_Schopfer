package mis_juegos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/*
 * la libreria awt encuentra los eventos los cuales manejamos para el uso del teclado.
 * la libreria swing la utilizamos para el uso de la clase JPanel y as como sus componentes.
 */

// Se esta heredando de la clase JPanel para hacer uso de sus componentes como botones, lista desplegable, casillas de verificación, cajas
// dibujar en pantalla como figuras 2D
public class MarioBros extends JPanel {
    private Image personaje;     // Imagen actual
    private Image quieto;        // Imagen cuando está parado
    private Image saltando;      // Imagen cuando salta
    private Image fondo;         // Imagen fondo / mapa del juego
    private Image correDerecha;
    private Image corrreIzquierda;
    private Image agachado;
    private Image salto;
    private int x = 400, y = 230; // estas coordenadas son la posición inicial de la imagen en la ventana

 // Banderas de movimiento
    private boolean moverDerecha = false;
    private boolean moverIzquierda = false;
    private boolean moverArriba = false;
    private boolean moverAbajo = false;
    
 // Timer que se ejecuta cada 50 ms (20 FPS aprox.)
    ;
    public MarioBros() {
        // Cargar imágenes y ruta de imagenes
        quieto = new ImageIcon("imagenes_mario/stop.gif").getImage(); // ruta de tu imagen
        fondo = new ImageIcon("mapas/fondo.gif").getImage();  // fondo
        correDerecha = new ImageIcon("imagenes_mario/correr2.gif").getImage();
        agachado = new ImageIcon("imagenes_mario/agachado.gif").getImage();
        corrreIzquierda = new ImageIcon("imagenes_mario/correIzquierda.gif").getImage();
        salto = new ImageIcon("imagenes_mario/salto.gif").getImage();

        personaje = quieto; // Empieza en quieto

        // Escuchar las teclas
        setFocusable(true); // Con este metodo estamos agregando al panel que va a recibir acciones por el teclado 
        // se inicializa en true activar el teclado.
        addKeyListener(new KeyAdapter() {
        	
            @Override
            //
            public void keyPressed(KeyEvent e) {
            	int key = e.getKeyCode();
            	
            	switch(key) {
            	case KeyEvent.VK_D:
                    personaje = correDerecha;
                    x+=5;
                    break;
            	case KeyEvent.VK_A:
                    personaje = corrreIzquierda; // cambia la imagen
                    x -= 5;
                    break;
            	case KeyEvent.VK_W:
                    personaje = salto; // cambia la imagen
                    y-=5;
                    break; 
            	case KeyEvent.VK_S:
                    personaje = agachado; // cambia la imagen
                    y+=5;
                    break;
            	}
            	repaint();
            }
            @Override
            public void keyReleased(KeyEvent e) {
                // Cuando se suelta la tecla, detener movimiento
                int tecla = e.getKeyCode();
                if (tecla == KeyEvent.VK_D ) {
                	x += 40;
                	personaje = quieto; // vuelve a la original
                    repaint();
                }
                if (tecla == KeyEvent.VK_S ) {
                	y += 40;
                	personaje = quieto; // vuelve a la original
                    repaint();
                }
                if (tecla == KeyEvent.VK_A ) {
                	x += -40;
                	personaje = quieto; // vuelve a la original
                    repaint();
                }
                if (tecla == KeyEvent.VK_W ) {
                	y += -40;
                	personaje = quieto; // vuelve a la original
                    repaint();
                }
            }
        });
    }
    
  

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
        g.drawImage(personaje, x, y, this);
    }

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Juego de Mario Bros FAKE");
        MarioBros juego = new MarioBros();
        ventana.add(juego);
        ventana.setSize(1000, 700);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null); //CENTRAR LA VENTANA
        ventana.setVisible(true);
    }
}







