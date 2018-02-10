package controller;

import dao.RegistrationDao;
import model.Registration;
import util.DateUtil;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 挂号管理控制类
 */
public class RegistrationController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String ADD = "/registration/add.jsp";
    private static String EDIT = "/registration/edit.jsp";
    private static String FINAL = "/registration/final.jsp";
    private static String LIST = "/registration/list.jsp";
    private RegistrationDao dao;

    public RegistrationController() {
        super();
        dao = new RegistrationDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String forward="";
        if (action.equalsIgnoreCase("delete")){
            int id = Integer.parseInt(request.getParameter("id"));
            dao.delete(id);
            forward = LIST;
            request.setAttribute("list", dao.getAll(null));
        } else if (action.equalsIgnoreCase("edit")){
            forward = EDIT;
            int id = Integer.parseInt(request.getParameter("id"));
            Registration item = dao.getById(id);
            request.setAttribute("item", item);
        } else if (action.equalsIgnoreCase("final")){
            forward = FINAL;
            int id = Integer.parseInt(request.getParameter("id"));
            Registration item = dao.getById(id);
            request.setAttribute("item", item);
        } else if (action.equalsIgnoreCase("list")){
            forward = LIST;
            request.setAttribute("list", dao.getAll(null));
        } else {
            forward = ADD;
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Registration doc = new Registration();
        String patientId = request.getParameter("patientId");
        if (patientId != null && !patientId.isEmpty()) {
            doc.setPatientId(Integer.parseInt(patientId));
        }

        String departmentId = request.getParameter("departmentId");
        if (departmentId != null && !departmentId.isEmpty()) {
            doc.setDepartmentId(Integer.parseInt(departmentId));
        }

        String examinationId = request.getParameter("examinationId");
        if (examinationId != null && !examinationId.isEmpty()) {
            doc.setExaminationId(Integer.parseInt(examinationId));
        }

        String diagnosisId = request.getParameter("diagnosisId");
        if (diagnosisId != null && !diagnosisId.isEmpty()) {
            doc.setDiagnosisId(Integer.parseInt(diagnosisId));
        }

        String status = request.getParameter("status");
        if (status != null && !status.isEmpty()) {
            doc.setStatus(status);
        }

        String id = request.getParameter("id");
        if(id == null || id.isEmpty()) {
            dao.add(doc);
        } else {
            doc.setId(Integer.parseInt(id));
            dao.update(doc);
        }
        response.sendRedirect("/RegistrationController?action=list");
    }
}
