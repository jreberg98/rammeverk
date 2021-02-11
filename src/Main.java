public class Main {

    public static void main(String[] args) {
        // write your code here

        /* ------------- DATABASE ---------------- */
        // En ekstra klasse til å holde en kobling til databasen
        DB db = rammeverk.connectMYSQL("adresse", "brukernavn", "passord");
        DB db = rammeverk.connectMYSQL("adresse", "brukernavn", "passord").selectSchema("schema");
        DB db = rammeverk.connectMYSQL("adresse", "brukernavn", "passord").selectSchema("schema").selectTable;


        /* ----------   LESE FRA FIL   ------------ */
        // Får alle data fra JSON fil
        Object[][] data = rammeverk.getJSON("fil.json");
        // Får alle data fra en XML fil
        Object[][] data = rammeverk.getXML("fil.xml");
        // Får et utvalg av dataen fra en XML fil, tilsvarende for JSON
        Object[] data = rammeverk.getXML("fil.xml").getSelected("tag");
        // Dersom db en kobling gir den alle schema med alle tabeller, dersom db er et schema gir den alle tabeller, dersom det er en tabell gir den alt i tabellen
        Object[][] data = rammever.getMYSQL(db);


        /* ---------- SKRIVE ------------------ */
        Object[] ting;
        rammeverk.writeJSON(ting, "filnavn");
        rammeverk.writeXML(ting, "filnavn");


        /* -------------- KONVERTERE -------------- */
        rammeverk.XMLtoJSON("fil.xml", "nyfil.json");
        rammeverk.JSONtoXML("fil.json", "nyfil.xml");
        rammeverk.JSONtoMYSQL("fil.json", db);
        rammeverk.JSONtoMYSQL("fil.json", db, "schema");
        rammeverk.JSONtoMYSQL("fil.json", db, "schema", "table");
        rammeverk.MYSQLtoJSON(db, "nyfil.json");
        rammeverk.MYSQLtoJSON(db, "schema", "table", "nyfil.json");

    }
}
