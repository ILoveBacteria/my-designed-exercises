#include <stdio.h>

int main() {
    char sentence[255];
    char word[20];
    int senIndex = 0;

    while(1) {
        scanf("%s", word);

        int i = 0;
        int end = 0;
        while(word[i] != '\0') {
            sentence[senIndex] = word[i];
            if (word[i] == '.' || word[i] == '?') {
                end = 1;
            }
            i++;
            senIndex++;
        }
        if(end) {
            sentence[senIndex] = '\0';
            break;
        }
        sentence[senIndex++] = ' ';
    }
    printf("%s", sentence);
    return 0;
}