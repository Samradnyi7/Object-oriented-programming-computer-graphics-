class BasicPhone {
    String make;
    String model;

    public BasicPhone(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public void makeCall(String phoneNo) {
        System.out.println("In BasicPhone: Calling number " + phoneNo);
    }

    public void sendSMS(String newSMS) {
        System.out.println("In BasicPhone: Sending SMS: " + newSMS);
    }
}

class Smartphone extends BasicPhone {
    boolean biometric;

    public Smartphone(String make, String model, boolean biometric) {
        super(make, model);
        this.biometric = biometric;
    }

    public void makeVideoCall(String phoneNo) {
        System.out.println("Start video call with " + phoneNo);
    }

    public void checkBiometric() {
        System.out.println(make + " " + model + " biometric support is " + biometric);
    }
}

public class Main {
    public static void main(String[] args) {
        Smartphone s1 = new Smartphone("vivo", "v40e", true);
        s1.makeCall("8964712304");
        s1.makeVideoCall("7541238888");
        s1.checkBiometric();

        Smartphone s2 = new Smartphone("Samsung", "S24 pro", true);
        s2.sendSMS("GOOD MORNING");
        s2.checkBiometric();
    }
}
