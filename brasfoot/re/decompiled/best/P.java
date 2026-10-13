/*
 * Decompiled with CFR 0.152.
 */
package best;

import best.Q;
import best.W;
import best.ah;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class P {
    public static void iD() {
        File file = new File(String.valueOf(System.getProperty("user.dir")) + "/teams2");
        File[] fileArray = file.listFiles(new Q());
        int n2 = 0;
        while (n2 < fileArray.length) {
            if (fileArray[n2].isFile()) {
                String string = fileArray[n2].getName();
                string = string.substring(0, string.lastIndexOf("."));
                try {
                    P.a(fileArray[n2].getPath(), string);
                }
                catch (ParserConfigurationException parserConfigurationException) {
                    parserConfigurationException.printStackTrace();
                }
                catch (SAXException sAXException) {
                    sAXException.printStackTrace();
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
            }
            ++n2;
        }
    }

    public static void a(String string, String string2) {
        String string3 = null;
        String string4 = null;
        int n2 = 0;
        int n3 = 0;
        String string5 = null;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        int n8 = 0;
        Color color = null;
        Color color2 = null;
        Boolean bl2 = false;
        int n9 = 0;
        int n10 = 0;
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(string);
        Element element = document.getDocumentElement();
        string3 = P.a(element, "n");
        n2 = Integer.parseInt(P.a(element, "p"));
        n3 = Integer.parseInt(P.a(element, "nv"));
        string5 = P.a(element, "e");
        n4 = Integer.parseInt(P.a(element, "ec"));
        string4 = P.a(element, "t");
        n5 = Integer.parseInt(P.a(element, "es"));
        n6 = Integer.parseInt(P.a(element, "r"));
        n7 = Integer.parseInt(P.a(element, "cb"));
        n8 = Integer.parseInt(P.a(element, "id"));
        color = Color.decode("#" + P.a(element, "cf"));
        color2 = Color.decode("#" + P.a(element, "ct"));
        String string6 = string2;
        if (string3 != "0" && string4 != "0" && string6 != null) {
            bl2 = true;
        }
        if (bl2.booleanValue()) {
            NodeList nodeList = element.getElementsByTagName("jog");
            ArrayList<W> arrayList = new ArrayList<W>();
            if (nodeList.getLength() > 0) {
                int n11 = 0;
                while (n11 < nodeList.getLength()) {
                    Element element2 = (Element)nodeList.item(n11);
                    if (P.a(element2, "no") != "0") {
                        W w2 = new W();
                        w2.dm = P.a(element2, "no");
                        w2.em = Integer.parseInt(P.a(element2, "i"));
                        w2.hk = Integer.parseInt(P.a(element2, "t"));
                        w2.hl = Integer.parseInt(P.a(element2, "s"));
                        w2.en = Integer.parseInt(P.a(element2, "p"));
                        w2.pais = Integer.parseInt(P.a(element2, "pa"));
                        w2.er = Integer.parseInt(P.a(element2, "l"));
                        w2.hn = Integer.parseInt(P.a(element2, "c1"));
                        w2.ho = Integer.parseInt(P.a(element2, "c2"));
                        w2.hp = Integer.parseInt(P.a(element2, "ju"));
                        w2.es = Integer.parseInt(P.a(element2, "tl"));
                        arrayList.add(w2);
                    }
                    ++n11;
                }
                if (arrayList.size() > 0) {
                    n11 = 0;
                    while (n11 < arrayList.size()) {
                        if (((W)arrayList.get((int)n11)).hp == 0) {
                            if (((W)arrayList.get((int)n11)).en == 0) {
                                ++n10;
                            } else {
                                ++n9;
                            }
                        }
                        ++n11;
                    }
                }
            }
            if (n10 <= 0 || n9 < 12) {
                bl2 = false;
            }
            if (bl2.booleanValue()) {
                new ah(string3, string2, n8, n2, n5, n3, string4, n6, color, color2, string5, n4, arrayList, false);
            }
        }
    }

    public static String a(Element element, String string) {
        if (element.getElementsByTagName(string).getLength() == 0) {
            return "0";
        }
        if (element.getElementsByTagName(string).item(0).getChildNodes().getLength() == 0) {
            return "0";
        }
        NodeList nodeList = element.getElementsByTagName(string);
        if (nodeList == null) {
            return "0";
        }
        Element element2 = (Element)nodeList.item(0);
        if (element2 == null) {
            return "0";
        }
        Node node = element2.getFirstChild();
        return node.getNodeValue();
    }
}

