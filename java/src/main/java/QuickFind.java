import java.util.Scanner;

public class QuickFind {
    private int[] data;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Input Size: ");
        int size = scanner.nextInt();
        QuickFind quickFind = new QuickFind(size);
        System.out.println("For union enter like: 2 3");
        System.out.println("For isConnected enter like: is 2 3");
        int x,y;
        String[] tmp;
        while(scanner.hasNext()) {
            tmp = scanner.nextLine().split("\\s+");
            if(tmp.length == 2) {
                x = Integer.valueOf(tmp[0]);
                y = Integer.valueOf(tmp[1]);
                if(quickFind.isValidInput(x, y)) {
                    if(!quickFind.isConnected(x, y)) {
                        quickFind.union(x, y);
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
                if(quickFind.isValidInput(x, y)) {
                    System.out.println(quickFind.isConnected(x, y));
                } else {
                    System.out.println("Invalid input");
                }
            }
        }
    }

    public QuickFind(int size) {
        this.data = new int[size];
        for(int idx = 0; idx < data.length; idx++) {
            data[idx] = idx;
        }
    }

    public boolean isConnected(int x, int y) {
        return data[x] == data[y];
    }

    public void union(int x, int y) {
        int xId = data[x];
        int yId = data[y];
        for(int idx = 0; idx < data.length; idx++) {
           if(data[idx] == xId) {
               data[idx] = yId;
           }
        }
    }

    public boolean isValidInput(int x, int y) {
        return (x < data.length && y < data.length);
    }
}
