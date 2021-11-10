import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Rolodex extends Application {
    Person chose = null;
    @Override
    public void start(Stage primaryStage) throws Exception {
        Group group = new Group();
        Scene scene = new Scene(group, 595, 375);
        primaryStage.setTitle("K1210859");
        ListView<String> lv = new ListView<>();
        ArrayList<Person> array = new ArrayList<>();
        ArrayList<String> array2 = new ArrayList<>();

        Label lbl_fname = new Label("First Name: ");
        TextField txt_fname = new TextField();

        Label lbl_lname = new Label("Last Name: ");
        TextField txt_lname = new TextField();
        Label lbl_num = new Label("Phone Number: ");
        TextField txt_num = new TextField();

        Label lbl_address = new Label("Address: ");
        TextField txt_address = new TextField();

        Button btn_save = new Button("Save");
        Button btn_new = new Button("New");
        Button btn_savechanges = new Button("Save Changes");
        Button btn_delete = new Button("Delete Contact");

        //horizontal container for login
        HBox hb_fname = new HBox();
        hb_fname.getChildren().addAll(lbl_fname,txt_fname);

        HBox hb_lname = new HBox();
        hb_lname.getChildren().addAll(lbl_lname,txt_lname);

        HBox hb_num = new HBox();
        hb_num.getChildren().addAll(lbl_num,txt_num);

        HBox hb_address = new HBox();
        hb_address.getChildren().addAll(lbl_address,txt_address);

        VBox vlist = new VBox();
        vlist.getChildren().addAll(lv);
        vlist.setAlignment(Pos.CENTER_LEFT);
        vlist.setPrefHeight(scene.getHeight());

        VBox vb_rowItems = new VBox();
        vb_rowItems.getChildren().addAll(hb_fname,hb_lname,hb_num,hb_address);
        vb_rowItems.setSpacing(20);
        vb_rowItems.setAlignment(Pos.TOP_RIGHT);
        vb_rowItems.setLayoutX(300);
        vb_rowItems.setLayoutY(50);
        vb_rowItems.setPrefHeight(scene.getHeight());

        HBox buttons = new HBox();
        buttons.getChildren().addAll(btn_save,btn_new);
        buttons.setSpacing(20);
        buttons.setLayoutX(375);
        buttons.setLayoutY(250);
        buttons.setVisible(true);

        HBox buttons2 = new HBox();
        buttons2.getChildren().addAll(btn_savechanges,btn_delete);
        buttons2.setSpacing(20);
        buttons2.setLayoutX(325);
        buttons2.setLayoutY(300);
        buttons2.setVisible(false);

        btn_save.setOnAction(event -> {
            String fn = txt_fname.getText();
            String ln = txt_lname.getText();
            String num = txt_num.getText();
            String adr = txt_address.getText();
            if(fn.equals("") || ln.equals(""))
                new Alert(Alert.AlertType.ERROR,"Invalid Entry").showAndWait();
            else if(!fn.equals("") && !ln.equals(""))
            {
                Person p = new Person(fn,ln,num,adr);
                array.add(p);
                for(int i=array.size()-1;i<array.size();i++)
                {
                    lv.getItems().add(array.get(i).toString());
                }
                txt_address.setText("");
                txt_fname.setText("");
                txt_lname.setText("");
                txt_num.setText("");
            }
        });
        btn_new.setOnAction(event -> {
            txt_address.setText("");
            txt_fname.setText("");
            txt_lname.setText("");
            txt_num.setText("");
        });

        lv.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            String chosen = lv.getSelectionModel().getSelectedItem();
            for(int i=0;i<array.size();i++)
            {
                if(array.get(i).toString().equals(chosen))
                {
                    txt_fname.setText(array.get(i).getFirstN());
                    txt_lname.setText(array.get(i).getLastN());
                    txt_num.setText(array.get(i).getPhoneN());
                    txt_address.setText(array.get(i).getAddress());
                    chose = array.get(i);
                }
            }
            buttons2.setVisible(true);
            buttons.setVisible(false);
        });
            btn_savechanges.setOnAction(event -> {
                lv.getItems().clear();
                chose.setAddress(txt_address.getText());
                chose.setFirstN(txt_fname.getText());
                chose.setLastN(txt_lname.getText());
                chose.setPhoneN(txt_num.getText());
                for(int i=0;i<array.size();i++)
                    array2.add(i,array.get(i).toString());
                lv.getItems().addAll(array2);
                txt_address.setText("");
                txt_fname.setText("");
                txt_lname.setText("");
                txt_num.setText("");
                buttons2.setVisible(false);
                buttons.setVisible(true);
            });
            btn_delete.setOnAction(event -> {
                array.remove(chose);
                lv.getItems().remove(chose.toString());
                lv.getSelectionModel().clearSelection();
                txt_address.setText("");
                txt_fname.setText("");
                txt_lname.setText("");
                txt_num.setText("");
                buttons2.setVisible(false);
                buttons.setVisible(true);
            });
        group.getChildren().addAll(vlist,vb_rowItems,buttons,buttons2);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args)
    {
        launch(args);
    }
}
