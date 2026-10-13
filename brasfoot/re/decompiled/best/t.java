/*
 * Decompiled with CFR 0.152.
 */
package best;

import best.G;
import best.ah;
import f.s;
import java.util.ArrayList;
import java.util.Collections;

public class t {
    private static final int[][][] cX = new int[][][]{new int[][]{{1, 2}, {19, 4}, {18, 5}, {17, 6}, {16, 7}, {15, 8}, {14, 9}, {13, 10}, {12, 11}}, new int[][]{{1, 3}, {2, 4}, {19, 6}, {18, 7}, {17, 8}, {16, 9}, {15, 10}, {14, 11}, {13, 12}}, new int[][]{{1, 4}, {3, 5}, {2, 6}, {19, 8}, {18, 9}, {17, 10}, {16, 11}, {15, 12}, {14, 13}}, new int[][]{{1, 5}, {4, 6}, {3, 7}, {2, 8}, {19, 10}, {18, 11}, {17, 12}, {16, 13}, {15, 14}}, new int[][]{{1, 6}, {5, 7}, {4, 8}, {3, 9}, {2, 10}, {19, 12}, {18, 13}, {17, 14}, {16, 15}}, new int[][]{{1, 7}, {6, 8}, {5, 9}, {4, 10}, {3, 11}, {2, 12}, {19, 14}, {18, 15}, {17, 16}}, new int[][]{{1, 8}, {7, 9}, {6, 10}, {5, 11}, {4, 12}, {3, 13}, {2, 14}, {19, 16}, {18, 17}}, new int[][]{{1, 9}, {8, 10}, {7, 11}, {6, 12}, {5, 13}, {4, 14}, {3, 15}, {2, 16}, {19, 18}}, new int[][]{{1, 10}, {9, 11}, {8, 12}, {7, 13}, {6, 14}, {5, 15}, {4, 16}, {3, 17}, {2, 18}}, new int[][]{{1, 11}, {10, 12}, {9, 13}, {8, 14}, {7, 15}, {6, 16}, {5, 17}, {4, 18}, {3, 19}}, new int[][]{{1, 12}, {11, 13}, {10, 14}, {9, 15}, {8, 16}, {7, 17}, {6, 18}, {5, 19}, {3, 2}}, new int[][]{{1, 13}, {12, 14}, {11, 15}, {10, 16}, {9, 17}, {8, 18}, {7, 19}, {5, 2}, {4, 3}}, new int[][]{{1, 14}, {13, 15}, {12, 16}, {11, 17}, {10, 18}, {9, 19}, {7, 2}, {6, 3}, {5, 4}}, new int[][]{{1, 15}, {14, 16}, {13, 17}, {12, 18}, {11, 19}, {9, 2}, {8, 3}, {7, 4}, {6, 5}}, new int[][]{{1, 16}, {15, 17}, {14, 18}, {13, 19}, {11, 2}, {10, 3}, {9, 4}, {8, 5}, {7, 6}}, new int[][]{{1, 17}, {16, 18}, {15, 19}, {13, 2}, {12, 3}, {11, 4}, {10, 5}, {9, 6}, {8, 7}}, new int[][]{{1, 18}, {17, 19}, {15, 2}, {14, 3}, {13, 4}, {12, 5}, {11, 6}, {10, 7}, {9, 8}}, new int[][]{{1, 19}, {17, 2}, {16, 3}, {15, 4}, {14, 5}, {13, 6}, {12, 7}, {11, 8}, {10, 9}}, new int[][]{{19, 2}, {18, 3}, {17, 4}, {16, 5}, {15, 6}, {14, 7}, {13, 8}, {12, 9}, {11, 10}}};
    private static final int[][][] cY = new int[][][]{new int[][]{{4, 4, 2, 2}, {4, 1, 2, 4}, {4, 3, 2, 1}, {3, 2, 1, 1}, {3, 4, 1, 2}, {4, 2, 2, 3}, {3, 3, 1, 3}, {3, 1, 1, 4}}, new int[][]{{2, 3, 4, 4}, {2, 4, 4, 3}, {1, 2, 3, 3}, {1, 3, 3, 2}, {2, 1, 4, 2}, {2, 2, 4, 1}, {1, 1, 3, 1}, {1, 4, 3, 4}}, new int[][]{{4, 4, 2, 4}, {1, 2, 3, 1}, {3, 2, 1, 4}, {1, 1, 4, 3}, {4, 2, 2, 2}, {2, 1, 4, 1}, {2, 3, 3, 3}, {1, 3, 3, 4}}, new int[][]{{2, 4, 4, 2}, {4, 4, 2, 1}, {4, 1, 1, 2}, {2, 2, 3, 2}, {4, 3, 2, 3}, {3, 1, 1, 3}, {3, 4, 1, 1}, {3, 3, 1, 4}}, new int[][]{{2, 4, 3, 4}, {1, 2, 3, 2}, {1, 3, 4, 4}, {2, 2, 4, 3}, {2, 3, 3, 1}, {2, 1, 3, 3}, {1, 1, 4, 1}, {1, 4, 4, 2}}, new int[][]{{3, 1, 2, 4}, {3, 2, 2, 1}, {4, 4, 1, 1}, {4, 2, 1, 2}, {3, 3, 2, 2}, {3, 4, 2, 3}, {4, 1, 1, 3}, {4, 3, 1, 4}}, new int[][]{{2, 3, 3, 2}, {2, 4, 3, 3}, {1, 2, 4, 4}, {1, 3, 4, 3}, {2, 1, 3, 4}, {2, 2, 3, 1}, {1, 1, 4, 2}, {1, 4, 4, 1}}, new int[][]{{3, 2, 2, 4}, {4, 3, 1, 2}, {1, 4, 4, 4}, {3, 1, 2, 1}, {3, 4, 2, 2}, {3, 3, 1, 1}, {4, 2, 1, 3}, {4, 1, 2, 3}}, new int[][]{{4, 4, 3, 2}, {2, 4, 1, 3}, {2, 1, 1, 2}, {4, 3, 3, 1}, {2, 2, 1, 1}, {2, 3, 1, 4}, {4, 2, 3, 3}, {4, 1, 3, 4}}, new int[][]{{1, 1, 2, 4}, {1, 2, 2, 3}, {3, 2, 4, 2}, {3, 4, 4, 4}, {3, 3, 4, 3}, {1, 3, 2, 2}, {1, 4, 2, 1}, {3, 1, 4, 1}}, new int[][]{{2, 4, 1, 2}, {3, 3, 4, 4}, {3, 2, 4, 1}, {3, 4, 4, 3}, {2, 2, 1, 4}, {2, 3, 1, 1}, {2, 1, 1, 3}, {3, 1, 4, 2}}, new int[][]{{4, 3, 3, 2}, {1, 4, 2, 4}, {1, 2, 2, 2}, {4, 4, 3, 1}, {1, 3, 2, 3}, {1, 1, 2, 1}, {4, 1, 3, 3}, {4, 2, 3, 4}}};
    private static final int[][][] cZ = new int[][][]{new int[][]{{4, 3, 1, 1}, {4, 1, 1, 5}, {4, 2, 1, 4}, {4, 5, 1, 3}, {4, 4, 1, 2}, {2, 3, 3, 1}, {2, 4, 3, 3}, {2, 2, 3, 4}, {2, 1, 3, 2}, {2, 5, 3, 5}}, new int[][]{{1, 1, 4, 5}, {1, 5, 4, 4}, {1, 3, 4, 3}, {1, 4, 4, 1}, {1, 2, 4, 2}, {3, 1, 2, 5}, {3, 4, 2, 3}, {3, 5, 2, 4}, {3, 2, 2, 2}, {3, 3, 2, 1}}, new int[][]{{1, 1, 4, 2}, {1, 2, 4, 5}, {4, 1, 1, 3}, {4, 3, 1, 5}, {1, 4, 4, 4}, {3, 1, 2, 1}, {3, 4, 2, 5}, {2, 3, 3, 5}, {2, 4, 3, 2}, {2, 2, 3, 3}}, new int[][]{{4, 1, 1, 1}, {4, 2, 1, 5}, {4, 5, 1, 4}, {4, 3, 1, 2}, {4, 4, 1, 3}, {3, 1, 2, 2}, {2, 1, 3, 5}, {2, 5, 3, 2}, {2, 3, 3, 3}, {3, 4, 2, 4}}, new int[][]{{4, 4, 1, 1}, {1, 4, 4, 3}, {1, 3, 4, 2}, {1, 5, 4, 5}, {1, 2, 4, 1}, {2, 4, 3, 1}, {3, 5, 2, 2}, {2, 1, 3, 4}, {3, 3, 2, 5}, {3, 2, 2, 3}}, new int[][]{{1, 1, 2, 3}, {2, 2, 1, 4}, {1, 3, 2, 4}, {1, 5, 2, 1}, {2, 5, 1, 2}, {4, 3, 3, 1}, {3, 4, 4, 4}, {3, 3, 4, 2}, {3, 5, 4, 1}, {4, 5, 3, 2}}, new int[][]{{2, 2, 1, 1}, {2, 3, 1, 2}, {2, 5, 1, 3}, {2, 4, 1, 5}, {2, 1, 1, 4}, {3, 1, 4, 5}, {4, 2, 3, 4}, {3, 2, 4, 3}, {4, 4, 3, 5}, {4, 1, 3, 3}}, new int[][]{{1, 1, 2, 1}, {1, 2, 2, 4}, {1, 3, 2, 3}, {1, 4, 2, 5}, {1, 5, 2, 2}, {3, 1, 4, 4}, {3, 2, 4, 2}, {3, 4, 4, 1}, {3, 5, 4, 3}, {3, 3, 4, 5}}, new int[][]{{1, 1, 2, 4}, {2, 5, 1, 5}, {2, 1, 1, 2}, {2, 2, 1, 3}, {2, 3, 1, 4}, {4, 1, 3, 1}, {4, 3, 3, 3}, {4, 4, 3, 2}, {4, 2, 3, 5}, {4, 5, 3, 4}}, new int[][]{{2, 5, 1, 1}, {2, 1, 1, 3}, {1, 2, 2, 2}, {1, 5, 2, 3}, {2, 4, 1, 4}, {3, 1, 4, 2}, {3, 2, 4, 1}, {3, 4, 4, 3}, {3, 5, 4, 5}, {3, 3, 4, 4}}, new int[][]{{1, 1, 3, 2}, {1, 3, 3, 4}, {1, 5, 3, 3}, {1, 2, 3, 1}, {1, 4, 3, 5}, {4, 1, 2, 3}, {4, 3, 2, 2}, {4, 2, 2, 4}, {4, 5, 2, 1}, {4, 4, 2, 5}}, new int[][]{{3, 1, 1, 1}, {3, 2, 1, 3}, {3, 5, 1, 2}, {3, 3, 1, 4}, {3, 4, 1, 5}, {2, 5, 4, 1}, {2, 3, 4, 5}, {2, 2, 4, 2}, {2, 4, 4, 4}, {2, 1, 4, 3}}, new int[][]{{1, 1, 3, 3}, {1, 5, 3, 5}, {1, 3, 3, 1}, {1, 2, 3, 4}, {1, 4, 3, 2}, {4, 1, 2, 4}, {4, 4, 2, 1}, {4, 2, 2, 5}, {4, 3, 2, 3}, {4, 5, 2, 2}}, new int[][]{{3, 4, 1, 1}, {3, 3, 1, 2}, {3, 2, 1, 5}, {3, 5, 1, 3}, {3, 1, 1, 4}, {2, 1, 4, 1}, {2, 5, 4, 3}, {2, 3, 4, 2}, {2, 2, 4, 4}, {2, 4, 4, 5}}, new int[][]{{1, 1, 3, 5}, {1, 5, 3, 1}, {1, 4, 3, 4}, {1, 2, 3, 2}, {1, 3, 3, 3}, {4, 1, 2, 2}, {4, 3, 2, 4}, {4, 2, 2, 1}, {4, 5, 2, 5}, {4, 4, 2, 3}}};
    private static final int[][][] da = new int[][][]{new int[][]{{2, 4, 1, 3}, {2, 3, 1, 2}, {2, 1, 1, 1}, {2, 5, 1, 4}, {2, 6, 1, 6}, {2, 2, 1, 5}}, new int[][]{{1, 1, 2, 5}, {1, 6, 2, 2}, {1, 2, 2, 6}, {1, 4, 2, 1}, {1, 5, 2, 4}, {1, 3, 2, 3}}, new int[][]{{2, 4, 1, 6}, {2, 2, 1, 3}, {2, 1, 1, 2}, {2, 3, 1, 1}, {2, 6, 1, 4}, {2, 5, 1, 5}}, new int[][]{{1, 1, 2, 4}, {1, 6, 2, 3}, {1, 3, 2, 6}, {1, 2, 2, 5}, {1, 5, 2, 1}, {1, 4, 2, 2}}, new int[][]{{2, 3, 1, 4}, {2, 4, 1, 2}, {2, 2, 1, 1}, {2, 1, 1, 6}, {2, 6, 1, 5}, {2, 5, 1, 3}}, new int[][]{{1, 1, 2, 6}, {1, 2, 2, 2}, {1, 4, 2, 4}, {1, 6, 2, 5}, {1, 3, 2, 1}, {1, 5, 2, 3}}};
    private static final int[][][] db = new int[][][]{new int[][]{{1, 8, 2, 6}, {1, 6, 2, 7}, {1, 3, 2, 1}, {1, 1, 2, 3}, {2, 4, 1, 2}, {2, 5, 1, 5}, {2, 8, 1, 4}, {2, 2, 1, 7}}, new int[][]{{1, 5, 2, 4}, {1, 4, 2, 2}, {1, 7, 2, 8}, {1, 2, 2, 5}, {2, 3, 1, 6}, {2, 7, 1, 1}, {2, 1, 1, 8}, {2, 6, 1, 3}}, new int[][]{{1, 8, 2, 8}, {1, 6, 2, 4}, {1, 3, 2, 2}, {1, 1, 2, 5}, {2, 3, 1, 5}, {2, 7, 1, 2}, {2, 1, 1, 7}, {2, 6, 1, 4}}, new int[][]{{1, 4, 2, 7}, {1, 5, 2, 1}, {1, 2, 2, 6}, {2, 5, 1, 3}, {1, 7, 2, 3}, {1, 8, 2, 4}, {2, 8, 1, 6}, {2, 2, 1, 1}}, new int[][]{{1, 4, 2, 4}, {1, 5, 2, 2}, {1, 7, 2, 5}, {1, 2, 2, 8}, {2, 3, 1, 3}, {2, 7, 1, 8}, {2, 1, 1, 1}, {2, 6, 1, 6}}, new int[][]{{1, 6, 2, 2}, {1, 3, 2, 4}, {1, 1, 2, 8}, {2, 3, 1, 4}, {2, 1, 1, 2}, {2, 6, 1, 5}, {1, 8, 2, 5}, {2, 7, 1, 7}}, new int[][]{{1, 8, 2, 3}, {1, 6, 2, 1}, {1, 3, 2, 7}, {1, 1, 2, 6}, {2, 4, 1, 7}, {2, 5, 1, 4}, {2, 8, 1, 5}, {2, 2, 1, 2}}, new int[][]{{1, 4, 2, 1}, {1, 5, 2, 7}, {1, 7, 2, 6}, {1, 2, 2, 3}, {2, 4, 1, 1}, {2, 5, 1, 6}, {2, 8, 1, 3}, {2, 2, 1, 8}}};
    private static final int[][] Jd;
    private static final int[][] dc;
    private static final int[][][] dd;
    private static final int[][][] Je;
    private static final int[][][] de;
    private static final int[][][] Jf;
    private static final int[][][] df;
    private static final int[][][] dg;
    private static final int[][][] dh;

