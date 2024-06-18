package example;

import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {
        
        if(test().join()) {
            System.out.println("Abc");
        }

        System.out.println("Should be after abc");
        
        while (true) {
        
        }
    }
    
    public static CompletableFuture<Boolean> test() {
        return CompletableFuture.supplyAsync(() -> true);
    }
    
}
