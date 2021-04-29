package servlet;

import com.google.gson.Gson;
import jdbc.JDBCFactory;
import model.Lab;
import service.LabService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = "/lab")
public class LabServlet extends HttpServlet {

    Gson gson = new Gson();


    public LabServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LabService ls = new LabService (JDBCFactory.daoFactory (Lab.class));
        resp.getWriter ().println ("List of labs : ");
        resp.getWriter ().print(gson.toJson (ls.getAllLabs ()));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        LabService ls = new LabService (JDBCFactory.daoFactory (Lab.class));
        String body = req.getReader ().lines().collect (Collectors.joining ());

        if(ls.save (body)){
            resp.setStatus (201);
        } else {
            resp.setStatus (400);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LabService ls = new LabService (JDBCFactory.daoFactory (Lab.class));

        String str = req.getParameter("labId");
        int labId = Integer.parseInt(str);
        if(ls.delete (labId)){
            resp.setStatus (201);
        } else {
            resp.setStatus (400);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LabService ls = new LabService (JDBCFactory.daoFactory (Lab.class));

        String str = req.getParameter("labId");
        String str2 = req.getParameter("labName");

        int labId = Integer.parseInt(str);
        if(ls.updateLabName (labId,str2)){
            resp.setStatus (201);
        } else {
            resp.setStatus (400);
        }
    }
}
