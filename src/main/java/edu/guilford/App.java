package edu.guilford;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        // Set the window title
        stage.setTitle("Car Dealership");

        VBox root = new VBox();

        // Instatiate a default Individual object
        Car car = new Car();

        // Instantiate an Individual pane object and add it to the root node
        root.getChildren().add(new CarPane(car));
        scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}