import java.util.ArrayList;

public final class Result {

    // Har protected for å lette få tak i variabler, men ikke mulig å bruke utenfor pakka
    protected String data;
    protected ArrayList<Result> children = new ArrayList<>();
    protected Result parent;

    protected void add(String child){
        Result temp = new Result(child);
        children.add(temp);
    }

    // Returnerer det nyeste elementet som er lagt til
    public Result lastChild() {
        if (children.isEmpty()){
            throw new ArrayIndexOutOfBoundsException("Does not contain any children");
        }
        return children.get(children.size() - 1);
    }

    public Result(String data) {
        this.data = data;
    }

    public Result getByTag(String planetsystemet) {
        return null;
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


    // Under her er bare for å teste om noe fungerer
    // TODO: Fjerne dette når det virker
    public static void main(String[] args){
        Result root = new Result("root");

        root.add("Strom");
        root.add("Kristian");
        root.lastChild().add("Ruud");

        root.setParents(root);
        root.print(root);
    }

    // Rekursiv metode for å skrive ut data
    protected void print(Result node){
        System.out.println(node.data);

        for (int i = 0; i < node.children.size(); i++){
            print(node.children.get(i));
        }
    }
}
