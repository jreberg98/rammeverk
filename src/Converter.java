import java.io.File;
// TODO: Fjerne hele filen?
public class Converter {

/* ------------- HENTE FIL LOKALT ELLER FRA URL -----------*/
    public Converter(File file){

    }
    public Converter(String url){

    }

/*----------- FIL INFO FOR KONVERTOR&TOSTRING---------*/
    private String printFile() {
        return null;
    }

    private String getFileType() {
        return null;
    }

    private String getFileName() {
        return null;
    }




    @Override
    public String toString() {
        return String.format("Laster inn: " + getFileType() + "Med navn: " + getFileName() + ":\n" + printFile());
    }




}