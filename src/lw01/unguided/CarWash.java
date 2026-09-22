package lw01.unguided;

public class CarWash extends WashService{
    public CarWash(String id, int days){
        super(id, days);
    }

    @Override
    public int calculateCharge(){
        int total;
        if(getDays() > 3){
            total = (3 * 35000) + ((getDays() - 3) * 25000);
        } else {
            total = getDays() * 35000;
        }
        return (total + 15000);
    }

    @Override 
    public String label(){
        return "Car";
    }
}