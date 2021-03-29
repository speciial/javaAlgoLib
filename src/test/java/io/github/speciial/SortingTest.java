package io.github.speciial;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortingTest {

    int[] largeArray;

    @BeforeEach
    void setup() {
        largeArray = new int[]{837, 85, 438, 10, 553, 587, 676, 144, 816, 743, 746, 664, 447, 402, 325, 189, 611, 825, 524, 295, 100, 932, 357, 143, 904, 118, 476, 625, 156, 466, 613, 952, 683, 284, 80, 957, 990, 505, 941, 203, 185, 567, 765, 166, 471, 830, 482, 333, 801, 663, 341, 202, 876, 154, 48, 943, 242, 331, 439, 793, 527, 889, 953, 738, 905, 868, 891, 228, 606, 289, 757, 522, 258, 803, 480, 965, 588, 997, 501, 894, 956, 919, 669, 470, 330, 888, 864, 279, 917, 604, 126, 469, 560, 574, 227, 49, 806, 656, 636, 434, 296, 348, 127, 926, 944, 852, 64, 911, 105, 744, 36, 263, 339, 717, 942, 605, 373, 964, 610, 858, 264, 673, 221, 56, 906, 667, 843, 609, 405, 316, 106, 1000, 593, 133, 197, 886, 938, 362, 507, 907, 251, 563, 671, 351, 252, 751, 661, 591, 934, 737, 147, 205, 302, 160, 209, 494, 237, 898, 973, 962, 831, 504, 879, 459, 184, 429, 724, 479, 134, 720, 937, 584, 90, 485, 791, 895, 45, 666, 777, 768, 931, 985, 693, 754, 19, 123, 201, 844, 845, 27, 518, 820, 283, 254, 491, 826, 247, 95, 194, 966, 318, 548, 515, 547, 114, 783, 460, 486, 608, 580, 614, 538, 101, 766, 424, 371, 602, 361, 410, 188, 414, 129, 358, 915, 413, 366, 239, 589, 397, 960, 55, 81, 94, 893, 360, 29, 607, 342, 497, 117, 294, 598, 54, 312, 363, 510, 426, 977, 681, 241, 861, 833, 99, 691, 871, 288, 641, 718, 629, 790, 885, 694, 141, 335, 975, 727, 590, 89, 229, 771, 897, 7, 355, 675, 323, 832, 128, 616, 557, 877, 176, 367, 674, 379, 814, 455, 554, 890, 433, 786, 849, 415, 846, 763, 503, 637, 594, 390, 270, 86, 142, 73, 275, 319, 817, 386, 164, 300, 216, 704, 246, 111, 802, 24, 177, 552, 842, 153, 457, 716, 42, 214, 863, 980, 138, 406, 961, 66, 642, 665, 772, 365, 260, 255, 706, 619, 601, 399, 592, 161, 467, 225, 640, 113, 544, 324, 920, 474, 393, 210, 262, 183, 539, 856, 550, 520, 440, 282, 148, 240, 623, 193, 620, 63, 646, 186, 427, 940, 496, 799, 979, 570, 59, 930, 162, 702, 809, 492, 238, 528, 375, 529, 705, 451, 108, 755, 813, 338, 163, 968, 517, 169, 489, 951, 847, 436, 25, 465, 249, 678, 215, 735, 122, 107, 488, 618, 38, 955, 987, 199, 884, 253, 575, 984, 487, 854, 796, 383, 265, 994, 483, 267, 946, 710, 384, 206, 519, 967, 326, 79, 13, 595, 168, 269, 652, 526, 927, 158, 654, 403, 711, 286, 815, 350, 8, 775, 780, 301, 644, 756, 892, 726, 87, 78, 617, 959, 39, 679, 452, 764, 750, 449, 116, 739, 104, 343, 818, 146, 760, 150, 650, 789, 747, 200, 740, 57, 566, 320, 499, 344, 630, 131, 651, 824, 35, 145, 516, 835, 456, 30, 33, 400, 317, 420, 6, 561, 954, 291, 478, 152, 272, 173, 836, 171, 513, 219, 98, 281, 61, 60, 425, 222, 76, 46, 412, 401, 329, 271, 306, 981, 902, 416, 266, 853, 328, 734, 811, 736, 579, 389, 556, 83, 213, 873, 307, 226, 178, 730, 670, 448, 658, 198, 950, 787, 332, 354, 347, 11, 297, 211, 303, 533, 432, 290, 698, 838, 352, 115, 829, 419, 187, 9, 53, 688, 408, 776, 218, 748, 121, 908, 626, 913, 862, 446, 321, 929, 387, 93, 445, 536, 40, 310, 795, 733, 62, 615, 23, 773, 12, 135, 196, 822, 901, 51, 130, 346, 812, 69, 181, 647};
    }

    @Test
    void testInsertionSort() {
        SortingAlgorithm insertionSort = new InsertionSortAlgorithm();
        testSorting(insertionSort, new int[]{0});
        testSorting(insertionSort, new int[]{0, 0, 0});
        testSorting(insertionSort, new int[]{1, 2, 3});
        testSorting(insertionSort, new int[]{3, 2, 1});
        testSorting(insertionSort, new int[]{-17, 30, 2, 5, -13, 9, 9, 10});
        testSorting(insertionSort, largeArray);
    }

    @Test
    void testSelectionSort() {
        SortingAlgorithm selectionSort = new SelectionSortAlgorithm();
        testSorting(selectionSort, new int[]{0});
        testSorting(selectionSort, new int[]{0, 0, 0});
        testSorting(selectionSort, new int[]{1, 2, 3});
        testSorting(selectionSort, new int[]{3, 2, 1});
        testSorting(selectionSort, new int[]{-17, 30, 2, 5, -13, 9, 9, 10});
        testSorting(selectionSort, largeArray);
    }

    @Test
    void testHeapSort() {
        SortingAlgorithm heapSort = new HeapSortAlgorithm();
        testSorting(heapSort, new int[]{0});
        testSorting(heapSort, new int[]{0, 0, 0});
        testSorting(heapSort, new int[]{1, 2, 3});
        testSorting(heapSort, new int[]{3, 2, 1});
        testSorting(heapSort, new int[]{-17, 30, 2, 5, -13, 9, 9, 10});
        testSorting(heapSort, largeArray);
    }

    @Test
    void testQuickSort() {
        SortingAlgorithm quickSort = new QuickSortAlgorithm();
        testSorting(quickSort, new int[]{0});
        testSorting(quickSort, new int[]{0, 0, 0});
        testSorting(quickSort, new int[]{1, 2, 3});
        testSorting(quickSort, new int[]{3, 2, 1});
        testSorting(quickSort, new int[]{-17, 30, 2, 5, -13, 9, 9, 10});
        testSorting(quickSort, largeArray);
    }

    private void testSorting(SortingAlgorithm algorithm, int[] data) {
        algorithm.setData(data);
        algorithm.sort();
        assertEquals(data.length, algorithm.getItemCount());
        for (int index = 0; index < (algorithm.getItemCount() - 1); index++) {
            assertTrue(algorithm.getItem(index) <= algorithm.getItem(index + 1));
        }
    }

}