    /*
     * Opcode count of 16484 triggered aggressive code reduction.  Override with --aggressivesizethreshold.
     */
    static {
        int[][] nArrayArray = new int[3][];
        int[] nArray = new int[2];
        nArray[0] = 2;
        nArrayArray[0] = nArray;
        nArrayArray[1] = new int[]{1, 2};
        int[] nArray2 = new int[2];
        nArray2[0] = 1;
        nArrayArray[2] = nArray2;
        Jd = nArrayArray;
        int[][] nArrayArray2 = new int[6][];
        int[] nArray3 = new int[2];
        nArray3[0] = 2;
        nArrayArray2[0] = nArray3;
        nArrayArray2[1] = new int[]{1, 2};
        int[] nArray4 = new int[2];
        nArray4[0] = 1;
        nArrayArray2[2] = nArray4;
        int[] nArray5 = new int[2];
        nArray5[1] = 2;
        nArrayArray2[3] = nArray5;
        nArrayArray2[4] = new int[]{2, 1};
        int[] nArray6 = new int[2];
        nArray6[1] = 1;
        nArrayArray2[5] = nArray6;
        dc = nArrayArray2;
        dd = new int[][][]{new int[][]{{1, 6}, {2, 7}, {3, 8}, {4, 9}}, new int[][]{{1, 2}, {3, 6}, {4, 7}, {5, 8}}, new int[][]{{1, 3}, {4, 2}, {5, 6}, {9, 8}}, new int[][]{{1, 4}, {5, 3}, {9, 6}, {8, 7}}, new int[][]{{1, 5}, {9, 3}, {7, 6}, {8, 2}}, new int[][]{{9, 5}, {8, 4}, {7, 3}, {6, 2}}, new int[][]{{1, 9}, {7, 5}, {2, 3}, {6, 4}}, new int[][]{{1, 8}, {7, 9}, {2, 5}, {3, 4}}, new int[][]{{1, 7}, {6, 8}, {2, 9}, {4, 5}}};
        int[][][] nArrayArray3 = new int[3][][];
        int[][] nArrayArray4 = new int[2][];
        int[] nArray7 = new int[2];
        nArray7[1] = 1;
        nArrayArray4[0] = nArray7;
        nArrayArray4[1] = new int[]{2, 3};
        nArrayArray3[0] = nArrayArray4;
        int[][] nArrayArray5 = new int[2][];
        int[] nArray8 = new int[2];
        nArray8[1] = 2;
        nArrayArray5[0] = nArray8;
        nArrayArray5[1] = new int[]{3, 1};
        nArrayArray3[1] = nArrayArray5;
        int[][] nArrayArray6 = new int[2][];
        int[] nArray9 = new int[2];
        nArray9[0] = 3;
        nArrayArray6[0] = nArray9;
        nArrayArray6[1] = new int[]{1, 2};
        nArrayArray3[2] = nArrayArray6;
        Je = nArrayArray3;
        int[][][] nArrayArray7 = new int[10][][];
        int[][] nArrayArray8 = new int[2][];
        nArrayArray8[0] = new int[]{3, 2};
        int[] nArray10 = new int[2];
        nArray10[0] = 1;
        nArrayArray8[1] = nArray10;
        nArrayArray7[0] = nArrayArray8;
        int[][] nArrayArray9 = new int[2][];
        nArrayArray9[0] = new int[]{1, 4};
        int[] nArray11 = new int[2];
        nArray11[1] = 2;
        nArrayArray9[1] = nArray11;
        nArrayArray7[1] = nArrayArray9;
        nArrayArray7[2] = new int[][]{{2, 1}, {4, 3}};
        int[][] nArrayArray10 = new int[2][];
        int[] nArray12 = new int[2];
        nArray12[1] = 3;
        nArrayArray10[0] = nArray12;
        nArrayArray10[1] = new int[]{2, 4};
        nArrayArray7[3] = nArrayArray10;
        int[][] nArrayArray11 = new int[2][];
        int[] nArray13 = new int[2];
        nArray13[0] = 4;
        nArrayArray11[0] = nArray13;
        nArrayArray11[1] = new int[]{3, 1};
        nArrayArray7[4] = nArrayArray11;
        int[][] nArrayArray12 = new int[2][];
        nArrayArray12[0] = new int[]{2, 3};
        int[] nArray14 = new int[2];
        nArray14[1] = 1;
        nArrayArray12[1] = nArray14;
        nArrayArray7[5] = nArrayArray12;
        int[][] nArrayArray13 = new int[2][];
        nArrayArray13[0] = new int[]{4, 1};
        int[] nArray15 = new int[2];
        nArray15[0] = 2;
        nArrayArray13[1] = nArray15;
        nArrayArray7[6] = nArrayArray13;
        nArrayArray7[7] = new int[][]{{1, 2}, {3, 4}};
        int[][] nArrayArray14 = new int[2][];
        int[] nArray16 = new int[2];
        nArray16[0] = 3;
        nArrayArray14[0] = nArray16;
        nArrayArray14[1] = new int[]{4, 2};
        nArrayArray7[8] = nArrayArray14;
        int[][] nArrayArray15 = new int[2][];
        int[] nArray17 = new int[2];
        nArray17[1] = 4;
        nArrayArray15[0] = nArray17;
        nArrayArray15[1] = new int[]{1, 3};
        nArrayArray7[9] = nArrayArray15;
        de = nArrayArray7;
        int[][][] nArrayArray16 = new int[10][][];
        int[][] nArrayArray17 = new int[3][];
        nArrayArray17[0] = new int[]{2, 1};
        int[] nArray18 = new int[2];
        nArray18[1] = 4;
        nArrayArray17[1] = nArray18;
        nArrayArray17[2] = new int[]{5, 3};
        nArrayArray16[0] = nArrayArray17;
        int[][] nArrayArray18 = new int[3][];
        int[] nArray19 = new int[2];
        nArray19[0] = 2;
        nArrayArray18[0] = nArray19;
        nArrayArray18[1] = new int[]{5, 1};
        nArrayArray18[2] = new int[]{3, 4};
        nArrayArray16[1] = nArrayArray18;
        int[][] nArrayArray19 = new int[3][];
        nArrayArray19[0] = new int[]{2, 5};
        int[] nArray20 = new int[2];
        nArray20[0] = 3;
        nArrayArray19[1] = nArray20;
        nArrayArray19[2] = new int[]{4, 1};
        nArrayArray16[2] = nArrayArray19;
        int[][] nArrayArray20 = new int[3][];
        nArrayArray20[0] = new int[]{2, 4};
        nArrayArray20[1] = new int[]{1, 3};
        int[] nArray21 = new int[2];
        nArray21[1] = 5;
        nArrayArray20[2] = nArray21;
        nArrayArray16[3] = nArrayArray20;
        int[][] nArrayArray21 = new int[3][];
        nArrayArray21[0] = new int[]{2, 3};
        nArrayArray21[1] = new int[]{4, 5};
        int[] nArray22 = new int[2];
        nArray22[0] = 1;
        nArrayArray21[2] = nArray22;
        nArrayArray16[4] = nArrayArray21;
        int[][] nArrayArray22 = new int[3][];
        nArrayArray22[0] = new int[]{1, 2};
        int[] nArray23 = new int[2];
        nArray23[0] = 4;
        nArrayArray22[1] = nArray23;
        nArrayArray22[2] = new int[]{3, 5};
        nArrayArray16[5] = nArrayArray22;
        int[][] nArrayArray23 = new int[3][];
        int[] nArray24 = new int[2];
        nArray24[1] = 2;
        nArrayArray23[0] = nArray24;
        nArrayArray23[1] = new int[]{1, 5};
        nArrayArray23[2] = new int[]{4, 3};
        nArrayArray16[6] = nArrayArray23;
        int[][] nArrayArray24 = new int[3][];
        nArrayArray24[0] = new int[]{5, 2};
        int[] nArray25 = new int[2];
        nArray25[1] = 3;
        nArrayArray24[1] = nArray25;
        nArrayArray24[2] = new int[]{1, 4};
        nArrayArray16[7] = nArrayArray24;
        int[][] nArrayArray25 = new int[3][];
        nArrayArray25[0] = new int[]{4, 2};
        nArrayArray25[1] = new int[]{3, 1};
        int[] nArray26 = new int[2];
        nArray26[0] = 5;
        nArrayArray25[2] = nArray26;
        nArrayArray16[8] = nArrayArray25;
        int[][] nArrayArray26 = new int[3][];
        nArrayArray26[0] = new int[]{3, 2};
        nArrayArray26[1] = new int[]{5, 4};
        int[] nArray27 = new int[2];
        nArray27[1] = 1;
        nArrayArray26[2] = nArray27;
        nArrayArray16[9] = nArrayArray26;
        Jf = nArrayArray16;
        int[][][] nArrayArray27 = new int[3][][];
        int[][] nArrayArray28 = new int[16][];
        int[] nArray28 = new int[2];
        nArray28[0] = 2;
        nArrayArray28[0] = nArray28;
        nArrayArray28[1] = new int[]{1, 3};
        nArrayArray28[2] = new int[]{6, 5};
        nArrayArray28[3] = new int[]{7, 4};
        nArrayArray28[4] = new int[]{10, 8};
        nArrayArray28[5] = new int[]{11, 9};
        nArrayArray28[6] = new int[]{12, 14};
        nArrayArray28[7] = new int[]{13, 15};
        nArrayArray28[8] = new int[]{17, 18};
        nArrayArray28[9] = new int[]{16, 19};
        nArrayArray28[10] = new int[]{20, 22};
        nArrayArray28[11] = new int[]{23, 21};
        nArrayArray28[12] = new int[]{24, 26};
        nArrayArray28[13] = new int[]{27, 25};
        nArrayArray28[14] = new int[]{28, 29};
        nArrayArray28[15] = new int[]{30, 31};
        nArrayArray27[0] = nArrayArray28;
        int[][] nArrayArray29 = new int[16][];
        nArrayArray29[0] = new int[]{2, 1};
        int[] nArray29 = new int[2];
        nArray29[0] = 3;
        nArrayArray29[1] = nArray29;
        nArrayArray29[2] = new int[]{7, 6};
        nArrayArray29[3] = new int[]{5, 4};
        nArrayArray29[4] = new int[]{9, 8};
        nArrayArray29[5] = new int[]{10, 11};
        nArrayArray29[6] = new int[]{12, 13};
        nArrayArray29[7] = new int[]{15, 14};
        nArrayArray29[8] = new int[]{16, 17};
        nArrayArray29[9] = new int[]{18, 19};
        nArrayArray29[10] = new int[]{21, 22};
        nArrayArray29[11] = new int[]{20, 23};
        nArrayArray29[12] = new int[]{24, 27};
        nArrayArray29[13] = new int[]{25, 26};
        nArrayArray29[14] = new int[]{29, 31};
        nArrayArray29[15] = new int[]{30, 28};
        nArrayArray27[1] = nArrayArray29;
        int[][] nArrayArray30 = new int[16][];
        nArrayArray30[0] = new int[]{3, 2};
        int[] nArray30 = new int[2];
        nArray30[1] = 1;
        nArrayArray30[1] = nArray30;
        nArrayArray30[2] = new int[]{5, 7};
        nArrayArray30[3] = new int[]{4, 6};
        nArrayArray30[4] = new int[]{9, 10};
        nArrayArray30[5] = new int[]{8, 11};
        nArrayArray30[6] = new int[]{15, 12};
        nArrayArray30[7] = new int[]{14, 13};
        nArrayArray30[8] = new int[]{18, 16};
        nArrayArray30[9] = new int[]{19, 17};
        nArrayArray30[10] = new int[]{21, 20};
        nArrayArray30[11] = new int[]{22, 23};
        nArrayArray30[12] = new int[]{25, 24};
        nArrayArray30[13] = new int[]{26, 27};
        nArrayArray30[14] = new int[]{29, 30};
        nArrayArray30[15] = new int[]{31, 28};
        nArrayArray27[2] = nArrayArray30;
        df = nArrayArray27;
        int[][][] nArrayArray31 = new int[11][][];
        int[][] nArrayArray32 = new int[5][];
        nArrayArray32[0] = new int[]{6, 4};
        nArrayArray32[1] = new int[]{7, 3};
        nArrayArray32[2] = new int[]{8, 2};
        nArrayArray32[3] = new int[]{9, 1};
        int[] nArray31 = new int[2];
        nArray31[0] = 10;
        nArrayArray32[4] = nArray31;
        nArrayArray31[0] = nArrayArray32;
        int[][] nArrayArray33 = new int[5][];
        int[] nArray32 = new int[2];
        nArray32[0] = 2;
        nArrayArray33[0] = nArray32;
        nArrayArray33[1] = new int[]{3, 10};
        nArrayArray33[2] = new int[]{4, 9};
        nArrayArray33[3] = new int[]{5, 8};
        nArrayArray33[4] = new int[]{6, 7};
        nArrayArray31[1] = nArrayArray33;
        int[][] nArrayArray34 = new int[5][];
        nArrayArray34[0] = new int[]{7, 5};
        nArrayArray34[1] = new int[]{8, 4};
        nArrayArray34[2] = new int[]{9, 3};
        nArrayArray34[3] = new int[]{10, 2};
        int[] nArray33 = new int[2];
        nArray33[1] = 1;
        nArrayArray34[4] = nArray33;
        nArrayArray31[2] = nArrayArray34;
        nArrayArray31[3] = new int[][]{{1, 10}, {2, 9}, {3, 8}, {4, 7}, {5, 6}};
        int[][] nArrayArray35 = new int[5][];
        nArrayArray35[0] = new int[]{3, 1};
        int[] nArray34 = new int[2];
        nArray34[0] = 4;
        nArrayArray35[1] = nArray34;
        nArrayArray35[2] = new int[]{5, 10};
        nArrayArray35[3] = new int[]{6, 9};
        nArrayArray35[4] = new int[]{7, 8};
        nArrayArray31[4] = nArrayArray35;
        int[][] nArrayArray36 = new int[5][];
        nArrayArray36[0] = new int[]{8, 6};
        nArrayArray36[1] = new int[]{9, 5};
        nArrayArray36[2] = new int[]{10, 4};
        int[] nArray35 = new int[2];
        nArray35[1] = 3;
        nArrayArray36[3] = nArray35;
        nArrayArray36[4] = new int[]{1, 2};
        nArrayArray31[5] = nArrayArray36;
        int[][] nArrayArray37 = new int[5][];
        nArrayArray37[0] = new int[]{4, 2};
        nArrayArray37[1] = new int[]{5, 1};
        int[] nArray36 = new int[2];
        nArray36[0] = 6;
        nArrayArray37[2] = nArray36;
        nArrayArray37[3] = new int[]{7, 10};
        nArrayArray37[4] = new int[]{8, 9};
        nArrayArray31[6] = nArrayArray37;
        int[][] nArrayArray38 = new int[5][];
        nArrayArray38[0] = new int[]{9, 7};
        nArrayArray38[1] = new int[]{10, 6};
        int[] nArray37 = new int[2];
        nArray37[1] = 5;
        nArrayArray38[2] = nArray37;
        nArrayArray38[3] = new int[]{1, 4};
        nArrayArray38[4] = new int[]{2, 3};
        nArrayArray31[7] = nArrayArray38;
        int[][] nArrayArray39 = new int[5][];
        nArrayArray39[0] = new int[]{5, 3};
        nArrayArray39[1] = new int[]{6, 2};
        nArrayArray39[2] = new int[]{7, 1};
        int[] nArray38 = new int[2];
        nArray38[0] = 8;
        nArrayArray39[3] = nArray38;
        nArrayArray39[4] = new int[]{9, 10};
        nArrayArray31[8] = nArrayArray39;
        int[][] nArrayArray40 = new int[5][];
        nArrayArray40[0] = new int[]{10, 8};
        int[] nArray39 = new int[2];
        nArray39[1] = 7;
        nArrayArray40[1] = nArray39;
        nArrayArray40[2] = new int[]{1, 6};
        nArrayArray40[3] = new int[]{2, 5};
        nArrayArray40[4] = new int[]{3, 4};
        nArrayArray31[9] = nArrayArray40;
        int[][] nArrayArray41 = new int[5][];
        int[] nArray40 = new int[2];
        nArray40[1] = 9;
        nArrayArray41[0] = nArray40;
        nArrayArray41[1] = new int[]{1, 8};
        nArrayArray41[2] = new int[]{2, 7};
        nArrayArray41[3] = new int[]{3, 6};
        nArrayArray41[4] = new int[]{4, 5};
        nArrayArray31[10] = nArrayArray41;
        dg = nArrayArray31;
        int[][][] nArrayArray42 = new int[25][][];
        nArrayArray42[0] = new int[][]{{1, 24}, {2, 23}, {3, 22}, {4, 21}, {5, 20}, {6, 19}, {7, 18}, {8, 17}, {9, 16}, {10, 15}, {11, 14}, {12, 13}};
        int[][] nArrayArray43 = new int[12][];
        nArrayArray43[0] = new int[]{14, 12};
        nArrayArray43[1] = new int[]{15, 11};
        nArrayArray43[2] = new int[]{16, 10};
        nArrayArray43[3] = new int[]{17, 9};
        nArrayArray43[4] = new int[]{18, 8};
        nArrayArray43[5] = new int[]{19, 7};
        nArrayArray43[6] = new int[]{20, 6};
        nArrayArray43[7] = new int[]{21, 5};
        nArrayArray43[8] = new int[]{22, 4};
        nArrayArray43[9] = new int[]{23, 3};
        nArrayArray43[10] = new int[]{24, 2};
        int[] nArray41 = new int[2];
        nArray41[1] = 1;
        nArrayArray43[11] = nArray41;
        nArrayArray42[1] = nArrayArray43;
        int[][] nArrayArray44 = new int[12][];
        int[] nArray42 = new int[2];
        nArray42[0] = 2;
        nArrayArray44[0] = nArray42;
        nArrayArray44[1] = new int[]{3, 24};
        nArrayArray44[2] = new int[]{4, 23};
        nArrayArray44[3] = new int[]{5, 22};
        nArrayArray44[4] = new int[]{6, 21};
        nArrayArray44[5] = new int[]{7, 20};
        nArrayArray44[6] = new int[]{8, 19};
        nArrayArray44[7] = new int[]{9, 18};
        nArrayArray44[8] = new int[]{10, 17};
        nArrayArray44[9] = new int[]{11, 16};
        nArrayArray44[10] = new int[]{12, 15};
        nArrayArray44[11] = new int[]{13, 14};
        nArrayArray42[2] = nArrayArray44;
        int[][] nArrayArray45 = new int[12][];
        nArrayArray45[0] = new int[]{15, 13};
        nArrayArray45[1] = new int[]{16, 12};
        nArrayArray45[2] = new int[]{17, 11};
        nArrayArray45[3] = new int[]{18, 10};
        nArrayArray45[4] = new int[]{19, 9};
        nArrayArray45[5] = new int[]{20, 8};
        nArrayArray45[6] = new int[]{21, 7};
        nArrayArray45[7] = new int[]{22, 6};
        nArrayArray45[8] = new int[]{23, 5};
        nArrayArray45[9] = new int[]{24, 4};
        int[] nArray43 = new int[2];
        nArray43[1] = 3;
        nArrayArray45[10] = nArray43;
        nArrayArray45[11] = new int[]{1, 2};
        nArrayArray42[3] = nArrayArray45;
        int[][] nArrayArray46 = new int[12][];
        nArrayArray46[0] = new int[]{3, 1};
        int[] nArray44 = new int[2];
        nArray44[0] = 4;
        nArrayArray46[1] = nArray44;
        nArrayArray46[2] = new int[]{5, 24};
        nArrayArray46[3] = new int[]{6, 23};
        nArrayArray46[4] = new int[]{7, 22};
        nArrayArray46[5] = new int[]{8, 21};
        nArrayArray46[6] = new int[]{9, 20};
        nArrayArray46[7] = new int[]{10, 19};
        nArrayArray46[8] = new int[]{11, 18};
        nArrayArray46[9] = new int[]{12, 17};
        nArrayArray46[10] = new int[]{13, 16};
        nArrayArray46[11] = new int[]{14, 15};
        nArrayArray42[4] = nArrayArray46;
        int[][] nArrayArray47 = new int[12][];
        nArrayArray47[0] = new int[]{16, 14};
        nArrayArray47[1] = new int[]{17, 13};
        nArrayArray47[2] = new int[]{18, 12};
        nArrayArray47[3] = new int[]{19, 11};
        nArrayArray47[4] = new int[]{20, 10};
        nArrayArray47[5] = new int[]{21, 9};
        nArrayArray47[6] = new int[]{22, 8};
        nArrayArray47[7] = new int[]{23, 7};
        nArrayArray47[8] = new int[]{24, 6};
        int[] nArray45 = new int[2];
        nArray45[1] = 5;
        nArrayArray47[9] = nArray45;
        nArrayArray47[10] = new int[]{1, 4};
        nArrayArray47[11] = new int[]{2, 3};
        nArrayArray42[5] = nArrayArray47;
        int[][] nArrayArray48 = new int[12][];
        nArrayArray48[0] = new int[]{4, 2};
        nArrayArray48[1] = new int[]{5, 1};
        int[] nArray46 = new int[2];
        nArray46[0] = 6;
        nArrayArray48[2] = nArray46;
        nArrayArray48[3] = new int[]{7, 24};
        nArrayArray48[4] = new int[]{8, 23};
        nArrayArray48[5] = new int[]{9, 22};
        nArrayArray48[6] = new int[]{10, 21};
        nArrayArray48[7] = new int[]{11, 20};
        nArrayArray48[8] = new int[]{12, 19};
        nArrayArray48[9] = new int[]{13, 18};
        nArrayArray48[10] = new int[]{14, 17};
        nArrayArray48[11] = new int[]{15, 16};
        nArrayArray42[6] = nArrayArray48;
        int[][] nArrayArray49 = new int[12][];
        nArrayArray49[0] = new int[]{17, 15};
        nArrayArray49[1] = new int[]{18, 14};
        nArrayArray49[2] = new int[]{19, 13};
        nArrayArray49[3] = new int[]{20, 12};
        nArrayArray49[4] = new int[]{21, 11};
        nArrayArray49[5] = new int[]{22, 10};
        nArrayArray49[6] = new int[]{23, 9};
        nArrayArray49[7] = new int[]{24, 8};
        int[] nArray47 = new int[2];
        nArray47[1] = 7;
        nArrayArray49[8] = nArray47;
        nArrayArray49[9] = new int[]{1, 6};
        nArrayArray49[10] = new int[]{2, 5};
        nArrayArray49[11] = new int[]{3, 4};
        nArrayArray42[7] = nArrayArray49;
        int[][] nArrayArray50 = new int[12][];
        nArrayArray50[0] = new int[]{5, 3};
        nArrayArray50[1] = new int[]{6, 2};
        nArrayArray50[2] = new int[]{7, 1};
        int[] nArray48 = new int[2];
        nArray48[0] = 8;
        nArrayArray50[3] = nArray48;
        nArrayArray50[4] = new int[]{9, 24};
        nArrayArray50[5] = new int[]{10, 23};
        nArrayArray50[6] = new int[]{11, 22};
        nArrayArray50[7] = new int[]{12, 21};
        nArrayArray50[8] = new int[]{13, 20};
        nArrayArray50[9] = new int[]{14, 19};
        nArrayArray50[10] = new int[]{15, 18};
        nArrayArray50[11] = new int[]{16, 17};
        nArrayArray42[8] = nArrayArray50;
        int[][] nArrayArray51 = new int[12][];
        nArrayArray51[0] = new int[]{18, 16};
        nArrayArray51[1] = new int[]{19, 15};
        nArrayArray51[2] = new int[]{20, 14};
        nArrayArray51[3] = new int[]{21, 13};
        nArrayArray51[4] = new int[]{22, 12};
        nArrayArray51[5] = new int[]{23, 11};
        nArrayArray51[6] = new int[]{24, 10};
        int[] nArray49 = new int[2];
        nArray49[1] = 9;
        nArrayArray51[7] = nArray49;
        nArrayArray51[8] = new int[]{1, 8};
        nArrayArray51[9] = new int[]{2, 7};
        nArrayArray51[10] = new int[]{3, 6};
        nArrayArray51[11] = new int[]{4, 5};
        nArrayArray42[9] = nArrayArray51;
        int[][] nArrayArray52 = new int[12][];
        nArrayArray52[0] = new int[]{6, 4};
        nArrayArray52[1] = new int[]{7, 3};
        nArrayArray52[2] = new int[]{8, 2};
        nArrayArray52[3] = new int[]{9, 1};
        int[] nArray50 = new int[2];
        nArray50[0] = 10;
        nArrayArray52[4] = nArray50;
        nArrayArray52[5] = new int[]{11, 24};
        nArrayArray52[6] = new int[]{12, 23};
        nArrayArray52[7] = new int[]{13, 22};
        nArrayArray52[8] = new int[]{14, 21};
        nArrayArray52[9] = new int[]{15, 20};
        nArrayArray52[10] = new int[]{16, 19};
        nArrayArray52[11] = new int[]{17, 18};
        nArrayArray42[10] = nArrayArray52;
        int[][] nArrayArray53 = new int[12][];
        nArrayArray53[0] = new int[]{19, 17};
        nArrayArray53[1] = new int[]{20, 16};
        nArrayArray53[2] = new int[]{21, 15};
        nArrayArray53[3] = new int[]{22, 14};
        nArrayArray53[4] = new int[]{23, 13};
        nArrayArray53[5] = new int[]{24, 12};
        int[] nArray51 = new int[2];
        nArray51[1] = 11;
        nArrayArray53[6] = nArray51;
        nArrayArray53[7] = new int[]{1, 10};
        nArrayArray53[8] = new int[]{2, 9};
        nArrayArray53[9] = new int[]{3, 8};
        nArrayArray53[10] = new int[]{4, 7};
        nArrayArray53[11] = new int[]{5, 6};
        nArrayArray42[11] = nArrayArray53;
        int[][] nArrayArray54 = new int[12][];
        nArrayArray54[0] = new int[]{7, 5};
        nArrayArray54[1] = new int[]{8, 4};
        nArrayArray54[2] = new int[]{9, 3};
        nArrayArray54[3] = new int[]{10, 2};
        nArrayArray54[4] = new int[]{11, 1};
        int[] nArray52 = new int[2];
        nArray52[0] = 12;
        nArrayArray54[5] = nArray52;
        nArrayArray54[6] = new int[]{13, 24};
        nArrayArray54[7] = new int[]{14, 23};
        nArrayArray54[8] = new int[]{15, 22};
        nArrayArray54[9] = new int[]{16, 21};
        nArrayArray54[10] = new int[]{17, 20};
        nArrayArray54[11] = new int[]{18, 19};
        nArrayArray42[12] = nArrayArray54;
        int[][] nArrayArray55 = new int[12][];
        nArrayArray55[0] = new int[]{20, 18};
        nArrayArray55[1] = new int[]{21, 17};
        nArrayArray55[2] = new int[]{22, 16};
        nArrayArray55[3] = new int[]{23, 15};
        nArrayArray55[4] = new int[]{24, 14};
        int[] nArray53 = new int[2];
        nArray53[1] = 13;
        nArrayArray55[5] = nArray53;
        nArrayArray55[6] = new int[]{1, 12};
        nArrayArray55[7] = new int[]{2, 11};
        nArrayArray55[8] = new int[]{3, 10};
        nArrayArray55[9] = new int[]{4, 9};
        nArrayArray55[10] = new int[]{5, 8};
        nArrayArray55[11] = new int[]{6, 7};
        nArrayArray42[13] = nArrayArray55;
        int[][] nArrayArray56 = new int[12][];
        nArrayArray56[0] = new int[]{8, 6};
        nArrayArray56[1] = new int[]{9, 5};
        nArrayArray56[2] = new int[]{10, 4};
        nArrayArray56[3] = new int[]{11, 3};
        nArrayArray56[4] = new int[]{12, 2};
        nArrayArray56[5] = new int[]{13, 1};
        int[] nArray54 = new int[2];
        nArray54[0] = 14;
        nArrayArray56[6] = nArray54;
        nArrayArray56[7] = new int[]{15, 24};
        nArrayArray56[8] = new int[]{16, 23};
        nArrayArray56[9] = new int[]{17, 22};
        nArrayArray56[10] = new int[]{18, 21};
        nArrayArray56[11] = new int[]{19, 20};
        nArrayArray42[14] = nArrayArray56;
        int[][] nArrayArray57 = new int[12][];
        nArrayArray57[0] = new int[]{21, 19};
        nArrayArray57[1] = new int[]{22, 18};
        nArrayArray57[2] = new int[]{23, 17};
        nArrayArray57[3] = new int[]{24, 16};
        int[] nArray55 = new int[2];
        nArray55[1] = 15;
        nArrayArray57[4] = nArray55;
        nArrayArray57[5] = new int[]{1, 14};
        nArrayArray57[6] = new int[]{2, 13};
        nArrayArray57[7] = new int[]{3, 12};
        nArrayArray57[8] = new int[]{4, 11};
        nArrayArray57[9] = new int[]{5, 10};
        nArrayArray57[10] = new int[]{6, 9};
        nArrayArray57[11] = new int[]{7, 8};
        nArrayArray42[15] = nArrayArray57;
        int[][] nArrayArray58 = new int[12][];
        nArrayArray58[0] = new int[]{9, 7};
        nArrayArray58[1] = new int[]{10, 6};
        nArrayArray58[2] = new int[]{11, 5};
        nArrayArray58[3] = new int[]{12, 4};
        nArrayArray58[4] = new int[]{13, 3};
        nArrayArray58[5] = new int[]{14, 2};
        nArrayArray58[6] = new int[]{15, 1};
        int[] nArray56 = new int[2];
        nArray56[0] = 16;
        nArrayArray58[7] = nArray56;
        nArrayArray58[8] = new int[]{17, 24};
        nArrayArray58[9] = new int[]{18, 23};
        nArrayArray58[10] = new int[]{19, 22};
        nArrayArray58[11] = new int[]{20, 21};
        nArrayArray42[16] = nArrayArray58;
        int[][] nArrayArray59 = new int[12][];
        nArrayArray59[0] = new int[]{22, 20};
        nArrayArray59[1] = new int[]{23, 19};
        nArrayArray59[2] = new int[]{24, 18};
        int[] nArray57 = new int[2];
        nArray57[1] = 17;
        nArrayArray59[3] = nArray57;
        nArrayArray59[4] = new int[]{1, 16};
        nArrayArray59[5] = new int[]{2, 15};
        nArrayArray59[6] = new int[]{3, 14};
        nArrayArray59[7] = new int[]{4, 13};
        nArrayArray59[8] = new int[]{5, 12};
        nArrayArray59[9] = new int[]{6, 11};
        nArrayArray59[10] = new int[]{7, 10};
        nArrayArray59[11] = new int[]{8, 9};
        nArrayArray42[17] = nArrayArray59;
        int[][] nArrayArray60 = new int[12][];
        nArrayArray60[0] = new int[]{10, 8};
        nArrayArray60[1] = new int[]{11, 7};
        nArrayArray60[2] = new int[]{12, 6};
        nArrayArray60[3] = new int[]{13, 5};
        nArrayArray60[4] = new int[]{14, 4};
        nArrayArray60[5] = new int[]{15, 3};
        nArrayArray60[6] = new int[]{16, 2};
        nArrayArray60[7] = new int[]{17, 1};
        int[] nArray58 = new int[2];
        nArray58[0] = 18;
        nArrayArray60[8] = nArray58;
        nArrayArray60[9] = new int[]{19, 24};
        nArrayArray60[10] = new int[]{20, 23};
        nArrayArray60[11] = new int[]{21, 22};
        nArrayArray42[18] = nArrayArray60;
        int[][] nArrayArray61 = new int[12][];
        nArrayArray61[0] = new int[]{23, 21};
        nArrayArray61[1] = new int[]{24, 20};
        int[] nArray59 = new int[2];
        nArray59[1] = 19;
        nArrayArray61[2] = nArray59;
        nArrayArray61[3] = new int[]{1, 18};
        nArrayArray61[4] = new int[]{2, 17};
        nArrayArray61[5] = new int[]{3, 16};
        nArrayArray61[6] = new int[]{4, 15};
        nArrayArray61[7] = new int[]{5, 14};
        nArrayArray61[8] = new int[]{6, 13};
        nArrayArray61[9] = new int[]{7, 12};
        nArrayArray61[10] = new int[]{8, 11};
        nArrayArray61[11] = new int[]{9, 10};
        nArrayArray42[19] = nArrayArray61;
        int[][] nArrayArray62 = new int[12][];
        nArrayArray62[0] = new int[]{11, 9};
        nArrayArray62[1] = new int[]{12, 8};
        nArrayArray62[2] = new int[]{13, 7};
        nArrayArray62[3] = new int[]{14, 6};
        nArrayArray62[4] = new int[]{15, 5};
        nArrayArray62[5] = new int[]{16, 4};
        nArrayArray62[6] = new int[]{17, 3};
        nArrayArray62[7] = new int[]{18, 2};
        nArrayArray62[8] = new int[]{19, 1};
        int[] nArray60 = new int[2];
        nArray60[0] = 20;
        nArrayArray62[9] = nArray60;
        nArrayArray62[10] = new int[]{21, 24};
        nArrayArray62[11] = new int[]{22, 23};
        nArrayArray42[20] = nArrayArray62;
        int[][] nArrayArray63 = new int[12][];
        nArrayArray63[0] = new int[]{24, 22};
        int[] nArray61 = new int[2];
        nArray61[1] = 21;
        nArrayArray63[1] = nArray61;
        nArrayArray63[2] = new int[]{1, 20};
        nArrayArray63[3] = new int[]{2, 19};
        nArrayArray63[4] = new int[]{3, 18};
        nArrayArray63[5] = new int[]{4, 17};
        nArrayArray63[6] = new int[]{5, 16};
        nArrayArray63[7] = new int[]{6, 15};
        nArrayArray63[8] = new int[]{7, 14};
        nArrayArray63[9] = new int[]{8, 13};
        nArrayArray63[10] = new int[]{9, 12};
        nArrayArray63[11] = new int[]{10, 11};
        nArrayArray42[21] = nArrayArray63;
        int[][] nArrayArray64 = new int[12][];
        nArrayArray64[0] = new int[]{12, 10};
        nArrayArray64[1] = new int[]{13, 9};
        nArrayArray64[2] = new int[]{14, 8};
        nArrayArray64[3] = new int[]{15, 7};
        nArrayArray64[4] = new int[]{16, 6};
        nArrayArray64[5] = new int[]{17, 5};
        nArrayArray64[6] = new int[]{18, 4};
        nArrayArray64[7] = new int[]{19, 3};
        nArrayArray64[8] = new int[]{20, 2};
        nArrayArray64[9] = new int[]{21, 1};
        int[] nArray62 = new int[2];
        nArray62[0] = 22;
        nArrayArray64[10] = nArray62;
        nArrayArray64[11] = new int[]{23, 24};
        nArrayArray42[22] = nArrayArray64;
        int[][] nArrayArray65 = new int[12][];
        int[] nArray63 = new int[2];
        nArray63[1] = 23;
        nArrayArray65[0] = nArray63;
        nArrayArray65[1] = new int[]{1, 22};
        nArrayArray65[2] = new int[]{2, 21};
        nArrayArray65[3] = new int[]{3, 20};
        nArrayArray65[4] = new int[]{4, 19};
        nArrayArray65[5] = new int[]{5, 18};
        nArrayArray65[6] = new int[]{6, 17};
        nArrayArray65[7] = new int[]{7, 16};
        nArrayArray65[8] = new int[]{8, 15};
        nArrayArray65[9] = new int[]{9, 14};
        nArrayArray65[10] = new int[]{10, 13};
        nArrayArray65[11] = new int[]{11, 12};
        nArrayArray42[23] = nArrayArray65;
        int[][] nArrayArray66 = new int[12][];
        nArrayArray66[0] = new int[]{13, 11};
        nArrayArray66[1] = new int[]{14, 10};
        nArrayArray66[2] = new int[]{15, 9};
        nArrayArray66[3] = new int[]{16, 8};
        nArrayArray66[4] = new int[]{17, 7};
        nArrayArray66[5] = new int[]{18, 6};
        nArrayArray66[6] = new int[]{19, 5};
        nArrayArray66[7] = new int[]{20, 4};
        nArrayArray66[8] = new int[]{21, 3};
        nArrayArray66[9] = new int[]{22, 2};
        nArrayArray66[10] = new int[]{23, 1};
        int[] nArray64 = new int[2];
        nArray64[0] = 24;
        nArrayArray66[11] = nArray64;
        nArrayArray42[24] = nArrayArray66;
        dh = nArrayArray42;
    }

