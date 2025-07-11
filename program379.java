///////////////////////////////////////////////////////
//
//  File name :     program379.java
//  Descreption :   Doubly Linear LinkedList 
//  Author :        Diksha Anil Chavan
//  Date :          07/07/2025
//
///////////////////////////////////////////////////////
/// 
class node 
{
    public int data;
    public node next;
    public node prev;
}

class DoublyLLL
{
    private node first;
    private int iCount;

    public DoublyLLL()
    {
        first = null;
        iCount = 0;
    }

    public void InsertFirst(int no)
    {
        node newn = null;

        newn = new node();

        newn.data = no;
        newn.next = null;
        newn.prev = null;

        if((first == null))   // LL is empty
        {
            first = newn;
        }
        else    // LL contains atleast one node
        {
            newn.next = first;
            first.prev = newn;

            first = newn;
        }
        iCount++;
    }

    public void InsertLast(int no)
    {
        node newn = null;
        node temp = null;

        newn = new node();

        newn.data = no;
        newn.next = null;
        newn.prev = null;

        if((first == null))   // LL is empty
        {
            first = newn;
        }
        else    // LL contains atleast one node
        {
            temp = first;

            while(temp.next != null)
            {
                temp = temp.next;
            }

            newn.prev = temp;
            temp.next = newn;
        }
        iCount++;
    }

    public void InsertAtPos(int no, int Pos)
    {
        node newn = null;
        node temp = null;
        int iCnt = 0;

        if(Pos < 1 || Pos > iCount+1)
        {
            System.out.println("Invalid Position");
            return;
        }
        
        if(Pos == 1)
        {
            InsertFirst(no);
        }
        else if(Pos == iCount+1)
        {
            InsertLast(no);
        }
        else
        {
            newn = new node();

            newn.data = no;
            newn.next = null;
            newn.prev = null;

            temp = first;

            for(iCnt = 1; iCnt < Pos-1; iCnt++)
            {
                temp = temp.next;
            }

            newn.next = temp.next;
            newn.next.prev = newn;
            temp.next = newn;
            newn.prev = temp;

            iCount++;
        }
    }

    public void DeleteFirst()
    {
        if(first == null)
        {
            return;
        }
        else if(first.next == null)
        {
            first = null;
        }
        else
        {
            first = first.next;
            first.prev = null;
        }
        iCount--;
    }

    public void DeleteLast()
    {
        node temp = null;

        if(first == null)
        {
            return;
        }
        else if(first.next == null)
        {
            first = null;
        }
        else
        {
            temp = first;

            while(temp.next != null)
            {
                temp = temp.next;
            }

            temp.prev.next = null;
        }
        iCount--;
    }

    public void DeleteAtPos(int Pos)
    {
        node newn = null;
        node temp = null;
        int iCnt = 0;

        if(Pos < 1 || Pos > iCount)
        {
            System.out.println("Invalid Position");
            return;
        }
        
        if(Pos == 1)
        {
            DeleteFirst();
        }
        else if(Pos == iCount)
        {
            DeleteLast();
        }
        else
        {
            temp = first;

            for(iCnt = 1; iCnt < Pos-1; iCnt++)
            {
                temp = temp.next;
            }

            temp.next = temp.next.next;

            iCount--;
        }   
    }

    public void Display()
    {
        node temp = null;

        if(first == null)
        {
            return;
        }

        temp = first;

        while(temp != null)
        {
            System.out.print("| "+temp.data+" | <=>" );
            temp = temp.next;
        }
        System.out.println("null");
    }

    public int Count()
    {
        return iCount;
    }
}

class program379
{
    public static void main(String A[])
    {
        DoublyLLL sobj = new DoublyLLL();
        int iRet = 0;

        sobj.InsertFirst(51);
        sobj.InsertFirst(21);
        sobj.InsertFirst(11);

        sobj.InsertLast(101);
        sobj.InsertLast(111);
        sobj.InsertLast(121);

        sobj.Display();

        iRet = sobj.Count();

        System.out.println("Number of elements in LinkedList are : "+iRet);

        sobj.InsertAtPos(105, 5);

        sobj.Display();

        iRet = sobj.Count();

        System.out.println("Number of elements in LinkedList are : "+iRet);

        sobj.DeleteAtPos(5);

        sobj.Display();

        iRet = sobj.Count();

        System.out.println("Number of elements in LinkedList are : "+iRet);
    }
}