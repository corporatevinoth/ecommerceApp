package com.ecommerce.order.model;

import java.math.BigDecimal;
import java.util.List;

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
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "order_table")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;

	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pc_fid", referencedColumnName = "orderId")	
	private List<Product> products;

	@DecimalMin(value = "0.5", inclusive = false, message = "total price should be greater than 0.5 rs")
	@Digits(integer = 3, fraction = 2)
	private BigDecimal totalPrice;

	@Min(value = 1, message = "Product quantity should have atleast 2 characters")
	private Long quantity;

	@Pattern(regexp = "^(NETBANKING|CARD|COD|WALLET|EMI)$", message = "invalid code")
	private String paymentType;
	
}
