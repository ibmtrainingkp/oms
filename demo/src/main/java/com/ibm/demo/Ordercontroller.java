package com.ibm.demo;

/*import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ordercontroller {
	@PostMapping
	String createOrder() {
		return "success";
	}
	@GetMapping("/order")
	String getOrder() {
		return "order created";
	}
	@PutMapping("/order/{id}")
	String updateOrder(@PathVariable("id")int orderid) {
		System.out.println("orderId");
		return "order updated";
	}
	@DeleteMapping("/order/{id}")
	String deleteOrder(@PathVariable("id")int orderid) {
		System.out.println("orderId");
		return "order deleted";
	}
}
/*