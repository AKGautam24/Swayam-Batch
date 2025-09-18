import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class MergingOverlapping {
    public static void main(String args []) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int arr [][]=new int [n][2];

        for(int j=0;j<n;j++) {
            String line =br.readLine();
            arr[j][0]=Integer.parseInt(line.split(" ")[0]);
            arr[j][1]= Integer.parseInt(line.split(" " ) [0]);
        }
        mergeoverlappingInterval(arr);


    }

    public static void mergeoverlappingInterval(int arr [] []) {
        pair [] pairs=new pair[arr.length];
        for(int i=0;i<arr.length;i++) {
            pairs[i] =new pair(arr[i][0],arr[i][1]);

        }
        Arrays.sort(pairs);
        Stack<pair> st=new Stack<>();
        for(int i=0;i<pairs.length;i++) {
            if(i==0) {
                st.push(pairs[i]);
            } else {
                pair top=st.peek();
                if(pairs[i].st>top.end) {
                    st.push(pairs[i]);
                } else {
                    top.end=Math.max(top.end,pairs[i].end);
                }
            }
        }
        Stack<pair> re=new Stack<>();
        while(st.size()>0) {
            re.push(st.pop());

        }
        while(re.size()>0) {
            pair p=re.pop();
            System.out.println(p.st+" "+ p.end);
        }

    }
        public static class pair implements Comparable<pair> {
        int st;
        int end;

        pair(int st, int end) {
            this.st=st;
            this.end=end;
        }
        public int compareTo(pair other) {
            if(this.st!=other.st) {
                return this.st=other.st;
            } else {
                return this.end=other.end;
            }
        }
    }
}
