import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class InicioSesion extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Usuario;
	private JPasswordField textField_Contrase�a;
	public JPasswordField getTextField_Contrase�a() {
		return textField_Contrase�a;
	}

	public void setTextField_Contrase�a(JPasswordField textField_Contrase�a) {
		this.textField_Contrase�a = textField_Contrase�a;
	}

	private JButton btnIniciarSesion;
	private ControladorLogin controlador;
	private BaseDeDatos bbdd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioSesion frame = new InicioSesion();
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
	public InicioSesion() {
		setTitle("Sistema de Gesti�n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 385, 150);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre de Usuario:");
		lblNombre.setBounds(10, 11, 122, 14);
		contentPane.add(lblNombre);
		
		JLabel lblNewLabel = new JLabel("Contrase\u00F1a:");
		lblNewLabel.setBounds(10, 45, 98, 14);
		contentPane.add(lblNewLabel);
		
		textField_Usuario = new JTextField();
		textField_Usuario.setBounds(142, 8, 190, 20);
		contentPane.add(textField_Usuario);
		textField_Usuario.setColumns(10);
		
		textField_Contrase�a = new JPasswordField();
		textField_Contrase�a.setEchoChar('*');
		textField_Contrase�a.setBounds(142, 42, 190, 20);
		contentPane.add(textField_Contrase�a);
		textField_Contrase�a.setColumns(10);
		
		btnIniciarSesion = new JButton("Iniciar Sesi\u00F3n");
		btnIniciarSesion.setBounds(210, 77, 122, 23);
		contentPane.add(btnIniciarSesion);
		bbdd = new BaseDeDatos();
		controlador = new ControladorLogin(this, bbdd);
	}

	public JTextField getTextField_Usuario() {
		return textField_Usuario;
	}

	public void setTextField_Usuario(JTextField textField_Usuario) {
		this.textField_Usuario = textField_Usuario;
	}


	public JButton getBtnIniciarSesion() {
		return btnIniciarSesion;
	}

	public void setBtnIniciarSesion(JButton btnIniciarSesion) {
		this.btnIniciarSesion = btnIniciarSesion;
	}
}
