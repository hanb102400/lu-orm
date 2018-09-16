package com.rats.orm.repository;

import com.rats.orm.data.DataRow;
import com.rats.orm.data.DataSet;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class DataRepository<T, ID> extends SimpleRepository<T, ID> {

     <S extends T> DataSet<S> findAll(String var1, Map params) throws Exception{
        return null;
     }

    DataRow<String,Object> findById(ID var1){
        return null;
    }

}
