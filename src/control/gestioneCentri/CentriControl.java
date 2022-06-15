package control.gestioneCentri;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CentroManage;
import model.dao.CentroManageDS;
import model.entity.Centro;
import model.entity.Genitore;
import model.entity.Responsabile;
import model.entity.Utente;

/**
 * Servlet implementation class CentriControl
 */
@WebServlet("/centri")
@MultipartConfig
public class CentriControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CentriControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utente u = (Utente) request.getSession(false).getAttribute("utente");
		String action= request.getParameter("action");
		
		if(action == null) {
		if(u==null) {
			response.sendError(401, "Autenticazione non effettuata!");
			return;
		} 
		
		if(!(u instanceof Responsabile)) {
			response.sendError(403, "Non sei autorizzato!");
			return;
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/centri.jsp");
		dispatcher.forward(request, response);
	}
		else {
			int centro = Integer.parseInt(request.getParameter("centro"));
			CentroManage centroman= new CentroManageDS();
			centroman.setCencellato(centro);
			
			response.sendRedirect(request.getContextPath()+"/list_centri");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String denominazione = (String) request.getParameter("nome");
		String comune = (String) request.getParameter("comune");
		String provincia = (String) request.getParameter("provincia");
		String indirizzo = (String) request.getParameter("indirizzo");
		String capienza2 =(String) request.getParameter("capienza");
		System.out.println(denominazione);
		System.out.println(comune);
		System.out.println(provincia);
		System.out.println(indirizzo);
		System.out.println(capienza2);
		int capienza =100;
		
		CentroManage centroman= new CentroManageDS();
		Centro c = new Centro();
		
		if (denominazione != null
				|| comune != null
				|| provincia != null
				|| indirizzo != null
				|| capienza >=1)
		{
			c.setCapienzaTot(capienza);
			c.setComune(comune);
			c.setDenominazione(denominazione);
			c.setProvincia(provincia);
			c.setIndirizzo(indirizzo);
			
			centroman.inserisciCentro(c);
			
			response.sendRedirect(request.getContextPath()+"/list_centri");
		} else {
			request.setAttribute("errorMessage", "Il formato dei dati � errato o non sono presenti tutti i campi!");
			this.doGet(request, response);
			return;
		}
		
		
	}

}
