#include <stdio.h>

int main()
{
    char check;
    int length;

    scanf("%d", &length);

    for(int i=0; i<=length; i++) //i az i=0 shoroo mishavad chon avalin enter ra ham voroodi migirad
    {
        scanf("%c", &check);

        if(check == ',')
        {
            printf("INVALID");
            break;
        }
        else if(check == ';')
        {
            printf("INVALID");
            break;
        }
        else if(check == '!')
        {
            printf("INVALID");
            break;
        }
        else if(check == '%')
        {
            printf("INVALID");
            break;
        }
        else if(check == '<')
        {
            printf("INVALID");
            break;
        }
        else if(check == '>')
        {
            printf("INVALID");
            break;
        }
        else if(check == '(')
        {
            printf("INVALID");
            break;
        }
        else if(check == ')')
        {
            printf("INVALID");
            break;
        }
        else if(check == '$')
        {
            printf("INVALID");
            break;
        }
        else if(i == length)
        {
            printf("VALID");
        }
    }

    return 0;
}