
/**
 * Write a description of class isort here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Sorts {
    enum ListType {
        Standard, Bubble, Insert, Selection
    };

    ListType listType = ListType.Standard;

    private int[] list;
    private int[] blist;
    int bcompares = 0;
    int bswaps = 0;
    private int[] ilist;
    int icompares = 0;
    int iswaps = 0;
    private int[] slist;
    int scompares = 0;
    int sswaps = 0;

    /**
     * Constructor for objects of class isort
     */
    public Sorts() {
        int size = 50;
        list = new int[size];
        for (int i = 0; i < list.length; i++) {
            list[i] = (int) (Math.random() * size) + 1;
        }
        blist = list.clone();
        this.BubbleSort();
        ilist = list.clone();
        this.InsertionSort();
        slist = list.clone();
        this.SelectionSort();
    }

    public String toString() {
        int[] list;

        switch (listType) {
            case Standard:
                System.out.println("Original List");
                list = this.list;
                break;
            case Bubble:
                System.out.println("Bubble Sort -- " + " Operations: " + (this.bcompares + this.bswaps) + " Compares: "
                        + this.bcompares + " Swaps: " + this.bswaps);
                list = this.blist;
                break;
            case Insert:
                System.out.println("Insertions Sort -- " + " Operations: " + (this.icompares + this.iswaps)
                        + " Compares: " + this.icompares + " Swaps: " + this.iswaps);
                list = this.ilist;
                break;

            case Selection:
            default:
                System.out.println("Selection Sort -- " + " Operations: " + (this.scompares + this.sswaps)
                        + " Compares: " + this.scompares + " Swaps: " + this.sswaps);
                list = this.slist;
        }

        String output = "[";
        for (int i = 0; i < list.length; i++)
            output += " " + list[i];
        return output + " ]";
    }

    private int[] BubbleSort() {

        // iterate list, one less than length
        for (int i = 0; i < blist.length - 1; i++) {

            // bubble sort key logic
            for (int k = 1; k < blist.length - i; k++) {

                // analytics
                this.bcompares++; // compare counter

                // bubble sort swap logic
                if (blist[k - 1] > blist[k]) {
                    int swap = blist[k];
                    blist[k] = blist[k - 1];
                    blist[k - 1] = swap;

                    // analytics
                    this.bswaps++; // swap counter
                }

            }

        }
        return blist;
    }

    private int[] InsertionSort() {

        // iterate list, one less than length
        for (int i = 0; i < ilist.length - 1; i++) {

            // insertion sort key logic
            int k = i + 1;
            int swap = ilist[k];
            while (k > 0 && swap < ilist[k - 1]) {
                ilist[k] = ilist[k - 1];
                k--;

                // analytics
                this.icompares++; // compare counter
                this.iswaps++; // shift counter
            }
            ilist[k] = swap;

            this.iswaps++; // increment swap counter

        }

        return ilist;
    }

    private int[] SelectionSort() {
        for (int j = 0; j < slist.length - 1; j++) {
            int iMinimum = j;
            for (int i = j + 1; i < slist.length; i++) {
                this.scompares++; // compare counter
                if (slist[i] < slist[iMinimum]) {
                    iMinimum = i;
                }
            }
            if (iMinimum != j) {
                int swap = slist[iMinimum];
                slist[iMinimum] = slist[j];
                slist[j] = swap;

                // analytics
                this.sswaps++; // swap counter
            }
        }
        return slist;
    }

    /**
     * Bubble sort is not the most efficient and rarely used outside of learning. It
     * compares/swaps one element with the next until the largest number slowly
     * "bubbles" to the right. From this example, this algorithm produces the
     * greatest number of operations, comparisons, and swaps (close).
     * 
     * Both insertion sort and selection sort go through 2 loops, though the former
     * loops through sorted elements to insert where numbers belong and the latter
     * loops through unsorted elements and swaps with the minimum.
     * 
     * Selection sort drastically requires more comparisons. For each iteration, it
     * must compare all elements beyond itself in order to find the minimum and swap
     * with it (lots of comparing, less swapping). Therefore, less swapping is
     * needed compared to insertion sort.
     * 
     * According to
     * https://techdifferences.com/difference-between-insertion-sort-and-selection-sort.html
     * insertion sort is ultimately the better method between the two as it has a
     * O(n) complexity. On the other hand, selection sort has a best case complexity
     * of O(n^2)
     */
    public static void main(String[] args) {
        // Original List
        Sorts is = new Sorts();
        System.out.println(is);

        // Bubble Sort
        is.listType = ListType.Bubble;
        System.out.println(is);

        // Insertion Sort
        is.listType = ListType.Insert;
        System.out.println(is);

        // Selection Sort
        is.listType = ListType.Selection;
        System.out.println(is);
    }
}
