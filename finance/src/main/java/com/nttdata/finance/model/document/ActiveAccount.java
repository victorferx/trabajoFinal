package com.nttdata.finance.model.document;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.DecimalMin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Entidad ActiveAccount.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "activeAccounts")
public class ActiveAccount {
  @Id
  private String id;
  private String number;
  private ActiveProduct activeProduct;
  private Customer customer;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
  private Date creation;
  @DecimalMin("0.00")
  private BigDecimal amount;
  private String status;
}