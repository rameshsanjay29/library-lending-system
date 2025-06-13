package com.library.model;

import lombok.Data;
import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String username;
    private String password;
    
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> roles;
}
