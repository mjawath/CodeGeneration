package com.techstart.codegen.freemarker;


import com.example.Address;

public class JSONSchemaToPojo {

    public static void main(String[] args) {
        System.out.println("print ");
        Address schema = new Address();
        System.out.println(ReflectionModel.getFieldNames(schema.getClass()));

    }

}
