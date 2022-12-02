package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import gestionnaire.GestionnaireUtilisateurs;

/**
 * Servlet implementation class accueil
 */
@WebServlet("/")
public class accueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GestionnaireUtilisateurs gestUsers;
	
	@Resource(name="JDBCgestionnaire")
	private DataSource datasource;
	
    public accueil() {
        this.gestUsers = new GestionnaireUtilisateurs();
    
        // mieux vaut avoir un objet partagé entre servlet ou des sessions ? comment vivent les objets entre sessions ?
        // bean en jsp pour passer un user c'est mieux ?
        // c'est multi threadé ou mis en file d'attente les requests ? Du coup les objets crées en mémoire viennent d'où ?
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		session.setAttribute("gestionnaire", gestUsers);
		
		try {
			Connection conn = datasource.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from contact");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("accueil.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	public GestionnaireUtilisateurs getGestUsers() {
		return gestUsers;
	}

	public void setGestUsers(GestionnaireUtilisateurs gestUsers) {
		this.gestUsers = gestUsers;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public DataSource getDatasource() {
		return datasource;
	}

	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
	}

}
