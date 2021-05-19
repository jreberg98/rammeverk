import java.util.ArrayList;

public final class Result {

    // Har protected for å lette få tak i variabler, men ikke mulig å bruke utenfor pakka
    protected String key, data;
    protected ArrayList<Result> children = new ArrayList<>();
    protected Result parent;

    protected void add(String key, String data){
        Result temp = new Result(key, data);
        children.add(temp);
    }

    protected void add(String key){
        Result temp = new Result(key);
        children.add(temp);
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

    public Result getSelected(String tag) {
        return null;
    }

    public void setValue(String new_value, String pathInFile) {
    }

    public void setValue(String newValue, long lineNumber){}

    public String getPath() {
        return null;
    }

    public void append(Object object) {
    }
    public void append(Object object, String pathInFile) {
    }
    public void append(Object object, long lineNumber){
    }

    // Setter riktig forelder til alle noder
    // Gjøres rekursivt
    private void setParents(Result node){
        for (int i = 0; i < node.children.size(); i++){
            node.children.get(i).parent = node;
            node.children.get(i).setParents(node.children.get(i));
        }
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
        Result root = new Result("root");

        root.add("fornavn","peter");

        root.setParents(root);
        root.print(root);

        System.out.println("\n\n");
        System.out.println(root.getByTag("fornavn").data);
    }

    // Rekursiv metode for å skrive ut data for tester
    public void print(Result node){
        System.out.println(node.data);

        for (int i = 0; i < node.children.size(); i++){
            print(node.children.get(i));
        }
    }
}