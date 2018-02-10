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
 * 患者管理控制类
 */
public class PatientController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/patient/edit.jsp";
    private static String LIST = "/patient/list.jsp";
    private PatientDao dao;

    public PatientController() {
        super();
        dao = new PatientDao();
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
            Patient item = dao.getById(id);
            request.setAttribute("item", item);
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
        Patient doc = new Patient();
        doc.setName(request.getParameter("name"));
        doc.setSex(request.getParameter("sex"));
        doc.setBirthday(DateUtil.parseYYMMDD(request.getParameter("birthday")));
        doc.setPhone(request.getParameter("phone"));
        String id = request.getParameter("id");
        if(id == null || id.isEmpty()) {
            dao.add(doc);
        } else {
            doc.setId(Integer.parseInt(id));
            dao.update(doc);
        }
        response.sendRedirect("/PatientController?action=list");
    }
}
