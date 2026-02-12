package com.ekart.product.api;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ekart.product.dto.ProductDTO;
import com.ekart.product.exception.EKartProductException;
import com.ekart.product.service.CustomerProductService;

@CrossOrigin
@RestController
@RequestMapping(value = "/product-api")
@Validated
public class CustomerProductAPI {

	@Autowired
	private CustomerProductService customerProductService;

	@Autowired
	private Environment environment;

	Log logger = LogFactory.getLog(CustomerProductAPI.class);

	// Get all the product details by calling getAllProducts() of
	// CustomerProductService and return the same
	@GetMapping(value = "/products")
	public ResponseEntity<List<ProductDTO>> getAllProducts() throws EKartProductException {
		List<ProductDTO> productDTO = customerProductService.getAllProducts();
		return new ResponseEntity<List<ProductDTO>>(productDTO, HttpStatus.OK);
	}

	// Get the specific product by calling getProductById() of
	// CustomerProductService and return the same
	@GetMapping(value = "/product/{productId}")
	public ResponseEntity<ProductDTO> getProductById(@PathVariable Integer productId) throws EKartProductException {
		logger.info("Received a request to get product " + productId);
		ProductDTO productDTO = customerProductService.getProductById(productId);
		// write your logic here
		return ResponseEntity.ok(productDTO);
	}

//reduce the available quantity of product by calling reduceAvailableQuantity() of CustomerProductService and return the message with property as ProductAPI.REDUCE_QUANTITY_SUCCESSFULL
	@PutMapping(value = "/update/{productId}")
	public ResponseEntity<String> reduceAvailableQuantity(@PathVariable Integer productId,
			@RequestBody Integer quantity) throws EKartProductException {
		// write your logic here
		customerProductService.reduceAvailableQuantity(productId, quantity);
		String msg = environment.getProperty("ProductAPI.REDUCE_QUANTITY_SUCCESSFULL");
		return new ResponseEntity<String>(msg, HttpStatus.OK);

	}
}
