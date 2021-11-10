import java.util.ArrayList;
import java.util.Collections;

public class MyPriorityQueue<E extends Comparable> implements PriorityQueueInterface<E> {
    ArrayList<E> priorityList = new ArrayList<E>();

    @Override
    public boolean offer(E o) {
        priorityList.add(o);
        int index=size()-1;
        int parentIndex = (index-1)/2;
        E parent = priorityList.get(parentIndex);
        while(o.compareTo(parent)<0)
        {
            parent= priorityList.get(parentIndex);
            if(o.compareTo(parent)<0)
            {
                priorityList.set(parentIndex,o);
                priorityList.set(index,parent);
                index = parentIndex;
                parentIndex = (index-1)/2;
                parent = priorityList.get(parentIndex);
            }
        }
        return true;
    }

    @Override
    public E poll() {
        E lastValue = priorityList.get(size()-1);
        E firstValue = priorityList.get(0);
        priorityList.set(0,lastValue);
        priorityList.set(size()-1,firstValue);
        E returnedValue = priorityList.remove(size()-1);
        Collections.sort(priorityList);
        /*int index=0;
        int leftChild = (index*2)+1;
        int rightChild = (index*2)+2;
        //while(heapList.get(index).compareTo(heapList.get(leftChild))>0 || heapList.get(index).compareTo(heapList.get(rightChild))>0)
        for(int x=0;x<size();x++)
        {
            leftChild = (index*2)+1;
            rightChild = (index*2)+2;
            if((leftChild<size()&&priorityList.get(leftChild).compareTo(priorityList.get(index))<0)||(rightChild<size() && priorityList.get(rightChild).compareTo(priorityList.get(index))<0))
            {
                if(priorityList.get(leftChild).compareTo(priorityList.get(rightChild))>0)
                {
                    E value1 = priorityList.get(leftChild);
                    priorityList.set(leftChild,priorityList.get(index));
                    priorityList.set(index,value1);
                    index = leftChild;
                    leftChild = (index*2)+1;
                    rightChild = (index*2)+2;
                }
                else if(priorityList.get(leftChild).compareTo(priorityList.get(rightChild))<0)
                {
                    E value2 = priorityList.get(rightChild);
                    priorityList.set(rightChild,priorityList.get(index));
                    priorityList.set(index,value2);
                    index = rightChild;
                    leftChild = (index*2)+1;
                    rightChild = (index*2)+2;
                }
            }
        }*/
        return returnedValue;
    }

    @Override
    public int size() {
        return priorityList.size();
    }

    @Override
    public boolean isEmpty() {
        if(size()==0)
            return true;
        return false;
    }

    @Override
    public void clear() {
        priorityList.clear();
    }

    @Override
    public E get(int x) {
        return priorityList.get(x);
    }

    @Override
    public E set(int x, E item) {
        E answer = priorityList.get(x);
        priorityList.set(x,item);
        return answer;
    }

    @Override
    public E peek() {
        if(!isEmpty())
            return priorityList.get(0);
        return null;
    }

    public String toString() {
        return priorityList.toString();
    }
}
