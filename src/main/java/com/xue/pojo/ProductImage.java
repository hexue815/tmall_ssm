package com.xue.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductImage {
    private int id;
    private int pid;
    private String type;

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}
