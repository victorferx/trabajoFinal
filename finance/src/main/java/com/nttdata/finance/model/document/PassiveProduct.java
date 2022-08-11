package com.nttdata.finance.model.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassiveProduct {
    @Id
    private String id = new ObjectId().toString();
    private String name;
    @DecimalMin("0.00")
    private BigDecimal maintenanceCommission;
    private Long movementLimit;
}
