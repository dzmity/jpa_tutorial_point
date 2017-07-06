package by.rafalovich.study.simple_jpa.dao;

public interface IDao<T>
{
    void create(T t);

    T find(Long id);

    void delete(T t);

    void update(T t);
}
