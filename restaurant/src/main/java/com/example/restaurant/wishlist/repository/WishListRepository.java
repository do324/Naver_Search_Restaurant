package com.example.restaurant.wishlist.repository;

import com.example.restaurant.db.MemoryDbRepositoryAbstract;
import com.example.restaurant.wishlist.entity.WishListEntity;
import org.springframework.stereotype.Repository;

@Repository //db를 저장하는 곳이다
public class WishListRepository extends MemoryDbRepositoryAbstract<WishListEntity> {
}
