package yazlab2;

public class Tree {
    sagadallan nesne2 = new sagadallan();
    soladallan nesne1 = new soladallan();
    static class Dugum {
    public Dugum left;
    public Dugum right;
    public float value;
    public int a;
    public int b;

    public Dugum(float value, int a, int b) {
      this.value = value;
      this.a = a;
    }
  }

  public  void solYazdir(Dugum node, float value, int par1, int par2) {
      if (node.left != null) {
        solYazdir(node.left, value, par1, par2);
          
      } else {
          System.out.println(node.value +" 'nın soluna " + value + " eklendi ");
          System.out.println("solun solu 1 sayisi: " + nesne1.eksikKucukBir + "\n" +  " 2 sayisi: " + nesne1.eksikKucukIki);
          System.out.println("solun sagi 1 sayisi: " + nesne1.eksikBuyukBir + "\n" + " 2 sayisi: " + nesne1.eksikBuyukIki);
        node.left = new Dugum(value, par1, par2);
      }
  }
  
  public void sagYazdir(Dugum node, float value,int par1, int par2) {
      if (node.right != null) {
        sagYazdir(node.right, value, par1, par2);
      } else {
        System.out.println(node.value +" 'nın sagina " + value + " eklendi ");
        System.out.println("sagin solu 1 sayisi: " + nesne2.fazlaAzBir + "\n" + " 2 sayisi: " + nesne2.fazlaAzIki);
        System.out.println("sagın sagi 1 sayisi: " + nesne2.fazlaCokBir + "\n" + " 2 sayisi: " + nesne2.fazlaCokIki);
        node.right = new Dugum(value, par1, par2);
      }
  }
  
  public void dugumYazdir(Dugum node) {
    if (node != null) {
      dugumYazdir(node.left);
      System.out.println( "entropisi " + node.value + " olan koke yerleştirildi "  );
      dugumYazdir(node.right);
    }
  }
}