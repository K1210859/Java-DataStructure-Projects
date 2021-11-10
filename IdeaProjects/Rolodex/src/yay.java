import java.util.ArrayList;

public class yay {
    public static void main(String[] args)
    {
        System.out.println(purge(new char[]{'r','t','e'}));
    }
    public static char[] purge(char[] list)
    {
        char[] newList=null;
        ArrayList<Character> nonVowels = new ArrayList<Character>();
        for (int i=0;i< list.length;i++)
        {
            if(list[i]!='a' || list[i]!='e' || list[i]!='i' || list[i]!='o' || list[i]!='u')
            {
                nonVowels.add(list[i]);
            }
        }
        newList = new char[nonVowels.size()];
        for(int x =0; x< nonVowels.size();x++)
        {
            newList[x] = nonVowels.get(x);
        }
        return newList;
    }
}
