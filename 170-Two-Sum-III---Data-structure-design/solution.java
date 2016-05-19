public class TwoSum {
    //!!!!!
    //note: when using hashmap.keySet()
    //it first need to trasfer all KV pairs to a set
    //this is very time consuming
    //to save time, we can use a list to store all elements
    //and iterate all elements vai list
    
    HashMap<Integer, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    // Add the number to an internal data structure.
	public void add(int number) {
	    if(map.containsKey(number))
	        map.put(number, map.get(number) + 1);
	    else{
	        map.put(number, 1);
	        list.add(number);
	    }
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for(Integer n: list){
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