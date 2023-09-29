package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



// TODO: Auto-generated Javadoc
/**
 * The Class DAO.
 */
public class DAO {
	
	/** The driver. */
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	/** The url. */
	private String url = "jdbc:mysql://localhost:3306/dbagenda?useTimezone=true&serverTimezone=UTC";
	
	/** The user. */
	private String user = "root";
	
	/** The password. */
	private String password = "";

	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
	private Connection conectar() {

		Connection con = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/**
	 * Insert contactos.
	 *
	 * @param contacto the contacto
	 */
	public void insertContactos(JavaBeans contacto) {
		String insert = "insert into contactos(nome,fone,email)values(?,?,?)";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(insert);
			pst.setString(1, contacto.getNome());
			pst.setString(2, contacto.getFone());
			pst.setString(3, contacto.getEmail());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Lista contacto.
	 *
	 * @return the array list
	 */
	public ArrayList<JavaBeans> listaContacto(){
		ArrayList<JavaBeans> contacto = new ArrayList<JavaBeans>();
		String select = "select * from contactos order by nome";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(select);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String idcon = rs.getString(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);
				contacto.add(new JavaBeans(idcon,nome,fone,email));	
			}
			con.close();
			return contacto;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	/**
	 * Seleccionar contacto.
	 *
	 * @param contacto the contacto
	 */
	public void seleccionarContacto(JavaBeans contacto) {
		String select = "select * from contactos where idcon = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(select);
			pst.setString(1, contacto.getIdcon());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				contacto.setIdcon(rs.getString(1)); 
				contacto.setNome(rs.getString(2)); 
				contacto.setFone(rs.getString(3)); 
				contacto.setEmail(rs.getString(4)); 	
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}	
	}
	
	/**
	 * Alterar contacto.
	 *
	 * @param contacto the contacto
	 */
	public void alterarContacto(JavaBeans contacto) {
		String update = "update contactos set nome=?,fone =?,email=? where idcon = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(update);
			pst.setString(1, contacto.getNome());
			pst.setString(2, contacto.getFone());
			pst.setString(3, contacto.getEmail());
			pst.setString(4, contacto.getIdcon());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Deletar contacto.
	 *
	 * @param contacto the contacto
	 */
	public void deletarContacto(JavaBeans contacto){
		String delete = "delete from contactos where idcon = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, contacto.getIdcon());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}
