package Repository;

import java.util.List;
import java.util.Optional;

public interface _CrudRepository<T> {
    void Insert(T entity);
    void Update(T entity, int id);
    void Delete(int id);
    Optional<T> GetById(int id);
    List<T> GetAll();
}
