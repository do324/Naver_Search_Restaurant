package com.example.restaurant.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

abstract public class MemoryDbRepositoryAbstract<T extends MemoryDbEntity> implements MemoryDbRepositoryIfs<T> {

    private final List<T> db = new ArrayList<>();
    private int index = 0;  //primary key


    @Override
    public Optional<T> findById(int index) {
                //filter 란 db.stream()의 type   //getIndex()란 MemoryDbEntity 의 index
        return db.stream().filter(it -> it.getIndex() == index).findFirst();
                        //getIndex() 를 통해서 db 에서 해당 index 에 해당되는 데이터를 찾아서 첫번째 것을
                        //(optiona)하게 있을 수도 없을 수도 있는 데이터를 return
    }

    @Override
    public T save(T entity) {
        var optionalEntity = db.stream().filter(it -> it.getIndex() == entity.getIndex()).findFirst();

        if(optionalEntity.isEmpty()){
            //db에 데이터가 없는 경우
            index++;
            entity.setIndex(index);
            db.add(entity);
            return entity;
        }else{
            //db에 이미 데이터가 있는 경우
            var preIndex= optionalEntity.get().getIndex();  //사전에 있던 index 가져오기
            entity.setIndex(preIndex);  //새로운 데이터에 해당값을 setting 해줌

            deleteById(preIndex);   //이전에 있던 데이터를 지운다
            db.add(entity);         //새로 받은 entity 를 넣어줌
            return entity;
        }

    }

    @Override
    public void deleteById(int index) {                         //getIndex()와 index가 동일하면 optional한 객체를 찾아옴
        var optionalEntity = db.stream().filter(it -> it.getIndex() == index).findFirst();

        if(optionalEntity.isPresent()){
            db.remove(optionalEntity.get());
        }
    }

    @Override
    public List<T> findAll() {
        return db;
    }
}
