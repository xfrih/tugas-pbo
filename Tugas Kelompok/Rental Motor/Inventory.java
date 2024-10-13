import java.util.HashMap;
import java.util.Map;

public class Inventory implements Storable {
    private Map<String, Integer> itemMap;
    private int totalItem;

    public Inventory() {
        itemMap = new HashMap<>();
        totalItem = 0;
    }

    @Override
    public void tambahItem(String item, int jumlah) {
        itemMap.put(item, itemMap.getOrDefault(item, 0) + jumlah);
        totalItem += jumlah;
        System.out.println(jumlah + " unit " + item + " telah ditambahkan.");
    }

    @Override
    public void hapusItem(String item) {
        if (itemMap.containsKey(item)) {
            int jumlah = itemMap.get(item);
            totalItem -= jumlah;
            itemMap.remove(item);
            System.out.println(item + " telah dihapus dari inventaris.");
        } else {
            System.out.println("Item " + item + " tidak ditemukan.");
        }
    }

    @Override
    public void tampilkanItem() {
        if (itemMap.isEmpty()) {
            System.out.println("Inventaris kosong.");
        } else {
            System.out.println("Daftar Item di Inventaris:");
            for (Map.Entry<String, Integer> entry : itemMap.entrySet()) {
                System.out.println("- " + entry.getKey() + ": " + entry.getValue() + " unit");
            }
            System.out.println("Total item di inventaris: " + totalItem);
        }
    }
}
