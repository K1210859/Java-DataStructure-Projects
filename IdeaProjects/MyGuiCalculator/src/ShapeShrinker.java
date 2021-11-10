import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ShapeShrinker extends Application {
    RadioButton btn_circle = new RadioButton("Circle");
    RadioButton btn_square = new RadioButton("Square");
    RadioButton btn_triangle = new RadioButton("Triangle");
    String shapeSelected = "";
    String colorsSelected = "";
    Button btn_display = new Button("Display");
    CheckBox box_red = new CheckBox("Red");
    CheckBox box_green = new CheckBox("Green");
    CheckBox box_blue = new CheckBox("Blue");

    ComboBox<Integer> shrinkpercent = new ComboBox<>();
    GridPane gp_main = new GridPane();
    GridPane gp_shape = new GridPane();
    GridPane gp_colors = new GridPane();
    ToggleGroup tg_shapes = new ToggleGroup();
    TitledPane title_shape = new TitledPane();
    TitledPane title_colors = new TitledPane();
    TitledPane title_shrink = new TitledPane();
    GraphicsContext gc;
    @Override
    public void start(Stage primaryStage) throws Exception {
        Group group = new Group();
        Scene scene = new Scene(group, 600, 700);
        Canvas c = new Canvas(420,420);
        primaryStage.setTitle("K1210859");
        for(int i=1;i<101;i++)
        {
            shrinkpercent.getItems().add(i);
        }
        title_shape.setText("Shape");
        title_colors.setText("Colors");
        title_shrink.setText("Shrink Percentage");
        title_shape.setMinWidth(200);
        title_colors.setMinWidth(200);
        btn_circle.setToggleGroup(tg_shapes);
        btn_square.setToggleGroup(tg_shapes);
        btn_triangle.setToggleGroup(tg_shapes);

        gp_shape.add(btn_circle,0,0, 1, 1);
        gp_shape.add(btn_square,0,1,1,1);
        gp_shape.add(btn_triangle,0,2,1,1);

        gp_colors.add(box_red,0,0, 1, 1);
        gp_colors.add(box_green,0,1,1,1);
        gp_colors.add(box_blue,0,2,1,1);

        title_shrink.setContent(shrinkpercent);
        title_shape.setContent(gp_shape);
        title_colors.setContent(gp_colors);
        gp_main.add(title_shape,0,0,1,1);
        gp_main.add(title_colors,1,0,1,1);
        gp_main.add(title_shrink,0,1,2,1);
        gp_main.add(c,0,2,2,1);
        gp_main.add(btn_display,1,3,2,1);
        title_shape.setContent(gp_shape);
        gp_main.setHgap(20);
        gp_main.setVgap(20);
        gp_main.setPrefHeight(scene.getHeight());
        gp_main.setPrefWidth(scene.getWidth());
        gp_main.setAlignment(Pos.CENTER);
        btn_display.setAlignment(Pos.CENTER);
        //btn_display.setPrefWidth(Double.MAX_VALUE);
        title_colors.setCollapsible(false);
        title_shape.setCollapsible(false);
        title_shrink.setCollapsible(false);
        shrinkpercent.setValue(10);
        btn_circle.setSelected(true);
        group.getChildren().addAll(gp_main);
        btn_display.setOnAction(event -> {
            if(!box_red.isSelected() && !box_blue.isSelected() && !box_green.isSelected())
            {
                new Alert(Alert.AlertType.ERROR,"No color has been selected").showAndWait();
            }
            else if(box_blue.isSelected() || box_green.isSelected() || box_red.isSelected())
            {
                if(btn_circle.isSelected())
                    shapeSelected = "Circle";
                else if(btn_square.isSelected())
                    shapeSelected = "Square";
                else if(btn_triangle.isSelected())
                    shapeSelected = "Triangle";
            }
            draw(c.getGraphicsContext2D());
        });

        primaryStage.setScene(scene);
        draw(c.getGraphicsContext2D());
        primaryStage.show();

    }
    public void draw(GraphicsContext gc)
    {
        gc.setFill(Color.BLACK);
        gc.fillRect(0,0,420,420);
        int r=0;
        int g=0;
        int b =0;
        if(box_blue.isSelected())
        {
            b = (int) (Math.random()*256);
        }
        if(box_green.isSelected())
        {
            g = (int) (Math.random()*256);
        }
        if(box_red.isSelected())
        {
            r = (int) (Math.random()*256);
        }
        gc.setStroke(Color.rgb(r,g,b));
        if(shapeSelected.equals("Square"))
        {
            int shrinker = shrinkpercent.getValue();
            double squareWidth=350;
            double squareHeight=350;
            while(squareHeight>1)
            {
                gc.strokeRect(210-(squareWidth/2),210-(squareHeight/2),squareWidth,squareHeight);
                squareWidth*= (1-(shrinker/100.));
                squareHeight*= (1-(shrinker/100.));
                if(box_blue.isSelected())
                {
                    b = (int) (Math.random()*256);
                }
                if(box_green.isSelected())
                {
                    g = (int) (Math.random()*256);
                }
                if(box_red.isSelected())
                {
                    r = (int) (Math.random()*256);
                }
                gc.setStroke(Color.rgb(r,g,b));
            }
        }
        else if(shapeSelected.equals("Triangle"))
        {
            int shrinker = shrinkpercent.getValue();
            double triangleWidth=350;
            double triangleHeight=350;
            while(triangleHeight>1)
            {
                double[] xPoints = new double[3];
                xPoints[0] = 210-triangleWidth/2;
                xPoints[1] = 210;
                xPoints[2] = 210+triangleWidth/2;
                double[] yPoints = new double[3];
                yPoints[0] = 210+triangleHeight/2;
                yPoints[1] = 210-triangleHeight/2;
                yPoints[2] = 210+triangleHeight/2;
                gc.strokePolygon(xPoints,yPoints,3);
                triangleWidth*= (1-(shrinker/100.));
                triangleHeight*= (1-(shrinker/100.));
                if(box_blue.isSelected())
                {
                    b = (int) (Math.random()*256);
                }
                if(box_green.isSelected())
                {
                    g = (int) (Math.random()*256);
                }
                if(box_red.isSelected())
                {
                    r = (int) (Math.random()*256);
                }
                gc.setStroke(Color.rgb(r,g,b));
            }
        }
        else if(shapeSelected.equals("Circle"))
        {
            int shrinker = shrinkpercent.getValue();
            double circleWidth=350;
            double circleHeight=350;
            while(circleHeight>1)
            {
                gc.strokeOval(210-(circleWidth/2),210-(circleHeight/2),circleWidth,circleHeight);
                circleWidth*= (1-(shrinker/100.));
                circleHeight*= (1-(shrinker/100.));
                if(box_blue.isSelected())
                {
                    b = (int) (Math.random()*256);
                }
                if(box_green.isSelected())
                {
                    g = (int) (Math.random()*256);
                }
                if(box_red.isSelected())
                {
                    r = (int) (Math.random()*256);
                }
                gc.setStroke(Color.rgb(r,g,b));
            }
        }
    }
    public static void main(String[] args)
    {
        launch(args);
    }
}
