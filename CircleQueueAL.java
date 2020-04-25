import java.util.*;


public class CircleQueueAL
{
   private ArrayList arr;
   private int currentIndex;


public CircleQueueAL() {
    arr = new ArrayList();
    currentIndex = -1;
}

public Object getFirstObject() {
    if (arr == null)
      return null;
    else
      currentIndex = 0;
      return arr.get(0);
}


public Object getLastObject() {
    if (arr == null)
      return null;
    else
      currentIndex = arr.size() - 1;
      return arr.get(arr.size() - 1);
}

public Object getObject()
{
      if (currentIndex > 0)
        return arr.get(currentIndex);
      else
        return null;
}

public void setNext()
{
    currentIndex += 1;

    // never let currentNode be null, wrap to head
    if (currentIndex >= arr.size())
      currentIndex = 0;

    if (arr.size() == 0)
      currentIndex = -1;
}

public void setPrevious() {
    currentIndex -= 1;

    // never let currentNode be null, wrap to head
    if (currentIndex < 0)
      currentIndex = arr.size() - 1;

    if (arr.size() == 0)
      currentIndex = -1;
}

public void add(Object opaqueObject) {
  arr.add(opaqueObject);
}

public Object delete()
{
  return arr.remove(0);
}

public String toString() {
    String queueToString = "[";

    for (int i = 0; i < arr.size(); i++) {
        queueToString += "("+arr.get(i)+")";
        if (i < (arr.size() - 1))
           queueToString += ", ";
    }

    queueToString += "]";
    return queueToString;
}

public void insertionSort() {
    for (int i = 1; i < arr.size(); i++) {
        String cur = arr.get(i).toString();
        int j = i;
        while ((j > 0) && (arr.get(j - 1).toString().compareTo(cur) > 0)) {
            arr.set(j, arr.get(j - 1));
            j--;
        }
        arr.set(j, tmp);
    }
    

} 
  
}