import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class fileWrite{
    /**
     * Reads the file that was created
     * @param fileName The name of the file
     * @return reads the file
     */
    public static ArrayList<String> readFile(String fileName) {
        ArrayList<String> lines = new ArrayList<>();

        try {
            File file = new File(fileName);

            // if the file doesn't exist it creates one and returns the empty list
            if (file.createNewFile()) {
                return lines;
            }
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                lines.add(line);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Error reading file.");
            e.printStackTrace();
        }

        return lines;
    }
    /**
     * 
     * @param fileName The name of the file
     * @param lines The lines that will be wrote to the file
     * @return The new information written to the file
     */
    public static boolean writeFile(String fileName, ArrayList<String> lines) {
        try {
            FileWriter writer = new FileWriter(fileName);
            for (String line : lines) {
                writer.write(line + "\n");
            }
            writer.close();
            return true;
        } catch (IOException e) {
            System.out.println("An error occurred when saving");
            return false;
        }
    }
}