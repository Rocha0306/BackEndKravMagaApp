package com.Krav.api.UsersCase;


import java.util.List;

public abstract class CrudCases<T> {

    public abstract void Registration(T t);

    public abstract T Update(T objeto);

    public abstract List<T> Find();

    public abstract T Delete(T t);



}
