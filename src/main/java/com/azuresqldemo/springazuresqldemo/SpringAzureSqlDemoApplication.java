package com.azuresqldemo.springazuresqldemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@SpringBootApplication
@RestController
public class SpringAzureSqlDemoApplication {

	Logger log
			= Logger.getLogger(
			SpringAzureSqlDemoApplication.class.getName());

	@Autowired
	private ProductRepository productRepository;

	@PostMapping("/product")
	public Product addProduct(@RequestBody Product product) {
		log.info("Adding product to the database: " + product.toString());
		return productRepository.save(product);
	}

	@GetMapping("/getAllProducts")
	public List<Product> getAllProducts() {
		log.info("Searching for all products in database");
		return productRepository.findAll();
	}

	@GetMapping("/getProduct/{id}")
	public Optional<Product> getProductById(@PathVariable int id) {
		log.info("Getting details for product with id: " + id);
		return productRepository.findById(id);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringAzureSqlDemoApplication.class, args);
	}

}
