import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import static spark.Spark.*;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

public class PingPong {
  public static void main(String[] args){
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap model = new HashMap();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

    get("/result", (request, response) -> {
      HashMap model = new HashMap();
      model.put("template","templates/result.vtl");

      String userInput = request.queryParams("userInput");
      String[] userOutput = pingPongDisplay(userInput);

      model.put("userOutput", userOutput);

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }

  public static String[] pingPongDisplay(String input) {
    Integer integerInput = Integer.parseInt(input);
    String[] numbers = new String[integerInput];
    String output;
    for(Integer index = 1;index <= integerInput; index++){
      if((index % 3 == 0) && (index % 5 == 0)) {
        output = "ping-pong";
      } else if(index % 3 == 0) {
        output = "ping";
      } else if (index % 5 == 0) {
        output = "pong";
      } else {
        output = Integer.toString(index);
      }

      int i = index-1;
      numbers[i] = output;

    }
      return numbers;
  }

}
