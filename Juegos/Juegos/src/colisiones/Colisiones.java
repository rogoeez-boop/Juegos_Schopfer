package colisiones;

import java.awt.Rectangle;
import java.util.ArrayList;
public class Colisiones {
	
	    // Lista de zonas de colisión
	    private ArrayList<Rectangle> colisiones = new ArrayList<>();
	    
	    //constructor, este siempre lleva el nombre de nuestra clase.
	    public Colisiones() {}
	    
	    /* 
	     * en este metodo definiciones las colisiones del mapa 1 / nivel 1.
	     * estamos retornando un ArrayList de tipo Rectangle para regresar la posicion completa 
	     * de la coordenada de la figura, usamos este tipo porque estamos
	     * dibujando una figura de rectangulo y esta recibe 4 parametros (x, y, ancho, alto)
	     * 
	     * */
	    public ArrayList<Rectangle> colisionesMapa1() {
	    	
	    	 // Definir zonas de colisión (x, y, ancho, alto)
	        colisiones.add(new Rectangle(285, 160, 50, 50));
	        colisiones.add(new Rectangle(430, 80, 50, 50));
	        colisiones.add(new Rectangle(400, 160, 50, 50));
	        colisiones.add(new Rectangle(900, 100, 80, 80));
	        colisiones.add(new Rectangle(1400, 180, 60, 40));
	        
	        return colisiones;
	    }
		

	}

