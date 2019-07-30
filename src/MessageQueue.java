import java.util.ArrayDeque;

public  class MessageQueue <T> {
    private ArrayDeque<T> arr;
    public MessageQueue(){
        arr=new ArrayDeque<>();
    }

    public synchronized Object pop(){
        if(arr.isEmpty())        {return null;}
        else{
            return arr.poll();
        }
    }
    public synchronized void offer(T obj){
        arr.offer(obj);

    }

    public synchronized int size(){
        return arr.size();
    }
}
