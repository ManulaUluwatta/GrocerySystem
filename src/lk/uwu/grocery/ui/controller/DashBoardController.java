package lk.uwu.grocery.ui.controller;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Manula Uluwatta on 1/14/2020.
 */
public class DashBoardController implements Initializable {
    @FXML
    private AnchorPane dash;
    public static AnchorPane sDash;

    @FXML
    private JFXDrawer drawer;

    public static JFXDrawer sDrawer;

    @FXML
    private JFXHamburger hamburger;

    private static JFXHamburger sHam;

    @FXML
    private AnchorPane anchorView;

    @FXML
    private AnchorPane fade;

    public static AnchorPane sFade;

    @FXML
    public static AnchorPane rootPane;

    public  static HamburgerSlideCloseTransition hamTransition;

    public static Parent sidePane;

    Node s;
    public static boolean isStart=false;

    private UserLoginController userLoginController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sFade=fade;
        rootPane=anchorView;
        sDrawer=drawer;
        sHam=hamburger;
        sDash=dash;
       fade.setVisible(false);

       String userName=userLoginController.usernName;

        try {
            if(userName.equals("manager")) {
                AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/lk/uwu/grocery/ui/fxml/SidePane.fxml"));
                drawer.setSidePane(anchorPane);
            }
            if(userName.equals("cashier")){
                AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/lk/uwu/grocery/ui/fxml/SidePaneCashier.fxml"));
                drawer.setSidePane(anchorPane);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        isStart=true;

       rootPane = anchorView;


        hamTransition = new HamburgerSlideCloseTransition(hamburger);
        hamTransition.setRate(-1);
        hamburger.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
            hamTransition.setRate(hamTransition.getRate() * -1);
            hamTransition.play();


            if (drawer.isOpened()) {
                drawer.close();

                   drawer.toBack();

                FadeTransition fadeOut=new FadeTransition(Duration.millis(800),fade);
                fadeOut.setFromValue(0.4);
                fadeOut.setToValue(0);
                fadeOut.setCycleCount(1);
                fadeOut.play();
                fadeOut.setOnFinished(l -> {
                    fade.setVisible(false);
                });
            } else {
                ////////////////
                drawer.setVisible(true);

               drawer.toFront();
                //////////////////

                try {
                    if(userName.equals("manager")) {
                        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/lk/uwu/grocery/ui/fxml/SidePane.fxml"));
                        drawer.setSidePane(anchorPane);
                        drawer.open();
                    }
                    if(userName.equals("cashier")){
                        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/lk/uwu/grocery/ui/fxml/SidePaneCashier.fxml"));
                        drawer.setSidePane(anchorPane);
                        drawer.open();
                    }
                fade.setVisible(true);
                //sFadeAction(e);
                FadeTransition fadeIn=new FadeTransition(Duration.millis(800),fade);
                fadeIn.setFromValue(0);
                fadeIn.setToValue(0.4);
                fadeIn.setCycleCount(1);
                fadeIn.play();
                fadeIn.setOnFinished(l -> {
                    fade.setVisible(true);
                });
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
//
        try {
            dash = FXMLLoader.load(getClass().getResource("/lk/uwu/grocery/ui/fxml/PlaceOrdeForm.fxml"));
            PauseTransition delayPlay= new PauseTransition(Duration.seconds(0.1));
            delayPlay.setOnFinished((ActionEvent event) -> {
                DashBoardController.rootPane.getChildren().setAll(dash);
            });
            delayPlay.play();
            //sDrawer.close();
            //sDrawer.setVisible(false);

        } catch (IOException ex) {
            Logger.getLogger(SidePaneController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void humburgAction(ActionEvent actionEvent){

        hamTransition.setRate(hamTransition.getRate()*-1);
        hamTransition.play();
         if (sDrawer.isOpening()) {
            sDrawer.close();
            sDrawer.toBack();



            //////////
            sDrawer.setVisible(false);
            ///////////

            FadeTransition fadeOut=new FadeTransition(Duration.millis(800),sFade);
            fadeOut.setFromValue(0.4);
            fadeOut.setToValue(0);
            fadeOut.setCycleCount(1);
            fadeOut.play();
            fadeOut.setOnFinished(l -> {
                sFade.setVisible(false);
            });
        }
    }
    private void sFadeAction(MouseEvent mouseEvent){
        hamTransition.setRate(hamTransition.getRate() * -1);
        hamTransition.play();

        if (sDrawer.isOpening()) {
            sDrawer.close();
                sDrawer.toBack();


            //////////
            sDrawer.setVisible(false);
            /////////////////////

            FadeTransition fadeOut=new FadeTransition(Duration.millis(800),sFade);
            fadeOut.setFromValue(0.4);
            fadeOut.setToValue(0);
            fadeOut.setCycleCount(1);
            fadeOut.play();
            fadeOut.setOnFinished(l -> {
                sFade.setVisible(false);
            });
        }
    }


}
