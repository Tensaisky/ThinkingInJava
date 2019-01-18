package unit11.holding;

import java.util.SortedSet;

public class E15_Evaluator {
    public static void main(String[] args){
        Stack<Character> stack = new Stack<>();
        String s = "+U+n+c---+e+r+t---+a-+i-+n+t+y---+ -+r+u--+l+e+s--";
        char data[] = s.toCharArray();
        for (int i = 0; i < data.length; i++){
            if (data[i] == '+'){
                    stack.push(data[i+1]);
            }
            else if (data[i] == '-'){
                System.out.print(stack.pop());
            }
        }
    }
}
