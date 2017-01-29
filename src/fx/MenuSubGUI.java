package fx;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

/**
 * Created by james on 1/19/2017.
 */
public class MenuSubGUI {
    static VBox getSubMenu(String src){
     VBox base = new VBox();
     base.setPrefSize(400,600);
     base.setPadding(new Insets(20,0,0,0));
     base.setSpacing(20);

     switch(src){
         case "Play":

     }
     return base;
    }
}
