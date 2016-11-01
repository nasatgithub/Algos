package code.nasir.StringProcessing;

import java.io.ObjectInputStream.GetField;

class CommonData{
	private float loaded=0;
	private Boolean connected=false;
	private boolean valueSet=false;

    public float getLoaded() {
    	while(!valueSet){
    		try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	valueSet=false;
    	notify();
    	System.out.println("returning");
		return loaded;
	}
    public void setLoaded(float loaded) {
    	while(valueSet){
    		try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	valueSet=true;
    	notify();
		this.loaded = loaded;
	}

	public Boolean getConnected() {
		return connected;
	}

	public void setConnected(Boolean connected) {
		this.connected = connected;
	}
        
}
class ConnectNetwork implements Runnable{
	Thread t;
	int progress=0;
	CommonData cd;
	public ConnectNetwork(CommonData cd) {
		// TODO Auto-generated constructor stub
		this.cd=cd;
		t=new Thread(this);
		t.start();

	}
	public void run(){
		try{
			System.out.println("Loading...");
			for(int i=0;i<=40;i++){
				Thread.sleep(100);
				synchronized (cd) {
					float loaded= (i/(float)40)*100;
					cd.setLoaded(loaded);
					if(loaded==100){
						cd.setConnected(true);
						System.out.println("\nConnected to Network");
					}
				}
			}
		}
		catch(InterruptedException e){
			
		}
	}
}
class DisplayProgress implements Runnable{
	Thread t;
	CommonData cd;
	public DisplayProgress(CommonData cd) {
		// TODO Auto-generated constructor stub
		this.cd=cd;
		t=new Thread(this);
		t.start();
	}
	public void run(){
		while(!cd.getConnected()){
			synchronized (cd) {
				float loaded=cd.getLoaded();
				System.out.println(loaded+" ");
			}
		}
		System.out.println("DONE!!!");
	}
}
public class ProducerConsumerThreaded {
public static void main(String args[]) throws InterruptedException{
	CommonData cd=new CommonData();
	ConnectNetwork c=new ConnectNetwork(cd);
	DisplayProgress d=new DisplayProgress(cd);

    c.t.join();
	System.out.println(d.t.isAlive());
}
}
