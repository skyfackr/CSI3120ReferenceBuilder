package wang.skycloud.uocsi3120;

import static wang.skycloud.uocsi3120.SymbolTable.MAX_SYMBOLS;

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
    Node next,last;

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

    /**
     * @return true if this is the last node
     */
    private boolean isCurrent(){
        return this.next==null;
    }

    public Node() {
        symbolTable = new SymbolTable();
        count = 0;
    }

    public Node pushScope() {
        if (!isCurrent())
        {
            return this.goCurrent().pushScope();
        }
        Node node=new Node();
        this.next=node;
        node.last=this;
        return node;
    }

    public Node popScope() {
        if (!isCurrent())
        {
            return this.goCurrent().popScope();
        }
        if (this.last==null)//root scope cannot be poped
        {
            throw new RuntimeException("popScope error - root scope");
        }
        //simply cut of the link, this node will be considered as garbage and will be collected by GC
        this.last.next=null;
        this.last=null;
        return this;
    }

    public void printCurrentScope() {
        System.out.println("*****     -Scope List Start- Count:{"+count+"}     *****");
        for (int i = 0; i < count; i++) {
            System.out.println(symbolTable.symbols[i].toString());
        }
        System.out.println("*****     -Scope List End-     *****");
    }

    public void printAllScopes() {
        printAllInterval(0);
    }

    /**
     * for {@link #printAllScopes()} to calculate the depth of the scope
     *
     * @param level the level of the scope to be printed
     */
    private void printAllInterval(int level)
    {
        System.out.println("[Level "+level+"]");
        printCurrentScope();
        if (!isCurrent())
        {
            this.next.printAllInterval(level+1);
        }
    }

    public void insertSymbol(String symbolType, String symbolName, String symbolValue) {
        if (!isCurrent())
        {
            this.goCurrent().insertSymbol(symbolType,symbolName,symbolValue);
            return;
        }
        if (count>=MAX_SYMBOLS)
        {
            throw new RuntimeException("insertSymbol error - symbol table full");
        }
        //set the symbol
        symbolTable.symbols[count].type=symbolType;
        symbolTable.symbols[count].name=symbolName;
        symbolTable.symbols[count].value=symbolValue;
        count++;//set count as well as the next index of the symbol table
    }

    public Symbol symbolExists(String name) {
        Symbol ans=null;
        for (int i = 0; i < count; i++) {
            if (symbolTable.symbols[i].name.equals(name))
            {
                ans=symbolTable.symbols[i];
                break;
            }
        }
        Symbol after=null;
        if (!isCurrent())
        {
            after=this.next.symbolExists(name);
        }
        if (after!=null)// always use the most depth one
        {
            ans=after;
        }
        return ans;
    }

    public Symbol symbolExistsInCurrent(String name) {
        //just go to current scope and search
        return goCurrent().symbolExists(name);
    }

    public void freeEnvironment() {
        //delete next node link from the root and create new symbol table
        this.next=null;
        this.symbolTable=new SymbolTable();
        this.count=0;
    }

}


