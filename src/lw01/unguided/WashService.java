package lw01.unguided;

public abstract class WashService implements Billable{
    private String id;
    private int days;
    
    protected WashService(String id, int days){
        this.id = id;
        this.days = days;
    }

    public String getId(){
        return id;
    }

    public int getDays(){
        return days;
    }

    public abstract int calculateCharge();

    public int calculateCharge(int units){
        if(units <= 0 || units > 10){
            throw new IllegalArgumentException("Units must at least 0 and at most 10");
        } return units * calculateCharge();
    }

    public String label(){
        return "Services";
    }

    public String summary(){
        return id + " | " + label() + " | " + calculateCharge();
    }

    public String summary(int units){
        return id + " | " + label() + " | " + calculateCharge(units);
    }
}