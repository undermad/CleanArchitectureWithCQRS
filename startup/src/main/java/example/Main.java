package example;

import org.springframework.beans.factory.annotation.Value;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {


        int[] arr = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 3, 4};

        List<Integer> a = List.of(1, 2 ,3,4,5,6,7);
        
        a.stream().mapToInt(Integer::intValue)
                .toArray();
        
        
    }
}
