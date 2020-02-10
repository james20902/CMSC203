package Labs.Lab4;
/**
 *The purpose of this class is to model a television
 *James Pham 2-10-20
 */
public class Television {

    public final String MANUFACTURER;
    public final int SCREEN_SIZE;
    private boolean powerOn = false;
    private int channel = 2;
    private int volume = 20;

    public Television(String manufacturer, int screensize){
        this.MANUFACTURER = manufacturer;
        this.SCREEN_SIZE = screensize;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public void power(){
        powerOn = !powerOn;
    }

    public void increaseVolume(){
        volume++;
    }

    public void decreaseVolume(){
        volume--;
    }

    public int getChannel(){
        return channel;
    }

    public int getVolume(){
        return volume;
    }

    public String getManufacturer(){
        return MANUFACTURER;
    }

    public int getScreenSize(){
        return SCREEN_SIZE;
    }
}
