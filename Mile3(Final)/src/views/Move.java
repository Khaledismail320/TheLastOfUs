package views;

import java.io.IOException;
import java.util.ArrayList;

import Controller.Start;
import engine.Game;
import exceptions.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;
import model.characters.Direction;
import model.characters.Hero;
import model.characters.Zombie;
import model.collectibles.Supply;
import model.collectibles.Vaccine;
import model.world.CharacterCell;
import model.world.CollectibleCell;
import model.world.TrapCell;

public class Move extends MapMidGame {

	public void move(Stage stage,Hero h,String HeroAdded,BorderPane border,GridPane pane,ArrayList<Text>UpdatingData) throws Exception {
		Button up=new Button("up");
		Button down=new Button("down");
		Button right=new Button("right");
		Button left=new Button("left");
		
		up.setPrefSize(40, 40);
		down.setPrefSize(40, 40);
		right.setPrefSize(40, 40);
		left.setPrefSize(40, 40);
		
	up.setOnAction(e-> {
		try {
			int y=h.getLocation().y;
			int x=h.getLocation().x;
				
			h.move(Direction.UP);	
			BackgroundImage vvv= new BackgroundImage(new Image("Grunge-Dark-Background2.jpg"),null, null, null,new BackgroundSize(1,1,true,true,false,false));
			Background bbbbb=new Background(vvv);
			Button oldCell=new Button();
			oldCell.setBackground(bbbbb);
			oldCell.setPrefSize(45,45);
			pane.add(oldCell,y,14-x);
			
			
			
			Button NewCell=new Button();
			BackgroundImage v= new BackgroundImage(new Image(HeroAdded),null, null, null,new BackgroundSize(1,1,true,true,false,false));
			Background b=new Background(v);
			NewCell.setBackground(b);
			NewCell.setPrefSize(45,45);
			pane.add(NewCell,h.getLocation().y,14-h.getLocation().x);
			UpdateVis(pane,HeroAdded,h);
			UpdateHeroData(UpdatingData);
			
		}
		catch (NotEnoughActionsException e1) {
			
			
			Alert alert=new Alert(Alert.AlertType.WARNING);
			alert.setTitle("Pay Attention!!");
			alert.setContentText(e1.getMessage());
			alert.showAndWait();
			
		} catch (IOException e1) {
			
		} catch (MovementException e1) {
			e1.printStackTrace();
			Alert alert=new Alert(Alert.AlertType.WARNING);
			alert.setTitle("Pay Attention!!");
			alert.setContentText(e1.getMessage());
			alert.showAndWait();
		}
	});
	down.setOnAction(e-> {
		try {
			int y=h.getLocation().y;
			int x=h.getLocation().x;
				
			h.move(Direction.DOWN);	
			BackgroundImage vvv= new BackgroundImage(new Image("Grunge-Dark-Background2.jpg"),null, null, null,new BackgroundSize(1,1,true,true,false,false));
			Background bbbbb=new Background(vvv);
			Button oldCell=new Button();
			oldCell.setBackground(bbbbb);
			oldCell.setPrefSize(45,45);
			pane.add(oldCell,y,14-x);
			
			
			
			Button NewCell=new Button();
			BackgroundImage v= new BackgroundImage(new Image(HeroAdded),null, null, null,new BackgroundSize(1,1,true,true,false,false));
			Background b=new Background(v);
			NewCell.setBackground(b);
			NewCell.setPrefSize(45,45);
			
			pane.add(NewCell,h.getLocation().y,14-h.getLocation().x);
			
			UpdateVis(pane,HeroAdded,h);
			UpdateHeroData(UpdatingData);
		} catch (MovementException e1) {
			Alert alert=new Alert(Alert.AlertType.WARNING);
			alert.setTitle("Pay Attention!!");
			alert.setContentText(e1.getMessage());
			alert.showAndWait();
		} catch (NotEnoughActionsException e1) {
			Alert alert=new Alert(Alert.AlertType.WARNING);
			alert.setTitle("Pay Attention!!");
			alert.setContentText(e1.getMessage());
			alert.showAndWait();
		} catch (IOException e1) {
			
		}
	});
	right.setOnAction(e-> {
		try {
			int y=h.getLocation().y;
			int x=h.getLocation().x;
				
			h.move(Direction.RIGHT);	
			BackgroundImage vvv= new BackgroundImage(new Image("Grunge-Dark-Background2.jpg"),null, null, null,new BackgroundSize(1,1,true,true,false,false));
			Background bbbbb=new Background(vvv);
			Button oldCell=new Button();
			oldCell.setBackground(bbbbb);
			oldCell.setPrefSize(45,45);
			pane.add(oldCell,y,14-x);
			
			
			
			Button NewCell=new Button();
			BackgroundImage v= new BackgroundImage(new Image(HeroAdded),null, null, null,new BackgroundSize(1,1,true,true,false,false));
			Background b=new Background(v);
			NewCell.setBackground(b);
			NewCell.setPrefSize(45,45);
			
			pane.add(NewCell,h.getLocation().y,14-h.getLocation().x);
			
			UpdateVis(pane,HeroAdded,h);
			UpdateHeroData(UpdatingData);
		} catch (MovementException e1) {
			Alert alert=new Alert(Alert.AlertType.WARNING);
			alert.setTitle("Pay Attention!!");
			alert.setContentText(e1.getMessage());
			alert.showAndWait();
		} catch (NotEnoughActionsException e1) {
			Alert alert=new Alert(Alert.AlertType.WARNING);
			alert.setTitle("Pay Attention!!");
			alert.setContentText(e1.getMessage());
			alert.showAndWait();
		} catch (IOException e1) {
			
		}
	});
	left.setOnAction(e-> {
		try {
			int y=h.getLocation().y;
			int x=h.getLocation().x;
				
			h.move(Direction.LEFT);	
			BackgroundImage vvv= new BackgroundImage(new Image("Grunge-Dark-Background2.jpg"),null, null, null,new BackgroundSize(1,1,true,true,false,false));
			Background bbbbb=new Background(vvv);
			Button oldCell=new Button();
			oldCell.setBackground(bbbbb);
			oldCell.setPrefSize(45,45);
			pane.add(oldCell,y,14-x);
			
			
			
			Button NewCell=new Button();
			BackgroundImage v= new BackgroundImage(new Image(HeroAdded),null, null, null,new BackgroundSize(1,1,true,true,false,false));
			Background b=new Background(v);
			NewCell.setBackground(b);
			NewCell.setPrefSize(45,45);
			
			pane.add(NewCell,h.getLocation().y,14-h.getLocation().x);
			
			UpdateVis(pane,HeroAdded,h);
			UpdateHeroData(UpdatingData);
			
		} catch (MovementException e1) {
			Alert alert=new Alert(Alert.AlertType.WARNING);
			alert.setTitle("Pay Attention!!");
			alert.setContentText(e1.getMessage());
			alert.showAndWait();
		} catch (NotEnoughActionsException e1) {
			Alert alert=new Alert(Alert.AlertType.WARNING);
			alert.setTitle("Pay Attention!!");
			alert.setContentText(e1.getMessage());
			alert.showAndWait();
		} catch (IOException e1) {
			
		}
	});
	
	Image up1=new Image("ArrowU.jpg");
	BackgroundImage vvv= new BackgroundImage(up1,null, null, null,new BackgroundSize(1,1,true,true,false,false));
	Background bbb=new Background(vvv);
	up.setBackground(bbb);

	Image down1=new Image("ArrowD.jpg");
	BackgroundImage vv1= new BackgroundImage(down1,null, null, null,new BackgroundSize(1,1,true,true,false,false));
	Background bbb1=new Background(vv1);
	down.setBackground(bbb1);
	
	Image right1=new Image("ArrowR.jpg");
	BackgroundImage vv11= new BackgroundImage(right1,null, null, null,new BackgroundSize(1,1,true,true,false,false));
	Background bbb11=new Background(vv11);
	right.setBackground(bbb11);
	
	Image left1=new Image("ArrowL.jpg");
	BackgroundImage vv111= new BackgroundImage(left1,null, null, null,new BackgroundSize(1,1,true,true,false,false));
	Background bbb111=new Background(vv111);
	left.setBackground(bbb111);
	
	GridPane dir=new GridPane();
	dir.add(up, 1, 0);
	dir.add(down, 1, 2);
	dir.add(right, 2, 1);
	dir.add(left, 0, 1);
	dir.setAlignment(Pos.CENTER_RIGHT);
	border.setTop(dir);
	
	
	}

	public void UpdateVis(GridPane pane,String HeroPath,Hero h) throws IOException {
		
		if(Start.Type(h).equals("Explorer") && h.isSpecialAction()==true){
			UpdatingActionExp(pane, HeroPath, h);
			
		}else {
	
		for(int i=0;i<15;i++) {
			for(int j=0;j<15;j++) {
				
				if(Game.map[i][j].isVisible()==true) {
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
		}
		}
	

	public void UpdatingActionExp(GridPane pane,String HeroPath,Hero h){
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
		}}	
	}
}
