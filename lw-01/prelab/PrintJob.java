public abstract class PrintJob {
    private String id;
    private int pages;

    protected PrintJob(String id, int pages){
        if (pages <= 0) {
            throw new IllegalArgumentException("Pages must be greater than zero.");
        }
        this.id = id;
        this.pages = pages;
    }

    public String getId(){
        return this.id;
    }

    public int getPages(){
        return this.pages;
    }

    public abstract int calculateCharges();
    
    public int calculateCharges(int copies){
        if (copies <= 0) {
            throw new IllegalArgumentException("Copies must be greater than zero.");
        }
        return copies * calculateCharges();
    }

    public String label(){
        return "Print";
    }

    public String summary(){
        return getId() + " | " + label() + " | " + calculateCharges();
    }
}
