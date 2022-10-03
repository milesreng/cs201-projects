import java.util.*;
// Shivam Mani
public class LinkStrand implements IDnaStrand {

    private class Node {
        String info;
        Node next;
   
        public Node(String s, Node n) {
             info = s;
             next = n;
        }
   }
   
   private Node myFirst, myLast;
   private long mySize;
   private int myAppends;
   private int myIndex;
   private Node myCurrent;
   private int myLocalIndex;
   

    public LinkStrand() {
        this("");
    }

    public LinkStrand(String s) {
        initialize(s);
    }

    @Override
    public long size() {
        // TODO Auto-generated method stub
        return mySize;
    }

    @Override
    public void initialize(String source) {
        Node nd = new Node(source, null);
        myFirst = nd;
        myLast = nd;
        myIndex = 0;
        myCurrent = myFirst;
        myLocalIndex = 0;
        mySize = source.length();
        myAppends = 0;      
    }

    @Override
    public IDnaStrand getInstance(String source) {
        return new LinkStrand(source);
    }

    @Override
    public IDnaStrand append(String dna) {
        myLast.next = new Node(dna, null);
        myLast = myLast.next;
        mySize += dna.length();
        myAppends++;

        return this;
    }

    @Override
    public IDnaStrand reverse() {
        LinkStrand rev = new LinkStrand();
        Node currNode = myFirst;

        while (currNode != null) {
            if (currNode == myFirst) {
                rev.myLast = currNode;
            }
            rev.addFirst(currNode.info);
            currNode = currNode.next;
        }

        return rev;
    }

    private void addFirst(String s) {
        StringBuilder revS = new StringBuilder(s);
        revS = revS.reverse();
        Node revNode = new Node(revS.toString(), myFirst);
        myFirst = revNode;
        mySize += revS.length();
    }

    @Override
    public int getAppendCount() {
        return myAppends;
    }

    @Override
    public char charAt(int index) {
        if (index < 0 || index >= mySize) {
            throw new IndexOutOfBoundsException();
        }

        int count = 0;
        int dex = 0;
        Node list = myFirst;

        if (myIndex < index && myIndex > 0 && myCurrent != null) {
            count = myIndex;
            dex = myLocalIndex;
            list = myCurrent;
        }

        while (count != index) {
            count++;
            dex++;
            if (dex >= list.info.length()) {
                dex = 0;
                list = list.next;
            }
        }

        myIndex = count;
        myLocalIndex = dex;
        myCurrent = list;

        return list.info.charAt(dex);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        myCurrent = myFirst;

        while (myCurrent != null) {
            sb.append(myCurrent.info);
            myCurrent = myCurrent.next;
        }

        return sb.toString();
    }
    
}
