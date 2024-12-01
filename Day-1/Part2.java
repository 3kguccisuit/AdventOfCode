import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;

class Part2 {
    private HashMap<Integer, Integer> leftMap = new HashMap<Integer, Integer>();
    private HashMap<Integer, Integer> rightMap = new HashMap<Integer, Integer>();
    private int similarityScore = 0;

    private void ReadFile(String fileName) {
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("   ");
                int leftValue = Integer.parseInt(parts[0]);
                int rightValue = Integer.parseInt(parts[1]);
                leftMap.put(leftValue, leftMap.getOrDefault(leftValue, 0) + 1);
                rightMap.put(rightValue, rightMap.getOrDefault(rightValue, 0) + 1);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
    }

    private void calculateSimilarityScore() {
        for (Integer key : leftMap.keySet()) {
            if (rightMap.containsKey(key)) {
                similarityScore += key * leftMap.get(key) * rightMap.get(key);
            }
        }
    }
    public static void main(String[] args) {
        Part2 sol = new Part2();

        sol.ReadFile("input.txt");
        sol.calculateSimilarityScore();

        System.out.println("similarityScore: " + sol.similarityScore);
    }
}
