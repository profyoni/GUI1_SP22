import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class ASD {
    String word;
    List<String> path = new LinkedList<>();

    public ASD(String s, List<String> path) {
        word=s;
        this.path = path;
    }
}
public class _27_WordLadder {
    List<String> dictionary = new LinkedList<>();
    public static void main(String[] args) {

        Queue<ASD> queue = new LinkedList<>();
        Stack<String> stack = new Stack<>();

        String source="SHLEP", target = "TRAIN";
        boolean targetFound = false;
        while (! targetFound && ! queue.isEmpty())
        {
            ASD next = queue.remove();
            List<String> tries = transforms(next.word);
            targetFound = tries.contains(target);

            next.path.add(next.word);
            for (String s: tries) {
                queue.add(new ASD(s, next.path));
            }

            // TODO Track Path
        }


    }

    public static List<String> transforms(String s)
    {
        return null; // TODO
    }
}
