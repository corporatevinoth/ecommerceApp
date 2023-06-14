package com.ecommerce.customer.model;

import java.math.BigDecimal;

import com.ecommerce.customer.config.ValidPhoneNumber;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;

	@NotNull
	@Size(min = 2, message = "Product Name should have atleast 2 characters")
	private String customerName;

	@NotNull
	@Size(min = 20, message = "orderShippingAddress should have atleast 20 characters")
	private String customerAddress;
	

	@NotNull
	@Size(min = 20, message = "orderBillingAddress should have atleast 20 characters")
	private String customerBillingAddress;

	
	@ValidPhoneNumber
	private BigDecimal orderContactNo;
	
	@NotNull
	private String customerEmailId;
	
	@Pattern(regexp = "^(AADHAR|PANCARD|DRIVERLICENCE)$", message = "invalid customer Proof Type")
	private String customerProofType;
	
	@NotNull
	private String customerProofId;
}
