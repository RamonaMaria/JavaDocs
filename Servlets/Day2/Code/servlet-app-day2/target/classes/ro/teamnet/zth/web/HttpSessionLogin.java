package ro.teamnet.zth.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Ramona.Raducu on 7/19/2017.
 */
public
class HttpSessionLogin extends HttpServlet {
    @Override
    protected
    void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //  super.doPost(req, resp);
        String user = "";
        String password = "";
        user = req.getParameter("user");
        password = req.getParameter("password");
        // Cookie[] cookies = req.getCookies();
        if (user.equals("admin") && password.equals("admin")) {
            resp.getWriter().write("Welcome back " + user);
            resp.getWriter().write("The session id is: " + req.getSession().getId());
        } else {
            req.getSession().setAttribute("user", user);
            req.getSession().setAttribute("session", req.getSession());
            req.getRequestDispatcher("/views/loginFail.jsp").forward(req, resp);
        }
    }
}
