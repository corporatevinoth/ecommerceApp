package com.ecommerce.order.model;

import java.math.BigDecimal;
import java.util.List;

import com.ecommerce.order.customValidation.ValidPhoneNumber;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
	
	@NotNull
	@Size(min = 20, message = "orderShippingAddress should have atleast 20 characters")
	private String orderShippingAddress;
	

	@NotNull
	@Size(min = 20, message = "orderBillingAddress should have atleast 20 characters")
	private String orderBillingAddress;
	
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pc_fid", referencedColumnName = "orderId")	
	private List<Product> products;

	@DecimalMin(value = "0.5", inclusive = false, message = "total price should be greater than 0.5 rs")
	@Digits(integer = 3, fraction = 2)
	private BigDecimal orderTotalPrice;
	
	
	@DecimalMin(value = "0.5", inclusive = false, message = "tax price should be greater than 0.5 rs")
	@Digits(integer = 3, fraction = 2)
	private BigDecimal orderTax;
	
	@DecimalMin(value = "0.5", inclusive = false, message = "orderPrice should be greater than 0.5 rs")
	@Digits(integer = 3, fraction = 2)
	private BigDecimal orderPrice;
	
	@ValidPhoneNumber
	private BigDecimal orderContactNo;

	@Min(value = 1, message = "Order quantity shoulde be greater than 1")
	private Long quantity;

	@Pattern(regexp = "^(NETBANKING|CARD|COD|WALLET|EMI)$", message = "invalid payment type")
	private String paymentType;
	
}
