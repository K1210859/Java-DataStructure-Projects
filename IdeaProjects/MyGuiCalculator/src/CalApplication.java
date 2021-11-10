import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CalApplication extends Application {
    double enteredNumber = 0.0;
    String stringExpression = "";
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Calculator");
        Group group = new Group();
        Scene scene = new Scene(group, 315, 365);

        TextField txt_enter = new TextField();
        //TextField txt_operation = new TextField();
        //txt_operation.setVisible(false);
        Label lbl_secondenter = new Label();
        Label lbl_operation = new Label();
        //txt_secondenter.setVisible(false);
        Button btn_decimal = new Button(" . ");
        Button btn_plusorminus = new Button("-/+");
        Button btn_delete = new Button(" C ");
        Button btn_add = new Button(" + ");
        Button btn_one = new Button(" 1 ");
        Button btn_two = new Button(" 2 ");
        Button btn_three = new Button(" 3 ");
        Button btn_zero = new Button(" 0 ");
        Button btn_sub = new Button(" - ");
        Button btn_four = new Button(" 4 ");
        Button btn_five = new Button(" 5 ");
        Button btn_six = new Button(" 6 ");
        Button btn_multiply = new Button(" * ");
        Button btn_seven = new Button(" 7 ");
        Button btn_eight = new Button(" 8 ");
        Button btn_nine = new Button(" 9 ");
        Button btn_divide = new Button(" / ");
        Button btn_equals = new Button(" = ");

        GridPane gp = new GridPane();

  /*HBox hb_1 = new HBox();
  hb_1.getChildren().addAll(btn_decimal,btn_plusorminus,btn_delete,btn_add);
  HBox hb_2 = new HBox();
  hb_2.getChildren().addAll(btn_one,btn_two,btn_three);
  HBox hb_3 = new HBox();
  hb_3.getChildren().addAll(btn_four,btn_five,btn_six);
  HBox hb_4 = new HBox();
  hb_4.getChildren().addAll(btn_seven,btn_eight,btn_nine);
  HBox hb_5 = new HBox();
  hb_5.getChildren().addAll(btn_zero);
  HBox hb_6 = new HBox();
  hb_6.getChildren().addAll(btn_sub);
  HBox hb_7 = new HBox();
  hb_7.getChildren().addAll(btn_multiply);
  HBox hb_8 = new HBox();
  hb_8.getChildren().addAll(btn_divide);
  HBox hb_9 = new HBox();
  hb_9.getChildren().addAll(btn_equals);

  VBox vb_row1Items = new VBox();
  vb_row1Items.getChildren().addAll(hb_2,hb_3,hb_4,btn_one,btn_four,btn_seven);
  vb_row1Items.setSpacing(20);
  vb_row1Items.setAlignment(Pos.CENTER_LEFT);
  vb_row1Items.setPrefHeight(scene.getHeight());
  VBox vb_row2Items = new VBox();
  vb_row2Items.getChildren().addAll(hb_1,hb_2,hb_3,hb_4,btn_decimal,btn_two,btn_five,btn_eight);
  vb_row2Items.setSpacing(20);
  vb_row2Items.setAlignment(Pos.CENTER_LEFT);
  vb_row2Items.setPrefHeight(scene.getHeight());
 VBox vb_row3Items = new VBox();
 vb_row3Items.getChildren().addAll(hb_1,hb_2,hb_3,hb_4,btn_plusorminus,btn_three,btn_six,btn_nine);
 vb_row3Items.setSpacing(20);
 vb_row3Items.setAlignment(Pos.CENTER);
 vb_row3Items.setPrefHeight(scene.getHeight());
 VBox vb_row4Items = new VBox();
 vb_row4Items.getChildren().addAll(hb_1,hb_5,btn_delete,btn_zero);
 vb_row4Items.setSpacing(20);
 vb_row4Items.setAlignment(Pos.CENTER_RIGHT);
 vb_row4Items.setPrefHeight(scene.getHeight());
 VBox vb_row5Items = new VBox();
 vb_row5Items.getChildren().addAll(hb_1,hb_6,hb_7,hb_8,btn_add,btn_sub,btn_multiply,btn_divide);
 vb_row5Items.setSpacing(20);
 vb_row5Items.setAlignment(Pos.CENTER_RIGHT);
 vb_row5Items.setPrefHeight(scene.getHeight());
 VBox vb_row6Items = new VBox();
  vb_row6Items.getChildren().addAll(hb_9,btn_equals);
  vb_row6Items.setSpacing(20);
  vb_row6Items.setAlignment(Pos.BOTTOM_CENTER);
  vb_row6Items.setPrefHeight(scene.getHeight());
 /*vb_rowItems.getChildren().addAll(hb_login,hb_password,btn_login,btn_close);
 vb_rowItems.setSpacing(20);
 vb_rowItems.setAlignment(Pos.CENTER);
 vb_rowItems.setPrefHeight(scene.getHeight());*/


        btn_decimal.setMaxWidth(Double.MAX_VALUE);

        btn_plusorminus.setMaxWidth(Double.MAX_VALUE);

        btn_delete.setMaxWidth(Double.MAX_VALUE);

        btn_add.setMaxWidth(Double.MAX_VALUE);

        btn_one.setMaxWidth(Double.MAX_VALUE);

        btn_two.setMaxWidth(Double.MAX_VALUE);

        btn_three.setMaxWidth(Double.MAX_VALUE);

        btn_four.setMaxWidth(Double.MAX_VALUE);

        btn_five.setMaxWidth(Double.MAX_VALUE);

        btn_six.setMaxWidth(Double.MAX_VALUE);

        btn_seven.setMaxWidth(Double.MAX_VALUE);

        btn_eight.setMaxWidth(Double.MAX_VALUE);

        btn_nine.setMaxWidth(Double.MAX_VALUE);

        btn_zero.setMaxWidth(Double.MAX_VALUE);

        btn_sub.setMaxWidth(Double.MAX_VALUE);

        btn_multiply.setMaxWidth(Double.MAX_VALUE);

        btn_divide.setMaxWidth(Double.MAX_VALUE);

        btn_equals.setMaxWidth(Double.MAX_VALUE);

        btn_zero.setMaxHeight(Double.MAX_VALUE);

        gp.add(txt_enter,0,2,5,1);
        gp.add(lbl_secondenter,4,0,1,1);
        gp.add(lbl_operation,4,1,1,1);
        gp.add(btn_decimal,1,3,1,1);
        gp.add(btn_plusorminus,2,3,1,1);
        gp.add(btn_delete,3,3,1,1);
        gp.add(btn_add,4,3,1,1);
        gp.add(btn_one,0,4,1,1);
        gp.add(btn_two,1,4,1,1);
        gp.add(btn_three,2,4,1,1);
        gp.add(btn_four,0,5,1,1);
        gp.add(btn_five,1,5,1,1);
        gp.add(btn_six,2,5,1,1);
        gp.add(btn_seven,0,6,1,1);
        gp.add(btn_eight,1,6,1,1);
        gp.add(btn_nine,2,6,1,1);
        gp.add(btn_zero,3,4,1,3);
        gp.add(btn_sub,4,4,1,1);
        gp.add(btn_multiply,4,5,1,1);
        gp.add(btn_divide,4,6,1,1);
        gp.add(btn_equals,0,7,5,1);
        gp.setHgap(10);
        gp.setVgap(10);
        txt_enter.setEditable(false);
        gp.setPrefWidth(scene.getWidth());
        //gp.setPrefHeight(scene.getHeight());
        gp.setAlignment(Pos.CENTER);
// fix infinity glitch
        //number detection
        btn_zero.setOnAction(event -> {
            if(!txt_enter.getText().contains("Infinity")) {
                stringExpression += "0";
                txt_enter.setText(stringExpression);
            }
        });
        btn_one.setOnAction(event -> {
            if(!txt_enter.getText().contains("Infinity")) {
                stringExpression += "1";
                txt_enter.setText(stringExpression);
            }
        });
        btn_two.setOnAction(event -> {
            if(!txt_enter.getText().contains("Infinity")) {
                stringExpression += "2";
                txt_enter.setText(stringExpression);
            }
        });
        btn_three.setOnAction(event -> {
            if(!txt_enter.getText().contains("Infinity")) {
                stringExpression += "3";
                txt_enter.setText(stringExpression);
            }
        });
        btn_four.setOnAction(event -> {
            if(!txt_enter.getText().contains("Infinity")) {
                stringExpression += "4";
                txt_enter.setText(stringExpression);
            }
        });
        btn_five.setOnAction(event -> {
            if(!txt_enter.getText().contains("Infinity")) {
                stringExpression += "5";
                txt_enter.setText(stringExpression);
            }
        });
        btn_six.setOnAction(event -> {
            if(!txt_enter.getText().contains("Infinity")) {
                stringExpression += "6";
                txt_enter.setText(stringExpression);
            }
        });
        btn_seven.setOnAction(event -> {
            if(!txt_enter.getText().contains("Infinity")) {
                stringExpression += "7";
                txt_enter.setText(stringExpression);
            }
        });
        btn_eight.setOnAction(event -> {
            if(!txt_enter.getText().contains("Infinity")) {
                stringExpression += "8";
                txt_enter.setText(stringExpression);
            }
        });
        btn_nine.setOnAction(event -> {
            if(!txt_enter.getText().contains("Infinity")) {
                stringExpression += "9";
                txt_enter.setText(stringExpression);
            }
        });
        btn_decimal.setOnAction(event -> {
            if(!stringExpression.contains(".") && !txt_enter.getText().contains("Infinity")) {
                stringExpression += ".";
                txt_enter.setText(stringExpression);
            }
        });
        // other detection
        btn_delete.setOnAction(event -> {
            stringExpression="";
            lbl_operation.setText("");
            lbl_secondenter.setText("");
            txt_enter.setText(stringExpression);
        });
        btn_add.setOnAction(event -> {
            if(!stringExpression.equals("")&&!lbl_operation.getText().equals("")&&!lbl_secondenter.getText().equals("") && !stringExpression.equals(".") && !stringExpression.equals("-."))
            {
                double num2 = Double.parseDouble(stringExpression);
                double num = Double.parseDouble(lbl_secondenter.getText());
                if(lbl_operation.getText().equals(" + ")) {
                    lbl_secondenter.setText((num + num2) + "");
                }
                if(lbl_operation.getText().equals(" - ")) {
                    lbl_secondenter.setText((num - num2) + "");
                }
                if(lbl_operation.getText().equals(" * ")) {
                    lbl_secondenter.setText((num * num2) + "");
                }
                if(lbl_operation.getText().equals(" / "))
                {
                    if(num2==0)
                        lbl_secondenter.setText("Infinity");
                    else if(num2!=0)
                        lbl_secondenter.setText((num / num2) + "");
                }
                lbl_operation.setText(" + ");
                stringExpression = "";
                txt_enter.setText("");
            }
            else if((!stringExpression.equals("")&&!stringExpression.equals(".")&&!stringExpression.equals("-.")) && lbl_operation.getText().equals(""))
            {
                double num = Double.parseDouble(stringExpression);
                lbl_secondenter.setText(num+"");
                lbl_operation.setText(" + ");
                stringExpression="";
                txt_enter.setText(stringExpression);
            }
            else if(stringExpression.equals("") && !lbl_operation.getText().equals(""))
            {
                lbl_operation.setText(" + ");
            }
        });
        btn_sub.setOnAction(event -> {
            if(!stringExpression.equals("")&&!lbl_operation.getText().equals("")&&!lbl_secondenter.getText().equals("") && !stringExpression.equals(".") && !stringExpression.equals("-."))
            {
                double num2 = Double.parseDouble(stringExpression);
                double num = Double.parseDouble(lbl_secondenter.getText());
                if(lbl_operation.getText().equals(" + ")) {
                    lbl_secondenter.setText((num + num2) + "");
                }
                if(lbl_operation.getText().equals(" - ")) {
                    lbl_secondenter.setText((num - num2) + "");
                }
                if(lbl_operation.getText().equals(" * ")) {
                    lbl_secondenter.setText((num * num2) + "");
                }
                if(lbl_operation.getText().equals(" / "))
                {
                    if(num2==0)
                        lbl_secondenter.setText("Infinity");
                    else if(num2!=0)
                        lbl_secondenter.setText((num / num2) + "");
                }
                lbl_operation.setText(" - ");
                stringExpression = "";
                txt_enter.setText("");
            }
            else if((!stringExpression.equals("")&&!stringExpression.equals(".")&&!stringExpression.equals("-.")) && lbl_operation.getText().equals(""))
            {
                double num = Double.parseDouble(stringExpression);
                lbl_secondenter.setText(num+"");
                lbl_operation.setText(" - ");
                stringExpression="";
                txt_enter.setText(stringExpression);
            }
            else if(stringExpression.equals("") && !lbl_operation.getText().equals(""))
            {
                lbl_operation.setText(" - ");
            }
        });
        btn_multiply.setOnAction(event -> {
            if(!stringExpression.equals("")&&!lbl_operation.getText().equals("")&&!lbl_secondenter.getText().equals("") && !stringExpression.equals(".") && !stringExpression.equals("-."))
            {
                double num2 = Double.parseDouble(stringExpression);
                double num = Double.parseDouble(lbl_secondenter.getText());
                if(lbl_operation.getText().equals(" + ")) {
                    lbl_secondenter.setText((num + num2) + "");
                }
                if(lbl_operation.getText().equals(" - ")) {
                    lbl_secondenter.setText((num - num2) + "");
                }
                if(lbl_operation.getText().equals(" * ")) {
                    lbl_secondenter.setText((num * num2) + "");
                }
                if(lbl_operation.getText().equals(" / "))
                {
                    if(num2==0)
                        lbl_secondenter.setText("Infinity");
                    else if(num2!=0)
                        lbl_secondenter.setText((num / num2) + "");
                }
                lbl_operation.setText(" * ");
                stringExpression = "";
                txt_enter.setText("");
            }
            else if((!stringExpression.equals("")&&!stringExpression.equals(".")&&!stringExpression.equals("-.")) && lbl_operation.getText().equals(""))
            {
                double num = Double.parseDouble(stringExpression);
                lbl_secondenter.setText(num+"");
                lbl_operation.setText(" * ");
                stringExpression="";
                txt_enter.setText(stringExpression);
            }
            else if(stringExpression.equals("") && !lbl_operation.getText().equals(""))
            {
                lbl_operation.setText(" * ");
            }
        });
        btn_divide.setOnAction(event -> {
            if(!stringExpression.equals("")&&!lbl_operation.getText().equals("")&&!lbl_secondenter.getText().equals("") && !stringExpression.equals(".") && !stringExpression.equals("-."))
            {
                double num2 = Double.parseDouble(stringExpression);
                double num = Double.parseDouble(lbl_secondenter.getText());
                if(lbl_operation.getText().equals(" + ")) {
                    lbl_secondenter.setText((num + num2) + "");
                }
                if(lbl_operation.getText().equals(" - ")) {
                    lbl_secondenter.setText((num - num2) + "");
                }
                if(lbl_operation.getText().equals(" * ")) {
                    lbl_secondenter.setText((num * num2) + "");
                }
                if(lbl_operation.getText().equals(" / "))
                {
                    if(num2==0)
                        lbl_secondenter.setText("Infinity");
                    else if(num2!=0)
                        lbl_secondenter.setText((num / num2) + "");
                }
                lbl_operation.setText(" / ");
                stringExpression = "";
                txt_enter.setText("");
            }
            else if((!stringExpression.equals("")&&!stringExpression.equals(".")&&!stringExpression.equals("-.")) && lbl_operation.getText().equals(""))
            {
                double num = Double.parseDouble(stringExpression);
                lbl_secondenter.setText(num+"");
                lbl_operation.setText(" / ");
                stringExpression="";
                txt_enter.setText(stringExpression);
            }
            else if(stringExpression.equals("") && !lbl_operation.getText().equals(""))
            {
                lbl_operation.setText(" / ");
            }
        });
        btn_plusorminus.setOnAction(event -> {
            if(stringExpression.equals("."))
            {
                stringExpression = "-.";
            }
            else if(stringExpression.equals("-."))
            {
                stringExpression = ".";
            }
            else if(stringExpression.equals("Infinity"))
            {
                stringExpression = "-Infinity";
            }
            else if(stringExpression.equals("-Infinity"))
            {
                stringExpression = "Infinity";
            }
            else if(!stringExpression.equals("")) {
                double num = Double.parseDouble(stringExpression);
                num *= -1;
                stringExpression = num + "";
            }
            txt_enter.setText(stringExpression);
        });
        btn_equals.setOnAction(event -> {
            if(!stringExpression.equals(".") && !stringExpression.equals("-.") && (!stringExpression.equals("")) && !lbl_operation.getText().equals(""))
            {
                double num2 = Double.parseDouble(stringExpression);
                double num = Double.parseDouble(lbl_secondenter.getText());
                if(lbl_operation.getText().equals(" + "))
                    stringExpression = (num+num2)+"";
                if(lbl_operation.getText().equals(" - "))
                    stringExpression = (num-num2)+"";
                if(lbl_operation.getText().equals(" * "))
                    stringExpression = (num*num2)+"";
                if(lbl_operation.getText().equals(" / "))
                {
                    if(num2==0)
                        stringExpression = "Infinity";
                    else if(num2!=0)
                        stringExpression = (num/num2)+"";
                }
                lbl_secondenter.setText("");
                lbl_operation.setText("");
                txt_enter.setText(stringExpression);}
        });
        group.getChildren().addAll(gp);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args)
    {
        launch(args);
    }

}
