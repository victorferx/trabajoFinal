package com.nttdata.finance.model.document;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("persons")
public class Person extends Customer {
    private String dni;
    private String name;
    private String lastName;
}
