//
//  DogClass.h
//  week1
//
//  Created by Patrick Powers on 6/26/12.
//  Copyright (c) 2012 Full Sail University. All rights reserved.
//

#import <UIKit/UIKit.h>

typedef enum
{
    Boxer_Dog=0,
    Mastiff_Dog,
    Beagle_Dog
} EDogType;

@interface DogClass : NSObject
{
    EDogType dogType;
    int lbs;
    NSString *name;
}

//getter for Lbs
-(int)getLbs;
//getter for name
-(NSString*)getName;
//setter for Lbs
-(void)setLbs :(int)newLbs;
//setter for name
-(void)setName : (NSString*)newName;

//calculation method
-(int)gainWeight;



@end
