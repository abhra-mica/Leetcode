package hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P10_GroupAnagram {
	public static void main(String[] args) {
		String[] strs = new String[] { "abc", "cab", "bca", "xyz", "zxy" };
		List<List<String>> result = groupAnagrams(strs);
		System.out.println(result);
		
		List<List<String>> result1 = ultimateGroupAnagrams(strs);
		System.out.println(result1);
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		for (String s : strs) {
			char[] chars = s.toCharArray();
			Arrays.sort(chars);
			String sortedString = new String(chars);

			if (!map.containsKey(sortedString)) {
				map.put(sortedString, new ArrayList<>());
			}
			map.get(sortedString).add(s);
		}
		return new ArrayList<>(map.values());
	}

	public static List<List<String>> ultimateGroupAnagrams(String[] strs) {
		Map<Map<Character, Integer>, List<String>> mainMap = new HashMap<>();

		for (String s : strs) {
			Map<Character, Integer> frequencyMap = new HashMap<>();
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
			}

			if (!mainMap.containsKey(frequencyMap)) {
				mainMap.put(frequencyMap, new ArrayList<>());
			}
			mainMap.get(frequencyMap).add(s);
		}
		return new ArrayList<>(mainMap.values());
	}
}
