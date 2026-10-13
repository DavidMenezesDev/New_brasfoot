/*
 * Decompiled with CFR 0.152.
 */
package components;

import best.F;
import best.ah;
import best.aq;
import c.a;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;

public class ao {
    private F U = null;
    private ImageIcon RC = null;
    private ah cg = null;
    private ImageIcon AH = new ImageIcon(this.getClass().getResource("/aicons/camisav.png"));
    private ImageIcon AJ = new ImageIcon(this.getClass().getResource("/aicons/camisat.png"));
    private ImageIcon AI = new ImageIcon(this.getClass().getResource("/aicons/camisag.png"));
    private static int RD = 435;
    private static int RE = 210;
    private static int RF = 580;
    private static int RG = 410;
    private static ArrayList RH = new ArrayList();
    private static ArrayList RI = new ArrayList();
    private static int[][] RJ = new int[][]{{-1, -1}, {190, 565}, {35, 425}, {100, 485}, {190, 485}, {285, 485}, {100, 405}, {190, 405}, {285, 405}, {345, 425}, {35, 265}, {100, 315}, {190, 315}, {285, 315}, {100, 205}, {190, 205}, {285, 205}, {345, 265}, {35, 55}, {100, 115}, {190, 115}, {285, 115}, {100, 35}, {190, 30}, {285, 35}, {345, 55}, {470, 30}, {558, 30}, {655, 30}, {755, 30}, {855, 30}, {950, 30}, {470, 105}, {558, 105}, {655, 105}, {755, 105}, {855, 105}};
    private static int[][] RK = new int[][]{{-1, -1}, {190, 565}, {35, 425}, {100, 485}, {190, 485}, {285, 485}, {100, 405}, {190, 405}, {285, 405}, {345, 425}, {35, 270}, {100, 315}, {190, 315}, {285, 315}, {100, 205}, {190, 205}, {285, 205}, {345, 270}, {35, 55}, {100, 115}, {190, 115}, {285, 115}, {100, 35}, {190, 30}, {285, 35}, {345, 55}, {20, 25}, {115, 35}, {20, 125}, {115, 135}, {20, 210}, {115, 220}, {20, 305}, {115, 315}, {20, 400}, {115, 410}, {20, 495}};
    private static int[][] RL = new int[][]{{-1, -1}, {200, 489}, {76, 376}, {135, 422}, {202, 421}, {273, 421}, {131, 356}, {202, 356}, {277, 356}, {328, 377}, {76, 243}, {131, 276}, {199, 276}, {275, 276}, {128, 188}, {201, 188}, {276, 188}, {323, 247}, {68, 62}, {129, 107}, {203, 107}, {276, 107}, {127, 37}, {200, 37}, {280, 37}, {331, 64}, {10, 480}, {10, 400}, {10, 320}, {10, 240}, {10, 160}, {10, 84}, {10, 1}};
    private static int[][] RM;

    public F x() {
        return this.U;
    }

    public void a(F f2) {
        this.U = f2;
    }

    public ImageIcon vf() {
        return this.RC;
    }

    public void h(ImageIcon imageIcon) {
        this.RC = imageIcon;
    }

    public static int S(int n2, int n3) {
        int n4 = 1;
        while (n4 <= 36) {
            if (n2 >= RJ[n4][0] && n2 <= RJ[n4][0] + 60 && n3 >= RJ[n4][1] && n3 <= RJ[n4][1] + 60) {
                return n4;
            }
            ++n4;
        }
        return -1;
    }

    public static int T(int n2, int n3) {
        int n4 = 1;
        while (n4 <= 36) {
            int n5 = RK[n4][0];
            int n6 = RK[n4][1];
            if (n4 <= 25) {
                n5 += 200;
                n6 += 10;
            }
            if (n2 >= n5 && n2 <= n5 + 50 && n3 >= n6 && n3 <= n6 + 50) {
                return n4;
            }
            ++n4;
        }
        return -1;
    }

