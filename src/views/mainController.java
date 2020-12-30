package views;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import bsh.EvalError;
import bsh.Interpreter;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.GridPane;

public class mainController {

	@FXML
	private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
	@FXML
	private Button btnDiv, btnSubtr, btnAdd, btnMult;
	@FXML
	private SplitPane calculator;
	@FXML
	private GridPane keys;
	@FXML
	private Label input,output;
	
	String expression="  ";
	Interpreter interpreter = new Interpreter();
	
	ScriptEngineManager scriptManager = new ScriptEngineManager();
	ScriptEngine scriptEngine = scriptManager.getEngineByName("Nashorn");


	Map<String, String> btnMap = new HashMap<>();
	
			
	private  void btnMapFactory() {

		ObservableList<Node> btns = keys.getChildren();

		for (Node nd : btns) {
			
			
			btnMap.put(nd.getId(), ((Button) nd).getText());
			
			

		}

	}
	
	private void expressionFactory(Button btn) {
				
		expression += btnMap.get(btn.getId());
		input.setText(expression);		
		
	}
	

	@FXML
	public void btnAction(ActionEvent ae) {
		btnMapFactory();		
		Button clicBtn =(Button) ae.getSource();
		expressionFactory(clicBtn);
		
	}
	
	@FXML
	public void btnResultAction(ActionEvent ae) throws ScriptException {
		//interpreter.eval("result="+ expression);
		//output.setText(interpreter.get("result").toString());
		Object result = scriptEngine.eval(expression);
		DecimalFormat df = new DecimalFormat("#.###########");
		String resultFormat = df.format(result);
		output.setText(resultFormat);
		expression=result.toString();
		
	}
	
	@FXML
	public void btnClean(ActionEvent ae) {
		expression="";
		input.setText("");
		output.setText("");
	}
	
	@FXML void btnreturn(ActionEvent ae) {
		
		int size = expression.length();
		expression = expression.substring(0, size-1);
		input.setText(expression);
	}

}
