package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
    public ProductController() 
    {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String flag = request.getParameter("flag");
		if(flag.equals("remove"))
		{
			removeProduct(request,response);
		}
		else if(flag.equals("view"))
		{
			viewProducts(request,response);
		}
	}

	private void viewProducts(HttpServletRequest request, HttpServletResponse response) 
	{
		ProductDAO dao = new ProductDAO();
		List ls = dao.view();
	}

	private void removeProduct(HttpServletRequest request, HttpServletResponse response) throws IOException 
	{
		
		ProductDAO dao = new ProductDAO();
		List ls = dao.viewProducts();
		
		HttpSession session = request.getSession();
		session.setAttribute("productList", ls);
		
		response.sendRedirect("Sales/removeProduct.jsp");
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
		else if(flag.equals("remove"))
		{
			remove(request,response);
		}
	}

	private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException 
	{
		String removed = "Removed!";
		
		int productId = Integer.parseInt(request.getParameter("products"));
		
		ProductVO productVO = new ProductVO();
		productVO.setProductId(productId);
		
		ProductDAO dao = new ProductDAO();
		dao.deleteProduct(productVO);
		
		HttpSession session = request.getSession();
		session.setAttribute("removed", removed);
		
		response.sendRedirect("Sales/removeProduct.jsp");
		
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
