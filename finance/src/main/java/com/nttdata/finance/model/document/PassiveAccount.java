package com.nttdata.finance.model.document;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassiveAccount {
    @Id
    private String id = new ObjectId().toString();
    @NotBlank(message="No puede ser vacio el numero de cuenta.")
    private String number;
    private String idPasiveProduct;
    private String idCustomer;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Timestamp creation;
    @DecimalMin("0.00")
    private BigDecimal amount;
    private String status;
}
