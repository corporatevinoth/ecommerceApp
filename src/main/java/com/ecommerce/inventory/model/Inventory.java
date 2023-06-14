package com.ecommerce.inventory.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
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
@Table(name = "inventory")
public class Inventory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long inventoryId;

	@NotNull
	@Size(min = 2, message = "Inventory Name should have atleast 2 characters")
	private String inventoryname;

	@NotNull
	@Size(min = 2, message = "Inventory description should have atleast 5 characters")
	private String inventoryDescription;

	@Min(value = 10, message = "Inventory totalCapacity greater than 10")
	private Long totalCapacity;

	@Min(value = 1, message = "Inventory availableCapacity greater than 1")
	@Max(value = 9, message = "Inventory availableCapacity lessthan than 10")
	private Long availableCapacity;

	@Pattern(regexp = "^(ACTIVE|DISCONTINUTED)$", message = "invalid code")
	private String status;

}
