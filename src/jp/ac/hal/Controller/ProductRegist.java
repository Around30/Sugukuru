package jp.ac.hal.Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.ac.hal.Dao.Dao;
import jp.ac.hal.Model.Product;
import jp.ac.hal.Util.InputCheck;

/**
 * Servlet implementation class ProductRegist
 */
@WebServlet("/ProductRegist")
public class ProductRegist extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductRegist() {
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
		request.setCharacterEncoding("UTF-8");
		System.out.println(request.getParameter("edit"));

		if (request.getParameter("edit") != null) {
			//パラメータ受け取り
			int productId = Integer.parseInt(request.getParameter("productId"));
			String productName = request.getParameter("productName");
			String productPhonetic = request.getParameter("productPhonetic");

			String price = request.getParameter("price");
			String makerId = request.getParameter("makerId");
			String productGenreId = request.getParameter("productGenreId");
			String countryId = request.getParameter("countryId");
			String productX = request.getParameter("productX");
			String productY = request.getParameter("productY");
			String productZ = request.getParameter("productZ");
			String productWeight = request.getParameter("productWeight");

			String productDetail = request.getParameter("productDetail");
			String janCode = request.getParameter("janCode");

			String sendURL = "view/admin/productManagement/products/product_detail.jsp?product_id=" + productId;

			System.out.println(productId);
			System.out.println(productName);
			System.out.println(productPhonetic);
			System.out.println(price);
			System.out.println(makerId);
			System.out.println(productGenreId);
			System.out.println(countryId);

			String msg = "";
			InputCheck i = new InputCheck();
			boolean err = false;
			err |= i.checkNullChar(productName, productPhonetic, price, makerId, productGenreId, countryId, productX, productY, productZ, productWeight, productDetail, janCode);
			err |= i.checkCharaLength(productName, 60);
			err |= i.checkCharaLength(productPhonetic, 30);
			err |= i.checkNumbers(price, makerId, productGenreId, countryId, productX, productY, productZ, productWeight);
			err |= i.checkCharaLength(price, 8);
			err |= i.checkCharaLength(makerId, 8);
			err |= i.checkCharaLength(productGenreId, 2);
			err |= i.checkCharaLength(countryId, 8);
			err |= i.checkCharaLength(productX, 8);
			err |= i.checkCharaLength(productY, 8);
			err |= i.checkCharaLength(productZ, 8);
			err |= i.checkCharaLength(productWeight, 8);
			err |= i.checkCharaLength(productDetail, 200);
			err |= i.checkCharaLength(janCode, 13);

			System.out.println(err);

			if(!err) {
				try {
					Dao dao = Dao.getNewInstance();
					Product p = new Product();
					p.setProductName(productName);
					p.setProductPhonetic(productPhonetic);
					p.setPrice(Integer.parseInt(price));
					p.setMakerId(Integer.parseInt(makerId));
					p.setProductGenreId(Integer.parseInt(productGenreId));
					p.setCountryId(Integer.parseInt(countryId));
					p.setProductX(Integer.parseInt(productX));
					p.setProductY(Integer.parseInt(productY));
					p.setProductZ(Integer.parseInt(productZ));
					p.setProductWeight(Integer.parseInt(productWeight));
					p.setProductDetail(productDetail);
					p.setJanCode(janCode);
					dao.update(p, productId);
					msg = "登録が完了しました。";
				} catch (NamingException e) {
					e.printStackTrace();
					msg = "Naming";
				} catch (SQLException e) {
					e.printStackTrace();
					msg = "SQL";
				}
			} else {
				msg = "入力項目に誤りがあります。";
			}
			request.setAttribute("msg", msg);
			RequestDispatcher disp = request.getRequestDispatcher(sendURL);
			//文字コード
			response.setContentType("text/html; charset=UTF-8");
			disp.forward(request, response);
		}
	}

}
