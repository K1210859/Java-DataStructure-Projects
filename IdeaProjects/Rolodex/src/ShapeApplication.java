//Pranav Akkaraju, Mr.Tully, 2nd period;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.shape.Polygon;
import javafx.scene.image.Image;
public class ShapeApplication extends Application implements Runnable{
    Rectangle square = null;
    Ellipse circle = null;
    Polygon p = null;
    int points=0;
    long squareMaxTime = 3000;
    long squareSpawnTime = 0;
    long circleMaxTime = 2500;
    long circleSpawnTime = 0;
    long triangleMaxTime = 2000;
    long triangleSpawnTime = 0;
    long updatesPerSecond = 35;
    int shapeWidth = 40;
    int shapeHeight = 40;
    int death=0;
    int lives = 3;
    boolean running=true;
    Image skull;
    Thread t = new Thread();
    Canvas c;
    int skullCounter=0;
    double x;
    double y;
    long updatesDone = 0;
    long startTime = System.nanoTime();
    double spaceBetweenUpdates = 1000/updatesPerSecond;
    @Override
    public void start(Stage stage) throws Exception
    {
        stage.setTitle("Shape Smasher");
        skull = new Image("File:Skull.png");
        Group g = new Group();
        c = new Canvas(400,400);
        g.getChildren().add(c);
        if(running)
        {
            new AnimationTimer()
            {
                @Override
                public void handle(long currentTime)
                {
                    double updatesNeeded = (long) (((System.nanoTime()-startTime)/10000000)/spaceBetweenUpdates);
                    for(;updatesDone<updatesNeeded;updatesDone++)
                    {
                        update();
                    }
                    paint(c.getGraphicsContext2D());
                }
            }.start();
            reset();
            c.setOnMousePressed(event ->{
                if(event.getButton() == MouseButton.SECONDARY && death==3)
                {
                    reset();
                }
                if(running)
                {
                    if(event.getButton()==MouseButton.PRIMARY)
                    {
                        x = event.getX();
                        y = event.getY();
                        if(square.contains(x,y))
                        {
                            points+=1;
                            moveSquare();
                        }
                        if(circle.contains(x,y))
                        {
                            points+=3;
                            moveCircle();
                        }
                        if(p.contains(x,y))
                        {
                            points+=5;
                            moveTriangle();
                        }
                        paint(c.getGraphicsContext2D());
                    }}});}
        Scene sc = new Scene(g);
        stage.setScene(sc);
        reset();
        paint(c.getGraphicsContext2D());
        c.requestFocus();
        stage.show();
    }
    public static void main(String[] args)
    {
        launch(args);
    }
    public void paint(GraphicsContext gc)
    {
        gc.setFill(Color.BLACK);
        gc.fillRect(0,0,400,400);
        gc.setFont(new Font("Times New Roman", 20));
        gc.setFill(Color.WHITE);
        gc.fillText("Skulls: ", 20, 25);
        for (int i = 0; i < death; i++) {
            gc.drawImage(skull, 80 + (skullCounter * 40), 2);
            skullCounter++;
        }
        skullCounter = 0;
        gc.fillText("Score: " + points, 300, 25);
        gc.setFill(Color.RED);
        gc.fillRect(square.getX(), square.getY(), shapeWidth, shapeHeight);
        gc.setFill(Color.GREEN);
        gc.fillOval(circle.getCenterX() - (shapeWidth / 2), circle.getCenterY() - (shapeHeight / 2), shapeWidth, shapeHeight);
        gc.setFill(Color.BLUE);
        double[] xarray = {p.getPoints().get(0), p.getPoints().get(2), p.getPoints().get(4)};
        double[] yarray = {p.getPoints().get(1), p.getPoints().get(3), p.getPoints().get(5)};
        gc.fillPolygon(xarray, yarray, 3);

        if(running==false)
        {
            gc.setFill(Color.WHITE);
            gc.setFont(new Font("Times New Roman",30));
            gc.fillText("Game Over. You lost",50,200);
        }
    }
    public void update()
    {
        if(death==3 && lives==0)
        {
            running=false;
        }
        else if(((System.nanoTime()-squareSpawnTime)/1000000)>=squareMaxTime)
        {
            death++;
            lives--;
            moveSquare();
        }
        else if(((System.nanoTime()-circleSpawnTime)/1000000)>=circleMaxTime)
        {
            death++;
            lives--;
            moveCircle();
        }
        else if(((System.nanoTime()-triangleSpawnTime)/1000000)>=triangleMaxTime)
        {
            death++;
            lives--;
            moveTriangle();
        }

    }
    public void reset()
    {
        lives = 3;
        death=0;
        points=0;
        running=true;
        moveTriangle();
        moveCircle();
        moveSquare();
    }
    public void moveSquare()
    {
        int x = (int) (Math.random()*350);
        int y = (int) (Math.random()*300+50);
        square = new Rectangle(x,y,shapeWidth,shapeHeight);
        squareSpawnTime = System.nanoTime();
    }
    public void moveCircle()
    {
        int x = (int) (Math.random()*350);
        int y = (int) (Math.random()*300+50);
        circle = new Ellipse(x+(shapeWidth/2),y+(shapeHeight/2),shapeWidth/2,shapeHeight/2);
        circleSpawnTime = System.nanoTime();
    }
    public void moveTriangle()
    {
        int x = (int) (Math.random()*350);
        int y = (int) (Math.random()*300+50);
        double x1 = x+(shapeWidth/2);
        double y1 = y;
        double x2 = x+shapeWidth;
        double y2 = y+shapeHeight;
        double x3 = x;
        double y3 = y+shapeHeight;
        p = new Polygon();
        p.getPoints().addAll(new Double[]{x1, y1, x2, y2, x3, y3});
        triangleSpawnTime = System.nanoTime();
    }
    public void run()
    {

    }
}