    public static int U(int n2, int n3) {
        int n4 = 37;
        int n5 = 0;
        while (n5 < RH.size()) {
            if (n2 >= (Integer)RH.get(n5) - 20 && n2 <= (Integer)RH.get(n5) + 70 && n3 >= (Integer)RI.get(n5) && n3 <= (Integer)RI.get(n5) + 80) {
                return n5 + n4;
            }
            ++n5;
        }
        return -1;
    }

    public static boolean V(int n2, int n3) {
        if (n2 >= 0 && n2 <= 434 && n3 >= 0 && n3 <= 640) {
            return true;
        }
        return n2 >= 440 && n2 <= 1020 && n3 >= 20 && n3 <= 180;
    }

    public static boolean W(int n2, int n3) {
        if (n2 >= 200 && n2 <= 640 && n3 >= 0 && n3 <= 650) {
            return true;
        }
        return n2 >= 10 && n2 <= 200 && n3 >= 20 && n3 <= 650;
    }

    public static boolean X(int n2, int n3) {
        return n2 >= RD && n2 <= RD + RF && n3 >= 10 && n3 <= RE + RG;
    }

    public ImageIcon a(ArrayList arrayList, int n2, ImageIcon imageIcon, boolean bl2, int n3, ah ah2, int n4) {
        Image image = this.AH.getImage();
        Image image2 = imageIcon.getImage();
        ImageIcon imageIcon2 = new ImageIcon(this.getClass().getResource("/aeicons/ect.png"));
        Image image3 = imageIcon2.getImage();
        ImageIcon imageIcon3 = new ImageIcon(this.getClass().getResource("/aicons/kicker.png"));
        Image image4 = imageIcon3.getImage();
        ImageIcon imageIcon4 = new ImageIcon(this.getClass().getResource("/aicons/captain.png"));
        Image image5 = imageIcon4.getImage();
        ImageIcon imageIcon5 = new ImageIcon(this.getClass().getResource("/aicons/escanteiosicone.png"));
        Image image6 = imageIcon5.getImage();
        ImageIcon imageIcon6 = new ImageIcon(this.getClass().getResource("/aicons/falsonove.png"));
        Image image7 = imageIcon6.getImage();
        int n5 = 480;
        int n6 = 679;
        if (n4 == 1) {
            n5 = 580;
            n6 = 160;
        }
        if (n4 == 3) {
            n5 = 200;
            n6 = 650;
        }
        if (bl2) {
            n5 = 390;
            n6 = 566;
        }
        BufferedImage bufferedImage = new BufferedImage(n5, n6, 2);
        Graphics2D graphics2D = bufferedImage.createGraphics();
        int n7 = 1;
        int n8 = 25;
        if (n4 == 1 || n4 == 3) {
            n7 = 26;
            n8 = 36;
        }
        int n9 = n7;
        while (n9 <= n8) {
            if (((ao)arrayList.get(n9)).vf() != null && n9 != n2) {
                if (n9 == 1) {
                    image = this.AI.getImage();
                } else if (n9 <= 25) {
                    image = ((ao)arrayList.get(n9)).x() != null ? image2 : this.AH.getImage();
                } else if (n9 > 25) {
                    image = ((ao)arrayList.get(n9)).x() != null ? (((ao)arrayList.get(n9)).x().getPosicao() == 0 ? this.AI.getImage() : image2) : this.AH.getImage();
                }
                int n10 = RJ[n9][0];
                int n11 = RJ[n9][1];
                if (n4 == 1) {
                    n10 = RJ[n9][0] - 450;
                    n11 = RJ[n9][1] - 30;
                }
                if (n4 == 2) {
                    n10 = RJ[n9][0];
                    n11 = RJ[n9][1];
                }
                if (n4 == 3) {
                    n10 = RK[n9][0];
                    n11 = RK[n9][1];
                }
                if (bl2) {
                    n10 = RK[n9][0];
                    n11 = RK[n9][1];
                }
                graphics2D.drawImage(image, n10, n11, null);
                if (((ao)arrayList.get(n9)).x() != null) {
                    int n12;
                    graphics2D.setFont(new Font("Arial", 1, 11));
                    graphics2D.setFont(graphics2D.getFont().deriveFont(11.0f));
                    graphics2D.drawImage(ao.a(((ao)arrayList.get(n9)).x(), 1, n9, ""), n10 - 52, n11 + 47, null);
                    if (((ao)arrayList.get(n9)).x().fP()) {
                        graphics2D.drawImage(image3, n10 - 15, n11 + 30, null);
                    }
                    if (n9 < 26) {
                        if (ah2.ke() == ((ao)arrayList.get(n9)).x()) {
                            graphics2D.drawImage(image4, n10 - 10, n11, null);
                        }
                        n12 = 10;
                        if (ah2.ke() == ah2.kd()) {
                            n12 = 25;
                        }
                        if (ah2.kd() == ((ao)arrayList.get(n9)).x()) {
                            graphics2D.drawImage(image5, n10 - n12, n11, null);
                        }
                        if (ah2.lq() == ((ao)arrayList.get(n9)).x()) {
                            graphics2D.drawImage(image6, n10 + 40, n11 + 20, null);
                        }
                        if (n9 > 14 && n9 != 17 && ah2.lr() == ((ao)arrayList.get(n9)).x()) {
                            graphics2D.drawImage(image7, n10 + 40, n11 + 35, null);
                        }
                    }
                    n12 = 22;
                    int n13 = 20;
                    if (((ao)arrayList.get(n9)).x().fn() > 0) {
                        if (((ao)arrayList.get(n9)).x().fn() > 9) {
                            n12 = 19;
                            n13 = 20;
                        }
                        graphics2D.setColor(Color.WHITE);
                        graphics2D.drawString(Integer.toString(((ao)arrayList.get(n9)).x().fn()), n10 + n12, n11 + n13);
                    }
                }
            }
            ++n9;
        }
        graphics2D.dispose();
        return new ImageIcon(bufferedImage);
    }

