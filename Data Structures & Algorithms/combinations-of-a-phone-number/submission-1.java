class Solution {
        Map<Character,List<Character>> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        List<String> output = new ArrayList<>();

        map.put('2',List.of('a','b','c'));
        map.put('3',List.of('d','e','f'));
        map.put('4',List.of('g','h','i'));
        map.put('5',List.of('j','k','l'));
        map.put('6',List.of('m','n','o'));
        map.put('7',List.of('p','q','r','s'));
        map.put('8',List.of('t','u','v'));
        map.put('9',List.of('w','x','y','z'));

// Add this edge case check
    if (digits == null || digits.isEmpty()) {
        return output; 
    }
        createCombinations(digits,output,0, new StringBuffer());
        return output;
    }

    private void createCombinations(String digits,List<String> output,int index,StringBuffer str){

        if(index==digits.length()){
            output.add(str.toString());
            return;
        }

        for(Character c: map.get(digits.charAt(index)) ){

            createCombinations(digits,output,index+1,str.append(c));
            str.deleteCharAt(str.length()-1);
        }


    }
}
