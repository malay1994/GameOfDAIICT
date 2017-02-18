package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ProductDAO;
import VO.ProductVO;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/ProductController")
public class ProductController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String flag = request.getParameter("flag");
		
		if(flag.equals("add"))
		{
			addProduct(request,response);
		}
	}

	private void addProduct(HttpServletRequest request, HttpServletResponse response) throws IOException 
	{
		String productName = request.getParameter("products");
		
		ProductVO productVO = new ProductVO();
		productVO.setProductName(productName);
		
		ProductDAO productDAO = new ProductDAO();
		productDAO.addProduct(productVO);
		
		response.sendRedirect("Sales/addProduct.jsp");
	}

}
