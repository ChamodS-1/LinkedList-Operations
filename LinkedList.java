public class LinkedList {

    Node head;
     public static class Node{
        int data;
        Node next;

         public Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public Node insertLast(int value){

        Node new_node = new Node(value);

        if(head == null){
            head = new_node;
        }else {
            Node last = head;

            while (last.next != null){
                last = last.next;
            }
            last.next = new_node;
        }
        return head;
    }

    public Node insertFirst(int value){

        Node new_node = new Node(value);
        new_node.next = head;
        head = new_node;

        return head;
    }

    public void deleteFirst(){

         if(head == null){
             throw new Error("linked list is empty!");
         }
         head = head.next;
    }

    public void deleteLast(){
        if(head == null){
            throw new Error("linked list is empty!");
        }

        Node last = head,pre = null;

        while (last.next != null){
            pre = last;
            last = last.next;
        }

        if(pre == null){
            head =head.next;
            return;
        }

        pre.next = null;
    }

    public int indexOf(int data){
         int count = -1;
         Node current = head;

         while (current != null){
             count++;
             if(current.data == data){
                 return count;
             }

             current = current.next;
         }

         return -1;
    }

    public void add(int index , int value){
        if(head == null){
            throw new Error("linked list is empty!");
        }

        if(index<1){
            throw new Error("Index must be 1 or greater than");
        }

        Node forward;

        int count = 0;
        Node new_node = new Node(value);
        Node current = head;

        while (current.next != null){
            count++;

            if(count == index){
                forward = current.next;
                current.next = new_node;
                new_node.next = forward;
            }

            current = current.next;
        }
    }

    public void delete(int index) {

        if (head == null) {
            throw new Error("linked list is empty!");
        }

        if(index<1){
            throw new Error("Index must be 1 or greater than");
        }

        if(index == 1){
            head = head.next;
            return;
        }

        Node forward;
        int count = 1;
        Node current = head,pre = null;

        while (current.next != null) {
            count++;
            current = current.next;
        }

       if(index<count){

           count = 0;
           Node currentnode = head,pree = null;

           while (currentnode.next != null) {
            count++;

            if (count == index-1) {
                pree = currentnode;
            }

            if (count == index) {
                forward = currentnode.next;
                pree.next = forward;
            }

               currentnode = currentnode.next;
        }

           if(pree == null){
               head =head.next;
           }

       }else {

           Node lastnode = head,pre2 = null;

           while (lastnode.next != null){
               pre2 = lastnode;
               lastnode = lastnode.next;
           }

           if(pre2 == null){
               head =head.next;
               return;
           }

           pre2.next = null;
       }
    }

    public int count(){
         int nodesCount = 1;

        if (head == null) {
            return 0;
        }

        Node current = head;

        while (current.next != null){
            nodesCount++;
            current = current.next;
        }

        return nodesCount;
    }

    public void display(){

        Node current = head;
        System.out.print("[ ");

        while (current !=null){

            if(current.next != null) {
                System.out.print(current.data + ", ");
            }else {
                System.out.print(current.data + " ");
            }
            current = current.next;
        }

        System.out.print("]");

    }
}
