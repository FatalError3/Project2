package sample;

import javafx.stage.FileChooser;
import javafx.stage.Window;
import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Lyaro on 22.10.2015.
 */
public class Encription extends Window implements Runnable, iEncription{
    File inputFile;
    File outputFile;

    int keygen;
    int N;

    Thread thread;

    Keygen key;

    public Encription (){
        key = new Keygen();
        thread = new Thread(this);
    }

    public void openFile() {
        FileChooser fc = new FileChooser();
        inputFile = fc.showOpenDialog(this);
    }

    public String[] keyGeneration() {
        return key.generation();
    }

    public void encrypt(String keygen) {
        String []buff = keygen.split(" ");
        this.keygen = Integer.parseInt(buff[0]);
        this.N = Integer.parseInt(buff[1]);
        outputFile = new File (inputFile.getPath()+"s");
        byte[]buf = new byte[1];
        ArrayList<Integer> list = new ArrayList<>();
        try  {
            FileInputStream fileInputStream = new FileInputStream(inputFile);
            int size = fileInputStream.available();
            for (int i = 0; i<size; i++){
                fileInputStream.read(buf, 0, 1);
                list.add(recurs(this.keygen, buf[0]));
            }
            fileInputStream.close();
            saveToFile(list);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void decrypt (String keygen){
        String []buff = keygen.split(" ");
        this.keygen = Integer.parseInt(buff[0]);
        this.N = Integer.parseInt(buff[1]);
        outputFile = new File(inputFile.getPath().substring(0, inputFile.getPath().length()-1));
        ArrayList<Integer> list = loadToFile();
        byte[]buf = new byte[1];
        try  {
            FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
            for (int b : list){
                buf[0] = (byte)recurs(this.keygen, b);
                fileOutputStream.write(buf);
            }
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

    }

    private void saveToFile (ArrayList<Integer> list){
        try {
            FileOutputStream fos = new FileOutputStream(outputFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<Integer> loadToFile () {
        ArrayList<Integer> list = new ArrayList<>();
        try {
            FileInputStream fos = new FileInputStream(inputFile);
            ObjectInputStream oos = new ObjectInputStream(fos);
            list = (ArrayList<Integer>)oos.readObject();
            fos.close();
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }


    private int recurs (int keygen, int b){
        long result = 0;
        if (keygen == 1)
            return b%N;
        if (keygen == 2)
            return (int)(((b%N)*(Math.pow(b, (keygen-1))%N))%N);
        result = ((b%N)*(recurs(keygen - 1, b))%N)%N;
        return (int)result;
    }
}