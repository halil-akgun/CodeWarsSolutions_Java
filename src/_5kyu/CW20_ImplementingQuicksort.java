package _5kyu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Program a particular implementation of the Quicksort sorting algorithm, as described below. For simplicity,
we will consider sorting integers in ascending order.

Input:
A list of integers of size n, with 1 ≤ n ≤ 1000.

Output:
A list of snapshots documenting the contents of the list as the algorithm executes. Each snapshot differs
from the previous one by a swap of two elements. The final snapshot must be the sorted list.
The snapshots allow the tests to confirm that the list is sorted in the way described below.

Algorithm Outline:
Quicksort starts by picking an element in the list, called the pivot. The pivot in our implementation is always
the first element. The algorithm partitions the list into two sublists, the elements smaller and larger than the pivot,
and places the pivot between them. It repeats this process on the two sublists until the entire list is sorted.

Partitioning is done by using indexes i and j to find elements that should be swapped. Index i starts at the position
to the right of the pivot, and moves right. Index j starts at the end of the list, moving left. If i finds an element
bigger than the pivot and j finds one smaller than the pivot, those elements are swapped, and we take a snapshot.
Elements that equal the pivot are ignored. When i and j cross, the algorithm ends the partitioning process by swapping
the pivot with the element at position j.

Example: [30, 50, 5, 30, 51, 10, 20, 99, 18, 30, 100, 33]
Phase 1 - Partition the list.

In this example the pivot is 30. i starts at the 50, which is bigger than the pivot. Meanwhile, j start at the 33,
but it only finds a element smaller than the pivot when it reaches the 18.

[30, 50, 5, 30, 51, 10, 20, 99, 18, 30, 100, 33]
      i                          j

The 18 and 50 are swapped. The 1st snapshot is [30, 18, 5, 30, 51, 10, 20, 99, 50, 30, 100, 33].
i and j continue. The next element bigger than the pivot that i encounters is the 51. The next element smaller than the
pivot that j encounters is the 20. After swapping these, the 2nd snapshot is [30, 18, 5, 30, 20, 10, 51, 99, 50, 30, 100, 33].
This process continues as long as i ≤ j. When they cross, the situation is:
[30, 18, 5, 30, 20, 10, 51, 99, 50, 30, 100, 33]
                    j   i

After the i, j loop terminates, the algorithm ends the partitioning process by swapping the pivot with the element
at position j. In this case this is the 10. The 3rd snapshot is [10, 18, 5, 30, 20, 30, 51, 99, 50, 30, 100, 33].

What has been achieved? All elements to the left of the pivot are smaller or equal to it, while all elements
to the right of the pivot are greater or equal to it. The pivot 30 is in the correct sorted position. We have
partitioned the list into two sublists with the pivot between them. Now we repeat the process on the two sublists
[10, 18, 5, 30, 20] and [51, 99, 50, 30, 100, 33].

NOTE: In certain cases one of the sublists might contain only a single element, if i and j meet at either the beginning or end of the list.

Phase 2 - Partition the first sublist.

Consider the first sublist [10, 18, 5, 30, 20]. Set the pivot to the first element 10. i and j swap the bigger 18
with the smaller 5, so the 4th snapshot is [10, 5, 18, 30, 20, 30, 51, 99, 50, 30, 100, 33]. They don't swap any
more before they cross. Then we swap the pivot with the element at position j, giving the 5th snapshot
[5, 10, 18, 30, 20, 30, 51, 99, 50, 30, 100, 33]. We have partitioned [10, 18, 5, 30, 20] into [5]
and [18, 30, 20] with the pivot 10 between them.

Phase 3 - Continue partitioning until the first sublist is sorted.

