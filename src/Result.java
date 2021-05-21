import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public final class Result {

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
        String[] tags = path.split("/");
        return getByPath(Arrays.copyOfRange(tags, 1, 100));
    }

    public Result getSelected(String tag) {
        return null;
    }

    public void setValue(String new_value, String pathInFile) {
    }

    public void setValue(String newValue, long lineNumber){}

    public String getPath() {
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

    public void append(Object object) {
    }
    public void append(Object object, String pathInFile) {
    }
    public void append(Object object, long lineNumber){
    }

    @Override
    public String toString() {
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