    public ImageIcon a(ArrayList arrayList, int n2, ImageIcon imageIcon) {
        int n3;
        Image image = this.AH.getImage();
        Image image2 = imageIcon.getImage();
        BufferedImage bufferedImage = new BufferedImage(RF, RG, 2);
        Graphics2D graphics2D = bufferedImage.createGraphics();
        RH.clear();
        RI.clear();
        int n4 = 20;
        int n5 = 0;
        int n6 = n4;
        int n7 = 0;
        int n8 = 37;
        while (n8 < arrayList.size()) {
            if (((ao)arrayList.get(n8)).vf() != null) {
                Image image3 = ((ao)arrayList.get(n8)).x() != null && ((ao)arrayList.get(n8)).x().getPosicao() == 0 ? this.AI.getImage() : image2;
                if (n8 != n2) {
                    graphics2D.drawImage(image3, n6, n7, 45, 45, null);
                }
                if (((ao)arrayList.get(n8)).x() != null) {
                    graphics2D.drawImage(ao.a(((ao)arrayList.get(n8)).x(), 2, n8, ""), n6 - 53, n7 + 42, null);
                    graphics2D.setFont(new Font("Arial", 1, 11));
                    graphics2D.setFont(graphics2D.getFont().deriveFont(11.0f));
                    graphics2D.setColor(Color.BLACK);
                    graphics2D.drawString(aq.rI[((ao)arrayList.get(n8)).x().getPosicao()], n6, n7 + 39);
                    graphics2D.setColor(Color.WHITE);
                    graphics2D.drawString(aq.rI[((ao)arrayList.get(n8)).x().getPosicao()], n6, n7 + 38);
                    n3 = 20;
                    int n9 = 20;
                    if (((ao)arrayList.get(n8)).x().fn() > 0) {
                        if (((ao)arrayList.get(n8)).x().fn() > 9) {
                            n3 = 17;
                            n9 = 20;
                        }
                        graphics2D.setColor(Color.WHITE);
                        graphics2D.drawString(Integer.toString(((ao)arrayList.get(n8)).x().fn()), n6 + n3, n7 + n9);
                    }
                }
                RH.add(n6 + RD);
                RI.add(n7 + RE);
                n6 += 100;
                if (++n5 == 6) {
                    n5 = 0;
                    n6 = n4;
                    n7 += 88;
                }
            }
            ++n8;
        }
        int[][] nArray = new int[RH.size()][2];
        n3 = 0;
        while (n3 < RH.size()) {
            nArray[n3][0] = (Integer)RH.get(n3);
            nArray[n3][1] = (Integer)RI.get(n3);
            ++n3;
        }
        RM = nArray;
        graphics2D.dispose();
        return new ImageIcon(bufferedImage);
    }

