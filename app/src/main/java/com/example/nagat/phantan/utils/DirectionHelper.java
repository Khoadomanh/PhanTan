package com.example.nagat.phantan.utils;


import android.location.Location;
import android.util.Log;

import java.util.ArrayList;

public class DirectionHelper {
    public static MyPoint[] path = {
            new MyPoint(new CustomLatLong(21.005045, 105.845659), new int[]{1}),                        //0
            new MyPoint(new CustomLatLong(21.005057, 105.845359), new int[]{0, 2}),                        //1
            new MyPoint(new CustomLatLong(21.00504, 105.845134), new int[]{1, 3}),                        //2
            new MyPoint(new CustomLatLong(21.00505, 105.844935), new int[]{2, 4}),                        //3
            new MyPoint(new CustomLatLong(21.00505, 105.844747), new int[]{3, 5}),                        //4
            new MyPoint(new CustomLatLong(21.005033, 105.844608), new int[]{4, 6, 23, 123}),                        //5
            new MyPoint(new CustomLatLong(21.005048, 105.844404), new int[]{5, 7}),                        //6
            new MyPoint(new CustomLatLong(21.005033, 105.844195), new int[]{6, 8}),                        //7
            new MyPoint(new CustomLatLong(21.005038, 105.843943), new int[]{7, 9}),                        //8
            new MyPoint(new CustomLatLong(21.005028, 105.843728), new int[]{8, 10, 78, 133}),                        //9
            new MyPoint(new CustomLatLong(21.005038, 105.843578), new int[]{9, 11}),                        //10
            new MyPoint(new CustomLatLong(21.005058, 105.843396), new int[]{10, 12}),                        //11
            new MyPoint(new CustomLatLong(21.005053, 105.843203), new int[]{11, 13}),                        //12
            new MyPoint(new CustomLatLong(21.005048, 105.843036), new int[]{12, 14}),                        //13
            new MyPoint(new CustomLatLong(21.005057, 105.842873), new int[]{13, 15}),                        //14
            new MyPoint(new CustomLatLong(21.005045, 105.842742), new int[]{14, 16}),                        //15
            new MyPoint(new CustomLatLong(21.00507, 105.842511), new int[]{15, 17}),                        //16
            new MyPoint(new CustomLatLong(21.00505, 105.842307), new int[]{16, 18, 115, 148}),                        //17
            new MyPoint(new CustomLatLong(21.00506, 105.842189), new int[]{17, 19}),                        //18
            new MyPoint(new CustomLatLong(21.005065, 105.842066), new int[]{18, 20}),                        //19
            new MyPoint(new CustomLatLong(21.005075, 105.841915), new int[]{19, 21}),                        //20
            new MyPoint(new CustomLatLong(21.005075, 105.841738), new int[]{20, 22}),                        //21
            new MyPoint(new CustomLatLong(21.005095, 105.84154), new int[]{21}),                        //22
            new MyPoint(new CustomLatLong(21.005174, 105.844623), new int[]{5, 24}),                        //23
            new MyPoint(new CustomLatLong(21.005389, 105.844645), new int[]{23, 25}),                        //24
            new MyPoint(new CustomLatLong(21.00554, 105.844645), new int[]{24, 26}),                        //25
            new MyPoint(new CustomLatLong(21.005685, 105.844645), new int[]{25, 27, 35, 36}),                        //26
            new MyPoint(new CustomLatLong(21.005798, 105.84465), new int[]{26, 28}),                        //27
            new MyPoint(new CustomLatLong(21.00598, 105.84465), new int[]{27, 29}),                        //28
            new MyPoint(new CustomLatLong(21.006119, 105.844651), new int[]{28, 30, 46, 47}),                        //29
            new MyPoint(new CustomLatLong(21.006258, 105.84465), new int[]{29, 31}),                        //30
            new MyPoint(new CustomLatLong(21.006395, 105.84465), new int[]{30, 32}),                        //31
            new MyPoint(new CustomLatLong(21.006499, 105.844643), new int[]{31, 54, 61}),                        //32
            new MyPoint(new CustomLatLong(21.005697, 105.845194), new int[]{34}),                        //33
            new MyPoint(new CustomLatLong(21.005692, 105.845028), new int[]{33, 35}),                        //34
            new MyPoint(new CustomLatLong(21.005695, 105.844811), new int[]{34, 26}),                        //35
            new MyPoint(new CustomLatLong(21.005695, 105.844462), new int[]{26, 37}),                        //36
            new MyPoint(new CustomLatLong(21.005692, 105.844237), new int[]{36, 38}),                        //37
            new MyPoint(new CustomLatLong(21.005695, 105.844046), new int[]{37, 39}),                        //38
            new MyPoint(new CustomLatLong(21.00569, 105.843816), new int[]{39, 40}),                        //39
            new MyPoint(new CustomLatLong(21.005777, 105.84381), new int[]{39, 76}),                        //40
            new MyPoint(new CustomLatLong(21.005782, 105.843639), new int[]{76, 42}),                        //41
            new MyPoint(new CustomLatLong(21.005777, 105.84347), new int[]{41, 83, 107}),                        //42
            new MyPoint(new CustomLatLong(21.00611, 105.84528), new int[]{44}),                        //43
            new MyPoint(new CustomLatLong(21.006123, 105.845117), new int[]{43, 45}),                        //44
            new MyPoint(new CustomLatLong(21.006118, 105.844956), new int[]{44, 46}),                        //45
            new MyPoint(new CustomLatLong(21.006121, 105.844789), new int[]{45, 29}),                        //46
            new MyPoint(new CustomLatLong(21.006121, 105.844443), new int[]{29, 48}),                        //47
            new MyPoint(new CustomLatLong(21.006126, 105.844215), new int[]{47, 49}),                        //48
            new MyPoint(new CustomLatLong(21.006126, 105.844012), new int[]{48, 50}),                        //49
            new MyPoint(new CustomLatLong(21.006115, 105.843821), new int[]{49, 51}),                        //50
            new MyPoint(new CustomLatLong(21.006186, 105.843813), new int[]{50, 52}),                        //51
            new MyPoint(new CustomLatLong(21.006193, 105.843644), new int[]{74, 53}),                        //52
            new MyPoint(new CustomLatLong(21.006188, 105.843472), new int[]{52, 107, 106}),                        //53
            new MyPoint(new CustomLatLong(21.006499, 105.844467), new int[]{32, 55}),                        //54
            new MyPoint(new CustomLatLong(21.006504, 105.844237), new int[]{54, 56}),                        //55
            new MyPoint(new CustomLatLong(21.006504, 105.844033), new int[]{55, 57}),                        //56
            new MyPoint(new CustomLatLong(21.006501, 105.843848), new int[]{56, 58}),                        //57
            new MyPoint(new CustomLatLong(21.006579, 105.843834), new int[]{57, 72}),                        //58
            new MyPoint(new CustomLatLong(21.006591, 105.843633), new int[]{72, 60}),                        //59
            new MyPoint(new CustomLatLong(21.006589, 105.843478), new int[]{59, 106, 105}),                        //60
            new MyPoint(new CustomLatLong(21.006672, 105.844628), new int[]{32, 62}),                        //61
            new MyPoint(new CustomLatLong(21.006822, 105.844556), new int[]{61, 63}),                        //62
            new MyPoint(new CustomLatLong(21.006915, 105.844443), new int[]{62, 64}),                        //63
            new MyPoint(new CustomLatLong(21.007025, 105.844256), new int[]{63, 65}),                        //64
            new MyPoint(new CustomLatLong(21.00715, 105.844014), new int[]{64, 66}),                        //65
            new MyPoint(new CustomLatLong(21.007238, 105.843751), new int[]{65, 67, 69}),                        //66
            new MyPoint(new CustomLatLong(21.007263, 105.843432), new int[]{66, 68}),                        //67
            new MyPoint(new CustomLatLong(21.007258, 105.843092), new int[]{67, 79, 85}),                        //68
            new MyPoint(new CustomLatLong(21.007016, 105.843753), new int[]{66, 70, 114}),                        //69
            new MyPoint(new CustomLatLong(21.006886, 105.843758), new int[]{69, 71}),                        //70
            new MyPoint(new CustomLatLong(21.006751, 105.843753), new int[]{70, 72}),                        //71
            new MyPoint(new CustomLatLong(21.006586, 105.843753), new int[]{71, 73, 58, 59}),                        //72
            new MyPoint(new CustomLatLong(21.006393, 105.843753), new int[]{72, 74}),                        //73
            new MyPoint(new CustomLatLong(21.006182, 105.843753), new int[]{73, 75, 51, 52}),                        //74
            new MyPoint(new CustomLatLong(21.005965, 105.843758), new int[]{74, 76}),                        //75
            new MyPoint(new CustomLatLong(21.005784, 105.843755), new int[]{75, 77, 40, 41}),                        //76
            new MyPoint(new CustomLatLong(21.005526, 105.843745), new int[]{76, 78}),                        //77
            new MyPoint(new CustomLatLong(21.005299, 105.843745), new int[]{77, 9}),                        //78
            new MyPoint(new CustomLatLong(21.007024, 105.843091), new int[]{68, 80, 113, 114}),                        //79
            new MyPoint(new CustomLatLong(21.006738, 105.843142), new int[]{79, 81, 104, 105}),                        //80
            new MyPoint(new CustomLatLong(21.00642, 105.843137), new int[]{80, 82, 103, 106}),                        //81
            new MyPoint(new CustomLatLong(21.006082, 105.843145), new int[]{81, 83}),                        //82
            new MyPoint(new CustomLatLong(21.005714, 105.843145), new int[]{82, 84, 42, 101}),                        //83
            new MyPoint(new CustomLatLong(21.005559, 105.843139), new int[]{83, 119, 120}),                        //84
            new MyPoint(new CustomLatLong(21.007242, 105.842878), new int[]{68, 86}),                        //85
            new MyPoint(new CustomLatLong(21.007242, 105.84265), new int[]{85, 87}),                        //86
            new MyPoint(new CustomLatLong(21.007125, 105.842321), new int[]{86, 88}),                        //87
            new MyPoint(new CustomLatLong(21.007042, 105.842028), new int[]{87, 89}),                        //88
            new MyPoint(new CustomLatLong(21.006942, 105.841851), new int[]{88, 90}),                        //89
            new MyPoint(new CustomLatLong(21.006857, 105.84176), new int[]{89, 91}),                        //90
            new MyPoint(new CustomLatLong(21.006629, 105.841757), new int[]{90, 92}),                        //91
            new MyPoint(new CustomLatLong(21.006363, 105.841757), new int[]{91, 93}),                        //92
            new MyPoint(new CustomLatLong(21.006113, 105.841773), new int[]{92, 94}),                        //93
            new MyPoint(new CustomLatLong(21.005893, 105.841763), new int[]{93, 95}),                        //94
            new MyPoint(new CustomLatLong(21.005682, 105.841757), new int[]{94, 96, 98}),                        //95
            new MyPoint(new CustomLatLong(21.005492, 105.841757), new int[]{95, 97}),                        //96
            new MyPoint(new CustomLatLong(21.005302, 105.841752), new int[]{96, 21}),                        //97
            new MyPoint(new CustomLatLong(21.005683, 105.842101), new int[]{95, 99}),                        //98
            new MyPoint(new CustomLatLong(21.005675, 105.842447), new int[]{98, 100, 112}),                        //99
            new MyPoint(new CustomLatLong(21.005678, 105.842642), new int[]{99, 101}),                        //100
            new MyPoint(new CustomLatLong(21.00571, 105.842795), new int[]{100, 102, 83}),                        //101
            new MyPoint(new CustomLatLong(21.006118, 105.842795), new int[]{101, 103}),                        //102
            new MyPoint(new CustomLatLong(21.006416, 105.842803), new int[]{102, 104, 81}),                        //103
            new MyPoint(new CustomLatLong(21.006703, 105.842817), new int[]{103, 80}),                        //104
            new MyPoint(new CustomLatLong(21.006718, 105.843466), new int[]{80, 60}),                        //105
            new MyPoint(new CustomLatLong(21.006398, 105.843479), new int[]{60, 53, 81}),                        //106
            new MyPoint(new CustomLatLong(21.006072, 105.843479), new int[]{53, 42}),                        //107
            new MyPoint(new CustomLatLong(21.007012, 105.842469), new int[]{109, 113}),                        //108
            new MyPoint(new CustomLatLong(21.006731, 105.842458), new int[]{108, 110}),                        //109
            new MyPoint(new CustomLatLong(21.006401, 105.842458), new int[]{109, 111}),                        //110
            new MyPoint(new CustomLatLong(21.00611, 105.842447), new int[]{110, 112}),                        //111
            new MyPoint(new CustomLatLong(21.005885, 105.842453), new int[]{111, 99}),                        //112
            new MyPoint(new CustomLatLong(21.007032, 105.842801), new int[]{108, 79}),                        //113
            new MyPoint(new CustomLatLong(21.007042, 105.843445), new int[]{79, 69}),                        //114
            new MyPoint(new CustomLatLong(21.005119, 105.842372), new int[]{17, 116}),                        //115
            new MyPoint(new CustomLatLong(21.005264, 105.842522), new int[]{115, 117}),                        //116
            new MyPoint(new CustomLatLong(21.005369, 105.84263), new int[]{116, 118}),                        //117
            new MyPoint(new CustomLatLong(21.005525, 105.842796), new int[]{117, 119}),                        //118
            new MyPoint(new CustomLatLong(21.00561, 105.842973), new int[]{118, 84}),                        //119
            new MyPoint(new CustomLatLong(21.005429, 105.843311), new int[]{84, 121}),                        //120
            new MyPoint(new CustomLatLong(21.005289, 105.843456), new int[]{120, 122}),                        //121
            new MyPoint(new CustomLatLong(21.005194, 105.843547), new int[]{121, 9}),                        //122
            new MyPoint(new CustomLatLong(21.004768, 105.844609), new int[]{5, 124}),                        //123
            new MyPoint(new CustomLatLong(21.004623, 105.844609), new int[]{123, 134, 147}),                        //124
            new MyPoint(new CustomLatLong(21.004466, 105.844612), new int[]{124, 126}),                        //125
            new MyPoint(new CustomLatLong(21.004293, 105.844617), new int[]{125, 127}),                        //126
            new MyPoint(new CustomLatLong(21.004148, 105.844601), new int[]{126, 128}),                        //127
            new MyPoint(new CustomLatLong(21.004098, 105.84436), new int[]{127, 129}),                        //128
            new MyPoint(new CustomLatLong(21.0041, 105.844124), new int[]{128, 130}),                        //129
            new MyPoint(new CustomLatLong(21.004115, 105.843928), new int[]{129, 131}),                        //130
            new MyPoint(new CustomLatLong(21.004105, 105.84371), new int[]{130, 132, 144}),                        //131
            new MyPoint(new CustomLatLong(21.004421, 105.843721), new int[]{131, 133, 145}),                        //132
            new MyPoint(new CustomLatLong(21.004729, 105.843732), new int[]{132, 9, 146}),                        //133
            new MyPoint(new CustomLatLong(21.004621, 105.844773), new int[]{124, 135}),                        //134
            new MyPoint(new CustomLatLong(21.004613, 105.84496), new int[]{134, 136}),                        //135
            new MyPoint(new CustomLatLong(21.004608, 105.845135), new int[]{135}),                        //136
            new MyPoint(new CustomLatLong(21.004737, 105.843031), new int[]{13, 138}),                        //137
            new MyPoint(new CustomLatLong(21.004502, 105.843025), new int[]{137, 139, 145}),                        //138
            new MyPoint(new CustomLatLong(21.004127, 105.843006), new int[]{138, 140, 153}),                        //139
            new MyPoint(new CustomLatLong(21.003804, 105.843008), new int[]{139, 141}),                        //140
            new MyPoint(new CustomLatLong(21.003724, 105.843075), new int[]{140, 142}),                        //141
            new MyPoint(new CustomLatLong(21.003694, 105.843357), new int[]{141, 143}),                        //142
            new MyPoint(new CustomLatLong(21.003699, 105.843663), new int[]{142, 144}),                        //143
            new MyPoint(new CustomLatLong(21.003839, 105.843695), new int[]{143, 131}),                        //144
            new MyPoint(new CustomLatLong(21.004472, 105.843373), new int[]{138, 132}),                        //145
            new MyPoint(new CustomLatLong(21.004762, 105.843992), new int[]{133, 147}),                        //146
            new MyPoint(new CustomLatLong(21.004787, 105.844378), new int[]{146, 124}),                        //147
            new MyPoint(new CustomLatLong(21.004762, 105.842297), new int[]{17, 149}),                        //148
            new MyPoint(new CustomLatLong(21.004607, 105.842291), new int[]{148, 150}),                        //149
            new MyPoint(new CustomLatLong(21.004411, 105.842297), new int[]{149, 151}),                        //150
            new MyPoint(new CustomLatLong(21.004146, 105.842308), new int[]{150, 152, 153}),                        //151
            new MyPoint(new CustomLatLong(21.00382, 105.842313), new int[]{151}),                        //152
            new MyPoint(new CustomLatLong(21.004156, 105.842672), new int[]{151, 139})                        //153
    };

