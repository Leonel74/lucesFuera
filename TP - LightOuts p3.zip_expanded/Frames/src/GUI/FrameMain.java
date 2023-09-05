package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Logica.Tablero;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
/* import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder; */

public class FrameMain {

	private JFrame framePrincipalDelJuego;
	public Tablero tablero;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameMain window = new FrameMain();
					window.framePrincipalDelJuego.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 *
	 *
	 * @throws UnsupportedLookAndFeelException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public FrameMain() throws InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		initialize();
	}

	@SuppressWarnings("unchecked")
	private void initialize() {

		tablero = new Tablero();

		framePrincipalDelJuego = new JFrame();
		JPanel contenedorBotones = new JPanel();
		contenedorBotones.setBackground(new Color(193, 193, 255));


		framePrincipalDelJuego.setAlwaysOnTop(true);
		framePrincipalDelJuego.setBounds(100, 100, 929, 572);
		framePrincipalDelJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// DROPDOWN
		// Variable para almacenar el item seleccionado

		@SuppressWarnings("rawtypes")
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(119, 33, 284, 22);
		// evento que captura que item se selecciono y actualiza el tablero de pantalla
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				String itemSeleccionado = comboBox.getSelectedItem().toString();
				tablero.crearTablero(3, 2, contenedorBotones);
				contenedorBotones.repaint();
				if(itemSeleccionado.length()<5) {
					Integer indice = Integer.parseInt(itemSeleccionado.charAt(itemSeleccionado.length()-1)+"");
					contenedorBotones.removeAll();
					tablero.crearTablero(indice, indice-1, contenedorBotones);
					contenedorBotones.repaint();
				}
//				

			}
		});
		framePrincipalDelJuego.getContentPane().setLayout(null);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setToolTipText("Seleccionar el tama\u00F1o de la cuadricula");
		comboBox.setName("dropdown");
		comboBox.setModel(new DefaultComboBoxModel<Object>(
				new String[] { "Seleccione tama\u00F1o de la cuadricula", "3x3", "4x4", "5x5" }));
		comboBox.setSelectedIndex(0);
		framePrincipalDelJuego.getContentPane().add(comboBox);

		// Panel de informacion del juego
		JPanel panelInformacionJuego = new JPanel();
		panelInformacionJuego.setBounds(557, 102, 333, 383);
		panelInformacionJuego.setBackground(new Color(128, 255, 255));
		framePrincipalDelJuego.getContentPane().add(panelInformacionJuego);
		panelInformacionJuego.setLayout(null);

		// Label CLICKS
		JLabel labelClicks = new JLabel("Clicks:");
		labelClicks.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		labelClicks.setBounds(21, 29, 54, 28);
		panelInformacionJuego.add(labelClicks);

		// Label PUNTAJE
		JLabel labelPuntaje = new JLabel("Puntaje:");
		labelPuntaje.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelPuntaje.setBounds(21, 68, 64, 35);
		panelInformacionJuego.add(labelPuntaje);

		// PUNTAJE
		JLabel clickText = new JLabel("0");
		clickText.setFont(new Font("Tahoma", Font.BOLD, 18));
		clickText.setBounds(97, 33, 20, 14);
		panelInformacionJuego.add(clickText);

		// CLICKS
		JLabel puntajeText = new JLabel("0");
		puntajeText.setFont(new Font("Tahoma", Font.BOLD, 18));
		puntajeText.setBounds(95, 79, 20, 14);
		panelInformacionJuego.add(puntajeText);

		//contenedor de botones
		contenedorBotones.setBounds(67, 102, 429, 420);
		framePrincipalDelJuego.getContentPane().add(contenedorBotones);
		contenedorBotones.setLayout(null);


	}
}
