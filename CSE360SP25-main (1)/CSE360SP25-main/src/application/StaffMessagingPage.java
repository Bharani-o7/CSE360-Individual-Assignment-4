// StaffMessagingPage.java
package application;

import databasePart1.DatabaseHelper;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.List;

public class StaffMessagingPage {

    private DatabaseHelper dbHelper;
    private User currentUser;

    public StaffMessagingPage(DatabaseHelper dbHelper, User currentUser) {
        this.dbHelper = dbHelper;
        this.currentUser = currentUser;
    }

    public void show(Stage stage) {
        VBox layout = new VBox(10);
        layout.setStyle("-fx-padding: 20");

        List<Message> allMessages = dbHelper.getAllMessages();
        for (Message msg : allMessages) {
            layout.getChildren().add(new Label(msg.getSender() + " -> " + msg.getReceiver() + ": " + msg.getContent()));
        }

        Scene scene = new Scene(layout, 500, 500);
        stage.setScene(scene);
        stage.setTitle("All Private Messages");
        stage.show();
    }
}