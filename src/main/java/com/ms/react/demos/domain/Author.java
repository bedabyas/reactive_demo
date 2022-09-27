package com.ms.react.demos.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Author {
    private UUID id;
    private String firstName;
    private String lastName;
    private String emailAddress;

}
