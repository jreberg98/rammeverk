import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public final class Result {

    /**
     * Each element in the data file has a corresponding Result element. An element can have either a key or a key:value pair. An element that contains an array has the array represented as children, with numbers matching the indexes.
     */
    // Har protected for å lette få tak i variabler, men ikke mulig å bruke utenfor pakka
    protected String key, data;
    protected ArrayList<Result> children = new ArrayList<>();
    protected Result parent;

    protected void add(String key, String data){

        key = key.replace(" ", "");

        Result temp = new Result(key, data);
        children.add(temp);
        lastChild().parent = this;
    }

    protected void add(String key){

        key = key.replace(" ", "");

        Result temp = new Result(key);
        children.add(temp);
        lastChild().parent = this;
    }

    // Returnerer det nyeste elementet som er lagt til
    public Result lastChild() {
        /**
         * Method for acessing the current elements last added child. If the element has no children, an exception is thrown.
         * @return Returns the most recently added child.
         */
        if (children.isEmpty()){
            throw new ArrayIndexOutOfBoundsException("Does not contain any children");
        }
        return children.get(children.size() - 1);
    }

    private Result(String key) {
        this.key = key;
    }

    private Result(String key, String data) {
        this.key = key;
        this.data = data;
    }

    // Lager roten av trestrukturen
    // TODO: Lage egen klasse av roten?
    protected Result(){
        this.key = "root";
        this.data = "I am Root";
        this.parent = this;
    }


    public Result getByTag(String tag) {
        /**
         * Is used to get a child element with a key matching the provided tag, preferably cap sensetiv.
         * @param tag The tag that is supposed to match the elements key
         * @return The first element with a key that matches the tag
         */

        // Leter etter barnet med riktig tag
        for (Result child : this.children){
            if (child.key.equals(tag)){
                return child;
            }
        }
        // Leter en gang til hvis ikke funnet, men ser ikke på stor/liten bokstav
        for (Result child : this.children){
            if (child.key.equalsIgnoreCase(tag)){
                return child;
            }
        }
        throw new ArrayIndexOutOfBoundsException("Ingen barn med rett tag");
    }

    public Result getByPath(String[] tags){

        /**
         * Method for getting a element after following the path matching the provided keys.
         * @param tags An array consisting of the different tags to be searched for.
         * @return Returns the element that matches the path provided
         */
        Result temp = this;

        for (String tag : tags) {
            if (tag == null){
                continue;
            }
            temp = temp.getByTag(tag);
        }

        return temp;
    }
    public Result getByPath(String path){
        /**
         * Method for getting a element after following the path matching the provided keys.
         * @param tags A string of the path to be followed. The different keys in the path should be separated with / (slash)
         * @return Returns the element that matches the path provided
         */
        String[] tags = path.split("/");
        return getByPath(Arrays.copyOfRange(tags, 1, Integer.MAX_VALUE));
    }

    public Result getSelected(String tag) {
        return null;
    }

    public void setValue(String newValue){
        /**
         * Updates the value in the current element. This does not change the datafile
         * @param newValue The new value for the current element.
         */
        this.data = newValue;
    }

    public void setValue(String newValue, String pathInFile) {
        /**
         * Updates the value in the element matching the path. This does not change the datafile.
         * @param newValue The new value for the current element.
         * @param pathInFile The path to the element that is supposed to be updated. Each key in the path should be seperated by '/' (slash)
         */
        getByPath(pathInFile).setValue(newValue);
    }

    public void setValue(String newValue, long lineNumber){
        /**
         * Updates the value of the element that corresponds with the line number of the file provided
         * @param newValue The vale the element is supposed to have
         * @param LineNumber The number of the line in the file the element has.
         */
    }

    public String getPath() {
        /**
         * Method to get the path from the root node to the current element.
         * @return Returns a String representing the keys in the path. Each key is seperated by '/'
         */
        Stack<String> stack = new Stack<String>();
        String temp = "";
        Result current = this;

        // Lager en stack for å holde alle nøkkelverdier
        while (current != null){
            stack.add(current.key);
            current = current.parent;
            if (current.key.equals("root")){
                break;
            }
        }

        // Bygger opp path til der vi var
        while (!stack.isEmpty()){
            temp += "/" + stack.pop();
        }

        return temp;
    }

    public void append(String key, String value) {
        /**
         * Adds a new entry as a child of the current element. This updates the datasource as well, so all changes will be saved.
         * @param key The key of the new element.
         * @param value The value of the new element
         */
    }
    public void append(String key, String value, String pathInFile) {
        /**
         * Adds a new entry as a child of the current element. This updates the datasource as well, so all changes will be saved.
         * @param key The key of the new element.
         * @param value The value of the new element
         * @param pathInFile The path to the element from the current element that is supposed to be updated.
         */
    }
    public void append(String key, String value, long lineNumber){
        /**
         * Adds a new entry as a child of the current element. This updates the datasource as well, so all changes will be saved.
         * @param key The key of the new element.
         * @param value The value of the new element
         * @param lineNumber The linenumber of the parent elements position in the file
         */
    }

    @Override
    public String toString() {
        /**
         * Prints the current element. If its a parent it tells its number of children. If its a data element it tells its key and value.
         * @return Returns a string representing the element
         */
        if (this.data == null){
            return this.key + " has " + children.size() + " children";
        } else {
            return this.key + " : " + this.data;
        }
    }

    // tester mot henting av data i henhold til taggs
    public static void main(String[] args){
        Result root = new Result();

        root.add("fornavn","peter");

        root.print(root);

        System.out.println("\n\n");
        System.out.println(root.getByTag("fornavn").data);
    }

    // Rekursiv metode for å skrive ut data for tester
    protected void print(Result node){
        // Printer ut bare bare data i noden
        System.out.println(node.data);

        for (int i = 0; i < node.children.size(); i++){
            print(node.children.get(i));
        }
    }
    // Samme som over, men både nøkkel og data
    protected void print2(Result node){
        System.out.println(node);

        for (int i = 0; i < node.children.size(); i++){
            print2(node.children.get(i));
        }
    }
}