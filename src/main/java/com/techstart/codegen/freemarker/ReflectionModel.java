package com.techstart.codegen.freemarker;

import org.apache.commons.lang.NotImplementedException;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReflectionModel {

    public static List<Field> getFields(Class clas){
        try {
            Field[] fields = clas.getDeclaredFields();
            return Arrays.asList(fields);
        }catch (Exception e){
            e.printStackTrace();
        }
        throw new NotImplementedException("");
    }

    public static List<String> getFieldNames(Class clas) {
        final List<Field> fields = getFields(clas);
        List<String> actualFields = fields.stream()
                .map(f->f.getName()).collect(Collectors.toList());
        return actualFields;
    }




    }
