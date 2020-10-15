

//  Created by Primrose Chareka on 2018-07-16.
/*
 ============================================================================
 Name           : utilityFunctions.h
 Author         : Primrose Chareka
 Date           : 16/07/2018
 Version        : 1.0
 Description    : common functions used to initialize or test practice code
 ============================================================================
 */

#ifndef utilityFunctions_h
#define utilityFunctions_h

//Read from file functions used to initialize character and integer arrays
//using values files provided.
char* ReadCharactersFile(FILE* file, char* array) {
    if (file == NULL) {
        printf("ERROR - FILE NOT FOUND\n");
        return NULL;
    }
    int i = 0;
    
    while (fscanf(file, "%c", &array[i]) == 1) {
        i++;
    }
    array[i] = '\0';
    return array;
}

int* ReadNumbersFile(FILE* file, int* array) {
    if (file == NULL) {
        printf("ERROR - FILE NOT FOUND\n");
        return NULL;
    }
    
    int i = 0;
    
    while (fscanf(file, "%d", &array[i]) == 1) {
        i++;
    }
    array[i] = '\0';
    
    return array;
}

#endif /* utilityFunctions_h */
