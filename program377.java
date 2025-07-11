///////////////////////////////////////////////////////
//
//  File name :     program377.java
//  Descreption :   Singly Circular LinkedList 
//  Author :        Diksha Anil Chavan
//  Date :          11/07/2025
//
///////////////////////////////////////////////////////
/// 
class node 
{
    public int data;
    public node next;
}

class SinglyCLL
{
    private node first;
    private node last;
    private int iCount;

    public SinglyCLL()
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

        if((first == null) && (last == null))
        {
            first = newn;
            last = newn;

            last.next = first;
        }
        else
        {
            newn.next = first;
            first = newn;

            last.next = first;
        }
        iCount++;
    }

    public void InsertLast(int no)
    {
        node newn = null;

        newn = new node();

        newn.data = no;
        newn.next = null;

        if((first == null) && (last == null))
        {
            first = newn;
            last = newn;

            last.next = first;
        }
        else
        {
            last.next = newn;
            last = newn;

            last.next = first;
        }
        iCount++;
    }

    public void InsertAtPos(int no, int Pos)
    {
        node temp = null;
        node newn = null;

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

            temp = first;

            for(iCnt = 1; iCnt < Pos-1; iCnt++)
            {
                temp = temp.next;
            }

            newn.next = temp.next;
            temp.next = newn;

            iCount++;
        }
    }

    public void DeleteFirst()
    {
        if(first == null)   // LL is empty
        {
            return;
        }
        else if(first.next == null)  // LL contains 1 node
        {
            first = null;
        }
        else    // LL contains more than 1 node
        {
            first = first.next;
        }
        iCount--;
    }

    public void DeleteLast()
    {
        node temp = null;

        if(first == null)   // LL is empty
        {
            return;
        }
        else if(first.next == null)  // LL contains 1 node
        {
            first = null;
        }
        else    // LL contains more than 1 node
        {
            temp = first;

            while(temp.next.next != first)
            {
                temp = temp.next;
            }
            temp.next = first;
        }
        iCount--;
    }

    public void DeleteAtPos(int Pos)
    {
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

        if((first == null) && (last != null))
        {
            return;
        }

        temp = first;
        int i = 0;

        for(i = 1; i <= iCount; i++)
        {
            System.out.print("| "+temp.data+" | ->" );
            temp = temp.next;
        }
        System.out.println();
    }

    public int Count()
    {
        return iCount;
    }
}

class program377
{
    public static void main(String A[])
    {
        SinglyCLL sobj = new SinglyCLL();
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