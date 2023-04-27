package edu.guilford;

import java.io.File;

import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;

public class CarPane extends GridPane {

    // Attributes

    // Car object
    private Car car;

    // TextFields
    private TextField makeField;
    private TextField modelField;
    private TextField yearField;
    private TextField priceField;
    private TextField mileageField;

    // Buttons
    private Button buyButton; // Confirms "purhcase"
    private Button nextButton; // Generates a new car
    private Button customizeButton; // Takes input from user to customize car

    // HBox for the buttons
    private HBox buttonBox;

    // Labels
    private Label makeLabel;
    private Label modelLabel;
    private Label yearLabel;
    private Label priceLabel;
    private Label mileageLabel;
    private Label analysisLabel;
    private Label resultsLabel;

    // ColorPicker
    private ColorPicker colorPicker;

    // ImageView
    private ImageView carPicture;

    private Rectangle carBackground;

    // Constructor

    public CarPane(Car car) {
        // Set the car attribute
        this.car = car;

        // Instantiate the attributes
        makeField = new TextField();
        modelField = new TextField();
        yearField = new TextField();
        priceField = new TextField();
        mileageField = new TextField();

        buyButton = new Button("Buy");
        nextButton = new Button("Next");
        customizeButton = new Button("Check Rating");

        buttonBox = new HBox();

        makeLabel = new Label("Make:");
        modelLabel = new Label("Model:");
        yearLabel = new Label("Year:");
        priceLabel = new Label("Price:");
        mileageLabel = new Label("Mileage:");
        analysisLabel = new Label("Car score out of 30:");
        resultsLabel = new Label();

        colorPicker = new ColorPicker();
        colorPicker.setValue(javafx.scene.paint.Color.BLACK);

        File outline = new File(this.getClass().getResource("tpcar.png").getPath());
        carPicture = new ImageView(outline.toURI().toString());

        // Add the attributes to the pane

        // Add the labels
        add(makeLabel, 0, 0);
        add(modelLabel, 0, 1);
        add(yearLabel, 0, 2);
        add(priceLabel, 0, 3);
        add(mileageLabel, 0, 4);
        add(analysisLabel, 4, 0);
        add(resultsLabel, 4, 1);

        // Add the text fields
        add(makeField, 1, 0);
        add(modelField, 1, 1);
        add(yearField, 1, 2);
        add(priceField, 1, 3);
        add(mileageField, 1, 4);

        // Add the HBox for the buttons
        buttonBox.getChildren().addAll(buyButton, nextButton, customizeButton);
        add(buttonBox, 1, 5);

        // Add the rectangle behind the image
        carBackground = new Rectangle(0, 0, 187.5, 125);
        add(carBackground, 3, 0, 1, 5);

        // Add the image
        add(carPicture, 3, 0, 1, 5);

        // Add the color picker below the image
        add(colorPicker, 3, 5);

        // Adjust the image to make it fit to the screen while maintaining aspect ratio
        carPicture.setFitHeight(125);
        carPicture.setPreserveRatio(true);

        // When the new car pane is instantiated, the text fields should be populated
        // with the car's attributes and the results label should be populated with the
        // car's score
        makeField.setText(car.getMake());
        modelField.setText(car.getModel());
        yearField.setText(Integer.toString(car.getYear()));
        priceField.setText(Integer.toString(car.getPrice()));
        mileageField.setText(Integer.toString(car.getMileage()));
        resultsLabel.setText(Double.toString(car.analyze()));

        // When the next button is clicked, a new car object should be instantiated and
        // the text fields should be populated with the new car's attributes and the
        // results label should be populated with the new car's score
        nextButton.setOnAction(e -> {
            Car newCar = new Car();
            makeField.setText(newCar.getMake());
            modelField.setText(newCar.getModel());
            yearField.setText(Integer.toString(newCar.getYear()));
            priceField.setText(Integer.toString(newCar.getPrice()));
            mileageField.setText(Integer.toString(newCar.getMileage()));
            resultsLabel.setText(Double.toString(newCar.analyze()));
        });

        // When the buy button is clicked, a label should appear that says "Thank you
        // for your purchase!"
        buyButton.setOnAction(e -> {
            Label thankYouLabel = new Label("Thank you for your purchase!");
            add(thankYouLabel, 3, 6);
        });

        // When the customize button is clicked, the car's attributes should be updated
        // with the user's input, and the analysis label should be updated with the
        // car's score
        customizeButton.setOnAction(e -> {
            car.setMake(makeField.getText());
            car.setModel(modelField.getText());
            car.setYear(Integer.parseInt(yearField.getText()));
            car.setPrice(Integer.parseInt(priceField.getText()));
            car.setMileage(Integer.parseInt(mileageField.getText()));
            resultsLabel.setText(Integer.toString(car.analyze()));
        });

        // When the color picker is clicked, the rectangle behind the car
        // should change to the color that the user selected
        colorPicker.setOnAction(e -> {
            carBackground.setFill(colorPicker.getValue());
        });

    }

}
