package views;

import java.io.IOException;
import java.util.ArrayList;

import engine.Game;
import exceptions.InvalidTargetException;
import exceptions.NoAvailableResourcesException;
import exceptions.NotEnoughActionsException;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.characters.Hero;
import model.world.CharacterCell;
import model.world.CollectibleCell;
import model.world.TrapCell;

public class Cure extends MapMidGame{
	
	public void cure(Stage stage, Hero h,ArrayList<String> HeroPath,GridPane pane,BorderPane border,ArrayList<String>play,VBox Ad) {
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
		        	TakeAction( stage,  h, HeroPath, pane, border,play,Ad);
		        	
		        });
		        }
	        else {
	        	int Rowin=rowIndex;
	        	int Colin=columnIndex;
	        	HeroT.setOnAction(e->{
	        	h.setTarget(((CharacterCell)Game.map[14-Rowin][Colin]).getCharacter());
	        	TakeAction( stage,  h, HeroPath, pane, border,play,Ad);
	        });
	        
		
	        }
	       
		} 	
		
	}
		
		public void TakeAction(Stage stage, Hero h,ArrayList<String> HeroPath,GridPane pane,BorderPane border,ArrayList<String>play,VBox Ad) {
		
		try {
			System.out.print(h.getTarget());
			h.cure();
			//cured hero adding
			Hero c=Game.heroes.get(Game.heroes.size()-1);
			//switch for hero pic path
			String newHero=CrossCompare(c,play);
			
			Button cured=new Button();
			BackgroundImage vvv= new BackgroundImage(new Image(newHero),null, null, null,new BackgroundSize(1,1,true,true,false,false));
			Background bbbbb=new Background(vvv);
			cured.setBackground(bbbbb);
			cured.setPrefSize(45,45);
			pane.add(cured,h.getTarget().getLocation().y,14-h.getTarget().getLocation().x);
			Move m=new Move();
			
			
		} catch (NoAvailableResourcesException e) {
			
		} catch (InvalidTargetException e) {
			
		} catch (NotEnoughActionsException e) {
			
		}
			
		
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
