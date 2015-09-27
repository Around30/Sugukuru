package jp.ac.hal.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.ac.hal.Dao.Dao;
import jp.ac.hal.Util.InputCheck;

/**
 * Servlet implementation class ProductDetail
 */
@WebServlet("/ProductDetail")
public class ProductDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetail() {
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
		String sendURL = "商品詳細.jsp";
		// パラメータを受け取り変数にセット
		String productId = request.getParameter("productId");
		//パラメータチェック
		InputCheck i = new InputCheck();
		boolean err = false;
		err |= i.checkCharaLength(productId, 8);
		err |= i.checkNullChar(productId);
		err |= i.checkNumbers(productId);

		//エラーなし
		if (!err) {
			try {
				Dao dao = Dao.getNewInstance();

			}
		}

	}
	}

}