    public static Image a(F f2, int n2, int n3, String string) {
        String string2;
        int n4 = n3 > 25 && n3 <= 36 ? 150 : 150;
        if (f2 == null) {
            return null;
        }
        BufferedImage bufferedImage = new BufferedImage(n4, 40, 2);
        Graphics2D graphics2D = bufferedImage.createGraphics();
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        Font font = new Font("Arial", 1, 11);
        FontMetrics fontMetrics = null;
        Dimension dimension = new Dimension(n4, 40);
        graphics2D.setFont(font);
        if (fontMetrics == null) {
            fontMetrics = graphics2D.getFontMetrics();
            n6 = fontMetrics.getAscent();
            n5 = n6 + fontMetrics.getDescent();
            n7 = fontMetrics.stringWidth(" ");
        }
        StringTokenizer stringTokenizer = new StringTokenizer("");
        boolean bl2 = false;
        if (n2 == 1) {
            string2 = "";
            if (n3 >= 1 && n3 <= 25) {
                string2 = aq.rI[aq.sE[n3][0]];
                if (n3 == 10 || n3 == 17) {
                    string2 = aq.rI[3];
                }
                if (n3 >= 11) {
                    // empty if block
                }
                if (aq.sE[n3][0] != f2.getPosicao()) {
                    bl2 = true;
                    if (!(n3 != 10 && n3 != 17 || f2.getPosicao() != 1 && f2.getPosicao() != 3)) {
                        bl2 = false;
                    }
                    if (bl2) {
                        string2 = String.valueOf(string2) + " (" + aq.rI[f2.getPosicao()] + ") ";
                    }
                }
            } else {
                string2 = aq.rI[f2.getPosicao()];
            }
            string2 = String.valueOf(string2) + " - ";
            stringTokenizer = !a.SR.isHabilidadeIndividual() ? new StringTokenizer(String.valueOf(f2.getNome()) + " <br> " + string2 + "F:" + Integer.toString(f2.fi()) + " E:" + Integer.toString(f2.fp())) : new StringTokenizer(String.valueOf(f2.getNome()) + " <br> " + string2 + " E:" + Integer.toString(f2.fp()));
        } else if (n2 == 2) {
            stringTokenizer = !a.SR.isHabilidadeIndividual() ? new StringTokenizer(String.valueOf(f2.getNome()) + " <br> " + "F:" + Integer.toString(f2.fi()) + " E:" + Integer.toString(f2.fp()) + " L:" + aq.rK[f2.getLado()]) : new StringTokenizer(String.valueOf(f2.getNome()) + " <br> " + " E:" + Integer.toString(f2.fp()) + " L:" + aq.rK[f2.getLado()]);
        } else if (n2 == 3) {
            string2 = "";
            if (n3 >= 1 && n3 <= 25) {
                string2 = aq.rI[aq.sE[n3][0]];
            }
            stringTokenizer = new StringTokenizer(String.valueOf(string2) + " - " + f2.getNome() + " <br> " + string);
        }
        int n8 = 0;
        int n9 = 0;
        int n10 = 0;
        String string3 = "";
        while (stringTokenizer.hasMoreTokens()) {
            String string4 = stringTokenizer.nextToken();
            if (string4.equals("<br>")) {
                ao.a(graphics2D, string3, n10, fontMetrics.stringWidth(string3), n9 + n6, bl2, n4);
                string3 = "";
                n10 = 0;
                n8 = 0;
                n9 += n5;
                continue;
            }
            int n11 = fontMetrics.stringWidth(string4);
            int n12 = n8 + n7 + n11;
            if (n12 > dimension.width) {
                ao.a(graphics2D, string3, n10, fontMetrics.stringWidth(string3), n9 + n6, bl2, n4);
                string3 = "";
                n10 = 0;
                n8 = 0;
                n9 += n5;
            }
            String string5 = n8 != 0 ? " " : "";
            string3 = String.valueOf(string3) + string5 + string4;
            n8 = n8 + n7 + n11;
            ++n10;
        }
        ao.a(graphics2D, string3, n10, fontMetrics.stringWidth(string3), n9 + n6, bl2, n4);
        graphics2D.dispose();
        return bufferedImage;
    }

