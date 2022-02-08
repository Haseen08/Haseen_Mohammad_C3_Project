//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemTest {
    Item item;
    @BeforeEach
    public void setup(){
        LocalTime openingTime = LocalTime.parse("10:30:00");
        LocalTime closingTime = LocalTime.parse("22:00:00");

        item = new Item("sweet",344);
        item.addToOrder("Sweet corn soup",119);
        item.addToOrder("Vegetable lasagne", 269);
    }

    @Test
    public void adding_item_to_order_should_increase_order_size_by_1(){
        int initialOrderSize = item.getOrder().size();
        item.addToOrder("Sizzling brownie",319);
        assertEquals(initialOrderSize+1,item.getOrder().size());
    }
    @Test
    public void removing_item_to_order_should_decrease_order_size_by_1() throws itemNotFoundException {
        int initialOrderSize = item.getOrder().size();
        item.removeFromOrder("Sweet corn soup");
        assertEquals(initialOrderSize-1,item.getOrder().size());
    }
    @Test
    public void get_total_amount_of_order()  {
        assertEquals(388,item.getTotalAmount());

    }
}
