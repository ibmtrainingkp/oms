package com.ibm.demo;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.demo.entity.Order;
import com.ibm.demo.service.OrderService;

@RestController
public class Ordercontroller { // frontend
	@Autowired // is used for DI
	OrderService orderService; // DI

	@PostMapping("/order")
	@ResponseStatus(code = HttpStatus.CREATED)
	String createOrder(@RequestBody @Valid Order order, BindingResult bindingresult) {
		validateModel(bindingresult);
		System.out.println(order);
		return orderService.createOrder(order);

	}
	
	@GetMapping("/order")
	List<Order> getOrders(){
		return orderService.getOrders();
	}
	
	
	@GetMapping("/order/{id}")
	Order getOrder(@PathVariable("id") int orderId) {
		return orderService.getOrder(orderId);
	}

	private void validateModel(Errors bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new IllegalArgumentException("something went wrong.");
		}
}

//DRY
	@PutMapping("/order/{id}")
	void updateOrder(@RequestBody @Valid Order order, BindingResult bindingresult, @PathVariable("id") int orderId) {
		System.out.println(orderId);
		orderService.updateOrder(orderId);
	}

	@DeleteMapping("/order/{id}")
	String deleteOrder(@PathVariable("id") int orderId, HttpRequest httpRequest) {
		System.out.println(httpRequest.getHeaders());
		System.out.println(orderId);
		return "order deleted";
	}
}
