package map;

import java.util.Scanner;

public class Main {

    static void bubbleSort(int arr[], int n)
    {
        if (n == 1)
        {
            return;
        }

        for (int i=0; i<n-1; i++)
        {
            if (arr[i] > arr[i+1])
            {
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }

        bubbleSort(arr, n-1);           //one pass done, proceed to the next
    }

    public static void main(String[] args) {
        //folosesc un obiect de clasa Scanner pentru a citi de pe tastatura lungimea array-ului
	    Scanner console = new Scanner(System.in);
        System.out.println("Bitte die Lange des Arrays einfugen: ");
        //creare arr + calcularea simultana a max si min pt eficienta
        int n=console.nextInt();
        int[] arr = new int[n];
        int max = -Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            arr[i] = console.nextInt();
            if(arr[i] > max) max=arr[i];
            if(arr[i] < min) min=arr[i];
        }
        int[] sorted_arr = arr;
        //pentru a putea calcula cat mai usor suma intre n-1 elemente ale array-ului fara a avea doua for-uri una in alta
        //am sortat intr-o functie de tip bubble sort array-ul de la mic la mare
        bubbleSort(sorted_arr, n);
        int sum_min = 0;
        int sum_max = 0;
        int anz = 0;
        for(int i=0; i<n && anz < n-1; i++){
            sum_max += sorted_arr[n-1-i];
            sum_min += sorted_arr[i];
            anz++;
        }
        System.out.println(max);
        System.out.println(min);
        System.out.println(sum_max);
        System.out.println(sum_min);
    }
}
