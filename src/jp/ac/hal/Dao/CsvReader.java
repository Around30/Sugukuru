package jp.ac.hal.Dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.naming.NamingException;

import jp.ac.hal.Model.Corporation;
import jp.ac.hal.Model.Product;
import jp.ac.hal.Model.ProductGenre;

public class CsvReader
{
	public static void main(String[] args) throws FileNotFoundException, IOException, NamingException, SQLException
	{
		Dao dao = Dao.getInstance();
		Random rdm = new Random();
		try
		(
			InputStream fis = new FileInputStream("C:\\Users\\nagai.shinji\\Desktop\\files\\4-3\\IH31\\テストデータ\\取引先.csv");
			Reader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr)
		){
			String line;
			String[] values;
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
		}
		
		try
		(
			InputStream fis = new FileInputStream("C:\\Users\\nagai.shinji\\Desktop\\files\\4-3\\IH31\\テストデータ\\商品.csv");
			Reader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr)
		){
			String line;
			String[] values;
			Map<String, Integer> cats = new HashMap<String, Integer>();
			Map<String, Integer> makers = new HashMap<String, Integer>();
			while((line = br.readLine()) != null)
			{
				values = line.split(",");
				int cat = cats.get(values[4]);
				if(cat == 0)
				{
					cat = dao.executeInsert(values[4]);
					cats.put(values[4], cat);
				}
				int maker = makers.get(values[3]);
				if(cat == 0)
				{
					maker = dao.executeInsert(values[3]);
					makers.put(values[3], maker);
				}
				ProductGenre g = new ProductGenre();
				g.setProductGenreName("");
				Product p = new Product();
				p.setProductName(values[0]);
				dao.insert(p);
			}
		}
	}
}