    public static ah[][][] a(s s2, ArrayList arrayList, int n2) {
        ah[][][] ahArray;
        int n3;
        int n4;
        int n5;
        ah[] ahArray2 = new ah[arrayList.size()];
        ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
        int n6 = 0;
        while (n6 < arrayList.size()) {
            arrayList2.add(n6);
            ++n6;
        }
        Collections.shuffle(arrayList2);
        n6 = 0;
        while (n6 < arrayList.size()) {
            ahArray2[n6] = (ah)arrayList.get((Integer)arrayList2.get(n6));
            ++n6;
        }
        n6 = ahArray2.length;
        if (n6 % 2 == 1) {
            ah[] ahArray3 = new ah[n6 + 1];
            n5 = 0;
            while (n5 < ahArray2.length) {
                ahArray3[n5] = ahArray2[n5];
                ++n5;
            }
            ahArray3[n6] = null;
            ahArray2 = ahArray3;
        }
        int n7 = ahArray2.length - 1;
        n5 = ahArray2.length / 2;
        ah[][][] ahArray4 = new ah[n7][n5][4];
        int n8 = 0;
        while (n8 < n7) {
            n4 = 0;
            while (n4 < n5) {
                ah ah2 = ahArray2[(n8 + n4) % (n6 - 1)];
                ah ah3 = ahArray2[(n6 - 1 - n4 + n8) % (n6 - 1)];
                if (n4 == 0) {
                    ah3 = ahArray2[n6 - 1];
                }
                ahArray4[n8][n4][0] = ah2;
                ahArray4[n8][n4][3] = ah3;
                ++n4;
            }
            ++n8;
        }
        ah[][][] ahArray5 = new ah[n7][n5][4];
        n4 = 0;
        int n9 = ahArray2.length / 2;
        int n10 = 0;
        while (n10 < ahArray4.length) {
            ahArray5[n10] = n10 % 2 == 0 ? ahArray4[n4++] : ahArray4[n9++];
            ++n10;
        }
        ahArray4 = ahArray5;
        n10 = 0;
        while (n10 < ahArray4.length) {
            if (n10 % 2 == 1) {
                ahArray4[n10][0] = t.a(ahArray4[n10][0]);
            }
            ++n10;
        }
        ah[][][] ahArray6 = new ah[n7][n5][4];
        int n11 = 0;
        while (n11 < n7) {
            n3 = 0;
            while (n3 < n5) {
                ahArray6[n11][n3] = t.a((ah[])ahArray4[n11][n3].clone());
                ++n3;
            }
            ++n11;
        }
        if (n2 == 4) {
            ahArray = new ah[n7 * 4][n5][4];
            n3 = 0;
            while (n3 < ahArray4.length) {
                ahArray[n3] = ahArray4[n3];
                ++n3;
            }
            n3 = ahArray4.length;
            while (n3 < ahArray4.length + ahArray6.length) {
                ahArray[n3] = ahArray6[n3 - ahArray4.length];
                ++n3;
            }
            n3 = ahArray4.length + ahArray6.length;
            while (n3 < ahArray4.length + ahArray6.length + ahArray4.length) {
                ahArray[n3] = ahArray4[n3 - ahArray4.length - ahArray6.length];
                ++n3;
            }
            n3 = ahArray4.length + ahArray6.length + ahArray4.length;
            while (n3 < ahArray4.length + ahArray6.length + ahArray4.length + ahArray6.length) {
                ahArray[n3] = ahArray6[n3 - ahArray4.length - ahArray6.length - ahArray4.length];
                ++n3;
            }
        } else if (n2 == 3) {
            ahArray = new ah[n7 * 3][n5][4];
            n3 = 0;
            while (n3 < ahArray4.length) {
                ahArray[n3] = ahArray4[n3];
                ++n3;
            }
            n3 = ahArray4.length;
            while (n3 < ahArray4.length + ahArray6.length) {
                ahArray[n3] = ahArray6[n3 - ahArray4.length];
                ++n3;
            }
            n3 = ahArray4.length + ahArray6.length;
            while (n3 < ahArray4.length + ahArray6.length + ahArray4.length) {
                ahArray[n3] = ahArray4[n3 - ahArray4.length - ahArray6.length];
                ++n3;
            }
        } else if (n2 == 2) {
            ahArray = new ah[n7 * 2][n5][4];
            n3 = 0;
            while (n3 < ahArray4.length) {
                ahArray[n3] = ahArray4[n3];
                ++n3;
            }
            n3 = ahArray4.length;
            while (n3 < ahArray4.length + ahArray6.length) {
                ahArray[n3] = ahArray6[n3 - ahArray4.length];
                ++n3;
            }
        } else {
            ahArray = new ah[n7][n5][4];
            n3 = 0;
            while (n3 < ahArray4.length) {
                ahArray[n3] = ahArray4[n3];
                ++n3;
            }
        }
        return ahArray;
    }

