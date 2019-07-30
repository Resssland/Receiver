import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;

public class ReceiverMain {
    public static void main(String[] args){
        MessageQueue<Screen> q=new MessageQueue<>();
        Receiver r = null;
        try {
            r = new Receiver(q);
        } catch (IOException e) {
            e.printStackTrace();
        }
        new Thread(r).start();



        try {
            Form F =new Form(q);

        } catch (IOException e) {
            e.printStackTrace();
        }






    }
}
