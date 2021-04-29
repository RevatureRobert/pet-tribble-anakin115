package jdbc;

public class JDBCFactory {

    public static GenericDAO daoFactory(Class c){
        switch(c.getName()){

            case"model.Lab":
                return LabDAO.getInstance();

            case"model.Tribble":
                return TribbleDAO.getInstance ();

            default:
                throw new IllegalArgumentException("The class provided does not have a corresponding dao object");
        }
    }
}
