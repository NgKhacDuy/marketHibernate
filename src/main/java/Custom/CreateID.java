/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Custom;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class CreateID {
    private int ID;

    public CreateID() {
    }
    
    public int createID(int[] list){
        mergeSort(list, new int[list.length], 0, list.length-1);
        ID = (int)list[0];
        return ID+1;
    }

    
    public int getID() {
        return ID+1;
    }
    
    void merging(int[] arr,int[] temp, int low, int mid, int high) {
        int l1, l2, i;
 
        l1 = low;
        l2 = mid + 1;
        for (i = low; l1 <= mid && l2 <= high; i++) {
            if (arr[l1] >= arr[l2]) {
                temp[i] = arr[l1++];
            } else {
                temp[i]=arr[l2++];
            }
        }
 
        while (l1 <= mid) {
            temp[i++]=arr[l1++];
        }
        while (l2 <= high) {
            temp[i++]=arr[l2++];
        }
        for (i = low; i <= high; i++) {
            arr[i]=temp[i];
        }
    }
 
    void mergeSort(int[] arr, int[] temp, int low, int high) {
        int mid;
 
        if (low < high) {
            mid = (low + high) / 2;
            mergeSort(arr, temp, low, mid);
            mergeSort(arr, temp, mid + 1, high);
            merging(arr, temp, low, mid, high);
        } else {
            return;
        }
    }
    
//    public static void main(String[] args) {
//
//        
//        int[] list = {2,3,4,5,6,7,8,9,10,456};
//        
//        
//        CreateID c = new CreateID();
//        c.createID(list);
//        System.out.println(c.getID());
//    }

}
