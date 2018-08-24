package com.offer66;

/**
 这是一个可以用回朔法解决的典型题。首先，在矩阵中任选一个格子作为路径的起点。如果路径上的第i个字符不是ch，那么这个格子不可能处在路径上的
 第i个位置。如果路径上的第i个字符正好是ch，那么往相邻的格子寻找路径上的第i+1个字符。除在矩阵边界上的格子之外，其他格子都有4个相邻的格子。
 重复这个过程直到路径上的所有字符都在矩阵中找到相应的位置。
 　　由于回朔法的递归特性，路径可以被开成一个栈。当在矩阵中定位了路径中前n个字符的位置之后，在与第n个字符对应的格子的周围都没有找到第n+1个
 字符，这个时候只要在路径上回到第n-1个字符，重新定位第n个字符。
 　　由于路径不能重复进入矩阵的格子，还需要定义和字符矩阵大小一样的布尔值矩阵，用来标识路径是否已经进入每个格子。 当矩阵中坐标为（row,col）的
 格子和路径字符串中相应的字符一样时，从4个相邻的格子(row,col-1),(row-1,col),(row,col+1)以及(row+1,col)中去定位路径字符串中下一个字符
 如果4个相邻的格子都没有匹配字符串中下一个的字符，表明当前路径字符串中字符在矩阵中的定位不正确，我们需要回到前一个，然后重新定位。
 　　一直重复这个过程，直到路径字符串上所有字符都在矩阵中找到合适的位置
 */
public class Solution2 {
    /**
     * 在矩阵matrix中查找是否存在连续字符串路径str
     * @param matrix 矩阵字符数组
     * @param rows 矩阵行数
     * @param cols 矩阵列数
     * @param str 待查找字符串路径
     * @return 存在返回true 不存在返回false
     */
    public boolean hasPath(char[] matrix,int rows,int cols,char[] str){
        if(matrix == null || rows < 1 || cols < 1 || str == null){//参数校验
            return false;
        }
        boolean[] visit = new boolean[rows*cols];//标记访问过的矩阵坐标位置，初始化为false
        for(int i = 0; i < rows; i ++){
            for(int j = 0 ;j < cols; j ++){
                if(hasPathCore(matrix,rows,cols,i,j,str,0,visit)){
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * 回溯法匹配字符串路径
     * @param matrix 矩阵字符数组
     * @param rows 矩阵行数
     * @param cols 矩阵列数
     * @param row 当前匹配矩阵元素的行坐标
     * @param col 当前匹配矩阵元素的列坐标
     * @param str 匹配字符串
     * @param current 当前匹配字符串元素的下标
     * @param visit 标记匹配过的矩阵元素位置
     * @return
     */
    private boolean hasPathCore(char[] matrix, int rows, int cols, int row,int col, char[] str, int current, boolean[] visit) {
        int index = row*cols + col;
        if(row >= rows || col >= cols || row < 0 || col < 0 || visit[index] || matrix[index] != str[current]){
            return false;
        }
        visit[index] = true;//当前k下标的字符匹配成功
        if(current == str.length-1){
            return true;
        }
        current ++;//准备匹配下一个字符
        if(hasPathCore(matrix, rows, cols, row-1, col, str, current, visit)||//试探当前字符的上方字符
                hasPathCore(matrix, rows, cols, row+1, col, str, current, visit)||//试探当前字符的下方字符
                hasPathCore(matrix, rows, cols, row, col-1, str, current, visit)||//试探当前字符的左方字符
                hasPathCore(matrix, rows, cols, row, col+1, str, current, visit)//试探当前字符的右方字符
        ){
            return true;
        }
        current --;//如果四个方向的都不对，表明上一个字符匹配不对，回退
        visit[index] = false;
        return false;
    }
    public static void main(String[] args) {
        char[] matrix = {'a','b','c','e',
                's','f','c','s',
                'a','d','e','e'};
        String str = "abceseecfdas";
        Solution2 offer_66 = new Solution2();
        System.out.println(offer_66.hasPath(matrix, 3, 4, str.toCharArray()));
    }
}