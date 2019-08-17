package com.bobohe;

/**
 * @author blackcat
 * @Description:用归并排序算逆序对的个数   打印日志  debug 调试递归助于理解
 * @create 2019-08-17 9:41
 */
public class MergeSortCount {

    private int num = 0;

    public int count(int[] a, int n){
        num = 0;
        mergeSortCounting(a,0,n-1);
        return num;
    }

    private void mergeSortCounting(int[] a,int low, int max){
        if (low>=max){
            return;
        }
        int middle = (low + max)/2;
        mergeSortCounting(a,low,middle);
        mergeSortCounting(a,middle+1,max);
        merge(a,low,middle,max);
    }

    private void merge(int[] a, int low, int middle, int max) {
        int i = low;
        int j = middle + 1;
        int k = 0;
        int[] tmp = new int[max - low + 1];
        while (i<=middle && j<=max){
            if (a[i] <= a[j]){
                tmp[k++] = a[i++];
            }else {
                num += middle- i + 1;//统计low到middle中间，比a[j]大的元素个数
                tmp[k++] = a[j++];
            }
        }
        while(i <= middle){ //处理剩下的
            tmp[k++] = a[i++];
        }
        while (j<=max){ //处理剩下的
            tmp[k++] = a[j++];
        }
        for (i=0;i<=max-low;++i){ //从tmp拷贝回a
            a[low+i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        MergeSortCount mergeSortCount = new MergeSortCount();
        int[] a = {6,5,4,3,2,0,1,7};
        System.out.println(mergeSortCount.count(a,a.length));
    }

}
