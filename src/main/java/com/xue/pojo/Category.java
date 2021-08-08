package com.xue.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    private int id;

    private String name;

    private List<Product> products;

    private List<List<Product>> productsByRow;
}
