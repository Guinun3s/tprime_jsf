package com.example.tprime.model;

import java.io.Serializable;


import javax.persistence.*;
import lombok.*;

@Data
@MappedSuperclass
public abstract class AbstractEntity<ID extends Serializable> implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ID id;
    
}
