import java.util.Scanner;

public class Main{
    static int[] alphabet = new int[27];
    static int count;
    static int length;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        length = str.length();
        for (int i = 0; i < str.length(); i++)alphabet[str.charAt(i)-'a']++;

        dfs(0,' ');
        System.out.println(count);
    }

    public static void dfs(int index,char pre){
        if (index==length){
            count++;
            return;
        }

        for (int i = 0; i < 27; i++){
            if (alphabet[i]==0)continue;

            if (pre != (char) (i+'a')){
                alphabet[i]--;
                dfs(index+1, (char)(i+'a'));
                alphabet[i]++;
            }

        }
    }
}