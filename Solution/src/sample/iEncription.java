package sample;

/**
 * Created by Катерина on 19.11.2015.
 */
public interface iEncription {

    public void openFile();
    public String[] keyGeneration();
    public void encrypt(String keygen);
    public void decrypt (String keygen);
}
