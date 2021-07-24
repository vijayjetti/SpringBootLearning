package com.vijay.springbootlearning.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Field;

import java.util.List;

@Data
@Builder
@EqualsAndHashCode(exclude = {"addresses"})
public class Customer {
    @Id
    private String id;
    @Field
    private String name;
    @Field
    private Integer age;
    @Field
    private String email;
    @Field
    private List<Address> addresses;
}