    public static void e(int n2, int n3) {
        if (n2 % 2 != 0 && n3 != n2 - 1 || n2 <= 0) {
            throw new IllegalArgumentException();
        }
        int[] nArray = new int[n2];
        int n4 = n2 / 2;
        int n5 = 0;
        while (n5 < n4) {
            nArray[n5] = n5 + 1;
            nArray[n2 - n5 - 1] = nArray[n5] + n4;
            ++n5;
        }
        n5 = 1;
        while (n5 <= n3) {
            int n6 = nArray[1];
            int n7 = 1;
            while (n7 < n2 - 1) {
                int n8 = nArray[n7 + 1];
                nArray[n7 + 1] = n6;
                n6 = n8;
                ++n7;
            }
            nArray[1] = n6;
            ++n5;
        }
    }

    public static ah[][][] a(ArrayList arrayList, ArrayList arrayList2) {
        int n2;
        ah[] ahArray = new ah[arrayList.size()];
        int n3 = 0;
        while (n3 < arrayList.size()) {
            ahArray[n3] = (ah)arrayList.get(n3);
            ++n3;
        }
        n3 = 16;
        int n4 = 12;
        int n5 = 8;
        ah[][][] ahArray2 = new ah[n4][n5][4];
        int n6 = 0;
        while (n6 < n4) {
            n2 = 0;
            while (n2 < n5) {
                int n7 = cY[n6][n2][0] - 1;
                int n8 = cY[n6][n2][1] - 1;
                ahArray2[n6][n2][0] = (ah)((G)arrayList2.get(n7)).gR().get(n8);
                int n9 = cY[n6][n2][2] - 1;
                int n10 = cY[n6][n2][3] - 1;
                ahArray2[n6][n2][3] = (ah)((G)arrayList2.get(n9)).gR().get(n10);
                ++n2;
            }
            ++n6;
        }
        ah[][][] ahArray3 = new ah[n4][n5][4];
        n2 = 0;
        while (n2 < ahArray2.length) {
            ahArray3[n2] = ahArray2[n2];
            ++n2;
        }
        return ahArray3;
    }

