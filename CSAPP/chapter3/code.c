//gcc -O1 -S code.c
//gcc -O1 -c code.c


int acccum = 0;
int sum(int x, int y){
	int t = x + y;
	acccum += t;
	return t;
}