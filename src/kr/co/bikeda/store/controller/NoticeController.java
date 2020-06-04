package kr.co.bikeda.store.controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jfoenix.controls.JFXButton;

import io.datafx.controller.ViewController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

@ViewController(value = "/fxml/view/popup/Notice.fxml", title = "출금계좌 등록")
public class NoticeController implements Initializable{
	private final Logger appLog = LoggerFactory.getLogger(NoticeController.class);
	private File path = new File("");
	
	@FXML private JFXButton btn_close;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		btn_close.setOnAction( new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				((Stage)btn_close.getScene().getWindow()).close();
			}
		});
	}
}
