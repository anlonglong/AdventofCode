import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class SyntaxChunks {

    public static void main(String[] args) {
        try {
            //Part1
            Path path1 = FileSystems.getDefault().getPath("data", "syntax_chunks.txt");
            List<String> lines1 = Files.readAllLines(path1);
            System.out.println("Lines1 = " + lines1.size());
            long score1 = Solution.solveIssueOne(lines1);
            System.out.println("Score1 = " + score1);
            //Part2
            Path path2 = FileSystems.getDefault().getPath("data", "syntax_chunks2.txt");
            List<String> lines2 = Files.readAllLines(path2);
            System.out.println("Lines2 = " + lines2.size());
            long score2 = Solution.solveIssueTwo(lines2);
            System.out.println("Score2 = " + score2);
        }catch (IOException e){
            System.out.println("Error message = " + e.getMessage());
        }
    }

}
