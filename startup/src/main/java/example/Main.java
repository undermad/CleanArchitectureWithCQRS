package example;

import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {
        
        abc abc = new Aaa() {};

        abc aa = new asd();
        
        System.out.println(aa.getClass().getName());
        
        
        
    }    
}

class asd implements abc {
    
}

interface abc{}

interface Aaa extends abc {}

interface Bbb extends abc {}
