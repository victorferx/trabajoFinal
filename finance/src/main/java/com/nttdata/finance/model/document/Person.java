package com.nttdata.finance.model.document;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Entidad Person.
 */
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
