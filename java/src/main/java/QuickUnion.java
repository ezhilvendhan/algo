import java.util.Scanner;

public class QuickUnion {
    private int[] data;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Input Size: ");
        int size = scanner.nextInt();
        QuickUnion quickUnion = new QuickUnion(size);
        System.out.println("For union enter like: 2 3");
        System.out.println("For isConnected enter like: is 2 3");
        int x,y;
        String[] tmp;
        while(scanner.hasNext()) {
            tmp = scanner.nextLine().split("\\s+");
            if(tmp.length == 2) {
                x = Integer.valueOf(tmp[0]);
                y = Integer.valueOf(tmp[1]);
                if(quickUnion.isValidInput(x, y)) {
                    if(!quickUnion.isConnected(x, y)) {
                        quickUnion.union(x, y);
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
                if(quickUnion.isValidInput(x, y)) {
                    System.out.println(quickUnion.isConnected(x, y));
                } else {
                    System.out.println("Invalid input");
                }
            }
        }
    }

    public QuickUnion(int size) {
        this.data = new int[size];
        for(int idx = 0; idx < data.length; idx++) {
            data[idx] = idx;
        }
    }

    public int root(int x) {
        while(data[x] != x) {
            x = data[x];
        }
        return x;
    }

    public boolean isConnected(int x, int y) {
        return root(x) == root(y);
    }

    public void union(int x, int y) {
        int xId = root(x);
        int yId = root(y);
        data[xId] = yId;
    }

    public boolean isValidInput(int x, int y) {
        return (x < data.length && y < data.length);
    }
}
