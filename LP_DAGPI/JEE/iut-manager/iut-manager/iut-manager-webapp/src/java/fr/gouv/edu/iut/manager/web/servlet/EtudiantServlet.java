/**
 *
 */
package fr.gouv.edu.iut.manager.web.servlet;

import fr.gouv.edu.iut.manager.service.EtudiantService;
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
public class EtudiantServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = -513808271416474777L;

    /**
     * L'etudiant service.
     */
    @EJB
    private EtudiantService etudiantService;
    
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
            case "displayEtudiantList":
                displayEtudiantList(req, resp);
                break;
            default : throw new UnsupportedOperationException("Unsupported action : " + action);
        }
    }

    /**
     * Recuperation et affichage de la liste des etudiants dans la jsp
     * etudiantList.jsp.
     *
     * @param request request
     * @param response response
     * @throws IOException io error
     * @throws ServletException servlet error
     */
    private void displayEtudiantList(final HttpServletRequest request,
            final HttpServletResponse response)
            throws IOException, ServletException {
        // Ajout dans la request de la liste de departements
        request.setAttribute("etudiantList", this.etudiantService
                .getAllEtudiants());
        // Redirection vers etudiantList.jsp
        this.forward("/jsp/etudiantList.jsp", request, response);
    }

}
