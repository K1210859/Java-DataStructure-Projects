import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javafx.scene.image.Image;
import java.util.ArrayList;
import javafx.geometry.Pos;

public class MainApplication extends Application {
    //Image map;
    ArrayList<String> states = new ArrayList<>();
    ArrayList<Integer> numcases = new ArrayList<>();
    ArrayList<Integer> population = new ArrayList<>();
    /*ArrayList<Integer> dead = new ArrayList<>();
    ArrayList<Integer> ratio = new ArrayList<>();
    ArrayList<Boolean> safe = new ArrayList<>();*/

    @Override
    public void start(Stage primaryStage) throws Exception {
        //map = new Image("File:.idea/Images/Map.jpeg");
        population.add(4858979);
        population.add(738432);
        population.add(6828065);
        population.add(2978204);
        population.add(39144818);
        population.add(5456574);
        population.add(3590886);
        population.add(945934);
        population.add(20271272);
        population.add(10214860);
        population.add(1431603);
        population.add(1654930);
        population.add(12859995);
        population.add(6619680);
        population.add(3123899);
        population.add(2911641);
        population.add(4425092);
        population.add(4670724);
        population.add(1329328);
        population.add(6006401);
        population.add(6794422);
        population.add(9922576);
        population.add(5489594);
        population.add(2992333);
        population.add(6083672);
        population.add(1032949);
        population.add(1896190);
        population.add(2890845);
        population.add(1330608);
        population.add(8958013);
        population.add(2085109);
        population.add(19795791);
        population.add(10042802);
        population.add(756927);
        population.add(11613423);
        population.add(3911338);
        population.add(4028977);
        population.add(12802503);
        population.add(1056298);
        population.add(4896146);
        population.add(858469);
        population.add(6600299);
        population.add(27469114);
        population.add(2995919);
        population.add(626042);
        population.add(8382993);
        population.add(7170351);
        population.add(1844128);
        population.add(5771337);
        population.add(586107);
        states.add("Alabama");
        states.add("Alaska");
        states.add("Arizona");
        states.add("Arkansas");
        states.add("California");
        states.add("Colorado");
        states.add("Connecticut");
        states.add("Delaware");
        states.add("Florida");
        states.add("Georgia");
        states.add("Hawaii");
        states.add("Idaho");
        states.add("Illinois");
        states.add("Indiana");
        states.add("Iowa");
        states.add("Kansas");
        states.add("Kentucky");
        states.add("Louisiana");
        states.add("Maine");
        states.add("Maryland");
        states.add("Massachusetts");
        states.add("Michigan");
        states.add("Minnesota");
        states.add("Mississippi");
        states.add("Missouri");
        states.add("Montana");
        states.add("Nebraska");
        states.add("Nevada");
        states.add("New Hampshire");
        states.add("New Jersey");
        states.add("New Mexico");
        states.add("New York");
        states.add("North Carolina");
        states.add("North Dakota");
        states.add("Ohio");
        states.add("Oklahoma");
        states.add("Oregon");
        states.add("Pennsylvania");
        states.add("Rhode Island");
        states.add("South Carolina");
        states.add("South Dakota");
        states.add("Tennessee");
        states.add("Texas");
        states.add("Utah");
        states.add("Vermont");
        states.add("Virginia");
        states.add("Washington");
        states.add("West Virginia");
        states.add("Wisconsin");
        states.add("Wyoming");

        numcases.add(17322);
        numcases.add(430);
        numcases.add(18465);
        numcases.add(6777);
        numcases.add(103886);
        numcases.add(25613);
        numcases.add(41762);
        numcases.add(9422);
        numcases.add(53114);
        numcases.add(45711);
        numcases.add(603);
        numcases.add(2803);
        numcases.add(117455);
        numcases.add(33558);
        numcases.add(18956);
        numcases.add(9719);
        numcases.add(9464);
        numcases.add(38907);
        numcases.add(2282);
        numcases.add(52015);
        numcases.add(95512);
        numcases.add(56621);
        numcases.add(23531);
        numcases.add(15230);
        numcases.add(12795);
        numcases.add(505);
        numcases.add(13654);
        numcases.add(8350);
        numcases.add(4492);
        numcases.add(158844);
        numcases.add(7493);
        numcases.add(166285);
        numcases.add(26488);
        numcases.add(2520);
        numcases.add(34566);
        numcases.add(6238);
        numcases.add(4131);
        numcases.add(71415);
        numcases.add(14635);
        numcases.add(11131);
        numcases.add(4866);
        numcases.add(22266);
        numcases.add(61006);
        numcases.add(9429);
        numcases.add(975);
        numcases.add(43611);
        numcases.add(21071);
        numcases.add(1972);
        numcases.add(17707);
        numcases.add(891);

        /*for(int i = 0; i < 50; i++) {
            numcases.add(0);
        }*/

        primaryStage.setTitle("CoVID-19 Response Map");
        Group group = new Group();
        Scene scene = new Scene(group, 750, 750);

        Label l1 = new Label("CoVID-19 Personal Response Map");
        l1.setFont(new Font("Impact", 45));
        l1.setLayoutX(350);

        Label l2 = new Label("We- Sanjay Sivakumar, Pranav Akkaraju, Jose Ardilla, and Soumil Voma -, the Covid Upstanders, present you our \nCoronavirus Response Tracker. Some functions of this great tool include the addition and reduction of covid cases.\nA key feature that this program provides but others don't is that this program can declare if states are safe or unsafe.");
        l2.setFont(new Font("Arial", 13));

        Canvas c = new Canvas(750, 500);

        Label lbl_new_cases = new Label("Cases: ");
        TextField txt_new_cases = new TextField();

        Label lbl_states = new Label("State: ");
        ComboBox<String> cb = new ComboBox<>();
        for(int i=0;i<states.size();i++) {
            cb.getItems().add(states.get(i));
        }
        Label option = new Label("Option: ");
        ComboBox<String> options = new ComboBox<>();
        options.getItems().add("Add Cases");
        options.getItems().add("Remove Cases");

        HBox statesH = new HBox();
        statesH.getChildren().addAll(lbl_states,cb);
        HBox selection = new HBox();
        selection.getChildren().addAll(option,options);
        HBox cases = new HBox();
        cases.getChildren().addAll(lbl_new_cases,txt_new_cases);

        Button change = new Button("Change");
        change.setAlignment(Pos.CENTER);
        change.setLayoutX(350);
        HBox btn = new HBox();
        btn.getChildren().addAll(change);
        btn.setAlignment(Pos.CENTER);

        HBox combined = new HBox();
        combined.getChildren().addAll(statesH,selection,cases);
        combined.setSpacing(50);
        VBox vbox = new VBox();

        vbox.getChildren().addAll(l1,l2,combined, btn,c);
        vbox.setSpacing(20);
        vbox.setLayoutX(20);
        vbox.setPrefHeight(scene.getHeight());
        group.getChildren().addAll(vbox);
        change.setOnAction(event -> {
            if(cb.getValue().equals("") || options.getValue().equals("") || txt_new_cases.getText().equals(""))
                new Alert(Alert.AlertType.ERROR,"Missing Data Entry").showAndWait();
            else
            {
                if(options.getValue().equals("Add Cases"))
                {
                    String stateChosen = cb.getValue();
                    for(int i=0;i<states.size();i++)
                    {
                        if(states.get(i).equals(stateChosen))
                        {
                            int caseCount=numcases.get(i);
                            int ans = Integer.parseInt(txt_new_cases.getText());
                            numcases.set(i,caseCount+ans);
                        }
                    }
                }
                else if(options.getValue().equals("Remove Cases"))
                {
                    String stateChosen = cb.getValue();
                    for(int i=0;i<states.size();i++)
                    {
                        if(states.get(i).equals(stateChosen))
                        {
                            int caseCount=numcases.get(i);
                            int ans = Integer.parseInt(txt_new_cases.getText());
                            if(caseCount-ans<=0)
                                numcases.set(i,0);
                            else
                                numcases.set(i,caseCount-ans);
                        }
                    }
                }
            }
            cb.setValue("");
            options.setValue("");
            txt_new_cases.setText("");
            draw(c.getGraphicsContext2D());
        });
        primaryStage.setScene(scene);
        draw(c.getGraphicsContext2D());
        primaryStage.show();
    }

