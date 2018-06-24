package zadacha3;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.beans.Expression;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Client {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String expression = input.readLine();
        Structure str = new Structure(expression);
        if(str.isCor()){
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("js");
            Object result = engine.eval(expression);
            System.out.println(result);
        } else {
            System.out.print("Expression is not correct");
        }
    }
}
