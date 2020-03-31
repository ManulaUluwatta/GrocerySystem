package lk.uwu.grocery.ui.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.*;
import net.connectcode.Code128Auto;

import java.awt.*;
import java.awt.Font;

/**
 * Created by Manula Uluwatta on 3/11/2020.
 */
public class BarcodeGenaratorController {



    @FXML
    private JFXTextField name_txt;

    @FXML
    private JFXTextArea text_lbl;

    @FXML
    private JFXButton button_btn;

    @FXML
    void buttonAction(javafx.event.ActionEvent event) {
        Code128Auto code128Auto=new Code128Auto();
        String barcode=code128Auto.encode(name_txt.getText());
        System.out.println("mm");
        text_lbl.setText(barcode);
        text_lbl.setFont(new javafx.scene.text.Font("CCode128_S3_Trial",24));

    }

}
