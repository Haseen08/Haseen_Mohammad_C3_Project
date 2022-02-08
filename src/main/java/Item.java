import java.util.ArrayList;
import java.util.List;

public class Item {
    private String name;
    private int price;
    private List<Item> order = new ArrayList<Item>();

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString(){
        return  name + ":"
                + price
                + "\n"
                ;
    }
    public List<Item> getOrder() {
        return this.order;
    }
    public int getPrice() {
        return price;
    }

    public void addToOrder(String name, int price) {
        Item newItem = new Item(name,price);
        //System.out.println(newItem);
        order.add(newItem);
    }

    public void removeFromOrder(String itemName) throws itemNotFoundException {

        Item itemToBeRemoved = findItemByNameInOrder(itemName);
        if (itemToBeRemoved == null)
            throw new itemNotFoundException(itemName);

        order.remove(itemToBeRemoved);
    }

    private Item findItemByNameInOrder(String itemName){
        for(Item item: order) {
            if(item.getName().equals(itemName))
                return item;
        }
        return null;
    }

    public int getTotalAmount() {
        int totalAmount = 0;
        for(Item item: order) {
            totalAmount = totalAmount + item.getPrice();
        }
        return totalAmount;
    }


}
