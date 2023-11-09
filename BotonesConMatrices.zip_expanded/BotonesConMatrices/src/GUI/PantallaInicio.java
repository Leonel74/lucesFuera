package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class PantallaInicio extends JFrame {
	private JButton botonDeInicio;
	private JTextArea instrucciones;
	private JLabel lblTitulo;

	public PantallaInicio() {
		getContentPane().setFont(new Font("Consolas", Font.PLAIN, 24));
		getContentPane().setBackground(new Color(94, 191, 131));
		setTitle("\"Programacion III - Bienvenidos\"");
		setSize(480, 320);
		setLocationRelativeTo(null);

		btnJuego();
		iniciarJuego();
		
		getContentPane().setLayout(null);

		getContentPane().add(botonDeInicio);

		 titulo();

		instruccionesDeJuego();
	}

	private void iniciarJuego() {
		botonDeInicio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PantallaDeJuego inicioJuego = new PantallaDeJuego();
				inicioJuego.iniciar();
				dispose();

			}
		});		
	}

	private void btnJuego() {
		botonDeInicio = new JButton("Iniciar");
		botonDeInicio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botonDeInicio.setBounds(134, 200, 184, 54);		
	}

	private void titulo() {
		lblTitulo = new JLabel("TRABAJO PRACTICO N°1: LIGHTS OUT");
		lblTitulo.setFont(new Font("Cambria", Font.PLAIN, 20));
		lblTitulo.setBounds(66, 11, 339, 42);
		getContentPane().add(lblTitulo);		
	}

	private void instruccionesDeJuego() {
		instrucciones = new JTextArea();
		instrucciones.setFont(new Font("Cambria", Font.PLAIN, 20));
		instrucciones.setEditable(false);
		instrucciones.setBackground(new Color(79, 106, 113));
		instrucciones.setText("El objetivo del juego es lograr que todas\t\n las luces queden apagadas\r\n Suerte!");
		instrucciones.setForeground(SystemColor.window);
		instrucciones.setBounds(66, 63, 349, 125);
		getContentPane().add(instrucciones);		
	}
}
