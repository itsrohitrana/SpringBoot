package com.spring.start.z_startup;

public class Controller {
	static int insert(int k, int index, int ar[]) {
		if (index >= ar.length) {
			System.out.println(index);
			return -1;
		}
		ar[index] = k;
		return 1;

	}

	static int serch(int k, int ar[]) {
		if (ar.length == 0) {
			return -1;
		}
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] == k) {
				return i;
			}
		}
		return -1;
	}

	static int update(int key, int index, int ar[]) {
		if (serch(key, ar) > 1) {
			ar[index] = key;
			return 1;
		}
		return -1;
	}

	static int delete(int key, int ar[]) {
		int length = ar.length;
		if (serch(key, ar) > 1) {
			for (int i = serch(key, ar); i < length - 1; i++) {
				ar[i] = ar[i + 1];

			}
			return length - 1;
		}
		return -1;
	}

	static int[] merge(int a1[], int a2[], int n) {
		int a[] = new int[n];
		int index = 0;
		for (int i = 0; i < n; i++) {
			if (i < a1.length) {
				a[i] = a1[i];
			} else {
				a[i] = a2[index];
				index++;
			}
		}
		return a;
	}

	public static void main(String[] args) {
		System.out.println();
	}

	static int findElement(int arr[], int n, int key) {
		int i;
		for (i = 0; i < n; i++)
			if (arr[i] == key)
				return i;

		return -1;
	}

	static int deleteElement(int arr[], int n, int key) {
		int pos = findElement(arr, n, key);

		if (pos == -1) {
			System.out.println("Element not found");
			return n;
		}

		int i;
		for (i = pos; i < n - 1; i++)
			arr[i] = arr[i + 1];

		return n - 1;
	}
	
	  // function to calculate median 
    static int getMedian(int ar1[], int ar2[], int n) 
    {    
        int i = 0;   
        int j = 0;  
        int count; 
        int m1 = -1, m2 = -1; 
       
        /* Since there are 2n elements, median will  
           be average of elements at index n-1 and  
           n in the array obtained after merging ar1  
           and ar2 */
        for (count = 0; count <= n; count++) 
        { 
            /* Below is to handle case where all  
              elements of ar1[] are smaller than  
              smallest(or first) element of ar2[] */
            if (i == n) 
            { 
                m1 = m2; 
                m2 = ar2[0]; 
                break; 
            } 
       
            /* Below is to handle case where all  
               elements of ar2[] are smaller than  
               smallest(or first) element of ar1[] */
            else if (j == n) 
            { 
                m1 = m2; 
                m2 = ar1[0]; 
                break; 
            } 
       
            if (ar1[i] < ar2[j]) 
            {    
                /* Store the prev median */
                m1 = m2;   
                m2 = ar1[i]; 
                i++; 
            } 
            else
            { 
                /* Store the prev median */
                m1 = m2;   
                m2 = ar2[j]; 
                j++; 
            } 
        } 
       
        return (m1 + m2)/2; 
    } 

}
