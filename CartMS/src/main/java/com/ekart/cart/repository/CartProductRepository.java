package com.ekart.cart.repository;



import org.springframework.data.repository.CrudRepository;

import com.ekart.cart.entity.CartProduct;
import org.springframework.stereotype.Repository;

@Repository
public interface CartProductRepository extends CrudRepository<CartProduct, Integer> {

}
