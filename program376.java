///////////////////////////////////////////////////////
//
//  File name :     program376.java
//  Descreption :   Singly Linear LinkedList 
//  Author :        Diksha Anil Chavan
//  Date :          07/07/2025
//
///////////////////////////////////////////////////////

class node
{
    public int data;
    public node next;
}

class SinglyLL
{
    private node first;
    private int iCount;

    public SinglyLL()
    {
        System.out.println("Inside Constructor");
        first = null;
        iCount = 0;
    }

    public void InsertFirst(int no)
    {

        node newn = null;

        newn = new node();

        newn.data = no;
        newn.next = null;

        if(first == null)   // LL is empty
        {
            first = newn;
        }
        else    // LL contains atleast 1 node
        {
            newn.next = first;
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

        if(first == null)   // LL is empty
        {
            first = newn;
        }
        else    // LL contains atleast 1 node
        {
            temp = first;

            while(temp.next != null)
            {
                temp = temp.next;
            }

           temp.next = newn;
        }
        iCount++;
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
            System.out.print("| "+temp.data+" | ->" );
            temp = temp.next;
        }
        System.out.println("null");
    }

    public int Count()
    {
        return iCount;
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
        else if(first.next == null) // LL contains 1 node
        {
            first = null;
        }
        else    // LL contains more than 1 node
        {
            temp = first;

            while(temp.next.next != null)
            {
                temp = temp.next;
            }
            temp.next = null;
        }
        iCount--;
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
}

class program376
{
    public static void main(String A[])
    {
        SinglyLL sobj = new SinglyLL();
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