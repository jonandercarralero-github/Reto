import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JMenu mnGestiones;
	private JMenuItem mntmAltas;
	private JMenuItem mntmBajas;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNuevoCurso;
	private JMenuItem mntmBoletines;
	private JMenuItem mntmTransferir;
	private JMenuItem mntmBecas;
	private JMenuItem mntmPagos;
	private JMenuItem mntmComprobarBeca;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setTitle("Sistema de Gesti\u00F3n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 313);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnHerramientas = new JMenu("Herramientas");
		menuBar.add(mnHerramientas);
		
		mntmNuevoCurso = new JMenuItem("Crear nuevo curso");
		mnHerramientas.add(mntmNuevoCurso);
		
		mntmBoletines = new JMenuItem("Generar Boletines");
		mnHerramientas.add(mntmBoletines);
		
		mntmTransferir = new JMenuItem("Transferir a 2\u00BA curso");
		mnHerramientas.add(mntmTransferir);
		
		mntmBecas = new JMenuItem("Solicitar becas");
		mnHerramientas.add(mntmBecas);
		
		mntmComprobarBeca = new JMenuItem("Comprobar becas");
		mnHerramientas.add(mntmComprobarBeca);
		
		mntmPagos = new JMenuItem("Comprobar pagos");
		mnHerramientas.add(mntmPagos);
		
		mnGestiones = new JMenu("Gestiones");
		mnGestiones.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnGestiones);
		
		mntmAltas = new JMenuItem("Altas");
		mnGestiones.add(mntmAltas);
		
		mntmBajas = new JMenuItem("Bajas");
		mnGestiones.add(mntmBajas);
		
		mntmNewMenuItem = new JMenuItem("Modificaciones");
		mnGestiones.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
