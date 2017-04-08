package yazlab2;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;

public class YazLab2 {
    static float genelGain;
    static int j;
    static String [] f1etiket = new String[306];
    static String [] f2etiket = new String[306];
    static String [] f3etiket = new String[306];
    
    public static Tree tree;
    public static Tree.Dugum treeRoot;
   
    public static String [][] etiketler = new String[306][4];
    
    public static void main(String[] args) throws InterruptedException {
        
        tree = new Tree();
        soladallan soladallan = new soladallan();
        sagadallan sagadallan = new sagadallan();
        String[] nextLine;
        int[][] cancer = new int[306][4];
        int i;
        int birEntropi=0,ikiEntropi=0;
        
        try{
            CSVReader reader = new CSVReader(new FileReader("C:\\Users\\musty\\Desktop\\Yaz_Lab_II_Proje_II\\haberman.txt"));
            while((nextLine = reader.readNext()) != null){
                for(
                        i = 0; i < nextLine.length ;i++){
                    cancer[j][i] = Integer.parseInt(nextLine[i]);
                }
                j++;
            }
        } 
        catch (IOException e){
        }
        int [] f1 = new int[j];
        int [] f2 = new int[j];
        int [] f3 = new int[j];
        int [] f4 = new int[j];
        
        for (i = 0; i < j; i++) {
                f1[i]=cancer[i][0];
                f2[i]=cancer[i][1];
                f3[i]=cancer[i][2];
                f4[i]=cancer[i][3];
            }
        
        for (int k = 0; k < j; k++) {
            if(f4[k]>1){
                ikiEntropi++;
            }
            else{
                birEntropi++;
            }
        }
        F1bolumleme f1bolumle = new F1bolumleme(f1,f4,j);
        F2bolumleme f2bolumle = new F2bolumleme(f2,f4,j);
        F3bolumleme f3bolumle = new F3bolumleme(f3,f4,j);
        genelGain = gainHesapla(birEntropi,ikiEntropi);
        f1bolumle.setPriority(Thread.MAX_PRIORITY);  
        f2bolumle.setPriority(Thread.MAX_PRIORITY);  
        f3bolumle.setPriority(Thread.MAX_PRIORITY);  
        
        f1bolumle.start();
        f2bolumle.start();
        f3bolumle.start();
        f1bolumle.join();
        f2bolumle.join();
        f3bolumle.join();
        
        treeRoot = new Tree.Dugum(hangisiBuyuk(f1bolumle.f1sonuc,f2bolumle.f2sonuc,f3bolumle.f3sonuc), 1, 1);
        f1etiket = f1bolumle.f1etiket;
        f2etiket = f2bolumle.f2etiket;
        f3etiket = f3bolumle.f3etiket;
        
        for (int k = 0; k < j; k++) {
            etiketler[k][0] = f1etiket[k];
            etiketler[k][1] = f2etiket[k];
            etiketler[k][2] = f3etiket[k];
            etiketler[k][3] = Integer.toString(f4[k]);
        }
        soladallan.start();
        sagadallan.start();
        tree.dugumYazdir(treeRoot);
    }
    
    
    public static void etiketYazdir(String [] x, String [] y, String [] z){
        for (int i = 0; i < 306; i++) {
            System.out.println(x[i] + " " + y[i]+ " " + z[i]);
        }
    }
    
    public static float hangisiBuyuk(float x, float y, float z){
        float a = 0;
        if (x>y){
            if(x>z){
                a=x;
            }
            else{
                a=z;
            }
        }
        else if(y>x){
            a=y;
            if(y>z){
                a=y;
            }
            else{
                a=z;
            }
        }
        return a;
    }
    
    public static String[] f1etiketle(int [] x, int y){
        String [] temp = new String [306];
        for (int i = 0; i < 306; i++) {
            if(x[i]<y ){
                temp[i]="kucuk";
            }
            if(x[i]>=y ){
                temp[i]="buyuk";
            }
        }
        return temp;
    }
    
    public static String[] f2etiketle(int [] x, int y){
        String [] temp = new String [306];
        for (int i = 0; i < 306; i++) {
            if(x[i]<y ){
                temp[i]="az";
            }
            if(x[i]>=y ){
                temp[i]="cok";
            }
        }
        return temp;
    }
    
    public static String[] f3etiketle(int [] x, int y){
        String [] temp = new String [306];
        for (int i = 0; i < 306; i++) {
            if(x[i]<y ){
                temp[i]="eksik";
            }
            if(x[i]>=y ){
                temp[i]="fazla";
            }
        }
        return temp;
    }
    
    public static float gainHesapla(int x , int y){
        double ilk=((Math.log10(x)/Math.log10(2))-(Math.log10(x+y)/Math.log10(2)));
        float a=(float) (((float)x/(x+y))*ilk);
        double son=((Math.log10(y)/Math.log10(2))-(Math.log10(x+y)/Math.log10(2)));
        float b=(float) (((float)y/(x+y))*son);
        return (float) -1*(a+b);
    }
    
    public float karsilastir(int alt,int bir,int iki, int count){
        double ilk=((Math.log10(bir)/Math.log10(2))-(Math.log10(alt)/Math.log10(2)));
        float a=(float) (((float)bir/alt)*ilk);
        double son=((Math.log10(iki)/Math.log10(2))-(Math.log10(alt)/Math.log10(2)));
        float b=(float) (((float)iki/alt)*son);
        return (float) -(((float)alt/count)*(a+b));
    }
}