    public static double getDistance(CustomLatLong latLng, CustomLatLong latLng1) {
        float[] result = new float[1];
        Location.distanceBetween(latLng.getLat(), latLng.getLog(),
                latLng1.getLat(), latLng1.getLog(),
                result);
        return (double) result[0];
    }
    private static double[][] arr(MyPoint[] myPoints) {
        double a[][];
        int n = myPoints.length;
        a = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (myPoints[i].isContain(j)) {
                    a[i][j] = getDistance(myPoints[i].getCustomLatLong(), myPoints[j].getCustomLatLong());
                } else {
                    a[i][j] = 0;
                }
            }
        }
        return a;
    }
    public static ArrayList<Integer> findDirectionBetweenTwoIndex(int index,int index1) {
        return dijkstra(index,index1);
    }
    public static int[] findPointNearest(CustomLatLong customLatLong, CustomLatLong customLatLong1) {
        int myPoint = -1;
        int myPoint1 = -1;
        //my point la index cua diem gan` nhat voi' nguoi` dung
        // my point 1 la index cua diem gan nhat voi cay muon toi
        for (int i = 0; i < path.length; i++) {
            if (myPoint == -1) {
                myPoint = i;
            } else {
                if (getDistance(customLatLong, path[i].getCustomLatLong())
                        < getDistance(customLatLong, path[myPoint].getCustomLatLong())) {
                    myPoint = i;
                }
            }

            if (myPoint1 == -1) {
                myPoint1 = i;
            } else {
                if (getDistance(customLatLong1, path[i].getCustomLatLong())
                        < getDistance(customLatLong1, path[myPoint1].getCustomLatLong())) {
                    myPoint1 = i;
                }
            }
        }

        return new int[]{myPoint, myPoint1};
    }
    public static ArrayList<Integer> dijkstra(int start, int finish ) {
        int back[], mark[];
        double[] weight;
        int startBegin = start;
        int n = path.length;
        back = new int[n];
        weight = new double[n];
        mark = new int[n];
        double[][] mat = arr(path);
        for (int i = 0; i < n; i++) {
            back[i] = -1;
            mark[i] = 0;
            weight[i] = Double.POSITIVE_INFINITY;
        }
        back[start] = 0;
        weight[start] = 0;
        int connect;
        do {
            connect = -1;
            double min = Double.POSITIVE_INFINITY;
            for (int j = 0; j < n; j++) {
                if (mark[j] == 0) {
                    if (mat[start][j] != 0 &&
                            weight[j] > weight[start] + mat[start][j]) {
                        weight[j] = weight[start] + mat[start][j];
                        back[j] = start;
                    }

                    if (min > weight[j]) {
                        min = weight[j];
                        connect = j;

                    }
                }

            }
            start = connect;
            if (start!= -1) {
                mark[start] = 1;
            }
        } while (connect != -1 && start != finish);
        System.out.println("Khoang cach la " + weight[finish]);
        ArrayList<Integer> index = new ArrayList<>();
        printPath(startBegin, finish, back,index);
        Log.e("khoado",index.toString());
        return index;
    }

    public static void printPath(int start, int finish, int[] back,ArrayList<Integer> list) {
        if (start == finish) {
            list.add(finish);
        } else {
            printPath(start, back[finish], back,list);
            list.add(finish);
        }
    }
}
