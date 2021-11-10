import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

public class GraphicalApplication extends Application {
    Group g;
    Canvas c;
    MaxHeap<Integer> list;
    int[][] array = new int[5][4];
    int changingX = 500;
    int changingY = 200;
    ArrayList<Integer> xList = new ArrayList<>();
    ArrayList<Integer> yList = new ArrayList<>();
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("Graphical Heap");
        g = new Group();
        c = new Canvas(1000,800);
        list = new MaxHeap<>();
        c.setOnMousePressed(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                double x = event.getX();
                double y = event.getY();
                int newX = (int) ((x-5)/55);
                int newY = (int) ((y-5)/60);
                if(y<240 && x<270 && (x - 5) % 55 <= 50 && (y - 5) % 60 <= 50 && list.size()<15)
                    list.add(array[newX][newY]);
                if(x<950 && x>850 && y<60 && y>10 && !list.isEmpty())
                    list.remove();
                //System.out.println(list);
            }
            paint(c.getGraphicsContext2D());
        });
        g.getChildren().add(c);
        Scene sc = new Scene(g);
        primaryStage.setScene(sc);
        paint(c.getGraphicsContext2D());
        c.requestFocus();
        primaryStage.show();
    }

    public void paint(GraphicsContext gc)
    {
        gc.setFill(Color.rgb(234,237,237));
        gc.fillRect(0,0,1000,800);
        int startingX = 5;
        int startingY = 5;
        gc.setFill(Color.rgb(153,163,164));
        int counter=1;
        gc.setFont(new Font("Times New Roman", 20));
        for(int i=1;i<6;i++)
        {
            for(int j=1;j<5;j++)
            {
                gc.fillRect(startingX,startingY,50,50);
                if(counter<10)
                    gc.strokeText(counter+"",startingX+20,startingY+30);
                else
                    gc.strokeText(counter+"", startingX+15,startingY+30);
                counter++;
                startingY+=60;
            }
            startingY = 5;
            startingX+=55;
        }
        counter=1;
        for(int i=0;i<array.length;i++)
        {
            for(int j = 0;j<array[0].length;j++)
            {
                array[i][j] = counter;
                counter++;
            }
        }
        gc.setFill(Color.RED);
        gc.fillRoundRect(850,10,100,50,20,20);
        gc.setStroke(Color.BLACK);
        gc.strokeRoundRect(850,10,100,50,20,20);
        gc.strokeText("Remove",867,40);
        xList.add(500);
        xList.add(300);
        xList.add(700);
        xList.add(200);
        xList.add(400);
        xList.add(600);
        xList.add(800);
        xList.add(150);
        xList.add(250);
        xList.add(350);
        xList.add(450);
        xList.add(550);
        xList.add(650);
        xList.add(750);
        xList.add(850);
        yList.add(200);
        yList.add(300);
        yList.add(300);
        yList.add(400);
        yList.add(400);
        yList.add(400);
        yList.add(400);
        yList.add(500);
        yList.add(500);
        yList.add(500);
        yList.add(500);
        yList.add(500);
        yList.add(500);
        yList.add(500);
        yList.add(500);
        gc.setFill(Color.GRAY);
        gc.setFont(new Font("Times New Roman", 15));
        for(int i=0;i<list.size();i++)
        {
            gc.fillRect(xList.get(i),yList.get(i),40,60);
            gc.setStroke(Color.BLACK);
            if(i>0)
            {
                if(i%2==1)
                    gc.strokeLine(xList.get(i)+20,yList.get(i),xList.get((i-1)/2)+20,yList.get((i-1)/2)+60);
                else if(i%2==0)
                    gc.strokeLine(xList.get(i)+20,yList.get(i),xList.get((i-1)/2)+20,yList.get((i-1)/2)+60);
            }
            gc.strokeText(list.get(i)+"",xList.get(i)+13,yList.get(i)+30);
        }
        System.out.println(list);
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}


