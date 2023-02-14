package com.example.test;

import com.example.Data.Query;
import com.example.Drug.Casher.Reciept;
import java.math.*;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import static java.lang.Math.sqrt;

public class test {

   public static void main(String[] args) throws ScriptException {

       ScriptEngineManager mgr = new ScriptEngineManager();
       ScriptEngine engine = mgr.getEngineByName("JavaScript");
       String foo = "sqrt(40)";
      // System.out.println(engine.eval(foo));
System.out.println(sqrt(16));
    /* Query q = new Query();
     Reciept r = new Reciept();
     r.preview_reciept();*/
    //System.out.println(q.query("select * from users where username='admin'"));
  } 
}
