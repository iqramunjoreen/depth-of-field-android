package com.example.myapplication;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//



import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ALensManager implements Iterable<ALens> {
    private List<ALens> lenses = new ArrayList();



    public Iterator<ALens> iterator() {
        return this.lenses.iterator();
    }

    public void add(ALens lens) {
        this.lenses.add(lens);
    }
    public void delete(ALens lens){ this.lenses.remove(lens);}
    private static ALensManager instance;
    private  ALensManager(){};
    public static ALensManager getInstance(){
        if(instance==null){
            instance=new ALensManager();
            instance.add(new ALens("Cannon",1.50,50));
            instance.add(new ALens("Tamron",2.8,90));
            instance.add(new ALens("Sigma",2.8,200));
            instance.add(new ALens("Nikkon",4.0,200));
        }
        return instance;

    }


    public static void printLens(List<ALens> lenses) {
        for(int i = 0; i < lenses.size(); ++i) {
            System.out.println("Lense" + i + lenses.get(i));
        }

    }

    public void getbyindex(int n) {
        PrintStream var10000 = System.out;
        Object var10001 = this.lenses.get(n);
        var10000.println("Specific Lens is" + var10001);
    }

    public ALens getobjbyindex(int n) {
        return (ALens)this.lenses.get(n);
    }

    public int getlistsize() {
        int count = 0;

        for(Iterator var2 = this.lenses.iterator(); var2.hasNext(); ++count) {
            ALens lenses55 = (ALens)var2.next();
        }

        return count;
    }
}

