public static int maxLength(ArrayList<String> Strings){
    int len = 0;
    for(int i=0 ; i < Strings.size() ; i++){
        if (Strings.get(i).length() > len){ 
            len = Strings.get(i).length();}
    }
    return len;
}