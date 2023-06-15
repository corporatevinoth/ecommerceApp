package com.ecommerce.customer.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.ecommerce.customer.config.ValidPhoneNumber;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
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
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
      name = "sequence-generator",
      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
      parameters = {
        @Parameter(name = "sequence_name", value = "user_sequence"),
        @Parameter(name = "initial_value", value = "100001"),
        @Parameter(name = "increment_size", value = "1")
        }
    )
	private Long customerId;

	@NotNull
	@Size(min = 2, message = "Product Name should have atleast 2 characters")
	private String customerName;

	@NotNull
	@Size(min = 20, message = "cusotmerShippingAddress should have atleast 20 characters")
	private String cusotmerShippingAddress;
	

	@NotNull
	@Size(min = 20, message = "customerBillingAddress should have atleast 20 characters")
	private String customerBillingAddress;

	
	@ValidPhoneNumber
	@Column(unique = true)
	private Long customerContactNumber;
	
	@NotNull
	private String customerEmailId;
	
	@Pattern(regexp = "^(AADHAR|PANCARD|DRIVERLICENCE)$", message = "invalid customer Proof Type valid types are AADHAR|PANCARD|DRIVERLICENCE")
	private String customerProofType;
	
	@NotNull
	private String customerProofId;
}
