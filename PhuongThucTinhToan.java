package Caculator;

import java.util.ArrayList;

public class PhuongThucTinhToan {
    public static int CaculateString(String tamGoc) {
        String tam = tamGoc;
        String[] tamList = new String[tamGoc.length()];
        int j = 0;
        System.out.println("vi tri dau + : " + tam.indexOf("+"));
        if (tamGoc.length() == 1) {
            tamList[0] = tamGoc;
        } else {
            for (int i = 0; i < tamGoc.length() ; i++) {
                if(tam.indexOf("*") == -1 && tam.indexOf("+") == -1 && tam.indexOf("-") == -1 && tam.indexOf("/") == -1){
                    tamList[j] = tam;
                    break;
                }
                if (tam.substring(i, i + 1).equals("+") || tam.substring(i, i + 1).equals("-") ||
                        tam.substring(i, i + 1).equals("*") || tam.substring(i, i + 1).equals("/")) {
                    tamList[j] = tam.substring(0, i);
                    tamList[j + 1] = tam.substring(i, i + 1);
                    j = j + 2;
                    tam = tam.substring(i + 1, tam.length());
                    i = 0;
                    if (tam.length() == 1 ) {
                        tamList[j] = tam;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < tamList.length; i++){
            System.out.println(tamList[i]);
        }
        ArrayList<String> phepTinhList = new ArrayList<String>();
        for (int i = 0;i < tamList.length ; i ++){
            if (tamList[i] != null){
                phepTinhList.add(tamList[i]);
            }
        }
        System.out.println("Mang pheptinhList : ");
        for (int i = 0; i < phepTinhList.size() ; i++){
            System.out.println(phepTinhList.get(i));
        }
        int tich, thuong, tong;
        tich = 0;
        thuong = 0;
        tong = 0;
        if (phepTinhList.size() == 1) {
            return tong = Integer.valueOf(phepTinhList.get(0));
        } else {
            for (int i = 0; i < phepTinhList.size() ; i++) {
                if (phepTinhList.get(i).equals("*")) {
                    tich = Integer.valueOf(phepTinhList.get(i-1)) * Integer.valueOf(phepTinhList.get(i+1));
                    if (i < 2) {
                         if (phepTinhList.get(i+2).equals("/")){
                            tong = tong + tich/ Integer.valueOf(phepTinhList.get(i + 3));
                            System.out.println( "hiếu "+ tich/ Integer.valueOf(phepTinhList.     get(i + 3)));
                            i = i + 4;
                            continue;
                        }
                        tong = tong + tich;
                    }
                    else if (phepTinhList.get(i+2).equals("/")){
                        tong = tong + tich/ Integer.valueOf(phepTinhList.get(i + 3));
                        System.out.println( "hiếu "+ tich/ Integer.valueOf(phepTinhList.get(i + 3)));
                        i = i + 4;
                        continue;
                    }
                    else {
                        if (phepTinhList.get(i-2).equals("+")) {
                            tong = tong + tich;
                        }
                        else {
                            tong = tong - tich;
                        }
                    }
                } else if (phepTinhList.get(i).equals("/")) {
                    thuong = Integer.valueOf(phepTinhList.get(i-1)) / Integer.valueOf(phepTinhList.get(i+1));
                    if (i < 2) {
                        tong = tong + thuong;
                    } else {
                        if (phepTinhList.get(i-2).equals("+")) {
                            tong = tong + thuong;
                        } else {
                            tong = tong - thuong;
                        }
                    }
                    System.out.println("Thuong : " + thuong);
                }
                System.out.println("Tich" + tich);
                thuong = 0;
                tich = 0;

                if (i < phepTinhList.size() - 1) {
                    if (i == 0 && phepTinhList.get(i+1).equals("+") || phepTinhList.get(i+1).equals("-")) {
                        tong = tong + Integer.valueOf(phepTinhList.get(i));
                    }
                }
                if (i > 0) {
                    if (i == phepTinhList.size() - 1 && phepTinhList.get(i-1).equals("+")) {
                        tong = tong + Integer.valueOf(phepTinhList.get(i));
                    } else if (i == phepTinhList.size() - 1 && phepTinhList.get(i-1).equals("-")) {
                        tong = tong - Integer.valueOf(phepTinhList.get(i));
                    }
                      else if (phepTinhList.get(i-1).equals("+") && (phepTinhList.get(i+1).equals("+") || phepTinhList.get(i+1).equals("-"))) {
                        tong = tong + Integer.valueOf(phepTinhList.get(i));
                    } else if (phepTinhList.get(i-1).equals("-") && (phepTinhList.get(i+1).equals("+") || phepTinhList.get(i+1).equals("-"))) {
                        tong = tong - Integer.valueOf(phepTinhList.get(i));
                    }
                }
            }




        }
        return tong;
    }

    public static void main(String[] args) {
        System.out.println("kết quả : " + CaculateString("5+6*3/2"));
    }
}