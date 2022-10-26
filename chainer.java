/**
 * chainer
 */
public class chainer {

    public static void main(String[] args) {
        int[] firsts = new int[args.length];
        int[] seconds = new int[args.length];

        for (int i = 0; i < args.length; i++) {
            String[] parts = args[i].split(",");
            firsts[i] = Integer.parseInt(parts[0]);
            seconds[i] = Integer.parseInt(parts[1]);
        }

        // System.out.println("kartesian product");
        // for (int i : firsts) {
        // for (int j : seconds) {
        // System.out.print("(" + i + "," + j + ")");
        // }
        // System.out.println();

        // }

        int[] firstLinks = new int[args.length * args.length];
        int[] secondLinks = new int[args.length * args.length];
        boolean[] valuable = new boolean[args.length * args.length];

        int index = 0;
        for (int i = 0; i < seconds.length; i++) {
            // System.out.println("element first: " + "(" + firsts[i] + "," + seconds[i] +
            // ")");
            for (int j = 0; j < firsts.length; j++) {
                // System.out.println("element second: " + "(" + firsts[j] + "," + seconds[j] +
                // ")");
                if (seconds[i] == firsts[j]) {
                    // System.out.println("match! " + "(" + firsts[i] + "," + seconds[j] + ")");
                    if (!ArrayContains(firstLinks, secondLinks, firsts[i], seconds[j])) {
                        firstLinks[index] = firsts[i];
                        secondLinks[index] = seconds[j];
                        valuable[index] = true;
                        index++;
                    }
                }
            }
        }

        System.out.println("chain");
        for (int i = 0; i < secondLinks.length; i++) {
            if (valuable[i])
                System.out.println("(" + firstLinks[i] + "," + secondLinks[i] + ")");
        }

    }

    private static boolean ArrayContains(int[] haystack1, int[] haystack2, int needle1, int needle2) {

        for (int i = 0; i < haystack1.length; i++) {
            if (haystack1[i] == needle1 && haystack2[i] == needle2)
                return true;
        }
        // System.out.println("no");
        return false;
    }
}
