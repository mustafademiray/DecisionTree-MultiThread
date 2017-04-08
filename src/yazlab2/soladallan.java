package yazlab2;

public class soladallan  extends Thread{
    static float f1mi=0;
    static float f2mi=0;
    static int birSayac=0;
    static int ikiSayac=0;
    static int eksikKucukBir=0;
    static int eksikKucukIki=0;
    static int eksikBuyukBir=0;
    static int eksikBuyukIki=0;
    static int eksikAzBir=0;
    static int eksikAzIki=0;
    static int eksikCokBir=0;
    static int eksikCokIki=0;
    F1bolumleme f1 = new F1bolumleme();
    YazLab2 nesne = new YazLab2();
    @Override
    public void run(){
       f1.start();
            try {
                f1.join();
            } catch (InterruptedException ex) {
            }
       cocukBul(nesne.etiketler); 
        
    }
    
   
    public float cocukBul(String [][] etiketler){
        
        
        for (int i = 0; i < etiketler.length; i++) {
           if(etiketler[i][2].equals("eksik"))
           {
               if(etiketler[i][3].equals("1")){
                   birSayac++;
               }
               else if(etiketler[i][3].equals("2")){
                   ikiSayac++;
               }
               if(etiketler[i][0].equals("kucuk"))
               {
                   if(etiketler[i][3].equals("1"))
                   {
                       
                       eksikKucukBir++; 
                   }
                   if(etiketler[i][3].equals("2"))
                   {
                       eksikKucukIki++; 
                   }      
               }
               if(etiketler[i][0].equals("buyuk"))
               {
                   if(etiketler[i][3].equals("1"))
                   {
                       eksikBuyukBir++; 
                   }
                   if(etiketler[i][3].equals("2"))
                   {
                       eksikBuyukIki++; 
                   }      
               }
               if(etiketler[i][1].equals("az"))
               {
                   if(etiketler[i][3].equals("1"))
                   {
                       eksikAzBir++; 
                   }
                   if(etiketler[i][3].equals("2"))
                   {
                       eksikAzIki++; 
                   }      
               }
               if(etiketler[i][1].equals("cok"))
               {
                   if(etiketler[i][3].equals("1"))
                   {
                       eksikCokBir++; 
                   }
                   if(etiketler[i][3].equals("2"))
                   {
                       eksikCokIki++; 
                   }      
               }
           }
        }     
        int total=birSayac+ikiSayac;
        int kucukz=eksikKucukBir+eksikKucukIki;
        int buyukz=eksikBuyukBir+eksikBuyukIki;
        int eksikazz=eksikAzBir+eksikAzIki;
        int eksikcokz=eksikCokBir+eksikCokIki;
        float H =nesne.gainHesapla(birSayac, ikiSayac);
         
        float h1=nesne.karsilastir(kucukz, eksikKucukBir, eksikKucukIki, total)+ 
                nesne.karsilastir(buyukz, eksikBuyukBir, eksikBuyukIki, total);
        f1mi=H-h1;
        float h2=nesne.karsilastir(eksikazz, eksikAzBir, eksikAzIki, total)+ 
                nesne.karsilastir(eksikcokz, eksikCokBir, eksikCokIki, total);
        f2mi=H-h2;
        if(f1mi>f2mi){
            YazLab2.tree.solYazdir(YazLab2.treeRoot, f1mi, eksikKucukBir, eksikKucukIki);
            System.out.println("f1 sol ");
             return f1mi; 
        }
          
        else{
            YazLab2.tree.solYazdir(YazLab2.treeRoot, f2mi, 1, 2);
            System.out.println("f2 sol");
            return  f2mi;
        }
    }
}