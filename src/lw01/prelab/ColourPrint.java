public class ColourPrint extends PrintJob{
    public ColourPrint(String id, int pages){
        super(id, pages);
    }

    @Override 
    public int calculateCharges(){
        int totalPages = getPages();
        int pageCharge = 0;

        if (totalPages <= 10){
            pageCharge = 1500 * totalPages;
        } else {
            pageCharge = 1500 * 10 + (totalPages - 10) * 1000;
        }

        return pageCharge + 2000;
    }

    @Override 
    public String label(){
        return "Colour";
    }
}
