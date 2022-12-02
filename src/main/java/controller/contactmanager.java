package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gestionnaire.Contact;
import gestionnaire.GestionnaireDeContact;
import gestionnaire.Utilisateur;

/**
 * Servlet implementation class contactmanager
 */
@WebServlet("/contactmanager")
public class contactmanager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public contactmanager() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Utilisateur user = (Utilisateur) request.getSession().getAttribute("user");
		GestionnaireDeContact gestionnaire = user.getGestionnaire();

		String retour = "";

		if(request.getParameter("ajout") != null) {

			Contact contact = new Contact(request.getParameter("name"), request.getParameter("tel"));
			if(gestionnaire.ajouteContact(contact)) {
				retour = "contact ajouté";
			} else {
				retour = "contact non-ajouté";
			}

		} else if(request.getParameter("recherche") != null) {
			Contact contact = new Contact("", request.getParameter("tel"));

			int indice = gestionnaire.rechercheContactParTel(contact);
			
			if(indice != -1) {
				retour = "Le tél: "+ contact.getTel() + " appartient à " + gestionnaire.getContacts().get(indice).getNom();
			} else {
				retour = "Tél inconnu";
			}

		} else if(request.getParameter("suppression") != null) {

			Contact contact = new Contact("", request.getParameter("tel"));
			
			if(gestionnaire.supprimeContact(contact)) {
				retour = "contact supprimé";
			} else {
				retour = "suppression impossible";
			}

		} else if (request.getParameter("modification") != null) {
			if(request.getParameter("modifying") == null) {
				request.setAttribute("modifying", request.getParameter("tel"));
			} else {
				Contact contact = new Contact("", request.getParameter("modifying"));
				Contact newcontact = new Contact(request.getParameter("nom"), request.getParameter("tel"));
				if(gestionnaire.modifieContact(contact, newcontact)) {
					retour = "contact modifié";
				} else {
					retour = "contact non-modifié";
				}
				
				request.setAttribute("modifying", null);
			}
		}

		request.setAttribute("retour", retour);
		request.setAttribute("contacts", gestionnaire);

		RequestDispatcher dispatcher = request.getRequestDispatcher("user.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
