package com;

import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JavaScriptExecutor {

	public static void main(String[] args) throws ScriptException {
		final ScriptEngineManager manager = new ScriptEngineManager();
		/*for (final ScriptEngineFactory scriptEngine : manager.getEngineFactories())
		{
		   System.out.println(
		         scriptEngine.getEngineName() + " ("
		       + scriptEngine.getEngineVersion() + ")" );
		   System.out.println(
		         "\tLanguage: " + scriptEngine.getLanguageName() + "("
		       + scriptEngine.getLanguageVersion() + ")" );
		   System.out.println("\tCommon Names/Aliases: ");
		   for (final String engineAlias : scriptEngine.getNames())
		   {
		      System.out.println(engineAlias + " ");
		   }
		}*/
		
		ScriptEngine engine = manager.getEngineByName("js");
		
		//engine.eval("var test = new java.lang.String(\"Sachin\"); print(test); var input = 10; var decimalPlaces = 2; var output = input.toExponential(decimalPlaces); ");
		
		Bindings binding = engine.getBindings(ScriptContext.ENGINE_SCOPE) ;
		binding.put("string", new java.lang.String("Sachin"));
		engine.eval("function test() {return \"Sachin\"}");
		engine.eval("print(test());");
		
		
		System.out.println(engine.get("string"));

	}

}
