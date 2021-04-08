package ro.ase.acs.facade;

public class Lights {
    private boolean areHeadLightsOn;
    private boolean areBrakeLightsOn;
    private boolean areHazardLightsOn;
    private boolean isSignalLeftOn;
    private boolean isSignalRightOn;

    public boolean areHeadLightsOn() {
        return areHeadLightsOn;
    }

    public void setHeadLightsOn(boolean areHeadLightsOn) {
        this.areHeadLightsOn = areHeadLightsOn;
        if(areHeadLightsOn) {
            System.out.println("HeadLights on");
        } else {
            System.out.println("HeadLights off");
        }
    }

    public boolean areBrakeLightsOn() {
        return areBrakeLightsOn;
    }

    public void setBrakeLightsOn(boolean areBrakeLightsOn) {
        this.areBrakeLightsOn = areBrakeLightsOn;
        if(areBrakeLightsOn) {
            System.out.println("BrakeLights on");
        } else {
            System.out.println("BrakeLights off");
        }
    }

    public boolean areHazardLightsOn() {
        return areHazardLightsOn;
    }

    public void setHazardLightsOn(boolean areHazardLightsOn) {
        this.areHazardLightsOn = areHazardLightsOn;
        if(areHazardLightsOn) {
            System.out.println("HazardLights On");
        } else {
            System.out.println("HazardLights Off");
        }
    }

    public boolean isSignalLeftOn() {
        return isSignalLeftOn;
    }

    public void setSignalLeftOn(boolean signalLeftOn) {
        isSignalLeftOn = signalLeftOn;
        if(signalLeftOn) {
            System.out.println("signalLeft On");
        } else {
            System.out.println("signalLeft off");
        }
    }

    public boolean isSignalRightOn() {
        return isSignalRightOn;
    }

    public void setSignalRightOn(boolean signalRightOn) {
        isSignalRightOn = signalRightOn;
        if(signalRightOn) {
            System.out.println("signalRight On");
        } else {
            System.out.println("signalRight Off");
        }
    }
}
