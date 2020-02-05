import java.sql.*;
public class BaseDeDatos {
	private Connection conexion;
	
	public BaseDeDatos() {
		crearConexion();
	}
	
	private void crearConexion() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			conexion=DriverManager.getConnection("jdbc:oracle:thin:@192.168.6.38:1539:xe","reto","Almi1234");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}  
	}
	
	/*private void testBaseDatos() {
		String sql = "SELECT * FROM Personal";
		try {
			PreparedStatement sentencia = conexion.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = sentencia.executeQuery();
			while (rs.next()) {
			       for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
			           if (i > 1) System.out.print(",  ");
			           String columnValue = rs.getString(i);
			           System.out.print(columnValue + " " +rs.getMetaData().getColumnName(i));
			       }
			       System.out.println("");
			   }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/
	
	/**
	 * @param usuario
	 * @param password
	 * @return -1 if login was not successful , -2 if there was an exception, id_puesto if login was okay.
	 */
	public int checkLogIn (String usuario, String password) {
		int puesto;
		
		try {
			String sql = "SELECT id_puesto FROM Personal_Puesto INNER JOIN Personal ON Personal.id_personal=Personal_Puesto.id_personal WHERE dni = ? AND password = ? AND habilitado=1";
			PreparedStatement sentencia = conexion.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			sentencia.setString(1, usuario);
			sentencia.setString(2, password);
			ResultSet rs = sentencia.executeQuery();
			if (!rs.next()) {
				return -1;//El result set esta vacio, la SELECT no ha devuelto nada por lo que el login no es correcto
			}
			puesto = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
			puesto = -2;
		}
		return puesto;
	}
	
	//Test para llamar a funciones almacenadas
	public int testLlamarFuncionAlmacenada() {
		int retorno = 0;
		String call = "{ ? = call BLA}";
		CallableStatement cstmt;
		try {
			cstmt = conexion.prepareCall(call);
			cstmt.setQueryTimeout(1800);
			cstmt.registerOutParameter(1, Types.INTEGER); //para registrar el tipo de retorno de la funcion a la que se llama
			//cstmt.setString(2, "ejemplo"); si la funcion recibe parametros se haria asi, tipo y dato
			cstmt.executeUpdate();
			retorno = cstmt.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retorno;
	}
	
	public static void main(String args[]){  
		BaseDeDatos bd = new BaseDeDatos();
		//bd.testBaseDatos();
		int puesto = bd.checkLogIn("12345678A", "1234");
		System.out.println(puesto);
		int prueba = bd.testLlamarFuncionAlmacenada();
		System.out.println(prueba);
	}
}
