package Structural.Bridge;

public class SamsungControl implements Device {

    @Override
    public void turnOn() {
        System.out.println("samsung: turn on");
    }

    @Override
    public void turnOff() {
        System.out.println("samsung: turn off");

    }

    @Override
    public void setChannel(int channel) {
        System.out.println("samsung: set channel " + channel);

    }

}
