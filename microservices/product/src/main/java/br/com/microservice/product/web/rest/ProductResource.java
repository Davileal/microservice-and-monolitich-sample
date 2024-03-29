package br.com.microservice.product.web.rest;

import br.com.microservice.product.domain.Product;
import br.com.microservice.product.enums.EntityStatusEnum;
import br.com.microservice.product.exception.CustomException;
import br.com.microservice.product.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zalando.problem.Status;

import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductResource {

    private ProductRepository repository;

    public ProductResource(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity findAll() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable String id) {
        Optional<Product> product = repository.findById(id);
        if (!product.isPresent()) {
            throw new CustomException("Product not found", Status.NOT_FOUND);
        }
        return new ResponseEntity<>(repository.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Product product) {
        return new ResponseEntity<>(repository.save(product), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity update(@RequestBody Product product) {
        return new ResponseEntity<>(repository.save(product), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        Optional<Product> product = repository.findById(id);
        if (!product.isPresent()) {
            throw new CustomException("Product not found", Status.NOT_FOUND);
        }
        product.get().setStatus(EntityStatusEnum.INACTIVE);
        return new ResponseEntity<>(repository.save(product.get()), HttpStatus.OK);
    }

}
