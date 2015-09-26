package jp.ac.hal.Dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.SQLException;
import java.util.Random;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.ac.hal.Model.Corporation;

/**
 * Servlet implementation class Test2
 */
@WebServlet("/Test2")
public class ReadCorporationFromCsv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		(
			InputStream fis = new FileInputStream("C:\\Users\\nagai.shinji\\Desktop\\files\\4-3\\IH31\\テストデータ\\取引先.csv");
			Reader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr)
		){
			Dao dao = Dao.getNewInstance();
			Random rdm = new Random();
			String line;
			String[] values;
			br.readLine();
			while((line = br.readLine()) != null)
			{
				values = line.split(",");
				Corporation c = new Corporation();
				c.setCorporationName(values[0]);
				c.setPostalCode(values[2]);
				c.setAddress(values[3]);
				c.setPhoneNumber(values[4]);
				c.setPasswd(String.valueOf(rdm.nextInt(100000000)));
				dao.insert(c);
			}
		} catch (SQLException | NamingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
