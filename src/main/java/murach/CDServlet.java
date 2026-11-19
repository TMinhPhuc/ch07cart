package murach;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import murach.business.CD;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import murach.business.*;

/**
 * Servlet implementation class CDServlet
 */
@WebServlet("/CDServlet")
public class CDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CDServlet() {
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
		List<CD> cds = this.setUpCDs();
		String url = "/index.jsp";
		request.setAttribute("cds", cds);
		
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
