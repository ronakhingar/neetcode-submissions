class Solution {
    public int evalRPN(String[] tokens) {
        

        Stack<Integer> stack = new Stack<>();

        for(String token:tokens){


            if(token.equals("+")){
                stack.push(add(stack.pop(),stack.pop()));
            }else if(token.equals("-")){
                stack.push(subtract(stack.pop(),stack.pop()));
            }else if(token.equals("*")){
                stack.push(multiply(stack.pop(),stack.pop()));

            }else if(token.equals("/")){
                stack.push(divide(stack.pop(),stack.pop()));
            }else{
                stack.push(Integer.parseInt(token));
            }
            
        }

        return stack.pop();


    }

    private int add(int a, int b){
            return a+b;
    }

        private int subtract(int b, int a){
            return a-b;
    }

        private int multiply(int a, int b){
            return a*b;
    }

        private int divide(int b, int a){
            return a/b;
    }
}
