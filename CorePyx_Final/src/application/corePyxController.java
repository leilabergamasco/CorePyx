package application;

import java.awt.TextField;
import java.io.File;

import javax.swing.JFileChooser;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderPaneBuilder;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Popup;
import javafx.stage.PopupBuilder;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;
import javafx.stage.Window;

public class corePyxController {

    @FXML
    private Menu menuNavigation;

    @FXML
    private RadioButton tabDescriptorSpharm;

    @FXML
    private Canvas tabResultsCanvas1;

    @FXML
    private Button tabSimilaritySave;

    @FXML
    private Menu menuFile;

    @FXML
    private Canvas tabResultsCanvas3;

    @FXML
    private Button tabDescriptorSave;

    @FXML
    private StackedBarChart<?, ?> graphic1;

    @FXML
    private AnchorPane pPrincipal;

    @FXML
    private Group canvasQuery;

    @FXML
    private Tab tabRegion;

    @FXML
    private MenuItem menuFileOpen;

    @FXML
    private CheckBox tabRegionCheck8;

    @FXML
    private CheckBox tabRegionCheck7;

    @FXML
    private RadioMenuItem menuNavigationTester;

    @FXML
    private Tab tabVer3D;

    @FXML
    private Tab tabDescriptor;

    @FXML
    private CheckBox tabRegionCheck2;

    @FXML
    private MenuItem menuFileClose;

    @FXML
    private CheckBox tabRegionCheck1;

    @FXML
    private Tab tabSimilarity;

    @FXML
    private CheckBox tabRegionCheck6;

    @FXML
    private CheckBox tabRegionCheck5;

    @FXML
    private Canvas tabResultsCavas2;

    @FXML
    private CheckBox tabRegionCheck4;

    @FXML
    private RadioButton tabSimilarityFord;

    @FXML
    private CheckBox tabRegionCheck3;

    @FXML
    private MenuItem menuHelpAbout;

    @FXML
    private Button tabRegionSave;

    @FXML
    private RadioMenuItem menuNavigationAuto;

    @FXML
    private Button tabResultsInfo2;

    @FXML
    private MenuBar menuPrincipal;

    @FXML
    private Button tabResultsInfo1;

    @FXML
    private Button tabResultsGo;

    @FXML
    private RadioButton tabSimilarityEuclidean;

    @FXML
    private TabPane tabPrincipal;

    @FXML
    private GridPane tabRegionGrid;

    @FXML
    private Tab tabResults;

    @FXML
    private RadioMenuItem menuNavigationSemi;

    @FXML
    private Button tabResultsInfo3;

    @FXML
    private Tab tabStatistics;

    @FXML
    private RadioButton tabDescriptorHough;

    @FXML
    private Menu menuHelp;

    
    /*Start the actions*/
    /*Aux methods*/
    FileChooser fileChooser = new FileChooser();
    ToggleGroup toggleGroupMode = new ToggleGroup();
    ToggleGroup toggleGroupDescriptor = new ToggleGroup();
    ToggleGroup toggleGroupSimilarity = new ToggleGroup();
    
    @FXML
    void openFile(ActionEvent event) {
    	
    	Stage stage = null;
    	final int VIEWPORT_SIZE = 800;
    	FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(".STL files (*.stl)", "*.stl");
    	fileChooser.setTitle("Open 3D Object");
    	fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().add(extFilter);
    	File object = fileChooser.showOpenDialog(null);
    	
    	LoaderSTL loader = new LoaderSTL();
    	String MESH_FILENAME = object.getAbsolutePath();
        canvasQuery = loader.buildScene(MESH_FILENAME);
        canvasQuery.setScaleX(2);
        canvasQuery.setScaleY(2);
        canvasQuery.setScaleZ(2);
        canvasQuery.setTranslateX(50);
        canvasQuery.setTranslateY(50);

        Scene scene = new Scene(canvasQuery, VIEWPORT_SIZE, VIEWPORT_SIZE, true);
        scene.setFill(Color.rgb(10, 10, 40));
        loader.addCamera(scene);
        stage.setScene(scene);
        stage.show();
       
        //canvasQuery.getChildren().add(canvasQuery);
    
    }
    @FXML
    void closeFile(ActionEvent event) {
    	Platform.exit();
        System.exit(0);
    }

    @FXML
    void selectAuto(ActionEvent event) {
    	menuNavigationAuto.setToggleGroup(toggleGroupMode);
    	tabPrincipal.getTabs().remove(tabRegion);
    	tabPrincipal.getTabs().remove(tabDescriptor);
    	tabPrincipal.getTabs().remove(tabSimilarity);
    }

    @FXML
    void selectSemi(ActionEvent event) {
    	menuNavigationSemi.setToggleGroup(toggleGroupMode);
    	if(!tabPrincipal.getTabs().contains(tabRegion));
    		tabPrincipal.getTabs().add(1, tabRegion);
    	tabPrincipal.getTabs().remove(tabDescriptor);
    	tabPrincipal.getTabs().remove(tabSimilarity);

    }

    @FXML
    void selectTester(ActionEvent event) {
    	if(!tabPrincipal.getTabs().contains(tabRegion)&&!tabPrincipal.getTabs().contains(tabDescriptor)) {
    		tabPrincipal.getTabs().add(1, tabRegion);
    		tabPrincipal.getTabs().add(2, tabDescriptor);
    		tabPrincipal.getTabs().add(3, tabSimilarity);
    	}else if (!tabPrincipal.getTabs().contains(tabDescriptor)) {
    		tabPrincipal.getTabs().add(2, tabDescriptor);
    		tabPrincipal.getTabs().add(3, tabSimilarity);
    	}
		
    	menuNavigationTester.setToggleGroup(toggleGroupMode);


    }

    @FXML
    void openAbout(ActionEvent event) {
    	 Alert about = new Alert(Alert.AlertType.INFORMATION);
    	 about.setTitle("About");
    	 about.setHeaderText("CorePyx version 1.0");
    	 about.setContentText("Developed by Leila Bergamasco ");
    	 about.showAndWait();
    }

    @FXML
    void saveRegion(ActionEvent event) {

    }
    @FXML
    void selectHough(ActionEvent event) {
    	tabDescriptorHough.setToggleGroup(toggleGroupDescriptor);
    }

    @FXML
    void selectSphaprm(ActionEvent event) {
    	tabDescriptorSpharm.setToggleGroup(toggleGroupDescriptor);
    }
    @FXML
    void saveDescriptor(ActionEvent event) {

    }

    @FXML
    void selectEuclidean(ActionEvent event) {
    	tabSimilarityEuclidean.setToggleGroup(toggleGroupSimilarity);
    }

    @FXML
    void selectFord(ActionEvent event) {
    	tabSimilarityFord.setToggleGroup(toggleGroupSimilarity);
    }
    @FXML
    void saveSimilarity(ActionEvent event) {

    }

   
    @FXML
    void openInfo1(ActionEvent event) {

    }

    @FXML
    void openInfo2(ActionEvent event) {

    }

    @FXML
    void openInfo3(ActionEvent event) {

    }

    @FXML
    void executeQuery(ActionEvent event) {

    }

}
