package servlet;

import com.google.gson.Gson;
import jdbc.JDBCFactory;
import model.Lab;
import model.Tribble;
import service.LabService;
import service.TribbleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = "/tribble")
public class TribbleServlet extends HttpServlet {
    Gson gson = new Gson();


    public TribbleServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        TribbleService ts = new TribbleService (JDBCFactory.daoFactory (Tribble.class));
        resp.getWriter ().println ("List of tribbles : ");
        resp.getWriter ().print(gson.toJson (ts.getAllTribbles ()));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        TribbleService ts = new TribbleService (JDBCFactory.daoFactory (Tribble.class));
        String body = req.getReader ().lines().collect (Collectors.joining ());

        if(ts.save (body)){
            resp.setStatus (201);
        } else {
            resp.setStatus (400);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TribbleService ts = new TribbleService (JDBCFactory.daoFactory (Tribble.class));

        String str = req.getParameter("tribbleId");
        int id = Integer.parseInt(str);
        if(ts.delete (id)){
            resp.setStatus (201);
        } else {
            resp.setStatus (400);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TribbleService ts = new TribbleService (JDBCFactory.daoFactory (Tribble.class));

        String str = req.getParameter("tribbleId");
        String str2 = req.getParameter("labId");

        int id = Integer.parseInt(str);
        int labId = Integer.parseInt(str);
        if(ts.updateTribbleLabId (id,labId)){
            resp.setStatus (201);
        } else {
            resp.setStatus (400);
        }
    }
}
