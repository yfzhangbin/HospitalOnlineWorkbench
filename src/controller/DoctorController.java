package controller;

import dao.DoctorDao;
import model.Doctor;
import util.DateUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 医生管理控制类
 */
public class DoctorController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/doctor/edit.jsp";
    private static String LIST = "/doctor/list.jsp";
    private DoctorDao dao;

    public DoctorController() {
        super();
        dao = new DoctorDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String forward="";
        if (action.equalsIgnoreCase("delete")){
            int id = Integer.parseInt(request.getParameter("id"));
            dao.delete(id);
            forward = LIST;
            request.setAttribute("list", dao.getAll());
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int id = Integer.parseInt(request.getParameter("id"));
            Doctor doc = dao.getById(id);
            request.setAttribute("item", doc);
        } else if (action.equalsIgnoreCase("list")){
            forward = LIST;
            request.setAttribute("list", dao.getAll());
        } else {
            forward = INSERT_OR_EDIT;
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Doctor doc = new Doctor();
        doc.setName(request.getParameter("name"));
        doc.setSex(request.getParameter("sex"));
        doc.setBirthday(DateUtil.parseYYMMDD(request.getParameter("birthday")));
        doc.setPhone(request.getParameter("phone"));
        doc.setLevel(request.getParameter("level"));
        doc.setDepartmentId(Integer.parseInt(request.getParameter("departmentId")));
        String id = request.getParameter("id");
        if(id == null || id.isEmpty()) {
            dao.add(doc);
        } else {
            doc.setId(Integer.parseInt(id));
            dao.update(doc);
        }
        response.sendRedirect("/DoctorController?action=list");
    }
}
