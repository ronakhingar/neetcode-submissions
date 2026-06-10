class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map= new HashMap<>();

        for(String str:strs){

          char[] chars = str.toCharArray();
            
            // 2. Sort the array
            Arrays.sort(chars);
            
            // 3. Create the key from the sorted chars
            String key = new String(chars);


   

            map.computeIfAbsent(key,x->new ArrayList<>()).add(str);
          
        }

        return new ArrayList<>(map.values());
    }
}