    public static void a(Graphics2D graphics2D, String string, int n2, int n3, int n4, boolean bl2, int n5) {
        Dimension dimension = new Dimension(n5, 40);
        graphics2D.setColor(Color.BLACK);
        graphics2D.drawString(string, (dimension.width - n3) / 2 + 1, n4 + 1);
        if (bl2) {
            graphics2D.setColor(Color.YELLOW);
        } else {
            graphics2D.setColor(Color.WHITE);
        }
        graphics2D.drawString(string, (dimension.width - n3) / 2, n4);
    }

    public void vg() {
        this.U = null;
        this.cg = null;
        this.RC = null;
    }

    public void ej(int n2) {
        this.U = null;
        if (n2 <= 36) {
            this.RC = this.AH;
        }
    }

    public void vh() {
        this.RC = this.AH;
    }

    public static void a(int[][] nArray) {
        RM = nArray;
    }

    public static int vi() {
        return RD;
    }

    public static int vj() {
        return RE;
    }

    public static ImageIcon i(ImageIcon imageIcon) {
        Image image = imageIcon.getImage();
        BufferedImage bufferedImage = new BufferedImage(40, 40, 2);
        Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.drawImage(image, 0, 0, 40, 40, null);
        graphics2D.setComposite(AlphaComposite.Src);
        return new ImageIcon(bufferedImage);
    }

    public ImageIcon a(ArrayList arrayList, int n2, ImageIcon imageIcon, boolean bl2, int n3, F f2) {
        Image image = this.AH.getImage();
        Image image2 = imageIcon.getImage();
        ImageIcon imageIcon2 = new ImageIcon(this.getClass().getResource("/aicons/bolaouro_s2.png"));
        Image image3 = imageIcon2.getImage();
        int n4 = 480;
        int n5 = 679;
        if (bl2) {
            n4 = 390;
            n5 = 566;
        }
        BufferedImage bufferedImage = new BufferedImage(n4, n5, 2);
        Graphics2D graphics2D = bufferedImage.createGraphics();
        int n6 = 1;
        while (n6 <= 25) {
            if (((ao)arrayList.get(n6)).vf() != null && n6 != n2) {
                if (n6 == 1) {
                    image = this.AI.getImage();
                } else if (n6 <= 25) {
                    image = ((ao)arrayList.get(n6)).x() != null ? ((ao)arrayList.get(n6)).vf().getImage() : this.AH.getImage();
                } else if (n6 > 25) {
                    image = ((ao)arrayList.get(n6)).x() != null ? (((ao)arrayList.get(n6)).x().getPosicao() == 0 ? this.AI.getImage() : image2) : this.AH.getImage();
                }
                int n7 = RJ[n6][0];
                int n8 = RJ[n6][1];
                if (bl2) {
                    n7 = RL[n6][0];
                    n8 = RL[n6][1];
                }
                graphics2D.drawImage(image, n7, n8, null);
                if (((ao)arrayList.get(n6)).x() != null) {
                    String string = "";
                    if (((ao)arrayList.get(n6)).fg() != null) {
                        string = ((ao)arrayList.get(n6)).fg().getNome();
                    }
                    graphics2D.drawImage(ao.a(((ao)arrayList.get(n6)).x(), 3, n6, string), n7 - 50, n8 + 47, null);
                    if (((ao)arrayList.get(n6)).x() == f2) {
                        graphics2D.drawImage(image3, n7 - 20, n8 + 20, null);
                    }
                }
            }
            ++n6;
        }
        graphics2D.dispose();
        return new ImageIcon(bufferedImage);
    }

    public void n(ah ah2) {
        this.cg = ah2;
    }

    public ah fg() {
        return this.cg;
    }
}

