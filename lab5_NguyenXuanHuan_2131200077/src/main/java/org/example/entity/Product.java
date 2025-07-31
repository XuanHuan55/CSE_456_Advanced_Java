package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class Product {
    @Entity
    @Getter
    @Setter
    @Entity
    @AllArgsConstructor
    @NoArgsConstructor

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String name;
        private double price;

        public Product() {}
        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

}
