
public class Main {

    public static void main(String[] args) {
        // write your code here

        /* ------------- DATABASE ---------------- */
        // En ekstra klasse til å holde en kobling til databasen
        /*
        DatabaseHandler dbFull = FileHandler.connectMYSQL("adresse", "brukernavn", "passord");
        DatabaseHandler dbSkjema = FileHandler.connectMYSQL("adresse", "brukernavn", "passord").selectSchema("skjema");
        DatabaseHandler dbTabell = FileHandler.connectMYSQL("adresse", "brukernavn", "passord").selectSchema("skjema").selectTable("navn");

         */
        /* ----------   LESE FRA SPESIFISERT FIL   ------------ */
/*
        // Hente ut spesifisert innhold i Json fil
        Result data = FileHandler.getJSON("prosjekt/data/example.json");
        Result object = data.getByTag("planetsystemet");
        Result outer = object.getByTag("planet");
        Result middle = outer.getByTag("by");
        Result inner = middle.getByTag("person");
        Result innest = inner.getByTag("age");


        // Hente ut spesifisert innhold fra Xml
        Result dataXML = FileHandler.getXML("fil.xml");
        Result objectXML = dataXML.getByTag("planetsystemet");
        Result outerXML = objectXML.getByTag("planet");
        Result middleXML = outerXML.getByTag("by");
        Result innerXML = middleXML.getByTag("person");
        Result innestXML = innerXML.getByTag("age");
        /*----------REDIGERING AV FILER-----------*/
        //redigere innhold i spesifisert tag i spesifisert fil

        //Redigering av innhold i Json fil
        /*
       Result result = FileHandler.getJSON("fil.json");
       String path= result.getPath();
       result.setValue("new value",path);


       //Redigering av innhold i XML fil
        Result xResult = FileHandler.getJSON("fil.xml");
        String xPath= xResult.getPath();
        xResult.setValue("new value",xPath);
        // Dersom db en kobling gir den alle schema med alle tabeller, dersom db er et schema gir den alle tabeller, dersom det er en tabell gir den alt i tabellen
        Result dataMySQL = FileHandler.getMYSQL(dbFull);
        /* ---------- SKRIVE TIL FIL | SKRIVE OVER FIL ------------------ */
        //Legge til et opbjekt uten å gjøre en endring på det andre som er i filen

        //Json
        /*
        Result jRes = FileHandler.getJSON("fil.json");
        jRes.append(object);
        //Xml
        Result xRes = FileHandler.getJSON("fil.xml");
        xRes.append(object);
        //Skrive til spesifisert tag i fil uten endringer på andre objekter i samme tag.
        //Json
        Result spesiRes = FileHandler.getJSON("fil.json");
        String spesiPath = spesiRes.getPath();
        spesiRes.append(object,spesiPath);
        //Xml
        Result spesRes = FileHandler.getJSON("fil.xml");
        String spesPath = spesiRes.getPath();
        spesRes.append(object,spesPath);


        /* -------------- FIL KONVERTERE -------------- */
        FileHandler.XMLtoJSON("prosjekt/data/example.xml", "prosjekt/data/nyfil.json");
        FileHandler.JSONtoXML("prosjekt/data/nyfil.json", "prosjekt/data/nyfil.xml");
        // FileHandler.JSONtoMYSQL("fil.json", dbFull);
        // FileHandler.JSONtoMYSQL("fil.json", dbSkjema, "schema");
        // FileHandler.JSONtoMYSQL("fil.json", dbTabell, "schema", "table");
        // FileHandler.MYSQLtoJSON(dbFull, "nyfil.json");
        // FileHandler.MYSQLtoJSON(dbFull, "schema", "table", "nyfil.json");


        // TODO: Legge til setValue(String), setValue(String, String), addValue(String, String), addValue(Tree)
    }


}