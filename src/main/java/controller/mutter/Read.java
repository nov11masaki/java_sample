package controller.mutter;

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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@WebServlet("/mutter/read")
public class Read extends HttpServlet{
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();

        // セッションスコープからログイン済みユーザーを取り出す
        User user = (User) session.getAttribute("currentUser");

        //top.jspの内容を表示
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/user/top.jsp");
        dispatcher.forward(req, resp);
    }
}