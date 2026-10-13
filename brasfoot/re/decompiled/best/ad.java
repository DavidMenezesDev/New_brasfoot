/*
 * Decompiled with CFR 0.152.
 */
package best;

import best.ac;
import javax.swing.ImageIcon;

public class ad {
    private String nome;
    private String lZ;
    private int pais;
    private ImageIcon ma = null;
    private String mb;
    private int lV;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String string) {
        this.nome = string;
    }

    public int getPais() {
        return this.pais;
    }

    public void setPais(int n2) {
        this.pais = n2;
    }

    public ImageIcon jD() {
        return this.ma;
    }

    public void d(ImageIcon imageIcon) {
        this.ma = imageIcon;
    }

    public String jE() {
        return this.mb;
    }

    public void r(String string) {
        this.mb = string;
    }

    public int gg() {
        return this.lV;
    }

    public void bn(int n2) {
        this.lV = n2;
    }

    public String jF() {
        return this.lZ;
    }

    public void s(String string) {
        this.lZ = string;
    }

    public void bo(int n2) {
        ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/aflags/" + n2 + ".png"));
        this.d(imageIcon);
    }

    public static String bp(int n2) {
        String string = null;
        switch (n2) {
            case 3: {
                string = "Alem\u00e3o";
                break;
            }
            case 10: {
                string = "Argelino";
                break;
            }
            case 11: {
                string = "Argentino";
                break;
            }
            case 12: {
                string = "Armenio";
                break;
            }
            case 14: {
                string = "Australiano";
                break;
            }
            case 15: {
                string = "Austr\u00edaco";
                break;
            }
            case 21: {
                string = "Belga";
                break;
            }
            case 26: {
                string = "Boliviano";
                break;
            }
            case 29: {
                string = "Brasileiro";
                break;
            }
            case 31: {
                string = "Bulgaro";
                break;
            }
            case 42: {
                string = "Chileno";
                break;
            }
            case 43: {
                string = "Chin\u00eas";
                break;
            }
            case 46: {
                string = "Colombiano";
                break;
            }
            case 49: {
                string = "Sul-Coreano";
                break;
            }
            case 52: {
                string = "Croata";
                break;
            }
            case 54: {
                string = "Dinamarqu\u00eas";
                break;
            }
            case 57: {
                string = "Eg\u00edpcio";
                break;
            }
            case 60: {
                string = "Equatoriano";
                break;
            }
            case 62: {
                string = "Escoc\u00eas";
                break;
            }
            case 63: {
                string = "Eslovaco";
                break;
            }
            case 64: {
                string = "Esloveno";
                break;
            }
            case 65: {
                string = "Espanhol";
                break;
            }
            case 70: {
                string = "Finland\u00eas";
                break;
            }
            case 72: {
                string = "Franc\u00eas";
                break;
            }
            case 78: {
                string = "Grego";
                break;
            }
            case 85: {
                string = "Holand\u00eas";
                break;
            }
            case 88: {
                string = "Hungaro";
                break;
            }
            case 97: {
                string = "Ingl\u00eas";
                break;
            }
            case 98: {
                string = "Iraniano";
                break;
            }
            case 100: {
                string = "Irland\u00eas";
                break;
            }
            case 104: {
                string = "Italiano";
                break;
            }
            case 107: {
                string = "Japon\u00eas";
                break;
            }
            case 129: {
                string = "Marroquino";
                break;
            }
            case 131: {
                string = "Mexicano";
                break;
            }
            case 150: {
                string = "Paraguaio";
                break;
            }
            case 151: {
                string = "Peruano";
                break;
            }
            case 152: {
                string = "Polon\u00eas";
                break;
            }
            case 154: {
                string = "Portugu\u00eas";
                break;
            }
            case 160: {
                string = "Romeno";
                break;
            }
            case 162: {
                string = "Russo";
                break;
            }
            case 171: {
                string = "S\u00e9rvio";
                break;
            }
            case 179: {
                string = "Sueco";
                break;
            }
            case 180: {
                string = "Sui\u00e7o";
                break;
            }
            case 183: {
                string = "Tailand\u00eas";
                break;
            }
            case 192: {
                string = "Turco";
                break;
            }
            case 193: {
                string = "Ucraniano";
                break;
            }
            case 195: {
                string = "Uruguaio";
                break;
            }
            case 198: {
                string = "Venezuelano";
            }
        }
        return string;
    }

    public static String bq(int n2) {
        int[][] nArrayArray = new int[112][];
        nArrayArray[0] = new int[]{29, 1};
        nArrayArray[1] = new int[]{107, 1};
        nArrayArray[2] = new int[]{131, 1};
        nArrayArray[3] = new int[]{154, 2};
        int[] nArray = new int[2];
        nArray[1] = 1;
        nArrayArray[4] = nArray;
        nArrayArray[5] = new int[]{5, 2};
        nArrayArray[6] = new int[]{6, 2};
        nArrayArray[7] = new int[]{8, 2};
        nArrayArray[8] = new int[]{16, 1};
        nArrayArray[9] = new int[]{17, 2};
        nArrayArray[10] = new int[]{18, 1};
        nArrayArray[11] = new int[]{19, 2};
        nArrayArray[12] = new int[]{20, 2};
        nArrayArray[13] = new int[]{22, 1};
        nArrayArray[14] = new int[]{23, 1};
        nArrayArray[15] = new int[]{24, 2};
        nArrayArray[16] = new int[]{28, 2};
        nArrayArray[17] = new int[]{30, 2};
        nArrayArray[18] = new int[]{33, 1};
        nArrayArray[19] = new int[]{34, 1};
        nArrayArray[20] = new int[]{35, 2};
        nArrayArray[21] = new int[]{36, 2};
        nArrayArray[22] = new int[]{37, 1};
        nArrayArray[23] = new int[]{38, 1};
        nArrayArray[24] = new int[]{39, 1};
        nArrayArray[25] = new int[]{40, 1};
        nArrayArray[26] = new int[]{41, 1};
        nArrayArray[27] = new int[]{42, 1};
        nArrayArray[28] = new int[]{44, 1};
        nArrayArray[29] = new int[]{45, 1};
        nArrayArray[30] = new int[]{47, 1};
        nArrayArray[31] = new int[]{53, 2};
        nArrayArray[32] = new int[]{55, 1};
        nArrayArray[33] = new int[]{57, 1};
        nArrayArray[34] = new int[]{58, 2};
        nArrayArray[35] = new int[]{59, 3};
        nArrayArray[36] = new int[]{60, 1};
        nArrayArray[37] = new int[]{68, 3};
        nArrayArray[38] = new int[]{69, 2};
        nArrayArray[39] = new int[]{73, 1};
        nArrayArray[40] = new int[]{75, 2};
        nArrayArray[41] = new int[]{77, 2};
        nArrayArray[42] = new int[]{84, 1};
        nArrayArray[43] = new int[]{86, 2};
        nArrayArray[44] = new int[]{87, 2};
        nArrayArray[45] = new int[]{89, 1};
        nArrayArray[46] = new int[]{98, 2};
        nArrayArray[47] = new int[]{99, 2};
        nArrayArray[48] = new int[]{103, 2};
        nArrayArray[49] = new int[]{105, 2};
        nArrayArray[50] = new int[]{107, 1};
        nArrayArray[51] = new int[]{109, 1};
        nArrayArray[52] = new int[]{110, 2};
        nArrayArray[53] = new int[]{112, 1};
        nArrayArray[54] = new int[]{113, 1};
        nArrayArray[55] = new int[]{115, 1};
        nArrayArray[56] = new int[]{118, 2};
        nArrayArray[57] = new int[]{120, 2};
        nArrayArray[58] = new int[]{121, 2};
        nArrayArray[59] = new int[]{123, 2};
        nArrayArray[60] = new int[]{125, 1};
        nArrayArray[61] = new int[]{127, 1};
        nArrayArray[62] = new int[]{128, 2};
        nArrayArray[63] = new int[]{129, 1};
        nArrayArray[64] = new int[]{131, 1};
        nArrayArray[65] = new int[]{133, 2};
        nArrayArray[66] = new int[]{135, 2};
        nArrayArray[67] = new int[]{138, 1};
        nArrayArray[68] = new int[]{140, 1};
        nArrayArray[69] = new int[]{144, 2};
        nArrayArray[70] = new int[]{145, 1};
        nArrayArray[71] = new int[]{147, 1};
        nArrayArray[72] = new int[]{149, 1};
        nArrayArray[73] = new int[]{150, 1};
        nArrayArray[74] = new int[]{151, 1};
        nArrayArray[75] = new int[]{153, 2};
        nArrayArray[76] = new int[]{155, 1};
        nArrayArray[77] = new int[]{161, 2};
        nArrayArray[78] = new int[]{164, 2};
        nArrayArray[79] = new int[]{165, 2};
        nArrayArray[80] = new int[]{166, 2};
        nArrayArray[81] = new int[]{167, 2};
        nArrayArray[82] = new int[]{168, 2};
        nArrayArray[83] = new int[]{169, 1};
        nArrayArray[84] = new int[]{170, 2};
        nArrayArray[85] = new int[]{172, 1};
        nArrayArray[86] = new int[]{173, 2};
        nArrayArray[87] = new int[]{176, 2};
        nArrayArray[88] = new int[]{178, 2};
        nArrayArray[89] = new int[]{181, 1};
        nArrayArray[90] = new int[]{182, 1};
        nArrayArray[91] = new int[]{184, 1};
        nArrayArray[92] = new int[]{185, 2};
        nArrayArray[93] = new int[]{187, 1};
        nArrayArray[94] = new int[]{188, 1};
        nArrayArray[95] = new int[]{189, 2};
        nArrayArray[96] = new int[]{191, 1};
        nArrayArray[97] = new int[]{194, 2};
        nArrayArray[98] = new int[]{195, 1};
        nArrayArray[99] = new int[]{196, 1};
        nArrayArray[100] = new int[]{197, 2};
        nArrayArray[101] = new int[]{199, 1};
        nArrayArray[102] = new int[]{201, 1};
        nArrayArray[103] = new int[]{206, 2};
        nArrayArray[104] = new int[]{207, 1};
        nArrayArray[105] = new int[]{208, 2};
        nArrayArray[106] = new int[]{209, 1};
        nArrayArray[107] = new int[]{210, 2};
        nArrayArray[108] = new int[]{212, 2};
        nArrayArray[109] = new int[]{216, 2};
        nArrayArray[110] = new int[]{217, 2};
        nArrayArray[111] = new int[]{218, 2};
        int[][] nArrayArray2 = nArrayArray;
        String[] stringArray = new String[]{"da", "do", "de", "dos"};
        int n3 = 0;
        while (n3 < nArrayArray2.length) {
            if (nArrayArray2[n3][0] == n2) {
                return stringArray[nArrayArray2[n3][1]];
            }
            ++n3;
        }
        return "da";
    }

    public static String br(int n2) {
        String string = ad.bp(n2);
        if (string == null) {
            string = String.valueOf(ad.bq(n2)) + " " + ac.valueOf("P" + n2).getNome();
        }
        string = "Campeonato " + string;
        return string;
    }

    public static String bs(int n2) {
        String string = ad.bp(n2);
        if (string == null) {
            string = ac.valueOf("P" + n2).getNome();
        }
        return string;
    }

    public static String bt(int n2) {
        return String.valueOf(ad.bq(n2)) + " " + ac.valueOf("P" + n2).getNome();
    }

    public static String bu(int n2) {
        String string = ad.bp(n2);
        if (string == null) {
            string = ac.valueOf("P" + n2).getNome();
        }
        return string;
    }
}

