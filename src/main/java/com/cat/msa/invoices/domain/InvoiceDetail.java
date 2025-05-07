package com.cat.msa.invoices.domain;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvoiceDetail {

  private Long id;

  private String productName;

  private Integer quantity;

  private BigDecimal unitPrice;

  private BigDecimal subTotal;

  public void calculateSubTotal(){
    subTotal = unitPrice.multiply(new BigDecimal(quantity));
  }

}
