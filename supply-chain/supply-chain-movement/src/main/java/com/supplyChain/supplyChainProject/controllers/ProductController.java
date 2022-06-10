package com.supplyChain.supplyChainProject.controllers;

import com.supplyChain.supplyChainProject.models.Product;
import com.supplyChain.supplyChainProject.repositories.ProductRepository;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import org.json.*;

@RestController
public class ProductController {

    private final ProductRepository _productRepository;
    private final String baseUrl = "/products";

    public ProductController(ProductRepository productRepository) {
        _productRepository = productRepository;
    }

    @GetMapping(baseUrl + "/init")
    ResponseEntity<List<Product>> initialize() {
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://fakestoreapi.com/products?limit=10"))
                    .GET()
                    .build();

            var response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JSONArray obj = new JSONArray(response.body());

            List<Product> productList = new ArrayList<Product>();

            for (int i = 0; i < obj.length(); i++) {
                Product product = new Product();
                product.setId((long) i);
                product.setName(obj.getJSONObject(i).getString("title"));
                product.setDescription(obj.getJSONObject(i).getString("description"));
                product.setPrice(obj.getJSONObject(i).getDouble("price"));

                productList.add(product);
            }

            var repoSave = _productRepository.saveAllAndFlush(productList);

            return ResponseEntity.status(HttpStatus.CREATED).body(repoSave);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @GetMapping(baseUrl + "/getAllProducts")
    ResponseEntity<Iterable<Product>> getAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(_productRepository.findAll());
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

}
