package bank.account.application;

import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 *
 * @author Syed Yousuf
 */
public class BankAccountApplication extends Application 
{
    
    // Instance Variable
    private Customer customer;
    private Manager managerAdmin;
    private TextField enterValue;
    private Button send;
    private Label currentValue; // For displaying any current value.
    private Label bottomValue;
    
    @Override
    public void start(Stage primaryStage) 
    {
        // Local Variables
        
        
        
        // Create the two button for selecting manager or customer
        Button CustomerButton = new Button();
        CustomerButton.setText("Customer");
        Button ManagerButton = new Button();
        ManagerButton.setText("Manager");
        
        
        
        CustomerButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
                // Remove the buttons
                CustomerButton.setDisable(true);
                CustomerButton.setVisible(false);
                ManagerButton.setDisable(true);
                ManagerButton.setVisible(false);
                
                // Make the username and password option
                TextField username = new TextField();
                username.setText("Username");
                PasswordField password = new PasswordField();
                password.setText("Password");
                Label errorMessage = new Label("");
                
                Button enter = new Button("LOGIN");
                enter.setOnAction(action -> 
                {
                    
                    // Create a new customer.
                    try
                    {
                        customer = new Customer(username.getText(), password.getText());
                        
                        // Log in if possible
                        customer.login(username.getText(), password.getText());
                    }
                    catch(FileNotFoundException e)
                    {
                        errorMessage.setText("  An Account with that username or password does not exist! ");
                    }
                    
                    // Check if the customer has logged in successfully and if so lead them to the approprite screen.
                    if(customer.getSuccessfulLogin())
                    {
                        // First disable all the old items.
                        username.setDisable(true);
                        password.setDisable(true);
                        errorMessage.setDisable(true);
                        username.setVisible(false);
                        password.setVisible(false);
                        errorMessage.setVisible(false);
                        enter.setDisable(true);
                        enter.setVisible(false);
                        
                        
                        // Create new buttons for the customer actions
                        Button depositMoney = new Button("Deposit money");
                        Button withdrawMoney = new Button("Withdraw money");
                        Button getbalance = new Button("Get Account Balance");
                        Button purchase = new Button("Online Purchase");
                        Button logout = new Button("Logout");
                        
                        enterValue = new TextField();
                        send = new Button("ENTER");
                        currentValue = new Label("");
                        bottomValue = new Label("LEVEL: " + customer.getLevel().getStatus());
                        
                        // Disable the textfields and enter button for now.
                        enterValue.setDisable(true);
                        send.setDisable(true);
                        enterValue.setVisible(false);
                        send.setVisible(false);
                        currentValue.setDisable(true);
                        currentValue.setVisible(false);
                        
                        // Create a new border
                        BorderPane border  = new BorderPane();
                        HBox hbox = new HBox(depositMoney, withdrawMoney, getbalance, purchase, logout);
                        HBox bottom = new HBox(enterValue, send, currentValue);
                        HBox floor = new HBox(bottomValue);
                        
                        border.setTop(hbox);
                        border.setLeft(bottom);
                        border.setBottom(floor);
                        Scene scene = new Scene(border, 800, 600);
                        primaryStage.setScene(scene);
                        primaryStage.show();
                        
                        // Set action for each option.
                        depositMoney.setOnAction(actionDepositMoney -> 
                        {
                            // First make the text values visible and enabled
                            enterValue.setDisable(false);
                            send.setDisable(false);
                            enterValue.setVisible(true);
                            send.setVisible(true);
                            
                            // Disable the text field
                            currentValue.setDisable(true);
                            currentValue.setVisible(false);
                            
                            // Set a new text value for the texfield
                            enterValue.setText("Enter Money to deposit...");
                            
                            // Check if the enter button has been pressed.
                            send.setOnAction(button  ->
                            {
                                // Make sure that the money being deposited is positive
                                if(Double.parseDouble(enterValue.getText()) >= 0)
                                {
                                    customer.addMoney(Double.parseDouble(enterValue.getText()));
                                }
                                else
                                {
                                    // do nothing if its negative.
                                }
                                // Update level.
                                bottomValue.setText("LEVEL: " + customer.getLevel().getStatus());
                            });
                            
                            
                        });
                        
                        withdrawMoney.setOnAction(actionWithdrawMoney -> 
                        {
                            // First make the text values visible and enabled
                            enterValue.setDisable(false);
                            send.setDisable(false);
                            enterValue.setVisible(true);
                            send.setVisible(true);
                            
                            // Disable the text field
                            currentValue.setDisable(true);
                            currentValue.setVisible(false);
                            
                            // Set a new text value for the texfield
                            enterValue.setText("Enter Money to withdraw...");
                            
                            // Check if the enter button has been pressed.
                            send.setOnAction(button  ->
                            {
                                // Make sure the money to withdraw is positive.
                                if(Double.parseDouble(enterValue.getText()) >= 0)
                                {
                                    customer.withdrawMoney(Double.parseDouble(enterValue.getText()));
                                }
                                else
                                {
                                    // do nothing if its negative
                                }
                                // Update level.
                                bottomValue.setText("LEVEL: " + customer.getLevel().getStatus());
                            });
                            
                        });
                        
                        purchase.setOnAction(actionPurchaseMoney -> 
                        {
                            // First make the text values visible and enabled
                            enterValue.setDisable(false);
                            send.setDisable(false);
                            enterValue.setVisible(true);
                            send.setVisible(true);
                            
                            // Disable the text field
                            currentValue.setDisable(true);
                            currentValue.setVisible(false);
                            
                            // Set a new text value for the texfield
                            enterValue.setText("Enter online purchase money...");
                            
                            // Check if the enter button has been pressed.
                            send.setOnAction(button  ->
                            {
                                // Make sure that the money is positve
                                if(Double.parseDouble(enterValue.getText()) >= 0)
                                {
                                    customer.useMoney(Double.parseDouble(enterValue.getText()));
                                }
                                else
                                {
                                    //If the money that the customer is adding is not positive
                                    // then do nothing
                                }
                                // Update level.
                                bottomValue.setText("LEVEL: " + customer.getLevel().getStatus());
                            });
                            
                        });
                        
                        getbalance.setOnAction(actiongetBalance -> 
                        {
                            // Disable all other fields
                            enterValue.setDisable(true);
                            send.setDisable(true);
                            enterValue.setVisible(false);
                            send.setVisible(false);
                            
                            currentValue.setDisable(false);
                            currentValue.setVisible(true);
                            
                            // Set the label to Account Balance.
                            currentValue.setText("Current Account Balance: $" + customer.getCustomerFile().getAccountBalance());
                            
                            // Update level.
                            bottomValue.setText("LEVEL: " + customer.getLevel().getStatus());
                            
                        });
                        
                        logout.setOnAction(actiongetBalance -> 
                        {
                            // Disable all other fields
                            enterValue.setDisable(true);
                            send.setDisable(true);
                            enterValue.setVisible(false);
                            send.setVisible(false);
                            currentValue.setDisable(true);
                            currentValue.setVisible(false);
                            depositMoney.setDisable(true);
                            depositMoney.setVisible(false);
                            withdrawMoney.setDisable(true);
                            withdrawMoney.setVisible(false);
                            purchase.setDisable(true);
                            purchase.setVisible(false);
                            getbalance.setDisable(true);
                            getbalance.setVisible(false);
                            logout.setDisable(true);
                            logout.setVisible(false);
                            bottomValue.setDisable(true);
                            bottomValue.setVisible(false);
                            
                            
                            
                        });
                    }
                    else
                    {
                        errorMessage.setText("Password or username is incorrect!");
                    }
                    
                });
                
                
                HBox hbox = new HBox(username,password, enter, errorMessage);
                Scene scene = new Scene(hbox, 800, 600);
                primaryStage.setScene(scene);
                primaryStage.show();
            }
        });
        
        
        ManagerButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
                // Remove the buttons
                CustomerButton.setDisable(true);
                CustomerButton.setVisible(false);
                ManagerButton.setDisable(true);
                ManagerButton.setVisible(false);
                
                // Make the username and password option
                TextField username = new TextField();
                username.setText("Username");
                PasswordField password = new PasswordField();
                password.setText("Password");
                Label errorMessage = new Label("");
                
                Button enter = new Button("LOGIN");
                
                enter.setOnAction(action -> 
                {
                    
                    // Create a new customer.
                    managerAdmin = new Manager();
                        
                    // Log in if possible
                    managerAdmin.login(username.getText(), password.getText());
                    
                    if(managerAdmin.getLoginSucess())
                    {
                        // The login  was sucessful so go on with the manager options.
                        
                        // First disable all the old items.
                        username.setDisable(true);
                        password.setDisable(true);
                        errorMessage.setDisable(true);
                        username.setVisible(false);
                        password.setVisible(false);
                        errorMessage.setVisible(false);
                        enter.setDisable(true);
                        enter.setVisible(false);
                        
                        
                        // Create new buttons for the customer actions
                        Button addCustomer = new Button("ADD CUSTOMER");
                        Button deleteCustomer = new Button("DELETE CUSTOMER");
                        Button logout = new Button("LOGOUT");
                        
                        enterValue = new TextField();
                        TextField enterValue2 = new TextField();
                        send = new Button("ENTER");
                        currentValue = new Label("");
                        
                        // Disable the textfields and enter button for now.
                        enterValue.setDisable(true);
                        send.setDisable(true);
                        enterValue.setVisible(false);
                        send.setVisible(false);
                        currentValue.setDisable(true);
                        currentValue.setVisible(false);
                        enterValue2.setDisable(true);
                        enterValue2.setVisible(false);
                        
                        // Create a new border
                        BorderPane border  = new BorderPane();
                        HBox hbox = new HBox(addCustomer, deleteCustomer, logout);
                        HBox bottom = new HBox(enterValue, enterValue2,send, currentValue);
                        
                        border.setTop(hbox);
                        border.setLeft(bottom);
                        Scene scene = new Scene(border, 800, 600);
                        primaryStage.setScene(scene);
                        primaryStage.show();
                        
                        // Set an action for each option.
                        addCustomer.setOnAction(actionWithdrawMoney -> 
                        {
                            // First make the text values visible and enabled
                            enterValue.setDisable(false);
                            send.setDisable(false);
                            enterValue.setVisible(true);
                            send.setVisible(true);
                            enterValue2.setDisable(false);
                            enterValue2.setVisible(true);
                            
                            // Disable the text field
                            currentValue.setDisable(true);
                            currentValue.setVisible(false);
                            
                            // Change send back
                            send.setText("ENTER");
                            
                            // Set a new text value for the texfields
                            enterValue.setText("NEW USERNAME");
                            enterValue2.setText("NEW PASSWORD");
                            
                            // Check if the enter button has been pressed.
                            send.setOnAction(button  ->
                            {
                                // Add the customer as requested by the manager
                                managerAdmin.addCustomer(enterValue.getText(), enterValue2.getText());
                                
                                // State that it has occured successfully.
                                currentValue.setDisable(false);
                                currentValue.setVisible(true);
                                
                                currentValue.setText("CUSTOMER ADDED SUCCESSFULLY");
                                
                            });
                            
                        });
                        
                        deleteCustomer.setOnAction(actionWithdrawMoney -> 
                        {
                            // First make the text values visible and enabled
                            enterValue.setDisable(false);
                            send.setDisable(false);
                            enterValue.setVisible(true);
                            send.setVisible(true);
                            enterValue2.setDisable(false);
                            enterValue2.setVisible(true);
                            
                            // Disable the text field
                            currentValue.setDisable(true);
                            currentValue.setVisible(false);
                            
                            // Set a new text value for the texfields
                            enterValue.setText("USERNAME");
                            enterValue2.setText("PASSWORD");
                            
                            send.setText("DELETE");
                            // Check if the enter button has been pressed.
                            send.setOnAction(button  ->
                            {
                                // Add the customer as requested by the manager
                                managerAdmin.deleteCustomer(enterValue.getText(), enterValue2.getText());
                                
                                // State that it has occured successfully.
                                currentValue.setDisable(false);
                                currentValue.setVisible(true);
                                
                                currentValue.setText("CUSTOMER DELETED SUCCESSFULLY");
                                
                            });
                            
                            
                        });
                        
                        logout.setOnAction(actionLogout ->
                        {
                            enterValue.setDisable(true);
                            send.setDisable(true);
                            enterValue.setVisible(false);
                            send.setVisible(false);
                            currentValue.setDisable(true);
                            currentValue.setVisible(false);
                            enterValue2.setDisable(true);
                            enterValue2.setVisible(false);
                            addCustomer.setDisable(true);
                            addCustomer.setVisible(false);
                            deleteCustomer.setDisable(true);
                            deleteCustomer.setVisible(false);
                            logout.setDisable(true);
                            logout.setVisible(false);
                        });
                    }
                    else
                    {
                        errorMessage.setText("LOGIN FAILED! PLEASE CHECK YOUR USERNAME/PASSWORD AGAIN!");
                    }
  
                 
                });    
             
                HBox hbox = new HBox(username,password, enter, errorMessage);
                Scene scene = new Scene(hbox, 800, 600);
                primaryStage.setScene(scene);
                primaryStage.show();
                
            }
        });
        
        Pane root = new Pane();
        
        // Set the button location.
        CustomerButton.setLayoutX(100);
        CustomerButton.setLayoutY(100);
        ManagerButton.setLayoutX(200);
        ManagerButton.setLayoutY(100);
        
        root.getChildren().addAll(CustomerButton, ManagerButton);
        
        Scene scene = new Scene(root, 800, 600);
        
        primaryStage.setTitle("Bank Account Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