    public static ah[][][] b(ArrayList arrayList, ArrayList arrayList2) {
        int n2;
        ah[] ahArray = new ah[arrayList.size()];
        int n3 = 0;
        while (n3 < arrayList.size()) {
            ahArray[n3] = (ah)arrayList.get(n3);
            ++n3;
        }
        n3 = 20;
        int n4 = 15;
        int n5 = 10;
        ah[][][] ahArray2 = new ah[n4][n5][4];
        int n6 = 0;
        while (n6 < n4) {
            n2 = 0;
            while (n2 < n5) {
                int n7 = cZ[n6][n2][0] - 1;
                int n8 = cZ[n6][n2][1] - 1;
                ahArray2[n6][n2][0] = (ah)((G)arrayList2.get(n7)).gR().get(n8);
                int n9 = cZ[n6][n2][2] - 1;
                int n10 = cZ[n6][n2][3] - 1;
                ahArray2[n6][n2][3] = (ah)((G)arrayList2.get(n9)).gR().get(n10);
                ++n2;
            }
            ++n6;
        }
        ah[][][] ahArray3 = new ah[n4][n5][4];
        n2 = 0;
        while (n2 < ahArray2.length) {
            ahArray3[n2] = ahArray2[n2];
            ++n2;
        }
        return ahArray3;
    }

