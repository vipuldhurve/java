package dsa;

import java.util.*;

public class FlattenObjectArray {

    private static void flatten(Object[] array, List<Object> result){
        for(Object element: array){
            if(element instanceof Object[]){
//                recursively flatten the nested array
                flatten( (Object[]) element, result );
            } else{
//                Add the non-array element to the result list
                result.add(element);
            }
        }
    }

    public static void main(String[] args) {
        Object[] array = {1, 2,
                new Object[]{
                        3, 4,
                        new Object[]{5},
                        6, 7
                },
                8, 9, 10
        };
        List<Object> flattenedList = new ArrayList<>();
        flatten(array, flattenedList);
//        Convert the list to array if needed
        Object[] flattenedArray = flattenedList.toArray();

//        Print the flattened array
        for (Object obj: flattenedArray){
            System.out.print(obj +" ");
        }

    }
}
