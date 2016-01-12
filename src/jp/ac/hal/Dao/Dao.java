package jp.ac.hal.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import jp.ac.hal.Model.Admin;
import jp.ac.hal.Model.Corporation;
import jp.ac.hal.Model.CorporationAccount;
import jp.ac.hal.Model.CorporationOrder;
import jp.ac.hal.Model.Country;
import jp.ac.hal.Model.IndividualOrder;
import jp.ac.hal.Model.Maker;
import jp.ac.hal.Model.Order;
import jp.ac.hal.Model.OrderDetail;
import jp.ac.hal.Model.Product;
import jp.ac.hal.Model.ProductGenre;

public class Dao
{
	private static Dao instance;
	private DataSource ds;

	private Dao() throws NamingException
	{
		Context context = new InitialContext();
		ds = (DataSource)context.lookup("java:comp/env/Oracle_JDBC");
	}

	public static Dao getInstance() throws NamingException
	{
		if(instance == null)
		{
			instance = new Dao();
		}
		return instance;
	}

	public static Dao getNewInstance() throws NamingException
	{
		instance = new Dao();
		return instance;
	}

	private Connection getConnection() throws SQLException
	{
		return ds.getConnection();
	}

	/**
	 * @return 更新行数
	 */
	public int executeUpdate(String sql, Object... args) throws SQLException
	{
		try
		(
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
		)
		{
			for(int i = 0; i < args.length; i++)
			{
				ps.setObject(i + 1, args[i]);
			}
			return ps.executeUpdate();
		}
	}

	/**
	 * @return insertした行のID
	 */
	public int executeInsert(String sql, Object... args) throws SQLException
	{
		try
		(
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(sql, new int[]{1});
		)
		{
			for(int i = 0; i < args.length; i++)
			{
				ps.setObject(i + 1, args[i]);
			}
			ps.executeUpdate();
			try(ResultSet rs = ps.getGeneratedKeys())
			{
				rs.next();
				return rs.getInt(1);
			}
		}
	}

	/**
	 * @return selectの結果
	 */
	public List<Object[]> executeQuery(String sql, Object... args) throws SQLException
	{
		try
		(
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
		)
		{
			for(int i = 0; i < args.length; i++)
			{
				ps.setObject(i + 1, args[i]);
			}
			List<Object[]> ret = new ArrayList<>();
			try(ResultSet rs = ps.executeQuery())
			{
				int length = rs.getMetaData().getColumnCount();
				while(rs.next())
				{
					Object[] row = new Object[length];
					for(int i = 0; i < length; i++)
					{
						row[i] = rs.getObject(i + 1);
					}
					ret.add(row);
				}
			}
			return ret;
		}
	}
	
