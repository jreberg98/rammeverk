import java.util.HashMap;

public class FileHandler {


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

    // TODO: Fjerne denne
    public static void getSelected(String tag){

    }

    public static Result getJSON(String fileName) {
        return null;
    }

    public static Result getXML(String fileName) {
        return null;
    }

    public static Result getMYSQL(DatabaseHandler dbFull) {
        return null;
    }

    // TODO: Fjerne denne?
    public static void append(Result object) {
    }
}
