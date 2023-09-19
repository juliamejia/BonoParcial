package org.example;
import static spark.Spark.*;
import com.google.gson.Gson;



public class SparkWebServer {



    public static void main(String... args) {
        port(getPort());
        get("/", (req,res) -> index());
        get("/sin/:number", (req, res) -> {
            double number = Double.parseDouble(req.params(":number"));
            double result = Math.sin(number);
            return new Gson().toJson(result);
        });



        get("/cos/:number", (req, res) -> {
            double number = Double.parseDouble(req.params(":number"));
            double result = Math.cos(number);
            return new Gson().toJson(result);
        });



        get("/isPalindrome/:text", (req, res) -> {
            String text = req.params(":text");
            boolean isPalindrome = checkPalindrome(text);
            return new Gson().toJson(isPalindrome);
        });


        get("/magnitude/:x/:y", (req, res) -> {
            double x = Double.parseDouble(req.params(":x"));
            double y = Double.parseDouble(req.params(":y"));
            double magnitude = Math.sqrt(x * x + y * y);
            return new Gson().toJson(magnitude);
        });
    }



    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

    private static boolean checkPalindrome(String text) {
        text = text.replaceAll("\\s+", "").toLowerCase();
        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static String getIndexResponse(){
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <title>Calculadora</title>\n" +
                "    <script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"></script>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h1>Calculadora</h1>\n" +
                "    \n" +
                "    <form id=\"sinForm\">\n" +
                "        <label for=\"number\">Número:</label>\n" +
                "        <input type=\"text\" id=\"number\" name=\"number\">\n" +
                "        <button type=\"submit\">Calcular Seno</button>\n" +
                "    </form>\n" +
                "\n" +
                "    <div id=\"result\"></div>\n" +
                "\n" +
                "    <script>\n" +
                "        $(document).ready(function() {\n" +
                "            $(\"#sinForm\").submit(function(event) {\n" +
                "                event.preventDefault();\n" +
                "                var number = $(\"#number\").val();\n" +
                "                $.get(\"/sin/\" + number, function(data) {\n" +
                "                    $(\"#result\").html(\"Seno: \" + data);\n" +
                "                });\n" +
                "            });\n" +
                "        });\n" +
                "    </script>\n" +
                "</body>\n" +
                "</html>\n"
    }

}