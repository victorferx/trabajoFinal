package com.nttdata.finance.model.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Holder {
    @Id
    private String id = new ObjectId().toString();
    private String idPassiveAccount;
    private String idCustomer;
}
