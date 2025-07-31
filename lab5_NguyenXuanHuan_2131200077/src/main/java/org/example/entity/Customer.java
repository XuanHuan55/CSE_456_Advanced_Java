package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class Customer {
    @Getter
    @Setter
    @Entity
    @AllArgsConstructor
    @NoArgsConstructor
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String name;

        public Customer() {}
        public Customer(String name) { this.name = name; }

}
