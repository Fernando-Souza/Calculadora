package application;
	
import bsh.EvalError;
import bsh.Interpreter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage stage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/views/principalView.fxml"));
			Scene scene = new Scene(root);
			stage.setTitle("Calculadora");
	        stage.setScene(scene);
	        stage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);		
		
	}
}
