package jp.ac.hal.Dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test3
 */
@WebServlet("/ReadProductFromCsv")
public class ReadProductFromCsv extends HttpServlet {
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
			String line;
			String[] values;
			Map<String, Integer> cats = new HashMap<>();
			Map<String, Integer> makers = new HashMap<>();
			Map<String, Integer> countrys = new HashMap<>();
			br.readLine();
			while((line = br.readLine()) != null)
			{
				System.out.println("aaaa");
				values = line.split(",");
				Integer cat = cats.get(values[4]);
				if(cat == null)
				{
					cat = dao.executeInsert("insert into product_genre_t values(product_genre_seq.nextval, ?)", values[4]);
					cats.put(values[4], cat);
				}
				Integer maker = makers.get(values[3]);
				if(maker == null)
				{
					maker = dao.executeInsert("insert into maker_t values(maker_seq.nextval, ?)", values[3]);
					makers.put(values[3], maker);
				}
				Integer country = countrys.get(values[5]);
				if(country == null)
				{
					country = dao.executeInsert("insert into country_t values(country_seq.nextval, ?)", values[5]);
					countrys.put(values[5], country);
				}
				dao.executeUpdate
				(
					"insert into product_t values(product_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
					values[0],
					values[1],
					values[2],
					maker,
					cat,
					country,
					values[6],
					values[7],
					values[8],
					values[9],
					values[10],
					values[11]
				);
			}
		} catch (NamingException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
