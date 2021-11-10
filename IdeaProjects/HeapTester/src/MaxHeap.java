import java.util.ArrayList;

public class MaxHeap<E extends Comparable> implements HeapInterface<E> {
    ArrayList<E> heapList = new ArrayList<E>();
    @Override
    public boolean add(E item) {
        heapList.add(item);
        int index=size()-1;
        int parentIndex = (index-1)/2;
        E parent = heapList.get(parentIndex);
        while(item.compareTo(parent)>0)
        {
            parent= heapList.get(parentIndex);
            if(item.compareTo(parent)>0)
            {
                heapList.set(parentIndex,item);
                heapList.set(index,parent);
                index = parentIndex;
                parentIndex = (index-1)/2;
                parent = heapList.get(parentIndex);
            }
        }
        return true;
    }

    @Override
    public E remove() {
        E lastValue = heapList.get(size()-1);
        E firstValue = heapList.get(0);
        heapList.set(0,lastValue);
        heapList.set(size()-1,firstValue);
        E returnedValue = heapList.remove(size()-1);
        int index=0;
        int leftChild = (index*2)+1;
        int rightChild = (index*2)+2;
        for(int x=0;x<size();x++)
        {
            leftChild = (index*2)+1;
            rightChild = (index*2)+2;
            /*if((leftChild<size()&&heapList.get(leftChild).compareTo(heapList.get(index))>0)||(rightChild<size() && heapList.get(rightChild).compareTo(heapList.get(index))>0))
            {
                if(rightChild<size() && heapList.get(leftChild).compareTo(heapList.get(rightChild))>=0)
                {
                    E value1 = heapList.get(leftChild);
                    heapList.set(leftChild,heapList.get(index));
                    heapList.set(index,value1);
                    index = leftChild;
                    leftChild = (index*2)+1;
                    rightChild = (index*2)+2;
                }
                else if(rightChild<size() && heapList.get(rightChild).compareTo(heapList.get(leftChild))>0)
                {
                    E value2 = heapList.get(rightChild);
                    heapList.set(rightChild,heapList.get(index));
                    heapList.set(index,value2);
                    index = rightChild;
                    leftChild = (index*2)+1;
                    rightChild = (index*2)+2;
                }
            }
            else if(rightChild>=size() && leftChild<size() && heapList.get(leftChild).compareTo(heapList.get(index))>0)
            {
                E value1 = heapList.get(leftChild);
                heapList.set(leftChild,heapList.get(index));
                heapList.set(index,value1);
                index = leftChild;
                leftChild = (index*2)+1;
                rightChild = (index*2)+2;
            }*/
            if(leftChild<size() && rightChild<size())
            {
                if(heapList.get(leftChild).compareTo(heapList.get(index))>0 || heapList.get(rightChild).compareTo(heapList.get(index))>0)
                {
                    if(heapList.get(leftChild).compareTo(heapList.get(rightChild))>=0)
                    {
                        E value1 = heapList.get(leftChild);
                        heapList.set(leftChild,heapList.get(index));
                        heapList.set(index,value1);
                        index = leftChild;
                        leftChild = (index*2)+1;
                        rightChild = (index*2)+2;
                    }
                    else if(heapList.get(rightChild).compareTo(heapList.get(leftChild))>0)
                    {
                        E value2 = heapList.get(rightChild);
                        heapList.set(rightChild,heapList.get(index));
                        heapList.set(index,value2);
                        index = rightChild;
                        leftChild = (index*2)+1;
                        rightChild = (index*2)+2;
                    }
                }
            }
            else if(leftChild<size() && rightChild>=size())
            {
                if(heapList.get(leftChild).compareTo(heapList.get(index))>0)
                {
                    E value1 = heapList.get(leftChild);
                    heapList.set(leftChild,heapList.get(index));
                    heapList.set(index,value1);
                    index = leftChild;
                    leftChild = (index*2)+1;
                    rightChild = (index*2)+2;
                }
            }
        }
        return returnedValue;
    }

    @Override
    public boolean isEmpty() {
        if(size()==0)
            return true;
        return false;
    }

    @Override
    public int size() {
        return heapList.size();
    }

    @Override
    public E get(int x) {
        return heapList.get(x);
    }

    @Override
    public void clear() {
        heapList.clear();
    }

   public String toString() {
        return heapList.toString();
   }
}
