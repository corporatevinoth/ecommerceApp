package com.ecommerce.order.model;

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
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
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
	private Long productId;
	

	@Column(unique = true)
	@NotNull
	private String productCode;

	@NotNull
	@Size(min = 2, message = "Product Name should have atleast 2 characters")
	private String productName;

	@NotNull
	@Size(min = 2, message = "Product description should have atleast 5 characters")
	private String productCategory;

	@DecimalMin(value = "0.5", inclusive = false, message = "Product unit price should be greater than 0.5 rs")
	@Digits(integer = 3, fraction = 2)
	private BigDecimal unitPrice;

	@NotNull
	private String quantity;

	@Column(name = "batchNo", nullable = false)
	private Long batchNo;
	
	@Future(message = "Expiry Date should be Future Date")
	private Date expDate;
	
	@Past(message = "Manufactured Date should be Past Date")
	private Date mfgDate;

	
}
