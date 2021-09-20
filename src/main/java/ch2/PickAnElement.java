package ch2;

import java.util.List;

public class PickAnElement {

    public static void pickName(final List<String> names, final String startingLetter){

        String foundName = null;


        for (String name : names) {
            if(name.startsWith(startingLetter)){
                foundName = name;
                break;
            }
        }

        System.out.printf("A name starting with %s: ", startingLetter);

        if(foundName == null){
            System.out.println("No name found");
        }
        else{
            System.out.println(foundName);
        }

    }

}
