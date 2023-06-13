package com.ecommerce.productCatalog.model;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "productCatalog")
public class ProductCatalog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productCatalogNo;

	@NotNull
	@Size(min = 2, message = "Product Name should have atleast 2 characters")
	private String productName;

	@NotNull
	@Size(min = 2, message = "Product description should have atleast 5 characters")
	private String description;

	@DecimalMin(value = "0.5", inclusive = false, message = "Product unit price should be greater than 0.5 rs")
	@Digits(integer = 3, fraction = 2)
	private BigDecimal unitPrice;

	@Min(value = 1, message = "Product quantity should have atleast 2 characters")
	private Long quantity;

	@Column(name = "batchNo", nullable = false)
	private String batchNo;

	private Date productCatalogDate;

	@DecimalMin(value = "0.5", inclusive = false, message = "Product total price should be greater than 0.5 rs")
	@Digits(integer = 3, fraction = 2)
	private BigDecimal totalPrice;
}
