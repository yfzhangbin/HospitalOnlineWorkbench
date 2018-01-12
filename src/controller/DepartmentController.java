package controller;

import dao.DepartmentDao;
import model.Department;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 科室控制类
 */
public class DepartmentController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/department/edit.jsp";
    private static String LIST_DEP = "/department/list.jsp";
    private DepartmentDao dao;

    public DepartmentController() {
        super();
        dao = new DepartmentDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String forward="";
        if (action.equalsIgnoreCase("delete")){
            int depId = Integer.parseInt(request.getParameter("id"));
            dao.delete(depId);
            forward = LIST_DEP;
            request.setAttribute("deps", dao.getAll());
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int depId = Integer.parseInt(request.getParameter("id"));
            Department dep = dao.getById(depId);
            request.setAttribute("dep", dep);
        } else if (action.equalsIgnoreCase("list")){
            forward = LIST_DEP;
            request.setAttribute("deps", dao.getAll());
        } else {
            forward = INSERT_OR_EDIT;
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Department dep = new Department();
        dep.setName(request.getParameter("name"));
        dep.setAddress(request.getParameter("address"));
        String depId = request.getParameter("id");
        if(depId == null || depId.isEmpty()) {
            dao.add(dep);
        } else {
            dep.setId(Integer.parseInt(depId));
            dao.update(dep);
        }
        response.sendRedirect("/DepartmentController?action=list");
    }
}
