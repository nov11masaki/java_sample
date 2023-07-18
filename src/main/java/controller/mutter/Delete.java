package controller.mutter;

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
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/mutter/delete")
public class Delete extends HttpServlet{
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("currentUser");

        if(user == null){
            System.out.println("Userが不正です。");
            resp.sendRedirect("/mutter/read");
            return;
        }

        ArrayList<Mutter> mutters = Mutter.indexMutters(user);
        int id = Integer.parseInt(req.getParameter("id"));
        Mutter m;

        try{
            m = (Mutter)mutters.stream().filter(mutter -> mutter.getId()==id).toArray()[0];
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Userが不正です。");
            resp.sendRedirect("/mutter/read");
            return;
        }

        Mutter mutter = new Mutter(
                id
                ,null
                ,null
        );

        mutter.delete();

        resp.sendRedirect("/mutter/read");
    }
}