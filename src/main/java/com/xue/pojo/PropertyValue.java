package com.xue.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyValue {
    private int id;
    private int pid;
    private int ptid;
    private String value;

    private Property property;
}
