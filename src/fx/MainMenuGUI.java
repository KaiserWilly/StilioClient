package fx;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.ArrayList;

/**
 * Created by JD Isenhart on 1/17/2017.
 * Testing RMI creation in Java 8
 */
public class MainMenuGUI {
    AnchorPane menuAnchorPane;
    VBox buttonBox, subMenu;
    Rectangle subRec;
    boolean subMenuUp = false;

    AnchorPane menuPane() {
        menuAnchorPane = new AnchorPane();

        subRec = new Rectangle(1920, 1080, Paint.valueOf("Black"));
        subRec.setOpacity(0.0);
        AnchorPane.setLeftAnchor(subRec, 0.0);
        AnchorPane.setTopAnchor(subRec, 0.0);
        menuAnchorPane.getChildren().add(subRec);

        buttonBox = new VBox();
        buttonBox.setAlignment(Pos.CENTER_LEFT);
        buttonBox.setPrefSize(600, 700);
        buttonBox.setPadding(new Insets(8));
        buttonBox.setSpacing(5);
        for (Button b : createMenuButtons()) {
            VBox.setMargin(b, new Insets(0, 0, 0, 4));
            buttonBox.getChildren().add(b);
        }
        AnchorPane.setBottomAnchor(buttonBox, 50.0);
        AnchorPane.setLeftAnchor(buttonBox, 25.0);
        menuAnchorPane.getChildren().add(buttonBox);

        ImageView logoImg = new ImageView(new Image(FrameGUI.class.getClassLoader().getResourceAsStream("rsc/menu/StilioClientLogo.png")));
        logoImg.setPreserveRatio(true);
        logoImg.setFitWidth(600);
        Label logo = new Label();
        logo.setGraphic(logoImg);
        AnchorPane.setBottomAnchor(logo, 20.0);
        AnchorPane.setRightAnchor(logo, 50.0);
        menuAnchorPane.getChildren().add(logo);

        ImageView topImg = new ImageView(new Image(FrameGUI.class.getClassLoader().getResourceAsStream("rsc/menu/menutop.png")));
        topImg.setPreserveRatio(true);
        topImg.setFitWidth(2000);
        Label top = new Label();
        top.setGraphic(topImg);
        AnchorPane.setTopAnchor(top, -425.0);
        AnchorPane.setLeftAnchor(top, -10.0);
        menuAnchorPane.getChildren().add(top);

        menuAnchorPane.managedProperty().bind(menuAnchorPane.visibleProperty());
        menuAnchorPane.setVisible(false);
        return menuAnchorPane;
    }

    private ArrayList<Button> createMenuButtons() {
        ArrayList<Button> butts = new ArrayList<>();
        String[][] menuButtData = new String[][]{
                {"Play", "rsc/menu/buttons/menuplaybutton.png", "rsc/menu/buttons/menuplaybuttonhover.png"},
                {"Settings", "rsc/menu/buttons/menusettingsbutton.png", "rsc/menu/buttons/menusettingsbuttonhover.png"},
                {"Help", "rsc/menu/buttons/menuhelpbutton.png", "rsc/menu/buttons/menuhelpbuttonhover.png"},
                {"Credits", "rsc/menu/buttons/menucreditsbutton.png", "rsc/menu/buttons/menucreditsbuttonhover.png"},
                {"Exit", "rsc/menu/buttons/menuexitbutton.png", "rsc/menu/buttons/menuexitbuttonhover.png"}
        };
        for (String[] aMenuButtData : menuButtData) {
            String basePath = aMenuButtData[1], hoverPath = aMenuButtData[2];
            ImageView buttBase = new ImageView(new Image(FrameGUI.class.getClassLoader().getResourceAsStream(basePath)));
            buttBase.setPreserveRatio(true);
            buttBase.setFitWidth(450);

            ImageView buttHover = new ImageView(new Image(FrameGUI.class.getClassLoader().getResourceAsStream(hoverPath)));
            buttHover.setPreserveRatio(true);
            buttHover.setFitWidth(450);

            Button butt = new Button();
            butt.setId(aMenuButtData[0]);
            butt.setOpacity(0.0);
//            butt.setEffect(ds);
            butt.setGraphic(buttBase);
            butt.setBackground(null);
            butt.setBorder(null);
            butt.setPrefSize(450, 50);
            butt.setOnAction(e -> handleButtonClick(butt.getId()));
            butt.setOnMouseEntered(e -> butt.setGraphic(buttHover));
            butt.setOnMouseExited(e -> butt.setGraphic(buttBase));

            butts.add(butt);
        }
        return butts;
    }

