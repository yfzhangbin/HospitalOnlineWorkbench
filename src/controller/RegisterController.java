package controller;

import dao.PatientDao;
import model.Patient;
import util.DateUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 注册控制类
 */
public class RegisterController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PatientDao dao;

    public RegisterController() {
        super();
        dao = new PatientDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Patient doc = new Patient();
        doc.setName(request.getParameter("name"));
        doc.setSex(request.getParameter("sex"));
        doc.setBirthday(DateUtil.parseYYMMDD(request.getParameter("birthday")));
        doc.setPhone(request.getParameter("phone"));
        doc.setEmail(request.getParameter("email"));
        doc.setPassword(request.getParameter("password"));
        dao.add(doc);
        response.sendRedirect("/");
    }
}
