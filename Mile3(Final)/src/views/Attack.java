package views;


import java.util.ArrayList;

import engine.Game;
import exceptions.InvalidTargetException;
import exceptions.NotEnoughActionsException;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.characters.Hero;
import model.world.CharacterCell;
import model.world.CollectibleCell;
import model.world.TrapCell;

public class Attack extends MapMidGame{
	
	public void attackk(Stage stage, Hero h,String HeroPath,GridPane pane,BorderPane border,ArrayList<Text>UpdatingData) {
		Label choose=new Label("choose a cell to attack");
		
		HBox hxx=new HBox();
		
		choose.setFont(Font.font("Press Gothic",FontWeight.BOLD,15));
		choose.setTextFill(Color.WHITE);
		hxx.getChildren().add(choose);
		hxx.setAlignment(Pos.TOP_RIGHT);
		border.setTop(hxx);
		choose.setAlignment(Pos.TOP_RIGHT);
		
		
		for (Node node : pane.getChildren()) {
			 Integer columnIndex = GridPane.getColumnIndex(node);
		        Integer rowIndex = GridPane.getRowIndex(node);

		        if (columnIndex == null)
		            columnIndex = 0;
		        if (rowIndex == null)
		            rowIndex = 0;
			
	        Button HeroT=(Button)node;
	        if(Game.map[14-rowIndex][columnIndex] instanceof CollectibleCell || Game.map[14-rowIndex][columnIndex] instanceof TrapCell) {
	        HeroT.setOnAction(e->{ 
	        	
	        	h.setTarget(null);
	        	TakeAction( stage,  h, HeroPath, pane, border,UpdatingData);
	        	
	        });
	        }
	        else {
	        	int Rowin=rowIndex;
	        	int Colin=columnIndex;
	        	HeroT.setOnAction(e->{
	        		
	        	h.setTarget(((CharacterCell)Game.map[14-Rowin][Colin]).getCharacter());
	        	TakeAction( stage,  h, HeroPath, pane, border,UpdatingData);
	        	
	        });
	      
	        
	      }
	        	}
		
	}
	public void TakeAction(Stage stage, Hero h,String HeroPath,GridPane pane,BorderPane border,ArrayList<Text>UpdatingData) {
		
		try {
			System.out.print(h.getTarget());
			h.attack();
			
			if(h.getTarget().getCurrentHp()==0) {
				int x=h.getTarget().getLocation().x;
				int y=h.getTarget().getLocation().y;
				h.getTarget().onCharacterDeath();
				Button dead=new Button();
				BackgroundImage vvv= new BackgroundImage(new Image("Grunge-Dark-Background2.jpg"),null, null, null,new BackgroundSize(1,1,true,true,false,false));
				Background bbbbb=new Background(vvv);
				dead.setBackground(bbbbb);
				dead.setPrefSize(45,45);
				pane.add(dead,y,14-x);
							
			}
			if(h.getCurrentHp()==0) {
				int x=h.getLocation().x;
				int y=h.getLocation().y;
				h.onCharacterDeath();
				Button dead=new Button();
				BackgroundImage vvv= new BackgroundImage(new Image("Grunge-Dark-Background2.jpg"),null, null, null,new BackgroundSize(1,1,true,true,false,false));
				Background bbbbb=new Background(vvv);
				dead.setBackground(bbbbb);
				dead.setPrefSize(45,45);
				pane.add(dead,y,14-x);
							
			}
		} catch (NotEnoughActionsException e) {
			Alert alert=new Alert(Alert.AlertType.WARNING);
			alert.setTitle("Pay Attention!!");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		} catch (InvalidTargetException e) {
			Alert alert=new Alert(Alert.AlertType.WARNING);
			alert.setTitle("Pay Attention!!");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
		
		
		
		
	}

	
	

}
