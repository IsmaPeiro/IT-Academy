package n1Exercise3;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

public class IOManagement {
    private final Path path=Paths.get(System.getProperty("java.class.path")).getParent().getParent().resolve(Paths.get("src/main/java/n1Exercise3/resources"));
    private final File countriesFile = new File(this.path.toString() , "countries.txt");
    private final File rankingFile = checkRankingExists();
    
    public IOManagement() throws IOException {
    }
    
    private File checkRankingExists() throws IOException {
        
        File rankingFile = new File(this.path.toString() , "ranking.txt");
        if (!rankingFile.exists()) {
            rankingFile.createNewFile();
        }
        return rankingFile;
    }
    
    public void writeRanking(String userName, int score) throws IOException {
        ArrayList<String> ranking = new ArrayList<>();
        BufferedReader rankingBR = new BufferedReader(new FileReader(rankingFile));
        
        rankingBR.lines().forEach(ranking::add);
        ranking.add(userName + "-" + score);
        
        Collections.sort(ranking);
        ranking.sort((str1, str2) -> Integer.compare(Integer.parseInt(str2.split("-")[1]), Integer.parseInt(str1.split("-")[1])));
        
        FileWriter rankingFW = new FileWriter(rankingFile);
        BufferedWriter rankingBW = new BufferedWriter(rankingFW);
        
        for (String rank : ranking) {
            rankingBW.write(rank);
            rankingBW.newLine();
        }
        rankingBW.flush();
        rankingBW.close();
    }
    
    
    public Stream<String> readCountriesFile() throws FileNotFoundException {
        return new BufferedReader(new FileReader(countriesFile)).lines();
    }
}
