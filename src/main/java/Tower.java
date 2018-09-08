import java.util.Stack;

public class Tower {
    static Stack<Integer>[] stake = new Stack[4];

    public static void main(String[] args) {
        stake[1] = new Stack<Integer>();
        stake[2] = new Stack<Integer>();
        stake[3] = new Stack<Integer>();

        for (int i = 3; i > 0 ; i--) {
            stake[1].push(i);
        }

        System.out.println(stake[1].toString());
        solve(1, 3, 9);
        for (int i = 1; i < stake.length; i++) {
            System.out.println(stake[i]);
        }
    }

    static void solve(int source, int dest, int base){
        if (!stake[source].isEmpty() && stake[source].peek() < base) {
            int ring = stake[source].pop();
            if (stake[dest].isEmpty() || stake[dest].peek() > ring){
                stake[dest].push(ring);
            } else {
                stake[source ^ dest].push(ring);
                solve(dest, source, ring);
                stake[source ^ dest].pop();
                stake[dest].push(ring);
            }
            solve(source, dest, base);
        }
    }
}
