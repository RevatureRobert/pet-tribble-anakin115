package jdbc;

import config.ConnectionUtil;
import model.Lab;
import model.Tribble;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TribbleDAO implements GenericDAO<Tribble> {

    private static TribbleDAO instance;

    static TribbleDAO getInstance(){
        if(instance == null){
            instance = new TribbleDAO ();
        }
        return instance;
    }

    @Override
    public void save(Tribble tribble) {
        try {

            PreparedStatement ps = ConnectionUtil.getInstance().getConnection().prepareStatement(
                    "insert into tribble (name,age,size) values (?,?,?)");
            ps.setString(1,tribble.getName ());
            ps.setInt (2,tribble.getAge ());
            ps.setInt (3,tribble.getSize ());

            System.out.println (ps);
            ps.executeUpdate();
            ps.close ();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Tribble> getList() {
        List<Tribble> tribbleList = new ArrayList<Tribble> ();
        try {
            PreparedStatement ps = ConnectionUtil.getInstance ().getConnection ().prepareStatement (
                    "select * from tribble");
            ResultSet rs = ps.executeQuery ();
            while(rs.next ()){
                String name = rs.getString("name");
                int id = rs.getInt ("tribble_id");
                int age = rs.getInt ("age");
                int size = rs.getInt ("size");
                int labId = rs.getInt ("lab_id");

                tribbleList.add (new Tribble (id,name,age,size,labId));
            }
            ps.close ();
        } catch (SQLException throwables) {
            throwables.printStackTrace ();
        }
        return tribbleList;
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement ps = ConnectionUtil.getInstance ().getConnection ().prepareStatement (
                    "delete from tribble where tribble_id = (?)");
            ps.setInt (1,id);
            System.out.println (ps);
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
                    "update tribble set name = (?)," +
                            " where tribble_id = (?)");
            ps.setString (1,str);
            ps.setInt (2,id);

            ps.executeUpdate();
            ps.close ();
        } catch (SQLException throwables) {
            throwables.printStackTrace ();
        }
    }

    @Override
    public void update(int id, int labId) {
        try {
            PreparedStatement ps = ConnectionUtil.getInstance ().getConnection ().prepareStatement (
                    "update tribble set lab_id = (?)" +
                            " where tribble_id = (?)");
            ps.setInt (1,labId);
            ps.setInt (2,id);
            System.out.println (ps);
            ps.executeUpdate();
            ps.close ();
        } catch (SQLException throwables) {
            throwables.printStackTrace ();
        }
    }
}
