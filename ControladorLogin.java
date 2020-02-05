import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ControladorLogin {
	private InicioSesion inicioSesion;
	private BaseDeDatos bbdd;
	private VentanaPrincipal ventanaPrincipal;
	private VentanaProfesores ventanaProfesores;
	
	public ControladorLogin(InicioSesion inicioSesion, BaseDeDatos bbdd) {
		super();
		this.inicioSesion = inicioSesion;
		this.bbdd = bbdd;
		inicioSesion.getBtnIniciarSesion().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String usuario = inicioSesion.getTextField_Usuario().getText();
				String password = new String(inicioSesion.getTextField_Contraseña().getPassword());
				int login = bbdd.checkLogIn(usuario, password);
				System.out.println(login);
				switch (login) {
				case 1:	JOptionPane.showMessageDialog(inicioSesion, "Login OK", "Login estatus", JOptionPane.INFORMATION_MESSAGE);
						ventanaProfesores = new VentanaProfesores();
						ventanaProfesores.setVisible(true);
						inicioSesion.dispose();
				
					break;
				case 2:	JOptionPane.showMessageDialog(inicioSesion, "Login OK", "Login estatus", JOptionPane.INFORMATION_MESSAGE);
						ventanaPrincipal = new VentanaPrincipal();
						ventanaPrincipal.setVisible(true);
						inicioSesion.dispose();

					break;
				case 3: 

					break;
					

				default:JOptionPane.showMessageDialog(inicioSesion, "Login not OK", "Login estatus", JOptionPane.INFORMATION_MESSAGE);
					break;
				}
			}
		});
	}
	
	
}
