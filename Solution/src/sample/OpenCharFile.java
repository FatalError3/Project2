package sample;
import java.io.*;
@Alternative
public class OpenCharFile implements OpenFile{
	@Override
	public byte[] OpenFile (File file){
		try  {
            FileReaderStream fileInputStream = new Filereader(file);
            char []buf = new byte[fileInputStream.available()];
            fileInputStream.read(buf, 0, fileInputStream.available());
            fileInputStream.close();
            byte []retBuf = new byte [buf.length()];
            for (int i = 0; i<buf.length; i++){
                retBuf[i] = Char.toByte(buf[i]);
            }
            return retBuf;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Error!".toByte();
	}
}
