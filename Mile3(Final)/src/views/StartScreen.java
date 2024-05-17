package views;


import java.io.File;
import java.io.IOException;

import Controller.Start;
import engine.Game;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.*;
import javafx.scene.media.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.*;
import javafx.util.Duration;
import model.characters.Hero;

public class StartScreen extends Application {
	Scene scene1;
	public void start(Stage stage) throws Exception {
		/*String s="The-Last-Of-us-Theme-Song.mp3";
		Media media=new Media(new File("The-Last-Of-us-Theme-Song.mp3").toURI().toString());
		MediaPlayer mediaplayer=new MediaPlayer(media);
		mediaplayer.setAutoPlay(true);*/
		stage.getIcons().add(new Image("logo.png"));
		stage.setTitle("THE LAST OF US");
		StackPane root=new StackPane();
		Image g=new Image("Logo4.jpg");
		ImageView view=new ImageView(g);
		view.setFitHeight(150);
		view.setPreserveRatio(true);
		Button button1=new Button();
			//Fading title
		Text text=new Text("THE LAST OF US");
		text.setFill(Color.WHITESMOKE);
		FadeTransition fade =new FadeTransition();
		fade.setNode(text);
		fade.setDuration(Duration.millis(3000));
		fade.setFromValue(0);
		fade.setToValue(1);
		text.setFont(Font.font("Press Gothic",FontWeight.BOLD,150));
		fade.play();
		button1.setPadding(new Insets(-1, -1, -1, -1));
		button1.setTranslateX(0);
		button1.setTranslateY(250);
		button1.setPrefSize(10,10);
		button1.setGraphic(view);
		//Setting Screen size
		int width = (int) Screen.getPrimary().getBounds().getWidth();
		int height = (int) Screen.getPrimary().getBounds().getHeight();
		stage.setFullScreen(true);
		stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("esc"));
		stage.setResizable(false);
		scene1=new Scene(root,width,height);
		root.getChildren().addAll(button1,text);
		Image img=new Image("wall1.jpg",width,height,false,false);
		BackgroundImage myBI= new BackgroundImage(img,null, null, null,new BackgroundSize(1,1,true,true,false,false));
		Background b=new Background(myBI);
		root.setBackground(b);
		ChoosingHero h=new ChoosingHero();
		button1.setOnAction(e -> {
			try {
				h.start(stage);
			} catch (Exception e1) {
				Alert alert=new Alert(Alert.AlertType.WARNING);
				alert.setTitle("Pay Attention!!");
				alert.setContentText(e1.getMessage());
				alert.showAndWait();	
			}
		});
		stage.setScene(scene1);
		stage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
