package Projects;

import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;
class Main{

   public static int[] CmpDISKAlgorithmProject(int[] arr, int index)
{
  

if (arr == null || index < 0 || index >= arr.length) {
return arr;
}
  

int[] Array = new int[arr.length - 1];
  

for (int i = 0, j = 0; i < arr.length; i++) {

if (i == index) {
continue;
}
  

Array[j++] = arr[i];
}
 
return Array;
}

   int FCFS(int[] arr, int size){
       int totalmovements=0;
       for (int i=0;i<size-1;i++){
           totalmovements+=Math.abs(arr[i]-arr[i+1]);
       }
       return totalmovements;
   }
   int SSTF(int[] arr, int size, int firstNum){
       int[] temparr=new int[size]; 
       for (int i=0;i<size ;i++ ) { 
           temparr[i]=arr[i];
       }
       int totalmovements=0;
       int totalNumber=0;
       Arrays.sort(temparr); 
       int index=0;
       for (int i=0;i<size ;i++ ) {
           if (temparr[i]==firstNum) {
               index=i;
               break;
           }
       }

       while (totalNumber<size) {
           if (index>0 && index<size-totalNumber-1) {
             
               int leftDiff=Math.abs(temparr[index]-temparr[index-1]);
         
               int rightDiff=Math.abs(temparr[index]-temparr[index+1]);
               
               if (leftDiff<rightDiff) {
                   totalNumber++;
                   totalmovements+=Math.abs(temparr[index]-temparr[index-1]);
                  
                   temparr=CmpDISKAlgorithmProject(temparr, index);
               
                   index--;
               }
               else { 
                   totalNumber++;
                   totalmovements+=Math.abs(temparr[index]-temparr[index+1]);
                   temparr=CmpDISKAlgorithmProject(temparr ,index);
               }
           }
           else if(index>0 && index<=size-totalNumber-1){
               totalNumber++;
               totalmovements+=Math.abs(temparr[index]-temparr[index-1]);
           
               temparr=CmpDISKAlgorithmProject(temparr ,index);
               index--;
           }
           else if(index>=0 && index<size-totalNumber-1){
               totalNumber++;
               totalmovements+=Math.abs(temparr[index]-temparr[index+1]);
            
               temparr=CmpDISKAlgorithmProject(temparr ,index);
           }
           if (totalNumber==size-1) {
        	   CmpDISKAlgorithmProject(temparr, index);
               totalNumber++;
           }
       }
       return totalmovements;

   }
  
   int SCAN(int[] arr, int size, int firstNum){
       int totalmovements=0;
       Arrays.sort(arr);
       int index=0;
       for (int i=0;i<size ;i++ ) {
           if (arr[i]==firstNum) {
               index=i;
               break;
           }
       }
       if (index==0 || index==size-1) {
           return arr[size-1]-arr[0];
       }
       totalmovements+=arr[size-1]-arr[index];
       totalmovements+=arr[size-1]-arr[0];
       totalmovements+=arr[index-1]-arr[0];
       return totalmovements;
   }

   public static void main(String[] args) {
       int[] arr=new int[1000];
       Random rand = new Random(); 
       for (int i=0;i<arr.length;i++) {
           
           arr[i]=rand.nextInt(5000);
       }
       int firstNum=arr[0];

       Main m=new Main();
       System.out.print(" FCFS= ");
       System.out.println(m.FCFS(arr,arr.length));
       System.out.print(" SSTF= ");
       System.out.println(m.SSTF(arr,arr.length,firstNum));
       System.out.print("SCAN= ");
       System.out.println(m.SCAN(arr,arr.length,firstNum));
   }
}