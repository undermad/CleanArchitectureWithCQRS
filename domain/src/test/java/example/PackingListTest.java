package example;


import example.entities.PackingList;
import example.events.PackingItemAdded;
import example.exceptions.PackingItemAlreadyExistException;
import example.factories.PackingListFactory;
import example.value_objects.Localization;
import example.value_objects.PackingItem;
import example.value_objects.PackingListId;
import example.value_objects.PackingListName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PackingListTest {

    @Mock
    private PackingListFactory packingListFactory;

    @BeforeEach
    void setup() {
        when(packingListFactory.create(any(PackingListId.class), any(PackingListName.class), any(Localization.class)))
                .thenReturn(new PackingList(
                        new PackingListId(UUID.randomUUID()),
                        new PackingListName("MyPackingList"),
                        new Localization("London", "United Kingdom")));
    }

    private PackingList getPackingList() {
        var packingList = packingListFactory.create(new PackingListId(UUID.randomUUID()), new PackingListName("ASD"), new Localization("a", "asd"));
        packingList.clearEvents();
        return packingList;
    }


    @Test
    public void addItem_Throws_PackingItemAlreadyExistException_When_There_Is_Already_Item_With_Same_Name() {
        var packingList = getPackingList();
        packingList.addItem(new PackingItem("Item 1", 1, false));

        assertThrows(PackingItemAlreadyExistException.class, () -> {
            packingList.addItem(new PackingItem("Item 1", 1, false));
        });
    }

    @Test
    public void addItem_Adds_PackingItemAdded_Domain_Event_On_Success() {
        var packingList = getPackingList();
        var packingItem = new PackingItem("Item 1", 1, false);
        packingList.addItem(packingItem);
        assertEquals(1, packingList.getEvents().size());
        
        var event = packingList.getEvents().getFirst();
        assertInstanceOf(PackingItemAdded.class, event);
    }
    
    @Test
    public void addItem_Adds_PackingItem_To_items() {
        var packingList = getPackingList();
        var packingItem = new PackingItem("Item 1", 1, false);
        packingList.addItem(packingItem);
        assertTrue(packingList.getItems().contains(packingItem));
    }


}
