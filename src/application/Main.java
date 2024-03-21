package application;
//Name:Jehad Hamayel
//Id:1200348
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.effect.DropShadow;
import javafx.application.Application;
import javafx.geometry.*;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Main extends Application {
	static MediaRentalManger mRm = new MediaRentalManger();

	@Override
	public void start(Stage primaryStage) {
//Start the program and print a welcome message and note
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("welcome message");
		alert.setHeaderText("Hello to my Project\nJehad Hamayel-1200348");
		alert.setContentText(
				"Note: When the interface is closed , it stores the information in files that it reads about running again");
		Scene mainScene = new Scene(new BorderPane());
		primaryStage.setScene(mainScene);
		primaryStage.setMaximized(true);
		try {
			mainPage(primaryStage, mainScene);
			alert.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
//A method to display the main page interface and its contents
	public static void mainPage(Stage primaryStage, Scene maineSene) throws IOException {
		Font myfont2 = Font.font("Time new Roman", FontWeight.BOLD, FontPosture.REGULAR, 15);
	//Main Pane
		HBox root = new HBox(200);
		primaryStage.setTitle("Main Page");
		root.setPadding(new Insets(10));
		root.setAlignment(Pos.CENTER);
	//Buttons's Pane
		VBox buttons = new VBox(60);
		buttons.setMinSize(500, 100);
		buttons.setAlignment(Pos.CENTER);
	//image Pane
		VBox ima = new VBox(20);
		ima.setAlignment(Pos.CENTER);
	//Setting the image for the home page
		Image image = new Image("image_1.jpg");
		ImageView imageView = new ImageView(image);
		Group imag = new Group(imageView);

		Label rentalMS = new Label("Rental Media System");
		Font myfont = Font.font("Time new Roman", FontWeight.BOLD, FontPosture.REGULAR, 30);
		rentalMS.setFont(myfont);
		
	//Setting the image for the customer Button
		Image image2 = new Image("customer.png");
		ImageView cusim = new ImageView(image2);
		cusim.setFitHeight(130);
		cusim.setFitWidth(130);
	//Customer Button
		Button customerBut = new Button("Customer",cusim);
		customerBut.setContentDisplay(ContentDisplay.TOP);
	//Action for Customer Button
		customerBut.setOnAction(e -> {
			customer(primaryStage, maineSene);
		});
		customerBut.setMinSize(200, 100);
		customerBut.setStyle("-fx-background-color:lightblue");
		customerBut.setFont(myfont2);
	//Effect for Button
		DropShadow shadow = new DropShadow();
		customerBut.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			customerBut.setEffect(shadow);
		});
		customerBut.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			customerBut.setEffect(null);
		});
	//Setting the image for the media Button
		Image image3 = new Image("media.png");
		ImageView media = new ImageView(image3);
		media.setFitHeight(130);
		media.setFitWidth(130);
	//Media Button
		Button mediaBut = new Button("Media",media);
	//Action for Media Button
		mediaBut.setOnAction(e -> {
			media(primaryStage, maineSene);
		});
		mediaBut.setMinSize(200, 100);
		mediaBut.setStyle("-fx-background-color:lightblue");
		mediaBut.setFont(myfont2);
		mediaBut.setContentDisplay(ContentDisplay.TOP);
	//Effect for Button
		mediaBut.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			mediaBut.setEffect(shadow);
		});
		mediaBut.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			mediaBut.setEffect(null);
		});
	//Setting the image for the rent Button
		Image image4 = new Image("rent.png");
		ImageView rent = new ImageView(image4);
	//Rent Button
		Button rentBut = new Button("Rent",rent);
	//Action for Rent Button
		rentBut.setOnAction(e -> {
			rent(primaryStage, maineSene);
		});
		rentBut.setMinSize(200, 100);
		rentBut.setStyle("-fx-background-color:lightblue");
		rentBut.setFont(myfont2);
		rent.setFitHeight(130);
		rent.setFitWidth(130);
		rentBut.setContentDisplay(ContentDisplay.TOP);
	//Effect for Button
		rentBut.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			rentBut.setEffect(shadow);
		});
		rentBut.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			rentBut.setEffect(null);
		});
	//Screen Format
		buttons.getChildren().addAll(customerBut, mediaBut, rentBut);
		ima.getChildren().addAll(imag, rentalMS);
		root.getChildren().addAll(buttons, ima);
	//View content
		maineSene.setRoot(root);
		primaryStage.show();
	}

	public static void customer(Stage cust, Scene custScene) {
	//Customer Pane
		cust.setTitle("Customer Page");
		HBox root = new HBox(100);
		VBox buttons = new VBox(50);
		root.setAlignment(Pos.CENTER);
		root.setPadding(new Insets(40));
	//Add new Customer Button
		Button addNC = new Button("Add new Customer");
		DropShadow shadow = new DropShadow();
	//Effect for Button
		addNC.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			addNC.setEffect(shadow);
		});
		addNC.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			addNC.setEffect(null);
		});
	//Action for Add new Customer Button
		addNC.setOnAction(e -> {
			custAdd(cust, custScene);
		});
		addNC.setMinSize(200, 100);
		addNC.setStyle("-fx-background-color:lightblue");
	//Delete Customer Button
		Button deleteCus = new Button("Delete Customer");
	//Effect for Button	
		deleteCus.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			deleteCus.setEffect(shadow);
		});
		deleteCus.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			deleteCus.setEffect(null);
		});
	//Action for Delete Customer Button
		deleteCus.setOnAction(e -> {
			deleteCu(cust, custScene);
		});
		deleteCus.setMinSize(200, 100);
		deleteCus.setStyle("-fx-background-color:lightblue");
	//Update Information about Customer Button
		Button updatInfoCus = new Button("Update Information about Customer");
	//Effect for Button
		updatInfoCus.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			updatInfoCus.setEffect(shadow);
		});
		updatInfoCus.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			updatInfoCus.setEffect(null);
		});
	//Action for Update Information about Customer Button
		updatInfoCus.setOnAction(e -> {
			custUpDate(cust, custScene);
		});
		updatInfoCus.setMinSize(200, 100);
		updatInfoCus.setStyle("-fx-background-color:lightblue");
	//Search a Customer by id Button
		Button searchCus = new Button("Search a Customer by id");
	//Effect for Button
		searchCus.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			searchCus.setEffect(shadow);
		});
		searchCus.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			searchCus.setEffect(null);
		});
	//Action for Search a Customer by id Button
		searchCus.setOnAction(e -> {
			searchCu(cust, custScene);
		});
		searchCus.setMinSize(200, 100);
		searchCus.setStyle("-fx-background-color:lightblue");
	//Return to main page Button
		Button returnToMainPage = new Button("Return to main page");
	//Effect for Button
		returnToMainPage.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			returnToMainPage.setEffect(shadow);
		});
		returnToMainPage.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			returnToMainPage.setEffect(null);
		});
	//Action for Return to main page Button
		returnToMainPage.setOnAction(e -> {
			try {
				mainPage(cust, custScene);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		returnToMainPage.setMinSize(200, 100);
		returnToMainPage.setStyle("-fx-background-color:lightblue");
	//Screen Format
		buttons.getChildren().addAll(addNC, deleteCus, updatInfoCus, searchCus);
		root.getChildren().addAll(buttons, returnToMainPage);
	//View content
		custScene.setRoot(root);
		cust.show();
	}

	public static void media(Stage medi, Scene mediScene) {
	//Customer Pane
		medi.setTitle("Media Page");
		HBox root = new HBox(100);
	//buttons Panes
		VBox buttons1 = new VBox(40);
		VBox buttons2 = new VBox(40);
		root.setAlignment(Pos.CENTER);
		root.setPadding(new Insets(40));
	//Add new Media Button
		Button addM = new Button("Add new Media");
	//Effect for Button
		DropShadow shadow = new DropShadow();
		addM.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			addM.setEffect(shadow);
		});
		addM.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			addM.setEffect(null);
		});

		addM.setMinSize(200, 100);
		addM.setStyle("-fx-background-color:lightblue");
	//Action for Add new Media Button
		addM.setOnAction(e -> {
			addMedia(medi, mediScene);
		});
	//Delete Media Button
		Button deleteM = new Button("Delete Media");
	//Effect for Button
		deleteM.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			deleteM.setEffect(shadow);
		});
		deleteM.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			deleteM.setEffect(null);
		});
	//Action for Delete Media Button
		deleteM.setOnAction(e -> {
			deleteMedia(medi, mediScene);
		});
		deleteM.setMinSize(200, 100);
		deleteM.setStyle("-fx-background-color:lightblue");
	//Update Information about Media Button	
		Button updatInfoM = new Button("Update Information about Media");
	//Effect for Button
		updatInfoM.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			updatInfoM.setEffect(shadow);
		});
		updatInfoM.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			updatInfoM.setEffect(null);
		});
	//Action for Update Information about Media Button
		updatInfoM.setOnAction(e -> {
			updatInfoMedia(medi, mediScene);
		});
		updatInfoM.setMinSize(200, 100);
		updatInfoM.setStyle("-fx-background-color:lightblue");
	//Search a Media by code Button
		Button searchMedia = new Button("Search a Media by code");
	//Effect for Button
		searchMedia.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			searchMedia.setEffect(shadow);
		});
		searchMedia.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			searchMedia.setEffect(null);
		});
	//Action for Search a Media by code Button
		searchMedia.setOnAction(e -> {
			searchMedia(medi, mediScene);
		});
		searchMedia.setMinSize(200, 100);
		searchMedia.setStyle("-fx-background-color:lightblue");
	//Print All Media information Button
		Button printAMI = new Button("Print All Media information");
	//Effect for Button
		printAMI.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			printAMI.setEffect(shadow);
		});
		printAMI.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			printAMI.setEffect(null);
		});
		printAMI.setMinSize(200, 100);
		printAMI.setStyle("-fx-background-color:lightblue");
	//Action for Print All Media information Button
		printAMI.setOnAction(e -> {
			PrintAllMediaInfo(medi, mediScene);
		});
	//Set Limited Plan Limit Button
		Button setLimitedPlan = new Button("Set Limited Plan Limit");
	//Effect for Button
		setLimitedPlan.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			setLimitedPlan.setEffect(shadow);
		});
		setLimitedPlan.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			setLimitedPlan.setEffect(null);
		});
	//Action for Set Limited Plan Limit Button
		setLimitedPlan.setOnAction(e -> {
			SetLimitedPlanLimit(medi, mediScene);
		});
		setLimitedPlan.setMinSize(200, 100);
		setLimitedPlan.setStyle("-fx-background-color:lightblue");
	//Search Titles Of Medias Button
		Button searchTitles = new Button("Search Titles Of Medias");
	//Effect for Button
		searchTitles.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			searchTitles.setEffect(shadow);
		});
		searchTitles.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			searchTitles.setEffect(null);
		});
	//Action for Search Titles Of Medias Button
		searchTitles.setOnAction(e -> {
			searchTitleOfMedia(medi, mediScene);
		});
		searchTitles.setMinSize(200, 100);
		searchTitles.setStyle("-fx-background-color:lightblue");
	//Return to main page Button
		Button returnToMainPageM = new Button("Return to main page");
	//Effect for Button
		returnToMainPageM.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			returnToMainPageM.setEffect(shadow);
		});
		returnToMainPageM.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			returnToMainPageM.setEffect(null);
		});
	//Action for Return to main page Button
		returnToMainPageM.setOnAction(e -> {
			try {
				mainPage(medi, mediScene);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		returnToMainPageM.setMinSize(200, 100);
		returnToMainPageM.setStyle("-fx-background-color:lightblue");
		//Screen Format
		buttons1.getChildren().addAll(addM, deleteM, updatInfoM, searchMedia);
		buttons2.getChildren().addAll(printAMI, setLimitedPlan, searchTitles, returnToMainPageM);
		root.getChildren().addAll(buttons1, buttons2);
		//View content
		mediScene.setRoot(root);
		medi.show();
	}

	public static void rent(Stage rent, Scene rentScene) {

		rent.setTitle("Rent Page");
		VBox rented = new VBox(30);
		rented.setAlignment(Pos.CENTER);
		rented.setPadding(new Insets(20));
	//Add To Cart,Remove From Cart And Process Cart Button	
		Button addAndProcess = new Button("Add To Cart,Remove From Cart And Process Cart");
	//Effect for Button
		DropShadow shadow = new DropShadow();
		addAndProcess.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			addAndProcess.setEffect(shadow);
		});
		addAndProcess.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			addAndProcess.setEffect(null);
		});
	//Action for Add To Cart,Remove From Cart And Process Cart Button
		addAndProcess.setOnAction(e -> {
			addAndRemoveAndProcess(rent, rentScene);
		});
		addAndProcess.setMinSize(400, 90);
		addAndProcess.setStyle("-fx-background-color:lightblue");
	//Print the requested interested media in the cart by give the id of customer Button	
		Button printRIM = new Button("Print the requested interested media in the cart by give the id of customer");
	//Action for Print the requested interested media in the cart by give the id of customer Button
		printRIM.setOnAction(e -> {
			printTheRequestedInterested(rent, rentScene);
		});
	//Effect for Button
		printRIM.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			printRIM.setEffect(shadow);
		});
		printRIM.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			printRIM.setEffect(null);
		});
		printRIM.setMinSize(400, 90);
		printRIM.setStyle("-fx-background-color:lightblue");
	//Print the rented media in the cart by give the id of customer Button	
		Button printRM = new Button("Print the rented media in the cart by give the id of customer");
	//Action for Print the rented media in the cart by give the id of customer Button
		printRM.setOnAction(e -> {
			printTheRentedMedia(rent, rentScene);
		});
	//Effect for Button
		printRM.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			printRM.setEffect(shadow);
		});
		printRM.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			printRM.setEffect(null);
		});
		printRM.setMinSize(400, 90);
		printRM.setStyle("-fx-background-color:lightblue");
	//Return Rented media by give the id of customer and then return the media Button	
		Button returnRM = new Button("Return Rented media by give the id of customer and then return the media");
	//Action for Return Rented media by give the id of customer and then return the media Button
		returnRM.setOnAction(e -> {
			returnRentedMedia(rent, rentScene);
		});
	//Effect for Button
		returnRM.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			returnRM.setEffect(shadow);
		});
		returnRM.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			returnRM.setEffect(null);
		});
		returnRM.setMinSize(400, 90);
		returnRM.setStyle("-fx-background-color:lightblue");
	//Return to main page Button	
		Button returnToMainPage = new Button("Return to main page");
	//Effect for Button
		returnToMainPage.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			returnToMainPage.setEffect(shadow);
		});
		returnToMainPage.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			returnToMainPage.setEffect(null);
		});
	//Action for Return to main page Button
		returnToMainPage.setOnAction(e -> {
			try {
				mainPage(rent, rentScene);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		returnToMainPage.setMinSize(400, 90);
		returnToMainPage.setStyle("-fx-background-color:lightblue");
	//Screen Format
		rented.getChildren().addAll(addAndProcess, printRIM, printRM, returnRM, returnToMainPage);
	//View content
		rentScene.setRoot(rented);
		rent.show();
	}

	public static void custAdd(Stage custAd, Scene cusrAdScene) {
	//Customer Add Panes
		VBox custA = new VBox(40);
		custA.setAlignment(Pos.CENTER);
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("alerts");
		alert.setHeaderText(null);
	
		HBox hc1 = new HBox(40);
		HBox hc2 = new HBox(40);
		HBox hc3 = new HBox(40);
		HBox hc4 = new HBox(40);
		HBox hc5 = new HBox(40);
		HBox hc6 = new HBox(40);

		hc1.setAlignment(Pos.CENTER);
		hc2.setAlignment(Pos.CENTER);
		hc3.setAlignment(Pos.CENTER);
		hc4.setAlignment(Pos.CENTER);
		hc5.setAlignment(Pos.CENTER);
		hc6.setAlignment(Pos.CENTER);
		custA.setPadding(new Insets(30));
	//Customer Labels
		Label lc1 = new Label("Customer ID:");
		Label lc2 = new Label("Customer Name:");
		Label lc3 = new Label("Customer Address:");
		Label lc4 = new Label("Customer Mobile:");
		Label lc5 = new Label("Customer Plan:");

		Font myfont2 = Font.font("Time new Roman", FontWeight.BOLD, FontPosture.REGULAR, 20);

		lc1.setFont(myfont2);
		lc2.setFont(myfont2);
		lc3.setFont(myfont2);
		lc4.setFont(myfont2);
		lc5.setFont(myfont2);

		lc1.setMinSize(200, 30);
		lc2.setMinSize(200, 30);
		lc3.setMinSize(200, 30);
		lc4.setMinSize(200, 30);
		lc5.setMinSize(200, 30);
	//Customer TextField and ComboBox
		TextField tc1 = new TextField();
		TextField tc2 = new TextField();
		TextField tc3 = new TextField();
		TextField tc4 = new TextField();
		ComboBox<String> cc5 = new ComboBox<>();
		cc5.getItems().addAll("Limited", "Unlimited");
	//Setting the image for the add-customer Button
		Image image2 = new Image("add-customer.png");
		ImageView cusim = new ImageView(image2);
		cusim.setFitHeight(30);
		cusim.setFitWidth(30);
	//Add Button
		Button bc1 = new Button("Add",cusim);
		bc1.setContentDisplay(ContentDisplay.LEFT);
		DropShadow shadow = new DropShadow();
	//Effect for Button
		bc1.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			bc1.setEffect(shadow);
		});
		bc1.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			bc1.setEffect(null);
		});
	//Make TextField ineffective
		tc2.setEditable(false);
		tc3.setEditable(false);
		tc4.setEditable(false);
		cc5.setVisible(false);
	//Make the input effective in order
		tc1.setOnKeyTyped(e2 -> {
			//Check if the text is not empty
			if (tc1.getText() != "") {
				tc2.setEditable(true);
				tc2.setOnKeyTyped(e3 -> {
					if (tc2.getText() != "")
						tc3.setEditable(true);
					tc3.setOnKeyTyped(e4 -> {
						if (tc3.getText() != "")
							tc4.setEditable(true);
						tc4.setOnKeyTyped(e5 -> {
							cc5.setVisible(true);
						});
					});
				});
			}
		});
	//Action for Add Button
		bc1.setOnAction(e1 -> {
		//Check for incomplete entries
			if (tc1.getText() != "" && tc2.getText() != "" && tc3.getText() != "" && tc4.getText() != ""&& cc5.getValue() != null) {
				//Check the inputs if it is valid
				char[] na2 = tc1.getText().toCharArray();
				boolean idNum = false;
				for (int j = 0; j < na2.length; j++) {
					if (Character.isDigit(na2[j])) {
						idNum = true;
					} else {
						idNum = false;
						break;
					}
				}
				char[] na = tc2.getText().toCharArray();
				boolean letters = false;
				char space = ' ';
				for (int k = 0; k < na.length; k++) {
					if (Character.isLetter(na[k]) || na[k] == space) {
						letters = true;
					} else {
						letters = false;
						break;
					}
				}
				char[] na3 = tc4.getText().toCharArray();
				boolean mobileNum = false;
				for (int r = 0; r < na3.length; r++) {
					if (Character.isDigit(na3[r]) || na3[r] == '+' || na3[r] == '-' || na3[r] == space) {
						mobileNum = true;
					} else {
						mobileNum = false;
						break;
					}
				}

				String id = tc1.getText();
				String name = tc2.getText();
				String address = tc3.getText();
				String mobile = tc4.getText();
				String plan = cc5.getValue();
			//Check if customer is exist
				boolean isExcist = false;
				for (int e = 0; e < mRm.getCustomer().size(); e++) {
					if (mRm.getCustomer().get(e).getId().equals(id)) {
						isExcist = true;
					}
				}
				if (isExcist) {
					alert.setContentText("The Customer is already exist");
					alert.showAndWait();
				} else if (idNum && mobileNum && letters) {
					mRm.addCustomer(id, mobile, name, address, plan);
					alert.setContentText("the customer was added successfully");
					alert.showAndWait();
				} else {
					alert.setContentText("Please enter a valid id or valid Mobile Number");
					alert.showAndWait();
				}

			} else {
				alert.setContentText("Please enter all valid Information");
				alert.showAndWait();
			}
		});
	//Setting the image for the back Button
		Image image3 = new Image("back.png");
		ImageView cusim2 = new ImageView(image3);
		cusim2.setFitHeight(30);
		cusim2.setFitWidth(30);
	//Back Button
		Button bc2 = new Button("Back",cusim2);
		bc2.setContentDisplay(ContentDisplay.LEFT);
	//Effect for Button
		bc2.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			bc2.setEffect(shadow);
		});
		bc2.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			bc2.setEffect(null);
		});
	//Action for Back Button
		bc2.setOnAction(e -> {
			customer(custAd, cusrAdScene);
		});
		bc1.setMinSize(200, 30);
		bc2.setMinSize(200, 30);

		tc1.setMinSize(200, 30);
		tc2.setMinSize(200, 30);
		tc3.setMinSize(200, 30);
		tc4.setMinSize(200, 30);
		cc5.setMinSize(200, 30);
	//Screen Format
		hc1.getChildren().addAll(lc1, tc1);
		hc2.getChildren().addAll(lc2, tc2);
		hc3.getChildren().addAll(lc3, tc3);
		hc4.getChildren().addAll(lc4, tc4);
		hc5.getChildren().addAll(lc5, cc5);
		hc6.getChildren().addAll(bc1, bc2);

		custA.getChildren().addAll(hc1, hc2, hc3, hc4, hc5, hc6);
	//View content
		cusrAdScene.setRoot(custA);
		custAd.setTitle("Add new Customer");
		custAd.show();
		alert.setContentText(
				"Note: Please enter the information in order and complete, otherwise the Add button will not work");
		alert.showAndWait();
	}

	public static void deleteCu(Stage custRe, Scene custReScene) {
	//Customer delete Panes
		VBox custR = new VBox(40);
		custR.setAlignment(Pos.CENTER);
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("alerts");
		alert.setHeaderText(null);

		HBox hr1 = new HBox(40);
		HBox hr2 = new HBox(40);
		HBox hr3 = new HBox(40);
		HBox hr4 = new HBox(40);
		HBox hr5 = new HBox(40);
		HBox hr6 = new HBox(40);

		hr1.setAlignment(Pos.CENTER);
		hr2.setAlignment(Pos.CENTER);
		hr3.setAlignment(Pos.CENTER);
		hr4.setAlignment(Pos.CENTER);
		hr5.setAlignment(Pos.CENTER);
		hr6.setAlignment(Pos.CENTER);
		custR.setPadding(new Insets(30));
	//Customer Labels
		Label lr1 = new Label("Customer ID:");
		Label lr2 = new Label("Customer Name:");
		Label lr3 = new Label("Customer Address:");
		Label lr4 = new Label("Customer Mobile:");
		Label lr5 = new Label("Customer Plan:");
	//Customer TextField
		TextField tr1 = new TextField();
		TextArea tr2 = new TextArea();
		TextArea tr3 = new TextArea();
		TextArea tr4 = new TextArea();
		TextArea tr5 = new TextArea();
		
		tr2.setMaxSize(65, 25);
		tr3.setMaxSize(65, 25);
		tr4.setMaxSize(65, 25);
		tr5.setMaxSize(65, 25);
	//Make TextArea ineffective
		tr2.setEditable(false);
		tr3.setEditable(false);
		tr4.setEditable(false);
		tr5.setEditable(false);
	//Setting the image for the remove Button
		Image image = new Image("remove.png");
		ImageView cusim = new ImageView(image);
		cusim.setFitHeight(30);
		cusim.setFitWidth(30);
	//Remove Button
		Button br1 = new Button("Remove",cusim);
		DropShadow shadow = new DropShadow();
		br1.setContentDisplay(ContentDisplay.LEFT);
	//Effect for Button
		br1.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			br1.setEffect(shadow);
		});
		br1.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			br1.setEffect(null);
		});
	//Action for Remove Button
		br1.setOnAction(e -> {
			//Check if the text is not empty
			if(tr1.getText()!=""){
			String id;
			id = tr1.getText();
		//Check if customer is exist
			int l = -1;
			for (int p = 0; p < mRm.getCustomer().size(); p++) {
				if (mRm.getCustomer().get(p).getId().equals(id)) {
					l = p;
				}
			}
			if (l != -1) {
				mRm.getCustomer().remove(l);
				alert.setContentText("The Customer is removed");
				alert.showAndWait();
				tr1.setText("");
				tr2.setText("");
				tr3.setText("");
				tr4.setText("");
				tr5.setText("");
			} else {
				alert.setContentText("The Customer is not removed Because it does not exist");
				alert.showAndWait();
			}
		}else {
			alert.setContentText("Please Enter id");
			alert.showAndWait();
		}
			
		});
	//Setting the image for the back Button
		Image image2 = new Image("back.png");
		ImageView cusim2 = new ImageView(image2);
		cusim2.setFitHeight(30);
		cusim2.setFitWidth(30);
	//Back Button
		Button br2 = new Button("Back",cusim2);
		br2.setContentDisplay(ContentDisplay.LEFT);
	//Effect for Button
		br2.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			br2.setEffect(shadow);
		});
		br2.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			br2.setEffect(null);
		});
	//Action for Back Button
		br2.setOnAction(e -> {
			customer(custRe, custReScene);
		});
	//Setting the image for the search Button
		Image image3 = new Image("search.png");
		ImageView cusim3 = new ImageView(image3);
		cusim3.setFitHeight(30);
		cusim3.setFitWidth(30);
	//Find Button
		Button br3 = new Button("Find",cusim3);
		br3.setContentDisplay(ContentDisplay.LEFT);
	//Effect for Button
		br3.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			br3.setEffect(shadow);
		});
		br3.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			br3.setEffect(null);
		});
	//Action for Find Button
		br3.setOnAction(e -> {
			//Check if the text is not empty
			if (tr1.getText() != "") {
				char[] na2 = tr1.getText().toCharArray();
			//Check the input if it is valid
				boolean idNum = false;
				for (int j = 0; j < na2.length; j++) {
					if (Character.isDigit(na2[j])) {
						idNum = true;
					} else {
						idNum = false;
						break;
					}
				}
				if (idNum) {
					String id = tr1.getText();
				//Check if customer is exis
					int l = -1;
					for (int p = 0; p < mRm.getCustomer().size(); p++) {
						if (mRm.getCustomer().get(p).getId().equals(id)) {
							l = p;
						}
					}
					if (l != -1) {
						tr2.setText(mRm.getCustomer().get(l).getName());
						tr3.setText(mRm.getCustomer().get(l).getAddress());
						tr4.setText(mRm.getCustomer().get(l).getMobileNumber());
						tr5.setText(mRm.getCustomer().get(l).getPlan());
					} else {
						alert.setContentText("The Customer is not exist Enter another id");
						alert.showAndWait();
					}
				} else {
					alert.setContentText("Please Enter valid id");
					alert.showAndWait();
				}
			} else {
				alert.setContentText("Please Enter id");
				alert.showAndWait();
			}
		});

		br1.setMinSize(200, 30);
		br2.setMinSize(200, 30);
		br3.setMinSize(200, 30);

		Font myfont2 = Font.font("Time new Roman", FontWeight.BOLD, FontPosture.REGULAR, 20);

		lr1.setFont(myfont2);
		lr2.setFont(myfont2);
		lr3.setFont(myfont2);
		lr4.setFont(myfont2);
		lr5.setFont(myfont2);

		lr1.setMinSize(200, 30);
		lr2.setMinSize(200, 30);
		lr3.setMinSize(200, 30);
		lr4.setMinSize(200, 30);
		lr5.setMinSize(200, 30);

		tr1.setMinSize(200, 30);
		tr2.setMinSize(200, 30);
		tr3.setMinSize(200, 30);
		tr4.setMinSize(200, 30);
		tr5.setMinSize(200, 30);
	//Screen Format
		hr1.getChildren().addAll(lr1, tr1);
		hr2.getChildren().addAll(lr2, tr2);
		hr3.getChildren().addAll(lr3, tr3);
		hr4.getChildren().addAll(lr4, tr4);
		hr5.getChildren().addAll(lr5, tr5);
		hr6.getChildren().addAll(br3, br1, br2);

		custR.getChildren().addAll(hr1, hr2, hr3, hr4, hr5, hr6);
	//View content
		custReScene.setRoot(custR);
		custRe.setTitle("Delete Customer");
		custRe.show();
		alert.setContentText(
				"Note: For Search Enter the id and press Find button\nFor Remove Enter the id and press Remove button");
		alert.showAndWait();
	}

	public static void custUpDate(Stage custUp, Scene custUpScene) {
	//Customer Update Panes
		VBox custU = new VBox(40);
		custU.setAlignment(Pos.CENTER);

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("alerts");
		alert.setHeaderText(null);

		HBox hu1 = new HBox(40);
		HBox hu2 = new HBox(40);
		HBox hu3 = new HBox(40);
		HBox hu4 = new HBox(40);
		HBox hu5 = new HBox(40);
		HBox hu6 = new HBox(40);

		hu1.setAlignment(Pos.CENTER);
		hu2.setAlignment(Pos.CENTER);
		hu3.setAlignment(Pos.CENTER);
		hu4.setAlignment(Pos.CENTER);
		hu5.setAlignment(Pos.CENTER);
		hu6.setAlignment(Pos.CENTER);
		custU.setPadding(new Insets(30));
	//Customer Update Labels
		Label lu1 = new Label("Customer ID:");
		Label lu2 = new Label("Customer Name:");
		Label lu3 = new Label("Customer Address:");
		Label lu4 = new Label("Customer Mobile:");
		Label lu5 = new Label("Customer Plan:");
	//Customer Update TextField and ComboBox
		TextField tu1 = new TextField();
		TextField tu2 = new TextField();
		TextField tu3 = new TextField();
		TextField tu4 = new TextField();
		ComboBox<String> cu5 = new ComboBox<>();
		cu5.getItems().addAll("Limited", "Unlimited");

		tu2.setEditable(false);
		tu3.setEditable(false);
		tu4.setEditable(false);
		cu5.setVisible(false);
	//Setting the image for the back Button
		Image image = new Image("back.png");
		ImageView cusim = new ImageView(image);
		cusim.setFitHeight(30);
		cusim.setFitWidth(30);
	//Back Button
		Button bu2 = new Button("Back",cusim);
		DropShadow shadow = new DropShadow();
		bu2.setContentDisplay(ContentDisplay.LEFT);
	//Effect for Button
		bu2.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			bu2.setEffect(shadow);
		});
		bu2.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			bu2.setEffect(null);
		});
	//Action for Back Button
		bu2.setOnAction(e -> {
			customer(custUp, custUpScene);
		});
	//Setting the image for the search Button
		Image image2 = new Image("search.png");
		ImageView cusim2 = new ImageView(image2);
		cusim2.setFitHeight(30);
		cusim2.setFitWidth(30);
	//Find Button
		Button bu3 = new Button("Find",cusim2);
		bu3.setContentDisplay(ContentDisplay.LEFT);
	//Effect for Button
		bu3.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			bu3.setEffect(shadow);
		});
		bu3.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			bu3.setEffect(null);
		});
		Font myfont2 = Font.font("Time new Roman", FontWeight.BOLD, FontPosture.REGULAR, 20);
	//Action for Find Button
		bu3.setOnAction(e -> {
			//Check if the text is not empty
			if (tu1.getText() != "") {
			//Check the inputs if it is valid
				char[] na2 = tu1.getText().toCharArray();
				boolean idNum = false;
				for (int j = 0; j < na2.length; j++) {
					if (Character.isDigit(na2[j])) {
						idNum = true;
					} else {
						idNum = false;
						break;
					}
				}
				if (idNum) {
					tu2.setEditable(true);
					tu3.setEditable(true);
					tu4.setEditable(true);
					cu5.setVisible(true);
					String id = tu1.getText();
				//Check if customer is exist
					int l = -1;
					for (int p = 0; p < mRm.getCustomer().size(); p++) {
						if (mRm.getCustomer().get(p).getId().equals(id)) {
							l = p;
						}
					}
					if (l != -1) {
						tu2.setText(mRm.getCustomer().get(l).getName());
						tu3.setText(mRm.getCustomer().get(l).getAddress());
						tu4.setText(mRm.getCustomer().get(l).getMobileNumber());
						if (mRm.getCustomer().get(l).getPlan().equalsIgnoreCase("unlimited")) {
							cu5.setValue("Unlimited");
						}
						if (mRm.getCustomer().get(l).getPlan().equalsIgnoreCase("limited")) {
							cu5.setValue("Limited");
						}

					} else {
						alert.setContentText("The Customer is not exist Enter another id");
						alert.showAndWait();
					}
				} else {
					alert.setContentText("Please Enter valid id");
					alert.showAndWait();
				}
			} else {
				alert.setContentText("Please Enter id");
				alert.showAndWait();
			}
		});
		//Make TextField ineffective
		tu2.setEditable(false);
		tu3.setEditable(false);
		tu4.setEditable(false);
		cu5.setVisible(false);
		//Make the input effective in order
		tu1.setOnKeyTyped(e2 -> {
			if (tu1.getText() != "") {
				tu2.setEditable(true);
				tu2.setOnKeyTyped(e3 -> {
					if (tu2.getText() != "")
						tu3.setEditable(true);
					tu3.setOnKeyTyped(e4 -> {
						if (tu3.getText() != "")
							tu4.setEditable(true);
						tu4.setOnKeyTyped(e5 -> {
							cu5.setVisible(true);
						});
					});
				});
			}
		});
	//Setting the image for the update Button
		Image image3 = new Image("update.png");
		ImageView cusim3 = new ImageView(image3);
		cusim3.setFitHeight(30);
		cusim3.setFitWidth(30);
	//Update Button
		Button bu1 = new Button("Update",cusim3);
		bu1.setContentDisplay(ContentDisplay.LEFT);
	//Effect for Button
		bu1.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			bu1.setEffect(shadow);
		});
		bu1.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			bu1.setEffect(null);
		});
	//Action for Update Button
		bu1.setOnAction(e -> {
		//Check for incomplete entries
			if (tu1.getText() != "" && tu2.getText() != "" && tu3.getText() != "" && tu4.getText() != ""&& cu5.getValue() != null) {
			//Check the inputs if it is valid
				char[] na2 = tu1.getText().toCharArray();
				boolean idNum = false;
				for (int j = 0; j < na2.length; j++) {
					if (Character.isDigit(na2[j])) {
						idNum = true;
					} else {
						idNum = false;
						break;
					}
				}
				char[] na = tu2.getText().toCharArray();
				boolean letters = false;
				char space = ' ';
				for (int k = 0; k < na.length; k++) {
					if (Character.isLetter(na[k]) || na[k] == space) {
						letters = true;
					} else {
						letters = false;
						break;
					}
				}
				char[] na3 = tu4.getText().toCharArray();
				boolean mobileNum = false;
				for (int r = 0; r < na3.length; r++) {
					if (Character.isDigit(na3[r]) || na3[r] == '+' || na3[r] == '-' || na3[r] == space) {
						mobileNum = true;
					} else {
						mobileNum = false;
						break;
					}
				}

				String id = tu1.getText();

				boolean isExcist = false;
			//Check if customer is exist
				int l = -1;
				for (int k = 0; k < mRm.getCustomer().size(); k++) {
					if (mRm.getCustomer().get(k).getId().equals(id)) {
						isExcist = true;
						l = k;
					}
				}
				if (!isExcist) {
					alert.setContentText("The Customer is not exist");
					alert.showAndWait();
				} else if (idNum && mobileNum && letters) {
					mRm.getCustomer().get(l).setId(tu1.getText());
					mRm.getCustomer().get(l).setName(tu2.getText());
					mRm.getCustomer().get(l).setAddress(tu3.getText());
					mRm.getCustomer().get(l).setMobileNumber(tu4.getText());
					mRm.getCustomer().get(l).setPlan(cu5.getValue());
					alert.setContentText("The Customer is Updated successfully ");
					alert.showAndWait();
				} else {
					alert.setContentText("Please enter a real id  or real Name or real Mobile Number");
					alert.showAndWait();
				}
			} else {
				alert.setContentText("Please enter all valid Information");
				alert.showAndWait();
			}
		});
		bu1.setMinSize(200, 30);
		bu2.setMinSize(200, 30);
		bu3.setMinSize(200, 30);

		lu1.setFont(myfont2);
		lu2.setFont(myfont2);
		lu3.setFont(myfont2);
		lu4.setFont(myfont2);
		lu5.setFont(myfont2);

		lu1.setMinSize(200, 30);
		lu2.setMinSize(200, 30);
		lu3.setMinSize(200, 30);
		lu4.setMinSize(200, 30);
		lu5.setMinSize(200, 30);

		tu1.setMinSize(200, 30);
		tu2.setMinSize(200, 30);
		tu3.setMinSize(200, 30);
		tu4.setMinSize(200, 30);
		cu5.setMinSize(200, 30);
	//Screen Format
		hu1.getChildren().addAll(lu1, tu1);
		hu2.getChildren().addAll(lu2, tu2);
		hu3.getChildren().addAll(lu3, tu3);
		hu4.getChildren().addAll(lu4, tu4);
		hu5.getChildren().addAll(lu5, cu5);
		hu6.getChildren().addAll(bu3, bu1, bu2);

		custU.getChildren().addAll(hu1, hu2, hu3, hu4, hu5, hu6);
	//View content
		custUpScene.setRoot(custU);
		custUp.setTitle("Update Information about ");
		custUp.show();

		alert.setContentText(
				"Note:For Search Enter the id and press Find button \n Please enter the information in order and complete, otherwise the Update button will not work");
		alert.showAndWait();
	}

	
	public static void searchCu(Stage custSe, Scene custSeScene) {
	//Customer search Panes
		VBox custS = new VBox(40);
		custS.setAlignment(Pos.CENTER);
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("alerts");
		alert.setHeaderText(null);

		HBox hs1 = new HBox(40);
		HBox hs2 = new HBox(40);
		HBox hs3 = new HBox(40);
		HBox hs4 = new HBox(40);
		HBox hs5 = new HBox(40);
		HBox hs6 = new HBox(40);

		hs1.setAlignment(Pos.CENTER);
		hs2.setAlignment(Pos.CENTER);
		hs3.setAlignment(Pos.CENTER);
		hs4.setAlignment(Pos.CENTER);
		hs5.setAlignment(Pos.CENTER);
		hs6.setAlignment(Pos.CENTER);
		custS.setPadding(new Insets(50));
	//Customer Labels
		Label ls1 = new Label("Customer ID:");
		Label ls2 = new Label("Customer Name:");
		Label ls3 = new Label("Customer Address:");
		Label ls4 = new Label("Customer Mobile:");
		Label ls5 = new Label("Customer Plan:");
	//Customer Labels
		TextField ts1 = new TextField();
		TextArea ts2 = new TextArea();
		TextArea ts3 = new TextArea();
		TextArea ts4 = new TextArea();
		TextArea ts5 = new TextArea();

		ts2.setMaxSize(65, 25);
		ts3.setMaxSize(65, 25);
		ts4.setMaxSize(65, 25);
		ts5.setMaxSize(65, 25);
	//Make TextArea ineffective
		ts2.setEditable(false);
		ts3.setEditable(false);
		ts4.setEditable(false);
		ts5.setEditable(false);
	//Setting the image for the search Button
		Image image = new Image("search.png");
		ImageView cusim = new ImageView(image);
		cusim.setFitHeight(30);
		cusim.setFitWidth(30);
	//Search Button
		Button bs1 = new Button("Search",cusim);
		bs1.setContentDisplay(ContentDisplay.LEFT);
		DropShadow shadow = new DropShadow();
	//Effect for Button
		bs1.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			bs1.setEffect(shadow);
		});
		bs1.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			bs1.setEffect(null);
		});

		Font myfont2 = Font.font("Time new Roman", FontWeight.BOLD, FontPosture.REGULAR, 20);
	//Action for Search Button
		bs1.setOnAction(e -> {
			//Check if the text is not empty
			if (ts1.getText() != "") {
			//Check the input if it is valid
				char[] na2 = ts1.getText().toCharArray();
				boolean idNum = false;
				for (int j = 0; j < na2.length; j++) {
					if (Character.isDigit(na2[j])) {
						idNum = true;
					} else {
						idNum = false;
						break;
					}
				}
				if (idNum) {
					String id = ts1.getText();
				//Check if customer is exist
					int l = -1;
					for (int p = 0; p < mRm.getCustomer().size(); p++) {
						if (mRm.getCustomer().get(p).getId().equals(id)) {
							l = p;
						}
					}
					if (l != -1) {
						ts2.setText(mRm.getCustomer().get(l).getName());
						ts3.setText(mRm.getCustomer().get(l).getAddress());
						ts4.setText(mRm.getCustomer().get(l).getMobileNumber());
						ts5.setText(mRm.getCustomer().get(l).getPlan());

					} else {
						alert.setContentText("The Customer is not exist Enter another id");
						alert.showAndWait();
					}
				} else {
					alert.setContentText("Please enter a valid Id");
					alert.showAndWait();
				}
			} else {
				alert.setContentText("Please enter Id");
				alert.showAndWait();
			}
		});
	//Setting the image for the back Button
		Image image2 = new Image("back.png");
		ImageView cusim2 = new ImageView(image2);
		cusim2.setFitHeight(30);
		cusim2.setFitWidth(30);
	//Back Button
		Button bs2 = new Button("Back",cusim2);
		bs2.setContentDisplay(ContentDisplay.LEFT);
	//Effect for Button
		bs2.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			bs2.setEffect(shadow);
		});
		bs2.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			bs2.setEffect(null);
		});
	//Action for Back Button
		bs2.setOnAction(e -> {
			customer(custSe, custSeScene);
		});

		bs1.setMinSize(200, 30);
		bs2.setMinSize(200, 30);

		ls1.setFont(myfont2);
		ls2.setFont(myfont2);
		ls3.setFont(myfont2);
		ls4.setFont(myfont2);
		ls5.setFont(myfont2);

		ls1.setMinSize(200, 30);
		ls2.setMinSize(200, 30);
		ls3.setMinSize(200, 30);
		ls4.setMinSize(200, 30);
		ls5.setMinSize(200, 30);

		ts1.setMinSize(200, 30);
		ts2.setMinSize(200, 30);
		ts3.setMinSize(200, 30);
		ts4.setMinSize(200, 30);
		ts5.setMinSize(200, 30);
	//Screen Format
		hs1.getChildren().addAll(ls1, ts1);
		hs2.getChildren().addAll(ls2, ts2);
		hs3.getChildren().addAll(ls3, ts3);
		hs4.getChildren().addAll(ls4, ts4);
		hs5.getChildren().addAll(ls5, ts5);
		hs6.getChildren().addAll(bs1, bs2);

		custS.getChildren().addAll(hs1, hs2, hs3, hs4, hs5, hs6);
		custSeScene.setRoot(custS);
		custSe.setTitle("Search a Customer by id");
	//View content
		custSe.show();
		alert.setContentText("Note:For Search Enter the id and press Find button");
		alert.showAndWait();
	}
	
	public static void addMedia(Stage sMediaAd, Scene sMediaAdScene) {
		sMediaAd.setTitle("Add new Media");
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("alerts");
		alert.setHeaderText(null);
	//Media Add Panes and ComboBox
		ComboBox<String> mediaType = new ComboBox<>();
		mediaType.getItems().addAll("Movie", "Game", "Album");
		mediaType.setPromptText("Choose the type of media");
		HBox hM0 = new HBox(80);
	//Setting the image for the back Button
		Image image = new Image("back.png");
		ImageView mediaim = new ImageView(image);
		mediaim.setFitHeight(30);
		mediaim.setFitWidth(30);
		//Back Button
		Button bM = new Button("Back",mediaim);
		DropShadow shadow = new DropShadow();
		
		bM.setContentDisplay(ContentDisplay.LEFT);
		//Effect for Button
		bM.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e1) -> {
			bM.setEffect(shadow);
		});
		bM.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e1) -> {
			bM.setEffect(null);
		});
		//Action for Back Button
		bM.setOnAction(e1 -> {
			media(sMediaAd, sMediaAdScene);
		});
		//Movie Add Panes
		HBox hMo1 = new HBox(80);
		HBox hMo2 = new HBox(80);
		HBox hMo3 = new HBox(80);
		HBox hMo4 = new HBox(55);
		HBox hMo5 = new HBox(80);
		//Movie Add Labels
		Label lMo1 = new Label("Movie Code:");
		Label lMo2 = new Label("Movie Title:");
		Label lMo3 = new Label("Movie Copies Available:");
		Label lMo4 = new Label("Movie Rating:");
		//Movie Add TextFields
		TextField tMo1 = new TextField();
		TextField tMo2 = new TextField();
		TextField tMo3 = new TextField();
		//Movie Add RadioButtons
		RadioButton rMo1 = new RadioButton("DR");
		RadioButton rMo2 = new RadioButton("HR");
		RadioButton rMo3 = new RadioButton("AC");
	//Setting the image for the add Button and back Button
		Image image1 = new Image("add.png");
		ImageView mediaim1 = new ImageView(image1);
		mediaim1.setFitHeight(30);
		mediaim1.setFitWidth(30);
		Image image2 = new Image("back.png");
		ImageView mediaim2 = new ImageView(image2);
		mediaim2.setFitHeight(30);
		mediaim2.setFitWidth(30);
		//Add Button
		Button bMo1 = new Button("Add",mediaim1);
		//Back Button
		Button bMo2 = new Button("Back",mediaim2);
		//Game Add Panes
		HBox hGa1 = new HBox(80);
		HBox hGa2 = new HBox(80);
		HBox hGa3 = new HBox(80);
		HBox hGa4 = new HBox(80);
		HBox hGa5 = new HBox(80);
		//Game Add Labels
		Label lGa1 = new Label("Game Code:");
		Label lGA2 = new Label("Game Title:");
		Label lGa3 = new Label("Game Copies Available:");
		Label lGa4 = new Label("Game Weight(gm):");
		//Game Add TextFields
		TextField tGa1 = new TextField();
		TextField tGa2 = new TextField();
		TextField tGa3 = new TextField();
		TextField tGa4 = new TextField();
	//Setting the image for the add Button and back Button
		Image image3 = new Image("add.png");
		ImageView mediaim3 = new ImageView(image3);
		mediaim3.setFitHeight(30);
		mediaim3.setFitWidth(30);
		Image image4 = new Image("back.png");
		ImageView mediaim4 = new ImageView(image4);
		mediaim4.setFitHeight(30);
		mediaim4.setFitWidth(30);
		//Add Button
		Button bGa1 = new Button("Add",mediaim3);
		//Back Button
		Button bGa2 = new Button("Back",mediaim4);
		//Album Add Panes
		HBox hAl1 = new HBox(80);
		HBox hAl2 = new HBox(80);
		HBox hAl3 = new HBox(80);
		HBox hAl4 = new HBox(80);
		HBox hAl5 = new HBox(80);
		HBox hAl6 = new HBox(80);
		//Album Add Labels
		Label lAl1 = new Label("Album Code:");
		Label lAl2 = new Label("Album Title:");
		Label lAl3 = new Label("Album Copies Available:");
		Label lAl4 = new Label("Album artist:");
		Label lAl5 = new Label("Album songs:");
		//Album Add TextFields
		TextField tAl1 = new TextField();
		TextField tAl2 = new TextField();
		TextField tAl3 = new TextField();
		TextField tAl4 = new TextField();
		TextField tAl5 = new TextField();
	//Setting the image for the add Button and back Button	
		Image image5 = new Image("add.png");
		ImageView mediaim5 = new ImageView(image5);
		mediaim5.setFitHeight(30);
		mediaim5.setFitWidth(30);
		Image image6 = new Image("back.png");
		ImageView mediaim6 = new ImageView(image6);
		mediaim6.setFitHeight(30);
		mediaim6.setFitWidth(30);
		//Add Button
		Button bAl1 = new Button("Add",mediaim5);
		//Back Button
		Button bAl2 = new Button("Back",mediaim6);

		hM0.setAlignment(Pos.CENTER);

		VBox mediaAd = new VBox(40);
				
		Font myfont2 = Font.font("Time new Roman", FontWeight.BOLD, FontPosture.REGULAR, 20);
		Label lM0 = new Label("Media Type:");
		lM0.setFont(myfont2);
		lM0.setMinSize(250, 30);
		
		mediaType.setMinSize(200, 30);

		hM0.getChildren().addAll(lM0, mediaType);

		mediaAd.getChildren().addAll(hM0, bM);
		mediaAd.setAlignment(Pos.CENTER);
		//View content
		sMediaAdScene.setRoot(mediaAd);
		sMediaAd.show();

		alert.setContentText("Note: Please enter the information in order and complete, otherwise the Add button will not work");
		alert.showAndWait();
		//Screen Format
		//Add content to display
		hMo1.getChildren().addAll(lMo1, tMo1);
		hMo2.getChildren().addAll(lMo2, tMo2);
		hMo3.getChildren().addAll(lMo3, tMo3);
		hMo4.getChildren().addAll(lMo4, rMo1, rMo2, rMo3);
		hMo5.getChildren().addAll(bMo1, bMo2);

		hGa1.getChildren().addAll(lGa1, tGa1);
		hGa2.getChildren().addAll(lGA2, tGa2);
		hGa3.getChildren().addAll(lGa3, tGa3);
		hGa4.getChildren().addAll(lGa4, tGa4);
		hGa5.getChildren().addAll(bGa1, bGa2);

		hAl1.getChildren().addAll(lAl1, tAl1);
		hAl2.getChildren().addAll(lAl2, tAl2);
		hAl3.getChildren().addAll(lAl3, tAl3);
		hAl4.getChildren().addAll(lAl4, tAl4);
		hAl5.getChildren().addAll(lAl5, tAl5);
		hAl6.getChildren().addAll(bAl1, bAl2);

		mediaType.setOnAction(e -> {
			//Delete previous content to display the new
			mediaAd.getChildren().remove(bM);
			mediaAd.getChildren().removeAll(hMo1, hMo2, hMo3, hMo4, hMo5);
			mediaAd.getChildren().removeAll(hGa1, hGa2, hGa3, hGa4, hGa5);
			mediaAd.getChildren().removeAll(hAl1, hAl2, hAl3, hAl4, hAl5, hAl6);

			if (mediaType.getValue().equals("Movie")) {

				hMo1.setAlignment(Pos.CENTER);
				hMo2.setAlignment(Pos.CENTER);
				hMo3.setAlignment(Pos.CENTER);
				hMo4.setAlignment(Pos.CENTER);
				hMo5.setAlignment(Pos.CENTER);

				mediaAd.setPadding(new Insets(30));

				ToggleGroup t = new ToggleGroup();

				rMo1.setToggleGroup(t);
				rMo2.setToggleGroup(t);
				rMo3.setToggleGroup(t);
				
				bMo1.setContentDisplay(ContentDisplay.LEFT);
				//Effect for Button
				bMo1.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e1) -> {
					bMo1.setEffect(shadow);
				});
				bMo1.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e1) -> {
					bMo1.setEffect(null);
				});
				//Make TextField ineffective
				tMo2.setEditable(false);
				tMo3.setEditable(false);
				rMo1.setVisible(false);
				rMo2.setVisible(false);
				rMo3.setVisible(false);
				//Make the input effective in order
				tMo1.setOnKeyTyped(e2 -> {
					if (tMo1.getText() != "") {
						tMo2.setEditable(true);
						tMo2.setOnKeyTyped(e3 -> {
							if (tMo2.getText() != "")
								tMo3.setEditable(true);
							tMo3.setOnKeyTyped(e4 -> {
								if (tMo3.getText() != "") {
									rMo1.setVisible(true);
									rMo2.setVisible(true);
									rMo3.setVisible(true);
								}
							});
						});
					}
				});
				//Action for Add Button
				bMo1.setOnAction(e5 -> {
					//Check for incomplete entries
					if (tMo1.getText() != "" && tMo2.getText() != "" && tMo3.getText() != ""&& (rMo1.isSelected() || rMo2.isSelected() || rMo3.isSelected())) {
						boolean isExist = false;
						//Check if media is exist
						for (int m = 0; m < mRm.getMedia().size(); m++) {
							if (mRm.getMedia().get(m).getCode().equals(tMo1.getText())) {
								isExist = true;
							}
						}
						//Check the input if it is valid
						char[] na = tMo3.getText().toCharArray();
						boolean digit = false;
						for (int j = 0; j < na.length; j++) {
							if (Character.isDigit(na[j])) {
								digit = true;
							} else {
								digit = false;
								break;
							}
						}
						if (!isExist) {
							if (digit) {
								String code = tMo1.getText();
								String title = tMo2.getText();
								String rating = "";
								int copiesAvailable = Integer.parseInt(tMo3.getText());
								if (rMo1.isSelected()) {
									rating = "DR";
								}
								if (rMo2.isSelected()) {
									rating = "HR";
								}
								if (rMo3.isSelected()) {
									rating = "AC";
								}
								mRm.addMovie(code, title, copiesAvailable, rating);
								alert.setContentText("the Movie was added successfully");
								alert.showAndWait();
							} else {
								alert.setContentText(
										"Please enter Positive copies number without positive and negative symbols");
								alert.showAndWait();
							}
						} else {
							alert.setContentText("The Media is already exist");
							alert.showAndWait();
						}

					} else {
						alert.setContentText("Please enter all information");
						alert.showAndWait();
					}
				});
				bMo2.setContentDisplay(ContentDisplay.LEFT);
				//Effect for Button
				bMo2.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e1) -> {
					bMo2.setEffect(shadow);
				});
				bMo2.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e1) -> {
					bMo2.setEffect(null);
				});
				//Action for Back Button
				bMo2.setOnAction(e1 -> {
					media(sMediaAd, sMediaAdScene);
				});

				bMo1.setMinSize(200, 30);
				bMo2.setMinSize(200, 30);

				lMo1.setFont(myfont2);
				lMo2.setFont(myfont2);
				lMo3.setFont(myfont2);
				lMo4.setFont(myfont2);

				lMo1.setMinSize(250, 30);
				lMo2.setMinSize(250, 30);
				lMo3.setMinSize(250, 30);
				lMo4.setMinSize(250, 30);

				tMo1.setMinSize(200, 30);
				tMo2.setMinSize(200, 30);
				tMo3.setMinSize(200, 30);
				//Add content to display
				mediaAd.getChildren().addAll(hMo1, hMo2, hMo3, hMo4, hMo5);

				sMediaAd.setTitle("Adding Movie");
			}

			else if (mediaType.getValue().equals("Game")) {

				hGa1.setAlignment(Pos.CENTER);
				hGa2.setAlignment(Pos.CENTER);
				hGa3.setAlignment(Pos.CENTER);
				hGa4.setAlignment(Pos.CENTER);
				hGa5.setAlignment(Pos.CENTER);

				mediaAd.setPadding(new Insets(30));

				bGa1.setContentDisplay(ContentDisplay.LEFT);
				//Effect for Button
				bGa1.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e1) -> {
					bGa1.setEffect(shadow);
				});
				bGa1.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e1) -> {
					bGa1.setEffect(null);
				});
				//Make TextField ineffective
				tGa2.setEditable(false);
				tGa3.setEditable(false);
				tGa4.setEditable(false);
				//Make the input effective in order
				tGa1.setOnKeyTyped(e2 -> {
					if (tGa1.getText() != "") {
						tGa2.setEditable(true);
						tGa2.setOnKeyTyped(e3 -> {
							if (tGa2.getText() != "")
								tGa3.setEditable(true);
							tGa3.setOnKeyTyped(e4 -> {
								if (tGa3.getText() != "") {
									tGa4.setEditable(true);
								}
							});
						});
					}
				});
				//Action for Add Button
				bGa1.setOnAction(e1 -> {
					//Check for incomplete entries
					if (tGa1.getText() != "" && tGa2.getText() != "" && tGa3.getText() != "" && tGa4.getText() != "") {
						boolean isExist = false;
						//Check if media is exist
						for (int m = 0; m < mRm.getMedia().size(); m++) {
							if (mRm.getMedia().get(m).getCode().equals(tGa1.getText())) {
								isExist = true;
							}
						}
						//Check the inputs if they are valid
						char[] na = tGa3.getText().toCharArray();
						boolean digit = false;
						for (int j = 0; j < na.length; j++) {
							if (Character.isDigit(na[j])) {
								digit = true;
							} else {
								digit = false;
								break;
							}
						}
						char[] na2 = tGa4.getText().toCharArray();
						boolean digit1 = false;
						char point = '.';
						for (int j = 0; j < na2.length; j++) {
							if (Character.isDigit(na2[j]) || na2[j] == point) {
								digit1 = true;
							} else {
								digit1 = false;
								break;
							}
						}

						if (!isExist) {
							if (digit && digit1) {
								String code = tGa1.getText();
								String title = tGa2.getText();
								int copiesAvailable = Integer.parseInt(tGa3.getText());
								double weight = Double.parseDouble(tGa4.getText());
								mRm.addGame(code, title, copiesAvailable, weight);
								alert.setContentText("the Game was added successfully");
								alert.showAndWait();
							} else {
								alert.setContentText(
										"Please enter Positive copies number Example(5) and weight Example(5.6) without positive and negative symbols");
								alert.showAndWait();
							}
						} else {
							alert.setContentText("The Media is already exist");
							alert.showAndWait();
						}
					}

					else {
						alert.setContentText("Please enter all information");
						alert.showAndWait();
					}
				});

				bGa2.setContentDisplay(ContentDisplay.LEFT);
				//Effect for Button
				bGa2.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e1) -> {
					bGa2.setEffect(shadow);
				});
				bGa2.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e1) -> {
					bGa2.setEffect(null);
				});
				//Action for Back Button
				bGa2.setOnAction(e1 -> {
					media(sMediaAd, sMediaAdScene);
				});

				bGa1.setMinSize(200, 30);
				bGa2.setMinSize(200, 30);

				lGa1.setFont(myfont2);
				lGA2.setFont(myfont2);
				lGa3.setFont(myfont2);
				lGa4.setFont(myfont2);

				lGa1.setMinSize(250, 30);
				lGA2.setMinSize(250, 30);
				lGa3.setMinSize(250, 30);
				lGa4.setMinSize(250, 30);

				tGa1.setMinSize(200, 30);
				tGa2.setMinSize(200, 30);
				tGa3.setMinSize(200, 30);
				tGa4.setMinSize(200, 30);
				//Add content to display
				mediaAd.getChildren().addAll(hGa1, hGa2, hGa3, hGa4, hGa5);

				sMediaAd.setTitle("Adding Game");

			} else if (mediaType.getValue().equals("Album")) {
				hAl1.setAlignment(Pos.CENTER);
				hAl2.setAlignment(Pos.CENTER);
				hAl3.setAlignment(Pos.CENTER);
				hAl4.setAlignment(Pos.CENTER);
				hAl5.setAlignment(Pos.CENTER);
				hAl6.setAlignment(Pos.CENTER);

				mediaAd.setPadding(new Insets(30));

				bAl1.setContentDisplay(ContentDisplay.LEFT);
				//Effect for Button
				bAl1.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e1) -> {
					bAl1.setEffect(shadow);
				});
				bAl1.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e1) -> {
					bAl1.setEffect(null);
				});
				//Make TextField ineffective
				tAl2.setEditable(false);
				tAl3.setEditable(false);
				tAl4.setEditable(false);
				tAl5.setEditable(false);
				//Make the input effective in order
				tAl1.setOnKeyTyped(e2 -> {
					if (tAl1.getText() != "") {
						tAl2.setEditable(true);
						tAl2.setOnKeyTyped(e3 -> {
							if (tAl2.getText() != "")
								tAl3.setEditable(true);
							tAl3.setOnKeyTyped(e4 -> {
								if (tAl3.getText() != "") {
									tAl4.setEditable(true);
								}
								tAl4.setOnKeyTyped(e5 -> {
									if (tAl4.getText() != "") {
										tAl5.setEditable(true);
									}
								});
							});
						});
					}
				});
				//Action for Add Button
				bAl1.setOnAction(e1 -> {
					//Check for incomplete entries
					if (tAl1.getText() != "" && tAl2.getText() != "" && tAl3.getText() != "" && tAl4.getText() != ""&& tAl5.getText() != "") {
						boolean isExist = false;
						for (int m = 0; m < mRm.getMedia().size(); m++) {
							if (mRm.getMedia().get(m).getCode().equals(tAl1.getText())) {
								isExist = true;
							}
						}
						//Check the input if it is valid
						char[] na = tAl3.getText().toCharArray();
						boolean digit = false;
						for (int j = 0; j < na.length; j++) {
							if (Character.isDigit(na[j])) {
								digit = true;
							} else {
								digit = false;
								break;
							}
						}

						if (!isExist) {
							if (digit) {
								String code = tAl1.getText();
								String title = tAl2.getText();
								int copiesAvailable = Integer.parseInt(tAl3.getText());
								String artist = tAl4.getText();
								String songs = tAl5.getText();
								mRm.addAlbum(code, title, copiesAvailable, artist, songs);
								alert.setContentText("the Album was added successfully");
								alert.showAndWait();
							} else {
								alert.setContentText(
										"Please enter Positive copies number Example(5) without positive and negative symbols");
								alert.showAndWait();
							}
						} else {
							alert.setContentText("The Media is already exist");
							alert.showAndWait();
						}

					} else {
						alert.setContentText("Please enter all information");
						alert.showAndWait();
					}

				});

				bAl2.setContentDisplay(ContentDisplay.LEFT);
				//Effect for Button
				bAl2.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e1) -> {
					bAl2.setEffect(shadow);
				});
				bAl2.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e1) -> {
					bAl2.setEffect(null);
				});
				//Action for Back Button
				bAl2.setOnAction(e1 -> {
					media(sMediaAd, sMediaAdScene);
				});

				bAl1.setMinSize(200, 30);
				bAl2.setMinSize(200, 30);

				lAl1.setFont(myfont2);
				lAl2.setFont(myfont2);
				lAl3.setFont(myfont2);
				lAl4.setFont(myfont2);
				lAl5.setFont(myfont2);

				lAl1.setMinSize(250, 30);
				lAl2.setMinSize(250, 30);
				lAl3.setMinSize(250, 30);
				lAl4.setMinSize(250, 30);
				lAl5.setMinSize(250, 30);

				tAl1.setMinSize(200, 30);
				tAl2.setMinSize(200, 30);
				tAl3.setMinSize(200, 30);
				tAl4.setMinSize(200, 30);
				tAl5.setMinSize(200, 30);
				//Add content to display
				mediaAd.getChildren().addAll(hAl1, hAl2, hAl3, hAl4, hAl5, hAl6);

				sMediaAd.setTitle("Adding Album");
				alert.setContentText("Please enter the names of the songs with a comma between them");
				alert.showAndWait();
			}

		});
	}

	

	public static void deleteMedia(Stage sMediaRemove, Scene sMediaRemoveScene) {
		sMediaRemove.setTitle("Delete Media");
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("alerts");
		alert.setHeaderText(null);
		//Media Delete Panes and ComboBox
		ComboBox<String> mediaTypeRe = new ComboBox<>();
		mediaTypeRe.getItems().addAll("Movie", "Game", "Album");
		mediaTypeRe.setPromptText("Choose the type of media");
		
		HBox hMR0 = new HBox(80);
		//Setting the image for the back Button
		Image image = new Image("back.png");
		ImageView mediaim = new ImageView(image);
		mediaim.setFitHeight(30);
		mediaim.setFitWidth(30);
		//Back Button
		Button bM = new Button("Back",mediaim);
		DropShadow shadow = new DropShadow();
		
		bM.setContentDisplay(ContentDisplay.LEFT);
		//Effect for Button
		bM.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e1) -> {
			bM.setEffect(shadow);
		});
		bM.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e1) -> {
			bM.setEffect(null);
		});
		//Action for Back Button
		bM.setOnAction(e1 -> {
			media(sMediaRemove, sMediaRemoveScene);
		});
		//Movie Delete Panes
		HBox hMoR1 = new HBox(80);
		HBox hMoR2 = new HBox(80);
		HBox hMoR3 = new HBox(80);
		HBox hMoR4 = new HBox(80);
		HBox hMoR5 = new HBox(80);
		//Movie Delete TextFields
		TextField tMo1 = new TextField();
		TextArea tMo2 = new TextArea();
		TextArea tMo3 = new TextArea();
		TextArea tMo4 = new TextArea();
		tMo2.setMaxSize(65, 25);
		tMo3.setMaxSize(65, 25);
		tMo4.setMaxSize(65, 25);
		//Movie Delete Labels
		Label lMo1 = new Label("Movie Code:");
		Label lMo2 = new Label("Movie Title:");
		Label lMo3 = new Label("Movie Copies Available:");
		Label lMo4 = new Label("Movie Rating:");
		//Setting the image for the back Button, search Button and removeButton
		Image image2 = new Image("search.png");
		ImageView mediaim2 = new ImageView(image2);
		mediaim2.setFitHeight(30);
		mediaim2.setFitWidth(30);
		Image image3 = new Image("remove.png");
		ImageView mediaim3 = new ImageView(image3);
		mediaim3.setFitHeight(30);
		mediaim3.setFitWidth(30);
		Image image4 = new Image("back.png");
		ImageView mediaim4 = new ImageView(image4);
		mediaim4.setFitHeight(30);
		mediaim4.setFitWidth(30);
		
		//Movie Delete Buttons
		Button bMo3 = new Button("Find",mediaim2);
		Button bMo1 = new Button("Remove",mediaim3);
		Button bMo2 = new Button("Back",mediaim4);
		//Game Delete Panes
		HBox hGaR1 = new HBox(80);
		HBox hGaR2 = new HBox(80);
		HBox hGaR3 = new HBox(80);
		HBox hGaR4 = new HBox(80);
		HBox hGaR5 = new HBox(80);
		//Movie Delete TextFields
		TextField tGa1 = new TextField();
		TextArea tGa2 = new TextArea();
		TextArea tGa3 = new TextArea();
		TextArea tGa4 = new TextArea();
		tGa2.setMaxSize(65, 25);
		tGa3.setMaxSize(65, 25);
		tGa4.setMaxSize(65, 25);
		//Movie Delete Labels
		Label lGa1 = new Label("Game Code:");
		Label lGA2 = new Label("Game Title:");
		Label lGa3 = new Label("Game Copies Available:");
		Label lGa4 = new Label("Game Weight(gm):");
		//Setting the image for the back Button, search Button and removeButton
		Image image5 = new Image("search.png");
		ImageView mediaim5 = new ImageView(image5);
		mediaim5.setFitHeight(30);
		mediaim5.setFitWidth(30);
		Image image6 = new Image("remove.png");
		ImageView mediaim6 = new ImageView(image6);
		mediaim6.setFitHeight(30);
		mediaim6.setFitWidth(30);
		Image image7 = new Image("back.png");
		ImageView mediaim7 = new ImageView(image7);
		mediaim7.setFitHeight(30);
		mediaim7.setFitWidth(30);
		//Movie Delete Buttons
		Button bGa1 = new Button("Remove",mediaim6);
		Button bGa3 = new Button("Find",mediaim5);
		Button bGa2 = new Button("Back",mediaim7);
		//Album Delete Panes
		HBox hAlR1 = new HBox(80);
		HBox hAlR2 = new HBox(80);
		HBox hAlR3 = new HBox(80);
		HBox hAlR4 = new HBox(80);
		HBox hAlR5 = new HBox(80);
		HBox hAlR6 = new HBox(80);
		//Album Delete Labels
		Label lAl1 = new Label("Album Code:");
		Label lAl2 = new Label("Album Title:");
		Label lAl3 = new Label("Album Copies Available:");
		Label lAl4 = new Label("Album artist:");
		Label lAl5 = new Label("Album songs:");
		//Album Delete TextFields
		TextField tAl1 = new TextField();
		TextArea tAl2 = new TextArea();
		TextArea tAl3 = new TextArea();
		TextArea tAl4 = new TextArea();
		TextArea tAl5 = new TextArea();
		tAl2.setMaxSize(65, 25);
		tAl3.setMaxSize(65, 25);
		tAl4.setMaxSize(65, 25);
		tAl5.setMaxSize(65, 25);
		//Setting the image for the back Button, search Button and removeButton
		Image image8 = new Image("search.png");
		ImageView mediaim8 = new ImageView(image8);
		mediaim8.setFitHeight(30);
		mediaim8.setFitWidth(30);
		Image image9 = new Image("remove.png");
		ImageView mediaim9 = new ImageView(image9);
		mediaim9.setFitHeight(30);
		mediaim9.setFitWidth(30);
		Image image10 = new Image("back.png");
		ImageView mediaim10 = new ImageView(image10);
		mediaim10.setFitHeight(30);
		mediaim10.setFitWidth(30);
		//Album Delete Buttons
		Button bAl1 = new Button("Remove",mediaim9);
		Button bAl2 = new Button("Back",mediaim10);
		Button bAl3 = new Button("Find",mediaim8);

		hMR0.setAlignment(Pos.CENTER);

		VBox mediaRe = new VBox(40);

		Label lMR0 = new Label("Media Type:");

		Font myfont2 = Font.font("Time new Roman", FontWeight.BOLD, FontPosture.REGULAR, 20);

		lMR0.setFont(myfont2);
		lMR0.setMinSize(250, 30);

		mediaTypeRe.setMinSize(200, 30);

		hMR0.getChildren().addAll(lMR0, mediaTypeRe);

		mediaRe.getChildren().addAll(hMR0, bM);
		mediaRe.setAlignment(Pos.CENTER);
		//View content
		sMediaRemoveScene.setRoot(mediaRe);
		sMediaRemove.show();

		alert.setContentText("Note: For Search Enter the Code and press Find button\\nFor Remove Enter the id and press Remove button");
		alert.showAndWait();
		//Screen Format
		//Add content to display
		hMoR1.getChildren().addAll(lMo1, tMo1);
		hMoR2.getChildren().addAll(lMo2, tMo2);
		hMoR3.getChildren().addAll(lMo3, tMo3);
		hMoR4.getChildren().addAll(lMo4, tMo4);
		hMoR5.getChildren().addAll(bMo3, bMo1, bMo2);

		hGaR1.getChildren().addAll(lGa1, tGa1);
		hGaR2.getChildren().addAll(lGA2, tGa2);
		hGaR3.getChildren().addAll(lGa3, tGa3);
		hGaR4.getChildren().addAll(lGa4, tGa4);
		hGaR5.getChildren().addAll(bGa3, bGa1, bGa2);

		hAlR1.getChildren().addAll(lAl1, tAl1);
		hAlR2.getChildren().addAll(lAl2, tAl2);
		hAlR3.getChildren().addAll(lAl3, tAl3);
		hAlR4.getChildren().addAll(lAl4, tAl4);
		hAlR5.getChildren().addAll(lAl5, tAl5);
		hAlR6.getChildren().addAll(bAl3, bAl1, bAl2);
		mediaTypeRe.setOnAction(e -> {
			//Delete previous content to display the new
			mediaRe.getChildren().remove(bM);
			mediaRe.getChildren().removeAll(hMoR1, hMoR2, hMoR3, hMoR4, hMoR5);
			mediaRe.getChildren().removeAll(hGaR1, hGaR2, hGaR3, hGaR4, hGaR5);
			mediaRe.getChildren().removeAll(hAlR1, hAlR2, hAlR3, hAlR4, hAlR5, hAlR6);

			if (mediaTypeRe.getValue().equals("Movie")) {

				hMoR1.setAlignment(Pos.CENTER);
				hMoR2.setAlignment(Pos.CENTER);
				hMoR3.setAlignment(Pos.CENTER);
				hMoR4.setAlignment(Pos.CENTER);
				hMoR5.setAlignment(Pos.CENTER);

				mediaRe.setPadding(new Insets(30));
				//Make TextArea ineffective
				tMo2.setEditable(false);
				tMo3.setEditable(false);
				tMo4.setEditable(false);

				bMo3.setContentDisplay(ContentDisplay.LEFT);
				//Effect for Button
				bMo3.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e1) -> {
					bMo3.setEffect(shadow);
				});
				bMo3.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e1) -> {
					bMo3.setEffect(null);
				});
				//Action for Search Button
				bMo3.setOnAction(e3 -> {
					//Check if the text is not empty
					if (tMo1.getText() != "") {
						String code;
						code = tMo1.getText();
						//Check if media is exist
						int l = -1;
						for (int p = 0; p < mRm.getMedia().size(); p++) {
							if (mRm.getMedia().get(p).getCode().equals(code)) {
								l = p;
							}
						}
						if (l != -1 && mRm.getMedia().get(l) instanceof Movie) {
							tMo2.setText(mRm.getMedia().get(l).getTitle());
							tMo3.setText(mRm.getMedia().get(l).getCopiesAvailable() + "");
							tMo4.setText(((Movie) mRm.getMedia().get(l)).getRating());

						} else {
							alert.setContentText("The madia does not exist");
							alert.showAndWait();
						}
					} else {
						alert.setContentText("Please Enter Code");
						alert.showAndWait();
					}
				});
				bMo1.setContentDisplay(ContentDisplay.LEFT);
				//Effect for Button
				bMo1.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e1) -> {
					bMo1.setEffect(shadow);
				});
				bMo1.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e1) -> {
					bMo1.setEffect(null);
				});
				//Action for Remove Button
				bMo1.setOnAction(e2 -> {		
					//Check if the text is not empty
					if (tMo1.getText() != "") {
						String code;
						code = tMo1.getText();
						int l = -1;
						//Check if Media is exist
						for (int p = 0; p < mRm.getMedia().size(); p++) {
							if (mRm.getMedia().get(p).getCode().equals(code)) {
								l = p;
							}
						}
						if (l != -1 && mRm.getMedia().get(l) instanceof Movie) {
							mRm.getMedia().remove(l);
							tMo1.setText("");
							tMo2.setText("");
							tMo3.setText("");
							tMo4.setText("");
							alert.setContentText("The madia removed successfully");
							alert.showAndWait();
						} else {
							alert.setContentText("The madia does not exist");
							alert.showAndWait();
						}
					} else {
						alert.setContentText("Please Enter Code");
						alert.showAndWait();
					}
				});
				bMo2.setContentDisplay(ContentDisplay.LEFT);
				//Effect for Button
				bMo2.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e1) -> {
					bMo2.setEffect(shadow);
				});
				bMo2.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e1) -> {
					bMo2.setEffect(null);
				});
				//Action for Back Button
				bMo2.setOnAction(e1 -> {
					media(sMediaRemove, sMediaRemoveScene);
				});

				bMo1.setMinSize(200, 30);
				bMo2.setMinSize(200, 30);
				bMo3.setMinSize(200, 30);

				lMo1.setFont(myfont2);
				lMo2.setFont(myfont2);
				lMo3.setFont(myfont2);
				lMo4.setFont(myfont2);

				lMo1.setMinSize(250, 30);
				lMo2.setMinSize(250, 30);
				lMo3.setMinSize(250, 30);
				lMo4.setMinSize(250, 30);

				tMo1.setMinSize(200, 30);
				tMo2.setMinSize(200, 30);
				tMo3.setMinSize(200, 30);
				tMo4.setMinSize(200, 30);
				//Add content to display
				mediaRe.getChildren().addAll(hMoR1, hMoR2, hMoR3, hMoR4, hMoR5);

				sMediaRemove.setTitle("Removing Movie");
			}

			else if (mediaTypeRe.getValue().equals("Game")) {

				hGaR1.setAlignment(Pos.CENTER);
				hGaR2.setAlignment(Pos.CENTER);
				hGaR3.setAlignment(Pos.CENTER);
				hGaR4.setAlignment(Pos.CENTER);
				hGaR5.setAlignment(Pos.CENTER);

				mediaRe.setPadding(new Insets(30));
				
				bGa1.setContentDisplay(ContentDisplay.LEFT);
				//Effect for Button
				bGa1.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e1) -> {
					bGa1.setEffect(shadow);
				});
				bGa1.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e1) -> {
					bGa1.setEffect(null);
				});
				//Action for Remove Button
				bGa1.setOnAction(e2 -> {
					//Check if the text is not empty
					if (tGa1.getText() != "") {
						String code;
						code = tGa1.getText();
						//Check if Media is exist
						int l = -1;
						for (int p = 0; p < mRm.getMedia().size(); p++) {
							if (mRm.getMedia().get(p).getCode().equals(code)) {
								l = p;
							}
						}
						if (l != -1 && mRm.getMedia().get(l) instanceof Game) {
							mRm.getMedia().remove(l);
							tGa1.setText("");
							tGa2.setText("");
							tGa3.setText("");
							tGa4.setText("");
							alert.setContentText("The madia removed successfully");
							alert.showAndWait();
						} else {
							alert.setContentText("The madia does not exist");
							alert.showAndWait();
						}
					} else {
						alert.setContentText("Please Enter Code");
						alert.showAndWait();
					}
				});
				//Make TextArea ineffective
				tGa2.setEditable(false);
				tGa3.setEditable(false);
				tGa4.setEditable(false);
				
				bGa3.setContentDisplay(ContentDisplay.LEFT);
				//Effect for Button
				bGa3.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e1) -> {
					bGa3.setEffect(shadow);
				});
				bGa3.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e1) -> {
					bGa3.setEffect(null);
				});
				//Action for Search Button
				bGa3.setOnAction(e3 -> {
					//Check if the text is not empty
					if (tGa1.getText() != "") {
						String code;
						code = tGa1.getText();
						//Check if media is exist
						int l = -1;
						for (int p = 0; p < mRm.getMedia().size(); p++) {
							if (mRm.getMedia().get(p).getCode().equals(code)) {
								l = p;
							}
						}
						if (l != -1 && mRm.getMedia().get(l) instanceof Game) {
							tGa2.setText(mRm.getMedia().get(l).getTitle());
							tGa3.setText(mRm.getMedia().get(l).getCopiesAvailable() + "");
							tGa4.setText(((Game) mRm.getMedia().get(l)).getWeight() + "");

						} else {
							alert.setContentText("The madia does not exist");
							alert.showAndWait();
						}
					} else {
						alert.setContentText("Please Enter Code");
						alert.showAndWait();
					}
				});

				bGa2.setContentDisplay(ContentDisplay.LEFT);
				//Effect for Button
				bGa2.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e1) -> {
					bGa2.setEffect(shadow);
				});
				bGa2.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e1) -> {
					bGa2.setEffect(null);
				});
				//Action for Back Button
				bGa2.setOnAction(e1 -> {
					media(sMediaRemove, sMediaRemoveScene);
				});

				bGa1.setMinSize(200, 30);
				bGa2.setMinSize(200, 30);
				bGa3.setMinSize(200, 30);

				lGa1.setFont(myfont2);
				lGA2.setFont(myfont2);
				lGa3.setFont(myfont2);
				lGa4.setFont(myfont2);

				lGa1.setMinSize(250, 30);
				lGA2.setMinSize(250, 30);
				lGa3.setMinSize(250, 30);
				lGa4.setMinSize(250, 30);

				tGa1.setMinSize(200, 30);
				tGa2.setMinSize(200, 30);
				tGa3.setMinSize(200, 30);
				tGa4.setMinSize(200, 30);
				//Add content to display
				mediaRe.getChildren().addAll(hGaR1, hGaR2, hGaR3, hGaR4, hGaR5);

				sMediaRemove.setTitle("Removing Game");

			} else if (mediaTypeRe.getValue().equals("Album")) {

				hAlR1.setAlignment(Pos.CENTER);
				hAlR2.setAlignment(Pos.CENTER);
				hAlR3.setAlignment(Pos.CENTER);
				hAlR4.setAlignment(Pos.CENTER);
				hAlR5.setAlignment(Pos.CENTER);
				hAlR6.setAlignment(Pos.CENTER);

				mediaRe.setPadding(new Insets(30));
				
				bAl1.setContentDisplay(ContentDisplay.LEFT);
				//Effect for Button
				bAl1.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e1) -> {
					bAl1.setEffect(shadow);
				});
				bAl1.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e1) -> {
					bAl1.setEffect(null);
				});
				//Action for Remove Button
				bAl1.setOnAction(e2 -> {
					//Check if the text is not empty
					if (tAl1.getText() != "") {
						String code;
						code = tAl1.getText();
						//Check if Media is exist
						int l = -1;
						for (int p = 0; p < mRm.getMedia().size(); p++) {
							if (mRm.getMedia().get(p).getCode().equals(code)) {
								l = p;
							}
						}
						if (l != -1 && mRm.getMedia().get(l) instanceof Album) {
							mRm.getMedia().remove(l);
							tAl1.setText("");
							tAl2.setText("");
							tAl3.setText("");
							tAl4.setText("");
							tAl5.setText("");
							alert.setContentText("The madia removed successfully");
							alert.showAndWait();
						} else {
							alert.setContentText("The madia does not exist");
							alert.showAndWait();
						}
					} else {
						alert.setContentText("Please Enter Code");
						alert.showAndWait();
					}
				});

				bAl2.setContentDisplay(ContentDisplay.LEFT);
				//Effect for Button
				bAl2.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e1) -> {
					bAl2.setEffect(shadow);
				});
				bAl2.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e1) -> {
					bAl2.setEffect(null);
				});
				//Action for Back Button
				bAl2.setOnAction(e1 -> {
					media(sMediaRemove, sMediaRemoveScene);
				});
				//Make TextArea ineffective
				tAl2.setEditable(false);
				tAl3.setEditable(false);
				tAl4.setEditable(false);
				tAl5.setEditable(false);

				bAl3.setContentDisplay(ContentDisplay.LEFT);
				//Effect for Button
				bAl3.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e1) -> {
					bAl3.setEffect(shadow);
				});
				bAl3.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e1) -> {
					bAl3.setEffect(null);
				});
				//Action for Search Button
				bAl3.setOnAction(e3 -> {
					//Check if the text is not empty
					if (tAl1.getText() != "") {
						String code;
						code = tAl1.getText();
						//Check if media is exist
						int l = -1;
						for (int p = 0; p < mRm.getMedia().size(); p++) {
							if (mRm.getMedia().get(p).getCode().equals(code)) {
								l = p;
							}
						}
						if (l != -1 && mRm.getMedia().get(l) instanceof Album) {
							tAl2.setText(mRm.getMedia().get(l).getTitle());
							tAl3.setText(mRm.getMedia().get(l).getCopiesAvailable() + "");
							tAl4.setText(((Album) mRm.getMedia().get(l)).getArtist());
							tAl5.setText(((Album) mRm.getMedia().get(l)).getSongs());

						} else {
							alert.setContentText("The madia does not exist");
							alert.showAndWait();
						}
					} else {
						alert.setContentText("Please Enter Code");
						alert.showAndWait();
					}
				});
				bAl1.setMinSize(200, 30);
				bAl2.setMinSize(200, 30);
				bAl3.setMinSize(200, 30);

				lAl1.setFont(myfont2);
				lAl2.setFont(myfont2);
				lAl3.setFont(myfont2);
				lAl4.setFont(myfont2);
				lAl5.setFont(myfont2);

				lAl1.setMinSize(250, 30);
				lAl2.setMinSize(250, 30);
				lAl3.setMinSize(250, 30);
				lAl4.setMinSize(250, 30);
				lAl5.setMinSize(250, 30);

				tAl1.setMinSize(200, 30);
				tAl2.setMinSize(200, 30);
				tAl3.setMinSize(200, 30);
				tAl4.setMinSize(200, 30);
				tAl5.setMinSize(200, 30);
				//Add content to display
				mediaRe.getChildren().addAll(hAlR1, hAlR2, hAlR3, hAlR4, hAlR5, hAlR6);

				sMediaRemove.setTitle("Removing Album");
			}

		});

	}

	
	public static void updatInfoMedia(Stage sMediaUpdate, Scene sMediaUpdateScene) {
		sMediaUpdate.setTitle("Update Information about Media");
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("alerts");
		alert.setHeaderText(null);
		//Media update Panes and ComboBox
		ComboBox<String> mediaTypeUpdate = new ComboBox<>();
		mediaTypeUpdate.setPromptText("Choose the type of media");
		mediaTypeUpdate.getItems().addAll("Movie", "Game", "Album");
		HBox hMU0 = new HBox(80);
		//Setting the image for the back Button
		Image image = new Image("back.png");
		ImageView mediaim = new ImageView(image);
		mediaim.setFitHeight(30);
		mediaim.setFitWidth(30);
		//Back Button
		Button bM = new Button("Back",mediaim);
		DropShadow shadow = new DropShadow();
		bM.setContentDisplay(ContentDisplay.LEFT);
		//Effect for Button
		bM.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e1) -> {
			bM.setEffect(shadow);
		});
		bM.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e1) -> {
			bM.setEffect(null);
		});
		//Action for Back Button
		bM.setOnAction(e1 -> {
			media(sMediaUpdate, sMediaUpdateScene);
		});
		//Movie update Panes
		HBox hMoU1 = new HBox(80);
		HBox hMoU2 = new HBox(80);
		HBox hMoU3 = new HBox(80);
		HBox hMoU4 = new HBox(55);
		HBox hMoU5 = new HBox(80);
		//Movie update Labels
		Label lMo1 = new Label("Movie Code:");
		Label lMo2 = new Label("Movie Title:");
		Label lMo3 = new Label("Movie Copies Available:");
		Label lMo4 = new Label("Movie Rating:");
		//Movie update TextFields and RadioButtons
		TextField tMo1 = new TextField();
		TextField tMo2 = new TextField();
		TextField tMo3 = new TextField();
		RadioButton rMo1 = new RadioButton("DR");
		RadioButton rMo2 = new RadioButton("HR");
		RadioButton rMo3 = new RadioButton("AC");
		//Setting the image for the update Button,search Button and back Button
		Image image2 = new Image("update.png");
		ImageView mediaim2 = new ImageView(image2);
		mediaim2.setFitHeight(30);
		mediaim2.setFitWidth(30);
		Image image3 = new Image("back.png");
		ImageView medieim3 = new ImageView(image3);
		medieim3.setFitHeight(30);
		medieim3.setFitWidth(30);
		Image image4 = new Image("search.png");
		ImageView mediaim4 = new ImageView(image4);
		mediaim4.setFitHeight(30);
		mediaim4.setFitWidth(30);
		//Movie update Buttons
		Button bMo1 = new Button("Update Information",mediaim2);
		Button bMo2 = new Button("Back",medieim3);
		Button bMo3 = new Button("Find",mediaim4);
		//Game update Panes
		HBox hGaU1 = new HBox(80);
		HBox hGaU2 = new HBox(80);
		HBox hGaU3 = new HBox(80);
		HBox hGaU4 = new HBox(80);
		HBox hGaU5 = new HBox(80);
		//Game update Labels
		Label lGa1 = new Label("Game Code:");
		Label lGA2 = new Label("Game Title:");
		Label lGa3 = new Label("Game Copies Available:");
		Label lGa4 = new Label("Game Weight(gm):");
		//Game update TextFields
		TextField tGa1 = new TextField();
		TextField tGa2 = new TextField();
		TextField tGa3 = new TextField();
		TextField tGa4 = new TextField();
		//Setting the image for the update Button,search Button and back Button
		Image image5 = new Image("update.png");
		ImageView mediaim5 = new ImageView(image5);
		mediaim5.setFitHeight(30);
		mediaim5.setFitWidth(30);
		Image image6 = new Image("back.png");
		ImageView medieim6 = new ImageView(image6);
		medieim6.setFitHeight(30);
		medieim6.setFitWidth(30);
		Image image7 = new Image("search.png");
		ImageView mediaim7 = new ImageView(image7);
		mediaim7.setFitHeight(30);
		mediaim7.setFitWidth(30);
		//Game update Buttons
		Button bGa1 = new Button("Update Information",mediaim5);
		Button bGa2 = new Button("Back",medieim6);
		Button bGa3 = new Button("Fine",mediaim7);
		//Album update Panes
		HBox hAlU1 = new HBox(80);
		HBox hAlU2 = new HBox(80);
		HBox hAlU3 = new HBox(80);
		HBox hAlU4 = new HBox(80);
		HBox hAlU5 = new HBox(80);
		HBox hAlU6 = new HBox(80);
		//Album update Labels
		Label lAl1 = new Label("Album Code:");
		Label lAl2 = new Label("Album Title:");
		Label lAl3 = new Label("Album Copies Available:");
		Label lAl4 = new Label("Album artist:");
		Label lAl5 = new Label("Album songs:");
		//Album update TextFields
		TextField tAl1 = new TextField();
		TextField tAl2 = new TextField();
		TextField tAl3 = new TextField();
		TextField tAl4 = new TextField();
		TextField tAl5 = new TextField();
		//Setting the image for the update Button,search Button and back Button
		Image image8 = new Image("update.png");
		ImageView mediaim8 = new ImageView(image8);
		mediaim8.setFitHeight(30);
		mediaim8.setFitWidth(30);
		Image image9 = new Image("back.png");
		ImageView medieim9 = new ImageView(image9);
		medieim9.setFitHeight(30);
		medieim9.setFitWidth(30);
		Image image10 = new Image("search.png");
		ImageView mediaim10 = new ImageView(image10);
		mediaim10.setFitHeight(30);
		mediaim10.setFitWidth(30);
		//Album update Buttons
		Button bAl1 = new Button("Update Information",mediaim8);
		Button bAl2 = new Button("Back",medieim9);
		Button bAl3 = new Button("Find",mediaim10);

		hMU0.setAlignment(Pos.CENTER);

		VBox mediaUP = new VBox(40);

		Label lMU0 = new Label("Media Type:");

		Font myfont2 = Font.font("Time new Roman", FontWeight.BOLD, FontPosture.REGULAR, 20);

		lMU0.setFont(myfont2);
		lMU0.setMinSize(250, 30);

		mediaTypeUpdate.setMinSize(200, 30);

		hMU0.getChildren().addAll(lMU0, mediaTypeUpdate);

		mediaUP.getChildren().addAll(hMU0, bM);
		mediaUP.setAlignment(Pos.CENTER);
		//View content
		sMediaUpdateScene.setRoot(mediaUP);
		sMediaUpdate.show();

		alert.setContentText("Note:For Search Enter the Code and press Find button \n Please enter the information in order and complete, otherwise the Update button will not work");
		alert.showAndWait();
		//Screen Format
		//Add content to display
		hMoU1.getChildren().addAll(lMo1, tMo1);
		hMoU2.getChildren().addAll(lMo2, tMo2);
		hMoU3.getChildren().addAll(lMo3, tMo3);
		hMoU4.getChildren().addAll(lMo4, rMo1, rMo2, rMo3);
		hMoU5.getChildren().addAll(bMo3, bMo1, bMo2);

		hGaU1.getChildren().addAll(lGa1, tGa1);
		hGaU2.getChildren().addAll(lGA2, tGa2);
		hGaU3.getChildren().addAll(lGa3, tGa3);
		hGaU4.getChildren().addAll(lGa4, tGa4);
		hGaU5.getChildren().addAll(bGa3, bGa1, bGa2);

		hAlU1.getChildren().addAll(lAl1, tAl1);
		hAlU2.getChildren().addAll(lAl2, tAl2);
		hAlU3.getChildren().addAll(lAl3, tAl3);
		hAlU4.getChildren().addAll(lAl4, tAl4);
		hAlU5.getChildren().addAll(lAl5, tAl5);
		hAlU6.getChildren().addAll(bAl3, bAl1, bAl2);
		mediaTypeUpdate.setOnAction(e -> {
			//Delete previous content to display the new
			mediaUP.getChildren().remove(bM);
			mediaUP.getChildren().removeAll(hMoU1, hMoU2, hMoU3, hMoU4, hMoU5);
			mediaUP.getChildren().removeAll(hGaU1, hGaU2, hGaU3, hGaU4, hGaU5);
			mediaUP.getChildren().removeAll(hAlU1, hAlU2, hAlU3, hAlU4, hAlU5, hAlU6);

			if (mediaTypeUpdate.getValue().equals("Movie")) {

				hMoU1.setAlignment(Pos.CENTER);
				hMoU2.setAlignment(Pos.CENTER);
				hMoU3.setAlignment(Pos.CENTER);
				hMoU4.setAlignment(Pos.CENTER);
				hMoU5.setAlignment(Pos.CENTER);

				mediaUP.setPadding(new Insets(30));

				ToggleGroup t = new ToggleGroup();

				rMo1.setToggleGroup(t);
				rMo2.setToggleGroup(t);
				rMo3.setToggleGroup(t);
				//Make TextField ineffective
				tMo2.setEditable(false);
				tMo3.setEditable(false);
				//Make RadioButton ineffective
				rMo1.setVisible(false);
				rMo2.setVisible(false);
				rMo3.setVisible(false);

				bMo1.setContentDisplay(ContentDisplay.LEFT);
				//Effect for Button
				bMo1.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e1) -> {
					bMo1.setEffect(shadow);
				});
				bMo1.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e1) -> {
					bMo1.setEffect(null);
				});
				//Make TextField and RadioButton ineffective
				tMo2.setEditable(false);
				tMo3.setEditable(false);
				rMo1.setVisible(false);
				rMo2.setVisible(false);
				rMo3.setVisible(false);
				//Make the input effective in order
				tMo1.setOnKeyTyped(e2 -> {
					if (tMo1.getText() != "") {
						tMo2.setEditable(true);
						tMo2.setOnKeyTyped(e3 -> {
							if (tMo2.getText() != "")
								tMo3.setEditable(true);
							tMo3.setOnKeyTyped(e4 -> {
								if (tMo3.getText() != "") {
									rMo1.setVisible(true);
									rMo2.setVisible(true);
									rMo3.setVisible(true);
								}
							});
						});
					}
				});
				//Action for Update Button
				bMo1.setOnAction(e2 -> {
					//Check if the texts are not empty
					if (tMo1.getText() != "" && tMo2.getText() != "" && tMo3.getText() != ""&& (rMo1.isSelected() || rMo2.isSelected() || rMo3.isSelected())) {
						//Check the input if it is valid
						char[] na = tMo3.getText().toCharArray();
						boolean digit = false;
						for (int j = 0; j < na.length; j++) {
							if (Character.isDigit(na[j])) {
								digit = true;
							} else {
								digit = false;
								break;
							}
						}
						if (digit) {
							String code;
							code = tMo1.getText();
							//Check if media is exist
							int l = -1;
							for (int p = 0; p < mRm.getMedia().size(); p++) {
								if (mRm.getMedia().get(p).getCode().equals(code)) {
									l = p;
								}
							}
							if (l != -1 && mRm.getMedia().get(l) instanceof Movie) {
								mRm.getMedia().get(l).setTitle(tMo2.getText());
								mRm.getMedia().get(l).setCopiesAvailable(Integer.parseInt(tMo3.getText()));
								if (rMo1.isSelected()) {
									((Movie) mRm.getMedia().get(l)).setRating("DR");
								}
								if (rMo2.isSelected()) {
									((Movie) mRm.getMedia().get(l)).setRating("HR");
								}
								if (rMo3.isSelected()) {
									((Movie) mRm.getMedia().get(l)).setRating("AC");
								}
								alert.setContentText("The madia Updated successfully");
								alert.showAndWait();
							} else {
								alert.setContentText("The madia does not exist");
								alert.showAndWait();
							}
						} else {
							alert.setContentText("Please enter Positive copies number without positive and negative symbols");
							alert.showAndWait();
						}

					} else {
						alert.setContentText("Please Enter All Information");
						alert.showAndWait();
					}
				});
				bMo2.setContentDisplay(ContentDisplay.LEFT);
				//Effect for Button
				bMo2.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e1) -> {
					bMo2.setEffect(shadow);
				});
				bMo2.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e1) -> {
					bMo2.setEffect(null);
				});
				//Action for Back Button
				bMo2.setOnAction(e1 -> {
					media(sMediaUpdate, sMediaUpdateScene);
				});
				bMo3.setContentDisplay(ContentDisplay.LEFT);
				//Effect for Button
				bMo3.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e1) -> {
					bMo3.setEffect(shadow);
				});
				bMo3.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e1) -> {
					bMo3.setEffect(null);
				});
				//Action for Find Button
				bMo3.setOnAction(e3 -> {
					//Check if the text is not empty
					if (tMo1.getText() != "") {
						tMo2.setEditable(true);
						tMo3.setEditable(true);
						rMo1.setVisible(true);
						rMo2.setVisible(true);
						rMo3.setVisible(true);

						String code;
						code = tMo1.getText();
						//Check if media is exist
						int l = -1;
						for (int p = 0; p < mRm.getMedia().size(); p++) {
							if (mRm.getMedia().get(p).getCode().equals(code)) {
								l = p;
							}
						}
						if (l != -1 && mRm.getMedia().get(l) instanceof Movie) {
							tMo2.setText(mRm.getMedia().get(l).getTitle());
							tMo3.setText(mRm.getMedia().get(l).getCopiesAvailable() + "");
							if (((Movie) mRm.getMedia().get(l)).getRating().equalsIgnoreCase("DR")) {
								rMo1.setSelected(true);
							}
							if (((Movie) mRm.getMedia().get(l)).getRating().equalsIgnoreCase("HR")) {
								rMo2.setSelected(true);
							}
							if (((Movie) mRm.getMedia().get(l)).getRating().equalsIgnoreCase("AC")) {
								rMo3.setSelected(true);
							}

						}
						else {
							alert.setContentText("The madia does not exist");
							alert.showAndWait();
						}
					} else {
						alert.setContentText("Please Enter Code");
						alert.showAndWait();
					}

				});

				bMo1.setMinSize(200, 30);
				bMo2.setMinSize(200, 30);
				bMo3.setMinSize(200, 30);

				lMo1.setFont(myfont2);
				lMo2.setFont(myfont2);
				lMo3.setFont(myfont2);
				lMo4.setFont(myfont2);

				lMo1.setMinSize(250, 30);
				lMo2.setMinSize(250, 30);
				lMo3.setMinSize(250, 30);
				lMo4.setMinSize(250, 30);

				tMo1.setMinSize(200, 30);
				tMo2.setMinSize(200, 30);
				tMo3.setMinSize(200, 30);
				//Add content to display
				mediaUP.getChildren().addAll(hMoU1, hMoU2, hMoU3, hMoU4, hMoU5);

				sMediaUpdate.setTitle("Update Information Movie");
			}

			else if (mediaTypeUpdate.getValue().equals("Game")) {

				hGaU1.setAlignment(Pos.CENTER);
				hGaU2.setAlignment(Pos.CENTER);
				hGaU3.setAlignment(Pos.CENTER);
				hGaU4.setAlignment(Pos.CENTER);
				hGaU5.setAlignment(Pos.CENTER);

				mediaUP.setPadding(new Insets(30));

				bGa1.setContentDisplay(ContentDisplay.LEFT);
				//Effect for Button
				bGa1.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e1) -> {
					bGa1.setEffect(shadow);
				});
				bGa1.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e1) -> {
					bGa1.setEffect(null);
				});
				//Make TextField ineffective
				tGa2.setEditable(false);
				tGa3.setEditable(false);
				tGa4.setEditable(false);
				//Make the input effective in order
				tGa1.setOnKeyTyped(e2 -> {
					if (tGa1.getText() != "") {
						tGa2.setEditable(true);
						tGa2.setOnKeyTyped(e3 -> {
							if (tGa2.getText() != "")
								tGa3.setEditable(true);
							tGa3.setOnKeyTyped(e4 -> {
								if (tGa3.getText() != "") {
									tGa4.setEditable(true);
								}
							});
						});
					}
				});
				//Action for Update Button
				bGa1.setOnAction(e2 -> {
					//Check if the texts are not empty
					if (tGa1.getText() != "" && tGa2.getText() != "" && tGa3.getText() != "" && tGa4.getText() != "") {
						char[] na = tGa3.getText().toCharArray();
						boolean digit = false;
						//Check the inputs if They are valid
						for (int j = 0; j < na.length; j++) {
							if (Character.isDigit(na[j])) {
								digit = true;
							} else {
								digit = false;
								break;
							}
						}
						char[] na2 = tGa4.getText().toCharArray();
						boolean digit1 = false;
						char point = '.';
						for (int j = 0; j < na2.length; j++) {
							if (Character.isDigit(na2[j]) || na2[j] == point) {
								digit1 = true;
							} else {
								digit1 = false;
								break;
							}
						}
						if (digit && digit1) {
							String code;
							code = tGa1.getText();
							//Check if media is exist
							int l = -1;
							for (int p = 0; p < mRm.getMedia().size(); p++) {
								if (mRm.getMedia().get(p).getCode().equals(code)) {
									l = p;
								}
							}
							if (l != -1 && mRm.getMedia().get(l) instanceof Game) {
								mRm.getMedia().get(l).setTitle(tGa2.getText());
								mRm.getMedia().get(l).setCopiesAvailable(Integer.parseInt(tGa3.getText()));
								((Game) mRm.getMedia().get(l)).setWeight(Double.parseDouble(tGa4.getText()));
								alert.setContentText("The madia Updated successfully");
								alert.showAndWait();
							} else {
								alert.setContentText("The madia does not exist");
								alert.showAndWait();
							}

						} else {
							alert.setContentText(
									"Please enter Positive copies number Example(5) and weight Example(5.6) without positive and negative symbols");
							alert.showAndWait();
						}
					} else {
						alert.setContentText("Please enter All information");
						alert.showAndWait();
					}
				});
				bGa2.setContentDisplay(ContentDisplay.LEFT);
				//Effect for Button
				bGa2.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e1) -> {
					bGa2.setEffect(shadow);
				});
				bGa2.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e1) -> {
					bGa2.setEffect(null);
				});
				//Action for Back Button
				bGa2.setOnAction(e1 -> {
					media(sMediaUpdate, sMediaUpdateScene);
				});

				bGa3.setContentDisplay(ContentDisplay.LEFT);
				//Effect for Button
				bGa3.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e1) -> {
					bGa3.setEffect(shadow);
				});
				bGa3.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e1) -> {
					bGa3.setEffect(null);
				});
				//Action for Find Button
				bGa3.setOnAction(e3 -> {
					//Check if the text is not empty
					if (tGa1.getText() != "") {
						tGa2.setEditable(true);
						tGa3.setEditable(true);
						tGa4.setEditable(true);
						String code;
						code = tGa1.getText();
						//Check if media is exist
						int l = -1;
						for (int p = 0; p < mRm.getMedia().size(); p++) {
							if (mRm.getMedia().get(p).getCode().equals(code)) {
								l = p;
							}
						}
						if (l != -1 && mRm.getMedia().get(l) instanceof Game) {
							tGa2.setText(mRm.getMedia().get(l).getTitle());
							tGa3.setText(mRm.getMedia().get(l).getCopiesAvailable() + "");
							tGa4.setText(((Game) mRm.getMedia().get(l)).getWeight() + "");

						} else {
							alert.setContentText("The madia does not exist");
							alert.showAndWait();
						}
					} else {
						alert.setContentText("Please Enter Code");
						alert.showAndWait();
					}
				});

				bGa1.setMinSize(200, 30);
				bGa2.setMinSize(200, 30);
				bGa3.setMinSize(200, 30);

				lGa1.setFont(myfont2);
				lGA2.setFont(myfont2);
				lGa3.setFont(myfont2);
				lGa4.setFont(myfont2);

				lGa1.setMinSize(250, 30);
				lGA2.setMinSize(250, 30);
				lGa3.setMinSize(250, 30);
				lGa4.setMinSize(250, 30);

				tGa1.setMinSize(200, 30);
				tGa2.setMinSize(200, 30);
				tGa3.setMinSize(200, 30);
				tGa4.setMinSize(200, 30);
				//Add content to display
				mediaUP.getChildren().addAll(hGaU1, hGaU2, hGaU3, hGaU4, hGaU5);

				sMediaUpdate.setTitle("Update Information Game");

			} else if (mediaTypeUpdate.getValue().equals("Album")) {

				hAlU1.setAlignment(Pos.CENTER);
				hAlU2.setAlignment(Pos.CENTER);
				hAlU3.setAlignment(Pos.CENTER);
				hAlU4.setAlignment(Pos.CENTER);
				hAlU5.setAlignment(Pos.CENTER);
				hAlU6.setAlignment(Pos.CENTER);

				mediaUP.setPadding(new Insets(30));
				bAl1.setContentDisplay(ContentDisplay.LEFT);
				//Effect for Button
				bAl1.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e1) -> {
					bAl1.setEffect(shadow);
				});
				bAl1.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e1) -> {
					bAl1.setEffect(null);
				});
				//Make TextField ineffective
				tAl2.setEditable(false);
				tAl3.setEditable(false);
				tAl4.setEditable(false);
				tAl5.setEditable(false);
				//Make the input effective in order
				tAl1.setOnKeyTyped(e2 -> {
					if (tAl1.getText() != "") {
						tAl2.setEditable(true);
						tAl2.setOnKeyTyped(e3 -> {
							if (tAl2.getText() != "")
								tAl3.setEditable(true);
							tAl3.setOnKeyTyped(e4 -> {
								if (tAl3.getText() != "") {
									tAl4.setEditable(true);
								}
								tAl4.setOnKeyTyped(e5 -> {
									if (tAl4.getText() != "") {
										tAl5.setEditable(true);
									}
								});
							});
						});
					}
				});
				//Action for Update Button
				bAl1.setOnAction(e2 -> {
					//Check if the texts are not empty
					if (tAl1.getText() != "" && tAl2.getText() != "" && tAl3.getText() != "" && tAl4.getText() != ""&& tAl5.getText() != "") {
						char[] na = tAl3.getText().toCharArray();
						//Check the input if it is valid
						boolean digit = false;
						for (int j = 0; j < na.length; j++) {
							if (Character.isDigit(na[j])) {
								digit = true;
							} else {
								digit = false;
								break;
							}
						}
						if (digit) {
							String code;
							code = tAl1.getText();
							//Check if media is exist
							int l = -1;
							for (int p = 0; p < mRm.getMedia().size(); p++) {
								if (mRm.getMedia().get(p).getCode().equals(code)) {
									l = p;
								}
							}
							if (l != -1 && mRm.getMedia().get(l) instanceof Album) {
								mRm.getMedia().get(l).setTitle(tAl2.getText());
								mRm.getMedia().get(l).setCopiesAvailable(Integer.parseInt(tAl3.getText()));
								((Album) mRm.getMedia().get(l)).setArtist(tAl4.getText());
								((Album) mRm.getMedia().get(l)).setSongs(tAl5.getText());

								alert.setContentText("The madia Updated successfully");
								alert.showAndWait();
							}
						} else {
							alert.setContentText("Please enter Positive copies number Example(5) without positive and negative symbols");
							alert.showAndWait();
						}
					} else {
						alert.setContentText("Please enter All information");
						alert.showAndWait();
					}
				});
				bAl2.setContentDisplay(ContentDisplay.LEFT);
				//Effect for Button
				bAl2.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e1) -> {
					bAl2.setEffect(shadow);
				});
				bAl2.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e1) -> {
					bAl2.setEffect(null);
				});
				//Action for Back Button
				bAl2.setOnAction(e1 -> {
					media(sMediaUpdate, sMediaUpdateScene);
				});
				bAl3.setContentDisplay(ContentDisplay.LEFT);
				//Effect for Button
				bAl3.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e1) -> {
					bAl3.setEffect(shadow);
				});
				bAl3.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e1) -> {
					bAl3.setEffect(null);
				});
				//Action for Find Button
				bAl3.setOnAction(e3 -> {
					//Check if the text is not empty
					if (tAl1.getText() != "") {
						tAl2.setEditable(true);
						tAl3.setEditable(true);
						tAl4.setEditable(true);
						tAl5.setEditable(true);
						String code;
						code = tAl1.getText();
						//Check if media is exist
						int l = -1;
						for (int p = 0; p < mRm.getMedia().size(); p++) {
							if (mRm.getMedia().get(p).getCode().equals(code)) {
								l = p;
							}
						}
						if (l != -1 && mRm.getMedia().get(l) instanceof Album) {
							tAl2.setText(mRm.getMedia().get(l).getTitle());
							tAl3.setText(mRm.getMedia().get(l).getCopiesAvailable() + "");
							tAl4.setText(((Album) mRm.getMedia().get(l)).getArtist());
							tAl5.setText(((Album) mRm.getMedia().get(l)).getSongs());

						} else {
							alert.setContentText("The madia does not exist");
							alert.showAndWait();
						}
					} else {
						alert.setContentText("Please Enter Code");
						alert.showAndWait();
					}
				});

				bAl1.setMinSize(200, 30);
				bAl2.setMinSize(200, 30);
				bAl3.setMinSize(200, 30);

				lAl1.setFont(myfont2);
				lAl2.setFont(myfont2);
				lAl3.setFont(myfont2);
				lAl4.setFont(myfont2);
				lAl5.setFont(myfont2);

				lAl1.setMinSize(250, 30);
				lAl2.setMinSize(250, 30);
				lAl3.setMinSize(250, 30);
				lAl4.setMinSize(250, 30);
				lAl5.setMinSize(250, 30);

				tAl1.setMinSize(200, 30);
				tAl2.setMinSize(200, 30);
				tAl3.setMinSize(200, 30);
				tAl4.setMinSize(200, 30);
				tAl5.setMinSize(200, 30);
				//Add content to display
				mediaUP.getChildren().addAll(hAlU1, hAlU2, hAlU3, hAlU4, hAlU5, hAlU6);

				sMediaUpdate.setTitle("Update Information Album");

				alert.setContentText("Please enter the names of the songs with a comma between them when you Update the Information");
				alert.showAndWait();
			}

		});

	}

	
	public static void searchMedia(Stage sMediaSer, Scene sMediaSerScene) {
		sMediaSer.setTitle("Search a Media by Code");
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("alerts");
		alert.setHeaderText(null);
		//Media search Panes and ComboBox
		ComboBox<String> mediaTypeSer = new ComboBox<>();
		mediaTypeSer.setPromptText("Choose the type of media");
		mediaTypeSer.getItems().addAll("Movie", "Game", "Album");
		HBox hMS0 = new HBox(80);
		//Setting the image for the back Button
		Image image = new Image("back.png");
		ImageView mediaim = new ImageView(image);
		mediaim.setFitHeight(30);
		mediaim.setFitWidth(30);
		//Back Button
		Button bM = new Button("Back",mediaim);
		DropShadow shadow = new DropShadow();
		bM.setContentDisplay(ContentDisplay.LEFT);
		//Effect for Button
		bM.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e1) -> {
			bM.setEffect(shadow);
		});
		bM.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e1) -> {
			bM.setEffect(null);
		});
		//Action for Back Button
		bM.setOnAction(e1 -> {
			media(sMediaSer, sMediaSerScene);
		});
		//Movie search Panes
		HBox hMoS1 = new HBox(80);
		HBox hMoS2 = new HBox(80);
		HBox hMoS3 = new HBox(80);
		HBox hMoS4 = new HBox(80);
		HBox hMoS5 = new HBox(80);
		//Movie search Labels
		Label lMo1 = new Label("Movie Code:");
		Label lMo2 = new Label("Movie Title:");
		Label lMo3 = new Label("Movie Copies Available:");
		Label lMo4 = new Label("Movie Rating:");
		//Movie search TextFields and TextAreas
		TextField tMo1 = new TextField();
		TextArea tMo2 = new TextArea();
		TextArea tMo3 = new TextArea();
		TextArea tMo4 = new TextArea();

		tMo2.setMaxSize(65, 25);
		tMo3.setMaxSize(65, 25);
		tMo4.setMaxSize(65, 25);
		//Setting the image for the search Button and back Button
		Image image2 = new Image("search.png");
		ImageView mediaim2 = new ImageView(image2);
		mediaim2.setFitHeight(30);
		mediaim2.setFitWidth(30);
		Image image3 = new Image("back.png");
		ImageView medieim3 = new ImageView(image3);
		medieim3.setFitHeight(30);
		medieim3.setFitWidth(30);
		//Movie search Buttons
		Button bMo1 = new Button("Search a Media",mediaim2);
		Button bMo2 = new Button("Back",medieim3);
		//Game search Panes
		HBox hGaS1 = new HBox(80);
		HBox hGaS2 = new HBox(80);
		HBox hGaS3 = new HBox(80);
		HBox hGaS4 = new HBox(80);
		HBox hGaS5 = new HBox(80);
		//Game search Labels
		Label lGa1 = new Label("Game Code:");
		Label lGA2 = new Label("Game Title:");
		Label lGa3 = new Label("Game Copies Available:");
		Label lGa4 = new Label("Game Weight(gm):");
		//Game search TextFields and TextAreas
		TextField tGa1 = new TextField();
		TextArea tGa2 = new TextArea();
		TextArea tGa3 = new TextArea();
		TextArea tGa4 = new TextArea();

		tGa2.setMaxSize(65, 25);
		tGa3.setMaxSize(65, 25);
		tGa4.setMaxSize(65, 25);
		//Setting the image for the search Button and back Button
		Image image4 = new Image("search.png");
		ImageView mediaim4 = new ImageView(image4);
		mediaim4.setFitHeight(30);
		mediaim4.setFitWidth(30);
		Image image5 = new Image("back.png");
		ImageView medieim5 = new ImageView(image5);
		medieim5.setFitHeight(30);
		medieim5.setFitWidth(30);
		//Game search Buttons
		Button bGa1 = new Button("Search a Media",mediaim4);
		Button bGa2 = new Button("Back",medieim5);
		//Album search Panes
		HBox hAlS1 = new HBox(80);
		HBox hAlS2 = new HBox(80);
		HBox hAlS3 = new HBox(80);
		HBox hAlS4 = new HBox(80);
		HBox hAlS5 = new HBox(80);
		HBox hAlS6 = new HBox(80);
		//Album search Labels
		Label lAl1 = new Label("Album Code:");
		Label lAl2 = new Label("Album Title:");
		Label lAl3 = new Label("Album Copies Available:");
		Label lAl4 = new Label("Album artist:");
		Label lAl5 = new Label("Album songs:");
		//Album search TextFields and TextAreas
		TextField tAl1 = new TextField();
		TextArea tAl2 = new TextArea();
		TextArea tAl3 = new TextArea();
		TextArea tAl4 = new TextArea();
		TextArea tAl5 = new TextArea();

		tAl2.setMaxSize(65, 25);
		tAl3.setMaxSize(65, 25);
		tAl4.setMaxSize(65, 25);
		tAl5.setMaxSize(65, 25);
		//Setting the image for the search Button and back Button
		Image image6 = new Image("search.png");
		ImageView mediaim6 = new ImageView(image6);
		mediaim6.setFitHeight(30);
		mediaim6.setFitWidth(30);
		Image image7 = new Image("back.png");
		ImageView medieim7 = new ImageView(image7);
		medieim7.setFitHeight(30);
		medieim7.setFitWidth(30);
		//Album search Buttons
		Button bAl1 = new Button("Search a Media",mediaim6);
		Button bAl2 = new Button("Back",medieim7);

		hMS0.setAlignment(Pos.CENTER);

		VBox mediaSe = new VBox(40);

		Label lMS0 = new Label("Media Type:");

		Font myfont2 = Font.font("Time new Roman", FontWeight.BOLD, FontPosture.REGULAR, 20);

		lMS0.setFont(myfont2);
		lMS0.setMinSize(250, 30);

		mediaTypeSer.setMinSize(200, 30);

		hMS0.getChildren().addAll(lMS0, mediaTypeSer);

		mediaSe.getChildren().addAll(hMS0, bM);
		mediaSe.setAlignment(Pos.CENTER);
		//View content
		sMediaSerScene.setRoot(mediaSe);
		sMediaSer.show();
		alert.setContentText("Note:For Search Enter the id and press Find button");
		alert.showAndWait();
		//Screen Format
		//Add content to display
		hMoS1.getChildren().addAll(lMo1, tMo1);
		hMoS2.getChildren().addAll(lMo2, tMo2);
		hMoS3.getChildren().addAll(lMo3, tMo3);
		hMoS4.getChildren().addAll(lMo4, tMo4);
		hMoS5.getChildren().addAll(bMo1, bMo2);

		hGaS1.getChildren().addAll(lGa1, tGa1);
		hGaS2.getChildren().addAll(lGA2, tGa2);
		hGaS3.getChildren().addAll(lGa3, tGa3);
		hGaS4.getChildren().addAll(lGa4, tGa4);
		hGaS5.getChildren().addAll(bGa1, bGa2);

		hAlS1.getChildren().addAll(lAl1, tAl1);
		hAlS2.getChildren().addAll(lAl2, tAl2);
		hAlS3.getChildren().addAll(lAl3, tAl3);
		hAlS4.getChildren().addAll(lAl4, tAl4);
		hAlS5.getChildren().addAll(lAl5, tAl5);
		hAlS6.getChildren().addAll(bAl1, bAl2);

		mediaTypeSer.setOnAction(e -> {
			//Delete previous content to display the new
			mediaSe.getChildren().remove(bM);
			mediaSe.getChildren().removeAll(hMoS1, hMoS2, hMoS3, hMoS4, hMoS5);
			mediaSe.getChildren().removeAll(hGaS1, hGaS2, hGaS3, hGaS4, hGaS5);
			mediaSe.getChildren().removeAll(hAlS1, hAlS2, hAlS3, hAlS4, hAlS5, hAlS6);

			if (mediaTypeSer.getValue().equals("Movie")) {

				hMoS1.setAlignment(Pos.CENTER);
				hMoS2.setAlignment(Pos.CENTER);
				hMoS3.setAlignment(Pos.CENTER);
				hMoS4.setAlignment(Pos.CENTER);
				hMoS5.setAlignment(Pos.CENTER);

				mediaSe.setPadding(new Insets(30));
				//Make TextArea ineffective
				tMo2.setEditable(false);
				tMo3.setEditable(false);
				tMo4.setEditable(false);

				bMo1.setContentDisplay(ContentDisplay.LEFT);
				//Effect for Button
				bMo1.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e1) -> {
					bMo1.setEffect(shadow);
				});
				bMo1.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e1) -> {
					bMo1.setEffect(null);
				});
				//Action for Search Button
				bMo1.setOnAction(e3 -> {
					//Check if the text is not empty
					if (tMo1.getText() != "") {
						String code;
						code = tMo1.getText();
						//Check if media is exist
						int l = -1;
						for (int p = 0; p < mRm.getMedia().size(); p++) {
							if (mRm.getMedia().get(p).getCode().equals(code)) {
								l = p;
							}
						}
						if (l != -1 && mRm.getMedia().get(l) instanceof Movie) {
							tMo2.setText(mRm.getMedia().get(l).getTitle());
							tMo3.setText(mRm.getMedia().get(l).getCopiesAvailable() + "");
							tMo4.setText(((Movie) mRm.getMedia().get(l)).getRating());
						} else {
							tMo2.setText("");
							tMo3.setText("");
							tMo4.setText("");
							alert.setContentText("The madia does not exist");
							alert.showAndWait();
						}
					} else {
						alert.setContentText("Please Enter Code");
						alert.showAndWait();
					}
				});
				bMo2.setContentDisplay(ContentDisplay.LEFT);
				//Effect for Button
				bMo2.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e1) -> {
					bMo2.setEffect(shadow);
				});
				bMo2.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e1) -> {
					bMo2.setEffect(null);
				});
				//Action for Back Button
				bMo2.setOnAction(e1 -> {
					media(sMediaSer, sMediaSerScene);
				});

				bMo1.setMinSize(200, 30);
				bMo2.setMinSize(200, 30);

				lMo1.setFont(myfont2);
				lMo2.setFont(myfont2);
				lMo3.setFont(myfont2);
				lMo4.setFont(myfont2);

				lMo1.setMinSize(250, 30);
				lMo2.setMinSize(250, 30);
				lMo3.setMinSize(250, 30);
				lMo4.setMinSize(250, 30);

				tMo1.setMinSize(200, 30);
				tMo2.setMinSize(200, 30);
				tMo3.setMinSize(200, 30);
				tMo4.setMinSize(200, 30);
				//Add content to display
				mediaSe.getChildren().addAll(hMoS1, hMoS2, hMoS3, hMoS4, hMoS5);

				sMediaSer.setTitle("Search a Media by code");
			}

			else if (mediaTypeSer.getValue().equals("Game")) {

				hGaS1.setAlignment(Pos.CENTER);
				hGaS2.setAlignment(Pos.CENTER);
				hGaS3.setAlignment(Pos.CENTER);
				hGaS4.setAlignment(Pos.CENTER);
				hGaS5.setAlignment(Pos.CENTER);

				mediaSe.setPadding(new Insets(30));
				//Make TextArea ineffective
				tGa2.setEditable(false);
				tGa3.setEditable(false);
				tGa4.setEditable(false);

				bGa1.setContentDisplay(ContentDisplay.LEFT);
				//Effect for Button
				bGa1.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e1) -> {
					bGa1.setEffect(shadow);
				});
				bGa1.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e1) -> {
					bGa1.setEffect(null);
				});
				//Action for Search Button
				bGa1.setOnAction(e3 -> {
					//Check if the text is not empty
					if (tGa1.getText() != "") {
						String code;
						code = tGa1.getText();
						//Check if media is exist
						int l = -1;
						for (int p = 0; p < mRm.getMedia().size(); p++) {
							if (mRm.getMedia().get(p).getCode().equals(code)) {
								l = p;
							}
						}
						if (l != -1 && mRm.getMedia().get(l) instanceof Game) {
							tGa2.setText(mRm.getMedia().get(l).getTitle());
							tGa3.setText(mRm.getMedia().get(l).getCopiesAvailable() + "");
							tGa4.setText(((Game) mRm.getMedia().get(l)).getWeight() + "");

						} else {
							tGa2.setText("");
							tGa3.setText("");
							tGa4.setText("");
							alert.setContentText("The madia does not exist");
							alert.showAndWait();
						}
					} else {
						alert.setContentText("Please Enter Code");
						alert.showAndWait();
					}
				});
				bGa2.setContentDisplay(ContentDisplay.LEFT);
				//Effect for Button
				bGa2.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e1) -> {
					bGa2.setEffect(shadow);
				});
				bGa2.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e1) -> {
					bGa2.setEffect(null);
				});
				//Action for Back Button
				bGa2.setOnAction(e1 -> {
					media(sMediaSer, sMediaSerScene);
				});

				bGa1.setMinSize(200, 30);
				bGa2.setMinSize(200, 30);

				lGa1.setFont(myfont2);
				lGA2.setFont(myfont2);
				lGa3.setFont(myfont2);
				lGa4.setFont(myfont2);

				lGa1.setMinSize(250, 30);
				lGA2.setMinSize(250, 30);
				lGa3.setMinSize(250, 30);
				lGa4.setMinSize(250, 30);

				tGa1.setMinSize(200, 30);
				tGa2.setMinSize(200, 30);
				tGa3.setMinSize(200, 30);
				tGa4.setMinSize(200, 30);
				//Add content to display
				mediaSe.getChildren().addAll(hGaS1, hGaS2, hGaS3, hGaS4, hGaS5);

				sMediaSer.setTitle("Search a Media by code");

			} else if (mediaTypeSer.getValue().equals("Album")) {

				hAlS1.setAlignment(Pos.CENTER);
				hAlS2.setAlignment(Pos.CENTER);
				hAlS3.setAlignment(Pos.CENTER);
				hAlS4.setAlignment(Pos.CENTER);
				hAlS5.setAlignment(Pos.CENTER);
				hAlS6.setAlignment(Pos.CENTER);

				mediaSe.setPadding(new Insets(30));
				//Make TextArea ineffective
				tAl2.setEditable(false);
				tAl3.setEditable(false);
				tAl4.setEditable(false);
				tAl5.setEditable(false);

				bAl1.setContentDisplay(ContentDisplay.LEFT);
				//Effect for Button
				bAl1.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e1) -> {
					bAl1.setEffect(shadow);
				});
				bAl1.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e1) -> {
					bAl1.setEffect(null);
				});
				//Action for Search Button
				bAl1.setOnAction(e3 -> {
					//Check if the text is not empty
					if (tAl1.getText() != "") {
						String code;
						code = tAl1.getText();
						//Check if media is exist
						int l = -1;
						for (int p = 0; p < mRm.getMedia().size(); p++) {
							if (mRm.getMedia().get(p).getCode().equals(code)) {
								l = p;
							}
						}
						if (l != -1 && mRm.getMedia().get(l) instanceof Album) {
							tAl2.setText(mRm.getMedia().get(l).getTitle());
							tAl3.setText(mRm.getMedia().get(l).getCopiesAvailable() + "");
							tAl4.setText(((Album) mRm.getMedia().get(l)).getArtist());
							tAl5.setText(((Album) mRm.getMedia().get(l)).getSongs());

						} else {
							tAl2.setText("");
							tAl3.setText("");
							tAl4.setText("");
							tAl5.setText("");
							alert.setContentText("The madia does not exist");
							alert.showAndWait();
						}

					} else {
						alert.setContentText("Please Enter Code");
						alert.showAndWait();
					}
				});
				bAl2.setContentDisplay(ContentDisplay.LEFT);
				//Effect for Button
				bAl2.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e1) -> {
					bAl2.setEffect(shadow);
				});
				bAl2.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e1) -> {
					bAl2.setEffect(null);
				});
				//Action for Back Button
				bAl2.setOnAction(e1 -> {
					media(sMediaSer, sMediaSerScene);
				});

				bAl1.setMinSize(200, 30);
				bAl2.setMinSize(200, 30);

				lAl1.setFont(myfont2);
				lAl2.setFont(myfont2);
				lAl3.setFont(myfont2);
				lAl4.setFont(myfont2);
				lAl5.setFont(myfont2);

				lAl1.setMinSize(250, 30);
				lAl2.setMinSize(250, 30);
				lAl3.setMinSize(250, 30);
				lAl4.setMinSize(250, 30);
				lAl5.setMinSize(250, 30);

				tAl1.setMinSize(200, 30);
				tAl2.setMinSize(200, 30);
				tAl3.setMinSize(200, 30);
				tAl4.setMinSize(200, 30);
				tAl5.setMinSize(200, 30);
				//Add content to display
				mediaSe.getChildren().addAll(hAlS1, hAlS2, hAlS3, hAlS4, hAlS5, hAlS6);

				sMediaSer.setTitle("Search a Media by code");
			}

		});
	}

	
	public static void PrintAllMediaInfo(Stage print, Scene printScene) {
		print.setTitle("Print All Media Information");
		//Media Print All Media Information Panes 
		GridPane printIn = new GridPane();
		printIn.setVgap(20);
		printIn.setAlignment(Pos.CENTER);
		printIn.setPadding(new Insets(10));
		
		Label printInfo = new Label("All Media Information:");
		Font myfont = Font.font("Time new Roman", FontWeight.BOLD, FontPosture.REGULAR, 25);
		
		TextArea info = new TextArea();
		info.setMinHeight(100);
		info.setEditable(false);
		//Setting the image for the back Button
		Image image = new Image("back.png");
		ImageView medieim = new ImageView(image);
		medieim.setFitHeight(30);
		medieim.setFitWidth(30);
		//Back Button
		Button bP = new Button("Back",medieim);
		
		DropShadow shadow = new DropShadow();
		bP.setContentDisplay(ContentDisplay.LEFT);
		//Effect for Button
		bP.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e1) -> {
			bP.setEffect(shadow);
		});
		bP.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e1) -> {
			bP.setEffect(null);
		});
		//Setting the image for the printer Button
		Image image2 = new Image("printer.png");
		ImageView medieim2 = new ImageView(image2);
		medieim2.setFitHeight(30);
		medieim2.setFitWidth(30);
		//printer Button
		Button bP1 = new Button("Print",medieim2);
		bP1.setContentDisplay(ContentDisplay.LEFT);
		//Effect for Button
		bP1.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e1) -> {
			bP1.setEffect(shadow);
		});
		bP1.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e1) -> {
			bP1.setEffect(null);
		});
		//Action for Print Button
		bP1.setOnAction(e -> {
			info.setText(mRm.getAllMediaInfo());
		});
		//Action for Back Button
		bP.setOnAction(e -> {
			media(print, printScene);
		});

		bP.setMinSize(200, 30);
		bP1.setMinSize(200, 30);
		//Screen Format
		printInfo.setFont(myfont);
		printIn.add(printInfo, 0, 0);
		printIn.add(info, 1, 2);
		printIn.add(bP1, 1, 4);
		printIn.add(bP, 2, 4);
		//View content
		printScene.setRoot(printIn);
		print.show();
	}

	
	public static void SetLimitedPlanLimit(Stage SetLimitedPlanLimit, Scene SetLimitedPlanLimitScene) {

		SetLimitedPlanLimit.setTitle("Set Limited Plan Limit");
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("alerts");
		alert.setHeaderText(null);
		
		//Media Set Limited Plan Limit Panes 
		VBox SetL = new VBox(40);
		
		HBox hS0 = new HBox(80);
		HBox hS1 = new HBox(80);

		hS0.setAlignment(Pos.CENTER);
		hS1.setAlignment(Pos.CENTER);

		Label lS = new Label("Number of media allowed for limited customers: ");

		TextField tS = new TextField();

		tS.setMinSize(200, 30);
		//Setting the image for the set Button
		Image image = new Image("set.png");
		ImageView medieim = new ImageView(image);
		medieim.setFitHeight(30);
		medieim.setFitWidth(30);
		//set Button
		Button bS1 = new Button("Set",medieim);
		DropShadow shadow = new DropShadow();
		bS1.setContentDisplay(ContentDisplay.LEFT);
		//Effect for Button
		bS1.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e1) -> {
			bS1.setEffect(shadow);
		});
		bS1.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e1) -> {
			bS1.setEffect(null);
		});
		Font myfont2 = Font.font("Time new Roman", FontWeight.BOLD, FontPosture.REGULAR, 20);
		//Action for set Button
		bS1.setOnAction(e -> {
			//Check if the text is not empty
			if (tS.getText() != "") {
				char[] na = tS.getText().toCharArray();
				//Check the input if it is valid
				boolean isDigit = false;
				for (int j = 0; j < na.length; j++) {
					if (Character.isDigit(na[j])) {
						isDigit = true;
					} else {
						isDigit = false;
						break;
					}
				}
				if (isDigit) {
					mRm.setLimitedPlanLimit(Integer.parseInt(tS.getText()));
					alert.setContentText("The value has been added successfully");
					alert.showAndWait();

				} else {
					alert.setContentText(
							"Please enter Positive number without positive and negative symbols example(5)");
					alert.showAndWait();
				}
			} else {
				alert.setContentText("Please enter a valid Information");
				alert.showAndWait();
			}
		});
		//Setting the image for the back Button
		Image image2 = new Image("back.png");
		ImageView medieim2 = new ImageView(image2);
		medieim2.setFitHeight(30);
		medieim2.setFitWidth(30);
		//Back Button
		Button bS2 = new Button("Back",medieim2);
		
		bS2.setContentDisplay(ContentDisplay.LEFT);
		//Effect for Button
		bS2.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e1) -> {
			bS2.setEffect(shadow);
		});
		bS2.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e1) -> {
			bS2.setEffect(null);
		});
		//Action for Back Button
		bS2.setOnAction(e1 -> {
			media(SetLimitedPlanLimit, SetLimitedPlanLimitScene);
		});

		bS1.setMinSize(200, 30);
		bS2.setMinSize(200, 30);

		lS.setFont(myfont2);
		lS.setMinSize(250, 30);
		//Screen Format
		hS0.getChildren().addAll(lS, tS);
		hS1.getChildren().addAll(bS1, bS2);

		SetL.getChildren().addAll(hS0, hS1);
		SetL.setAlignment(Pos.CENTER);
		//View content
		SetLimitedPlanLimitScene.setRoot(SetL);
		SetLimitedPlanLimit.show();

	}

	
	public static void addAndRemoveAndProcess(Stage addAndRemoveAndProcess, Scene addAndProcessScene){
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("alerts");
		alert.setHeaderText(null);
		addAndRemoveAndProcess.setTitle("Add To Cart , Remove Frome Cart And Process Cart");
		//Rent Add, Remove and Process Panes 
		GridPane AddRemoPro = new GridPane();
		AddRemoPro.setVgap(20);
		AddRemoPro.setHgap(20);
		AddRemoPro.setPadding(new Insets(20));

		Font myfont = Font.font("Time new Roman", FontWeight.BOLD, FontPosture.REGULAR, 20);

		Label lR1 = new Label("Customer ID:");

		lR1.setFont(myfont);

		TextField tRf1 = new TextField();
		TextArea tRa1 = new TextArea();
		tRa1.setEditable(false);
		//Action for Customer ID TextField
		tRf1.setOnAction(e -> {
			String id = tRf1.getText();
			//Check if customer is exist
			int p = -1;
			for (int g = 0; g < mRm.getCustomer().size(); g++) {
				if (mRm.getCustomer().get(g).getId().equalsIgnoreCase(id)) {
					p = g;
				}
			}
			if (p != -1) {
				String info = "Name: " + mRm.getCustomer().get(p).getName() + "\n";
				info = info + "Address: " + mRm.getCustomer().get(p).getAddress() + "\n";
				info = info + "Mobile Number: " + mRm.getCustomer().get(p).getMobileNumber() + "\n";
				info = info + "Plan: " + mRm.getCustomer().get(p).getPlan();
				tRa1.setText(info);
			} else {
				alert.setContentText("The Customer does not exist ");
				alert.showAndWait();
			}
		});

		Label lR2 = new Label("Media Code:");

		lR2.setFont(myfont);

		TextField tRf2 = new TextField();
		TextArea tRa2 = new TextArea();
		tRa2.setEditable(false);
		//Action for Media Code TextField
		tRf2.setOnAction(e -> {
			String code = tRf2.getText();
			//Check if media is exist
			int p = -1;
			for (int f = 0; f < mRm.getMedia().size(); f++) {
				if (mRm.getMedia().get(f).getCode().equalsIgnoreCase(code)) {
					p = f;
				}
			}
			if (p != -1) {

				if (mRm.getMedia().get(p) instanceof Movie) {
					String info = "Title Of Movie: " + mRm.getMedia().get(p).getTitle() + "\n";
					info = info + "Copies Available: " + mRm.getMedia().get(p).getCopiesAvailable() + "\n";
					info = info + "Rating: " + ((Movie) mRm.getMedia().get(p)).getRating();
					tRa2.setText(info);

				} else if (mRm.getMedia().get(p) instanceof Game) {
					String info = "Title Of Game: " + mRm.getMedia().get(p).getTitle() + "\n";
					info = info + "Copies Available: " + mRm.getMedia().get(p).getCopiesAvailable() + "\n";
					info = info + "Weight: " + ((Game) mRm.getMedia().get(p)).getWeight();
					tRa2.setText(info);

				} else if (mRm.getMedia().get(p) instanceof Album) {
					String info = "Title Of Game: " + mRm.getMedia().get(p).getTitle() + "\n";
					info = info + "Copies Available: " + mRm.getMedia().get(p).getCopiesAvailable() + "\n";
					info = info + "Artist: " + ((Album) mRm.getMedia().get(p)).getArtist() + "\n";
					info = info + "Songs: " + ((Album) mRm.getMedia().get(p)).getSongs();
					tRa2.setText(info);
				}
			} else {
				alert.setContentText("The Media does not exist ");
				alert.showAndWait();
			}

		});

		Label lR3 = new Label("Rented Date:");

		lR3.setFont(myfont);

		TextArea tRf3 = new TextArea();
		tRf3.setEditable(false);
		tRf3.setMaxSize(500, 15);
		//Setting the image for the add Button
		Image image = new Image("add.png");
		ImageView rentim = new ImageView(image);
		rentim.setFitHeight(30);
		rentim.setFitWidth(30);
		//Add To Cart Button
		Button addToCart = new Button("Add To Cart",rentim);
		addToCart.setContentDisplay(ContentDisplay.LEFT);
		DropShadow shadow = new DropShadow();
		//Effect for Button
		addToCart.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			addToCart.setEffect(shadow);
		});
		addToCart.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			addToCart.setEffect(null);
		});
		//Action for Add To Cart Button
		addToCart.setOnAction(e -> {
			//Check if the texts are not empty
			if (tRf1.getText() != "" && tRf2.getText() != "") {
				String id = tRf1.getText();
				//Check if customer is exist
				int p = -1;
				for (int g = 0; g < mRm.getCustomer().size(); g++) {
					if (mRm.getCustomer().get(g).getId().equalsIgnoreCase(id)) {
						p = g;
					}
				}
				String code = tRf2.getText();
				//Check if media is exist
				int r = -1;
				for (int f = 0; f < mRm.getMedia().size(); f++) {
					if (mRm.getMedia().get(f).getCode().equalsIgnoreCase(code)) {
						r = f;
					}
				}
				if (p != -1 && r != -1) {
					boolean isAdded = mRm.addToCart(mRm.getCustomer().get(p).getId(), mRm.getMedia().get(r).getCode());
					if (isAdded) {
						alert.setContentText("The Media was Added successfully");
						alert.showAndWait();
					} else {
						alert.setContentText(
								"The Media was not Added successfully Because it's on the cart or not exist");
						alert.showAndWait();
					}
				} else {
					alert.setContentText("The Customer does not exist or the Media does not exist");
					alert.showAndWait();
				}

			} else {
				alert.setContentText("Please Enter All the Information(ID and Code)");
				alert.showAndWait();
			}

		});
		//Setting the image for the remove Button
		Image image2 = new Image("remove.png");
		ImageView rentim2 = new ImageView(image2);
		rentim2.setFitHeight(30);
		rentim2.setFitWidth(30);
		//Remove From Cart Button
		Button removeFromCart = new Button("Remove From Cart",rentim2);
		removeFromCart.setContentDisplay(ContentDisplay.LEFT);
		//Effect for Button
		removeFromCart.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			removeFromCart.setEffect(shadow);
		});
		removeFromCart.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			removeFromCart.setEffect(null);
		});
		//Action for Remove From Cart Button
		removeFromCart.setOnAction(e -> {
			//Check if the texts are not empty
			if (tRf1.getText() != "" && tRf2.getText() != "") {
				String id = tRf1.getText();
				//Check if customer is exist
				int p = -1;
				for (int g = 0; g < mRm.getCustomer().size(); g++) {
					if (mRm.getCustomer().get(g).getId().equalsIgnoreCase(id)) {
						p = g;
					}
				}
				String code = tRf2.getText();
				//Check if media is exist
				int r = -1;
				for (int f = 0; f < mRm.getMedia().size(); f++) {
					if (mRm.getMedia().get(f).getCode().equalsIgnoreCase(code)) {
						r = f;
					}
				}
				if (p != -1 && r != -1) {
					boolean isRemoved = mRm.removeFromCart(mRm.getCustomer().get(p).getId(),
							mRm.getMedia().get(r).getCode());
					if (isRemoved) {
						alert.setContentText("The Media was Removed successfully");
						alert.showAndWait();
					} else {
						alert.setContentText("The Media was not Removed successfully Because it's not on the cart");
						alert.showAndWait();
					}
				} else {
					alert.setContentText("The Customer does not exist or the Media does not exist");
					alert.showAndWait();
				}

			} else {
				alert.setContentText("Please Enter All the Information(ID and Code)");
				alert.showAndWait();
			}
		});
		//Setting the image for the process Button
		Image image3 = new Image("process.png");
		ImageView rentim3 = new ImageView(image3);
		rentim3.setFitHeight(30);
		rentim3.setFitWidth(30);
		//Process Cart Button
		Button processCart = new Button("Process Cart",rentim3);
		//Action for Process Cart Button
		processCart.setOnAction(e -> {
			Date d = new Date();
			tRf3.setText(d.toString());
			String id = tRf1.getText();
			//Check if customer is exist
			int c = -1;
			for (int k = 0; k < mRm.getCustomer().size(); k++) {
				if (mRm.getCustomer().get(k).getId().equals(id))
					c = k;
			}
			if (c != -1) {
				String process = mRm.processRequests(mRm.getCustomer().get(c).getId());
				try {
					printProcessungRequests(process,d);
				} catch (IOException e2) {
					e2.printStackTrace();
				}
				alert.setContentText(process);
				alert.showAndWait();

			} else{
				alert.setContentText("The Customer does not exist");
				alert.showAndWait();
			}

		});
		processCart.setContentDisplay(ContentDisplay.LEFT);
		//Effect for Button
		processCart.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e1) -> {
			processCart.setEffect(shadow);
		});
		processCart.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e1) -> {
			processCart.setEffect(null);
		});
		//Setting the image for the back Button
		Image image4 = new Image("back.png");
		ImageView rentim4 = new ImageView(image4);
		rentim4.setFitHeight(30);
		rentim4.setFitWidth(30);
		//Back Button
		Button back = new Button("Back",rentim4);
		back.setContentDisplay(ContentDisplay.LEFT);
		//Effect for Button
		back.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e1) -> {
			back.setEffect(shadow);
		});
		back.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e1) -> {
			back.setEffect(null);
		});
		//Action for Back Button
		back.setOnAction(e -> {
			rent(addAndRemoveAndProcess, addAndProcessScene);
		});
		//Screen Format
		AddRemoPro.add(lR1, 0, 0);
		AddRemoPro.add(tRf1, 1, 0);
		AddRemoPro.add(tRa1, 1, 1);
		AddRemoPro.add(lR2, 0, 2);
		AddRemoPro.add(tRf2, 1, 2);
		AddRemoPro.add(tRa2, 1, 3);
		AddRemoPro.add(lR3, 0, 4);
		AddRemoPro.add(tRf3, 1, 4);
		AddRemoPro.add(addToCart, 0, 5);
		AddRemoPro.add(removeFromCart, 1, 5);
		AddRemoPro.add(processCart, 3, 5);
		AddRemoPro.add(back, 4, 5);
		//View content
		addAndProcessScene.setRoot(AddRemoPro);
		addAndRemoveAndProcess.show();
		alert.setContentText(
				"Note: To perform the operation correctly, please enter the ID, then press the Enter button\nThen enter the Code, then the Enter button, and then the rest of the buttons");
		alert.showAndWait();
		
	}

	
	public static void searchTitleOfMedia(Stage searchTitleOfMedi, Scene searchTitleOfMediScene) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("alerts");
		alert.setHeaderText(null);
		searchTitleOfMedi.setTitle("Search Titles Of Medias");
		//Rent search Title Of Media Panes 
		GridPane searchTit = new GridPane();
		searchTit.setAlignment(Pos.CENTER);
		searchTit.setVgap(20);
		searchTit.setHgap(20);
		searchTit.setPadding(new Insets(20));

		Font myfont = Font.font("Time new Roman", FontWeight.BOLD, FontPosture.REGULAR, 20);
		//Rent search Title Of Media Labels 
		Label lR1 = new Label("Title Of Media:");
		Label lR2 = new Label("Rating Of Movie:");
		Label lR3 = new Label("Artist Of Album:");
		Label lR4 = new Label("Songs Of Album:");

		lR1.setFont(myfont);
		lR2.setFont(myfont);
		lR3.setFont(myfont);
		lR4.setFont(myfont);

		HBox rat = new HBox(20);
		//Rent search Title Of Media TextFields, RadioButton, TextArea and Button
		TextField tRf1 = new TextField();
		RadioButton r1 = new RadioButton("DR");
		RadioButton r2 = new RadioButton("HR");
		RadioButton r3 = new RadioButton("AC");
		TextField tRf2 = new TextField();
		TextField tR3 = new TextField();
		TextArea tA = new TextArea();
		//clear Button
		Button clear = new Button("clear");
		ToggleGroup t = new ToggleGroup();
		r1.setToggleGroup(t);
		r2.setToggleGroup(t);
		r3.setToggleGroup(t);
		rat.getChildren().addAll(r1, r2, r3, clear);
		//Action for clear Button
		clear.setOnAction(e -> {
			r1.setSelected(false);
			r2.setSelected(false);
			r3.setSelected(false);
		});
		tA.setEditable(false);
		//Setting the image for the search Button
		Image image = new Image("search.png");
		ImageView mediaIm = new ImageView(image);
		mediaIm.setFitHeight(30);
		mediaIm.setFitWidth(30);
		//Search Button
		Button search = new Button("Search",mediaIm);
		search.setContentDisplay(ContentDisplay.LEFT);
		DropShadow shadow = new DropShadow();
		//Effect for Button
		search.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			search.setEffect(shadow);
		});
		search.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			search.setEffect(null);
		});
		//Action for Search Button
		search.setOnAction(e -> {
			ArrayList<String> info = new ArrayList<>();
			String title = tRf1.getText();
			String rating = null;
			if (r1.isSelected()) {
				rating = "DR";
			}
			if (r2.isSelected()) {
				rating = "HR";
			}
			if (r3.isSelected()) {
				rating = "AC";
			}
			String artist = tRf2.getText();
			String songs = tR3.getText();
			String print = "";
			if (title == "") {
				title = null;
			}
			if (artist == "") {
				artist = null;
			}
			if (songs == "") {
				songs = null;
			}
			info = mRm.searchMedia(title, rating, artist, songs);
			if (info.size() != 0) {
				for (int r = 0; r < info.size(); r++) {
					print = print + info.get(r) + "\n";
				}
				tA.setText(print);
			} else {
				tA.setText("There is no Titles");
			}
		});
		//Setting the image for the back Button
		Image image2 = new Image("back.png");
		ImageView mediaIm2 = new ImageView(image2);
		mediaIm2.setFitHeight(30);
		mediaIm2.setFitWidth(30);
		//Back Button
		Button back = new Button("Back",mediaIm2);
		back.setContentDisplay(ContentDisplay.LEFT);
		//Effect for Button
		back.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e1) -> {
			back.setEffect(shadow);
		});
		back.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e1) -> {
			back.setEffect(null);
		});
		//Action for Back Button
		back.setOnAction(e -> {
			media(searchTitleOfMedi, searchTitleOfMediScene);
		});
		//Screen Format
		searchTit.add(lR1, 0, 0);
		searchTit.add(tRf1, 1, 0);
		searchTit.add(lR2, 0, 1);
		searchTit.add(rat, 1, 1);
		searchTit.add(lR3, 0, 2);
		searchTit.add(tRf2, 1, 2);
		searchTit.add(lR4, 0, 3);
		searchTit.add(tR3, 1, 3);
		searchTit.add(tA, 1, 4);
		searchTit.add(search, 0, 5);
		searchTit.add(back, 1, 5);
		//View content
		searchTitleOfMediScene.setRoot(searchTit);
		searchTitleOfMedi.show();
	}

	
	public static void printTheRequestedInterested(Stage printTheRequested, Scene printTheRequestedScene) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("alerts");
		alert.setHeaderText(null);
		printTheRequested.setTitle("Print the requested interested media in the cart by give ");
		//Rent print The Requested Interested Panes 
		GridPane printRequested = new GridPane();
		printRequested.setVgap(20);
		printRequested.setPadding(new Insets(20));

		Font myfont = Font.font("Time new Roman", FontWeight.BOLD, FontPosture.REGULAR, 15);

		Label lR1 = new Label("Customer ID:");

		lR1.setFont(myfont);

		TextField tRf1 = new TextField();

		Label lR2 = new Label("The Requested Interested in the cart: ");

		lR2.setFont(myfont);

		TextArea tRa2 = new TextArea();
		tRa2.setEditable(false);
		TextArea tRa1 = new TextArea();
		tRa1.setEditable(false);
		//Action for Customer ID TextField
		tRf1.setOnAction(e -> {
			String id = tRf1.getText();
			//Check if customer is exist
			int p = -1;
			for (int g = 0; g < mRm.getCustomer().size(); g++) {
				if (mRm.getCustomer().get(g).getId().equalsIgnoreCase(id)) {
					p = g;
				}
			}
			if (p != -1) {
				String info = "Name: " + mRm.getCustomer().get(p).getName() + "\n";
				info = info + "Address: " + mRm.getCustomer().get(p).getAddress() + "\n";
				info = info + "Mobile Number: " + mRm.getCustomer().get(p).getMobileNumber() + "\n";
				info = info + "Plan: " + mRm.getCustomer().get(p).getPlan();
				tRa1.setText(info);
			} else {
				alert.setContentText("The Customer does not exist ");
				alert.showAndWait();
			}
		});

		TextArea tRa3 = new TextArea();
		tRa3.setEditable(false);

		tRa3.setMaxSize(500, 10);

		Label lR3 = new Label("Print Requested Date:");

		lR3.setFont(myfont);

		TextArea tRf3 = new TextArea();
		tRf3.setEditable(false);
		tRf3.setMaxSize(500, 15);
		//Setting the image for the back Button
		Image image = new Image("back.png");
		ImageView view = new ImageView(image);
		view.setFitHeight(30);
		view.setFitWidth(30);
		//Back Button
		Button back = new Button("Back",view);
		back.setContentDisplay(ContentDisplay.LEFT);
		DropShadow shadow = new DropShadow();
		//Effect for Button
		back.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e1) -> {
			back.setEffect(shadow);
		});
		back.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e1) -> {
			back.setEffect(null);
		});
		//Action for Back Button
		back.setOnAction(e -> {
			rent(printTheRequested, printTheRequestedScene);
		});
		//Setting the image for the printer Button
		Image image2 = new Image("printer.png");
		ImageView view2 = new ImageView(image2);
		view2.setFitHeight(30);
		view2.setFitWidth(30);
		//Print Button
		Button printTRMIC = new Button("Print",view2);
		//Action for Print Button
		printTRMIC.setOnAction(e -> {
			//Check if the text is empty
			if (tRf1.getText() != "") {
				String id = tRf1.getText();
				//Check if customer is exist
				int g = -1;
				for (int r = 0; r < mRm.getCustomer().size(); r++) {
					if (mRm.getCustomer().get(r).getId().equalsIgnoreCase(id)) {
						g = r;
						break;
					}
				}
				String info = "";
				String title = "";
				if (g != -1) {
					for (int p = 0; p < mRm.getCustomer().get(g).getInterestedInList().size(); p++) {
						for (int s = 0; s < mRm.getMedia().size(); s++) {
							if (mRm.getCustomer().get(g).getInterestedInList().get(p)
									.equals(mRm.getMedia().get(s).getCode())) {
								title = mRm.getMedia().get(s).getTitle();
								break;
							}
						}
						info = info + title + "\n";

					}
					tRa3.setText("The Requested interested media in the cart of customer: "+ mRm.getCustomer().get(g).getName());
					tRa2.setText(info);
					Date d = new Date();
					tRf3.setText(d.toString());
				} else {
					alert.setContentText("The Customer does not exist ");
					alert.showAndWait();
				}

			} else {
				alert.setContentText("Please Enter the Information(ID)");
				alert.showAndWait();
			}
		});
		//Effect for Button
		printTRMIC.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			printTRMIC.setEffect(shadow);
		});
		printTRMIC.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			printTRMIC.setEffect(null);
		});
		//Screen Format
		printRequested.add(lR1, 0, 0);
		printRequested.add(tRf1, 1, 0);
		printRequested.add(tRa1, 1, 1);
		printRequested.add(lR2, 0, 2);
		printRequested.add(tRa3, 1, 2);
		printRequested.add(tRa2, 1, 3);
		printRequested.add(lR3, 0, 4);
		printRequested.add(tRf3, 1, 4);
		printRequested.add(printTRMIC, 0, 5);
		printRequested.add(back, 1, 5);
		//View content
		printTheRequestedScene.setRoot(printRequested);
		printTheRequested.show();
		alert.setContentText(
				"Note: To perform the operation correctly, please enter the ID, then press the Enter button, and then the print button");
		alert.showAndWait();
	}

	
	public static void printTheRentedMedia(Stage printTheRented, Scene printTheRentedScene) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("alerts");
		alert.setHeaderText(null);
		printTheRented.setTitle("Print the rented media in the cart by give the id of customer");
		//Rent print The Rented Media Panes 
		GridPane printRent = new GridPane();
		printRent.setVgap(20);
		printRent.setPadding(new Insets(20));

		Font myfont = Font.font("Time new Roman", FontWeight.BOLD, FontPosture.REGULAR, 15);

		Label lR1 = new Label("Customer ID:");

		lR1.setFont(myfont);

		TextField tRf1 = new TextField();

		Label lR2 = new Label("Rented Media in the cart: ");

		lR2.setFont(myfont);

		TextArea tRa2 = new TextArea();
		tRa2.setEditable(false);
		TextArea tRa1 = new TextArea();
		tRa1.setEditable(false);
		//Action for Customer ID TextField
		tRf1.setOnAction(e -> {
			String id = tRf1.getText();
			//Check if customer is exist
			int p = -1;
			for (int g = 0; g < mRm.getCustomer().size(); g++) {
				if (mRm.getCustomer().get(g).getId().equalsIgnoreCase(id)) {
					p = g;
				}
			}
			if (p != -1) {
				String info = "Name: " + mRm.getCustomer().get(p).getName() + "\n";
				info = info + "Address: " + mRm.getCustomer().get(p).getAddress() + "\n";
				info = info + "Mobile Number: " + mRm.getCustomer().get(p).getMobileNumber() + "\n";
				info = info + "Plan: " + mRm.getCustomer().get(p).getPlan();
				tRa1.setText(info);
			} else {
				alert.setContentText("The Customer does not exist ");
				alert.showAndWait();
			}
		});

		TextArea tRa3 = new TextArea();
		tRa3.setEditable(false);

		tRa3.setMaxSize(500, 10);

		Label lR3 = new Label("Print Rented Date:");

		lR3.setFont(myfont);

		TextArea tRf3 = new TextArea();
		tRf3.setEditable(false);
		tRf3.setMaxSize(500, 15);
		//Setting the image for the back Button
		Image image = new Image("back.png");
		ImageView view = new ImageView(image);
		view.setFitHeight(30);
		view.setFitWidth(30);
		//Back Button
		Button back = new Button("Back",view);
		back.setContentDisplay(ContentDisplay.LEFT);
		DropShadow shadow = new DropShadow();
		//Effect for Button
		back.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e1) -> {
			back.setEffect(shadow);
		});
		back.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e1) -> {
			back.setEffect(null);
		});
		//Action for Back Button
		back.setOnAction(e -> {
			rent(printTheRented, printTheRentedScene);
		});
		//Setting the image for the printer Button
		Image image2 = new Image("printer.png");
		ImageView view2 = new ImageView(image2);
		view2.setFitHeight(30);
		view2.setFitWidth(30);
		//Printer Button
		Button printTRMIC = new Button("Print",view2);
		//Action for Printer Button
		printTRMIC.setOnAction(e -> {
			//Check if the text is empty
			if (tRf1.getText() != "") {
				String id = tRf1.getText();
				////Check if customer is exist
				int g = -1;
				for (int r = 0; r < mRm.getCustomer().size(); r++) {
					if (mRm.getCustomer().get(r).getId().equals(id)) {
						g = r;
						break;
					}
				}
				String info = "";
				String title = "";
				if (g != -1) {
					for (int p = 0; p < mRm.getCustomer().get(g).getRentedList().size(); p++) {
						for (int s = 0; s < mRm.getMedia().size(); s++) {
							if (mRm.getCustomer().get(g).getRentedList().get(p)
									.equals(mRm.getMedia().get(s).getCode())) {
								title = mRm.getMedia().get(s).getTitle();
								break;
							}
						}
						info = info + title + "\n";
					}
					tRa3.setText("the rented media in the cart of customer: " + mRm.getCustomer().get(g).getName());
					tRa2.setText(info);
					Date d = new Date();
					tRf3.setText(d.toString());
				} else {
					alert.setContentText("The Customer does not exist ");
					alert.showAndWait();
				}
			} else {
				alert.setContentText("Please Enter the Information(ID)");
				alert.showAndWait();
			}
		});
		//Effect for Button
		printTRMIC.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			printTRMIC.setEffect(shadow);
		});
		printTRMIC.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			printTRMIC.setEffect(null);
		});
		//Screen Format
		printRent.add(lR1, 0, 0);
		printRent.add(tRf1, 1, 0);
		printRent.add(tRa1, 1, 1);
		printRent.add(lR2, 0, 2);
		printRent.add(tRa3, 1, 2);
		printRent.add(tRa2, 1, 3);
		printRent.add(lR3, 0, 4);
		printRent.add(tRf3, 1, 4);
		printRent.add(printTRMIC, 0, 5);
		printRent.add(back, 1, 5);
		//View content
		printTheRentedScene.setRoot(printRent);
		printTheRented.show();
		alert.setContentText(
				"Note: To perform the operation correctly, please enter the ID, then press the Enter button, and then the print buttons");
		alert.showAndWait();
	}

	
	public static void returnRentedMedia(Stage returnTheRented, Scene returnTheRentedScene) {
		returnTheRented.setTitle("Return Rented media by give the id of customer and then return the media");
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("alerts");
		alert.setHeaderText(null);
		//Rent return Rented Media Panes 
		GridPane returnRent = new GridPane();
		returnRent.setVgap(20);
		returnRent.setPadding(new Insets(20));

		Font myfont = Font.font("Time new Roman", FontWeight.BOLD, FontPosture.REGULAR, 15);

		Label lR1 = new Label("Customer ID:");

		lR1.setFont(myfont);

		TextField tRf1 = new TextField();
		TextArea tRa1 = new TextArea();
		tRa1.setEditable(false);
		//Action for Customer ID TextField
		tRf1.setOnAction(e -> {
			String id = tRf1.getText();
			//Check if customer is exist
			int p = -1;
			for (int g = 0; g < mRm.getCustomer().size(); g++) {
				if (mRm.getCustomer().get(g).getId().equals(id)) {
					p = g;
				}
			}
			if (p != -1) {
				String info = "Name: " + mRm.getCustomer().get(p).getName() + "\n";
				info = info + "Address: " + mRm.getCustomer().get(p).getAddress() + "\n";
				info = info + "Mobile Number: " + mRm.getCustomer().get(p).getMobileNumber() + "\n";
				info = info + "Plan: " + mRm.getCustomer().get(p).getPlan();
				tRa1.setText(info);
			} else {
				alert.setContentText("The Customer does not exist ");
				alert.showAndWait();
			}
		});
		Label lR2 = new Label("Media Code:");

		lR2.setFont(myfont);

		TextField tRf2 = new TextField();
		TextArea tRa2 = new TextArea();
		tRa2.setEditable(false);
		//Action for Media Code TextField
		tRf2.setOnAction(e -> {
			String code = tRf2.getText();
			//Check if media is exist
			int p = -1;
			for (int f = 0; f < mRm.getMedia().size(); f++) {
				if (mRm.getMedia().get(f).getCode().equals(code)) {
					p = f;
				}
			}
			if (p != -1) {
				if (mRm.getMedia().get(p) instanceof Movie) {
					String info = "Title Of Movie: " + mRm.getMedia().get(p).getTitle() + "\n";
					info = info + "Copies Available: " + mRm.getMedia().get(p).getCopiesAvailable() + "\n";
					info = info + "Rating: " + ((Movie) mRm.getMedia().get(p)).getRating();
					tRa2.setText(info);

				} else if (mRm.getMedia().get(p) instanceof Game) {
					String info = "Title Of Game: " + mRm.getMedia().get(p).getTitle() + "\n";
					info = info + "Copies Available: " + mRm.getMedia().get(p).getCopiesAvailable() + "\n";
					info = info + "Weight: " + ((Game) mRm.getMedia().get(p)).getWeight();
					tRa2.setText(info);

				} else if (mRm.getMedia().get(p) instanceof Album) {
					String info = "Title Of Game: " + mRm.getMedia().get(p).getTitle() + "\n";
					info = info + "Copies Available: " + mRm.getMedia().get(p).getCopiesAvailable() + "\n";
					info = info + "Artist: " + ((Album) mRm.getMedia().get(p)).getArtist() + "\n";
					info = info + "Songs: " + ((Album) mRm.getMedia().get(p)).getSongs();
					tRa2.setText(info);

				}
			} else {
				alert.setContentText("The Media does not exist ");
				alert.showAndWait();
			}
		});

		Label lR3 = new Label("Return Date:");

		lR3.setFont(myfont);

		TextArea tRf3 = new TextArea();
		tRf3.setEditable(false);
		tRf3.setMaxSize(500, 15);
		//Setting the image for the return Button
		Image image = new Image("return.png");
		ImageView view = new ImageView(image);
		view.setFitHeight(30);
		view.setFitWidth(30);
		//Return Rented media Button
		Button returnRen = new Button("Return Rented media",view);
		//Action for Return Rented media Button
		returnRen.setOnAction(e -> {
			String id = tRf1.getText();
			//Check if customer is exist
			int r = -1;
			for (int g = 0; g < mRm.getCustomer().size(); g++) {
				if (mRm.getCustomer().get(g).getId().equalsIgnoreCase(id)) {
					r = g;
				}
			}
			String code = tRf2.getText();
			//Check if media is exist
			int p = -1;
			for (int f = 0; f < mRm.getMedia().size(); f++) {
				if (mRm.getMedia().get(f).getCode().equalsIgnoreCase(code)) {
					p = f;
				}
			}
			if (p != -1 && r != -1) {
				if (mRm.getMedia().get(p) instanceof Movie
						&& mRm.returnMedia(mRm.getCustomer().get(r).getId(), mRm.getMedia().get(p).getCode())) {
					String info = "Title Of Movie: " + mRm.getMedia().get(p).getTitle() + "\n";
					info = info + "Copies Available: " + mRm.getMedia().get(p).getCopiesAvailable() + "\n";
					info = info + "Rating: " + ((Movie) mRm.getMedia().get(p)).getRating();
					tRa2.setText(info);
					alert.setContentText("The operation succeeded");
					alert.showAndWait();
				} else if (mRm.getMedia().get(p) instanceof Game
						&& mRm.returnMedia(mRm.getCustomer().get(r).getId(), mRm.getMedia().get(p).getCode())) {
					String info = "Title Of Game: " + mRm.getMedia().get(p).getTitle() + "\n";
					info = info + "Copies Available: " + mRm.getMedia().get(p).getCopiesAvailable() + "\n";
					info = info + "Weight: " + ((Game) mRm.getMedia().get(p)).getWeight();
					tRa2.setText(info);
					alert.setContentText("The operation succeeded");
					alert.showAndWait();

				} else if (mRm.getMedia().get(p) instanceof Album
						&& mRm.returnMedia(mRm.getCustomer().get(r).getId(), mRm.getMedia().get(p).getCode())) {
					String info = "Title Of Game: " + mRm.getMedia().get(p).getTitle() + "\n";
					info = info + "Copies Available: " + mRm.getMedia().get(p).getCopiesAvailable() + "\n";
					info = info + "Artist: " + ((Album) mRm.getMedia().get(p)).getArtist() + "\n";
					info = info + "Songs: " + ((Album) mRm.getMedia().get(p)).getSongs();
					tRa2.setText(info);
					alert.setContentText("The operation succeeded");
					alert.showAndWait();

				} else {
					alert.setContentText("The operation does not succeeded Because it is not in the Rented List");
					alert.showAndWait();
				}

			} else {
				alert.setContentText("The Customer does not exist or the Media does not exist");
				alert.showAndWait();
			}
			Date d = new Date();
			tRf3.setText(d.toString());
		});
		DropShadow shadow = new DropShadow();
		returnRen.setContentDisplay(ContentDisplay.LEFT);
		//Effect for Button
		returnRen.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e1) -> {
			returnRen.setEffect(shadow);
		});
		returnRen.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e1) -> {
			returnRen.setEffect(null);
		});
		//Setting the image for the back Button
		Image image2 = new Image("back.png");
		ImageView view2 = new ImageView(image2);
		view2.setFitHeight(30);
		view2.setFitWidth(30);
		//Back Button
		Button back = new Button("Back",view2);
		back.setContentDisplay(ContentDisplay.LEFT);
		//Effect for Button
		back.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e1) -> {
			back.setEffect(shadow);
		});
		back.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e1) -> {
			back.setEffect(null);
		});
		//Action for Back Button
		back.setOnAction(e -> {
			rent(returnTheRented, returnTheRentedScene);

		});
		//Screen Format
		returnRent.add(lR1, 0, 0);
		returnRent.add(tRf1, 1, 0);
		returnRent.add(tRa1, 1, 1);
		returnRent.add(lR2, 0, 2);
		returnRent.add(tRf2, 1, 2);
		returnRent.add(tRa2, 1, 3);
		returnRent.add(lR3, 0, 4);
		returnRent.add(tRf3, 1, 4);
		returnRent.add(returnRen, 0, 5);
		returnRent.add(back, 2, 5);
		//View content
		returnTheRentedScene.setRoot(returnRent);
		returnTheRented.show();
	}

	
	public static void main(String[] args) throws IOException {
		// Create an object of a file type in order to perform operations on it
		File myFile1 = new File("Customer.txt");
		File myFile2 = new File("Media.txt");
		File myFile3 = new File("Rented.txt");
		File myFile4 = new File("Intrested.txt");
		// Check if the file exists in order to read from the desired file
		if (myFile1.exists()) {
			Scanner sc = new Scanner(myFile1);
			while (sc.hasNext()) {
				// Read custers file
				String data = sc.nextLine();
				String[] infoData = data.split("[,:]");
				for (int y = 0; y < infoData.length; y++)
					infoData[y] = infoData[y].trim();
				if (infoData[0].equalsIgnoreCase("Customer")) {
					if (infoData[1].equalsIgnoreCase("ID") && infoData[3].equalsIgnoreCase("Mobile Number")
							&& infoData[5].equalsIgnoreCase("name") && infoData[7].equalsIgnoreCase("address")
							&& infoData[9].equalsIgnoreCase("plan")) {
						String id = infoData[2];
						String mobileNumber = infoData[4];
						String name = infoData[6];
						String address = infoData[8];
						String plan = infoData[10];
						mRm.addCustomer(id, mobileNumber, name, address, plan);
					}
				}
			}
			sc.close();
		}
		if (myFile2.exists()) {
			// Read media file
			Scanner sc = new Scanner(myFile2);
			while (sc.hasNext()) {
				String data = sc.nextLine();
				String[] infoData = data.split("[,:]");
				for (int y = 0; y < infoData.length; y++)
					infoData[y] = infoData[y].trim();
				if (infoData[0].equalsIgnoreCase("Game")) {
					if (infoData[1].equalsIgnoreCase("Code") && infoData[3].equalsIgnoreCase("title")
							&& infoData[5].equalsIgnoreCase("weight")
							&& infoData[7].equalsIgnoreCase("copiesAvailable")) {
						String code = infoData[2];
						String title = infoData[4];
						double weight = Double.parseDouble(infoData[6]);
						int copiesAvailable = Integer.parseInt(infoData[8]);
						mRm.addGame(code, title, copiesAvailable, weight);
					}
				}
				if (infoData[0].equalsIgnoreCase("Album")) {
					if (infoData[1].equalsIgnoreCase("Code") && infoData[3].equalsIgnoreCase("title")
							&& infoData[5].equalsIgnoreCase("artist") && infoData[7].equalsIgnoreCase("songs")) {
						String code = infoData[2];
						String title = infoData[4];
						String artist = infoData[6];
						String songs = "";
						int copiesAvailable = 0;
						int index = 8;
						int n = 0;
						while (!(infoData[index].equalsIgnoreCase("copiesAvailable"))) {
							if (n != 0)
								songs = songs + "," + infoData[index];
							else {
								songs = infoData[index];
								n = 1;
							}
							index++;

						}
						n = 0;
						if (infoData[index].equalsIgnoreCase("copiesAvailable")) {
							index++;
							infoData[index] = infoData[index];
							copiesAvailable = Integer.parseInt(infoData[index]);
						}
						mRm.addAlbum(code, title, copiesAvailable, artist, songs);
					}
				}
				if (infoData[0].equalsIgnoreCase("Movie")) {

					if (infoData[1].equalsIgnoreCase("Code") && infoData[3].equalsIgnoreCase("title")
							&& infoData[5].equalsIgnoreCase("rating")
							&& infoData[7].equalsIgnoreCase("copiesAvailable")) {
						String code = infoData[2];
						String title = infoData[4];
						String rating = infoData[6];
						int copiesAvailable = Integer.parseInt(infoData[8]);
						mRm.addMovie(code, title, copiesAvailable, rating);
					}
				}
			}
			sc.close();
		}
		if (myFile3.exists()) {
			// Read the rented file
			Scanner sc = new Scanner(myFile3);
			ArrayList<String> cusInfo = new ArrayList<>();
			while (sc.hasNext()) {
				String data = sc.nextLine();
				cusInfo.add(data);
			}
			for (int i = 0; i < mRm.getCustomer().size(); i++) {
				for (int j = 0; j < cusInfo.size(); j++) {
					String[] cus = cusInfo.get(j).split("[,:]");
					cus[0] = cus[0].trim();
					if (mRm.getCustomer().get(i).getName().equalsIgnoreCase(cus[0])) {
						cus[1] = cus[1].trim();
						if (cus[1].equalsIgnoreCase("Rented List")) {
							int index = 2;
							cus[index] = cus[index].trim();
							while (!(cus[index].equalsIgnoreCase("."))) {
								mRm.getCustomer().get(i).getRentedList().add(cus[index]);
								index++;
								cus[index] = cus[index].trim();
							}
						}
					}
				}
			}
		}
		if (myFile4.exists()) {
			// Read the intrested file
			Scanner sc = new Scanner(myFile4);
			ArrayList<String> cusInfo = new ArrayList<>();
			while (sc.hasNext()) {
				String data = sc.nextLine();
				cusInfo.add(data);
			}
			for (int i = 0; i < mRm.getCustomer().size(); i++) {
				for (int j = 0; j < cusInfo.size(); j++) {
					String[] cus = cusInfo.get(j).split("[,:]");
					cus[0] = cus[0].trim();
					if (mRm.getCustomer().get(i).getName().equalsIgnoreCase(cus[0])) {
						cus[1] = cus[1].trim();
						if (cus[1].equalsIgnoreCase("Interested In List")) {
							int index = 2;
							cus[index] = cus[index].trim();
							while (!(cus[index].equalsIgnoreCase("."))) {
								mRm.getCustomer().get(i).getInterestedInList().add(cus[index]);
								index++;
								cus[index] = cus[index].trim();
							}
						}
					}
				}
			}
		}
		//Run the program
		launch(args);
		//Write information on files to save and read again
		PrintWriter out1 = new PrintWriter(myFile1);
		PrintWriter out2 = new PrintWriter(myFile2);
		PrintWriter out3 = new PrintWriter(myFile3);
		PrintWriter out4 = new PrintWriter(myFile4);
		String rented = "";
		String intrested = "";
		for (int s = 0; s < mRm.getCustomer().size(); s++) {
			rented = rented + mRm.getCustomer().get(s).getName() + ", Rented List:"
					+ fromArrayListToString(mRm.getCustomer().get(s).getRentedList()) + ",." + "\n";
			intrested = intrested + mRm.getCustomer().get(s).getName() + ", Interested In List:"
					+ fromArrayListToString(mRm.getCustomer().get(s).getInterestedInList()) + ",." + "\n";
		}
		out1.println(mRm.getAllCustomersInfo());
		out2.println(mRm.getAllMediaInfo());
		out3.println(rented);
		out4.println(intrested);

		out1.close();
		out2.close();
		out3.close();
		out4.close();
	}

	
	private static String fromArrayListToString(ArrayList<String> arr) {
		//Converting an Array to a String in the form of a line
		String ar = "";
		for (int i = 0; i < arr.size(); i++) {
			if (i != (arr.size() - 1)) {
				ar = ar + arr.get(i) + " , ";
			} else
				ar = ar + arr.get(i);
		}
		return ar;
	}
    private static void printProcessungRequests (String  info,Date d) throws IOException {
    	//Define file name to write
    			File myFile5 = new File("ProcessingRequests.txt");
    			FileWriter myOut = new FileWriter(myFile5, true);
    			PrintWriter out5 = new PrintWriter(myOut);
    			out5.println(info + " " + d.toString() + "\n");
    			out5.close();
    }
}
