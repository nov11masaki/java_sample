package controller.mutter;

import model.mutter.Mutter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
@WebServlet("/mutter/delete")
public class Delete extends HttpServlet{
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        HttpSession session = req.getSession();
        
        int id = Integer.parseInt(req.getParameter("id"));

        Mutter mutter = new Mutter(
                id
                ,null
                ,null
        );

        mutter.delete();

        resp.sendRedirect("/mutter/read");
    }
}