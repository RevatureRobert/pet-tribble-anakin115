package jdbc;

import java.util.List;

public interface GenericDAO <T> {

    void save(T t);
    List<T> getList();
    void delete(int t);
    void update(int id, String str);
    void update(int id, int labId);
}
