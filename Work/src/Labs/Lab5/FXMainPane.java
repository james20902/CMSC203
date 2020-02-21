package Labs.Lab5;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	Button greeting1, greeting2, greeting3, clear, exit;
	ClickHandler handler;
	Label label;
	TextField textField;
	//  declare two HBoxes
	HBox row1, row2;
	
	//student Task #4:
	//  declare an instance of DataManager
	DataManager manager;
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		handler = new ClickHandler();

		//student Task #2:
		//  instantiate the buttons, label, and textfield
		 greeting1 = new Button ("Hello");
		 greeting1.setOnAction(handler);
		 greeting2 = new Button ("Howdy");
		 greeting2.setOnAction(handler);
		 greeting3 = new Button ("Chinese");
		 greeting3.setOnAction(handler);
		 clear = new Button ("Clear");
		 clear.setOnAction(handler);
		 exit = new Button ("Exit");
		 exit.setOnAction(handler);

		 label = new Label();
		 textField = new TextField();

		//  instantiate the HBoxes
		row1 = new HBox();

		row2 = new HBox();

		//student Task #4:
		//  instantiate the DataManager instance
		manager = new DataManager();
		//  set margins and set alignment of the components
		

		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		row2.getChildren().addAll(label, textField);
		//  add the buttons to the other HBox
		row1.getChildren().addAll(greeting1, greeting2, greeting3, clear, exit);
		//  add the HBoxes to this FXMainPanel (a VBox)
		getChildren().addAll(row1, row2);
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	class ClickHandler implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent actionEvent) {
			EventTarget objectPressed = actionEvent.getTarget();
			if (objectPressed.equals(greeting1)) {
				textField.setText(manager.getHello());
			}
			if (objectPressed.equals(greeting2)) {
				textField.setText(manager.getHowdy());
			}
			if (objectPressed.equals(greeting3)) {
				textField.setText(manager.getChinese());
			}
			if (objectPressed.equals(clear)) {
				textField.setText("");
			}
			if (objectPressed.equals(exit)) {
				System.exit(0);
			}
		}
	}
}
	
