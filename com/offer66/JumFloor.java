package com.offer66;

public class JumFloor {
 public int JumFloor(int target){
     if (target==1) {
         return 1;
     }
     if (target==2){
         return 2;
     }
     if (target>2){
         return JumFloor(target-1)+JumFloor(target-2);
     }
     return target;
 }
}
