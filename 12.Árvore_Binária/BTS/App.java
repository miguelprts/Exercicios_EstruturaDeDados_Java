public class App {
    
    public static void main(String[] args) throws Exception {
        BSTree bst = new BSTree();
        bst.inserir(bst.raiz, 50);
        bst.inserir(bst.raiz, 100);
        bst.inserir(bst.raiz, 30);
        bst.inserir(bst.raiz, 40);
        bst.inserir(bst.raiz, 20);
        bst.inserir(bst.raiz, 35);
        bst.inserir(bst.raiz, 37);
        bst.inserir(bst.raiz, 45);
        bst.inOrdem(bst.raiz);
        System.out.println();
        bst.preOrdem(bst.raiz);
        System.out.println();
        bst.posOrdem(bst.raiz);
        System.out.println();
        bst.remover(30);
        System.out.println("--------------");
        bst.inOrdem(bst.raiz);
        System.out.println();
        bst.preOrdem(bst.raiz);
        System.out.println();
        bst.posOrdem(bst.raiz);
        System.out.println();
    }
}
