package com.example.restaurant.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemoryDbEntity {  //모든 db를 가진 애들은 MemoryDbEntity 를 상속받는다
    protected Integer index;
}
