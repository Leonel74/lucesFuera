package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PantallaFinal extends JFrame{
	public PantallaFinal() {
		getContentPane().setBackground(new Color(95, 158, 160));
		setTitle("\"Programacion III - Bienvenidos\"");
		setSize(375, 322);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("¡GANASTE!");
		lblNewLabel.setForeground(new Color(255, 255, 240));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setBounds(81, 11, 200, 79);
		getContentPane().add(lblNewLabel);

		JButton btnNewButton = new JButton("JUGAR DE NUEVO");
		btnNewButton.setForeground(new Color(248, 248, 255));
		btnNewButton.setBackground(new Color(0, 0, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaDeJuego inicioJuego = new PantallaDeJuego();
				inicioJuego.iniciar();
				dispose();
//				PantallaInicio home = new PantallaInicio();
//				home.setResizable(false);
//				home.setVisible(true);
//				home.setLocationRelativeTo(null);
//				dispose();
			}
		});
		btnNewButton.setBounds(26, 152, 159, 57);
		getContentPane().add(btnNewButton);

		JButton btnClose = new JButton("SALIR");
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setBounds(272, 571, 129, 35);
		getContentPane().add(btnClose);

		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(26, 163, 89, 23);
		getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Salir");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				dispose();
			}
		});
		//btnNewButton_2.setIcon(new ImageIcon(PantallaFinal.class.getResource("CirculoRojo.png")));
		btnNewButton_2.setBackground(new Color(255, 0, 0));
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setBounds(236, 152, 75, 57);
		getContentPane().add(btnNewButton_2);

	}
}
