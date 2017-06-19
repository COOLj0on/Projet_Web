package fr.eni.projet.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet Filter implementation class AuthentFilter
 */
@WebFilter(value = "/*")
public class AuthentFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthentFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpReq 		= (HttpServletRequest) request;
		HttpSession session 			= httpReq.getSession();
		if(session.getAttribute("formateur") != null){
			session.setAttribute("isAuthent", true);
			if("Formateur".equals(session.getAttribute("formateur").getClass().getSimpleName())){
				request.setAttribute("authentType", "formateur");
			}else{

			}
		}else{
			request.setAttribute("isAuthent", false);
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
