package views;

import engine.Game;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.*;

public class ChoosingHero extends Application{
Scene scene2;
	
	public void start(Stage stage) throws Exception {
		stage.setFullScreen(true);
		int width = (int) Screen.getPrimary().getBounds().getWidth();
		int height = (int) Screen.getPrimary().getBounds().getHeight();
		stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("esc"));
		stage.setResizable(false);
		BorderPane border = new BorderPane();
		scene2=new Scene(border,width,height);
		HBox hbox = new HBox();
		hbox.setAlignment(Pos.CENTER);
			//setting background
		Image img2=new Image("test1.jpg",width,height,false,false);
		BackgroundImage myBI2= new BackgroundImage(img2,null, null, null,new BackgroundSize(1,1,true,true,false,false));
		border.autosize();
		Background bb=new Background(myBI2);
		border.setBackground(bb);
		border.backgroundProperty().set(bb);
		
		
			//setting hero box
		Button Button1= new Button ();
		Button Button2= new Button ();
		Button Button3= new Button ();
		Button Button4= new Button ();
		Button Button5= new Button ();
		Button Button6= new Button ();
		Button Button7= new Button ();
		Button Button8= new Button ();
		Image Imag1=new Image("Joel.jpeg",150,150,false,false);
		ImageView view1=new ImageView(Imag1);
		Image Imag2=new Image("Ellie2.jpg",150,150,false,false);
		ImageView view2=new ImageView(Imag2);
		Image Imag3=new Image("Tess2.jpg",150,150,false,false);
		ImageView view3=new ImageView(Imag3);
		Image Imag4=new Image("Riley2.jpg",150,150,false,false);
		ImageView view4=new ImageView(Imag4);
		Image Imag5=new Image("Tommy2.jpg",150,150,false,false);
		ImageView view5=new ImageView(Imag5);
		Image Imag6=new Image("Bill2.jpg",150,150,false,false);
		ImageView view6=new ImageView(Imag6);
		Image Imag7=new Image("David2.jpg",150,150,false,false);
		ImageView view7=new ImageView(Imag7);
		Image Imag8=new Image("Henry2.jpg",150,150,false,false);
		ImageView view8=new ImageView(Imag8);
		Button1.setPadding(new Insets(-1, -1, -1, -1));
		Button2.setPadding(new Insets(-1, -1, -1, -1));
		Button3.setPadding(new Insets(-1, -1, -1, -1));
		Button4.setPadding(new Insets(-1, -1, -1, -1));
		Button5.setPadding(new Insets(-1, -1, -1, -1));
		Button6.setPadding(new Insets(-1, -1, -1, -1));
		Button7.setPadding(new Insets(-1, -1, -1, -1));
		Button8.setPadding(new Insets(-1, -1, -1, -1));
		Button1.setGraphic(view1);
		Button2.setGraphic(view2);
		Button3.setGraphic(view3);
		Button4.setGraphic(view4);
		Button5.setGraphic(view5);
		Button6.setGraphic(view6);
		Button7.setGraphic(view7);
		Button8.setGraphic(view8);
		
		testHeroes T=new testHeroes();
		Game.loadHeroes("Heroes.csv");
		
		Button1.setOnAction(e-> {
			try {
				T.ChooseWhichHero(stage,"Joel.jpeg" ,Game.availableHeroes.get(0),0 );
			} catch (Exception e1) {
				Alert alert=new Alert(Alert.AlertType.WARNING);
				alert.setTitle("Pay Attention!!");
				alert.setContentText(e1.getMessage());
				alert.showAndWait();
			}
		});
		Button2.setOnAction(e-> {
			try {
				T.ChooseWhichHero(stage,"Ellie2.jpg" ,Game.availableHeroes.get(1),1 );
			} catch (Exception e1) {
				Alert alert=new Alert(Alert.AlertType.WARNING);
				alert.setTitle("Pay Attention!!");
				alert.setContentText(e1.getMessage());
				alert.showAndWait();
			}
		});
		Button3.setOnAction(e-> {
			try {
				T.ChooseWhichHero(stage,"Tess2.jpg" ,Game.availableHeroes.get(2),2 );
			} catch (Exception e1) {
				Alert alert=new Alert(Alert.AlertType.WARNING);
				alert.setTitle("Pay Attention!!");
				alert.setContentText(e1.getMessage());
				alert.showAndWait();
			}
		});
		Button4.setOnAction(e-> {
			try {
				T.ChooseWhichHero(stage,"Riley2.jpg" ,Game.availableHeroes.get(3),3 );
			} catch (Exception e1) {
				Alert alert=new Alert(Alert.AlertType.WARNING);
				alert.setTitle("Pay Attention!!");
				alert.setContentText(e1.getMessage());
				alert.showAndWait();
			}
		});
		Button5.setOnAction(e-> {
			try {
				T.ChooseWhichHero(stage,"Tommy2.jpg" ,Game.availableHeroes.get(4),4);
			} catch (Exception e1) {
				Alert alert=new Alert(Alert.AlertType.WARNING);
				alert.setTitle("Pay Attention!!");
				alert.setContentText(e1.getMessage());
				alert.showAndWait();
			}
		});
		Button6.setOnAction(e-> {
			try {
				T.ChooseWhichHero(stage,"Bill2.jpg" ,Game.availableHeroes.get(5),5 );
			} catch (Exception e1) {
				Alert alert=new Alert(Alert.AlertType.WARNING);
				alert.setTitle("Pay Attention!!");
				alert.setContentText(e1.getMessage());
				alert.showAndWait();
			}
		});
		Button7.setOnAction(e-> {
			try {
				T.ChooseWhichHero(stage,"David2.jpg" ,Game.availableHeroes.get(6),6 );
			} catch (Exception e1) {
				Alert alert=new Alert(Alert.AlertType.WARNING);
				alert.setTitle("Pay Attention!!");
				alert.setContentText(e1.getMessage());
				alert.showAndWait();
			}
		});
		Button8.setOnAction(e-> {
			try {
				T.ChooseWhichHero(stage,"Henry2.jpg" ,Game.availableHeroes.get(7),7 );
			} catch (Exception e1) {
				Alert alert=new Alert(Alert.AlertType.WARNING);
				alert.setTitle("Pay Attention!!");
				alert.setContentText(e1.getMessage());
				alert.showAndWait();
			}
		});
	
		Label t=new Label("Select a Character" +"\n" +"to view their Data:");
		t.setFont(Font.font("Press Gothic",FontWeight.BOLD,30));
		t.setTextFill(Color.WHITE);
		hbox.getChildren().addAll(t,Button1,Button2,Button3,Button4,Button5,Button6,Button7,Button8);
		hbox.setAlignment(Pos.TOP_LEFT);
		border.setTop(hbox);
		stage.setScene(scene2);
		stage.show();
	}
	
	
	public static void main(String[] args) {
		launch(args);
		
	}

}
