package GUI;

import javax.swing.JFrame;
import java.awt.Font;
import java.awt.event.ActionListener;
import Logica.Tablero;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;

import javax.swing.JTextArea;

public class PantallaDeJuego {

	private JFrame framePrincipalDelJuego;
	private Tablero tablero;
	private JPanel contenedorBotones, panelInformacionJuego;
	private JLabel puntajeText, labelClicks, labelPuntaje, clickText;
	private JButton[][] botones;
	private JButton btnResetComboBox;
	private JComboBox comboBox;
	private JTextArea sugerencia;

	public PantallaDeJuego() {
		initialize();

	}

	@SuppressWarnings("unchecked")
	private void initialize() {

		framePrincipalDelJuego = new JFrame();
		framePrincipalDelJuego.setBounds(100, 100, 929, 572);
		framePrincipalDelJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contenedorBotones = new JPanel();
		contenedorBotones.setBorder(new EmptyBorder(0, 8, 0, 0));
		// DROPDOWN
		comboBox = new JComboBox();
		inicialiazarComboBox(comboBox);
		framePrincipalDelJuego.getContentPane().setLayout(null);
		cargarComboBoxAPantalla(comboBox);
		// Panel de informacion del juego
		inicializarPanelDeInformacionDelJuego();
		inicializarLabelDeClick();
		// contenedor de botones
		contenedorBotones.setBounds(89, 102, 406, 361);
		framePrincipalDelJuego.getContentPane().add(contenedorBotones);
		contenedorBotones.setBackground(new Color(192, 192, 192));/* color gris claro */
		btnCambiarTablero();
	}

	private void btnCambiarTablero() {
		btnResetComboBox = new JButton("Cambiar tablero");
		btnResetComboBox.setBounds(173, 473, 255, 35);
		framePrincipalDelJuego.getContentPane().add(btnResetComboBox);
		btnResetComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.setVisible(true);
			}
		});
	}

	private void inicializarLabelDeClick() {
		// Label CLICKS
		labelClicks = new JLabel("Clicks:");
		labelClicks.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		labelClicks.setBounds(21, 29, 54, 28);
		panelInformacionJuego.add(labelClicks);
		// VALOR CLICKS
		clickText = new JLabel("");
		clickText.setFont(new Font("Tahoma", Font.BOLD, 18));
		clickText.setBounds(95, 25, 96, 24);
		panelInformacionJuego.add(clickText);

	}

	private void inicializarPanelDeInformacionDelJuego() {
		panelInformacionJuego = new JPanel(); // inicialice esta wea
		panelInformacionJuego.setBounds(557, 103, 333, 383);
		panelInformacionJuego.setBackground(new Color(128, 255, 255));
		framePrincipalDelJuego.getContentPane().add(panelInformacionJuego);
		panelInformacionJuego.setLayout(null);
	}

	private void cargarComboBoxAPantalla(JComboBox comboBox) {
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setToolTipText("Seleccionar el tamanio de la cuadricula");
		comboBox.setName("dropdown");
		comboBox.setModel(new DefaultComboBoxModel<Object>(
				new String[] { "Seleccione tamanio de la cuadricula", "3x3", "4x4", "5x5" }));
		comboBox.setSelectedIndex(0);
		framePrincipalDelJuego.getContentPane().add(comboBox);
	}

	private void inicialiazarComboBox(JComboBox comboBox) {

		comboBox.setBounds(119, 33, 284, 22);
		// evento que captura que item se selecciono y actualiza el tablero de pantalla
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				String itemSeleccionado = comboBox.getSelectedItem().toString();
				if (esNumero(itemSeleccionado)) {
					tablero = null;
					Integer indice = casteoANum(itemSeleccionado);
					clickText.setText("0");// resetea el contador si cambia el tamaio de la matriz
					contenedorBotones.removeAll();
					contenedorBotones.setLayout(new GridLayout(indice, indice, 2, 2)); // para ubicar los botones en un
					tablero = new Tablero(indice);
					dibujarTablero(tablero);
					comboBox.setVisible(false);
					contenedorBotones.repaint();
				}
			}

			private Integer casteoANum(String itemSeleccionado) {
				return Integer.parseInt(itemSeleccionado.charAt(0) + "");
			}

			private boolean esNumero(String itemSeleccionado) {
				return itemSeleccionado.charAt(0) > 50 && itemSeleccionado.charAt(0) < 54;
			}

		});

	}

	/* metodos generales */

	private void dibujarTablero(Tablero tablero) {
		// Inicializo la matriz de botones
		this.botones = new JButton[tablero.tamanio()][tablero.tamanio()];

		asignarBotenes(tablero);
	}

	private void asignarBotenes(Tablero tablero) {
		for (int fila = 0; fila < tablero.tamanio(); fila++) {
			for (int col = 0; col < tablero.tamanio(); col++) {
				// agrego los botones a la matriz
				botones[fila][col] = crearBoton(fila, col);
			}
		}
	}

	private JButton crearBoton(int fila, int col) {
		JButton btn = new JButton();
		btn.setBorderPainted(false);
		btn.setBackground(tablero.celdaEstaEncendida(fila, col) ? Color.black : Color.green);
		contenedorBotones.add(btn);
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Aqui puedes detectar cual boton fue presionado
				tablero.cambiarEstado(fila, col);
				actualizarIntentos();
				actualizarBotones();
				if (tablero.estaResuelto()) {
					pantallaFinalDelJuego();
				}
			}
		});
		return btn;
	}

	private void pantallaFinalDelJuego() {
		PantallaFinal pantallaFinal = new PantallaFinal();
		pantallaFinal.setVisible(true);
	}

	// metodos nuevos
	private void actualizarBotones() {
		recorrerTablero();
	}

	private void recorrerTablero() {
		for (int col = 0; col < tablero.tamanio(); col++) {
			for (int fila = 0; fila < tablero.tamanio(); fila++) {
				prenderApagarBotones(fila, col);
			}
		}
	}

	private void prenderApagarBotones(int fila, int col) {
		if (tablero.celdaEstaEncendida(fila, col)) {
			botones[fila][col].setBackground(Color.black);
		} else {
			botones[fila][col].setBackground(Color.GREEN);
		}
	}

	private void actualizarIntentos() {
		// lo agrego
		clickText.setText(String.valueOf(tablero.cantIntentos()));
	}

	public void iniciar() {
		this.framePrincipalDelJuego.setLocationRelativeTo(null);
		framePrincipalDelJuego.setVisible(true);
	}
}
