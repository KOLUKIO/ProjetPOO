// last modif 29/11

package game;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaException;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import shapes.Circle;
import shapes.Point2D;
import shapes.Shape2D;

public class Game extends Application {
	
	
	private int score;
	private final static int WIDTH = 1600;
	private final static int HEIGHT = 900;
	
	volatile boolean control_pressed = false;

	public static String getRessourcePathByName(String name) {
		return Game.class.getResource('/' + name).toString();
	}

	public static void main(String[] args) {
		launch(args);
	}


	public void start(Stage stage) throws Exception {
		
		stage.setTitle("GameTest1");
		stage.setResizable(false);
		
		Group root = new Group();
		Scene scene = new Scene(root);
		Canvas canvas = new Canvas(WIDTH, HEIGHT);
		root.getChildren().add(canvas);
		
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFont(Font.font("Helvetica", FontWeight.BOLD, 24));
		gc.setFill(Color.BISQUE);
		gc.setStroke(Color.RED);
		gc.setLineWidth(1);
		
		Image space = new Image(getRessourcePathByName("images/space2.jpg"), WIDTH, HEIGHT, false, false);
		
		//rajout d'une planete premier test
		
		Point2D p1 = new Point2D(WIDTH/2,HEIGHT/2);
		Shape2D hitboxplanet1 = new Circle(p1, 200);
		Planet planet1 = new Planet(getRessourcePathByName("images/BlueRed1.png"), WIDTH/2, HEIGHT/2, hitboxplanet1.getradius()*2, hitboxplanet1,WIDTH-hitboxplanet1.getradius()*2, HEIGHT-hitboxplanet1.getradius()*2, 0);
		
		//un vaisseau au pif
		
		
		Point2D pv = new Point2D(30,30);
		Shape2D hitboxvaisseau1 = new Circle(pv, 50);
		Ships vaisseau1 = new Ships(getRessourcePathByName("images/BlueRed1Ship.png"), 30, 30, hitboxvaisseau1.getradius(), WIDTH, HEIGHT, 5, 5, hitboxvaisseau1);
		
		
		
		
		stage.setScene(scene);
		stage.show();
		
		EventHandler<MouseEvent> mouseHandler = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				/*System.out.println("test :"+control_pressed);
				if(control_pressed == true) {
					Sprite pinapple = new Sprite(pinappleorig);
					pinapple.setPosition(e.getX() - pinapple.width() / 2, e.getY() - pinapple.height() / 2);
					changeSpeed(pinapple);
					pinapples.add(pinapple);
				}else {
				spaceship.setSpeed(0, 0);
				spaceship.setPosition(e.getX() - spaceship.width() / 2, e.getY() - spaceship.height() / 2);
				}*/
				Point2D p_e = new Point2D(e.getX(),e.getY());
				if(hitboxvaisseau1.isInside(p_e)) {
					System.out.println("dedans ! click : "+p_e.toString()+" planet :"+hitboxvaisseau1.toString());
				}else {
					System.out.println("dehors... click : "+p_e.toString()+" planet :"+hitboxvaisseau1.toString());
				}
			}
		};
		scene.setOnMousePressed(mouseHandler);
		
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent e) {
				vaisseau1.changeSpeed(e.getCode());
			}
		});
		
		new AnimationTimer() {

			
			public void handle(long arg0) {
				Point2D changePoint = new Point2D(vaisseau1.getPosX(),vaisseau1.getPosY());
				hitboxvaisseau1.setcenter(changePoint);
				gc.drawImage(space, 0, 0);
				vaisseau1.updatePosition();
				planet1.render(gc);
				vaisseau1.render(gc);
			}
			
		}.start();
		
	}
	
	
	
	

}






