    private static ah[] a(ah[] ahArray) {
        ah ah2 = ahArray[3];
        ahArray[3] = ahArray[0];
        ahArray[0] = ah2;
        return ahArray;
    }

    public static ah[][][] a(s s2, ArrayList arrayList) {
        int n2;
        ah[] ahArray = new ah[arrayList.size()];
        int n3 = 0;
        while (n3 < arrayList.size()) {
            ahArray[n3] = (ah)arrayList.get(n3);
            ++n3;
        }
        n3 = 6;
        int n4 = 1;
        ah[][][] ahArray2 = new ah[n3][n4][4];
        int n5 = 0;
        while (n5 < n3) {
            n2 = dc[n5][0];
            ahArray2[n5][0][0] = (ah)arrayList.get(n2);
            int n6 = dc[n5][1];
            ahArray2[n5][0][3] = (ah)arrayList.get(n6);
            ++n5;
        }
        ah[][][] ahArray3 = new ah[n3][n4][4];
        n2 = 0;
        while (n2 < ahArray2.length) {
            ahArray3[n2] = ahArray2[n2];
            ++n2;
        }
        return ahArray3;
    }

    public static ah[][][] g(s s2, ArrayList arrayList) {
        int n2;
        ah[] ahArray = new ah[arrayList.size()];
        int n3 = 0;
        while (n3 < arrayList.size()) {
            ahArray[n3] = (ah)arrayList.get(n3);
            ++n3;
        }
        n3 = 3;
        int n4 = 1;
        ah[][][] ahArray2 = new ah[n3][n4][4];
        int n5 = 0;
        while (n5 < n3) {
            n2 = Jd[n5][0];
            ahArray2[n5][0][0] = (ah)arrayList.get(n2);
            int n6 = Jd[n5][1];
            ahArray2[n5][0][3] = (ah)arrayList.get(n6);
            ++n5;
        }
        ah[][][] ahArray3 = new ah[n3][n4][4];
        n2 = 0;
        while (n2 < ahArray2.length) {
            ahArray3[n2] = ahArray2[n2];
            ++n2;
        }
        return ahArray3;
    }

