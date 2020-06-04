package kr.co.bikeda.store.controller;

import static io.datafx.controller.flow.container.ContainerAnimations.SWIPE_LEFT;
import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXPopup;

import datafx.ExtendedAnimatedFlowContainer;
import io.datafx.controller.ViewController;
import io.datafx.controller.flow.Flow;
import io.datafx.controller.flow.FlowHandler;
import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

@ViewController(value = "/fxml/main/BaseFrame.fxml", title = "Stage Main")
public final class BaseFrame {
	private final static Logger appLog = LoggerFactory.getLogger(BaseFrame.class);
    @FXMLViewFlowContext
    private ViewFlowContext context;

    @FXML
    private MenuBar menuBar;
    @FXML
    private StackPane mCardIss, mDigSet, mReport, mSystem;
    @FXML
    private JFXDrawer drawer;
    @FXML
    private JFXPopup rptPopup, designPopup, systemPopup;
    /**
     * init fxml when loaded.
     */
    @PostConstruct
    public void init() throws Exception {
        // create the inner flow and content
        context = new ViewFlowContext();
        // set the default controller
        Flow innerFlow = new Flow( DeliveryController.class );

        final FlowHandler flowHandler = innerFlow.createHandler(context);
        context.register( "ContentFlowHandler", flowHandler );
        context.register( "ContentFlow", innerFlow );
        final Duration containerAnimationDuration = Duration.millis(320);
        drawer.setContent( flowHandler.start( new ExtendedAnimatedFlowContainer( containerAnimationDuration, SWIPE_LEFT ) ) );
        context.register( "ContentPane", drawer.getContent().get( 0 ) );
        
//        FXMLLoader rptLoader = new FXMLLoader(getClass().getResource("/fxml/main/ReportPopup.fxml"));
//        rptLoader.setController( new rptPopupController( context ) );
//        rptPopup = new JFXPopup( rptLoader.load() );
//        
//        mReport.setOnMouseClicked(e ->
//        rptPopup.show(mReport,
//                PopupVPosition.TOP,
//                PopupHPosition.LEFT,
//                -12,
//                15));
        
//        FXMLLoader DesignLoader = new FXMLLoader(getClass().getResource("/fxml/main/DesignPopup.fxml"));
//        DesignLoader.setController( new designPopupController( context ) );
//        designPopup = new JFXPopup( DesignLoader.load() );
//
//        mDigSet.setOnMouseClicked(e ->
//        designPopup.show(mDigSet,
//            PopupVPosition.TOP,
//            PopupHPosition.LEFT,
//            -12,
//            15));
        
//        FXMLLoader SystemLoader = new FXMLLoader(getClass().getResource("/fxml/main/SystemPopup.fxml"));
//        SystemLoader.setController( new SystemPopupController( context ) );
//        systemPopup = new JFXPopup( SystemLoader.load() );
//
//        mSystem.setOnMouseClicked(e ->
//        systemPopup.show(mSystem,
//            PopupVPosition.TOP,
//            PopupHPosition.LEFT,
//            -12,
//            15));
        
//        innerFlow.withGlobalLink( mCardIss.getId(), CardIssueController.class );
//        mCardIss.setOnMouseClicked(e ->
//	    	{
//	            	try {
//						flowHandler.handle( mCardIss.getId() );
//					} catch (VetoException | FlowException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//			}
//	    );
    }

//    public static final class rptPopupController {
//    	@FXMLViewFlowContext
//    	ViewFlowContext context;
//    	
//        @FXML
//        private JFXListView<?> rptList;
//        @FXML
//        @ActionTrigger("mIssRpt")
//        private Label mIssRpt;
//	    @FXML
//	    @ActionTrigger("mCntRpt")
//	    private Label mCntRpt;
//	    
//	    private rptPopupController( ViewFlowContext context ) {
//        	this.context = context;
//        	
//        };
//	    	
//        @FXML
//        private void submit() {
//        	Objects.requireNonNull(context, "context");
//        	FlowHandler contentFlowHandler = ( FlowHandler ) context.getRegisteredObject( "ContentFlowHandler" );
//            Flow contentFlow = (Flow) context.getRegisteredObject("ContentFlow");
//            contentFlow.withGlobalLink( mIssRpt.getId(), RptIssuedController.class );
//            contentFlow.withGlobalLink( mCntRpt.getId(), RptAggregateController.class );
//        	
//        	int popupIdx = rptList.getSelectionModel().getSelectedIndex();
//            if ( popupIdx == 0 ) {
//            	try {
//					contentFlowHandler.handle( mIssRpt.getId() );
//				} catch (VetoException | FlowException e) {
//					// TODO Auto-generated catch block
//					appLog.error( e.getMessage() );
//				}
//            }else if ( popupIdx == 1 ) {
//            	try {
//					contentFlowHandler.handle( mCntRpt.getId() );
//				} catch (VetoException | FlowException e) {
//					// TODO Auto-generated catch block
//					appLog.error( e.getMessage() );
//				}
//            }
//        }
//    }
    
//    public static final class designPopupController {
//    	@FXMLViewFlowContext
//    	ViewFlowContext context;
//    	
//    	@FXML
//    	private JFXListView<?> DesignList;
//    	@FXML
//    	@ActionTrigger("mDesignCode")
//    	private Label mDesignCode;
//    	@FXML
//    	@ActionTrigger("mDesignSetting")
//    	private Label mDesignSetting;
//    	
//    	private designPopupController( ViewFlowContext context ) {
//    		this.context = context;
//    	};
//    	
//    	@FXML
//    	private void submit() {
//    		Objects.requireNonNull(context, "context");
//    		FlowHandler contentFlowHandler = ( FlowHandler ) context.getRegisteredObject( "ContentFlowHandler" );
//    		Flow contentFlow = (Flow) context.getRegisteredObject("ContentFlow");
//    		contentFlow.withGlobalLink( mDesignCode.getId(), DesignCodeController.class );
//    		contentFlow.withGlobalLink( mDesignSetting.getId(), DesignSettingController.class );
//    		
//    		int popupIdx = DesignList.getSelectionModel().getSelectedIndex();
//    		if ( popupIdx == 0 ) {
//    			try {
//    				contentFlowHandler.handle( mDesignCode.getId() );
//    			} catch (VetoException | FlowException e) {
//    				// TODO Auto-generated catch block
//    				appLog.error( e.getMessage() );
//    			}
//    		}else if ( popupIdx == 1 ) {
//    			try {
//    				contentFlowHandler.handle( mDesignSetting.getId() );
//    			} catch (VetoException | FlowException e) {
//    				// TODO Auto-generated catch block
//    				appLog.error( e.getMessage() );
//    			}
//    		}
//    	}
//    }
    
//    public static final class SystemPopupController {
//    	@FXMLViewFlowContext
//    	ViewFlowContext context;
//    	
//    	@FXML
//    	private JFXListView<?> systemList;
//    	@FXML
//    	@ActionTrigger("mSysSet")
//    	private Label mSysSet;
//    	@FXML
//    	@ActionTrigger("mLoginHist")
//    	private Label mLoginHist;
//    	
//    	private SystemPopupController( ViewFlowContext context ) {
//    		this.context = context;
//    	};
//    	
//    	@FXML
//    	private void submit() {
//    		Objects.requireNonNull(context, "context");
//    		FlowHandler contentFlowHandler = ( FlowHandler ) context.getRegisteredObject( "ContentFlowHandler" );
//    		Flow contentFlow = (Flow) context.getRegisteredObject("ContentFlow");
//    		contentFlow.withGlobalLink( mSysSet.getId(), SystemSettingController.class );
//    		contentFlow.withGlobalLink( mLoginHist.getId(), LoginHistoryController.class );
//    		
//    		int popupIdx = systemList.getSelectionModel().getSelectedIndex();
//    		if ( popupIdx == 0 ) {
//    			try {
//    				contentFlowHandler.handle( mSysSet.getId() );
//    			} catch (VetoException | FlowException e) {
//    				// TODO Auto-generated catch block
//    				appLog.error( e.getMessage() );
//    			}
//    		}else if ( popupIdx == 1 ) {
//    			try {
//    				contentFlowHandler.handle( mLoginHist.getId() );
//    			} catch (VetoException | FlowException e) {
//    				// TODO Auto-generated catch block
//    				appLog.error( e.getMessage() );
//    			}
//    		}
//    	}
//    }
}
