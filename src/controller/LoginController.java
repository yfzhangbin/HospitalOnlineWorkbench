package controller;

import dao.PatientDao;
import model.Patient;
import util.ConstantUtil;
import util.DateUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static util.ConstantUtil.ERROR_MSG;

/**
 * 登录控制类
 */
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PatientDao dao;

    public LoginController() {
        super();
        dao = new PatientDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Patient patient = dao.getByEmailAndPassword(email, password);
        if (patient != null) {
            request.getSession().setAttribute(ConstantUtil.LOGIN_USER, patient);
            response.sendRedirect("/");
        } else {
            request.setAttribute(ERROR_MSG,"无效用户或密码!");
            RequestDispatcher view = request.getRequestDispatcher("/login.jsp");
            view.forward(request, response);
        }
    }
}
