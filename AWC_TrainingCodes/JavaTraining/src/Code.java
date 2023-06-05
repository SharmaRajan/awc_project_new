import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Code {

    public void sort(int[] arr){
        SortedMap<Integer, Integer> map = new TreeMap();
        for(int x : arr) {
            map.put(x, map.getOrDefault(x, 0)+1);

        }
    }



    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter no of Animals: ");
        int noOfAnimals = input.nextInt();
        System.out.println("Enter no of animals to be saved: ");
        int xCapacity = input.nextInt();

        int[] energyLevels = new int[noOfAnimals];
        System.out.println("Energylevel length: " + energyLevels.length);
        for(int i = 0; i < energyLevels.length; i++){
            System.out.print("Index: "+ i + " ");
            energyLevels[i] = input.nextInt();
        }

        int minLevelAnimal = energyLevels[xCapacity];

        /*System.out.println("Energy level: ");
        for(int i = 0; i < energyLevels.length; i++){
            System.out.print(energyLevels[i] + " ");
        }

        System.out.println();

        int[] sortedArr = sortArrayDesc(energyLevels);
        for(int i = 0; i < sortedArr.length; i++){
            System.out.print(sortedArr[i] + " ");
        }*/

    }

    private static int[] sortArrayDesc(int[] arr){
        int temp;
         for(int i = 0; i < arr.length; i++){
             for(int j = i; j < arr.length; j++){
                 if(arr[i] < arr[j]){
                     temp = arr[j];
                     arr[j] = arr[i];
                     arr[i] = temp;
                 }
             }
         }
         return arr;
    }


}
