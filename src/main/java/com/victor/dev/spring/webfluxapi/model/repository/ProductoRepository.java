package com.victor.dev.spring.webfluxapi.model.repository;

import com.victor.dev.spring.webfluxapi.model.document.Producto;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;



public interface ProductoRepository extends ReactiveMongoRepository<Producto, String>{

}
