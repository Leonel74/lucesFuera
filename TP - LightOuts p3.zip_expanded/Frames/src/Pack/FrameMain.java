package Pack;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class FrameMain {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameMain window = new FrameMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
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

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("unchecked")
	private void initialize() {

		frame = new JFrame();
		frame.setAlwaysOnTop(true);
		frame.setBounds(100, 100, 513, 572);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// DROPDOWN
		// Variable para almacenar el item seleccionado

		@SuppressWarnings("rawtypes")
		JComboBox comboBox = new JComboBox();
		// evento que captura que item se selecciono
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedItem = null;
				selectedItem = comboBox.getSelectedItem().toString();
				if (selectedItem == "4x4") {
					System.out.println("4x4");
					// refrescamos la pantalla
					crearTablero(4, 3);
					frame.repaint();
				} else if (selectedItem == "5x5") {
					System.out.println("5x5");
					crearTablero(5, 4);
					// refrescamos la pantalla
					frame.revalidate();
					frame.repaint();
				} else if (selectedItem == "3x3") {
					System.out.println("3x3");
					crearTablero(3, 2);
					// refrescamos la pantalla
					frame.repaint();
				}
				// refrescar la pantalla

			}
		});
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setToolTipText("Seleccionar el tama\u00F1o de la cuadricula");
		comboBox.setName("dropdown");
		comboBox.setModel(new DefaultComboBoxModel<Object>(
				new String[] { "Seleccione tama\u00F1o de la cuadricula", "3x3", "4x4", "5x5" }));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(91, 34, 284, 22);
		frame.getContentPane().add(comboBox);

		// creamos el tablero INICIAL
		crearTablero(3, 2);

	}

	public void crearTablero(int cantBotonesX, int cantBotonesY) {
		int x = 0;
		int y = 0;
		for (int row = 0; row < cantBotonesX; row++) {
			x = 0;
			y = y + 70;
			JButton btnNewButton = new JButton("Button " + (row * 3 + 1));
			btnNewButton.setBackground(new Color(0, 255, 0));
			btnNewButton.setBounds(91 + x, 67 + y, 50, 50);
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					btnNewButton.setBackground(new Color(255, 0, 0));
				}
			});
			for (int col = 0; col < cantBotonesY; col++) {
				x = x + 70;
				JButton btnNewButton2 = new JButton("Button " + (row * 3 + col + 1));
				btnNewButton2.setBackground(new Color(0, 255, 0));
				btnNewButton2.setBounds(91 + x, 67 + y, 50, 50);
				btnNewButton2.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnNewButton2.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						btnNewButton2.setBackground(new Color(255, 0, 0));
					}
				});
				frame.getContentPane().add(btnNewButton2);
			}
			frame.getContentPane().add(btnNewButton);
		}

	}
}
