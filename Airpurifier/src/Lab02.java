class AirPurifier{
    //Instance variables
    String model;
    String serialNo;
    boolean power;
    int fanSpeed;
    int price;

    //Class variables
    static int modelCount;
    static int[] priceOfModel = new int[3];
    static int Pro = 15000;
    static int Air = 12000;
    static int Mini = 10000;

    //Instance methods
    void turnOn() {
        power = true;
        IO.println("Power of "+model+serialNo+" is on");
    }
    void turnOff() {
        power = false;
        IO.println("Power of "+model+serialNo+" is off");
    }
    void setFanSpeed(int speed){
        if(!power){
            IO.println(model+serialNo+" is still off");
            return;
        }
        if(speed < 0){
            IO.println("please set only positive value");
            return;
        }
        fanSpeed = speed;
        IO.println("set fanspeed of "+model+serialNo+": "+fanSpeed);
    }

    //Class methods
    static int TotalAirpurifier(){
        IO.println("Total amount of air purifier is "+modelCount);
        return modelCount;
    }

    static int Totalspend(){
            return (priceOfModel[0]*Pro) + (priceOfModel[1]*Air) + (priceOfModel[2]*Mini);
    }

    //Constructor
    AirPurifier(String model, String serialNo){
        if(!model.equals("Pro") && !model.equals("Air") && !model.equals("Mini")){
            IO.println("We only have 3 model -> Pro, Air, Mini");
            return;
        }
        this.model = model;
        this.serialNo = serialNo;
        power = false;
        if(model.equals("Pro")) {
            priceOfModel[0]++;
            price = Pro;
        }
        else if(model.equals("Air")) {
            priceOfModel[1]++;
            price = Air;
        }
        else {
            priceOfModel[2]++;
            price = Mini;
        }
        modelCount++;
        IO.println("Model: "+model);
        IO.println("Serial number: "+serialNo);
        IO.println("Price: "+price);
        IO.println();
    }

}
public class Lab02{
    public static void main(String[] args){
        AirPurifier x = new AirPurifier("Pro", "01");
        AirPurifier y = new AirPurifier("Air", "01");
        AirPurifier z = new AirPurifier("Pro", "02");

        x.turnOn();
        y.turnOn();

        AirPurifier.TotalAirpurifier();
        IO.println("Total spend for airpurifier is "+AirPurifier.Totalspend()+" baht");

        x.setFanSpeed(50);
        y.setFanSpeed(-100);
        z.setFanSpeed(150);

        x.turnOff();
        y.turnOff();
    }
}
