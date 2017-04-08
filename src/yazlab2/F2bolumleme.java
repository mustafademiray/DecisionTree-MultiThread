package yazlab2;

public class F2bolumleme extends Thread{
    int [] f2 = new int[306];
    int [] f4 = new int[306];
    int sayac;
    int atmisikieksi=0;
    int atmisikiarti=0;
    int atmisikieksiGain1=0;
    int atmisikieksiGain2=0;
    int atmisikiartiGain1=0;
    int atmisikiartiGain2=0;
    
    int atmisuceksi    =0;
    int atmisucarti    =0;
    int atmisuceksiGain1=0;
    int atmisuceksiGain2=0;
    int atmisucartiGain1=0;
    int atmisucartiGain2=0;
    
    int atmisdorteksi  =0;
    int atmisdortarti  =0;
    int atmisdorteksiGain1=0;
    int atmisdorteksiGain2=0;
    int atmisdortartiGain1=0;
    int atmisdortartiGain2=0;
    
    String [] f2etiket = new String[306];
    YazLab2 hesapla = new YazLab2();
    
    static float f2sonuc = 0;
    static float ilkPart;
    static float ikinciPart;
    static float atmisikitoplam;
    static float atmisuctoplam;
    static float atmisdorttoplam;
    
    public F2bolumleme(int [] f2, int[] f4, int sayac){
        this.f2=f2;
        this.f4=f4;      
        this.sayac=sayac;
    }
    
    @Override
    public void run(){
       for (int i =0 ; i<sayac;i++){
            if(f2[i] < 62){
                atmisikieksi++;
                if(f4[i]==1){
                    atmisikieksiGain1++;
                }
                else if(f4[i]==2){
                    atmisikieksiGain2++;
                }
            }
            if(f2[i] >= 62){
                atmisikiarti++;
                if(f4[i]==1){
                    atmisikiartiGain1++;
                }
                else if(f4[i]==2){
                    atmisikiartiGain2++;
                }
            }
        }
       
       for (int i =0 ; i<sayac;i++){
            if(f2[i] < 63){
                atmisuceksi++;
                if(f4[i]==1){
                    atmisuceksiGain1++;
                }
                else if(f4[i]==2){
                    atmisuceksiGain2++;
                }
            }
            if(f2[i]  >= 63){
                atmisucarti++;
                if(f4[i]==1){
                    atmisucartiGain1++;
                }
                else if(f4[i]==2){
                    atmisucartiGain2++;
                }
            }
        }
       
       for (int i =0 ; i<sayac;i++){
            if(f2[i] < 64){
                atmisdorteksi++;
                if(f4[i]==1){
                    atmisdorteksiGain1++;
                }
                else if(f4[i]==2){
                    atmisdorteksiGain2++;
                }
            }
            if(f2[i] >= 64){
                atmisdortarti++;
                if(f4[i]==1){
                    atmisdortartiGain1++;
                }
                else if(f4[i]==2){
                    atmisdortartiGain2++;
                }
            }
        }
       
        ilkPart = (((float)atmisikieksi/sayac)*hesapla.gainHesapla(atmisikieksiGain1,atmisikieksiGain2));
        ikinciPart = (((float)atmisikiarti/sayac)*hesapla.gainHesapla(atmisikiartiGain1,atmisikiartiGain2));
        atmisikitoplam = ilkPart + ikinciPart;
        
        ilkPart = (((float)atmisuceksi/sayac)*hesapla.gainHesapla(atmisuceksiGain1,atmisuceksiGain2));
        ikinciPart = (((float)atmisucarti/sayac)*hesapla.gainHesapla(atmisucartiGain1,atmisucartiGain2));
        atmisuctoplam = ilkPart + ikinciPart;
        
        ilkPart = (((float)atmisdorteksi/sayac)*hesapla.gainHesapla(atmisdorteksiGain1,atmisdorteksiGain2));
        ikinciPart = (((float)atmisdortarti/sayac)*hesapla.gainHesapla(atmisdortartiGain1,atmisdortartiGain2));
        atmisdorttoplam = ilkPart + ikinciPart;
        
        float atmisikix;
        float atmisucx;
        float atmisdortx;
        
        atmisikix = hesapla.genelGain - atmisikitoplam;
        atmisucx = hesapla.genelGain - atmisuctoplam;
        atmisdortx = hesapla.genelGain -atmisdorttoplam;
        
        f2sonuc = hesapla.hangisiBuyuk(atmisikix,atmisucx,atmisdortx);
        if(f2sonuc==atmisikix){
            f2etiket = hesapla.f2etiketle(f2,62);
            System.out.println("f2'de en iyisi 62 : " + f2sonuc);
        }
        if(f2sonuc==atmisucx){
            f2etiket = hesapla.f2etiketle(f2,63);
            System.out.println("f2'de en iyisi 63 : " + f2sonuc);
        }
        if(f2sonuc==atmisdortx){
            f2etiket = hesapla.f2etiketle(f2,64);
            System.out.println("f2'de en iyisi 64 : " + f2sonuc);
        }
    }
}