    private void handleButtonClick(String source) {
        if (source.equals("Exit"))
            Platform.exit();
        else if (subMenuUp) {
            transitionSubMenuBack();
            menuAnchorPane.getChildren().remove(subMenu);
        } else
            subMenuUp = true;

        subMenu = MenuSubGUI.getSubMenu(source);
        subMenu.setPrefSize(600, 700);
        AnchorPane.setBottomAnchor(subMenu, 50.0);
        AnchorPane.setLeftAnchor(subMenu, 750.0);
        menuAnchorPane.getChildren().add(subMenu);
        subMenu.toBack();

        System.out.println("Button Pushed: " + source);
        transitionSubMenuForward();

    }

    void transitionSubMenuForward() {
        ParallelTransition paraPane = new ParallelTransition(), paraMenu = new ParallelTransition();
        paraPane.setCycleCount(1);
        paraPane.setAutoReverse(false);
        paraMenu.setCycleCount(1);
        paraMenu.setAutoReverse(false);
        paraMenu.setDelay(Duration.millis(250));

        FadeTransition paneIn = new FadeTransition(Duration.millis(250), subRec);
        paneIn.setFromValue(0.0);
        paneIn.setToValue(0.2);
        paneIn.setCycleCount(1);
        paneIn.setAutoReverse(false);
        paraPane.getChildren().add(paneIn);

        for (Node n : subMenu.getChildren()) {
            FadeTransition buttIn = new FadeTransition(Duration.millis(250), n);
            buttIn.setFromValue(0.0);
            buttIn.setToValue(1.0);
            buttIn.setCycleCount(1);
            buttIn.setAutoReverse(false);
            paraMenu.getChildren().add(buttIn);
        }
        paraPane.getChildren().add(paraMenu);
        paraPane.play();
        setLayeringForward();
    }

    void setLayeringForward() {
        subRec.toFront();
        buttonBox.toFront();
        subMenu.toFront();
        subMenu.setManaged(true);
    }

    void transitionSubMenuBack() {
        ParallelTransition paraPane = new ParallelTransition(), paraMenu = new ParallelTransition();
        paraPane.setCycleCount(1);
        paraPane.setAutoReverse(false);
        paraMenu.setCycleCount(1);
        paraMenu.setAutoReverse(false);
        paraMenu.setDelay(Duration.millis(250));

        FadeTransition paneIn = new FadeTransition(Duration.millis(250), subRec);
        paneIn.setFromValue(0.2);
        paneIn.setToValue(0.0);
        paneIn.setCycleCount(1);
        paneIn.setAutoReverse(false);
        paraPane.getChildren().add(paneIn);

        for (Node n : subMenu.getChildren()) {
            FadeTransition buttIn = new FadeTransition(Duration.millis(250), n);
            buttIn.setFromValue(1.0);
            buttIn.setToValue(0.0);
            buttIn.setCycleCount(1);
            buttIn.setAutoReverse(false);
            paraMenu.getChildren().add(buttIn);
        }
        paraPane.getChildren().add(paraMenu);
        paraPane.play();
        setLayeringFrom();

    }

    void setLayeringFrom() {
        subMenu.toBack();
        subMenu.setManaged(false);
        subRec.toBack();
        buttonBox.toFront();
    }

    public void setOpacity(double opacity) {
        menuAnchorPane.setOpacity(opacity);
    }

    public void close(String newPane) {
        FadeTransition out = new FadeTransition(Duration.millis(250), menuAnchorPane);
        out.setFromValue(1.0);
        out.setToValue(0.0);
        out.setCycleCount(1);
        out.setAutoReverse(false);
        out.setOnFinished(e -> {
            menuAnchorPane.setVisible(false);
            switch (newPane) {
                case "Menu":
                    FrameGUI.menu.open();
                    break;
//                case "Server":
//                    FrameGUI.server.open();
//                    break;
//                case "Client":
//                    FrameGUI.client.open();
//                    break;
            }
        });
        out.play();
    }

    public void open() {
        menuAnchorPane.setVisible(true);
        FadeTransition in = new FadeTransition(Duration.millis(750), menuAnchorPane);
        in.setFromValue(0.0);
        in.setToValue(1.0);
        in.setCycleCount(1);
        in.setAutoReverse(false);
        in.play();
        buttonBoxTrans();
    }

    public void buttonBoxTrans() {
        SequentialTransition trans = new SequentialTransition();
        trans.setCycleCount(1);
        trans.setAutoReverse(false);
        trans.setDelay(Duration.millis(100));

        for (Node n : buttonBox.getChildren()) {
            FadeTransition in = new FadeTransition(Duration.millis(250), n);
            in.setFromValue(0.0);
            in.setToValue(1.0);
            in.setCycleCount(1);
            in.setAutoReverse(false);
            trans.getChildren().add(in);
        }
        trans.play();
    }
}
