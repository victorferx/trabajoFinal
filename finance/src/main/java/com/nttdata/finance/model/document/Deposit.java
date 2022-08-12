package com.nttdata.finance.model.document;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.DecimalMin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Entidad Deposit.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("deposits")
public class Deposit {
  @Id
  private String id = new ObjectId().toString();
  private PassiveAccount passiveAccount;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
  private Date operation;
  @DecimalMin("0.00")
  private BigDecimal amount;
  private Customer customer;
}
