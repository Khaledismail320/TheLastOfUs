package views;

import java.io.IOException;
import java.util.ArrayList;

import Controller.Start;
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
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import model.characters.Hero;

public class testHeroes extends Application{
	
	Scene ChosenH;
	public void ChooseWhichHero(Stage stage,String HeroPath,Hero h,int z) throws IOException {
		
		ArrayList<String>Playables=new ArrayList<String>();
		Playables.add("Joelp.jpg");
		Playables.add("Elliep.jpg");
		Playables.add("Tessp.jpg");
		Playables.add("Rileyp.jpg");
		Playables.add("Tommyp.jpg");
		Playables.add("Billp.jpg");
		Playables.add("Davidp.jpg");
		Playables.add("Henryp.jpg");
		
		//method to cross compare hero with image
		String PlayHero=CrossCompare(h,Playables);
		
		int width = (int) Screen.getPrimary().getBounds().getWidth();
		int height = (int) Screen.getPrimary().getBounds().getHeight();
		stage.setMaximized(true);
		stage.setWidth(width);
		stage.setHeight(height);
		stage.setResizable(false);
		BorderPane border = new BorderPane();
		ChosenH=new Scene(border,width,height);
		
		HBox hbox = new HBox();
		hbox.setAlignment(Pos.CENTER);
			//setting background
		Image img2=new Image("test1.jpg",width,height,false,false);
		BackgroundImage myBI2= new BackgroundImage(img2,null, null, null,new BackgroundSize(1,1,true,true,false,false));
		Background bb=new Background(myBI2);
		border.setBackground(bb);
		
		
			//setting hero box
		Button Button1= new Button ();
		Button Button2= new Button ();
		Button Button3= new Button ();
		Button Button4= new Button ();
		Button Button5= new Button ();
		Button Button6= new Button ();
		Button Button7= new Button ();
		Button Button8= new Button ();
		Image Imag1=new Image("P0.jpg",150,150,false,false);
		ImageView view1=new ImageView(Imag1);
		Image Imag2=new Image("P1.jpg",150,150,false,false);
		ImageView view2=new ImageView(Imag2);
		Image Imag3=new Image("P2.jpg",150,150,false,false);
		ImageView view3=new ImageView(Imag3);
		Image Imag4=new Image("P3.jpg",150,150,false,false);
		ImageView view4=new ImageView(Imag4);
		Image Imag5=new Image("P4.jpg",150,150,false,false);
		ImageView view5=new ImageView(Imag5);
		Image Imag6=new Image("P5.jpg",150,150,false,false);
		ImageView view6=new ImageView(Imag6);
		Image Imag7=new Image("P6.jpg",150,150,false,false);
		ImageView view7=new ImageView(Imag7);
		Image Imag8=new Image("P7.jpg",150,150,false,false);
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
		
		Label t=new Label("Select a Character" +"\n" +"to view their Data:");
		t.setFont(Font.font("Press Gothic",FontWeight.BOLD,30));
		t.setTextFill(Color.WHITE);
		hbox.getChildren().addAll(t,Button1,Button2,Button3,Button4,Button5,Button6,Button7,Button8);
		hbox.setAlignment(Pos.TOP_LEFT);
		border.setTop(hbox);
		
		//NEW scene settings
		
		
		VBox v=new VBox(10);
		Image c=new Image(HeroPath,200,200,false,false);
		ImageView ic=new ImageView(c);
		
		v.getChildren().add(ic);
		border.setCenter(v);
		v.setAlignment(Pos.CENTER);
		 
		
		//character data
			
		Text Show=new Text("Name: " + h.getName()+"\n" +"Type: " + Start.Type(h)+"\n" +  "Attack Damage: " +h.getAttackDmg()+"\n" +"Max HP: " +h.getMaxHp() +"\n" + "Max Actions: " + h.getMaxActions());
		Show.setFont(Font.font("Press Gothic",FontWeight.BOLD,20));
		Show.setFill(Color.WHITE);
		v.getChildren().add(Show);	
		border.setCenter(v);
		Text s2=new Text("Select Another");
		s2.setFont(Font.font("Stencil",FontWeight.BOLD,15));
		s2.setFill(Color.WHITE);
		Button select=new Button(s2.getText());
		
		select.setTextFill(Color.BLACK);
		select.setFont((Font.font("Press Gothic",FontWeight.BOLD,12)));
		ChoosingHero ch=new ChoosingHero();
		select.setPrefHeight(40);
		select.setOnAction(e -> {
			try {
				ch.start(stage);
			} catch (Exception e1) {
				Alert alert=new Alert(Alert.AlertType.WARNING);
				alert.setTitle("Pay Attention!!");
				alert.setContentText(e1.getMessage());
				alert.showAndWait();
			}
		} );
		Text s1=new Text("Continue");
		s1.setFont(Font.font("Stencil",FontWeight.BOLD,15));
		s1.setFill(Color.WHITE);
		Button con=new Button(s1.getText());
		con.setPrefSize(80, 40);
		con.setTextFill(Color.BLACK);
		con.setFont((Font.font("Press Gothic",FontWeight.BOLD,12)));
		ArrayList<String>Hi=new ArrayList<String>();
		Hi.add(PlayHero);
		MapMidGame m=new MapMidGame();
		con.setOnAction(e -> {
			try {
				Game.startGame(h);
				m.MidGame1(stage, Hi);
			} catch (Exception e1) {
				Alert alert=new Alert(Alert.AlertType.WARNING);
				alert.setTitle("Pay Attention!!");
				alert.setContentText(e1.getMessage());
				alert.showAndWait();
			}
		});
		HBox hx=new HBox(10);
		hx.getChildren().addAll(select,con);
		hx.setAlignment(Pos.CENTER);
		v.getChildren().add(hx);
		stage.sizeToScene();
		stage.setScene(ChosenH);
		stage.show();
	}
	
	public void start(Stage stage) throws Exception {
		stage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
			
	}
	
	public String CrossCompare(Hero h,ArrayList<String>Playables) {
		
		switch(h.getName()) {
		
		case ("Joel Miller"):
			return Playables.get(0);
			
		case ("Ellie Williams"):
			return Playables.get(1);
		
		case ("Tess"):
			return Playables.get(2);
		
		case ("Riley Abel"):
			return Playables.get(3);
	
		case ("Tommy Miller"):
			return Playables.get(4);
	
		case ("Bill"):
			return Playables.get(5);
	
		case ("David"):
			return Playables.get(6);
		
		case ("Henry Burell"):
			return Playables.get(7);
	}
		return null;
	}
	
		
	}
	
	
	


