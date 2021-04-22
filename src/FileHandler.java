import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public final class FileHandler {


    public static DatabaseHandler connectMYSQL(String address, String username, String password ) {
        return null;
    }

    public static void writeXML(Object[] ting, String fileName) {
    }

    public static void writeJSON(Object[] ting, String fileName){
    }

    public static void MYSQLtoJSON(DatabaseHandler dbFull, String fileName) {
    }

    public static void JSONtoMYSQL(String fileName, DatabaseHandler dbTabell, String schema, String table) {
    }

    public static void JSONtoXML(String jsonFile, String xmlFile) {
    }

    public static void XMLtoJSON(String xmlFile, String jsonFile) {
    }

    public static void JSONtoMYSQL(String fileName, DatabaseHandler dbFull) {
    }

    public static void JSONtoMYSQL(String fileName, DatabaseHandler dbSkjema, String schema) {
    }

    public static void MYSQLtoJSON(DatabaseHandler dbFull, String schema, String table, String jsonFile) {
    }

    public static Result read(File file) throws IOException {
        // TODO: bruke andre exceptions
        // Sjekker om filen kan brukes, før den starter å leses
        if (!file.isFile()){
            throw new FileNotFoundException("Input is not a file");
        }
        if (!file.canRead()) {
            throw new IOException("File found, but can not be read");
        }

        String type = "";
        // TODO: sjekke filtypen, og oppdatere type
        switch (type.toUpperCase()){
            case "JSON":
                return getJSON(file);
            case "XML":
                return getXML(file);
            default:
                // Filen har en filendelse som ikke støttes
                throw new FileNotFoundException("Filen har feil filformat");
        }

    }

    private static Result getJSON(File file) {
        // Lager roten i filen
        Result root, current;


        // Leser fila
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        scanner.next();
        current = root = new Result(scanner.next());


        // Bygger opp nodene og legger til barn sålenge filen ikke er ferdig
        String next;
        while (scanner.hasNext()){
            next = scanner.next();

            // Lager en ny node
            if (next.startsWith("{")){
                current.add(next);
                current = current.lastChild();
            // Fyller inn data
            } else if (next.startsWith("\"")){
                current.add(next);
            // Går et hakk lengre opp
            } else if (next.startsWith("}")){

            }




        }

        return root;
    }

    private static Result getXML(File fileName) {
        return null;
    }

    public static Result getMYSQL(DatabaseHandler dbFull) {
        return null;
    }

}
