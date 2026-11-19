package murach;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import murach.business.*;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String url = "/cart.jsp";
		List<CD> cds = this.setUpCDs();
		Cart cart = (Cart) session.getAttribute("cart");
		String action = request.getParameter("action");
		int cdCode = Integer.parseInt(request.getParameter("cdCode"));
		if(cart == null) {
			cart = new Cart();
		}
		if (action.equals("add")) {
			for(CD cd : cds) {
				if(cdCode == cd.getCode()) {
					cart.addCartItem(cd);
				}
			}
		}
		if (action.equals("update")) {
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			for(CD cd : cds) {
				if(cdCode == cd.getCode()) {
					cart.updateQuantity(cd, quantity);
				}
			}
		}
		if (action.equals("delete")) {
			cart.remove(cdCode);
		}
		session.setAttribute("cart", cart);
		request.setAttribute("cart", cart);
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}
	
	private List<CD> setUpCDs() {
		List<CD> cds = new ArrayList<CD>();
		CD cd1 = new CD(1, "86 (the band) - True Life Songs and Pictures", 14.95);
		CD cd2 = new CD(2, "Paddlefoot - The first CD", 12.95);
		CD cd3 = new CD(3, "Paddlefoot - The second CD", 14.95);
		CD cd4 = new CD(4, "Joe Rut - Genuine Wood Grained Finish", 14.95);
		cds.add(cd1);
		cds.add(cd2);
		cds.add(cd3);
		cds.add(cd4);
		return cds;
	}

}
