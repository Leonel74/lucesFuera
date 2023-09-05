package Logica;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JButton;
/*  import javax.swing.JFrame; */
import javax.swing.JPanel;


public class Tablero {
    public int x = 0;
    public int y = 0;

    public void crearTablero(int cantBotonesX, int cantBotonesY, JPanel frame) {
        int x = 0; //posicion en x
        int y = 0;  //posicion en y

        for (int row = 0; row < cantBotonesX; row++) {
            x = 0;
            y = y + 65;
            crearBoton(x,y,row*3+1,0,frame);
            
            for (int col = 0; col < cantBotonesY; col++) {
                x = x + 65;
               crearBoton(x,y,row*3,col+1,frame);
            }
        }
    }
    
    private void crearBoton(int x,int y,int row,int col,JPanel frame) {
    	JButton btnNewButton = new JButton("Button " + (row + col));
    	btnNewButton.setBounds(51 + x, 0 + y, 50, 50);
    	btnNewButton.setBackground(new Color(25, 53, 215));
    	btnNewButton.setText(""+asignarEstado()); //usamos el text como estado? y dependiendo true o false cambiamos color?

    	btnNewButton.addMouseListener(new MouseAdapter() {
    		@Override
    		public void mouseClicked(MouseEvent e) 
    		{
    			System.out.println("tocado");
    			btnNewButton.setBackground(Color.red);
    		}
    	});
    	frame.add(btnNewButton);
    }    
    
    
    private boolean asignarEstado() { //estado aleatorio
    	Random rd = new Random();
    	return rd.nextBoolean();
    }

    private int calcularPuntaje(int puntaje){ //pensar
    	return puntaje++;
    }
}
