package sample;


import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
//Hello!!!
public class Controller {
    public TextField keygenE;
    public TextField keygenD;

    Encription encription;

    public void initialize() {
        encription = new Encription();
    }

    public void openFile5(ActionEvent actionEvent) {
        encription = new Encription();
        encription.openFile();
    }

    public void decrypt5(ActionEvent actionEvent) {
        encription.decrypt(keygenD.getText());
    }

    public void encrypt5(ActionEvent actionEvent) {
        encription.encrypt(keygenE.getText());
    }

    public void keyGeneration(ActionEvent actionEvent) {
        String []key = encription.keyGeneration();
        keygenE.setText(key[0]);
        keygenD.setText(key[1]);
    }
}
