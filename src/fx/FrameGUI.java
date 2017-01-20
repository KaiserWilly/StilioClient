package fx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import rsc.Values;

/**
 * Created by JD Isenhart on 1/17/2017.
 * Testing RMI creation in Java 8
 */
public class FrameGUI extends Application {

    static StackPane stack;
    static Scene scene;
    static Node menuP;
    static String curScene = "Menu";

    public static MainMenuGUI menu = new MainMenuGUI();

    public static void run(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Stilio v" + Values.VERSION);
        primaryStage.setFullScreen(true);
        primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        primaryStage.getIcons().add(new Image(FrameGUI.class.getClassLoader().getResourceAsStream("rsc/frame/StilioIcon.png")));
        primaryStage.setScene(createScene());

        setScene("Menu");
        primaryStage.show();

    }

    private static Scene createScene() {
        stack = new StackPane();
        stack.setPadding(new Insets(0, 0, 30, 0));
        menuP = menu.menuPane();
        stack.getChildren().add(menuP);

        menu.setOpacity(0.0);
        scene = new Scene(stack, 1920, 1080);
        scene.getStylesheets().add("rsc/StylesheetRoot.css");
        return scene;
    }

    public static void setScene(String scene) {
        switch (curScene) {
            case "Menu":
                menu.close(scene);
                break;
        }
        curScene = scene;
    }
}
