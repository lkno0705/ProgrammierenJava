package klausurUebungen.stadtLandFluss;

import java.util.*;

public class Game {

    private char letter;
    private Set<ColumnType> cols = new HashSet<>();
    private int timeRemaining, minCols, maxCols, sec;
    private boolean running;
    private List<Sheet> registeredSheets = new LinkedList<>();
    private HashMap<ColumnType, List<String>> answers;

    enum ColumnType{
        CITY("Stadt"),
        COUNTRY("Land"),
        RIVER("Fluss"),
        PROFESSION("Beruf"),
        ANIMAL("Tier"),
        NAME("Vorname"),
        SPORT("Sportart"),
        FOOD("Lebensmittel"),
        BEVERAGE("Getränk"),
        GAME("Spiel");

        private String description;

        ColumnType(String s) {
            this.description = s;
        }

        public String getDescription() {
            return description;
        }
    }

    public Game(int min, int max, int sec) {
        if (!(min >= 3 && max >= min)){
            this.minCols = 3;
            this.maxCols = min;
        }
        else {
            this.minCols = min;
            this.maxCols = max;
        }
        this.sec = sec;
    }

    public char createFirstCharacter(){
        this.letter = (char) (new Random().nextInt('Z' - 'A') + 'A');
        return this.letter;
    }

    public Set<ColumnType> createCols() {

        ColumnType[] columnTypes = ColumnType.values();

        cols.add(ColumnType.CITY);
        cols.add(ColumnType.COUNTRY);
        cols.add(ColumnType.RIVER);

        int oldSize = 3;

        for (int i = 3; i < maxCols; i++){
            cols.add(columnTypes[new Random().nextInt(columnTypes.length)]);
            if (!(oldSize < cols.size())) {
                cols.add(columnTypes[new Random().nextInt(columnTypes.length)]);
                i--;
            }
        }
        return cols;
    }

    public void startGame(){
        if (!running){
            this.running = true;
            createFirstCharacter();
            createCols();
        }
    }

    public void stopGame(){
        this.running = false;
        for (Sheet sheet: registeredSheets
             ) {
            sheet.displayStop();
        }
    }

    public void calculateResults(){
        for (ColumnType column: cols
             ) {
            this.answers.put(column, new LinkedList<>());
        }
        HashMap<ColumnType, Integer>[] sheetScores = new HashMap[registeredSheets.size()];
        for (Sheet sheet: registeredSheets
             ) {
            HashMap<ColumnType, String> answers = sheet.getAnswers();
            for (ColumnType column: answers.keySet()
                 ) {
                this.answers.get(column).add(answers.get(column));
            }
        }
        for (ColumnType column: this.answers.keySet()
             ) {
            Set<String> givenAnswers = new HashSet<>();
            int i = 0;
            for (String string: this.answers.get(column)
                 ) {

                if (!isValid(string)){
                    sheetScores[i].get(column);
                }
                if (!givenAnswers.contains(string)){
                    givenAnswers.add(string);
                }
            }
        }
    }

    private boolean isValid(String string) {
        return true;
    }

    public void register(Sheet sheet) {
        this.registeredSheets.add(sheet);
    }
}
