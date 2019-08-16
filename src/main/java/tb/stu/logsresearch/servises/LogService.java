package tb.stu.logsresearch.servises;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class LogService {

    public List<String> extract(String fragment) {

        List<String> chosen= new ArrayList<>();
        String path = "C:\\Users\\PC17\\Downloads\\logs.txt";

        try (Stream<String> lines = Files.lines(Paths.get(path))) {

            // Formatting like \r\n will be lost
            // String content = lines.collect(Collectors.joining());

            // UNIX \n, WIndows \r\n
            String content = lines.collect(Collectors.joining(System.lineSeparator()));
            System.out.println(content);


            String[] array = content.split("\n");
            System.out.println(array.length);

            List<String> list = new ArrayList<>(Arrays.asList(array));

            chosen = list.stream().filter(line -> line.contains(fragment)).collect(Collectors.toList());

            //System.out.println(chosen);
          //  chosen.stream().forEach(System.out::println);

            System.out.println("-------------------------Show the result-----------------------");
            for(String line:chosen){
                System.out.println(line);
            }
            System.out.println("---------------------The end---------------------------");

        } catch (IOException e) {
            e.printStackTrace();
        }
           return chosen;
    }}