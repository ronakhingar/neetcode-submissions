class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> map = new HashMap<>();

        map.put('}','{');
        map.put(']','[');
        map.put(')','(');
        for(Character c: s.toCharArray()){

            if(map.containsKey(c) ){

            
            if((stack.isEmpty() || !stack.peek().equals(map.get(c)))){
                return false;
            }
            stack.pop();
            }else{
                stack.push(c);
            }

        }

        return stack.isEmpty();
    }
}
