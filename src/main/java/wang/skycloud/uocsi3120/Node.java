package wang.skycloud.uocsi3120;

class SymbolTable {
    public static final int MAX_SYMBOLS = 100; // Assuming MAX_SYMBOLS is a constant value
    Symbol[] symbols;

    public SymbolTable() {
        this.symbols = new Symbol[MAX_SYMBOLS];
        for (int i = 0; i < MAX_SYMBOLS; i++) {
            this.symbols[i] = new Symbol();
        }
    }
}



public class Node {
    SymbolTable symbolTable;
    int count;
    Node next;

    /**
     * find the last node in list
     *
     * @return the last node in the linked list
     */
    private Node goCurrent(){
        Node node=this;
        while (node.next!=null){
            node=node.next;
        }
        return node;
    }

    public Node() {
        symbolTable = new SymbolTable();
        count = 0;
    }

    public Node pushScope() {
        //TODO: pushScope not implemented created at 2023/11/28 20:59
        throw new RuntimeException("pushScope not implemented");
    }

    public Node popScope() {
        //TODO: popScope not implemented created at 2023/11/28 20:59
        throw new RuntimeException("popScope not implemented");
    }

    public void printCurrentScope() {
        //TODO: printCurrentScope not implemented created at 2023/11/28 20:59
        throw new RuntimeException("printCurrentScope not implemented");
    }

    public void printAllScopes() {
        //TODO: printAllScopes not implemented created at 2023/11/28 20:59
        throw new RuntimeException("printAllScopes not implemented");
    }

    public void insertSymbol(String symbolType, String symbolName, String symbolValue) {
        //TODO: insertSymbol not implemented created at 2023/11/28 20:59
        throw new RuntimeException("insertSymbol not implemented");
    }

    public Symbol symbolExists(String name) {
        //TODO: symbolExists not implemented created at 2023/11/28 20:59
        throw new RuntimeException("symbolExists not implemented");
    }

    public Symbol symbolExistsInCurrent(String name) {
        //TODO: symbolExistsInCurrent not implemented created at 2023/11/28 20:59
        throw new RuntimeException("symbolExistsInCurrent not implemented");
    }

    public void freeEnvironment() {
        //TODO: freeEnvironment not implemented created at 2023/11/28 20:59
        throw new RuntimeException("freeEnvironment not implemented");
    }

}


