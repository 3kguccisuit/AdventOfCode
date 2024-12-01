import java.io.*;
import java.util.*;

class Part1 {
    private List<Integer> leftList = new ArrayList<>();
    private List<Integer> rightList = new ArrayList<>();
    private int totalDistance = 0;

    private void readFile(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("   ");
                leftList.add(Integer.parseInt(parts[0]));
                rightList.add(Integer.parseInt(parts[1]));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
            e.printStackTrace();
        }
    }

    private void findDistanceBetween() {
        Collections.sort(leftList);
        Collections.sort(rightList);

        for (int i = 0; i < leftList.size(); i++) {
            totalDistance += Math.abs(leftList.get(i) - rightList.get(i));
        }
    }

    public static void main(String[] args) {
        Part1 sol = new Part1();
        sol.readFile("input.txt");
        sol.findDistanceBetween();
        System.out.println(sol.totalDistance);
    }
}
