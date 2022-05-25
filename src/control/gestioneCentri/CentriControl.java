package control.gestioneCentri;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.NoResultException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Response;

import com.google.gson.*;

import model.dao.CentroManage;
import model.dao.CentroManageDS;
import model.dao.CentroSettimanaManage;
import model.dao.CentroSettimanaManageDS;
import model.dao.IscrizioneManage;
import model.dao.IscrizioneManageDS;
import model.dao.UtenteManage;
import model.dao.UtenteManageDS;
import model.entity.Bambino;
import model.entity.Centro;
import model.entity.CentroSettimana;
import model.entity.Genitore;
import model.entity.Iscrizione;
import model.entity.Settimana;
import model.entity.Utente;

/**
 * Servlet implementation class LoginControl
 */
@WebServlet(description = "Control per disponibilità settimane", urlPatterns = { "/centri" })
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
		// TODO Auto-generated method stub
		System.out.println("dopo getWriter");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("dopo getWriter");
		String idCentro = request.getParameter("idCentro");
		
		if (idCentro == null) {
			response.sendError(404, "Parametro non valido!");
			return;
		}
		
		
		CentroSettimanaManage centroSettimanaManage = new CentroSettimanaManageDS();
		System.out.println("BOMBA: "+ centroSettimanaManage);
		
		List<CentroSettimana> settimane = centroSettimanaManage.getSettimaneDisponibilibyCentro(Integer.parseInt( idCentro ));
		System.out.println("BOMBA1: "+ settimane);
				
		String gson = new Gson().toJson(settimane);
		
		response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(gson);
		
	}
	
		
}
