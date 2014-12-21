package trainingsplan;

/**
 * Trainingsplan für Masse und Muskelaufbau
 * Created by Berkay on 26.11.2014.
 */
public class MasseMuskelaufbau implements IZiel {
    // Wie oft pro Woche Training?
    private int frequenz;

    // Konstruktor
    public MasseMuskelaufbau(int frequenz) {
        this.frequenz = frequenz;
    }

    @Override
    public String[][] erstellePlan() {
        //2x pro Woche
        if (frequenz == 2) {
            String[][] plan = {
                    {"BENCHPRESS", "Flys", "Dips"},
                    {"3", "3", "2"}
            };
            return plan;
        } else if ( frequenz == 3 ) { //3x pro Woche

        } else if ( frequenz >= 4 ) { //3x pro Woche

        }

        return new String[0][];
    }
    /**
    public List<String> read(String key) throws IOException {
        List<String> resultSet = new ArrayList<String>();

        File inputWorkbook = new File();
        if(inputWorkbook.exists()){
            Workbook w;
            try {
                w = Workbook.getWorkbook(inputWorkbook);
                // Get the first sheet
                Sheet sheet = w.getSheet(0);
                // Loop over column and lines
                for (int j = 0; j < sheet.getRows(); j++) {
                    Cell cell = sheet.getCell(0, j);
                    if(cell.getContents().equalsIgnoreCase(key)){
                        for (int i = 0; i < sheet.getColumns(); i++) {
                            Cell cel = sheet.getCell(i, j);
                            resultSet.add(cel.getContents());
                        }
                    }
                    continue;
                }
            } catch (BiffException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else
        {
            resultSet.add("File not found..!");
        }
        if(resultSet.size()==0){
            resultSet.add("Data not found..!");
        }
        return resultSet;
    }

    public int getFrequenz() {
        return frequenz;
    }

    public void setFrequenz(int frequenz) {
        this.frequenz = frequenz;
    }
     */
}
