package jp.ac.hal.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.ac.hal.Dao.Dao;

/**
 * Servlet implementation class ProductsList
 * 商品一覧用Servlet
 */
@WebServlet("/ProductsList")
public class ProductsList extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductsList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		// 受け取る文字コードの設定
		request.setCharacterEncoding("UTF-8");
		//転送先
		String sendURL = "";
		//エラーフラグ
		boolean err = false;
		//メッセージ格納用List
		ArrayList<String> msg = new ArrayList<>();
		List<Object[]> pList = new ArrayList<>();
		try {
			Dao dao = Dao.getNewInstance();
			//カテゴリ検索
			if (request.getParameter("productGenre") != null) {
				pList = dao.executeQuery("select * from product_t where product_genre_id = ?", request.getParameter("productGenre"));
				sendURL = "";
			} else {
				//全件検索	
				pList = dao.executeQuery("select * from product_t");
				sendURL = "";
			}
		} catch (NamingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			msg.add( "DB処理でエラーが発生しました。");
		} catch (SQLException e) {
			e.printStackTrace();
			msg.add( "DB処理でエラーが発生しました。");
		}
		
		RequestDispatcher disp = request.getRequestDispatcher(sendURL);
		//文字コード
		response.setContentType("text/html; charset=UTF-8");
		request.setAttribute("pList", pList);
		disp.forward(request, response);
	}
}
