package co.empresa.segundoParcial.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.empresa.segundoParcial.dao.CyclistDao;
import co.empresa.segundoParcial.modelo.Cyclist;

/**
 * Servlet implementation class CyclistDao
 */
@WebServlet("/")
public class CyclistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CyclistDao cyclistDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CyclistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		this.cyclistDao = new CyclistDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		try {
		switch(action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertarUsuario(request, response);
				break;
			case "/delete":
				eliminarUsuario(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				actualizarUsuario(request, response);
				break;
			default:
				listUsuarios(request, response);
				break;
		
		}
		}catch(SQLException e) {
			throw new ServletException(e);
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("cyclist.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertarCyclist(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, SQLException, IOException, ParseException {
		SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		Date birthDate = (Date) format.parse(request.getParameter("birthDate"));
		String id_country = request.getParameter("id_country");
		String id_team = request.getParameter("id_team");
		
		Cyclist cyclist = new Cyclist(name,email,birthDate,id_country,id_team);
		cyclistDao.insertar(cyclist);	
		response.sendRedirect("list");
	}
	


}
