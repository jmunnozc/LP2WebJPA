package com.cibertec;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lp2WebJpaApplication {

	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
		SpringApplication.run(Lp2WebJpaApplication.class, args);
		System.out.println("Hola como estan....");
		
//		//Class.forName("org.gjt.mm.mysql.Driver");
//		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdjpa", "root", "root");
//		String sqlQuery = "insert into imagen(codigoProducto, imagen) values (?,?)";
//		
//		FileInputStream fis = null;
//		PreparedStatement ps = null;
//		
//		try {
//			conn.setAutoCommit(false);
//			File archivo = new File("D:\\IDE Spring\\sts-4.23.0.RELEASE_Cibertec\\archivos\\image\\Producto demo.jpg");
//			fis = new FileInputStream(archivo);
//			ps = conn.prepareStatement(sqlQuery);
//			ps.setString(1, "5007");
//			ps.setBinaryStream(2, fis, (int) archivo.length());
//			ps.executeUpdate();
//			conn.commit();
//			System.out.println("Imágen registrada correctamente..en la BD.!!!");
//			
//		} catch (Exception ex) {
//			System.out.println(ex.getMessage());
//		} finally {
//			ps.close();
//			fis.close();
//		}
		
	}

}
