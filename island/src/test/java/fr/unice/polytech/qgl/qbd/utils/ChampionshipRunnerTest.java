package fr.unice.polytech.qgl.qbd.utils;

import eu.ace_design.island.runner.Runner;
import fr.unice.polytech.qgl.qbd.Explorer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static eu.ace_design.island.runner.Runner.run;

/**
 * PolyTech Nice / SI3 / Module POO-Java
 * Annee 2015 - qbd - Lab 3
 * Package fr.unice.polytech.qgl.qbd
 *
 * @author Flavian Jacquot
 * @version 23/11/2015
 * @since 1.8.0_60
 */
public class ChampionshipRunnerTest {
    int weekNumber;
    private Runner runner;
    private File mapFile;
    private long seed;
    private int startX;
    private int startY;
    private String direction;
    private int actionPoints;
    private int mens;
    private HashMap<String, Integer> contrats;
    private String outputPath;


    public ChampionshipRunnerTest(int weekNumber) {
        this.weekNumber = weekNumber;
        final String mapPath = "https://raw.githubusercontent.com/mosser/QGL-15-16/master/championships/week" + weekNumber + "/_map.json";
        final String scalaPath = "https://raw.githubusercontent.com/mosser/QGL-15-16/master/arena/src/main/scala/Week" + weekNumber + ".scala";
        final String scalaGeneralPath = "https://raw.githubusercontent.com/mosser/QGL-15-16/master/arena/src/main/scala/library/Islands.scala";


        String path = "maps/" + weekNumber + "/";


        //Apply
        File mapDirectory = new File(path);
        if (!mapDirectory.exists()) {
            mapDirectory.mkdir();
            String saveTo = path + "map.json";
            download(mapPath, saveTo);
        }

        outputPath = path + "output/";
        File resultDir = new File(outputPath);
        if (!resultDir.exists()) {
            resultDir.mkdir();
        }


        File mapFile = new File(path + "map.json");

        if (!mapDirectory.exists()) {
            System.out.println("Map !exists Downloading ...");
            download(mapPath, mapFile.getPath());
        }
        this.mapFile = mapFile;

        File confFile = new File(path + "Week" + weekNumber + ".scala");
        String seedFile = "maps/Islands.scala";

        if (!confFile.exists()) {
            System.out.println("Scala conf file !exists Downloading ...");
            //Download scala declaration
            download(scalaPath, confFile.getPath());

            //Get seed
            download(scalaGeneralPath, seedFile);

        }
        contrats = new HashMap<>();
        parseScalaConf(confFile);

        //now get seed
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(seedFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String ligne :
                lines)
            if (ligne.contains("val s" + weekNumber)) {
                String seed = ligne.split("=")[1];
                System.out.println("Setting seed:<" + seed + ">");
                seed = seed.replace("L", "");
                seed = seed.replace(" ", "");
                System.out.println("Setting seed2:<" + seed + ">");

                // for(Character c:text)
                {

                }
                try {
                    this.seed = Long.decode(seed);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("char values");
                    System.out.println(verifyValue(seed));
                    System.out.println("Setting seed3:<" + seed + ">");

                    BigInteger bi = new BigInteger(seed.substring(2), 16);
                    System.out.println(bi);
                    System.out.println(Long.MAX_VALUE);
                    this.seed = bi.longValue();

                }

                break;
            }
    }

    public static String verifyValue(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append("<" + (int) c + ":" + c + ">").append(",");
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {


        ChampionshipRunnerTest cr = new ChampionshipRunnerTest(47);
        cr.runWith();

        //cr = new ChampionshipRunner(49);


    }

    //http://stackoverflow.com/questions/921262/how-to-download-and-save-a-file-from-internet-using-java
    private void download(String url, String to) {
        URL website = null;
        try {
            website = new URL(url);
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            FileOutputStream fos = new FileOutputStream(to);
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void parseScalaConf(File file) {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(file.getAbsolutePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String line : lines) {
            if (line.contains("val crew")) {
                String[] split = line.split(" ");
                this.mens = Integer.valueOf(split[split.length - 1]);
            } else if (line.contains("val budget")) {
                String[] split = line.split(" ");
                this.actionPoints = Integer.valueOf(split[split.length - 1]);
            } else if (line.contains("val plane")) {
                String[] split = line.split("\\(|\\)");
                String[] values = split[1].split(",");

                this.startX = Integer.valueOf(values[0].trim());
                this.startY = Integer.valueOf(values[1].trim());
                direction = values[2].split("\\.")[1];
            } else if (line.contains("val objectives")) {
                String[] split = line.split("\\(\\(");
                String contractListString = split[1].replaceAll("\\(|\\)|,|Set", " ");
                String[] contractListTmp = contractListString.split(" ");
                ArrayList<String> contractList = new ArrayList<>();
                for (String aContract :
                        contractListTmp) {
                    if (!aContract.trim().isEmpty()) {
                        contractList.add(aContract);
                    }
                }
                System.out.println("Setting contract list " + contractListString);
                for (int i = 0; i < contractList.size(); i += 2) {
                    this.contrats.put(contractList.get(i).trim(), Integer.valueOf(contractList.get(i + 1).trim()));
                }
            }
        }

    }

    public void runWith() {
        System.out.println(this.toString());

        try {
            runner = run(Explorer.class)
                    .exploring(mapFile)
                    .withSeed(seed)
                    .startingAt(startX, startY, direction)
                    .backBefore(actionPoints)
                    .withCrew(mens)
                    .storingInto(outputPath);

            for (String s : this.contrats.keySet()) {
                runner.collecting(contrats.get(s), s);
            }


            runner.fire();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "ChampionshipRunner{" +
                "mapFile=" + mapFile +
                ", seed=" + seed +
                ", startX=" + startX +
                ", startY=" + startY +
                ", direction='" + direction + '\'' +
                ", actionPoints=" + actionPoints +
                ", mens=" + mens +
                ", contrats=" + contrats +
                ", outputPath='" + outputPath + '\'' +
                ", weekNumber=" + weekNumber +
                '}';
    }

    public String getOutputPath() {
        return outputPath;
    }
}
