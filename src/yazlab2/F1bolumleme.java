package yazlab2;

public class F1bolumleme extends Thread{
    int sayac;
    int [] f1 = new int[306];
    int [] f4 = new int[306];
    int ellieksi=0;
    int elliarti=0;
    int ellieksiGain1=0;
    int ellieksiGain2=0;
    int elliartiGain1=0;
    int elliartiGain2=0;
    
    int atmiseksi=0;
    int atmisarti=0;
    int atmiseksiGain1=0;
    int atmiseksiGain2=0;
    int atmisartiGain1=0;
    int atmisartiGain2=0;
    
    int yetmiseksi=0;
    int yetmisarti=0;
    int yetmiseksiGain1=0;
    int yetmiseksiGain2=0;
    int yetmisartiGain1=0;
    int yetmisartiGain2=0;
    static float f1sonuc = 0;
    
    int j = 0;
    String [] f1etiket = new String[306];
    YazLab2 hesapla = new YazLab2();
    static float ilkPart;
    static float ikinciPart;
    static float ellitoplam;
    static float atmistoplam;
    static float yetmistoplam;
    static float ellix;
    static float atmisx;
    static float yetmisx;
    
    public F1bolumleme(){
        
    }
    
    public F1bolumleme(int [] f1, int [] f4, int sayac){
        this.f1=f1;
        this.f4=f4;
        this.sayac=sayac;
    }
    
    @Override
    public void run(){
        for (int i =0 ; i<sayac;i++){
            if(f1[i] < 50){
                ellieksi++;
                if(f4[i]==1){
                    ellieksiGain1++;
                }
                else if(f4[i]==2){
                    ellieksiGain2++;
                }
            }
            if(f1[i] >= 50){
                elliarti++;
                if(f4[i]==1){
                    elliartiGain1++;
                }
                else if(f4[i]==2){
                    elliartiGain2++;
                }
            }
        }
        for (int i =0 ; i<sayac;i++){
            if(f1[i] < 60){
                atmiseksi++;
                if(f4[i]==1){
                    atmiseksiGain1++;
                }
                else if(f4[i]==2){
                    atmiseksiGain2++;
                }
            }
            if(f1[i] >= 60){
                atmisarti++;
                if(f4[i]==1){
                    atmisartiGain1++;
                }
                else if(f4[i]==2){
                    atmisartiGain2++;
                }
            }
        }
        for (int i =0 ; i<sayac;i++){
            if(f1[i] < 70){
                yetmiseksi++;
                if(f4[i]==1){
                    yetmiseksiGain1++;
                }
                else if(f4[i]==2){
                    yetmiseksiGain2++;
                }
            }
            if(f1[i] >= 70){
                yetmisarti++;
                if(f4[i]==1){
                    yetmisartiGain1++;
                }
                else if(f4[i]==2){
                    yetmisartiGain2++;
                }
            }
        }
        
        ilkPart = (((float)ellieksi/sayac)*hesapla.gainHesapla(ellieksiGain1,ellieksiGain2));
        ikinciPart = (((float)elliarti/sayac)*hesapla.gainHesapla(elliartiGain1,elliartiGain2));
        ellitoplam = ilkPart+ ikinciPart;
        
        
        ilkPart = (((float)atmiseksi/sayac)*hesapla.gainHesapla(atmiseksiGain1,atmiseksiGain2));
        ikinciPart = (((float)atmisarti/sayac)*hesapla.gainHesapla(atmisartiGain1,atmisartiGain2));
        atmistoplam = ilkPart + ikinciPart;
        
        ilkPart = (((float)yetmiseksi/sayac)*hesapla.gainHesapla(yetmiseksiGain1,yetmiseksiGain2));
        ikinciPart = (((float)yetmisarti/sayac)*hesapla.gainHesapla(yetmisartiGain1,yetmisartiGain2));
        yetmistoplam = ilkPart + ikinciPart;
        
        ellix = hesapla.genelGain - ellitoplam;
        atmisx = hesapla.genelGain - atmistoplam;
        yetmisx = hesapla.genelGain -yetmistoplam;
        
        f1sonuc = hesapla.hangisiBuyuk(ellix,atmisx,yetmisx); 
        
        if(f1sonuc==ellix){
            f1etiket = hesapla.f1etiketle(f1,50);
            System.out.println("f1'de en iyisi 50 : " + f1sonuc);
        }
        if(f1sonuc==atmisx){
            f1etiket = hesapla.f1etiketle(f1,60);
            System.out.println("f1'de en iyisi 60 : " + f1sonuc);
        }
        if(f1sonuc==yetmisx){
            f1etiket = hesapla.f1etiketle(f1,70);
            System.out.println("f1'de en iyisi 70 : " + f1sonuc);
        }
    }
}
