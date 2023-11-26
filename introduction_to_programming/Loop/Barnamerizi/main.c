#include <stdio.h>

int main() {
	int h1, h2, h3, h4, h5, h6, h7, m1, m2, m3, m4, m5, m6, m7;
	char t1, t2, t3, temp;

	scanf("%d:%d %d:%d %c%c", &h1, &m1, &h2, &m2, &t1, &temp);
	scanf("%d:%d %d:%d %c%c", &h3, &m3, &h4, &m4, &t2, &temp);
	scanf("%d:%d %d:%d %c", &h5, &m5, &h6, &m6, &t3);

	while (1) {
		scanf("%c%d:%d", &temp, &h7, &m7);
		int timestamp = h7 * 60 + m7;
		if (timestamp >= h1 * 60 + m1 && timestamp <= h2 * 60 + m2) {
			switch (t1) {
			case 'C':
				printf("boro c bekhoon!\n");
				break;
			case 'R':
				printf("boro riz bekhoon!\n");
				break;
			case 'S':
				printf("boro system amel bekhoon!\n");
				break;
			}
		} else if (timestamp >= h2 * 60 + m3 && timestamp <= h4 * 60 + m4) {
			switch (t2) {
			case 'C':
				printf("boro c bekhoon!\n");
				break;
			case 'R':
				printf("boro riz bekhoon!\n");
				break;
			case 'S':
				printf("boro system amel bekhoon!\n");
				break;
			}
		} else if (timestamp >= h5 * 60 + m5 && timestamp <= h6 * 60 + m6) {
			switch (t3) {
			case 'C':
				printf("boro c bekhoon!\n");
				break;
			case 'R':
				printf("boro riz bekhoon!\n");
				break;
			case 'S':
				printf("boro system amel bekhoon!\n");
				break;
			}
		} else if (timestamp >= 0 && timestamp <= 6 * 60) {
			printf("boro bekhab!\n");
			break;
		} else {
			printf("khob hame chi khube!\n");
		}
	}
	
	return 0;
}