package edu.iu.habahram.DinerPancakeHouseMerge.repository;

import edu.iu.habahram.DinerPancakeHouseMerge.model.Details;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    public static Logger LOG = LoggerFactory.getLogger(UserRepository.class);
    public UserRepository() {
        Path path = Paths.get(DATABASE);
        try {
            Files.createFile(path);
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }
    }

    private static final String DATABASE = "data/customers.txt";
    private static void appendToFile(Path path, String content)
            throws IOException {
        Files.write(path,
                content.getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);
    }

    public List<Details> findAll() throws IOException {
        List<Details> result = new ArrayList<>();
        Path path = Paths.get(DATABASE);
        List<String> lines = Files.readAllLines(path);
        for(String line : lines){
            if(!line.trim().isEmpty()){
                String[] parts = line.split(",");
                Details details = new Details();
                details.setName(parts[0]);
                details.setPassword(parts[1]);
                details.setEmail(parts[2]);
                result.add(details);
            }
        }
        return result;
    }

    public void save(Details details) throws Exception{
        Details details1 = findByUsername(details.name());
        if(details1 != null){
            throw new Exception("This username already exists. Please choose another one.");
        }
        Path path = Paths.get(DATABASE);
        String data = details.name() + "," + details.password() + "," + details.email();
        appendToFile(path, data + System.lineSeparator());

    }

    public Details findByUsername(String username) throws IOException{
        List<Details> details = findAll();
        for(Details detail : details){
            if(detail.name().equals(username)){
                return detail;
            }
        }
        return null;
    }
}
