package kr.co.bikeda.store.controller;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jfoenix.controls.JFXButton;

import io.datafx.controller.ViewController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

@ViewController(value = "/fxml/view/Delivery.fxml", title = "배달 매인")
public class DeliveryController {
	private final Logger appLog = LoggerFactory.getLogger(DeliveryController.class);
	private File path = new File("");
	
	@FXML JFXButton btn_notice, btn_setting;
	
	@PostConstruct
    public void init() {
		
		btn_notice.setOnAction( e -> {
			try {
				Stage popupStage = new Stage();
				NoticeController RegBnkAccController = new NoticeController();
				Parent root;
				Scene scene;
				FXMLLoader loader = new FXMLLoader( new File(path.getAbsolutePath()+ "/resources/fxml/view/popup/Notice.fxml").toURL() );
				loader.setController( RegBnkAccController );
				root = loader.load();
				scene = new Scene(root);
				popupStage.initOwner( btn_notice.getParent().getScene().getWindow() );
				popupStage.initStyle( StageStyle.UNDECORATED );
				popupStage.initModality( Modality.WINDOW_MODAL );
				popupStage.centerOnScreen();
				popupStage.setScene(scene);
				popupStage.show();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});

		btn_setting.setOnAction( e -> {
			try {
				Stage popupStage = new Stage();
				NoticeController RegBnkAccController = new NoticeController();
				Parent root;
				Scene scene;
				FXMLLoader loader = new FXMLLoader( new File(path.getAbsolutePath()+ "/resources/fxml/view/popup/Setting.fxml").toURL() );
				loader.setController( RegBnkAccController );
				root = loader.load();
				scene = new Scene(root);
				popupStage.initOwner( btn_notice.getParent().getScene().getWindow() );
				popupStage.initStyle( StageStyle.UNDECORATED );
				popupStage.initModality( Modality.WINDOW_MODAL );
				popupStage.centerOnScreen();
				popupStage.setScene(scene);
				popupStage.show();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
	}
	
    private void clearComponent() {
//    	txt_search.setText( "" );
//		txt_stNum.setText( "" );
//		txt_status.setText( "" );
//		txt_nm.setText( "" );
//		txt_college.setText( "" );
//		txt_major.setText( "" );
//		txt_scState.setText( "" );
//		txt_lostYn.setText( "" );
//		txt_issCnt.setText( "" );
//		btn_changPic.setDisable( true );
//		btn_deletePic.setDisable( true );
//		btn_issue.setDisable( true );
//		btn_issTest.setDisable( true );
//		setNoPhotoImage( img_pic );
//		tbl_issLog.setRoot( null );
    }
}

