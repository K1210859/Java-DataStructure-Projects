import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import static javafx.scene.paint.Color.RED;

public class PickUpTrash extends Application {
    double x = 50;
    double y = 50;
    boolean[][] blackColor = new boolean[20][20];
    @Override
    public void start(Stage stage) throws Exception
    {
        stage.setTitle("Pickup Trash");
        Group g = new Group();
        Canvas canvas = new Canvas(400,400);
        for(int i=0;i<blackColor.length;i++)
        {
            for(int j=0;j<blackColor[0].length;j++)
            {
                int x = (int) (Math.random()*100)+1;
                if(x>50)
                {
                    blackColor[i][j]=true;
                }
                else
                    blackColor[i][j]=false;
            }
        }
        g.getChildren().add(canvas);
        Scene sc = new Scene(g);
        stage.setScene(sc);
        paint(canvas.getGraphicsContext2D());

        stage.show();

        canvas.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                x = event.getX();
                y = event.getY();
                boolean trueOrFalse = false;
                int r = (int) ((x-48)/15);
                int c = (int) ((y-48)/15);
                //System.out.println("x-"+x+" y-"+y+" r-"+r+" c-"+c+ " boolean-"+blackColor[r][c]);
                if((x-48) % 15 <= 10 && (y-48) % 15 <= 10) {
                    pickUpTrash(r, c);
                    trueOrFalse = true;
                }
                //System.out.println("x-"+x+" y-"+y+" r-"+r+" c-"+c+ " boolean-"+trueOrFalse);
                paint(canvas.getGraphicsContext2D());
            }
        });
    }

    public void pickUpTrash(int r,int c)
    {
        if(r<0 || c<0 || r>=blackColor.length || c>=blackColor[0].length || !blackColor[r][c]) {
            return;
        }
        else {
            blackColor[r][c]=false;
            pickUpTrash(r,c-1);
            pickUpTrash(r,c+1);
            pickUpTrash(r-1,c);
            pickUpTrash(r+1,c);
        }

    }


    public void paint(GraphicsContext gc)
    {
        gc.setStroke(Color.BLACK);
        for(int i=0;i<blackColor.length;i++)
        {
            for(int j=0;j<blackColor[0].length;j++)
            {
                gc.strokeRect(i*15+50,j*15+50,10,10);
                if(blackColor[i][j])
                    gc.setFill(Color.rgb(66,66,66));
                else
                    gc.setFill(Color.WHITE);
                gc.fillRect(i*15+48,j*15+48,10,10);
            }
        }
        int counter=0;
        for(int i=0;i<blackColor.length;i++)
        {
            for(int j=0;j<blackColor[0].length;j++)
            {
                if(blackColor[i][j]==true)
                {
                    counter++;
                }
            }
        }
        if(counter==0)
        {
            gc.setFont(new Font("Times New Roman",30));
            gc.setFill(RED);
            gc.fillText("You cleared all the trash! Good Job", 50,380,300);
        }

    }

    public static void main(String[] args)
    {
        launch();
    }
}