    public static ah[][][] a(s s2, ArrayList arrayList, boolean bl2) {
        int n2;
        int n3;
        int n4;
        ah[] ahArray = new ah[arrayList.size()];
        int n5 = 0;
        while (n5 < arrayList.size()) {
            ahArray[n5] = (ah)arrayList.get(n5);
            ++n5;
        }
        n5 = 9;
        int n6 = 4;
        int n7 = 9;
        if (bl2) {
            n7 = 18;
        }
        ah[][][] ahArray2 = new ah[n7][n6][4];
        int n8 = 0;
        while (n8 < n5) {
            n4 = 0;
            while (n4 < n6) {
                n3 = dd[n8][n4][0] - 1;
                ahArray2[n8][n4][0] = (ah)arrayList.get(n3);
                n2 = dd[n8][n4][1] - 1;
                ahArray2[n8][n4][3] = (ah)arrayList.get(n2);
                ++n4;
            }
            ++n8;
        }
        if (bl2) {
            n8 = 0;
            while (n8 < n5) {
                n4 = 0;
                while (n4 < n6) {
                    n3 = dd[n8][n4][1] - 1;
                    ahArray2[n8 + n5][n4][0] = (ah)arrayList.get(n3);
                    n2 = dd[n8][n4][0] - 1;
                    ahArray2[n8 + n5][n4][3] = (ah)arrayList.get(n2);
                    ++n4;
                }
                ++n8;
            }
        }
        ah[][][] ahArray3 = new ah[n7][n6][4];
        n4 = 0;
        while (n4 < ahArray2.length) {
            ahArray3[n4] = ahArray2[n4];
            ++n4;
        }
        return ahArray3;
    }

    public static ah[][][] y(ArrayList arrayList) {
        int n2;
        ah[] ahArray = new ah[arrayList.size()];
        int n3 = 0;
        while (n3 < arrayList.size()) {
            ahArray[n3] = (ah)arrayList.get(n3);
            ++n3;
        }
        n3 = 5;
        int n4 = 2;
        ah[][][] ahArray2 = new ah[n3][n4][4];
        int n5 = 0;
        while (n5 < n3) {
            n2 = 0;
            while (n2 < n4) {
                int n6 = de[n5][n2][0];
                ahArray2[n5][n2][0] = (ah)arrayList.get(n6);
                int n7 = de[n5][n2][1];
                ahArray2[n5][n2][3] = (ah)arrayList.get(n7);
                ++n2;
            }
            ++n5;
        }
        ah[][][] ahArray3 = new ah[n3][n4][4];
        n2 = 0;
        while (n2 < ahArray2.length) {
            ahArray3[n2] = ahArray2[n2];
            ++n2;
        }
        return ahArray3;
    }

    public static ah[][][] v(ArrayList arrayList) {
        int n2;
        ah[] ahArray = new ah[arrayList.size()];
        int n3 = 0;
        while (n3 < arrayList.size()) {
            ahArray[n3] = (ah)arrayList.get(n3);
            ++n3;
        }
        n3 = 3;
        int n4 = 2;
        ah[][][] ahArray2 = new ah[n3][n4][4];
        int n5 = 0;
        while (n5 < n3) {
            n2 = 0;
            while (n2 < n4) {
                int n6 = Je[n5][n2][0];
                ahArray2[n5][n2][0] = (ah)arrayList.get(n6);
                int n7 = Je[n5][n2][1];
                ahArray2[n5][n2][3] = (ah)arrayList.get(n7);
                ++n2;
            }
            ++n5;
        }
        ah[][][] ahArray3 = new ah[n3][n4][4];
        n2 = 0;
        while (n2 < ahArray2.length) {
            ahArray3[n2] = ahArray2[n2];
            ++n2;
        }
        return ahArray3;
    }