Repeat the process on these two sublists. Obviously the one element list [5] is sorted. The second sublist
[18, 30, 20] requires two steps. First 18 is picked as pivot. Because it's the minimum element in the sublist,
j moves all the way to the front to the list while i doesn't move, and no swaps occur. Since j ends up at position 0,
swapping the pivot with the element at position j has no effect. The pivot 18 is in the correct position already,
and the sub-sublist [30, 20] is generated. Now 30 is picked as pivot and gets swapped with 20, creating the 6th
snapshot [5, 10, 18, 20, 30, 30, 51, 99, 50, 30, 100, 33]. The original first sublist [10, 18, 5, 30, 20] has been sorted.

Phase 4 - Partition the second sublist. (Snapshots 7-9 are omitted for brevity)

Repeat the process on the second sublist [51, 99, 50, 30, 100, 33]. The pivot is the first element 51. i and j swap
the bigger 99 with the smaller 33, but nothing further. Then the pivot is swapped with the element at position j,
the 30. This partitions [51, 99, 50, 30, 100, 33] into sublists [30, 33, 50] and [100, 99] with the pivot 51 between them.

Phase 5 - Continue partitioning until the second sublist is sorted.

Repeat the process on these two sublists. [30, 33, 50] is already sorted. After swapping the 99 with
the 100 the second sublist is sorted, and therefore the entire list is also.

The function should return
[ [30, 18, 5, 30, 51, 10, 20, 99, 50, 30, 100, 33],
  [30, 18, 5, 30, 20, 10, 51, 99, 50, 30, 100, 33],
  [10, 18, 5, 30, 20, 30, 51, 99, 50, 30, 100, 33],
  [10, 5, 18, 30, 20, 30, 51, 99, 50, 30, 100, 33],
  [5, 10, 18, 30, 20, 30, 51, 99, 50, 30, 100, 33],
  [5, 10, 18, 20, 30, 30, 51, 99, 50, 30, 100, 33],
  [5, 10, 18, 20, 30, 30, 51, 33, 50, 30, 100, 99],
  [5, 10, 18, 20, 30, 30, 30, 33, 50, 51, 100, 99],
  [5, 10, 18, 20, 30, 30, 30, 33, 50, 51, 99, 100] ]

NOTE: The list must change between any two snapshots, by swapping the correct two elements as outlined above.
There are other implementations of quicksort, but this one is ours!

Quicksort is one of the most widely used sorting algorithms. It is fast (actual implementations obviously don't
capture snapshots, so they sort large lists quickly.) It also needs minimal additional storage, because it simply
swaps elements. In practice, once the sublists become short, simpler algorithms like Insertion Sort can be used.
The library sorting function for many programming languages is a version of Quicksort.
 */
