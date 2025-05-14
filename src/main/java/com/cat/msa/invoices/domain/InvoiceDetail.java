package com.cat.msa.invoices.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "T_INVOICE_DETAILS")
public class InvoiceDetail {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "IND_ID", nullable = false)
  private Long id;

  @Column(name = "IND_PROD_NAME", nullable = false)
  private String productName;

  @Column(name = "IND_QUANTITY", nullable = false)
  private Integer quantity;

  @Column(name = "IND_UNIT_PRICE", nullable = false)
  private BigDecimal unitPrice;

  @Column(name = "IND_SUB_TOTAL", nullable = false)
  private BigDecimal subTotal;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "IND_INH_ID", nullable = false)
  private InvoiceHeader invoiceHeader;

  public void calculateSubTotal(){
    subTotal = unitPrice.multiply(new BigDecimal(quantity));
  }

}
