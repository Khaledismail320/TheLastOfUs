package views;

import java.io.IOException;

import Controller.Start;
import engine.Game;
import exceptions.InvalidTargetException;
import exceptions.NoAvailableResourcesException;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.*;
import model.characters.*;
import model.collectibles.Supply;
import model.collectibles.Vaccine;
import model.world.CharacterCell;
import model.world.CollectibleCell;
import model.world.TrapCell;
public class useSP extends MapMidGame {
	public void UseCharacterSpecial(Stage stage,Hero h,GridPane pane,BorderPane border,String HeroPath) throws Exception {
		Move m=new Move();
		String s=Start.Type(h);
		switch(s) {	
		case("Fighter"):
			h.useSpecial();
			break;
		case("Explorer"):
			h.useSpecial();
			ExpSp(pane);
			break;
		case("Medic"):
			h.useSpecial();
			m.UpdatingActionExp(pane, HeroPath, h);
	}
	}
	public void ExpSp(GridPane pane) {
		for(int i=0;i<15;i++) {
			for(int j=0;j<15;j++) {
					Button c1=new Button();
					if(Game.map[i][j] instanceof CharacterCell) {
						if(((CharacterCell)Game.map[i][j]).getCharacter()!=null) {
							if(((CharacterCell)Game.map[i][j]).getCharacter() instanceof Zombie) {						
							Image ig=new Image("Zombiep.jpg");
							BackgroundImage vv= new BackgroundImage(ig,null, null, null,new BackgroundSize(1,1,true,true,false,false));
							Background bb=new Background(vv);
							c1.setBackground(bb);
							pane.add(c1, j, 14-i);
							}
					}else if(((CharacterCell)Game.map[i][j]).getCharacter()==null) {
					Image ig=new Image("Grunge-Dark-Background2.jpg");
						BackgroundImage vv= new BackgroundImage(ig,null, null, null,new BackgroundSize(1,1,true,true,false,false));
						Background bb=new Background(vv);
						c1.setBackground(bb);
						pane.add(c1, j, 14-i);	
					}		
				}else if(Game.map[i][j] instanceof CollectibleCell) {
					if(((CollectibleCell)Game.map[i][j]).getCollectible() instanceof Supply){
					Image ig=new Image("Supply.jpg");
					BackgroundImage vv= new BackgroundImage(ig,null, null, null,new BackgroundSize(1,1,true,true,false,false));
					Background bb=new Background(vv);
					c1.setBackground(bb);
					pane.add(c1, j, 14-i);
					}
					else if(((CollectibleCell)Game.map[i][j]).getCollectible() instanceof Vaccine) {
						Image ig=new Image("Vaccine.jpg");
						BackgroundImage ll= new BackgroundImage(ig,null, null, null,new BackgroundSize(1,1,true,true,false,false));
						Background bbb=new Background(ll);
						c1.setBackground(bbb);
						pane.add(c1, j, 14-i);
					}
				}else if(Game.map[i][j] instanceof TrapCell) {
					Image ig=new Image("Grunge-Dark-Background2.jpg");
					BackgroundImage vv= new BackgroundImage(ig,null, null, null,new BackgroundSize(1,1,true,true,false,false));
					Background bb=new Background(vv);
					c1.setBackground(bb);
					pane.add(c1, j, 14-i);
					}
				c1.setPrefSize(45, 45);	
			}
		}}
	public void MedSp(Stage stage ,Hero h,GridPane pane,String HeroPath,BorderPane border) {
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
	        	TakeAction( stage,  h, HeroPath, pane, border);  	
	        });
	        }
	        else {
	        	int Rowin=rowIndex;
	        	int Colin=columnIndex;
	        	HeroT.setOnAction(e->{
	        		
	        	h.setTarget(((CharacterCell)Game.map[14-Rowin][Colin]).getCharacter());
	        	TakeAction( stage,  h, HeroPath, pane, border);
	        	
	        });     
	      }
	   }
	}
	public void TakeAction(Stage stage, Hero h,String HeroPath,GridPane pane,BorderPane border) {
		
		
			System.out.print(h.getTarget());
			try {
				System.out.print(h.getTarget());
				h.useSpecial();
			} catch (NoAvailableResourcesException e) {
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
	
	
	
	


