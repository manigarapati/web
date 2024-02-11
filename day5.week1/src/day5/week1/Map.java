package day5.week1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Map {
	public static void main(String[] args) {

		HashMap<String, Integer> map = new HashMap<>();
		map.put("apple", 3);
		map.put("banana", 5);
		map.put("orange", 8);
		map.put("grapes", 3);

		List<Entry<String, Integer>> sortedEntries = new ArrayList<>(map.entrySet());
		sortedEntries.sort(Entry.comparingByValue());

		System.out.println("Sorted Map by Values:");
		for (Entry<String, Integer> entry : sortedEntries) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}
}
