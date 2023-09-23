#include <stdio.h>

int main() {
    const int MAX_SPEED = 60;
    const int PENALTY1 = 80000;
    const int PENALTY2 = 150000;
    const int ARRIVE_CAMERA2 = 5 * 60 + 40; // 05:40
    const int ARRIVE_CAMERA3 = 12 * 60 + 15; // 12:15
    int min, sec, speed;
    int penaltyAmount = 0;
    char temp;

    // First speed camera
    scanf("%d%c%d%d", &min, &temp, &sec, &speed);
    if (speed > MAX_SPEED) {
        penaltyAmount += PENALTY1;
    }

    // Second speed camera
    scanf("%d%c%d%d", &min, &temp, &sec, &speed);
    int arrivedTimeCamera2 = min * 60 + sec;
    if (speed > MAX_SPEED) {
        penaltyAmount += PENALTY1;
    } else if (arrivedTimeCamera2 < ARRIVE_CAMERA2) {
        penaltyAmount += PENALTY2;
    }

    // Third speed camera
    scanf("%d%c%d%d", &min, &temp, &sec, &speed);
    int arrivedTimeCamera3 = min * 60 + sec;
    if (speed > MAX_SPEED) {
        penaltyAmount += PENALTY1;
    } else if (arrivedTimeCamera3 - arrivedTimeCamera2 < ARRIVE_CAMERA3) {
        penaltyAmount += PENALTY2;
    }

    printf("%d", penaltyAmount);
}
