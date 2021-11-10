import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FinalCalculator extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Group group = new Group();
        Scene scene = new Scene(group, 300, 600);

        Label lbl_totalweight = new Label("Total Term Weight: ");
        TextField txt_totalweight = new TextField();

        Label lbl_finalweight = new Label("Final Weight: ");
        TextField txt_finalweight = new TextField();

        Label lbl_numterms = new Label("Number of Terms: ");
        ComboBox<Integer> numterms = new ComboBox<>();
        numterms.getItems().addAll(1, 2, 3, 4, 5);

        Label lbl_gradewanted = new Label("Grade Wanted: ");
        TextField txt_gradewanted = new TextField();

        Label lbl_term1 = new Label("Term 1 Grade: ");
        TextField txt_term1 = new TextField();

        Label lbl_term2 = new Label("Term 2 Grade: ");
        TextField txt_term2 = new TextField();

        Label lbl_term3 = new Label("Term 3 Grade: ");
        TextField txt_term3 = new TextField();

        Label lbl_term4 = new Label("Term 4 Grade: ");
        TextField txt_term4 = new TextField();

        Label lbl_term5 = new Label("Term 5 Grade: ");
        TextField txt_term5 = new TextField();

        Button btn_calculate = new Button("Calculate");
        btn_calculate.setAlignment(Pos.CENTER);
        Button btn_clear = new Button("Clear");
        btn_clear.setAlignment(Pos.CENTER);

        Label lbl_statement = new Label("Calculate Grade Required On Final");

        Label lbl_gradecalculate = new Label();

        HBox hb_totalweight = new HBox();
        hb_totalweight.getChildren().addAll(lbl_totalweight, txt_totalweight);
        hb_totalweight.setAlignment(Pos.CENTER);

        HBox hb_finalweight = new HBox();
        hb_finalweight.getChildren().addAll(lbl_finalweight, txt_finalweight);
        hb_finalweight.setAlignment(Pos.CENTER);

        HBox hb_numterms = new HBox();
        hb_numterms.getChildren().addAll(lbl_numterms, numterms);
        hb_numterms.setAlignment(Pos.CENTER);

        HBox hb_gradewanted = new HBox();
        hb_gradewanted.getChildren().addAll(lbl_gradewanted, txt_gradewanted);
        hb_gradewanted.setAlignment(Pos.CENTER);

        HBox hb_term1 = new HBox();
        hb_term1.getChildren().addAll(lbl_term1, txt_term1);
        hb_term1.setAlignment(Pos.CENTER);
        HBox hb_term2 = new HBox();
        hb_term2.getChildren().addAll(lbl_term2, txt_term2);
        hb_term2.setAlignment(Pos.CENTER);
        HBox hb_term3 = new HBox();
        hb_term3.getChildren().addAll(lbl_term3, txt_term3);
        hb_term3.setAlignment(Pos.CENTER);
        HBox hb_term4 = new HBox();
        hb_term4.getChildren().addAll(lbl_term4, txt_term4);
        hb_term4.setAlignment(Pos.CENTER);
        HBox hb_term5 = new HBox();
        hb_term5.getChildren().addAll(lbl_term5, txt_term5);
        hb_term5.setAlignment(Pos.CENTER);
        HBox hb_label1 = new HBox();
        hb_label1.getChildren().addAll(lbl_statement);
        hb_label1.setAlignment(Pos.CENTER);
        HBox hb_label2 = new HBox();
        hb_label2.getChildren().addAll(lbl_gradecalculate);
        hb_label2.setAlignment(Pos.CENTER);
        VBox vb_rowItems = new VBox();
        vb_rowItems.getChildren().addAll(hb_totalweight, hb_finalweight, hb_numterms, hb_gradewanted, hb_term1, hb_term2, hb_term3, hb_term4, hb_term5, btn_calculate, btn_clear,hb_label1,hb_label2);
        vb_rowItems.setSpacing(20);
        vb_rowItems.setAlignment(Pos.CENTER);
        vb_rowItems.setPrefHeight(scene.getHeight());
        txt_finalweight.setText("15");
        txt_totalweight.setText("85");
        txt_gradewanted.setText("90");
        numterms.setValue(1);
        txt_term1.setDisable(false);
        txt_term2.setDisable(true);
        txt_term3.setDisable(true);
        txt_term4.setDisable(true);
        txt_term5.setDisable(true);
        numterms.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue==1)
            {
                txt_term1.setDisable(false);
                txt_term2.setDisable(true);
                txt_term3.setDisable(true);
                txt_term4.setDisable(true);
                txt_term5.setDisable(true);
                txt_term2.setText("");
                txt_term3.setText("");
                txt_term4.setText("");
                txt_term5.setText("");
            }
            else if(newValue==2)
            {
                txt_term1.setDisable(false);
                txt_term2.setDisable(false);
                txt_term3.setDisable(true);
                txt_term4.setDisable(true);
                txt_term5.setDisable(true);
                txt_term3.setText("");
                txt_term4.setText("");
                txt_term5.setText("");
            }
            else if(newValue==3)
            {
                txt_term1.setDisable(false);
                txt_term2.setDisable(false);
                txt_term3.setDisable(false);
                txt_term4.setDisable(true);
                txt_term5.setDisable(true);
                txt_term4.setText("");
                txt_term5.setText("");
            }
            else if(newValue==4)
            {
                txt_term1.setDisable(false);
                txt_term2.setDisable(false);
                txt_term3.setDisable(false);
                txt_term4.setDisable(false);
                txt_term5.setDisable(true);
                txt_term5.setText("");
            }
            else if(newValue==5)
            {
                txt_term1.setDisable(false);
                txt_term2.setDisable(false);
                txt_term3.setDisable(false);
                txt_term4.setDisable(false);
                txt_term5.setDisable(false);
            }
        });
        if(numterms.getSelectionModel().getSelectedItem()==null)
        {
            txt_term1.setDisable(true);
            txt_term2.setDisable(true);
            txt_term3.setDisable(true);
            txt_term4.setDisable(true);
            txt_term5.setDisable(true);
        }
        btn_calculate.setOnAction(event -> {
            if(txt_finalweight.getText().equals("")||txt_totalweight.getText().equals(""))
                new Alert(Alert.AlertType.ERROR,"Invalid Entry").showAndWait();
            else if(!txt_finalweight.getText().equals("") && !txt_totalweight.getText().equals(""))
            {
                double totalweight = Double.parseDouble(txt_totalweight.getText());
                double finalweight = Double.parseDouble(txt_finalweight.getText());
                if(totalweight+finalweight!=100)
                    new Alert(Alert.AlertType.ERROR,"Invalid Entry").showAndWait();
                else
                {
                    if(txt_gradewanted.getText().equals("")||numterms.getSelectionModel().getSelectedItem()==null)
                        new Alert(Alert.AlertType.ERROR,"Invalid Entry").showAndWait();
                    else if(!txt_gradewanted.getText().equals("") && numterms.getSelectionModel().getSelectedItem()!=null)
                    {
                        double numberterms = numterms.getSelectionModel().getSelectedItem();
                        double gradewanted = Double.parseDouble(txt_gradewanted.getText());
                        if(numberterms==1 && txt_term1.getText().equals(""))
                            new Alert(Alert.AlertType.ERROR,"Invalid Entry").showAndWait();
                        else if(numberterms==1 && !txt_term1.getText().equals(""))
                        {
                            double term1 = Double.parseDouble(txt_term1.getText());
                            lbl_gradecalculate.setText(((gradewanted-((totalweight/100)*term1))/(finalweight/100))+"");
                        }
                        else if(numberterms==2 && (txt_term1.getText().equals("") || txt_term2.getText().equals("")))
                            new Alert(Alert.AlertType.ERROR,"Invalid Entry").showAndWait();
                        else if(numberterms==2 && !txt_term1.getText().equals("") && !txt_term2.getText().equals(""))
                        {
                            double term1 = Double.parseDouble(txt_term1.getText());
                            double term2 = Double.parseDouble(txt_term2.getText());
                            lbl_gradecalculate.setText(((gradewanted-((totalweight/100)*((term1+term2)/2)))/(finalweight/100))+"");
                        }
                        else if(numberterms==3 && (txt_term1.getText().equals("") || txt_term2.getText().equals("") || txt_term3.getText().equals("")))
                            new Alert(Alert.AlertType.ERROR,"Invalid Entry").showAndWait();
                        else if(numberterms==3 && !txt_term1.getText().equals("") && !txt_term2.getText().equals("") && !txt_term3.getText().equals(""))
                        {
                            double term1 = Double.parseDouble(txt_term1.getText());
                            double term2 = Double.parseDouble(txt_term2.getText());
                            double term3 = Double.parseDouble(txt_term3.getText());
                            lbl_gradecalculate.setText(((gradewanted-((totalweight/100)*((term1+term2+term3)/3)))/(finalweight/100))+"");
                        }
                        else if(numberterms==4 && (txt_term1.getText().equals("") || txt_term2.getText().equals("") || txt_term3.getText().equals("") || txt_term4.getText().equals("")))
                            new Alert(Alert.AlertType.ERROR,"Invalid Entry").showAndWait();
                        else if(numberterms==4 && !txt_term1.getText().equals("") && !txt_term2.getText().equals("") && !txt_term3.getText().equals("") && !txt_term4.getText().equals(""))
                        {
                            double term1 = Double.parseDouble(txt_term1.getText());
                            double term2 = Double.parseDouble(txt_term2.getText());
                            double term3 = Double.parseDouble(txt_term3.getText());
                            double term4 = Double.parseDouble(txt_term4.getText());
                            lbl_gradecalculate.setText(((gradewanted-((totalweight/100)*((term1+term2+term3+term4)/4)))/(finalweight/100))+"");
                        }
                        else if(numberterms==5 && (txt_term1.getText().equals("") || txt_term2.getText().equals("") || txt_term3.getText().equals("") || txt_term4.getText().equals("") || txt_term5.getText().equals("")))
                            new Alert(Alert.AlertType.ERROR,"Invalid Entry").showAndWait();
                        else if(numberterms==5 && !txt_term1.getText().equals("") && !txt_term2.getText().equals("") && !txt_term3.getText().equals("") && !txt_term4.getText().equals("") && !txt_term5.getText().equals(""))
                        {
                            double term1 = Double.parseDouble(txt_term1.getText());
                            double term2 = Double.parseDouble(txt_term2.getText());
                            double term3 = Double.parseDouble(txt_term3.getText());
                            double term4 = Double.parseDouble(txt_term4.getText());
                            double term5 = Double.parseDouble(txt_term5.getText());
                            lbl_gradecalculate.setText(((gradewanted-((totalweight/100)*((term1+term2+term3+term4+term5)/5)))/(finalweight/100))+"");
                        }
                    }
                }}});
        btn_clear.setOnAction(event -> {
            txt_term1.setText("");
            txt_term2.setText("");
            txt_term3.setText("");
            txt_term4.setText("");
            txt_term5.setText("");
        });
        group.getChildren().addAll(vb_rowItems);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
