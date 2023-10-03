package ie.atu.hw1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CalculatorController
{
   //http://localhost:8080/calculate?num1=6&num2=2&operation=add
   //http://localhost:8080/calculate?num1=10&num2=5&operation=subtract
   //http://localhost:8080/calculate?num1=4&num2=3&operation=multiply
   //http://localhost:8080/calculate?num1=8&num2=2&operation=divide
    @GetMapping("/calculate")
    public Map<String, String> calculate(@RequestParam int num1,@RequestParam int num2,@RequestParam String operation)
    {
        int answer;
        HashMap<String, String> response = new HashMap<>();

        switch(operation)
        {
            case "add": answer = num1+num2;
                        break;
            case "subtract": answer = num1-num2;
                             break;
            case "multiply": answer = num1*num2;
                             break;
            case "divide": answer = num1/num2;
                           break;
            default: answer = num1 + num2;
        }

        response.put("Operation", operation);
        response.put("total", String.valueOf(answer));

        return response;
    }

    //http://localhost:8080/calculatepv/6/2/add
    //http://localhost:8080/calculatepv/10/5/subtract
    //http://localhost:8080/calculatepv/4/3/multiply
    //http://localhost:8080/calculatepv/8/2/divide
    @GetMapping("/calculatepv/{num1}/{num2}/{operation}")
    public Map<String, String> calculatePV(@PathVariable int num1,@PathVariable int num2,@PathVariable String operation)
    {
        int answer;
        HashMap<String, String> response = new HashMap<>();

        switch(operation)
        {
            case "add": answer = num1+num2;
                break;
            case "subtract": answer = num1-num2;
                break;
            case "multiply": answer = num1*num2;
                break;
            case "divide": answer = num1/num2;
                break;
            default: answer = num1 + num2;
        }

        response.put("Operation", operation);
        response.put("total", String.valueOf(answer));

        return response;
    }

}
