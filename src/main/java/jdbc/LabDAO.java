package jdbc;

import config.ConnectionUtil;
import model.Lab;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LabDAO implements GenericDAO<Lab>{

    private static LabDAO instance;

    static LabDAO getInstance(){
        if(instance == null){
            instance = new LabDAO ();
        }
        return instance;
    }

    @Override
    public void save(Lab lab) {
        try {

            PreparedStatement ps = ConnectionUtil.getInstance().getConnection().prepareStatement(
                    "insert into lab (lab_name) values (?)");
            ps.setString(1,lab.getLabName ());
            System.out.println (ps);
            int i = ps.executeUpdate();
            ps.close ();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Lab> getList() {
        List<Lab> labList = new ArrayList<Lab> ();
        try {
            PreparedStatement ps = ConnectionUtil.getInstance ().getConnection ().prepareStatement (
                    "select * from lab");
            System.out.println (ps);
            ResultSet rs = ps.executeQuery ();

            while(rs.next ()){
                String name = rs.getString("lab_name");
                int id = rs.getInt ("lab_id");

                labList.add (new Lab (id,name));
            }

            ps.close ();
        } catch (SQLException throwables) {
            throwables.printStackTrace ();
        }

        return labList;
    }

    @Override
    public void delete(int id) {

        try {
            PreparedStatement ps = ConnectionUtil.getInstance ().getConnection ().prepareStatement (
                    "delete from lab where lab_id = (?)");
            ps.setInt (1,id);
            ps.executeUpdate();
            ps.close ();
        } catch (SQLException throwables) {
            throwables.printStackTrace ();
        }
    }

    @Override
    public void update(int id, String str) {
        try {
            PreparedStatement ps = ConnectionUtil.getInstance ().getConnection ().prepareStatement (
                    "update lab set lab_name = (?) " +
                            " where lab_id = (?)");
            ps.setString (1,str);
            ps.setInt (2,id);
            System.out.println (ps);
            ps.executeUpdate();
            ps.close ();
        } catch (SQLException throwables) {
            throwables.printStackTrace ();
        }
    }

    @Override
    public void update(int id, int labId) {

    }


}
