#include <stdio.h>
//code by Alenn Wright 4/23/21
void listprint(int*, int);
int max(int*, int);
int min(int*, int);
float average(int*, int);
float median(int*, int);
int main()
{
    int testarray[] = {1,4,7,3,2,9,12,5};
    int arraySizeOf = sizeof(testarray) / sizeof(testarray[0]);

    // for pointer when declaring the pointer data type
    //it is redundant to put &testarray because it will
    //already grab the pointer address
    int* pointer = testarray;

    listprint(pointer, arraySizeOf);

    int maxans = max(pointer, arraySizeOf);
    printf("Maximum value is %d \n", maxans);

    int minans = min(pointer, arraySizeOf);
    printf("Minimum value is %d \n", minans);

    float averageans = average(pointer, arraySizeOf);
    printf("Average value is %.3f \n", averageans);

    float medianans = median(pointer, arraySizeOf);
    printf("Median value is %.2f \n", medianans);

    return 0;
}

void listprint(int* addr, int size)
{
    int listiterator;
    for (listiterator = 0; listiterator < size; listiterator++){
        printf("%d ", *(addr + listiterator));

    }
    printf("\n");
}

int max(int* addr, int size)
{
    int iteratorcount;
    int runningmax = *(addr);
    for (iteratorcount = 1; iteratorcount < size; iteratorcount++)
    {
        if(runningmax < *(addr+iteratorcount))
        {
           runningmax = *(addr + iteratorcount);
        }
    }
    return runningmax;
}

int min(int* addr, int size)
{
    int iteratorcount;
    int runningmin = *(addr);
    for (iteratorcount = 1; iteratorcount < size; iteratorcount++)
    {
        if(runningmin > *(addr+iteratorcount))
        {
           runningmin = *(addr + iteratorcount);
        }
    }
    return runningmin;
}

float average(int* addr, int size)
{
    int iteratorcount;
    int runningsum = 0;
    for (iteratorcount = 0; iteratorcount < size; iteratorcount++)
    {
        runningsum += *(addr + iteratorcount);
    }
    float returningval = (float)runningsum/size;
    return returningval;
}

void sortbubble(int size, int* addr)
{
    int listiterator, unsortediterator, swapholder;
    for (listiterator = 0; listiterator < size; listiterator++) {

        for (unsortediterator = listiterator + 1; unsortediterator <
        size; unsortediterator++) {

            if (*(addr + unsortediterator) < *(addr + listiterator)) {

                swapholder = *(addr + listiterator);
                *(addr + listiterator) = *(addr + unsortediterator);
                *(addr + unsortediterator) = swapholder;
            }
        }
    }
}

float median(int* addr, int size)
{
    sortbubble(size, addr);
    int medianindex = size/2 + size%2 - 1;
    float returnval = *(addr + medianindex);
    return returnval;
}
