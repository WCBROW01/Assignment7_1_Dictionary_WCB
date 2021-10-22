import java.util.ArrayList;

/**
   A class of static, iterative methods for sorting an ArrayList of
   Comparable objects from smallest to largest.
   Adapted from SortArray class found in Data Structures and
   Abstractions with Java.
 
   @author Frank M. Carrano
   @author Timothy M. Henry
   @author Will Brown
   @version 5.0
*/
public class SortArrayList
{
   /** Sorts the first n objects in an ArrayList into ascending order.
       @param a  An ArrayList of Comparable objects.
       @param n  An integer > 0. */
   public static <T extends Comparable<? super T>>
          void selectionSort(ArrayList<T> a, int n)
   {
      for (int index = 0; index < n - 1; index++)
      {
         int indexOfNextSmallest = getIndexOfSmallest(a, index, n - 1);
         swap(a, index, indexOfNextSmallest);
         // Assertion: a[0] <= a[1] <= . . . <= a[index] <= all other a[i]
      } // end for
   } // end selectionSort
   
   // Finds the index of the smallest value in a portion of an ArrayList a.
   // Precondition: a.length > last >= first >= 0.
   // Returns the index of the smallest value among
   // a[first], a[first + 1], . . . , a[last].
   private static <T extends Comparable<? super T>>
           int getIndexOfSmallest(ArrayList<T> a, int first, int last)
   {
      T min = a.get(first);
      int indexOfMin = first;
      for (int index = first + 1; index <= last; index++)
      {
         if (a.get(index).compareTo(min) < 0)
         {
            min = a.get(index);
            indexOfMin = index;
         } // end if
         // Assertion: min is the smallest of a[first] through a[index].
      } // end for
      
      return indexOfMin;
   } // end getIndexOfSmallest

   // Swaps the ArrayList entries a[i] and a[j].
   private static <T extends Comparable<? super T>>
   		   void swap(ArrayList<T> a, int i, int j)
   {
      T temp = a.set(i, a.get(j));
      a.set(j, temp); 
   } // end swap
} // end SortArrayList
