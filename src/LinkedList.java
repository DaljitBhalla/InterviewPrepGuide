import sun.awt.image.ImageWatched;
import sun.jvm.hotspot.debugger.posix.elf.ELFSectionHeader;

import javax.xml.soap.Node;

class LinkedListNode {

    private  int val;
    private LinkedListNode next;

    public int getVal() {
        return val;
    }
    public void setVal(int val ){ this.val = val; }

    public LinkedListNode getNext() {
        return next;
    }

    public void setNext(LinkedListNode next)
    {
        this.next = next;
    }

    public LinkedListNode(int val) {
        this.val = val;
        this.next= null;
    }

}

    public class LinkedList {

     LinkedListNode head;

        public LinkedListNode getHead() {
            return head;
        }

        public LinkedList(LinkedListNode node)
        {
            this.head = node;
        }

        public static void main(String args[])
        {
            LinkedListNode node  = new LinkedListNode(1);
            LinkedListNode node2 = new LinkedListNode(1) ;
            LinkedListNode node3 = new LinkedListNode(2) ;
            LinkedListNode node4 = new LinkedListNode(2) ;
            LinkedListNode node5 = new LinkedListNode(3) ;
            LinkedListNode node6 = new LinkedListNode(3) ;
            LinkedListNode node7 = new LinkedListNode(4) ;


            node.setNext(node2) ;
            node2.setNext(node3);
            node3.setNext(node4);
            node4.setNext(node5);
            node5.setNext(node6);
            node6.setNext(node7);

            LinkedList head = new LinkedList(node);
            head.printList();

            System.out.println("\nUpdated list is\n");

           LinkedList.printList(  head.deleteDuplicateNodes2( ));
        }

        private void printList()
        {
            System.out.println("Printing the linked list");
             LinkedListNode node =  head;
             while(node != null )
             {
                 System.out.print(node.getVal() + " ");
                 node = node.getNext();
             }
             System.out.println();
        }

        private static void printList(LinkedListNode NODE)
        {
            System.out.println("Printing the linked list");
            LinkedListNode node =  NODE;
            while(node != null )
            {
                System.out.print(node.getVal() + " ");
                node = node.getNext();
            }
            System.out.println();
        }


        private int getDecimalValue( )
        {
            /*  Inside this list we have a decimal number represented as binary stored in the linked list.
                    and the linked list is not empty and every node will store only zero(0) or one (1)
             */
            LinkedListNode node = head ;
            int val = 0 ;
            if( head == null )
                return -1;


            while(node != null )
            {
                val = (val << 1 )  | node.getVal();
                node = node.getNext();
            }
               return val;
        }

        private LinkedListNode middleNode()
        {
            /*
              Method of finding the middle of a linked list : Traverse linked list using two pointers. Move one pointer by one and the other pointers by two.
                When the fast pointer reaches the end slow pointer will reach the middle of the linked list.
                */

            LinkedListNode  slow_ptr , fast_ptr ;

            if(head == null )
                return  null ;

            slow_ptr = fast_ptr =head;
            int INDEX = 1 ;

            while(fast_ptr != null && fast_ptr.getNext() != null )
            {
             /* Increment fast_ptr */
                    fast_ptr = fast_ptr.getNext().getNext(); // this part needs to be checked

                /*Increment slow_ptr */
                slow_ptr = slow_ptr.getNext();

                INDEX += 2;
            }


            System.out.println("MEDIAN VALUE IS  " + slow_ptr.getVal());

            if(  INDEX > 1 && INDEX %2 == 0 )
                slow_ptr = slow_ptr.getNext();

            return  slow_ptr;
        }

        private static LinkedListNode deleteNode(LinkedListNode node)
        {

            node.setVal(node.getNext().getVal());
            LinkedListNode next2 = node.getNext().getNext();

           LinkedListNode next =  node.getNext() ;
           node.setNext(next2);

           next = null;
           System.gc();

            return node;
        }

        private static void deleteDuplicateNodes(LinkedListNode head)
        {
            /* Iterate over the sorted list whenever you find duplicate -- delete nodes **/
            LinkedListNode NODE = head;

            if(head == null )
                return ;

            while (NODE != null && NODE.getNext() != null ) // traverse till the end of the linked list
            {
                if (NODE.getVal() == NODE.getNext().getVal())
                    deleteNode(NODE);
                else
                NODE = NODE.getNext();
            }
        }

        private   LinkedListNode deleteDuplicateNodes2( )
        {
            /* This method removes all instances of nodes with duplicate instances */

            LinkedListNode dummyHead = new LinkedListNode(-1);

            dummyHead.setNext(head);

            LinkedListNode prev, curr ;

            prev = dummyHead;

            curr = head;

            while(curr != null ) // Iterate over the sorted linked list
            {

                /* Remove all instanes of duplicate nodes */

                while( curr.getNext() != null && prev.getNext().getVal() == curr.getNext().getVal())
                    curr = curr.getNext();

                /* Below logic is for resetting the curr and prev pointer positions respectively */

                if( prev.getNext() == curr) // no updation ( we can avoid using boolean flag to check if there are any duplicates in current iteration with the help of this)
                    prev = prev. getNext();
                else
                    prev.setNext( curr.getNext());

                curr = curr.getNext();
            }

            return dummyHead.getNext();
        }
    }




