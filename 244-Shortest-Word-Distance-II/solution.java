public class WordDistance {
    HashMap<String, ArrayList<Integer>> map;
    HashMap<String, Integer> mapExist;
    
    public WordDistance(String[] words) {
        mapExist = new HashMap<>();
        map = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            if(map.containsKey(words[i]))
                map.get(words[i]).add(i);
            else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(words[i], list);
            }
        }
    }

    public int shortest(String word1, String word2) {
        if(mapExist.containsKey(word1+"+"+word2))
            return mapExist.get(word1+"+"+word2);
        if(mapExist.containsKey(word2+"+"+word1))
            return mapExist.get(word2+"+"+word1);
        ArrayList<Integer> l1 = map.get(word1);
        ArrayList<Integer> l2 = map.get(word2);
        int ans = Integer.MAX_VALUE;
        int i1 = 0, i2 = 0;
        while(i1 < l1.size() && i2 < l2.size()){
            ans = Math.min(ans, Math.abs(l1.get(i1) - l2.get(i2)));
            if(l1.get(i1) > l2.get(i2))
                i2++;
            else
                i1++;
        }
        
        mapExist.put(word1+"+"+word2, ans);
        mapExist.put(word2+"+"+word1, ans);
        return ans;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");