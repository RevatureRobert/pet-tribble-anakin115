package service;

import com.google.gson.Gson;
import jdbc.GenericDAO;
import jdbc.TribbleDAO;
import model.Lab;
import model.Tribble;

import java.util.List;

public class TribbleService {
    private TribbleDAO td;

    public TribbleService(GenericDAO genericDAO){
        td = new TribbleDAO ();
    }

    public List<Tribble> getAllTribbles(){
        return td.getList ();
    }

    public boolean save(String json){

        try{
            Tribble tribble = new Gson ().fromJson(json, Tribble.class);
            System.out.println (tribble.toString ());
            td.save (tribble);
            return true;
        } catch (Exception e){
            e.printStackTrace ();
            return false;
        }
    }

    public boolean delete(int id){
        try {
            td.delete (id);
            return true;
        } catch (Exception e) {
            e.printStackTrace ();
            return false;
        }
    }

    public void updateTribbleName(int id, String str){
        td.update (id,str);
    }

    public boolean updateTribbleLabId(int id, int labId){
        try{
            td.update (id,labId);
            return true;
        } catch (Exception e) {
            e.printStackTrace ();
            return false;
        }
    }
}
