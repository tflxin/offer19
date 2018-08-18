package com.offer66;

public class JumpFloorI {
 public int JumpFloorI(int target){
     if (target <=0){
         return -1;
     }
     if (target==1){
         return 1;
     } else{
         return 2*JumpFloorI(target-1);
     }
 }
}
