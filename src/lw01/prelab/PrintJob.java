public abstract class PrintJob {
    private String id;
    private int pages;

    protected PrintJob(String id, int pages){
        if (pages <= 0 || pages > 100) {
            throw new IllegalArgumentException("Pages must be greater than zero and at most 100");
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
        if (copies <= 0 || copies > 10) {
            throw new IllegalArgumentException("Copies must be greater than zero and at most 10");
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
