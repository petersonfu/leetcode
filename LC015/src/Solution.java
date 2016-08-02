import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class NumEntry {
	public int count;
	public int index;
}

public class Solution {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums == null || nums.length < 3) {
			return result;
		}
		Map<Integer, NumEntry> map = new HashMap<Integer, NumEntry>();
		List<Integer> list = new ArrayList<Integer>();
		int counter = 0;
		for (int i = 0; i < nums.length; i++) {
			int n = nums[i];
			NumEntry entry = map.get(n);
			if (entry == null) {
				entry = new NumEntry();
				entry.count = 1;
				entry.index = counter;
				counter++;
				map.put(n, entry);
				list.add(n);
			} else {
				entry.count = entry.count + 1;
			}
		}
		// case 0: three 0's.
		NumEntry entry0 = map.get(0);
		if (entry0 != null && entry0.count >= 3) {
			result.add(Arrays.asList(0, 0, 0));
		}
		// case 1: 2x + y.
		for (int i = 0; i < list.size(); i++) {
			int n = list.get(i);
			if (map.get(n).count >= 2) {
				NumEntry e = map.get(-2 * n);
				if (e != null && e.index != i) {
					result.add(Arrays.asList(n, n, -2 * n));
				}
			}
		}
		// case 2: x + y + z
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i + 1; j < list.size(); j++) {
				int n1 = list.get(i);
				int n2 = list.get(j);
				NumEntry e = map.get(-n1 - n2);
				if (e != null && e.index > j) {
					result.add(Arrays.asList(n1, n2, -n1 - n2));
				}
			}
		}
		return result;
	}
}