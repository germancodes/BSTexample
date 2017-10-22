/*
 * CSCI 3343 Analysis of Algorithms Spring 2017
 * Binary Search Tree Implementation
 */

package bst;

import java.util.Scanner;
import java.util.Random;
/**
 * German Candelaria
 * CSCI-3343
 * 03/25/2017
 * Assignment 5
 */
public class BSTMain {

    public static void main(String[] args) {
       //Initializing class variables
       BST bTree = new BST();
       int[] arryTree = new int[20];
       int intNumToBeSearched, intSuccessfulSearches, intFailedSearches;
       int intCurrentBSTIterations, intTotalBSTIterations;
       int intCurrentArryIterations, intTotlatArryIterations;
       boolean boolExit = false;
       boolean boolNumFound;
       Scanner scan = new Scanner(System.in);
       Random rand = new Random();
       
       //Inputting 20 random number between 0 and 100
       int intCurrentRandNumber;
       for(int x = 0; x < 20; x++){
           //Generating random number
           intCurrentRandNumber = rand.nextInt(101);
           //Inputting random number to Array
           arryTree[x] = intCurrentRandNumber;
           //Inputting random number to Binary Seach Tree
           bTree.insert(intCurrentRandNumber);
       }
       //Initializing total variables
       intTotalBSTIterations = 0;
       intTotlatArryIterations = 0;
       intSuccessfulSearches = 0;
       intFailedSearches = 0;
       do{
           //Initializing iteration specific variables
           intCurrentArryIterations = 0;
           boolNumFound = false;
           int y = 0;
           //Grabbing value to be searched from user
           System.out.println("Enter a number to be searched in the BST and in the Array: (0-100) (Enter '-1' to quit)");
           intNumToBeSearched = scan.nextInt();
           //Checking if user wishes to quit
           if(intNumToBeSearched == -1){
                boolExit = true;
           } else if (intNumToBeSearched > 100 || intNumToBeSearched < 0){
               System.err.println("Please enter a number within 0 and 100");
           } else {
                //Searching through BST
                bTree.search(bTree.root, intNumToBeSearched);
                //Getting the total number of iteration that it took to find number
                intCurrentBSTIterations = bTree.getSearchIterations();
                //Keeping count of total number of iterations for BST
                intTotalBSTIterations = intTotalBSTIterations + intCurrentBSTIterations;
                //Searching through BST
                do{
                    if (y < 20){
                        if (arryTree[y] == intNumToBeSearched) {
                            intCurrentArryIterations++;
                            intSuccessfulSearches++;
                            boolNumFound = true;
                        } else {
                            intCurrentArryIterations++;
                            y++;
                        }
                    } else {
                        intFailedSearches++;
                        break;
                    }
                } while (!boolNumFound);
                //Keeping count of total number of iteration for Array
                intTotlatArryIterations = intTotlatArryIterations + intCurrentArryIterations;
                //Displaying the number of iteration that it took to find the item (if found)
                if(boolNumFound){
                    System.out.println("Number was successfully found!");
                } else {
                    System.out.println("Number was NOT found!");
                }
                //Print results of the current search
                System.out.println("Type\tIterations\nBST\t" + intCurrentBSTIterations + 
                                   "\nArray\t" + intCurrentArryIterations);
           }
       } while(!boolExit);
       //Displaying final results
       System.out.println("==Final Results==\nTotal Queries:\t" + (intSuccessfulSearches + intFailedSearches) + 
                          "\nSuccesful Queries:\t" + intSuccessfulSearches + "\nFailed Queries:\t" + intFailedSearches + 
                          "\n=============");
       System.out.println("Type\tAvg Num of Iterations\nBST\t" + ((double)intTotalBSTIterations / (double)(intSuccessfulSearches + intFailedSearches)) + 
                          "\nArray\t" + ((double)intTotlatArryIterations / (double)(intSuccessfulSearches + intFailedSearches)));
    }
    
}
