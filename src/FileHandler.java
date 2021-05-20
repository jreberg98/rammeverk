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

        // Lager roten, for å ha tak i "toppen" av treet
        // Current er for å være mer fleksibel i treet som blir laget

        current = root = new Result();

        // Bygger opp nodene og legger til barn sålenge filen ikke er ferdig
        String next;
        while (scanner.hasNextLine()){
            next = scanner.nextLine();
            next = next.replace("\"", "");

            // Lager en ny node for fil innholdet
            if (next.startsWith("{")) {
                // Er i rot noden
            } else if (next.contains("[")){
                // Lagrer en array spm en sammenhengende string
                String key = next.split(":")[0];
                String temp = "";
                next = scanner.next();
                String seperator = ":-:";
                // Slår sammen alle elementene i løkken
                while (!next.contains("]")){
                    next = next.replace(",", "");
                    next = next.replace("\"", "");
                    temp += seperator + next;
                    next = scanner.next();
                }
                // Legger til en node med nøkkelen lik forelderen, og sata med string tilsvarende alle elementer, skilt med et skilletegn
                current.add(key, temp);
            } else if (next.contains("{")) {
                // Lager en ny foreldernode
                String[] splitted = next.split(":");
                current.add(splitted[0]);
                current = current.lastChild();


            } else if (next.contains(":")){
                // Lager et nytt barn
                String[] splitted  = next.split(": ");
                current.add(splitted[0], splitted[1]);
            } else if (next.startsWith("}")){
                // Går en node opp for å fortsette på treet
                current = current.parent;
            }

        }

        return root;
    }

    private static Result getXML(File file) {
        // Lager roten i filen
        Result root, current;


        // Leser fila
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Lager roten, for å ha tak i "toppen" av treet
        // Current er for å være mer fleksibel i treet som blir laget
        current = root = new Result();

        // Bygger opp nodene og legger til barn sålenge filen ikke er ferdig
        String next;

        while (scanner.hasNextLine()){
            next = scanner.nextLine();


            if (next.matches("^\\s*\\<\\w+\\>$")) {
                current.add(next.replace("<", "").replace(">", ""));
                current = current.lastChild();
            // Matcher med både start tag og slutt tag
            } else if (next.matches("^\\s*\\<\\w+\\>[\\w ]+\\<\\/\\w+\\>$")){
                String[] splitted = next.split(">");
                String[] data = splitted[1].split("<");
                current.add(splitted[0].replace("<", ""), data[0]);
            } else if (next.matches("^\\s*\\<\\w+\\>[\\w ]+\\<\\/\\w+\\> \\<\\/\\w+\\>$")) {
                String[] splitted = next.split(">");
                String[] data = splitted[1].split("<");
                current.add(splitted[0].replace("<", ""), data[0]);
                current = current.parent;
            } else if (next.matches("^\\s*\\<\\w+\\>$")){
                current = current.parent;
            }
        }



        return root;
    }

    public static Result getMYSQL(DatabaseHandler dbFull) {
        return null;
    }

    public static void main(String[] args) {

        /*
        Result root = new Result();
        root.add("Meg");
        root.lastChild().add("Fornavn", "Jonathan");
        root.lastChild().add("Mellomnavn", "Ruud");
        root.lastChild().add("Etternavn", "Reberg");
        System.out.println(root.children.get(0).children.get(0));
        System.out.println(root.lastChild().getByTag("Fornavn"));
        */

        //Result root = FileHandler.getJSON(new File("prosjekt/data/simple.json"));
        Result root = FileHandler.getXML(new File("prosjekt/data/simple.xml"));

        System.out.println("\n\n\n");
        root.print2(root);

        //System.out.println(root);
    }

}