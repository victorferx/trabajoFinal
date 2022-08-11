package com.nttdata.finance.model.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "businesses")
public class Business extends Customer {

    private String ruc;

    private String companyName;
}
