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
import javax.sql.DataSource;

import jp.ac.hal.Model.*;

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
	
	public void executeUpdate(String sql, Object... args) throws SQLException
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
			ps.executeUpdate();
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
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			return rs.getInt(1);
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
			ResultSet rs = ps.executeQuery();
			int length = rs.getMetaData().getColumnCount();
			List<Object[]> ret = new ArrayList<>();
			while(rs.next())
			{
				Object[] row = new Object[length];
				for(int i = 0; i < length; i++)
				{
					row[i] = rs.getObject(i + 1);
				}
				ret.add(row);
			}
			return ret;
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
			ResultSet rs = ps.executeQuery();
			return rs.next();
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
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				return 0;
			}
			else
			{
				return rs.getInt(1);
			}
		}
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
			"insert into product_t values(product_seq.nextval, ?, ?, ?, ?)",
			p.getProductName(),
			p.getProductGenreId(),
			p.getPrice(),
			p.getMakerId()
		);
	}
	
	public void insert(Corporation c) throws SQLException
	{
		executeUpdate
		(
			"insert into corporation_t values(corporation_seq.nextval, ?, ?, ?, ?, ?, ?, sysdate)",
			c.getCorporationName(),
			c.getPostalCode(),
			c.getAddress(),
			c.getPhoneNumber(),
			c.getPasswd(),
			c.getCreditLimit()
		);
	}
	
	public void insert(CorporationAccount a) throws SQLException
	{
		executeUpdate
		(
			"insert into corporation_account_t values(corporation_account_seq.nextval, ?, ?)",
			a.getCorporationAccountName(),
			a.getCorporationAccountId()
		);
	}
	
	public int executeInsert(Order o) throws SQLException
	{
		return executeInsert
		(
			"insert into order_t values(order_seq.nextval, ?, sysdate)",
			o.getTotal()
		);
	}
	
	public void insert(CorporationOrder o) throws SQLException
	{
		int id = executeInsert(o);
		executeUpdate
		(
			"insert into corporation_order_t values(?, ?, ?, ?)",
			id,
			o.getCorporationAccountId(),
			o.isConfirmed(),
			o.getEstimateDate()
		);
	}
	
	public void insert(IndividualOrder o) throws SQLException
	{
		int id = executeInsert(o);
		executeUpdate
		(
			"insert into individual_order_t values(?, ?, ?, ?, ?, ?)",
			id,
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
			"insert into administer_t values(administrator_seq.nextval, ?, nvl(?, 0), ?)",
			a.getAdministratorName(),
			a.isFlg(),
			a.getPasswd()
		);
	}
}