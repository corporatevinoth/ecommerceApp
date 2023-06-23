package com.ecommerce.order.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "orders")
@Builder
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String orderId;

	@FutureOrPresent(message="Order Date should be future or present")
	private Date orderDate;

	@Pattern(regexp = "^(DELIVERY|PICKUP)$", message = "invalid order type")
	private String orderType;
	
	@Pattern(regexp = "^(INCART|PLACED|DELIVERED|PAYMENTCMPLTED|)$", message = "invalid order type")
	private String orderStatus;
	
}