package com.mycompany.app;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;



/**
 * Hello world!
 *
 */
public class App 
{
    //public static void main( String[] args )
    //{
        //Integer[] array1 = {1, 2, 3};
        //Integer[] array2 = {4, 5, 6};
        //String str1 = "Hello";
        //String str2 = "World";
//
        //int result = sum(str1, str2, array1, array2);
        //System.out.println("Result: " + result);
    //}


public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {
        String str1 = req.queryParams("str1");
        String str2 = req.queryParams("str2");

        String[] array1String = req.queryParamsValues("array1");
        Integer[] array1 = null;
        if (array1String != null) {
        array1 = new Integer[array1String.length];
        for (int i = 0; i < array1String.length; i++) {
        array1[i] = Integer.parseInt(array1String[i]);
        }
        }

        String[] array2String = req.queryParamsValues("array2");
        Integer[] array2 = null;
        if (array2String != null) {
        array2 = new Integer[array2String.length];
        for (int i = 0; i < array2String.length; i++) {
        array2[i] = Integer.parseInt(array2String[i]);
        }
        }

        int result = sum(str1, str2, array1, array2);

        Map<String, Object> map = new HashMap<>();
        map.put("result", result);
        return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());

        get("/compute", (rq, rs) -> {
        Map<String, Object> map = new HashMap<>();
        map.put("result", "not computed yet!");
        return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());
        }

static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
        return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; // return default port if heroku-port isn't set (i.e. on localhost)
        }



    public static int sum(String str1, String str2, Integer[] array1, Integer[] array2) {
        int sumOfLengths = str1.length() + str2.length();

        int sumArray1 = 0;
        if (array1 != null) {
            for (int num : array1) {
                sumArray1 += num;
            }
        }

        int sumArray2 = 0;
        if (array2 != null) {
            for (int num : array2) {
                sumArray2 += num;
            }
        }

        int result = sumOfLengths + sumArray1 + sumArray2;

        return result;
    }
}