public class CW20_ImplementingQuicksort {
    public static void main(String[] args) {
        quicksort(new int[]{30, 50, 5, 30, 51, 10, 20, 99, 18, 30, 100, 33}).forEach(t -> System.out.println(Arrays.toString(t)));
        quicksort(new int[]{10, 303, 3, 18, 20, 30, 30, 18, 20, 30, 30, 18, 20, 30, -30, 51, -99, 50, 30, -100, 33, 30, 18, 5, 10, 18, 20, 30, 30, 51, 99, 50, 30, 100, 33, 30, 18, 5, 10, 18, 20, 30, 30, 51, 99, 50, 30, 100, 33, 30, 18, 5, 10, 18, 20, 30, 30, 51, 99, 50, 30, 100, 33, 30, 18, 5, 10, 18, 20, 30, 30, 51, 99, 50, 30, 100, 33, 30, 18, 5, 10, 18, 20, 30, 30, 51, 99, 50, 30, 100, 33, 30, 18, 5, 10, 18, 20, 30, 30, 51, 99, 50, 30, 100, 33, 30, 18, 5, 10, 18, 20, 30, 30, 51, 99, 50, 30, 100, 33, 30, 18, 5, 10, 18, 20, 30, 30, 51, 99, 50, 30, 100, 33, 30, 18, 5, 10, 18, 20, 30, 30, 51, 99, 50, 30, 100, 33, 30, 18}).forEach(t -> System.out.println(Arrays.toString(t)));
//        quicksort(new int[]{706, -893, 342, -923, 248, -843, -948, 278, -881, 582, 888, -421, 711, 869, 430, 147, 689, -282, -249, 271, -154, 578, 499, 913, -951, -956, 681, -791, -905, -857, 504, -703, 663, 815, 753, -676, 967, -177, 595, -717, 378, 773, 473, -468, -989, -310, 255, -633, 937, 807, -902, -561, -885, -933, -802, -875, -568, -451, 284, -431, 497, 953, 824, -647, 822, 997, -764, -690, 889, 122, -240, -326, 518, -998, 120, -793, 877, -619, 206, -857, 920, 315, -707, 148, 973, -844, 747, 821, 885, -421, -435, -470, 172, -897, 729, -772, -978, 327, 990, 299, 271, 887, -998, -625, -554, 754, -710, -342, 992, 384, 509, 877, -936, 664, 333, -530, 843, 431, 929, 158, -903, 474, 442, 658, 907, 467, 215, -909, 618, -990, -321, -489, 837, 780, 701, 873, -884, 745, 314, 724, 765, 548, 441, -871, 771, -456, 624, 598, 343, -813, -993, 768, 473, 948, -1000, 848, -955, 119, 902, 116, 619, 831, 253, 640, 934, 912, -989, 457, 934, 426, -347, 648, 776, 616, 101, 194, -978, 710, 832, -849, -594, -330, 935, 245, 699, 889, -792, -580, -270, 636, 150, -765, -733, 587, 975, 467, -905, 611, -632, 937, 219, -619, 256, 971, -925, -611, 945, 303, -772, -646, -413, 777, 473, -921, 651, -780, 109, 849, -517, -986, 791, 701, 772, 702, 366, -997, 981, 318, -546, -917, 951, -652, -999, 707, 962, -811, 967, 371, -964, 371, 478, 704, 329, 876, 273, -816, -504, -828, 824, 265, -847, 349, 895, 878, 761, 653, -772, -930, 935, -983, -673, 413, -731, -717, -815, -442, 279, 942, 952, -697, 747, 952, 799, -749, 797, 102, -1000, -793, 105, 823, -835, 666, -821, 964, 990, 699, 945, -810, 427, 535, -746, -689, -458, 425, -505, -843, 936, 688, 935, 160, 948, 713, -797, -846, 896, -997, 981, 822, 929, 653, 370, 444, 152, 802, 256, -772, 528, 941, 774, 943, -747, -898, 278, 847, 482, 786, 800, 217, 785, -544, 169, 869, -676, 320, 702, 529, 447, 979, 578, -998, 311, 769, -711, 804, -730, 780, -940, 975, -973, 168, -990, 582, 821, 123, 518, -937, -969, -432, 168, 943, 126, -821, 137, -749, -916, 977, -693, 474, -886, -951, 299, 147, 135, -647, -768, 118, 171, 528, 886, 669, 977, 724, 756, -937, 491, 478, -921, 442, 785, -874, 856, 115, 722, 925, 928, -691, -750, 371, 842, -994, -811, -926, 424, 943, 780, 604, 846, -739, 155, 152, -871, 947, 885, 120, 271, 255, 431, 879, 924, 825, 759, 953, -421, 522, 672, -907, 469, 702, 696, 737, 585, -930, 833, 875, 114, -720, 839, 895, 741, 833, 883, 737, 530, 877, 783, 666, 922, -637, -690, 282, 578, -929, 857, 794, 531, 843, -930, 758, 766, 536, 676, 741, 935, -902, 942, -805, -925, -997, 794, -908, -793, 497, 835, -835, -928, 935, -913, 694, 695, 784, -682, 167, 853, 839, 877, 855, 423, 147, 864, 492, 938, 758, -820, 322, -969, 139, 834, 151, 938, 753, 843, 535, 887, -997, 952, 934, 586, 829, -761, 700, 674, 364, 887, -812, -952, 948, -894, 823, 157, 836, 777, 691, 855, -995, 664, -890, 328, 843, 736, 887, 342, 828, 925, -955, -954, 662, 820, -849, 167, 731, 138, -855, 774, 694, -924, 845, 520, 742, 975, 769, -891, 487, -968, 666, 474, 758, 758, 700, 781, 979, 953, -810, 839, 974, 947, 867, 845, 822, -832, 878, 732, 776, 486, -959, -735, -964, 738, 876, 885, 977, -833, -724, 932, 819, 591, 827, 948, -874, 928, 823, -958, -936, 150, 957, 530, 154, -964, -885, 671, 535, 970, 496, -925, 948, 276, 740, 258, 926, 729, 735, -894, 675, 872, 973, -884, -912, 973, -957, 879, 876, 731, -729, 888, 437, -973, 844, -860, 731, 145, 923, -964, 648, 173, 140, -964, 322, 594, 919, 875, 932, 150, 799, 855, 801, 968, 888, -999, 885, 858, 662, 775, 784, 943, 492, -756, 979, 689, 672, 707, 707, 151, 578, 928, 790, 791, -925, 520, 327, -685, -700, -884, 583, -745, -934, 821, 931, 800, 256, 876, 867, -837, 885, 835, 862, -923, 725, 860, 121, 870, 652, 798, 868, 150, 275, -760, 743, 867, -973, 486, 773, 944, 974, 948, 873, 835, 120, 663, 580, -747, -847, 935, -749, 170, 800, 726, 856, 849, 150, 924, 647, 328, 895, 888, 874, 874, -862, 796, 714, 774, 863, 873, 163, 856, 896, 799, -928, 772, -747, -841, -878, 757, 961, 255, 879, 259, 669, -882, 162, -984, 137, 769, 733, -869, 158, -930, 860, 734, 816, 178, 979, -753, 768, 752, 869, 647, 862, -819, 824, -991, 143, -831, 888, 793, 267, -885, 799, 774, -793, 703, 274, 764, 936, 774, 649, 844, -965, 142, 816, 775, -875, 810, -838, 849, -758, 798, -916, -822, 762, -834, 885, 652, -893, -816, 832, 955, -995, 923, 866, 168, 684, 485, 733, 138, -964, 887, 751, 943, 789, -897, 823, 482, 870, 780, -930, 709, 967, 255, 843, 248, -997, 701, -940, 270, 329, -884, 937, 135, -977, 897, 865, 329, -908, 951, 621, 771, 167, 670, 944, 258, 687, 777, -929, 686, -962, 926, 322, 332, 478, -997, 958, 842, 525, 154, 711, 697, -899, -894, 943, 957, -851, -859, 170, 705, 484, 919, 108, -975, 590, 689, 871, 154, 711, 785, -794, 933, -791, 267, 969, 874, 932, 991, 497, -917, 755, 171, 813, 852, 335, 843, -926, -749, 876, 754, -994, 973, 146, -986, 780, 924, -951, -848, -726, 893, 436, 775, 762, 745, -930, 823, 662, 676, 587, -753, 835, -867, -780, 857, 673, -805, 952, 926, 748, 978, 744, -817, -913, 983, 937, -771, 274, 936, 667, 832, 246, 986, 947, 936, 957, -874, 723, 792, 472, 792, 324, 844, 786, 746, 694, 274, 957, 742, 651, -911, 821, -928, 267, 958, -950, 720, 150, 952, -999, 777, 947, 852, 973, -769, 874, 151, 724, -831, 818, 935, 703, 154, -876, 836, -970, 142, 948, 157, -961, 816, 154, 964, -955, 693, 724, -973, 872, 733, 885, 672, 864, 674, 864, 138, 150, 885, 818, 954, 775, 769, 776, 776, 876, 877, 887, 792, 935, 150, -924, 336, 964, 491, 723, -830, -748, 756, 745, 842, 957, 774, 843, -949, 876, 776, 146, 735, 768, 692, 961, 875, 792, 948, 769, -916, 937, 949, 887, 927, 938, 743, 768, -888, 842, 473, 824, 947, 972, -834, -919, 785, 688, -989, -849, 943, 688, 828, 876, 848, 927, 748, 770, -997, 257, -993, 862, 770, 720, 773, 774, 770, 865, -899, 870, 947, 748, -916, 847, 848, 872, 672, 946, 864, 865, 867, 876, -967, -854, 788, 943, 773, -976, 967, -967, 924, 942, 761, 967, 889, 836, 969, 848, -894, 847, 942, 887, 875, 788, -843, 745, 967, -849, 969, 926, -897, -842, 862, -876, 964, 792, 973, 873, 766, -963, -897, 844, 946, -907, 966, 947, 962, 894, 840, 927, -935, 756, 788, 867, 935, 948, 775, 850, 947, -826, 933, 858, 958, -914, 872, 969, -847, 947, 866, 964, 966, 943, 788, 927, 862, 944, -930, 964, -828, 776, 736, 968, 733, 774, 838, 946, 744, 147, -929, 844, 943, -954, 148, -958, 938, 964, 864, 876, -927, 928, 872, 772, -954, 946, 769, 744, 964, 876, 862, 862, 754, 925, 769, 876, 846, 847, 762, 938, 777, 928, 948, 847, 973, 968, 972, 975, 877, -949, 753, 933, 942, -914, 756, 745, 147, -914, 961, 748, -935, -967, 757, 865, 947, -854, 844, 964, 147, -967, 748, 973, 872, 840, 943, 840, 874, 943, 847, 866, 947, 792, -893, 947, 762, 967, 792, -953, 760, 872, 935, -884, 844, 747, 856, 947, 846, 942, -754, -936, 873, 962, -927, -927, 848, 774, -969, 872, 844, 872, -847, 938, -908, -930, 957, 947, 775, 873, 872, 946, -897, 949, 767, 967, 863, 846, -925, 944, 947, 967, 967, 874, 772, -953, 970, -847, -928, -971, -972, 855, -939, -854, 767, 874, -914, -971, -914, -958, 974, -936, 872, 845, 947, 772, 927, 873, 947, 873, 762, 967, 947, 875, 967, -916, -961, 947, 757, 875, -847, -962, 875, 873, 948, -916, 967, 874, 872, 933, 968, 873, 872, 873, -926, 875, -926, -875, 947, -953, 873, -926, 875, -872, 873, -926, 875, -926, -926, -926, 947, -875, -926, -926, 873, 875, -926, -926, 947, -926, -926, 873, -926, -926, -926, -926, -926, -926, -926, -926, 875, -926, 875, -926, 875, -926, 947, -926, -926, -926, 875, -926, -926, -926, 873, 875, 873, 875, 873, -926, 873, -926, 947, 875, -926, -926, 875, 947, 875, 947, 875, 873, 873, 875, 873, 947, 875, -926, 947, -926, -926, 875, 873, -926, -926, -926, -926}).forEach(t -> System.out.println(Arrays.toString(t)));
    }

    public static List<int[]> quicksort(int[] data) {
        List<int[]> result = new ArrayList<>();

        int pivot = 0, i = 1, j = data.length - 1;
        boolean pivotAtStart = false;

        while (pivot < data.length - 1) {

            int pivotValue = data[pivot];

            if (i >= j) {
                for (int k = j; k > pivot; k--) {
                    if (data[k] < pivotValue) {
                        data[pivot] = data[k];
                        data[k] = pivotValue;
                        result.add(data.clone());
                        pivotAtStart = true;
                        break;
                    }
                }
                if (!pivotAtStart) pivot++;
                pivotAtStart = false;
                i = pivot + 1;
                j = data.length - 1;
            } else if (data[i] > pivotValue && data[j] < pivotValue) {
                swap(data, i, j);
                result.add(data.clone());
                ++i;
                --j;
            } else if (data[i] > pivotValue) {
                --j;
            } else if (data[j] < pivotValue) {
                ++i;
            } else {
                ++i;
                --j;
            }
        }

        return result;
    }

    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
