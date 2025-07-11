///////////////////////////////////////////////////////
//
//  File name :     program378.java
//  Descreption :   Doubly Circular LinkedList 
//  Author :        Diksha Anil Chavan
//  Date :          11/07/2025
//
///////////////////////////////////////////////////////
/// 
class node 
{
    public int data;
    public node next;
    public node prev;
}

class DoublyCLL
{
    private node first;
    private node last;
    private int iCount;

    public DoublyCLL()
    {
        first = null;
        last = null;
        iCount = 0;
    }

    public void InsertFirst(int no)
    {
        node newn = null;

        newn = new node();

        newn.data = no;
        newn.next = null;
        newn.prev = null;

        if((first == null) && (last == null))   // LL is empty
        {
            first = newn;
            last = newn;
        }
        else    // LL contains atleast one node
        {
            newn.next = first;
            first.prev = newn;

            first = newn;
        }

        last.next = first;
        first.prev = last;

        iCount++;
    }

    public void InsertLast(int no)
    {
        node newn = null;

        newn = new node();

        newn.data = no;
        newn.next = null;
        newn.prev = null;

        if((first == null) && (last == null))   // LL is empty
        {
            first = newn;
            last = newn;
        }
        else    // LL contains atleast one node
        {
            last.next = newn;
            newn.prev = last;

            last = newn;
        }

        last.next = first;
        first.prev = last;

        iCount++;
    }

    public void InsertAtPos(int no, int Pos)
    {
        node newn = null;
        node temp = null;

        int i = 0;

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

            for(i = 1; i < Pos-1; i++)
            {
                temp = temp.next;
            }

            newn.next = temp.next;
            temp.next.prev = newn;

            temp.next = newn;
            newn.prev = temp;

            iCount++;
        }
    }

    public void DeleteFirst()
    {
        if((first == null) && (last == null))
        {
            return;
        }
        else if(first == last)
        {
            first = null;
            last = null;
        }
        else
        {
            first = first.next;

            last.next = first;
            first.prev = last;
        }
        iCount--;
    }

    public void DeleteLast()
    {
        if((first == null) && (last == null))
        {
            return;
        }
        else if(first == last)
        {
            first = null;
            last = null;
        }
        else
        {
            last = last.prev;

            last.next = first;
            first.prev = last;
        }
        iCount--;
    }

    public void DeleteAtPos(int Pos)
    {
        node temp = null;

        int i = 0;

        if(Pos < 1 || Pos > iCount)
        {
            System.out.println("Invalid Position");
            return;
        }

        if(Pos == 1)
        {
            DeleteFirst();
        }
        else if(Pos == iCount+1)
        {
            DeleteLast();
        }
        else
        {
            temp = first;

            for(i = 1; i < Pos-1; i++)
            {
                temp = temp.next;
            }

            temp.next = temp.next.next;
            temp.next.prev = temp;

            iCount--;
        }
    }

    public void Display()
    {
        node temp = null;

        temp = first;

        if((first == null) && (last == null))
        {
            return;
        }
        do
        {
            System.out.print("| "+temp.data+" | <=>" );
            temp = temp.next;
        }while(temp != first);
        System.out.println();
    }

    public int Count()
    {
        return iCount;
    }
}

class program378
{
    public static void main(String A[])
    {
        DoublyCLL sobj = new DoublyCLL();
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