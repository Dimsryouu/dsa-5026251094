public class MonoPrint extends PrintJob {
    public MonoPrint(String id, int pages){
        super(id, pages);
    }

    @Override
    public int calculateCharges(){
        return 500 * getPages();
    }

    @Override 
    public String label(){
        return "Mono";
    }
}
