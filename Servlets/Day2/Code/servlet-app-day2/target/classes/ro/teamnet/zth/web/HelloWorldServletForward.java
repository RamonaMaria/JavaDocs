package ro.teamnet.zth.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Ramona.Raducu on 7/19/2017.
 */
public
class HelloWorldServletForward extends HttpServlet {
    protected
    void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected
    void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String value = (String) request.getAttribute("testAttribute");
        response.getWriter().write("Hello <b>" + request.getParameter("user") + "" + "</b> from the Forward Servlet!" + value) ;
    }
}
