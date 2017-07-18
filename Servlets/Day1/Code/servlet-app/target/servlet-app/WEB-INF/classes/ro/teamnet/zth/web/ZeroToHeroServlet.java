package ro.teamnet.zth.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Ramona.Raducu on 7/18/2017.
 */
public
class ZeroToHeroServlet extends HttpServlet {
    protected
    void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String res;
        res = handleRequest(request);
        PrintWriter printWriter = response.getWriter();
        printWriter.write(res);
    }

    protected
    void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private String handleRequest (HttpServletRequest req) {
        String firstName = "";
        String lastName = "";

        firstName = req.getParameter("firstName");
        lastName = req.getParameter("lastName");

        return "Hello <b>" + firstName + lastName + "</b>! Enjoy Zero To Hero!!!"  ;
    }


}