	/**
	 * getCntで指定した数の新しい商品を取得する
	 * 
	 * @param getCnt 取得した商品数
	 * @return List<Product>
	 * @throws SQLException
	 */
	public List<Product> getNewItems(int getCnt) throws SQLException
	{
		
		String sql = "select * from product_t where rownum <= ?";
		List<Product> products = new ArrayList<Product>();
		
		try
		(
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
		)
		{
			ps.setInt(1, getCnt);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				int productId = rs.getInt("product_id");
				String productName = rs.getString("product_name");
				String productPhonetic = rs.getString("product_phonetic");
				int price = rs.getInt("price");
				int makerId = rs.getInt("maker_id");
				int productGenreId = rs.getInt("PRODUCT_GENRE_ID");
				//String productGenreName = rs.getString("product_genre_name");
				int countryId = rs.getInt("country_id");
				int productX = rs.getInt("product_x");
				int productY = rs.getInt("product_y");
				int productZ = rs.getInt("product_z");
				int productWeight = rs.getInt("product_weight");
				String productDetail = rs.getString("product_detail");
				String janCode = rs.getString("jan_code");
				
				Product product = new Product(productId, productName, productPhonetic, price, makerId, productGenreId, countryId, productX, productY, productZ, productWeight, productDetail, janCode);
				
				products.add(product);
			}
		}
		return products;
	}

	/**
	 * @return selectの結果が1行以上あれば1行目、そうでないならばnull
	 */
	public Object[] executeGet(String sql, Object... args) throws SQLException
	{
		try
		(
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
		)
		{
			for(int i = 0; i < args.length; i++)
			{
				ps.setObject(i + 1, args[i]);
			}
			try(ResultSet rs = ps.executeQuery())
			{
				int length = rs.getMetaData().getColumnCount();
				if(rs.next())
				{
					Object[] row = new Object[length];
					for(int i = 0; i < length; i++)
					{
						row[i] = rs.getObject(i + 1);
					}
					return row;
				}
				else
				{
					return null;
				}
			}
		}
	}

	/**
	 * @return selectの結果が1行以上であるかどうか
	 */
	public boolean executeConfirm(String sql, Object... args) throws SQLException
	{
		try
		(
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
		)
		{
			for(int i = 0; i < args.length; i++)
			{
				ps.setObject(i + 1, args[i]);
			}
			try(ResultSet rs = ps.executeQuery())
			{
				return rs.next();
			}
		}
	}

	/**
	 * @return selectの結果が1行以上あれば1行目のID、そうでないならば0
	 */
	public int executeSearch(String sql, Object... args) throws SQLException
	{
		try
		(
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(sql, new int[]{1});
		)
		{
			for(int i = 0; i < args.length; i++)
			{
				ps.setObject(i + 1, args[i]);
			}
			ps.executeUpdate();
			try(ResultSet rs = ps.executeQuery())
			{
				if(rs.next())
				{
					return rs.getInt(1);
				}
				else
				{
					return 0;
				}
			}
		}
	}

	public void insert(Country c) throws SQLException
	{
		executeInsert
		(
			"insert into country_t values(country_seq.nextval, ?)",
			c.getCountryName()
		);
	}

	public void insert(ProductGenre g) throws SQLException
	{
		executeUpdate
		(
			"insert into product_genre_t values(product_genre_seq.nextval, ?)",
			g.getProductGenreName()
		);
	}

	public void insert(Maker m) throws SQLException
	{
		executeUpdate
		(
			"insert into maker_t values(maker_seq.nextval, ?)",
			m.getMarkerName()
		);
	}

	public void insert(Product p) throws SQLException
	{
		executeUpdate
		(
			"insert into product_t values(product_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
			p.getProductName(),
			p.getProductPhonetic(),
			p.getPrice(),
			p.getMakerId(),
			p.getProductGenreId(),
			p.getCountryId(),
			p.getProductX(),
			p.getProductY(),
			p.getProductZ(),
			p.getProductWeight(),
			p.getProductDetail(),
			p.getJanCode()
		);
	}

	public void insert(Corporation c) throws SQLException
	{
		executeUpdate
		(
			"insert into corporation_t values(corporation_seq.nextval, ?, ?, ?, ?, ?, sysdate)",
			c.getCorporationName(),
			c.getPostalCode(),
			c.getAddress(),
			c.getPhoneNumber(),
			c.getCreditLimit()
		);
	}

	public void insert(CorporationAccount a) throws SQLException
	{
		executeUpdate
		(
			"insert into corporation_account_t values(corporation_account_seq.nextval, ?, ?, ?)",
			a.getCorporationAccountName(),
			a.getCorporationAccountId(),
			a.getPasswd()
		);
	}

	public int insert(Order o) throws SQLException
	{
		return executeInsert
		(
			"insert into order_t values(order_seq.nextval, ?, null)",
			o.getTotal()
		);
	}

	public int insert(CorporationOrder o) throws SQLException
	{
		return executeInsert
		(
			"insert into corporation_order_t values(?, ?, ?, ?)",
			o.getOrderId(),
			o.getCorporationAccountId(),
			o.getEstimateRequestDate(),
			o.getEstimateDate()
		);
	}

	public int insert(IndividualOrder o) throws SQLException
	{
		return executeUpdate
		(
			"insert into individual_order_t values(?, ?, ?, ?, ?, ?, ?)",
			o.getOrderId(),
			o.getName(),
			o.getPhonetic(),
			o.getPostalCode(),
			o.getAddress(),
			o.getPhoneNumber(),
			o.getMailAddress()
		);
	}

	public void insert(OrderDetail d) throws SQLException
	{
		executeUpdate
		(
			"insert into order_detail_t values(?, ?, ?, ?)",
			d.getOrderId(),
			d.getProductId(),
			d.getNumberOf(),
			d.getSubTotal()
		);
	}

	public void insert(Admin a) throws SQLException
	{
		executeUpdate
		(
			"insert into administer_t values(administrator_seq.nextval, ?, ?, ?)",
			a.getAdministratorName(),
			a.isFlg(),
			a.getPasswd()
		);
	}

	public int update(Corporation c, int corporationId) throws SQLException
	{
		return executeUpdate
		(
			"update corporation_t set corporation_name = ?, postal_code = ?, corporation_address = ?, phone_number = ?, credit_limit = ?"
					+ " where corporation_id = " + corporationId,
				c.getCorporationName(),
				c.getPostalCode(),
				c.getAddress(),
				c.getPhoneNumber(),
				c.getCreditLimit()
		);
	}

	public int update(Product p, int productId) throws SQLException
	{
		return executeUpdate
		(
			"update product_t set product_name = ?, product_phonetic = ?, price = ?, maker_id = ?, product_genre_id = ?, country_id = ?, product_x = ?, product_y = ?, product_z = ?, product_weight = ?, product_detail = ?, jan_code = ? where product_id = " + productId,
				p.getProductName(),
				p.getProductPhonetic(),
				p.getPrice(),
				p.getMakerId(),
				p.getProductGenreId(),
				p.getCountryId(),
				p.getProductX(),
				p.getProductY(),
				p.getProductZ(),
				p.getProductWeight(),
				p.getProductDetail(),
				p.getJanCode()
		);
	}

	public int delete(int productId) throws SQLException
	{
		return executeUpdate("delete from product_t where product_id = ?", productId);
	}

	public Object[] administratorLogin(String id, String passwd) throws SQLException
	{
		return executeGet("select * from administrator_t where administrator_id = ? and password = ?", id, passwd);
	}

	public Object[] corporationLogin(int id, String passwd) throws SQLException
	{
		return executeGet("select corporation_t.corporation_id, corporation_account_id, corporation_account_name from corporation_t, corporation_account_t where corporation_account_id = ? and password = ? and corporation_t.corporation_id = corporation_account_t.corporation_id", id, passwd);
	}

	public Object[] productDetail(int id) throws SQLException
	{
		return executeGet("select * from product_t, product_genre_t, country_t, maker_t where product_id = ? and product_t.product_genre_id = product_genre_t.product_genre_id and product_t.country_id = country_t.country_id and product_t.maker_id = maker_t.maker_id", id);
	}

	public Object[] corporationDetail(int id) throws SQLException
	{
		return executeGet("select * from corporation_t where corporation_id = ?", id);
	}

	public int getOrderId(HttpServletRequest request) throws SQLException
	{
		if(request.getSession().getAttribute("orderId") == null)
		{
			request.getSession().setAttribute("orderId", insert(new Order()));
		}
		return (Integer)request.getSession().getAttribute("orderId");
	}
}