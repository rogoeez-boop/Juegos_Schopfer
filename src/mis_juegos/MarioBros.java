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
    private Image caminar_l;
    private Image caminar_r;
    private Image correr_r;
    private Image correr_l;
    private Image saltar_l;
    private Image saltar_r;
    private Image agachar;
    
    private int x = 400, y = 430; // estas coordenadas son la posición inicial de la imagen en la ventana

    public MarioBros() {
        // Cargar imágenes
     
        quieto = new ImageIcon("imagenes_mario/stop.gif").getImage(); // ruta de tu imagen
        fondo = new ImageIcon("mapas/fondo.gif").getImage();  // fondo
        caminar_l = new ImageIcon("imagenes_mario/caminar_left.gif").getImage();
        caminar_r = new ImageIcon("imagenes_mario/caminar.gif").getImage();
        correr_r= new ImageIcon("imagenes_mario/Mario_Correr_Left.gif").getImage();
        correr_l = new ImageIcon("imagenes_mario/MArio_correr_Right.gif").getImage();
        saltar_l=new ImageIcon("imagenes_mario/saltar_left.gif").getImage();
        saltar_r=new ImageIcon("imagenes_mario/saltando.gif").getImage();
        agachar = new ImageIcon("imagenes_mario/mario_agachar.gif").getImage();

        personaje = quieto; // Empieza en quieto

        // Escuchar las teclas
        setFocusable(true); // Con este metodo estamos agregando al panel que va a recibir acciones por el teclado 
        // se inicializa en true activar el teclado.
        addKeyListener(new KeyAdapter() {
        	
            @Override
            //
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_RIGHT ||e.getKeyCode() == KeyEvent.VK_D ) {
                    personaje = caminar_r; // cambia la imagen
                    x+=10;
                    repaint();//se vuelve a pintar la imagen en el panel
                }
                
                if (e.getKeyCode() == KeyEvent.VK_LEFT ||e.getKeyCode() == KeyEvent.VK_A ) {
                    personaje = caminar_l; // cambia la imagen}
                    x-=10;
                    repaint();//se vuelve a pintar la imagen en el panel
                }
                
                if (e.getKeyCode() == KeyEvent.SHIFT_DOWN_MASK && ( e.getKeyCode() == KeyEvent.VK_LEFT ||e.getKeyCode() == KeyEvent.VK_A)  ) {
                    personaje = correr_r; // cambia la imagen
                    x-=30;
                    repaint();//se vuelve a pintar la imagen en el panel
                }
                if ( e.getKeyCode() == KeyEvent.SHIFT_DOWN_MASK  && (e.getKeyCode() == KeyEvent.VK_RIGHT ||e.getKeyCode() == KeyEvent.VK_D)   ) {
                    personaje = correr_l; // cambia la imagen
                    x+=30;
                    repaint();//se vuelve a pintar la imagen en el panel
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN ||e.getKeyCode() == KeyEvent.VK_S ) {
                    personaje = agachar; // cambia la imagen
                    y+=10;
                    repaint();//se vuelve a pintar la imagen en el panel
                }
                if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP   ) {
                    personaje = saltar_r; // cambia la imagen
                    y-=10;
                    repaint();//se vuelve a pintar la imagen en el panel
                }
             
                
            }

            
            @Override
            public void keyReleased(KeyEvent e) {
                // Cuando se suelta la tecla, detener movimiento
                int tecla = e.getKeyCode();
                
                if (tecla == KeyEvent.VK_LEFT || tecla == KeyEvent.VK_D ) {
                	x = x;
                	personaje = quieto; // vuelve a la original
                    repaint();
                }
                

                if (tecla == KeyEvent.VK_RIGHT || tecla == KeyEvent.VK_A ) {
                	x = x;
                	personaje = quieto; // vuelve a la original
                    repaint();
                }
                
                
                if (( tecla == KeyEvent.VK_LEFT || tecla == KeyEvent.VK_A) && tecla == KeyEvent.VK_SHIFT    ) {
                	x = x;
                	personaje = quieto; // vuelve a la original
                    repaint();
                }
                
                if ( (tecla == KeyEvent.VK_RIGHT || tecla == KeyEvent.VK_A) && tecla == KeyEvent.VK_SHIFT  ) {
                	x = x;
                	personaje = quieto; // vuelve a la original
                    repaint();
                }
                

                if (tecla == KeyEvent.VK_DOWN || tecla == KeyEvent.VK_S) {
                	y=y;
                	personaje = quieto; // vuelve a la original
                    repaint();
                }
                if ( tecla == KeyEvent.VK_UP|| tecla == KeyEvent.VK_W  ) {
                	y =450;
                	personaje = agachar; // vuelve a la original
                	
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
        JFrame ventana = new JFrame("Juego De Mario Rodrigo González");
        MarioBros juego = new MarioBros();
        ventana.add(juego);
        ventana.setSize(1000, 700);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null); //CENTRAR LA VENTANA
        ventana.setVisible(true);
    }
}
