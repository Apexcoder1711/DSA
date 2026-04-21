

public class linearSearch {
    public static int indexSearch(int numbers[],int key){
        for(int i=0; i<numbers.length;i++){
            if (numbers[i]==key) {
                return i;
            }
        }
        return -1;
    }

    public static int menuIndexSearch(String menu[], String key2){
        for(int i=0;i<menu.length;i++){
            if (menu[i]==key2) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int numbers[]={2,4,6,8,10,12,14};
        int key= 10;

        int index=indexSearch(numbers, key);

        if (index==-1) {
            System.out.println("NOT FOUND");
        }
        else{
            System.out.println("index key is = " + index);
        }


        String menu[]={"samosa", "dosa" , "idli", "paneer"}; 
        String key2="idli"; 





        int indexMenu= menuIndexSearch(menu, key2);
        if (indexMenu==-1) {
            System.out.println("Not found");
        }
        else{
            System.out.println("index key of Menu = " + indexMenu);
        }


    }
}
