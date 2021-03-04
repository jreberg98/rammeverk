import java.io.File;

public class Converter {

/* ------------- HENTE FIL LOKALT ELLER FRA URL -----------*/
    public Converter(File file){

    }
    public Converter(String url){

    }

/*----------- FIL INFO FOR KONVERTOR&TOSTRING---------*/
    private String printFile() {
    }

    private String getFileType() {
    }

    private String getFileName() {
    }




    @Override
    public String toString() {
        return String.format("Laster inn: " + getFileType() + "Med navn: " + getFileName() + ":\n" + printFile());
    }




}