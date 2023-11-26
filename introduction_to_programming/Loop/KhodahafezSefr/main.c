#include <stdio.h>

int main()
{
    int num1, num2;
    int removed_zero_num1 = 0;
    int removed_zero_num2 = 0;
    int removed_zero_sum  = 0;

    int check;

    int ten2 = 1;

    int sum_before_remove_zero;
    int sum_after_remove_zero;

    scanf("%d %d", &num1, &num2);

    sum_before_remove_zero = num2 + num1;

    for(int ten1=1; num1/ten1 != 0; ten1*=10)  //remove zero from num1
    {
        check = (num1 / ten1) % 10;
        if(check == 0) {
            continue;
        }
        removed_zero_num1 += check * ten2;
        ten2 *= 10;
    }
    ten2 = 1;

    for(int ten1=1; num2/ten1 != 0; ten1*=10)  //remove zero from num2
    {
        check = (num2 / ten1) % 10;

        if(check == 0) {
            continue;
        }
        removed_zero_num2 += check * ten2;
        ten2 *= 10;
    }
    ten2 = 1;

    for(int ten1=1; sum_before_remove_zero/ten1 != 0; ten1*=10)  //remove zero from sum
    {
        check = (sum_before_remove_zero / ten1) % 10;
        if(check == 0) {
            continue;
        }        
        removed_zero_sum += check * ten2;
        ten2 *= 10;
    }

    sum_after_remove_zero = removed_zero_num1+removed_zero_num2;

    if(sum_after_remove_zero == removed_zero_sum) {
        printf("%d\n", removed_zero_sum);
        printf("YES");
    } else {
        printf("%d\n", removed_zero_sum);
        printf("NO");
    }

    return 0;
}
