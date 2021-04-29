package service;

import com.google.gson.Gson;
import jdbc.GenericDAO;
import jdbc.LabDAO;
import model.Lab;

import java.util.List;

public class LabService {

    private LabDAO ld;

    public LabService(GenericDAO genericDAO) {
        ld = new LabDAO ();
    }

    public List<Lab> getAllLabs(){
        return ld.getList ();
    }

    public boolean save(String json){
        try{
            Lab lab = new Gson ().fromJson(json, Lab.class);
            System.out.println (lab.toString ());
            ld.save (lab);
            return true;
        } catch (Exception e){
            e.printStackTrace ();
            return false;
        }
    }

    public boolean delete(int id) {
        try {
            ld.delete (id);
            return true;
        } catch (Exception e) {
            e.printStackTrace ();
            return false;
        }
    }

    public boolean updateLabName(int id, String str){
        try{
            ld.update (id,str);
            return true;
        } catch (Exception e) {
            e.printStackTrace ();
            return false;
        }

    }
}
