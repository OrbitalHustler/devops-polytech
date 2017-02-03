package fr.unice.polytech.qgl.qbd;

import fr.unice.polytech.qgl.qbd.utils.ChampionshipRunnerTest;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * PolyTech Nice / SI3 / Module POO-Java
 * Annee 2015 - qbd - Lab 3
 * Package fr.unice.polytech.qgl.qbd
 *
 * @author Flavian Jacquot
 * @version 02/01/2016
 * @since 1.8.0_60
 */
@Ignore
public class ITRunPreviousChampionships {

    @Test
    public void testMain() throws Exception {
        int[] championShips = {47, 48, 49, 50, 51, 52};
        //int[] championShips = {50,51,52};

        ArrayList<ChampionshipRunnerTest> championshipRunners = new ArrayList<>(championShips.length);
        for (Integer i :
                championShips) {
            System.out.println("Running championship " + i);
            ChampionshipRunnerTest cr = new ChampionshipRunnerTest(i);
            cr.runWith();
            verifyLog(cr.getOutputPath());
        }
    }

    private void verifyLog(String logFile) {
        JSONArray log = null;
        String text = "";
        try {
            List<String> lines = Files.readAllLines(Paths.get(logFile + "/log.json"));
            for (String line :
                    lines) {
                text += line;
            }
            log = new JSONArray(text);

        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 2; i < log.length(); i += 2) {
            JSONObject result = ((JSONObject) log.get(i)).getJSONObject("data");
            assertEquals("OK", result.getString("status"));
        }
    }
}