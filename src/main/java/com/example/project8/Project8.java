package com.example.project8;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Project8 extends Application {
    @Override


    public void start(Stage primaryStage) {

        // Create a Label control.
        Label myLabel = new Label("Click the button to see a message.");

        Label dayslabel = new Label("Number of days on the trip");
        TextField days = new TextField();
        days.setMaxWidth(200);



        Label airfarelabel = new Label("Amount of airfare, if any");
        TextField airfare = new TextField();
        airfare.setMaxWidth(200);
        airfare.setText("0");

        CheckBox check = new CheckBox("Did you drive your own car");

        Label parkingfeeslabel = new Label("Amount of Parking fees, if any");
        TextField parkingfees = new TextField();
        parkingfees.setMaxWidth(200);
        parkingfees.setText("0");


        Label taxichargeslabel = new Label("Amount of taxi charges, if any");
        TextField taxicharges = new TextField();
        taxicharges.setMaxWidth(200);
        taxicharges.setText("0");

        Label registrationfeeslabel = new Label("Amount of registration fees, if any");
        TextField registrationfees = new TextField();
        registrationfees.setMaxWidth(200);
        registrationfees.setText("0");

        Label Lodgingchargeslabel = new Label("Amount of Lodging charges, if any");
        TextField Lodgingcharges = new TextField();
        Lodgingcharges.setMaxWidth(200);
        Lodgingcharges.setText("0");

        days.setPromptText("How Many Days Was the trip?");

        Label Milesdrivenlabel = new Label("How many miles did you drive?");
        TextField  Milesdriven = new TextField();
        Milesdriven.setMaxWidth(200);
        Milesdriven.setText("0");
        Milesdrivenlabel.setVisible(false);
        Milesdriven.setVisible(false);

        Label carrentallabel = new Label("How much was the car rentel?");
        TextField  carrental = new TextField();
        carrental.setText("0");
        carrental.setMaxWidth(200);
        Label count = new Label();
        count.setText("0");
        Label sumlabel = new Label();
        Label allowableexpenses = new Label();
        Label Difference = new Label();
        Button click = new Button();//
        click.setText("Calculate");

        Label error1 = new Label("Please input the number of days");

        GridPane gridpane = new GridPane();
        click.setOnAction(actionEvent -> {
            Double real;
            Boolean cheker;
            System.out.println();
            if(count.getText() == "0"){
                gridpane.add(error1, 1, 0);
                gridpane.add(Difference, 1, 4);
                gridpane.add(allowableexpenses, 1, 3);
                gridpane.add(sumlabel, 1, 2);
            }
            if(days.getText().equals("")){
                cheker = false;
                error1.setVisible(true);
                Difference.setVisible(false);
                allowableexpenses.setVisible(false);
                sumlabel.setVisible(false);
            }else {
                cheker = true;
                Difference.setVisible(true);
                allowableexpenses.setVisible(true);
                sumlabel.setVisible(true);
                error1.setVisible(false);
            }
            if(cheker.equals(true)){
                error1.setVisible(false);
                System.out.print("Test");
                // calculates the expenses on the trip
                if(carrental.isVisible()){
                    Double airfarecost = Double.parseDouble(airfare.getText());
                    Double Parkingcost = Double.parseDouble(parkingfees.getText());
                    Double Rentelcost = Double.parseDouble(carrental.getText());
                    Double  taxicost =  Double.parseDouble(taxicharges.getText());
                    Double registrationcost = Double.parseDouble(registrationfees.getText());
                    Double Lodgingcost = Double.parseDouble(Lodgingcharges.getText());
                    Double sum = airfarecost+Parkingcost+Rentelcost+taxicost+registrationcost+Lodgingcost;
                    sumlabel.setText("The total expenses: $"+String.format("%,.2f",sum));
                    real = sum;
                }
                else{
                    Double airfarecost = Double.parseDouble(airfare.getText());
                    Double Parkingcost = Double.parseDouble(parkingfees.getText());
                    Double Mileagecost = Double.parseDouble(Milesdriven.getText())*.42;
                    Double  taxicost =  Double.parseDouble(taxicharges.getText());
                    Double registrationcost = Double.parseDouble(registrationfees.getText());
                    Double Lodgingcost = Double.parseDouble(Lodgingcharges.getText());
                    Double sum = airfarecost+Parkingcost+Mileagecost+taxicost+registrationcost+Lodgingcost;
                    sumlabel.setText("The total expenses: $"+String.format("%,.2f",sum));
                    real = sum;
                }
                Double allowablemeals = 47.00;
                Double allowableparking = 20.00;
                Double allowabletaxi = 40.00;
                Double allowableLodging = 195.00;
                Double allowablecostpermile = .42;
                Double exp;
                int totaldays = Integer.parseInt(days.getText());
                if (carrental.isVisible()){
                    double allowableexpense = (allowablemeals*totaldays)+(allowableparking*totaldays)+(allowabletaxi*totaldays)+(allowableLodging*totaldays);
                    allowableexpenses.setText("The total allowable expenses: $"+String.format("%,.2f",allowableexpense));
                    exp = allowableexpense;
                }
                else {
                    double allowableexpense = (allowablemeals*totaldays)+(allowableparking*totaldays)+(allowabletaxi*totaldays)+(allowableLodging*totaldays)+(Double.parseDouble(Milesdriven.getText())*.42);
                    allowableexpenses.setText("The total allowable expenses: $"+String.format("%,.2f",allowableexpense));
                    exp = allowableexpense;
                }
                Double dif = real- exp;
                System.out.print(dif);
                if (dif < 0){
                    dif = dif*-1;
                    Difference.setText("The Business person saved: $"+ String.format("%,.2f",dif));
                }
                else{
                    Difference.setText("The Business person Spent: $"+String.format("%,.2f",dif)+ " More then what he was given");
                }

                if(count.getText() == "0"){

                }
                System.out.print(count);

            }
            count.setText("1");
        });

        Label checklabel = new Label();
        check.setOnAction(e -> {
                if (check.isSelected()== true){
                    Milesdrivenlabel.setVisible(true);
                    Milesdriven.setVisible(true);
                    carrental.setVisible(false);
                    carrentallabel.setVisible(false);

                }
                else{
                    carrental.setVisible(true);
                    carrentallabel.setVisible(true);
                    Milesdrivenlabel.setVisible(false);
                    Milesdriven.setVisible(false);
                }
                }
                );


        //,,,,,,,,,,,, ,sumlabel,allowableexpenses, Difference);

        // adds day and day label
        gridpane.add(dayslabel, 0, 0);
        gridpane.add(days, 0, 1);

        gridpane.add(airfarelabel, 0, 2);
        gridpane.add(airfare, 0, 3);

        gridpane.add(checklabel, 0, 4);
        gridpane.add(check, 0, 5);

        gridpane.add(carrentallabel, 0, 6);
        gridpane.add(carrental, 0, 7);

        gridpane.add(Milesdrivenlabel, 0, 6);
        gridpane.add(Milesdriven, 0, 7);

        gridpane.add(parkingfeeslabel, 0, 8);
        gridpane.add(parkingfees, 0, 9);

        gridpane.add(taxichargeslabel, 0, 10);
        gridpane.add(taxicharges, 0, 11);

        gridpane.add(registrationfeeslabel, 0, 12);
        gridpane.add(registrationfees, 0, 13);


        gridpane.add(Lodgingchargeslabel, 0, 14);
        gridpane.add(Lodgingcharges, 0, 15);

        gridpane.add(click, 0, 16);


        // Set the gap sizes.
        gridpane.setVgap(10);
        gridpane.setHgap(10);

        // Set the GridPane's padding.
        gridpane.setPadding(new Insets(30));
        // Create a Scene with the VBox as its root node.
        Scene scene = new Scene(gridpane);
        scene.setFill(Color.rgb(247, 179, 178));


        // Add the Scene to the Stage.
        primaryStage.setScene(scene);

        // Set the stage title.
        primaryStage.setTitle("Project 8");
        Image icon = new Image("file:/Users/Cole/IdeaProjects/Project-8/src/main/Images/1717912.png");
        primaryStage.getIcons().add(icon);

        // Show the window.

        primaryStage.show();


        System.out.print(check.isSelected());
    }

    public static void main(String[] args) {
        launch(args);
    }
}