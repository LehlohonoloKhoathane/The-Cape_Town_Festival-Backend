package za.ac.uct.repository;

/**
 * IRepository.java
 * interface for the IRepository
 * Author: Lehlohonolo Khoathane
 * Date: 24/11/202
 */
@Deprecated
public interface IRepository<T, ID> {
    T create(T entity);

    T read(ID id);

    T update(T entity);

    boolean delete(ID id);
}