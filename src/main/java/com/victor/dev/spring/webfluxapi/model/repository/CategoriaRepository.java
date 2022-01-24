package com.victor.dev.spring.webfluxapi.model.repository;

import com.victor.dev.spring.webfluxapi.model.document.Categoria;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CategoriaRepository extends ReactiveMongoRepository<Categoria, String>{

}
