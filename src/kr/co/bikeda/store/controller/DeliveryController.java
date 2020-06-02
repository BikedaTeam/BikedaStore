package kr.co.bikeda.store.controller;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.datafx.controller.ViewController;

@ViewController(value = "/fxml/view/Delivery.fxml", title = "Material Design Example")
public class DeliveryController {
	private final Logger appLog = LoggerFactory.getLogger(DeliveryController.class);
	
	@PostConstruct
    public void init() {
		
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

