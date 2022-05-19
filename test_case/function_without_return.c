int nonblock(){
    return 1;
}
char block(char a, char b, char c){
    if((a/b)==c) {
        a = b + c;
    }
    else {
        a = b - c;
    }
}