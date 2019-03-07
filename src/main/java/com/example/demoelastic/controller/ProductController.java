package com.example.demoelastic.controller;

import com.example.demoelastic.entity.Product;
import com.example.demoelastic.repository.ProductRepository;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mustley
 * @version $Revision: $<br/>
 * $Id: $
 * @since 07/03/19 13:36
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/{uuid}")
    public ResponseEntity searchId(@PathVariable final String uuid) {
        return ResponseEntity.ok(productRepository.findById(uuid));
    }

    @PostMapping
    public ResponseEntity addProduct(@RequestBody final String name) {
        final String uuid = UUID.randomUUID().toString().replace("-","").toUpperCase();
        Product product = productRepository.save(Product.builder().id(uuid).name(name).build());
        return ResponseEntity.created(URI.create(String.format("/products/",uuid))).body(product);
    }

    @GetMapping("/search")
    public ResponseEntity searchName(@RequestParam final String name) {
        final String encoded;
        try {
            encoded = URLEncoder.encode(name, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return  ResponseEntity.badRequest().body(e);
        }
        return ResponseEntity.ok(productRepository.findAllByNameLike(encoded));
    }

}
