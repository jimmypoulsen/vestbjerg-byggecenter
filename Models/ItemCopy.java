package Models;

public class ItemCopy {
    private String serialNo;
    private int condition;
    private Item item;
    
    public ItemCopy(String serialNo, int condition) {
        this.serialNo = serialNo;
        this.condition = condition;
        this.item = item;
    }
    
    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }
    
    public String getSerialNo() {
        return serialNo;
    }
    
    public void setCondition(int condition) {
        this.condition = condition;
    }
    
    public int getCondition() {
        return condition;
    }
}
