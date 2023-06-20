package com.ecommerce.payment.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "payment")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long paymentId;

	@NotNull
	@Column(unique = true)
	private String paymentCode;

	@NotNull
	private String orderId;

	@DecimalMin(value = "0.5", inclusive = false, message = "totalPrice price should be greater than 0.5 rs")
	@Digits(integer = 5, fraction = 2)
	private BigDecimal totalPrice;

	@DecimalMin(value = "0.5", inclusive = false, message = "gst price should be greater than 0.5 rs")
	@Digits(integer = 5, fraction = 2)
	private BigDecimal gst;

	@DecimalMin(value = "0.5", inclusive = false, message = "mrp price should be greater than 0.5 rs")
	@Digits(integer = 5, fraction = 2)
	private BigDecimal mrp;

	@Digits(integer = 5, fraction = 2)
	private BigDecimal discount;

	private Long rrn;

	@FutureOrPresent(message = "payment date should be present or future")
	private Date paymentDate;

	@Pattern(regexp = "^(INITIATED|INPROGRESS|PAID|RECONCILED|COMPLETED)$", message = "payment status valid types are INITIATED|INPROGRESS|PAID|RECONCILED|COMPLETED")
	private String status;

	@Pattern(regexp = "^(CARD|NETBANKING|WALLET|UPI|COD)$", message = "payment status valid types are CARD|NETBANKING|WALLET|UPI|COD")
	private String paymentType;
	
	@Transient
	private List<Order> orders;

}
