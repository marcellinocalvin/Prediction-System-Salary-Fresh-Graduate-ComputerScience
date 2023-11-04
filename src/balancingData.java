import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class balancingData {
    public static void main(String[] args) {
        ArrayList<String> gajiList = new ArrayList<>();
        gajiList.add("rendah");
        gajiList.add("rendah");
        gajiList.add("sedang");
        gajiList.add("tinggi");
        gajiList.add("tinggi");
        gajiList.add("tinggi");

        // Menghitung jumlah data pada setiap kategori gaji
        Map<String, Integer> countMap = new HashMap<>();
        for (String gaji : gajiList) {
            countMap.put(gaji, countMap.getOrDefault(gaji, 0) + 1);
        }

        // Menentukan kategori gaji dengan jumlah data terbanyak
        String maxCategory = Collections.max(countMap.entrySet(), Map.Entry.comparingByValue()).getKey();

        // Menghitung jumlah data pada kategori gaji terbanyak
        int maxCount = countMap.get(maxCategory);

        // Menghitung selisih jumlah data antara kategori gaji terbanyak dan kategori lainnya
        int diff = 0;
        for (String category : countMap.keySet()) {
            if (!category.equals(maxCategory)) {
                diff += maxCount - countMap.get(category);
            }
        }

        // Menambahkan atau menghapus data pada kategori gaji yang berbeda jumlahnya
        if (diff > 0) {
            for (String category : countMap.keySet()) {
                if (!category.equals(maxCategory)) {
                    addOrRemoveData(gajiList, category, diff);
                }
            }
        }

        // Cetak hasil balancing data gaji
        System.out.println("Data Gaji Setelah Balancing:");
        for (String gaji : gajiList) {
            System.out.println(gaji);
        }
    }

    private static void addOrRemoveData(List<String> gajiList, String category, int count) {
        Random random = new Random();
        if (count > 0) {
            // Menambahkan data pada kategori gaji yang jumlahnya kurang
            for (int i = 0; i < count; i++) {
                int index = random.nextInt(gajiList.size());
                gajiList.add(index, category);
            }
        } else {
            // Menghapus data pada kategori gaji yang jumlahnya lebih banyak
            for (int i = 0; i < Math.abs(count); i++) {
                gajiList.remove(category);
            }
        }
    }
}
