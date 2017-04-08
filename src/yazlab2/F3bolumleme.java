package yazlab2;

public class F3bolumleme extends Thread{
    int [] f3 = new int[306];
    int [] f4 = new int[306];
    int sayac;
    int beseksi     =0;
    int besarti     =0;
    int beseksiGain1=0;
    int beseksiGain2=0;
    int besartiGain1=0;
    int besartiGain2=0;
        
    int oneksi      =0;
    int onarti      =0;
    int oneksiGain1=0;
    int oneksiGain2=0;
    int onartiGain1=0;
    int onartiGain2=0;

    int ondokuzeksi   =0;
    int ondokuzarti   =0;
    int ondokuzeksiGain1=0;
    int ondokuzeksiGain2=0;
    int ondokuzartiGain1=0;
    int ondokuzartiGain2=0;
    
    String [] f3etiket = new String[306];
    YazLab2 hesapla = new YazLab2();
    
    static float f3sonuc = 0;
    static float ilkPart;
    static float ikinciPart;
    static float bestoplam;
    static float ontoplam;
    static float ondokuztoplam;
    
    public F3bolumleme(int [] f3,int[] f4,int sayac){
        this.f3 = f3;
        this.f4 = f4;
        this.sayac=sayac;
    }
    
    
    public void run(){
        
        for (int i =0 ; i<sayac;i++){
            if(f3[i] < 5){
                beseksi++;
                if(f4[i]==1){
                    beseksiGain1++;
                }
                else if(f4[i]==2){
                    beseksiGain2++;
                }
            }
            if(f3[i] >= 5){
                besarti++;
                if(f4[i]==1){
                    besartiGain1++;
                }
                else if(f4[i]==2){
                    besartiGain2++;
                }
            }
        }
        
        for (int i =0 ; i<sayac;i++){
            if(f3[i] < 10){
                oneksi++;
                if(f4[i]==1){
                    oneksiGain1++;
                }
                else if(f4[i]==2){
                    oneksiGain2++;
                }
            }
            if(f3[i] >= 10){
                onarti++;
                if(f4[i]==1){
                    onartiGain1++;
                }
                else if(f4[i]==2){
                    onartiGain2++;
                }
            }
        }
        
        for (int i =0 ; i<sayac;i++){
            if(f3[i] < 19){
                ondokuzeksi++;
                if(f4[i]==1){
                    ondokuzeksiGain1++;
                }
                else if(f4[i]==2){
                    ondokuzeksiGain2++;
                }
            }
            if(f3[i] >= 19){
                ondokuzarti++;
                if(f4[i]==1){
                    ondokuzartiGain1++;
                }
                else if(f4[i]==2){
                    ondokuzartiGain2++;
                }
            }
        }
        
        ilkPart = (((float)beseksi/sayac)*hesapla.gainHesapla(beseksiGain1,beseksiGain2));
        ikinciPart = (((float)besarti/sayac)*hesapla.gainHesapla(besartiGain1,besartiGain2));
        bestoplam = ilkPart + ikinciPart;
        
        ilkPart = (((float)oneksi/sayac)*hesapla.gainHesapla(oneksiGain1,oneksiGain2));
        ikinciPart = (((float)onarti/sayac)*hesapla.gainHesapla(onartiGain1,onartiGain2));
        ontoplam = ilkPart + ikinciPart;
        
        ilkPart = (((float)ondokuzeksi/sayac)*hesapla.gainHesapla(ondokuzeksiGain1,ondokuzeksiGain2));
        ikinciPart = (((float)ondokuzarti/sayac)*hesapla.gainHesapla(ondokuzartiGain1,ondokuzartiGain2));
        ondokuztoplam = ilkPart + ikinciPart;
        
        float besx;
        float onx;
        float ondokuzx;
        
        besx = hesapla.genelGain - bestoplam;
        onx = hesapla.genelGain - ontoplam;
        ondokuzx = hesapla.genelGain -ondokuztoplam;
        
        f3sonuc = hesapla.hangisiBuyuk(besx,onx,ondokuzx);
        if(f3sonuc==besx){
            f3etiket = hesapla.f3etiketle(f3,5);
            System.out.println("f3'de en iyisi 5 : " + f3sonuc);
        }
        if(f3sonuc==onx){
            f3etiket = hesapla.f3etiketle(f3,10);
            System.out.println("f3'de en iyisi 10 : " + f3sonuc);
        }
        if(f3sonuc==ondokuzx){
            f3etiket = hesapla.f3etiketle(f3,19);
            System.out.println("f3'de en iyisi 19 : " + f3sonuc);
        }
    }
}
