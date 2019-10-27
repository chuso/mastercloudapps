package mastermindWeek3.mastermind.models.DAO;

import java.io.FileWriter;
import java.io.BufferedReader;

interface DAO {

    void save(FileWriter fileWriter);

    void load(BufferedReader bufferedReader);

}
