package views;

import java.io.IOException;
import java.util.ArrayList;

import Controller.Start;
import engine.Game;
import exceptions.MovementException;
import exceptions.NotEnoughActionsException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Screen;
import javafx.stage.Stage;
import model.characters.*;
import model.collectibles.Supply;
import model.collectibles.Vaccine;
import model.world.CharacterCell;
import model.world.CollectibleCell;
import model.world.TrapCell;

public class MapMidGame extends Application {
	
	Scene MidGame;
public void MidGame1(Stage stage,ArrayList<String> HeroPath) throws Exception {		
		Hero h;
	int width = (int) Screen.getPrimary().getBounds().getWidth();
		int height = (int) Screen.getPrimary().getBounds().getHeight();
		stage.setMaximized(true);
		stage.setResizable(false);
		ArrayList<String>Playables=new ArrayList<String>();
		Playables.add("Joelp.jpg");
		Playables.add("Elliep.jpg");
		Playables.add("Tessp.jpg");
		Playables.add("Rileyp.jpg"); 
		Playables.add("Tommyp.jpg");
		Playables.add("Billp.jpg");
		Playables.add("Davidp.jpg");
		Playables.add("Henryp.jpg");
		BorderPane border=new BorderPane();
		Image Bp=new Image("Backgroound4.jpeg",width,height,false,false);
		BackgroundImage bbp=new BackgroundImage(Bp,null,null,null,new BackgroundSize(1,1,true,true,false,false));
		Background vl=new Background(bbp);
		border.setBackground(vl);
		GridPane pane=new GridPane();
		BorderStroke style=new BorderStroke(Color.DIMGREY,BorderStrokeStyle.SOLID,null,new BorderWidths(1));
		Border bd=new Border(style);
		border.setCenter(pane);
		pane.setAlignment(Pos.CENTER);
		//Getting hero images and plotting their data
		VBox HeroData=new VBox();
		border.setLeft(HeroData);
		
		ArrayList<Text>UpdatingData=new ArrayList<Text>();
		
		for(int i=0;i<HeroPath.size();i++) {
		h=Game.heroes.get(i);
		ImageView mv=new ImageView(new Image(HeroPath.get(i),100,100,false,false));
		Text Show=new Text("Name: " + h.getName()+"\n" +"Type: " + Start.Type(h)+"\n" +  "Attack Damage: " +h.getAttackDmg()+"\n" +"Current HP: " +h.getCurrentHp() +"\n" + "Available Actions: " + h.getActionsAvailable()+"\n"+"Vaccine inventory:"+h.getVaccineInventory().size()+"\n"+"Supply Inventory:"+h.getSupplyInventory().size());
		Show.setFont(Font.font("Press Gothic",FontWeight.SEMI_BOLD,12));
		Show.setFill(Color.WHITE);
		HBox hdata =new HBox (2);
		hdata.getChildren().addAll(mv,Show);
		HeroData.getChildren().add(hdata);
		HeroData.setAlignment(Pos.TOP_LEFT);
		UpdatingData.add(Show);
	}
		Button end=new Button("End Turn");
		end.setPrefSize(100, 60);
		end.setTextFill(Color.BLACK);
		end.setFont((Font.font("Press Gothic",FontWeight.BOLD,12)));
		VBox Ad=new VBox(5);
		Ad.getChildren().add(end);
		Ad.setAlignment(Pos.CENTER_RIGHT);
		;
		border.setRight(Ad);
		Alert alert;
		alert = new Alert(AlertType.ERROR);
		
		StartScreen ms = new StartScreen();
		
		MapMidGame m=new MapMidGame();
		end.setOnAction(e-> {
			try {
				Game.endTurn();
				
				 if(Game.checkWin()==true) {
						
			            alert.setTitle("Game WON");
			            alert.setHeaderText("YOU WIN !!");
			            alert.showAndWait();
			            
				        stage.setScene(ms.scene1);
				        stage.setFullScreen(true);
				        return;
					}
				 if(Game.checkGameOver()==true) {
					
		            alert.setTitle("Game LOST");
		            alert.setHeaderText("YOU ARE DEFEATED !!");
		            alert.showAndWait();
		            
			        stage.setScene(ms.scene1);
			        stage.setFullScreen(true);
			        return;
				}
		        
		       else
				
				m.MidGame1(stage, HeroPath);
				
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
			}
		});
	
		ArrayList<Hero>GameHeroes=new ArrayList<Hero>();
		ArrayList <String> Htemp=new ArrayList<String>();
		ArrayList<Button> HeroButtons=new ArrayList<Button>();
		for(int hi=0;hi<Game.heroes.size();hi++) 
		{
			Button c=new Button();
			h=Game.heroes.get(hi);
			Image img2=new Image(HeroPath.get(hi));
			BackgroundImage v= new BackgroundImage(img2,null, null, null,new BackgroundSize(1,1,true,true,false,false));
			Background b=new Background(v);
			c.setBackground(b);
			pane.add(c, h.getLocation().y, 14-h.getLocation().x);
			c.setPrefSize(45,45);
			HeroButtons.add(c);
			GameHeroes.add(h);
			Htemp.add(HeroPath.get(hi));		
		}
	while(!HeroButtons.isEmpty()) {
			
			Button x=HeroButtons.remove(0);
			x.setOnAction(e-> {
				try {
					ActionsToDo(stage, GameHeroes.remove(0),Htemp.remove(0),HeroPath,border, pane,Ad,Playables,UpdatingData);
				} catch (Exception e1) {
					Alert alert2=new Alert(Alert.AlertType.WARNING);
					alert2.setTitle("Pay Attention!!");
					alert2.setContentText(e1.getMessage());
					alert2.showAndWait();
				}
			});
			
		}
		
		for(int i=0;i<15;i++) {
			for(int j=0;j<15;j++) {
				Button c1=new Button();
				c1.setBorder(bd);
				
				if(Game.map[i][j].isVisible()) {
					
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
						else {
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
					
				}else {
					
					Image ig=new Image("EmptyTile2.jpeg");
					BackgroundImage vv= new BackgroundImage(ig,null, null, null,new BackgroundSize(1,1,true,true,false,false));
					Background bb=new Background(vv);
					c1.setBackground(bb);
					pane.add(c1, j, 14-i);
					
				}
				
				c1.setPrefSize(45,45);
			
			}
		}
		
			
		MidGame=new Scene(border,width,height);
		stage.sizeToScene();
		stage.setScene(MidGame);
		start(stage);
	}
		public void start(Stage stage) throws Exception {
			stage.show();	
			}
			

	public static void main(String[] args) {
		launch(args);

	}
public void ActionsToDo(Stage stage,Hero h,String HeroAdded,ArrayList<String>HeroPath,BorderPane border,GridPane pane,VBox Ad,ArrayList<String>Playables ,ArrayList<Text>UpdatingData) throws Exception {
		Button move=new Button("Move");
		Button attack=new Button("Attack");
		Button cure=new Button("Cure");
		Button UseSp=new Button("UseSp");
		
		move.setPrefSize(100, 60);
		move.setTextFill(Color.BLACK);
		move.setFont((Font.font("Press Gothic",FontWeight.BOLD,12)));
		
		
		attack.setPrefSize(100,60);
		attack.setTextFill(Color.BLACK);
		attack.setFont((Font.font("Press Gothic",FontWeight.BOLD,12)));
		
		cure.setPrefSize(100,60);
		cure.setTextFill(Color.BLACK);
		cure.setFont((Font.font("Press Gothic",FontWeight.BOLD,12)));
		
		
		UseSp.setPrefSize(100, 60);
		UseSp.setTextFill(Color.BLACK);
		UseSp.setFont((Font.font("Press Gothic",FontWeight.BOLD,12)));
		
		Move m=new Move();
		Attack a=new Attack();
		Cure c=new Cure();
		useSP sp=new useSP();
		
		move.setOnAction(e-> {
			try {
				m.move(stage, h, HeroAdded, border, pane,UpdatingData);
			} catch (Exception e1) {
				
			}
		
		});
		
		attack.setOnAction(e-> {
			a.attackk(stage, h, HeroAdded, pane, border,UpdatingData);
		
		});
		
		cure.setOnAction(e-> {
			c.cure(stage, h, HeroPath, pane, border, Playables,Ad);
		
	});
		UseSp.setOnAction(e-> {
			try {
				sp.UseCharacterSpecial(stage, h, pane, border, HeroAdded);
			} catch (Exception e1) {
				System.out.print("Cannot");
			}
		
	});
	
	Ad.getChildren().addAll(move,attack,cure,UseSp);
	
}
public void UpdateHeroData(ArrayList<Text>UpdatingData) throws IOException {
	
	for(int i=0;i<Game.heroes.size();i++) {
		Hero h=Game.heroes.get(i);
		Text Show=UpdatingData.get(i);
		UpdatingData.set(i, null);
		Show=new Text("Name: " + h.getName()+"\n" +"Type: " + Start.Type(h)+"\n" +  "Attack Damage: " +h.getAttackDmg()+"\n" +"Current HP: " +h.getCurrentHp() +"\n" + "Available Actions: " + h.getActionsAvailable()+"\n"+"Vaccine inventory:"+h.getVaccineInventory().size()+"\n"+"Supply Inventory:"+h.getSupplyInventory().size());
		Show.setFont(Font.font("Press Gothic",FontWeight.SEMI_BOLD,12));
		Show.setFill(Color.WHITE);
		
		
	}
	
	
	
	
}


	

}