    public static ah[][][] b(s s2, ArrayList arrayList) {
        int n2;
        ah[] ahArray = new ah[arrayList.size()];
        int n3 = 0;
        while (n3 < arrayList.size()) {
            ahArray[n3] = (ah)arrayList.get(n3);
            ++n3;
        }
        n3 = 10;
        int n4 = 2;
        ah[][][] ahArray2 = new ah[n3][n4][4];
        int n5 = 0;
        while (n5 < n3) {
            n2 = 0;
            while (n2 < n4) {
                int n6 = de[n5][n2][0];
                ahArray2[n5][n2][0] = (ah)arrayList.get(n6);
                int n7 = de[n5][n2][1];
                ahArray2[n5][n2][3] = (ah)arrayList.get(n7);
                ++n2;
            }
            ++n5;
        }
        ah[][][] ahArray3 = new ah[n3][n4][4];
        n2 = 0;
        while (n2 < ahArray2.length) {
            ahArray3[n2] = ahArray2[n2];
            ++n2;
        }
        return ahArray3;
    }

    public static ah[][][] h(s s2, ArrayList arrayList) {
        int n2;
        ah[] ahArray = new ah[arrayList.size()];
        int n3 = 0;
        while (n3 < arrayList.size()) {
            ahArray[n3] = (ah)arrayList.get(n3);
            ++n3;
        }
        n3 = 10;
        int n4 = 3;
        ah[][][] ahArray2 = new ah[n3][n4][4];
        int n5 = 0;
        while (n5 < n3) {
            n2 = 0;
            while (n2 < n4) {
                int n6 = Jf[n5][n2][0];
                ahArray2[n5][n2][0] = (ah)arrayList.get(n6);
                int n7 = Jf[n5][n2][1];
                ahArray2[n5][n2][3] = (ah)arrayList.get(n7);
                ++n2;
            }
            ++n5;
        }
        ah[][][] ahArray3 = new ah[n3][n4][4];
        n2 = 0;
        while (n2 < ahArray2.length) {
            ahArray3[n2] = ahArray2[n2];
            ++n2;
        }
        return ahArray3;
    }

    public static ah[][][] c(s s2, ArrayList arrayList) {
        int n2;
        ah[] ahArray = new ah[arrayList.size()];
        int n3 = 0;
        while (n3 < arrayList.size()) {
            ahArray[n3] = (ah)arrayList.get(n3);
            ++n3;
        }
        n3 = 11;
        int n4 = 5;
        ah[][][] ahArray2 = new ah[n3][n4][4];
        int n5 = 0;
        while (n5 < n3) {
            n2 = 0;
            while (n2 < n4) {
                int n6 = dg[n5][n2][0];
                ahArray2[n5][n2][0] = (ah)arrayList.get(n6);
                int n7 = dg[n5][n2][1];
                ahArray2[n5][n2][3] = (ah)arrayList.get(n7);
                ++n2;
            }
            ++n5;
        }
        ah[][][] ahArray3 = new ah[n3][n4][4];
        n2 = 0;
        while (n2 < ahArray2.length) {
            ahArray3[n2] = ahArray2[n2];
            ++n2;
        }
        return ahArray3;
    }

    public static ah[][][] d(s s2, ArrayList arrayList) {
        int n2;
        ah[] ahArray = new ah[arrayList.size()];
        int n3 = 0;
        while (n3 < arrayList.size()) {
            ahArray[n3] = (ah)arrayList.get(n3);
            ++n3;
        }
        n3 = 25;
        int n4 = 12;
        ah[][][] ahArray2 = new ah[n3][n4][4];
        int n5 = 0;
        while (n5 < n3) {
            n2 = 0;
            while (n2 < n4) {
                int n6 = dh[n5][n2][0];
                ahArray2[n5][n2][0] = (ah)arrayList.get(n6);
                int n7 = dh[n5][n2][1];
                ahArray2[n5][n2][3] = (ah)arrayList.get(n7);
                ++n2;
            }
            ++n5;
        }
        ah[][][] ahArray3 = new ah[n3][n4][4];
        n2 = 0;
        while (n2 < ahArray2.length) {
            ahArray3[n2] = ahArray2[n2];
            ++n2;
        }
        return ahArray3;
    }

    public static ah[][][] e(s s2, ArrayList arrayList) {
        int n2;
        int n3;
        ah[] ahArray = new ah[arrayList.size()];
        int n4 = 0;
        while (n4 < arrayList.size()) {
            ahArray[n4] = (ah)arrayList.get(n4);
            ++n4;
        }
        n4 = 19;
        int n5 = 9;
        ah[][][] ahArray2 = new ah[n4][n5][4];
        int n6 = 0;
        while (n6 < n4) {
            n3 = 0;
            while (n3 < n5) {
                n2 = cX[n6][n3][0];
                ahArray2[n6][n3][0] = (ah)arrayList.get(n2 - 1);
                int n7 = cX[n6][n3][1];
                ahArray2[n6][n3][3] = (ah)arrayList.get(n7 - 1);
                ++n3;
            }
            ++n6;
        }
        ah[][][] ahArray3 = new ah[n4][n5][4];
        n3 = 0;
        while (n3 < n4) {
            n2 = 0;
            while (n2 < n5) {
                ahArray3[n3][n2] = t.a((ah[])ahArray2[n3][n2].clone());
                ++n2;
            }
            ++n3;
        }
        ah[][][] ahArray4 = new ah[n4 * 2][n5][4];
        n2 = 0;
        while (n2 < ahArray2.length) {
            ahArray4[n2] = ahArray2[n2];
            ++n2;
        }
        n2 = ahArray2.length;
        while (n2 < ahArray2.length + ahArray3.length) {
            ahArray4[n2] = ahArray3[n2 - ahArray2.length];
            ++n2;
        }
        return ahArray4;
    }

    public static ah[][][] c(ArrayList arrayList, ArrayList arrayList2) {
        int n2;
        ah[] ahArray = new ah[arrayList.size()];
        int n3 = 0;
        while (n3 < arrayList.size()) {
            ahArray[n3] = (ah)arrayList.get(n3);
            ++n3;
        }
        n3 = 12;
        int n4 = 6;
        int n5 = 6;
        ah[][][] ahArray2 = new ah[n4][n5][4];
        int n6 = 0;
        while (n6 < n4) {
            n2 = 0;
            while (n2 < n5) {
                int n7 = da[n6][n2][0] - 1;
                int n8 = da[n6][n2][1] - 1;
                ahArray2[n6][n2][0] = (ah)((G)arrayList2.get(n7)).gR().get(n8);
                int n9 = da[n6][n2][2] - 1;
                int n10 = da[n6][n2][3] - 1;
                ahArray2[n6][n2][3] = (ah)((G)arrayList2.get(n9)).gR().get(n10);
                ++n2;
            }
            ++n6;
        }
        ah[][][] ahArray3 = new ah[n4][n5][4];
        n2 = 0;
        while (n2 < ahArray2.length) {
            ahArray3[n2] = ahArray2[n2];
            ++n2;
        }
        return ahArray3;
    }

    public static ah[][][] f(s s2, ArrayList arrayList) {
        int n2;
        ah[] ahArray = new ah[arrayList.size()];
        int n3 = 0;
        while (n3 < arrayList.size()) {
            ahArray[n3] = (ah)arrayList.get(n3);
            ++n3;
        }
        n3 = 32;
        int n4 = 3;
        int n5 = 16;
        ah[][][] ahArray2 = new ah[n4][n5][4];
        int n6 = 0;
        while (n6 < n4) {
            n2 = 0;
            while (n2 < n5) {
                int n7 = df[n6][n2][0];
                ahArray2[n6][n2][0] = (ah)arrayList.get(n7);
                int n8 = df[n6][n2][1];
                ahArray2[n6][n2][3] = (ah)arrayList.get(n8);
                ++n2;
            }
            ++n6;
        }
        ah[][][] ahArray3 = new ah[n4][n5][4];
        n2 = 0;
        while (n2 < ahArray2.length) {
            ahArray3[n2] = ahArray2[n2];
            ++n2;
        }
        return ahArray3;
    }

    public static ah[][][] d(ArrayList arrayList, ArrayList arrayList2) {
        int n2;
        ah[] ahArray = new ah[arrayList.size()];
        int n3 = 0;
        while (n3 < arrayList.size()) {
            ahArray[n3] = (ah)arrayList.get(n3);
            ++n3;
        }
        n3 = 16;
        int n4 = 8;
        int n5 = 8;
        ah[][][] ahArray2 = new ah[n4][n5][4];
        int n6 = 0;
        while (n6 < n4) {
            n2 = 0;
            while (n2 < n5) {
                int n7 = db[n6][n2][0] - 1;
                int n8 = db[n6][n2][1] - 1;
                ahArray2[n6][n2][0] = (ah)((G)arrayList2.get(n7)).gR().get(n8);
                int n9 = db[n6][n2][2] - 1;
                int n10 = db[n6][n2][3] - 1;
                ahArray2[n6][n2][3] = (ah)((G)arrayList2.get(n9)).gR().get(n10);
                ++n2;
            }
            ++n6;
        }
        ah[][][] ahArray3 = new ah[n4][n5][4];
        n2 = 0;
        while (n2 < ahArray2.length) {
            ahArray3[n2] = ahArray2[n2];
            ++n2;
        }
        return ahArray3;
    }

    private static boolean a(ah ah2, ah ah3, ArrayList arrayList) {
        boolean bl2 = false;
        if (arrayList == null || arrayList.size() == 0) {
            return false;
        }
        int n2 = 0;
        while (n2 < arrayList.size()) {
            if (((G)arrayList.get(n2)).gR().contains(ah2) && ((G)arrayList.get(n2)).gR().contains(ah3)) {
                bl2 = true;
                break;
            }
            ++n2;
        }
        return bl2;
    }
}

