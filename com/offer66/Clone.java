package com.offer66;

/**
 * （1），先复制单链表，再考虑特殊指针：每找一次特殊指针，
 * 从头遍历原链表一次（因为特殊指针有可能指向当前节点的前面节点）
 * ，通过比较顺序指针和特殊指针是否相等（为什么不比较值呢？因为链表中没说值不可以重复），
 * 记录顺序指针走的步数，同理在赋值链表中，走这么多步，找到谁，就把谁赋值给当前节点的特殊指针。
 *
 * 时间复杂度为O（n2）。
 *
 * （2），用map容器key-value思想，对每一个原链表的节点p，在复制后有p'，
 * 使（p，p'）形成键值对；这样在复制得到单链表后，就得到了一个map，
 * 然后扫描map每一个键值对（p,p')，找到p->random 键值对用（q，q'）表示，
 * 那么p'->random就等于q‘。
 *
 * （3），从头遍历链表，对每一个节点复制一个，插在它后边；接着遍历这个链表，
 * 那么原链表中节点的特殊指针若为空，则复制链表对应节点的特殊指针也为空，
 * 若源链表中结点的特殊指针不为空，那复制链表中对应节点的特殊指针为原链表中结点特殊指针的->next。

 *解题思路：
 *1、遍历链表，复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
 *2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
 *3、拆分链表，将链表拆分为原链表和复制后的链表
 */
 class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
public class Clone {
    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead == null) {
            return null;
        }

        RandomListNode currentNode = pHead;
        //1、复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
        while(currentNode != null){
            RandomListNode cloneNode = new RandomListNode(currentNode.label);
            RandomListNode nextNode = currentNode.next;
            currentNode.next = cloneNode;
            cloneNode.next = nextNode;
            currentNode = nextNode;
        }

        currentNode = pHead;
        //2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
        while(currentNode != null) {
            currentNode.next.random = currentNode.random==null?null:currentNode.random.next;
            currentNode = currentNode.next.next;
        }

        //3、拆分链表，将链表拆分为原链表和复制后的链表
        currentNode = pHead;
        RandomListNode pCloneHead = pHead.next;
        while(currentNode != null) {
            RandomListNode cloneNode = currentNode.next;
            currentNode.next = cloneNode.next;
            cloneNode.next = cloneNode.next==null?null:cloneNode.next.next;
            currentNode = currentNode.next;
        }

        return pCloneHead;
    }
}
