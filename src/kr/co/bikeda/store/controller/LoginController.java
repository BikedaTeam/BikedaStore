package kr.co.bikeda.store.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDecorator;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.effects.JFXDepthManager;
import com.jfoenix.svg.SVGGlyph;

import io.datafx.controller.flow.Flow;
import io.datafx.controller.flow.FlowException;
import io.datafx.controller.flow.container.DefaultFlowContainer;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import kr.co.bikeda.store.StoreMain;

public class LoginController implements Initializable{
	private final Logger appLog = LoggerFactory.getLogger(LoginController.class);
//	private File path = new File("");
	
    private ViewFlowContext flowContext;
//	
	@FXML private AnchorPane pane_card;
	@FXML private JFXTextField txt_id;
	@FXML private JFXPasswordField txt_password;
	@FXML private JFXButton btn_login;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		JFXDepthManager.setDepth(pane_card, 2);
		txt_id.setOnKeyPressed( e-> {
			if( e.getCode() == KeyCode.ENTER ){
				loginUser();
			}
		});
		
		txt_password.setOnKeyPressed( e-> {
			if( e.getCode() == KeyCode.ENTER ){
				loginUser();
			}
		});
	}
	
	@FXML
	private void loginUser(){
//		Properties dbProp = MDBUtil.getDBProp();
//		Properties sqlProp = MDBUtil.getSQLProp();
//		
//		if( null == dbProp ) return;
//		if( null == sqlProp ) return;
//		
//		String url		= dbProp.getProperty("mdb.driverClassName")
//				+ path.getAbsolutePath()
//				+ dbProp.getProperty("mdb.url") + ";" + "password=" + dbProp.getProperty("mdb.password");
//
//		String query	= "SELECT " + sqlProp.getProperty( "LOGIN.SELECT" )
//						+ " FROM " + sqlProp.getProperty( "LOGIN.TABLE" )
//						+ " WHERE " + sqlProp.getProperty( "LOGIN.CONDITION1" )
//						+ " =\'" + txt_id.getText()
//						+ "\' AND " + sqlProp.getProperty( "LOGIN.CONDITION2" )
//						+ "= \'" + txt_password.getText() + "\'";
//		
//		Connection conn	= null;
//		Statement stmt	= null;
//		ResultSet rs	= null;
//		
//		try {
//			conn = DriverManager.getConnection( url );
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery( query );
//			
//			CommUtil.setLoginDt();
//			CommUtil.loginID = txt_id.getText();
//			
//			if( null != rs && rs.next() ) {
				((Stage)btn_login.getScene().getWindow()).close();
				Stage stage = new Stage();
////				new Thread(() -> {
////		            try {
////		                SVGGlyphLoader.loadGlyphsFont(MainApp.class.getResourceAsStream( "/fonts/icomoon.svg" ), "icomoon.svg" );
////		            } catch ( IOException ioExc ) {
////		                ioExc.printStackTrace();
////		            }
////		        }).start();
//		        
////		        Font.loadFont(MainApp.class.getResource("/resources/font/NANUMSQUAREROUNDR.TTF").toExternalForm(), 10);
////		        Font.loadFont(MainApp.class.getResource("/resources/font/NANUMSQUAREROUNDB.TTF").toExternalForm(), 10);
////		        Font.loadFont(MainApp.class.getResource("/resources/font/NANUMSQUAREROUNDL.TTF").toExternalForm(), 10);
////		        Font.loadFont(MainApp.class.getResource("/resources/font/NANUMSQUAREROUNDEB.TTF").toExternalForm(), 10);
//		        Font.loadFont(MainApp.class.getResource("/font/NANUMSQUAREROUNDR.TTF").toExternalForm(), 10);
//		        Font.loadFont(MainApp.class.getResource("/font/NANUMSQUAREROUNDB.TTF").toExternalForm(), 10);
//		        Font.loadFont(MainApp.class.getResource("/font/NANUMSQUAREROUNDL.TTF").toExternalForm(), 10);
//		        Font.loadFont(MainApp.class.getResource("/font/NANUMSQUAREROUNDEB.TTF").toExternalForm(), 10);
		        try {
			        Flow flow = new Flow( BaseFrame.class );
			        DefaultFlowContainer container = new DefaultFlowContainer();
			        flowContext = new ViewFlowContext();
			        flowContext.register( "Stage", stage );
					flow.createHandler( flowContext )
					.start( container );
//		
			        JFXDecorator decorator = new JFXDecorator( stage, container.getView() );
			        decorator.setCustomMaximize( true );
			        decorator.setGraphic( new SVGGlyph("") );
			        stage.setTitle( "바이크다" );
			
			        double width = 1024;
			        double height = 768;
			        try {
			            Rectangle2D bounds = Screen.getScreens().get(0).getBounds();
//			            width = bounds.getWidth() / 1.5;
//			            height = bounds.getHeight() / 1.15;
			            width = bounds.getWidth() / 1.03;
			            height = bounds.getHeight() / 1.05;
			        }catch ( Exception e ){
			        	appLog.error( e.getMessage() );
			        }
			
//			        stage.getIcons().add(new Image("/image/symbol.png"));
			        Scene scene = new Scene( decorator, width, height );
			        final ObservableList< String > stylesheets = scene.getStylesheets();
			        stylesheets.addAll(StoreMain.class.getResource( "/css/jfoenix-fonts.css" ).toExternalForm(),
						        		StoreMain.class.getResource( "/css/jfoenix-design.css" ).toExternalForm(),
						        		StoreMain.class.getResource( "/css/jfoenix-main.css" ).toExternalForm()
			                           );
			        stage.setScene( scene );
			        stage.initStyle( StageStyle.TRANSPARENT );
//			        stage.setResizable( false );
			        stage.show();
//			        stage.setMaximized( true );
//			        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
//			            public void handle(WindowEvent we) {
//			            	CommUtil.setLogoutDt();
//			            	
//			            	Connection conn	= null;
//			        		PreparedStatement pstmt = null;
//			        		
//			        		String insertQuery	= "INSERT INTO " + sqlProp.getProperty( "HIST.TABLE" ) + " VALUES (?,?,?)";
//			        		
//			            	try {
//								conn = DriverManager.getConnection( url );
//								pstmt = conn.prepareStatement( insertQuery );
//								
//								pstmt.setString( 1 , CommUtil.getloginID() );
//								pstmt.setDate( 2 ,  new java.sql.Date( CommUtil.getLoginDt() ) );
//								pstmt.setDate( 3 , new java.sql.Date( CommUtil.getLogoutDt() ) );
//								
//								pstmt.execute();
//			            	} catch (SQLException e) {
//								// TODO Auto-generated catch block
//			            		appLog.error( e.getMessage() );
//							}
//			            }
//			        });
				} catch (FlowException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					appLog.error( e1.getMessage() );
				}
//			}else {
//				CommUtil.showMsg( AlertType.INFORMATION, "로그?��", "", "로그?�� ?��보�? ?��치하�? ?��?��?��?��." );
//			}
//			rs.close();
//			stmt.close();
//			conn.close();
//		}catch( SQLException e ) {
//			appLog.debug( e.getMessage() );
//		}
	}
	@FXML
	private void closeStage() {
//		appLog.info( MessageBundle.getString( "application.end" ) );
		Platform.exit();
	}
}
