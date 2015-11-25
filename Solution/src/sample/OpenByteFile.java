package sample;
import java.io.*;
public class OpenByteFile implements OpenFile{
	@Override
	public byte[] OpenFile (File file){
		try  {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte []buf = new byte[fileInputStream.available()];
            fileInputStream.read(buf, 0, fileInputStream.available());
            fileInputStream.close();
            return buf;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Error!".toByte();
	}
}
