public class HelloWorld{
    public static void main(String[] args){
    int[][] numbers = {{44, 45, 16, 50},{16, 12, 66, 9},{52, 83, 3, 37},{56, 61, 69, 61}};
    //prints the whole matrix
    for (int i = 0; i <= numbers.length - 1; i++){
        for (int j = 0; j <= numbers[i].length - 1; j++){
            System.out.print(numbers[i][j] + "  ");}
        System.out.println(" ");}
        System.out.println(" ");
    twoDimensions(numbers);
    System.out.println("  ");
    System.out.println("  ");
    //print the even numbers
    int[][] arr = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
for (int i = 0; i < arr.length; i++) {
    for (int j = 0; j < arr[i].length; j++) {
        if (arr[i][j] % 2 == 0) {
            System.out.println(arr[i][j]);
        }
    }
}
System.out.println("  ");
System.out.println("  ");
//prints all the numbers
int[] anArray = new int[4];
anArray[0] = 4;
anArray[1] = 6;
anArray[2] = 7;
anArray[3] = 3;
for(int j = 0; j < anArray.length; j++){
    System.out.print(anArray[j] + " ");
}
System.out.println("  ");
System.out.println("  ");
int[] nums = {5, 3, 6, 8, 11, 2};
    change(nums);
    for (int i = 0; i < nums.length; i++) {
    System.out.print(nums[i] + "  ");}
System.out.println("  ");
//attempt to print hello world!, 2&3 successful
String[][] set = {{"Hello", "world!"},{"world", "Hello "},{"Hello", "!", "Hello"}};
String hello = set[0][1] + set[1][0];
System.out.println(hello);
 hello = set[1][1] + set[0][1];
System.out.println(hello);
 hello = set[1][1] + set[1][0] + set[2][1];
System.out.println(hello);
System.out.println("  ");
System.out.println("  ");
int[] values = {1, 4, -7, -3};
multiply(values, 2);
/*System.out.println("  ");
System.out.println("  ");
ArrayList < Integer >  numbers = new ArrayList < Integer > ();
numbers.add(1);
numbers.add(2);
numbers.add(3);
numbers.remove(2);
numbers.set(1, 0);
numbers.add(5);
numbers.remove(0);
System.out.println(numbers);*/
}


public static void multiply(int[] values, int amount) {
    for (int i = 0; i < values.length; i++) {
        values[i] = values[i] + amount;
        System.out.print(values[i] + "  ");
    }
}
public static void change (int[] arr) {//gets the bigger number to the first position
    int k = arr[0];
    for (int i = 0; i < arr.length; i++) {
        if (k < arr[i]) {
            arr[0] = arr[i];
            arr[i] = k;
            k = arr[0];
        }
    }
}

     public static void twoDimensions(int[][] numbers){//changes the matrix
    for (int i = 0; i < numbers.length - 1; i++){
        for (int j = 0; j < numbers[i].length - 1; j++){
            if (numbers[i][j] < numbers[i][j + 1]){
                numbers[i][j] = numbers[i][j] + numbers[i + 1][j];
                numbers[i + 1][j] = numbers[i + 1][j] / 2;
            }
            System.out.println("  ");
        }
    }
    }
}