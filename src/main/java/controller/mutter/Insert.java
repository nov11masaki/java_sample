package controller.task;

import model.mutter.Mutter;
import model.user.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;

@WebServlet("/mutter/insert")
public class Insert extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // いつも通り
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/mutter/insert.jsp");
        dispatcher.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String text =  req.getParameter("text");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("currentUser");

        if(user == null){
            System.out.println("userがnullです");
        }else {
            Mutter mutter = new Mutter(user.getName(),text);
            mutter.insert();
        }

        

        resp.sendRedirect("/mutter/read");
    }
}