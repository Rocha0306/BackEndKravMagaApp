package com.Krav.api.UsersCase;



public abstract class CrudCases<T> {

    public abstract void Registration(T t);

    public abstract T Update(T t);

    public abstract T Find(T t);

    public abstract T Delete(T t);



}
