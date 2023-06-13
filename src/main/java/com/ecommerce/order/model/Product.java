package com.ecommerce.order.model;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;

	@NotNull
	@Size(min = 2, message = "Product Name should have atleast 2 characters")
	private String name;

	@NotNull
	@Size(min = 2, message = "Product description should have atleast 5 characters")
	private String description;

	@DecimalMin(value = "0.5", inclusive = false, message = "Product unit price should be greater than 0.5 rs")
	@Digits(integer = 3, fraction = 2)
	private BigDecimal unitPrice;

	@Min(value = 1, message = "Product quantity should have atleast 2 characters")
	private Long quantity;

	@Pattern(regexp = "^(ACTIVE|DISCONTINUTED)$", message = "invalid code")
	private String status;

	@Column(name = "batchNo", nullable = false)
	private String batchNo;

	private Date expDate;

	@Email
	@NotBlank
	private String contactEmail;
}