/*public class Game extends Application {
	private int score;
	private final static int WIDTH = 600;
	private final static int HEIGHT = 600;
	private final static int NBPINAPPLES = 400;

	public static String getRessourcePathByName(String name) {
		return Game.class.getResource('/' + name).toString();
	}

	public static void main(String[] args) {
		launch(args);
	}

	private void changeSpeed(Sprite pinapple) {
		int max = 5;
		pinapple.setSpeed(max * Math.random() - max / 2, max * Math.random() - max / 2);
	}

	public void start(Stage stage) {

		stage.setTitle("Alien vs Pinapples");
		stage.setResizable(false);

		Group root = new Group();
		Scene scene = new Scene(root);
		Canvas canvas = new Canvas(WIDTH, HEIGHT);
		root.getChildren().add(canvas);

		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFont(Font.font("Helvetica", FontWeight.BOLD, 24));
		gc.setFill(Color.BISQUE);
		gc.setStroke(Color.RED);
		gc.setLineWidth(1);

		Image space = new Image(getRessourcePathByName("images/space.jpg"), WIDTH, HEIGHT, false, false);

		Sprite spaceship = new Sprite(getRessourcePathByName("images/alien.png"), 62, 36, WIDTH, HEIGHT);
		spaceship.setPosition(WIDTH / 2 - spaceship.width() / 2, HEIGHT / 2 - spaceship.height() / 2);

		Collection<Sprite> pinapples = new ArrayList<Sprite>();
		Sprite pinappleorig = new Sprite(getRessourcePathByName("images/pinapple.png"), 8, 12, WIDTH, HEIGHT);
		for (int i = 0; i < NBPINAPPLES; i++) {
			Sprite pinapple = new Sprite(pinappleorig);
			pinapple.setPosition(WIDTH * Math.random(), HEIGHT * Math.random());
			changeSpeed(pinapple);
			pinapples.add(pinapple);
		}

		stage.setScene(scene);
		stage.show();

		EventHandler<MouseEvent> mouseHandler = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				spaceship.setSpeed(0, 0);
				spaceship.setPosition(e.getX() - spaceship.width() / 2, e.getY() - spaceship.height() / 2);
			}
		};

		scene.setOnMouseDragged(mouseHandler);
		scene.setOnMousePressed(mouseHandler);

		MediaPlayer mediaPlayer = null;
		try {
			mediaPlayer = new MediaPlayer(new Media(getRessourcePathByName("sounds/Engine.mp4")));// Only format allowed
																									// in the context of
																									// the project (mp4)

		} catch (MediaException e) {
			// in case of a platform without sound capabilities
		}
		MediaPlayer mediaPlayerPffft = null;
		try {
			mediaPlayerPffft = new MediaPlayer(new Media(getRessourcePathByName("sounds/Explosion.mp4")));

		} catch (MediaException e) {
			// in case of a platform without sound capabilities
		}

		final MediaPlayer mediaPlayerFinalCopy = mediaPlayer;// final copies are needed to transmit to inner classes
		final MediaPlayer mediaPlayerBoomFinalCopy = mediaPlayerPffft;

		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent e) {
				spaceship.changeSpeed(e.getCode());
				if (mediaPlayerFinalCopy != null) {
					mediaPlayerFinalCopy.stop();
					mediaPlayerFinalCopy.play();
				}
			}
		});

		new AnimationTimer() {
			public void handle(long arg0) {
				gc.drawImage(space, 0, 0);

				spaceship.updatePosition();

				Iterator<Sprite> it = pinapples.iterator();
				while (it.hasNext()) {
					Sprite pinapple = it.next();
					pinapple.updatePosition();
					if (pinapple.intersects(spaceship)) {
						it.remove();
						if (mediaPlayerBoomFinalCopy != null) {
							mediaPlayerBoomFinalCopy.stop();
							mediaPlayerBoomFinalCopy.play();
						}
						score += 100;
					} else {
						pinapple.render(gc);
						if (Math.random() > 0.995) {
							changeSpeed(pinapple);
						}
					}
				}

				spaceship.render(gc);

				String txt = "Score: " + score;
				gc.fillText(txt, WIDTH - 36, 36);
				gc.strokeText(txt, WIDTH - 36, 36);
				gc.setTextAlign(TextAlignment.RIGHT);
			}
		}.start();
	}
}*/
