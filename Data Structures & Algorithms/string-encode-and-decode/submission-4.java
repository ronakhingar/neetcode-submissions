class Solution {

    public String encode(List<String> strs) {

        StringBuilder output= new StringBuilder();
        for(int i=0;i<strs.size();i++){

            int len = strs.get(i).length();
            output.append(len);
            output.append("#");
            output.append(strs.get(i));
        }

        return output.toString();  
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        for(int i=0;i< str.length();i++){
            int len=0;
            int multiplier=1;
            while(i<str.length() && Character.isDigit(str.charAt(i))){
                
                len=multiplier*len + (Integer.parseInt(str.charAt(i)+""));
                multiplier=10;
                i++;
            }
            
                String curr=str.substring(i+1,i+1+len);
                list.add(curr);
                i+=len;

        }
        return list;
    }
}
