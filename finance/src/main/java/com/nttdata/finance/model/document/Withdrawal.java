package com.nttdata.finance.model.document;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.validation.constraints.DecimalMin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

/**
 * Entidad Withdrawal.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Withdrawal {
  @Id
  private String id = new ObjectId().toString();
  private String idPassiveAccount;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
  private Timestamp operation;
  @DecimalMin("0.00")
  private BigDecimal amount;
  private String idCustomer;
}
