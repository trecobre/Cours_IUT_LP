/**
 *
 */
package fr.gouv.edu.iut.manager.web.servlet;

import fr.gouv.edu.iut.manager.entity.Departement;
import fr.gouv.edu.iut.manager.service.DepartementService;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author vgilles
 *
 */
public class DepartementServlet extends HttpServlet {

    /**
     * Serial version UID
     */
    private static final long serialVersionUID = 1270791841727800483L;

    /**
     * Le departement service.
     */
    @EJB
    private DepartementService departementService;
    
    private void forward(final String pageName,
            final HttpServletRequest request, final HttpServletResponse response)
            throws IOException, ServletException {
        // Recuperation du request dispatcher pour cette page.
        final RequestDispatcher requestDispatcher = request
                .getRequestDispatcher(pageName);
        // Si le request dispatcher n'existe pas, log d'erreur et creation d'une
        // exception.
        if (requestDispatcher == null) {
            final String errorMessage = "Cannot find request dispatcher for page name \""
                    + pageName + "\". Check page name.";
            throw new ServletException(errorMessage);
        }
        // Tout est ok, redirection vers la page.
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String action = req.getParameter("action");
        switch(action) {
            case "displayDepartementList":
                displayDepartementList(req, resp);
                break;
            case "displayDepartement":
                displayDepartement(req, resp);
                break;
            default : throw new UnsupportedOperationException("Unsupported action : " + action);
        }
    }
    
    

    /**
     * Recuperation et affichage de la liste des departements dans la jsp
     * departementList.jsp.
     *
     * @param request request
     * @param response response
     * @throws IOException io error
     * @throws ServletException servlet error
     */
    private void displayDepartementList(final HttpServletRequest request,
            final HttpServletResponse response)
            throws IOException, ServletException {
        // Ajout dans la request de la liste de departements
        request.setAttribute("departementList", this.departementService
                .getAllDepartements());
        // Redirection vers departementList.jsp
        this.forward("/jsp/departementList.jsp", request, response);
    }

    /**
     * Recuperation et affichage du detail d'un departement dans la jsp
     * departementDetail.jsp.
     *
     * @param request request
     * @param response response
     * @throws IOException io error
     * @throws ServletException servlet error
     */
    private void displayDepartement(final HttpServletRequest request,
            final HttpServletResponse response)
            throws IOException, ServletException {
        final String id = request.getParameter("id");
        // l'id de departement est obligatoire, si elle n'est pas renseignee on
        // genere un erreur
        if (id == null) {
            throw new ServletException("Id de departement obligatoire");
        }
        // Ajout dans le formulaire du departement en utilisant son id
        final Departement departement = this.departementService.getDepartement(
                Long.parseLong(id)
        );
        request.setAttribute("departement", departement);
        // Redirection vers departementDetail.jsp
        this.forward("/jsp/departementDetail.jsp", request, response);
    }
}
