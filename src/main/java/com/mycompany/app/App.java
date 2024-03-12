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

public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {
            //str1
            String input1 = req.queryParams("input1");
            //java.util.Scanner sc1 = new java.util.Scanner(input1);


            //str2
            String input2 = req.queryParams("input2");
            //java.util.Scanner sc1 = new java.util.Scanner(input2);



            //list1
            String input3 = req.queryParams("input3");
            java.util.Scanner sc1 = new java.util.Scanner(input3);
            sc1.useDelimiter("[;\r\n]+");
            java.util.ArrayList<Integer> inputList1 = new java.util.ArrayList<>();
            while (sc1.hasNext())
            {
                int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
                inputList1.add(value);
            }

            //list2
            String input4 = req.queryParams("input4");
            java.util.Scanner sc2 = new java.util.Scanner(input4);
            sc1.useDelimiter("[;\r\n]+");
            java.util.ArrayList<Integer> inputList2 = new java.util.ArrayList<>();
            while (sc2.hasNext())
            {
                int value = Integer.parseInt(sc2.next().replaceAll("\\s",""));
                inputList2.add(value);
            }

        int result = sum(input1, input2, inputList1, inputList2);

        Map map = new HashMap();
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



    public static int sum(String str1, String str2, ArrayList<Integer> array1, ArrayList<Integer> array2) {
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
