package fxmls.example;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

//Every fxml can only have one controller
public class Controller implements Initializable {
  //Left side of number for calculation
  public BigDecimal left;

  //Math operator for calculation
  public String selectedOperator;

  //Boolean to decide when has user stopped entering numbers
  public boolean inputtingNumber;

  //Initialize will setup initial calculator screen on start
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    System.out.println("Your app is starting");
    this.left = BigDecimal.ZERO;
    this.selectedOperator = "";
    this.inputtingNumber = false;
  }

  //Calculator display
  public Label DisplayLabel;

  //This function will be called on any button click, it is added in onAction property of every button
  public void onAnyButtonClick(ActionEvent e) {
    //This method helps in recognising which button was clicked (i.e. finding source of click)
    Button button = (Button) e.getSource();

    String buttonText = button.getText();

    //In layout design I have used 0 with spaces so to avoid problem removing all extra spaces
    buttonText = buttonText.replaceAll("\\s", "");

    if(buttonText.equals("C") || buttonText.equals("AC")) {
      if (buttonText.equals("AC"))
        left = BigDecimal.ZERO;
      DisplayLabel.setText("0");
      inputtingNumber = false;
      return;
    }


    //[0-9\.] this is a regular expression to recognize if a number was clicked
    //You can also do it buttonText.equals("1") || buttonText.equals("2")...
    if (buttonText.matches("[0-9\\.]")) {
      //Checking if user is still entering one number without pressing any operator
      if (!inputtingNumber) {
        inputtingNumber = true;
        DisplayLabel.setText("");
      }

      //Again removing extra space from text
      String temp = DisplayLabel.getText().replaceAll("\\s", "");

      //Adding numbers on screen using string concat function
      DisplayLabel.setText(temp.concat(buttonText));
      return;
    }

    //Handling operator click
    if(buttonText.equals("+") || buttonText.equals("-")
        || buttonText.equals("x") || buttonText.equals("÷")) {
      left = new BigDecimal(DisplayLabel.getText());
      selectedOperator = buttonText;
      inputtingNumber = false;
      DisplayLabel.setText("");
      return;
    }

    //Handling what will happen when user clicks on equal sign
    if(buttonText.equals("=")) {
      BigDecimal right = inputtingNumber ? new BigDecimal(DisplayLabel.getText()):left;

      //Creating a separate function for calculation so that in future more operator can be added
      left = calculate(selectedOperator, left, right);
      DisplayLabel.setText(left.toString());
    }
  }

  public BigDecimal calculate(String operator, BigDecimal left, BigDecimal right) {
    if(operator.equals("+")) {
      return left.add(right);
    }
    if (operator.equals("-")) {
      return left.subtract(right);
    }
    if (operator.equals("x")) {
      return left.multiply(right);
    }
    if (operator.equals("÷")) {
      return left.divide(right);
    }

    return right;
  }

}