    private void draw(GraphicsContext gc) {
        gc.setFill(Color.BLACK);
        gc.fillRect(0,0,750,500);
        gc.setFont(new Font("Arial", 15));
        gc.setFill(Color.BLACK);
        //gc.fillRect(0,300,750,450);
        int startX = 50;
        int startY = 25;
        for(int i=0;i<25;i++)
        {
            double ratio = (double) numcases.get(i)/ population.get(i);
            if(numcases.get(i)>=50000)
                gc.setFill(Color.RED);
            else if(numcases.get(i)>=30000)
                gc.setFill(Color.ORANGE);
            else if(numcases.get(i)>10000)
                gc.setFill(Color.YELLOW);
            else if(numcases.get(i)<=10000)
                gc.setFill(Color.GREEN);
            if(ratio<=0.001)
                gc.fillText(states.get(i)+" - "+ numcases.get(i) + "    SAFE",startX,startY);
            else
                gc.fillText(states.get(i)+" - "+ numcases.get(i) + "    UNSAFE",startX,startY);
            startY+=15;
        }
        startX = 400;
        startY = 25;
        for(int i=25;i<50;i++)
        {
            double ratio = (double) numcases.get(i)/population.get(i);
            if(numcases.get(i)>=50000)
                gc.setFill(Color.RED);
            else if(numcases.get(i)>=30000)
                gc.setFill(Color.ORANGE);
            else if(numcases.get(i)>10000)
                gc.setFill(Color.YELLOW);
            else if(numcases.get(i)<=10000)
                gc.setFill(Color.GREEN);
            if(ratio<=0.001)
                gc.fillText(states.get(i)+" - "+ numcases.get(i) + "    SAFE",startX,startY);
            else
                gc.fillText(states.get(i)+" - "+ numcases.get(i) + "    UNSAFE",startX,startY);
            startY+=15;
        }
        gc.setFill(Color.WHITE);
        gc.fillText("Key: ",50,450);
        gc.setFill(Color.RED);
        gc.fillText("Red - # cases >= 50000",100,425);
        gc.setFill(Color.ORANGE);
        gc.fillText("Orange - 50000 > # cases >= 30000",400,425);
        gc.setFill(Color.YELLOW);
        gc.fillText("Yellow - 30000 > # cases > 10000",100,475);
        gc.setFill(Color.GREEN);
        gc.fillText("Green - # cases <= 10000",400,475);

    }
}