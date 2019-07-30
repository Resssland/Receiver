import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;


public class Receiver implements Runnable{

    DatagramSocket dsocket;
    public boolean stop=false;
    MessageQueue<Screen> sc;
    public Receiver(MessageQueue<Screen> sc) throws IOException {
        int port=22222;
        dsocket=new DatagramSocket(port);
        this.sc=sc;



    }

    @Override
    public void run() {
        while(!stop){
            byte[] b=new byte[32*1024];
            DatagramPacket pac=new DatagramPacket(b,b.length);
            try {
                dsocket.receive(pac);
                b=pac.getData();
                if(b.length>0)sc.offer (Converter(b));
               System.out.println(sc.size());

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }



    public Screen Converter(byte[] byteScreen){
        InputStream in =new ByteArrayInputStream(byteScreen);

        Screen s =null;
        try{
            ObjectInputStream ois =new ObjectInputStream(in);
            s=(Screen) ois.readObject();
            ois.close();
            in.close();

        }
        catch (IOException e){e.printStackTrace();}
        catch (ClassNotFoundException e) {e.printStackTrace();}
        return s;
    }
}
