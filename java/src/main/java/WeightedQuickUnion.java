import java.util.Scanner;

public class WeightedQuickUnion {
    private int[] data;
    private int[] size;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Input Size: ");
        int size = scanner.nextInt();
        WeightedQuickUnion wQu = new WeightedQuickUnion(size);
        System.out.println("For union enter like: 2 3");
        System.out.println("For isConnected enter like: is 2 3");
        int x,y;
        String[] tmp;
        while(scanner.hasNext()) {
            tmp = scanner.nextLine().split("\\s+");
            if(tmp.length == 2) {
                x = Integer.valueOf(tmp[0]);
                y = Integer.valueOf(tmp[1]);
                if(wQu.isValidInput(x, y)) {
                    if(!wQu.isConnected(x, y)) {
                        wQu.union(x, y);
                        System.out.println(x + " is now connected with " + y);
                    } else {
                        System.out.println(x + " is already connected with " + y);
                    }
                } else {
                    System.out.println("Invalid input");
                }
            } else if(tmp.length == 3) {
                x = Integer.valueOf(tmp[1]);
                y = Integer.valueOf(tmp[2]);
                if(wQu.isValidInput(x, y)) {
                    System.out.println(wQu.isConnected(x, y));
                } else {
                    System.out.println("Invalid input");
                }
            }
        }
    }

    public WeightedQuickUnion(int size) {
        this.data = new int[size];
        this.size = new int[size];
        for(int idx = 0; idx < data.length; idx++) {
            data[idx] = idx;
        }
    }

    public int root(int x) {
        while(data[x] != x) {
            //Path Compression
            //data[x] = data[data[x]];
            x = data[x];
        }
        return x;
    }

    public boolean isConnected(int x, int y) {
        return root(x) == root(y);
    }

    public void union(int x, int y) {
        int rootOfX = root(x);
        int rootOfY = root(y);
        if(size[rootOfX] > size[rootOfY]) {
            data[rootOfX] = rootOfY;
            ++size[rootOfY];
        } else {
            data[rootOfX] = rootOfY;
            ++size[rootOfX];
        }
    }

    public boolean isValidInput(int x, int y) {
        return (x < data.length && y < data.length);
    }
}
