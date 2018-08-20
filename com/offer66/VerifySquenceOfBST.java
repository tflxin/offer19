package com.offer66;

public class VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length==0)return false;
        if(sequence.length==1) return true;
        return VerifySquenceOfBST(sequence,0,sequence.length-1);
    }
    private boolean VerifySquenceOfBST(int[] sequence, int start, int end){
        if(start>=end)
            return true;
        //找到根节点的左子节点小于跟节点
        int i = start;
        while (i<end){
            if(sequence[i]>sequence[end])
                break;
            i++;
        }
        //找到右子节点大于跟节点
        int j = i;
        while (j++<end){
            if(sequence[j]<sequence[end])
                return false;
        }
        return VerifySquenceOfBST(sequence, start, i-1)&&VerifySquenceOfBST(sequence, i, end-1);
    }

    public void main(String[] args){
        int[] sequeue={1,2, 7,8, 10,11,45 , 3,9};
        System.out.println(sequeue);
        System.out.println(VerifySquenceOfBST(sequeue,0,sequeue.length-1));
    }
}