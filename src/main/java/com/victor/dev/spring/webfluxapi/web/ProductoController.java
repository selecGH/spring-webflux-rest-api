package com.victor.dev.spring.webfluxapi.web;

import com.victor.dev.spring.webfluxapi.model.document.Producto;
import com.victor.dev.spring.webfluxapi.model.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public Flux<Producto> getProductos() {
        return productoService.findAll();
    }

    @GetMapping("/mono")
    public Mono<ResponseEntity<Flux<Producto>>> getProductosMono() {
        return Mono.just(ResponseEntity.ok().body(this.productoService.findAll()));
    }

    @GetMapping("/{productoId}")
    public Mono<ResponseEntity<Producto>> getProductoById(@PathVariable String productoId) {
        return productoService.findById(productoId)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

}
