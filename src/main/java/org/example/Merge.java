package org.example;

public class Merge {
    public void run(int[] a){
        sort(a,1,a.length);
    }
    private void sort(int[] a,int p,int r){
        if (p<r){
            int q= (p + r) /2;
            sort(a,p,q);
            sort(a,q+1,r);
            merge(a,p,q,r);
        }
    }
    private void merge(int[] a,int p,int q,int r){
        int i=p-1,j=q,k=0;
        int[] mass = new int[r-p+1];
        while (i<q && j<r){
            if (a[i]<a[j]){
                mass[k]=a[i]; i++;
            }else{
                if (a[i]>=a[j]){
                    mass[k]=a[j]; j++;
                }
            }
            k++;
        }
        if (i<q) {
            for (j = i; j < q; j++) {
                mass[k] = a[j];
                k++;
            }
        }else{
            if (j<r) {
                for (i = j; i < r; i++) {
                    mass[k] = a[i];
                    k++;
                }
            }
        }
        j=p-1;
        for (i=0;i<mass.length;i++){
            a[j]=mass[i];j++;
        }
    }
}
