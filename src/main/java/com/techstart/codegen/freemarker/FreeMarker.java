package com.techstart.codegen.freemarker;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class FreeMarker {
    private static final String TEMPLATE_DIRECTORY = System.getProperty("user.dir") + File.separator + "freemarker/";
    private static final String OUT_DIRECTORY = System.getProperty("user.dir") + File.separator + "freemarker/";

    private Template template = null;
    Map<String, Object> dataMap = new HashMap<String, Object>();


    public FreeMarker() {

        Configuration cfg = new Configuration(Configuration.VERSION_2_3_30);

        cfg.setTemplateLoader(new StringTemplateLoader());
        try {

            cfg.setDirectoryForTemplateLoading(new File(TEMPLATE_DIRECTORY));
            template = cfg.getTemplate("CodeTemp.ftl");
        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void buildData() {
        dataMap.put("package", this.getClass().getPackage() + ";");
        dataMap.put("name", "HelloWorldservice");
        dataMap.put("return", "String");
        dataMap.put("methodname", "hello");
        dataMap.put("params", "String name");
        dataMap.put("body", "String res= \"Hi\" + name;\n System.out.println(res);");
        dataMap.put("val", "res;");
        System.out.println("Preparing Data");

    }

        public void writeFile() {
        buildData();
        Writer file = null;
        try {
            file = new FileWriter(new File(OUT_DIRECTORY + "HelloWorldservice.java"));
            template.process(dataMap, file);
            file.flush();
            System.out.println("Success");

        } catch (Exception e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        } finally {

            try {
                file.close();
            } catch (IOException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }


    public static void main(String[] args) {
        FreeMarker fm = new FreeMarker();
        fm.writeFile();

    }

}