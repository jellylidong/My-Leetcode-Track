public class TwoSum {
    HashMap<Integer, Integer> map = new HashMap<>();
    // Add the number to an internal data structure.
	public void add(int number) {
	    if(map.containsKey(number))
	        map.put(number, map.get(number) + 1);
	    else
	        map.put(number, 1);
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for(Integer n: map.keySet()){
	        if(map.containsKey(value-n)){
	            if(value-n == n && map.get(n) > 1)
	                return true;
	            else if(value -n != n)
	                return true;
	        }
	            
	    }
	    
	    return false;
	}
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);